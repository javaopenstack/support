package org.java.openstack.tools.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.java.openstack.tools.configuration.Configuration;

public class ConfigurationFactory {
	 
	private final static String DEFAULT_CONFIG = "server-config.xml";

	public static Configuration createConfiguration(){		 
		return createConfiguration(DEFAULT_CONFIG);		
	}
	
	public static Configuration createConfiguration(File file){
		try{
			return createConfiguration(new FileInputStream(file));
		} catch( Throwable e ) {
			throw new IllegalStateException( e );
		}
	}
	
	public static Configuration createConfiguration(String configuration){
		InputStream inputStream = ConfigurationFactory.class.getClassLoader().getResourceAsStream( configuration );
		return createConfiguration(inputStream);
	}
	
	public static Configuration createConfiguration(InputStream file){
		StreamSource source = new StreamSource(file );
		return parseConfiguration( source );
	}	
	
	private static Configuration parseConfiguration( Source source )
	{
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance( Configuration.class );
			SchemaFactory sf = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
			Schema schema = sf.newSchema( new StreamSource( ConfigurationFactory.class.getClassLoader().getResourceAsStream( "config.xsd" ) ) );
			
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			unmarshaller.setSchema( schema );
			return unmarshaller.unmarshal( source, Configuration.class ).getValue();
		} catch( Throwable e ) {
			throw new IllegalStateException( e );
		}
		
	}
	
}
