package com.ric.st.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.soap.SOAPException;
import javax.xml.ws.BindingProvider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.terracotta.modules.ehcache.async.AsyncConfig;

import ru.gosuslugi.dom.schema.integration.base.RequestHeader;
import ru.gosuslugi.dom.schema.integration.house_management.ApartmentHouseUOType.BasicCharacteristicts;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ApartmentHouseToCreate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportResult;
import ru.gosuslugi.dom.schema.integration.house_management_service.HouseManagementPortsType;
import ru.gosuslugi.dom.schema.integration.house_management_service.HouseManagementService;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportOrgRegistryRequest;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportOrgRegistryRequest.SearchCriteria;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportOrgRegistryResult;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportOrgRegistryResultType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common_service.Fault;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common_service.RegOrgPortsType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common_service.RegOrgService;

import com.ric.bill.Utl;
import com.ric.st.SoapPreps;
import com.ric.st.Throwers;
import com.sun.xml.ws.developer.WSBindingProvider;

@RunWith(SpringJUnit4ClassRunner.class) //только для JUnit, можно убрать!
@ContextConfiguration(classes = {AsyncConfig.class}) //только для JUnit, можно убрать!
@Service
public class ThrowerMng implements Throwers{

	@Autowired
	private ApplicationContext ctx;
    @PersistenceContext
    private EntityManager em;
	@Autowired
	private Config config;

    public void importHouse() throws Exception {
    	// создать сервис и порт
    	HouseManagementService service = new HouseManagementService();
    	HouseManagementPortsType port = service.getHouseManagementPort();

    	// подготовительный объект
    	SoapPreps sp = new SoapPrep((BindingProvider) port, (WSBindingProvider) port);

    	// подписывать XML?
    	sp.isSignXML(true);
    	
    	// заменить Endpoint, если надо 
    	if (config.isSrvTest()) {
    		sp.changeHost(config.getSrvTestHost());
    	}

    	// создать и подготовить заголовок запроса
    	sp.createRh(new Date(), Utl.getRndUuid(), config.getOrgPPGuid(), true);
    	
    	ImportHouseUORequest req = new ImportHouseUORequest();
    	req.setId("foo");
    	
    	ApartmentHouse ah = new ApartmentHouse();
    	ApartmentHouseToCreate ac = new ApartmentHouseToCreate();
    	
    	BasicCharacteristicts bc = new BasicCharacteristicts();
    	bc.setFIASHouseGuid("810321c3-f0b4-454a-9a1c-cad82adebd58");
    	bc.setTotalSquare(BigDecimal.valueOf(1000d));
    	bc.setUsedYear(BigDecimal.valueOf(1970d).shortValue());
    	bc.setCulturalHeritage(false);

    	NsiRef tz = new NsiRef();
    	tz.setCode("10");
    	tz.setGUID("8538e485-b925-5aa7-923f-3b6755e27d4b");
    	
    	bc.setOlsonTZ(tz);
    	bc.setFloorCount("10");
    	bc.setNoRSOGKNEGRPRegistered(true);

    	NsiRef ns = new NsiRef();
    	ns.setName("Исправный");
    	ns.setCode("2");
    	ns.setGUID("57c4dbc5-bdd5-4490-92e1-3e687797b32a");
    	bc.setState(ns);
    	
    	ac.setUndergroundFloorCount("0");
    	ac.setMinFloorCount((byte)0);
    	ac.setTransportGUID(Utl.getRndUuid().toString());
    	
    	ac.setBasicCharacteristicts(bc);
    	ah.setApartmentHouseToCreate(ac);

    	req.setVersion("10.0.1.1");
    	req.setApartmentHouse(ah);
    	
    	// создание XML, маршаллинг, подпись его внутри хэндлера
    	port.importHouseUOData(req);

    	// отправка SOAP, возврат результата
    	ImportResult res = (ImportResult) sp.sendSOAP(  // исправить для соотв.класса
    			HouseManagementPortsType.class,  		// исправить для соотв.класса
    			req, 
    			"importHouseUOData", 			 		// исправить для соотв.класса
    			new ImportResult(), 			 		// исправить для соотв.класса
    			config.getBscLogin(), config.getBscPass());

    	System.out.println("res:"+res.getCommonResult());
    }
    
}
