package com.ric.st.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.BindingProvider;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.terracotta.modules.ehcache.async.AsyncConfig;

import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;
import ru.gosuslugi.dom.schema.integration.house_management.ApartmentHouseUOType.BasicCharacteristicts;
import ru.gosuslugi.dom.schema.integration.house_management.ExportAccountRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportAccountResult;
import ru.gosuslugi.dom.schema.integration.house_management.ExportAccountResultType;
import ru.gosuslugi.dom.schema.integration.house_management.HouseBasicUpdateUOType;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ApartmentHouseToCreate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ApartmentHouseToUpdate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportResult;
import ru.gosuslugi.dom.schema.integration.house_management_service.HouseManagementPortsType;
import ru.gosuslugi.dom.schema.integration.house_management_service.HouseManagementService;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;

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
    	sp.setSignXML(true);
    	
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
    	bc.setFIASHouseGuid("7de1d6c3-c7fd-4da6-95a2-40cb97e8201a");
    	bc.setTotalSquare(BigDecimal.valueOf(1777d));
    	bc.setUsedYear(BigDecimal.valueOf(1970d).shortValue());
    	bc.setCulturalHeritage(false);

    	bc.setOlsonTZ(config.getTz());
    	bc.setFloorCount("17");
    	bc.setNoRSOGKNEGRPRegistered(true);
    	
    	OKTMORefType oktmo = new OKTMORefType();
    	oktmo.setCode("32607441101");
    	bc.setOKTMO(oktmo);

    	NsiRef ns = new NsiRef();
    	ns.setName("Исправный");
    	ns.setCode("2");
    	ns.setGUID("57c4dbc5-bdd5-4490-92e1-3e687797b32a");
    	bc.setState(ns);
    	
    	ac.setUndergroundFloorCount("7");
    	ac.setMinFloorCount((byte)0);
    	ac.setTransportGUID(Utl.getRndUuid().toString());
    	
    	ac.setBasicCharacteristicts(bc);
    	ah.setApartmentHouseToCreate(ac);
    	
    	req.setVersion("10.0.1.1");
    	req.setApartmentHouse(ah);
    	
    	// создание XML, маршаллинг, подпись его внутри хэндлера
    	port.importHouseUOData(req);

    	// отправка SOAP, анмаршаллинг результата
    	// Исправлять классы под соответствующий запрос!
    	ImportResult res = (ImportResult) sp.sendSOAP(  // исправить
    			HouseManagementPortsType.class,  		// исправить
    			req, 
    			"importHouseUOData", 			 		// исправить
    			new ImportResult(), 			 		// исправить
    			config.getBscLogin(), config.getBscPass());

    	System.out.println("res:"+res.getCommonResult());
    }

    public void importHouseUpd() throws Exception {
    	// создать сервис и порт
    	HouseManagementService service = new HouseManagementService();
    	HouseManagementPortsType port = service.getHouseManagementPort();

    	// подготовительный объект
    	SoapPreps sp = new SoapPrep((BindingProvider) port, (WSBindingProvider) port);

    	// подписывать XML?
    	sp.setSignXML(true);
    	
    	// заменить Endpoint, если надо 
    	if (config.isSrvTest()) {
    		sp.changeHost(config.getSrvTestHost());
    	}

    	// создать и подготовить заголовок запроса
    	sp.createRh(new Date(), Utl.getRndUuid(), config.getOrgPPGuid(), true);
    	
    	ImportHouseUORequest req = new ImportHouseUORequest();
    	req.setId("foo");
    	
    	ApartmentHouse ah = new ApartmentHouse();
    	ApartmentHouseToUpdate ac = new ApartmentHouseToUpdate();
    	
    	HouseBasicUpdateUOType bc = new HouseBasicUpdateUOType();
    	bc.setFIASHouseGuid("810321c3-f0b4-454a-9a1c-cad82adebd58");
    	bc.setTotalSquare(BigDecimal.valueOf(7777d));
    	bc.setUsedYear(BigDecimal.valueOf(1974d).shortValue());
    	bc.setCulturalHeritage(false);

    	bc.setOlsonTZ(config.getTz());
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
    	ah.setApartmentHouseToUpdate(ac);

    	req.setVersion("10.0.1.1");
    	req.setApartmentHouse(ah);
    	
    	// создание XML, маршаллинг
    	port.importHouseUOData(req);
    	// отправка SOAP, анмаршаллинг результата
    	// Исправлять классы под соответствующий запрос!
    	ImportResult res = (ImportResult) sp.sendSOAP(  // исправить
    			HouseManagementPortsType.class,  		// исправить
    			req, 
    			"importHouseUOData", 			 		// исправить
    			new ImportResult(), 			 		// исправить
    			config.getBscLogin(), config.getBscPass());

    	System.out.println("res:"+res.getCommonResult());
    }

    public void exportAccountData() throws Exception {
    	// создать сервис и порт
    	HouseManagementService service = new HouseManagementService();
    	HouseManagementPortsType port = service.getHouseManagementPort();

    	// подготовительный объект
    	SoapPreps sp = new SoapPrep((BindingProvider) port, (WSBindingProvider) port);

    	// подписывать XML?
    	sp.setSignXML(true);
    	
    	// заменить Endpoint, если надо 
    	if (config.isSrvTest()) {
    		sp.changeHost(config.getSrvTestHost());
    	}

    	// создать и подготовить заголовок запроса
    	sp.createRh(new Date(), Utl.getRndUuid(), config.getOrgPPGuid(), true);
    	
    	ExportAccountRequest req = new ExportAccountRequest();
    	req.setId("foo");
    	req.setFIASHouseGuid("810321c3-f0b4-454a-9a1c-cad82adebd58");

    	req.setVersion("10.0.1.1");
    	
    	// создание XML, маршаллинг
    	port.exportAccountData(req);
    	// отправка SOAP, анмаршаллинг результата
    	// Исправлять классы под соответствующий запрос!
    	ExportAccountResult res = (ExportAccountResult) sp.sendSOAP(  // исправить
    			HouseManagementPortsType.class,  		// исправить
    			req, 
    			"exportAccountData", 			 		// исправить
    			new ExportAccountResult(), 			 		// исправить
    			config.getBscLogin(), config.getBscPass());

    	
    	for (ExportAccountResultType e : res.getAccounts()) {
        	System.out.println("lsk: "+e.getAccountNumber()+" "+e.getUnifiedAccountNumber());
        	System.out.println("lsk: "+e.getAccountGUID());
    		
        	
    	}
    	
    	
    }
    
}
