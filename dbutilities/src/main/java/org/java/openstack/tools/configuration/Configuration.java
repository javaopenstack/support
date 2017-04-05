//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.11
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine.
// Generato il: 2017.02.16 alle 12:28:37 PM CET
//

package org.java.openstack.tools.configuration;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Classe Java per anonymous complex type.
 * 
 * <p>
 * Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="webapp" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="port" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="properties" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="property"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="datasources" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="datasource" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="jndi" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="classname" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="validationQuery" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="log" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "", propOrder = {
		"webapp",
		"servlet",
		"port",
		"properties",
		"datasources"
} )
@XmlRootElement( name = "configuration" )
public class Configuration
{
	
	@XmlElement( required = true )
	protected String webapp;
	
	@XmlElement( required = true )
	protected String servlet;
	
	@XmlElement( required = true )
	protected BigInteger port;
	protected Configuration.Properties properties;
	protected Configuration.Datasources datasources;
	
	public String getServlet()
	{
		return servlet;
	}
	
	public void setServlet( String servlet )
	{
		this.servlet = servlet;
	}
	
	/**
	 * Recupera il valore della proprietà webapp.
	 * 
	 * @return
	 * 		possible object is
	 *         {@link String }
	 * 
	 */
	public String getWebapp()
	{
		return webapp;
	}
	
	/**
	 * Imposta il valore della proprietà webapp.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link String }
	 * 
	 */
	public void setWebapp( String value )
	{
		this.webapp = value;
	}
	
	/**
	 * Recupera il valore della proprietà port.
	 * 
	 * @return
	 * 		possible object is
	 *         {@link BigInteger }
	 * 
	 */
	public BigInteger getPort()
	{
		return port;
	}
	
	/**
	 * Imposta il valore della proprietà port.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link BigInteger }
	 * 
	 */
	public void setPort( BigInteger value )
	{
		this.port = value;
	}
	
	/**
	 * Recupera il valore della proprietà properties.
	 * 
	 * @return
	 * 		possible object is
	 *         {@link Configuration.Properties }
	 * 
	 */
	public Configuration.Properties getProperties()
	{
		return properties;
	}
	
	/**
	 * Imposta il valore della proprietà properties.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link Configuration.Properties }
	 * 
	 */
	public void setProperties( Configuration.Properties value )
	{
		this.properties = value;
	}
	
	/**
	 * Recupera il valore della proprietà datasources.
	 * 
	 * @return
	 * 		possible object is
	 *         {@link Configuration.Datasources }
	 * 
	 */
	public Configuration.Datasources getDatasources()
	{
		return datasources;
	}
	
	/**
	 * Imposta il valore della proprietà datasources.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link Configuration.Datasources }
	 * 
	 */
	public void setDatasources( Configuration.Datasources value )
	{
		this.datasources = value;
	}
	
	/**
	 * <p>
	 * Classe Java per anonymous complex type.
	 * 
	 * <p>
	 * Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
	 * 
	 * <pre>
	 * &lt;complexType&gt;
	 *   &lt;complexContent&gt;
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
	 *       &lt;sequence&gt;
	 *         &lt;element name="datasource" maxOccurs="unbounded"&gt;
	 *           &lt;complexType&gt;
	 *             &lt;complexContent&gt;
	 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
	 *                 &lt;sequence&gt;
	 *                   &lt;element name="jndi" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
	 *                   &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
	 *                   &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
	 *                   &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
	 *                   &lt;element name="classname" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
	 *                   &lt;element name="validationQuery" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
	 *                   &lt;element name="log" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
	 *                 &lt;/sequence&gt;
	 *               &lt;/restriction&gt;
	 *             &lt;/complexContent&gt;
	 *           &lt;/complexType&gt;
	 *         &lt;/element&gt;
	 *       &lt;/sequence&gt;
	 *     &lt;/restriction&gt;
	 *   &lt;/complexContent&gt;
	 * &lt;/complexType&gt;
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType( XmlAccessType.FIELD )
	@XmlType( name = "", propOrder = {
			"datasource"
	} )
	public static class Datasources
	{
		
		@XmlElement( required = true )
		protected List<Configuration.Datasources.Datasource> datasource;
		
		/**
		 * Gets the value of the datasource property.
		 * 
		 * <p>
		 * This accessor method returns a reference to the live list,
		 * not a snapshot. Therefore any modification you make to the
		 * returned list will be present inside the JAXB object.
		 * This is why there is not a <CODE>set</CODE> method for the datasource property.
		 * 
		 * <p>
		 * For example, to add a new item, do as follows:
		 * 
		 * <pre>
		 * getDatasource().add( newItem );
		 * </pre>
		 * 
		 * 
		 * <p>
		 * Objects of the following type(s) are allowed in the list
		 * {@link Configuration.Datasources.Datasource }
		 * 
		 * 
		 */
		public List<Configuration.Datasources.Datasource> getDatasource()
		{
			if( datasource == null ) {
				datasource = new ArrayList<Configuration.Datasources.Datasource>();
			}
			return this.datasource;
		}
		
