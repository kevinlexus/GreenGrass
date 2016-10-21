package com.ric.soapthrower;

import javax.xml.datatype.DatatypeConfigurationException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.gosuslugi.dom.schema.integration.organizations_registry_common_service.Fault;

/**
 * Hello world!
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
		}
        System.out.println( "Ended" );
        
    }
    
    public static void checkSoap() throws Fault, DatatypeConfigurationException {
    	
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ThrowerMng thrMng = context.getBean(ThrowerMng.class);
		thrMng.send();
		System.out.println("Start()");
    	
    	
    }
}
