package org.java.openstack.tools.server;

import static io.undertow.servlet.Servlets.defaultContainer;
import static io.undertow.servlet.Servlets.deployment;

import java.io.File;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.log4j.PropertyConfigurator;
import org.java.openstack.tools.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.handlers.PathHandler;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import io.undertow.servlet.api.ServletContainerInitializerInfo;
import io.undertow.servlet.util.ImmediateInstanceFactory;

/**
 * Questa classe è utilizzata soltanto per lanciare il server in locale.
 * Una volta esportato il progetto con il comando mavan
 * mvn clean install -P release
 * 
 * il goal sopra genera un war che non conterra' questa classe e nemmeno le dipendenze ad esso associate ( server
 * undertow ).
 * 
 * @author jonathan
 *
 */
public class LocalServer
{
	private static Logger log = LoggerFactory.getLogger( LocalServer.class );
	 
	 	
	private Configuration configuration = null;
	
	public LocalServer(){
		Configuration configuration = ConfigurationFactory.createConfiguration();
		this.configuration = configuration;
	}
	
	public LocalServer(Configuration configuration){
		this.configuration = configuration;
	}
	
	static {
		System.setProperty( "devmode", "true" );	
	}
	  
	private void configureStartupLogging()
	{
		Properties properties = new Properties();
		properties.setProperty( "log4j.rootLogger", "INFO, stdout" );
		properties.setProperty( "log4j.appender.stdout", "org.apache.log4j.ConsoleAppender" );
		properties.setProperty( "log4j.appender.stdout.Target", "System.out" );
		properties.setProperty( "log4j.appender.stdout.layout", "org.apache.log4j.PatternLayout" );
		properties.setProperty( "log4j.appender.stdout.layout.ConversionPattern", "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n" );
		properties.setProperty( "log4j.logger.jdbc", "ERROR" );
		properties.setProperty( "log4j.logger.jdbc.sqlonly", "INFO" );
		properties.setProperty( "log4j.logger.jdbc.resultset", "ERROR" );
		properties.setProperty( "log4j.logger.jdbc.connection", "ERROR" );
		properties.setProperty( "log4j.logger.jdbc.sqltiming", "ERROR" );
		properties.setProperty( "log4j.logger.jdbc.audit", "ERROR" );
		PropertyConfigurator.configure( properties );
	}
	  
	@SuppressWarnings( "unchecked" )
	public void startServer()
	{
		configureStartupLogging();
		Class<? extends ServletContainerInitializer> clazz = null;
		
		if( !configuration.getWebapp().startsWith( "/" ) ) {
			configuration.setWebapp( "/" + configuration.getWebapp() );
		}
		
		if ( configuration.getDatasources() != null && !configuration.getDatasources().getDatasource().isEmpty()){
			JndiInitializer.init(configuration);
		}
		try {
			clazz = (Class<? extends ServletContainerInitializer>) Class.forName( configuration.getServlet() );
			log.info( "Starting server on port " + configuration.getPort() );
			
			ServletContainerInitializerInfo servletContainerInitializerInfo = createContainerInitializerInfo( clazz );
			
			DeploymentInfo servletBuilder = deployment().setContextPath( configuration.getWebapp() )
					.setDeploymentName( configuration.getWebapp() )
					.setClassLoader( LocalServer.class.getClassLoader() )
					.addServletContainerInitalizer( servletContainerInitializerInfo );
			
			DeploymentManager manager = defaultContainer().addDeployment( servletBuilder );
			
			manager.deploy();
			
			PathHandler path = null;
			
			HttpHandler servletHandler = manager.start();
			path = Handlers.path( Handlers.redirect( configuration.getWebapp() ) ).addPrefixPath( configuration.getWebapp(),
					servletHandler );
			
			Undertow server = Undertow.builder().addHttpListener( configuration.getPort().intValue(), "0.0.0.0" ).setHandler( path )
					.build();
			
			server.start();
			log.info( "STARTED" );
		} catch( Throwable e ) {
			e.printStackTrace();
			System.exit( 0 );
		}
		
	}
	
	public ServletContainerInitializerInfo createContainerInitializerInfo( final Class<?> clazz )
			throws Exception
	{
		final Set<Class<?>> set = new HashSet<Class<?>>();
		set.add( clazz );
		if( ServletContainerInitializer.class.isAssignableFrom( clazz ) ) {
			@SuppressWarnings("unchecked")
			Class<? extends ServletContainerInitializer> clazzI = (Class<? extends ServletContainerInitializer>) clazz;
			
			return new ServletContainerInitializerInfo( clazzI, set );
		} else {
			
			final WebApplicationInitializer webApplicationInitializer = (WebApplicationInitializer) clazz.newInstance();
			ImmediateInstanceFactory<ServletContainerInitializer> factory = new ImmediateInstanceFactory<ServletContainerInitializer>(
					new ServletContainerInitializer() {
						
						@Override
						public void onStartup( Set<Class<?>> arg0, ServletContext servletContext ) throws ServletException
						{
							webApplicationInitializer.onStartup( servletContext );
							
						}
					} );
			
			return new ServletContainerInitializerInfo( ServletContainerInitializer.class, factory, set );
		}
	}
	
	public static void main( String arg[] ) throws Exception
	{
		LocalServer localServer = null;
		if( arg.length == 0 ) {
			localServer = new LocalServer();
		} else {
			Configuration configuration = ConfigurationFactory.createConfiguration(new File(arg[0]));
			localServer = new LocalServer(configuration); 
		}
		
		localServer.startServer();
		
	}
	
}
