package com.ric.st.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.soap.SOAPException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ric.st.Configs;
import com.ric.st.FileExchanges;
import com.ric.st.Throwers;
import com.ric.st.Throwers2;
import com.ric.st.prep.HouseManagementPreps;
import com.ric.st.prep.impl.HouseManagementPrep;

import ru.gosuslugi.dom.schema.integration.organizations_registry_common_service.Fault;
import ru.gosuslugi.dom.signature.demo.commands.Command;
import ru.gosuslugi.dom.signature.demo.commands.SignCommand;

/**
 * Точка входа в приложение
 *
 */
public class App 
{
	
	static Command sc;
	
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
        
    }
    
    public static void checkSoap() throws Exception {
    	
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Configs cfg = context.getBean(Config.class);
		
		//Создать объект подписывания XML
		sc = new SignCommand();

		//включить логгирование XML
		cfg.setXmlLog();
		
		//создать бин отправщика SOAP
		Throwers thrMng = context.getBean(ThrowerMng.class);
		//Throwers2 thrMng2 = context.getBean(ThrowerMng2.class);
		//thrMng.exportAccountData();
		System.out.println("Start");
		
		HouseManagementPreps hm = new HouseManagementPrep();
		hm.setHouseGuid("810321c3-f0b4-454a-9a1c-cad82adebd58");
		hm.setFloorCount("33");
		hm.setCultHerit(false);
		hm.setOktmo("32607441101");
		hm.setState("Исправный");
		hm.setTotalSquare(5555d);
		hm.setUsedYear(1972);
		hm.setUnderFloorCount("3");
		hm.setNoRSOGKNEGRP(true);
		hm.setMinFloorCount(3);

//		thrMng.importHouse(hm);
		thrMng.importHouseUpd(hm);
		
		//FileExchanges fe = new FileExchange();  
		//fe.send();

		//thrMng.importContractData();
		//thrMng2.importHouseResidentialPremises(1, hm);
		
		System.out.println( "Stop" );
		//thrMng.importHouseUpd();
		//thrMng.exportContracts();
		//thrMng.exportOrgRegistry();
    	
		((AbstractApplicationContext) context).close();
    	
    }
}
