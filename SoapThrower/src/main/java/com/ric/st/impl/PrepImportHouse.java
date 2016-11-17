package com.ric.st.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import ru.gosuslugi.dom.schema.integration.house_management.HouseBasicUpdateUOType;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportResult;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ApartmentHouseToUpdate;
import ru.gosuslugi.dom.schema.integration.house_management_service.HouseManagementPortsType;
import ru.gosuslugi.dom.schema.integration.house_management_service.HouseManagementService;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;

import com.ric.bill.Utl;
import com.ric.st.PrepImportHouses;
import com.ric.st.SoapPreps;
import com.ric.st.prep.HouseManagementPreps;
import com.ric.st.prep.impl.HouseManagementPrep;
import com.sun.xml.ws.developer.WSBindingProvider;

@Service
public class PrepImportHouse implements PrepImportHouses {

	@Autowired
	private ApplicationContext ctx;
    @PersistenceContext
    private EntityManager em;
	@Autowired
	private Config config;

	private HouseManagementPreps hm;
	private HouseManagementService service;
	private HouseManagementPortsType port;
	private HouseBasicUpdateUOType bc;
	private ImportHouseUORequest req;
	private ImportResult res;
	private SoapPreps sp;

	public PrepImportHouse() {
    	// создать сервис и порт
    	service = new HouseManagementService();
    	port = service.getHouseManagementPort();
    	// подготовительный объект
    	sp = new SoapPrep(port, (BindingProvider) port, (WSBindingProvider) port);
    	// объект ответа
    	req = new ImportHouseUORequest();
    	req.setVersion(req.getVersion());
    	bc = new HouseBasicUpdateUOType();
	}

	public HouseManagementPreps getHm() {
		return hm;
	}

	public void setHm(HouseManagementPreps hm) {
		this.hm = hm;
		// обновить BasicCharacteristics по HouseManagementPreps
    	bc.setFIASHouseGuid(hm.getHouseGuid());
    	bc.setTotalSquare(BigDecimal.valueOf(hm.getTotalSquare()));
    	bc.setUsedYear(BigDecimal.valueOf(hm.getUsedYear()).shortValue());
    	bc.setCulturalHeritage(hm.getCultHerit());
    	bc.setOlsonTZ(config.getTz());
    	bc.setFloorCount(hm.getFloorCount());
    	bc.setNoRSOGKNEGRPRegistered(hm.getNoRSOGKNEGRP());
	}

	public void importHouseUpd() throws Exception {
    	// подписывать XML?
    	sp.setSignXML(true);
    	
    	// заменить Endpoint, если надо 
    	if (config.isSrvTest()) {
    		sp.changeHost(config.getSrvTestHost());
    	}

    	// создать и подготовить заголовок запроса
    	sp.createRh(new Date(), Utl.getRndUuid(), config.getOrgPPGuid(), true);
    	
    	req.setId("foo");
    	
    	ApartmentHouse ah = new ApartmentHouse();
    	ApartmentHouseToUpdate ac = new ApartmentHouseToUpdate();

    	NsiRef ns = new NsiRef();
    	ns.setName(hm.getState()); //TODO! переделать на поиск!
    	ns.setCode("2");
    	ns.setGUID("57c4dbc5-bdd5-4490-92e1-3e687797b32a");
    	bc.setState(ns);
    	
    	//ac.setUndergroundFloorCount("0");
    	//ac.setMinFloorCount((byte)0);
    	ac.setUndergroundFloorCount(hm.getUnderFloorCount());
    	ac.setMinFloorCount(hm.getMinFloorCount().byteValue());
    	ac.setTransportGUID(Utl.getRndUuid().toString());
    	
    	ac.setBasicCharacteristicts(bc);
    	ah.setApartmentHouseToUpdate(ac);

    	req.setApartmentHouse(ah);
    	
    	// создание XML, маршаллинг
    	port.importHouseUOData(req);
    	// отправка SOAP, анмаршаллинг результата
    	// Исправлять классы под соответствующий запрос!
    	res = (ImportResult) sp.sendSOAP(  // исправить
    			req, 
    			"importHouseUOData", 			 		// исправить
    			new ImportResult(), 			 		// исправить
    			config.getBscLogin(), config.getBscPass());

    	System.out.println("res:"+res.getCommonResult());
		
	}
	
}
