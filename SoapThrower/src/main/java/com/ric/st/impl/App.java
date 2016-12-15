package com.ric.st.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.soap.SOAPException;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.gosuslugi.dom.schema.integration.organizations_registry_common_service.Fault;
import ru.gosuslugi.dom.signature.demo.commands.Command;
import ru.gosuslugi.dom.signature.demo.commands.SignCommand;

import com.ric.st.ActionControllers;
import com.ric.st.Configs;
import com.ric.st.PrepImportHouses;
import com.ric.st.PrepImportHouses2;
import com.ric.st.prep.HouseManagementPreps;
import com.ric.st.prep.impl.HouseManagementPrep;

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
		//sc = new SignCommand();

		//включить логгирование XML
		cfg.setXmlLog();
		
		//Throwers thrMng = context.getBean(ThrowerMng.class);
		//thrMng.exportAccountData();
		System.out.println("Start");

		ActionControllers ac = context.getBean(ActionControllers.class);
		ac.searchActions();
		
		//создать бин сервиса SOAP
//		PrepImportHouses2 ph = context.getBean(PrepImportHouses2.class);
//		//PrepImportHouses ph = context.getBean(PrepImportHouses.class);
//		HouseManagementPreps hmp = new HouseManagementPrep();
//		
//		hmp.setHouseGuid("7de1d6c3-c7fd-4da6-95a2-40cb97e8201a");
//		hmp.setFloorCount("3");
//		hmp.setCultHerit(false);
//		hmp.setOktmo("32607441101");
//		hmp.setState("Исправный");
//		hmp.setTotalSquare(3333d);
//		hmp.setUsedYear(1972);
//		hmp.setUnderFloorCount("2");
//		hmp.setNoRSOGKNEGRP(true);
//		hmp.setMinFloorCount(2);
//		
//		ph.setHm(hmp);
//		//ph.importHouseUpd();
//		ph.importHouseResidentialPremisesCreate();
		//ph.importHouseEntranceCreate();
		//вернуло:
		/*
		</soap:Envelope>GUID: c6528122-ad75-4dc6-9820-8820122eb9e5
		Unique nomer: PHc00004 - помещение 1а*/
		
		/*
		thrMng.importHouse(hm);
*/
		
		//FileExchanges fe = new FileExchange();  
		//fe.send();

		//thrMng.importContractData();
		
		
		System.out.println( "Stop" );
		//thrMng.importHouse(ph.getHm());
		//thrMng.exportContracts();
		//thrMng.exportOrgRegistry();
    	
		((AbstractApplicationContext) context).close();
    	
    }
}
