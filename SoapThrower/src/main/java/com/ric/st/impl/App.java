package com.ric.st.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.soap.SOAPException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ric.st.Configs;
import com.ric.st.Throwers;

import ru.gosuslugi.dom.schema.integration.organizations_registry_common_service.Fault;

/**
 * Точка входа в приложение
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Started" );
        
		try {
			checkSoap();
		} catch (Fault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ru.gosuslugi.dom.schema.integration.house_management_service.Fault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println( "Ended" );
        
    }
    
    public static void checkSoap() throws Exception {
    	
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Configs cfg = context.getBean(Config.class);
		//включить логгирование XML
		cfg.setXmlLog();
		
		//создать бин отправщика SOAP
		Throwers thrMng = context.getBean(ThrowerMng.class);
		//thrMng.exportAccountData();
		thrMng.importHouseUpd();
		//thrMng.exportContracts();
		//thrMng.exportOrgRegistry();
		System.out.println("Start()");
    	
    	
    }
}