		/**
		 * <p>
		 * Classe Java per anonymous complex type.
		 * 
		 * <p>
		 * Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
		 * 
		 * <pre>
		 * &lt;complexType&gt;
		 *   &lt;complexContent&gt;
		 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
		 *       &lt;sequence&gt;
		 *         &lt;element name="jndi" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
		 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
		 *         &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
		 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
		 *         &lt;element name="classname" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
		 *         &lt;element name="validationQuery" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
		 *         &lt;element name="log" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
		 *       &lt;/sequence&gt;
		 *     &lt;/restriction&gt;
		 *   &lt;/complexContent&gt;
		 * &lt;/complexType&gt;
		 * </pre>
		 * 
		 * 
		 */
		@XmlAccessorType( XmlAccessType.FIELD )
		@XmlType( name = "", propOrder = {
				"jndi",
				"url",
				"user",
				"password",
				"classname",
				"validationQuery",
				"log"
		} )
		public static class Datasource
		{
			
			@XmlElement( required = true )
			protected String jndi;
			@XmlElement( required = true )
			protected String url;
			@XmlElement( required = true )
			protected String user;
			@XmlElement( required = true )
			protected String password;
			@XmlElement( required = true )
			protected String classname;
			protected String validationQuery;
			protected String log;
			
			/**
			 * Recupera il valore della proprietà jndi.
			 * 
			 * @return
			 * 		possible object is
			 *         {@link String }
			 * 
			 */
			public String getJndi()
			{
				return jndi;
			}
			
			/**
			 * Imposta il valore della proprietà jndi.
			 * 
			 * @param value
			 *            allowed object is
			 *            {@link String }
			 * 
			 */
			public void setJndi( String value )
			{
				this.jndi = value;
			}
			
			/**
			 * Recupera il valore della proprietà url.
			 * 
			 * @return
			 * 		possible object is
			 *         {@link String }
			 * 
			 */
			public String getUrl()
			{
				return url;
			}
			
			/**
			 * Imposta il valore della proprietà url.
			 * 
			 * @param value
			 *            allowed object is
			 *            {@link String }
			 * 
			 */
			public void setUrl( String value )
			{
				this.url = value;
			}
			
			/**
			 * Recupera il valore della proprietà user.
			 * 
			 * @return
			 * 		possible object is
			 *         {@link String }
			 * 
			 */
			public String getUser()
			{
				return user;
			}
			
			/**
			 * Imposta il valore della proprietà user.
			 * 
			 * @param value
			 *            allowed object is
			 *            {@link String }
			 * 
			 */
			public void setUser( String value )
			{
				this.user = value;
			}
			
			/**
			 * Recupera il valore della proprietà password.
			 * 
			 * @return
			 * 		possible object is
			 *         {@link String }
			 * 
			 */
			public String getPassword()
			{
				return password;
			}
			
			/**
			 * Imposta il valore della proprietà password.
			 * 
			 * @param value
			 *            allowed object is
			 *            {@link String }
			 * 
			 */
			public void setPassword( String value )
			{
				this.password = value;
			}
			
			/**
			 * Recupera il valore della proprietà classname.
			 * 
			 * @return
			 * 		possible object is
			 *         {@link String }
			 * 
			 */
			public String getClassname()
			{
				return classname;
			}
			
			/**
			 * Imposta il valore della proprietà classname.
			 * 
			 * @param value
			 *            allowed object is
			 *            {@link String }
			 * 
			 */
			public void setClassname( String value )
			{
				this.classname = value;
			}
			
