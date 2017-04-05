package org.java.openstack.tools.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Hashtable;
import java.util.List;
import java.util.TreeSet;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.lang3.StringUtils;
import org.java.openstack.tools.configuration.Configuration;
import org.java.openstack.tools.configuration.Configuration.Datasources.Datasource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;

public class JndiInitializer {

	private static Logger log = LoggerFactory.getLogger(JndiInitializer.class);
	
	public static void init(Configuration configuration){
		
		try {
			
			System.setProperty( "log4jdbc.spylogdelegator.name", "net.sf.log4jdbc.log.slf4j.Slf4jSpyLogDelegator" );
			System.setProperty( "log4jdbc.auto.load.popular.drivers", "false" );
			
			Hashtable<String, String> env = new Hashtable<>();
			env.put( Context.INITIAL_CONTEXT_FACTORY, "org.osjava.sj.memory.MemoryContextFactory" );
			env.put( "org.osjava.sj.jndi.shared", "true" );
			
			System.setProperty( Context.INITIAL_CONTEXT_FACTORY, "org.osjava.sj.memory.MemoryContextFactory" );
			System.setProperty( "org.osjava.sj.jndi.shared", "true" );
			
			Context context = new InitialContext( env );
			Configuration.Datasources datasources = configuration.getDatasources();
			if( datasources != null ) {
				
				List<Datasource> dataSourceConfigs = datasources.getDatasource();
				TreeSet<String> jndiTree = new TreeSet<>();
				for( Datasource dataSourceConfig : dataSourceConfigs ) {
					String prefix = StringUtils.left( dataSourceConfig.getJndi(),
							StringUtils.lastIndexOf( dataSourceConfig.getJndi(), "/" ) );
					splitJndi( jndiTree, prefix );
				}
				
				context.createSubcontext( "java:" );
				context.createSubcontext( "java:comp" );
				context.createSubcontext( "java:comp/env" );
				context.createSubcontext( "java:comp/env/jdbc" );
				
				for( Datasource config : dataSourceConfigs ) {
					
					Class.forName( config.getClassname() );
					try( Connection connection = DriverManager.getConnection( config.getUrl(), config.getUser(), config.getPassword() ); ) {
						connection.createStatement();
						log.info( "Connection validated" );
						connection.close();
					}
					BasicDataSource datasource = new BasicDataSource();
					datasource.setUrl( config.getUrl() );
					datasource.setDriverClassName( config.getClassname() );
					datasource.setUsername( config.getUser() );
					datasource.setPassword( config.getPassword() );
					datasource.setInitialSize( 1 );
					
					if( StringUtils.isNotBlank( config.getValidationQuery() ) ) {
						datasource.setValidationQuery( config.getValidationQuery() );
					}
					
					context.rebind( config.getJndi(), new DataSourceSpy( datasource ) );
					
				}
				
			}
			
		} catch( Throwable e ) {
			throw new IllegalStateException( e );
		}
	}
	
	private static void splitJndi( TreeSet<String> items, String data )
	{
		
		StringBuilder sb = new StringBuilder();
		// String data = "java:comp/env/jdbc";
		String jndiNames[] = data.split( "/" );
		for( int n = 0; n < jndiNames.length; n++ ) {
			String name = jndiNames[n];
			if( name.indexOf( ":" ) > -1 ) {
				String subCtx[] = name.split( ":" );
				for( int c = 0; c < subCtx.length; c++ ) {
					sb.append( subCtx[c] + ( c < subCtx.length - 1 ? ":" : "" ) );
					items.add( sb.toString() );
				}
			} else {
				sb.append( "/" );
				sb.append( jndiNames[n] );
				items.add( sb.toString() );
			}
			
		}
	}
	
	
}