			/**
			 * Recupera il valore della proprietà validationQuery.
			 * 
			 * @return
			 * 		possible object is
			 *         {@link String }
			 * 
			 */
			public String getValidationQuery()
			{
				return validationQuery;
			}
			
			/**
			 * Imposta il valore della proprietà validationQuery.
			 * 
			 * @param value
			 *            allowed object is
			 *            {@link String }
			 * 
			 */
			public void setValidationQuery( String value )
			{
				this.validationQuery = value;
			}
			
			/**
			 * Recupera il valore della proprietà log.
			 * 
			 * @return
			 * 		possible object is
			 *         {@link String }
			 * 
			 */
			public String getLog()
			{
				return log;
			}
			
			/**
			 * Imposta il valore della proprietà log.
			 * 
			 * @param value
			 *            allowed object is
			 *            {@link String }
			 * 
			 */
			public void setLog( String value )
			{
				this.log = value;
			}
			
		}
		
	}
	
	/**
	 * <p>
	 * Classe Java per anonymous complex type.
	 * 
	 * <p>
	 * Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
	 * 
	 * <pre>
	 * &lt;complexType&gt;
	 *   &lt;complexContent&gt;
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
	 *       &lt;sequence&gt;
	 *         &lt;element name="property"&gt;
	 *           &lt;complexType&gt;
	 *             &lt;complexContent&gt;
	 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
	 *                 &lt;sequence&gt;
	 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
	 *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
	 *                 &lt;/sequence&gt;
	 *               &lt;/restriction&gt;
	 *             &lt;/complexContent&gt;
	 *           &lt;/complexType&gt;
	 *         &lt;/element&gt;
	 *       &lt;/sequence&gt;
	 *     &lt;/restriction&gt;
	 *   &lt;/complexContent&gt;
	 * &lt;/complexType&gt;
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType( XmlAccessType.FIELD )
	@XmlType( name = "", propOrder = {
			"property"
	} )
	public static class Properties
	{
		
		@XmlElement( required = true )
		protected Configuration.Properties.Property property;
		
		/**
		 * Recupera il valore della proprietà property.
		 * 
		 * @return
		 * 		possible object is
		 *         {@link Configuration.Properties.Property }
		 * 
		 */
		public Configuration.Properties.Property getProperty()
		{
			return property;
		}
		
		/**
		 * Imposta il valore della proprietà property.
		 * 
		 * @param value
		 *            allowed object is
		 *            {@link Configuration.Properties.Property }
		 * 
		 */
		public void setProperty( Configuration.Properties.Property value )
		{
			this.property = value;
		}
		
		/**
		 * <p>
		 * Classe Java per anonymous complex type.
		 * 
		 * <p>
		 * Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
		 * 
		 * <pre>
		 * &lt;complexType&gt;
		 *   &lt;complexContent&gt;
		 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
		 *       &lt;sequence&gt;
		 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
		 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
		 *       &lt;/sequence&gt;
		 *     &lt;/restriction&gt;
		 *   &lt;/complexContent&gt;
		 * &lt;/complexType&gt;
		 * </pre>
		 * 
		 * 
		 */
		@XmlAccessorType( XmlAccessType.FIELD )
		@XmlType( name = "", propOrder = {
				"name",
				"value"
		} )
		public static class Property
		{
			
			@XmlElement( required = true )
			protected String name;
			@XmlElement( required = true )
			protected String value;
			
			/**
			 * Recupera il valore della proprietà name.
			 * 
			 * @return
			 * 		possible object is
			 *         {@link String }
			 * 
			 */
			public String getName()
			{
				return name;
			}
			
			/**
			 * Imposta il valore della proprietà name.
			 * 
			 * @param value
			 *            allowed object is
			 *            {@link String }
			 * 
			 */
			public void setName( String value )
			{
				this.name = value;
			}
			
			/**
			 * Recupera il valore della proprietà value.
			 * 
			 * @return
			 * 		possible object is
			 *         {@link String }
			 * 
			 */
			public String getValue()
			{
				return value;
			}
			
			/**
			 * Imposta il valore della proprietà value.
			 * 
			 * @param value
			 *            allowed object is
			 *            {@link String }
			 * 
			 */
			public void setValue( String value )
			{
				this.value = value;
			}
			
		}
		
	}
	
}
