package com.ric.st.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import ru.gosuslugi.dom.schema.integration.house_management.ApartmentHouseUOType;
import ru.gosuslugi.dom.schema.integration.house_management.ApartmentHouseUpdateUOType;
import ru.gosuslugi.dom.schema.integration.house_management.HouseBasicUpdateUOType;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ApartmentHouseToCreate;
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
	private ImportResult res;
	private SoapPreps sp;
	private ImportHouseUORequest req;

	@PostConstruct
	public void init() throws Exception {
    	// создать сервис и порт
    	service = new HouseManagementService();
    	port = service.getHouseManagementPort();
    	// подготовительный объект
    	sp = new SoapPrep(port, (BindingProvider) port, (WSBindingProvider) port);

    	// подписывать XML?
    	sp.setSignXML(true);
    	// заменить Endpoint, если надо 
    	if (config.isSrvTest()) {
    		sp.changeHost(config.getSrvTestHost());
    	}
    	// создать и подготовить заголовок запроса
    	sp.createRh(new Date(), Utl.getRndUuid(), config.getOrgPPGuid(), true);
	}

	/**
	 * Получить результат запроса
	 * @param req - запрос
	 * @return
	 * @throws Exception
	 */
	private ImportResult getImpResult (ImportHouseUORequest req) throws Exception {
    	// Исправлять классы под соответствующий запрос!
    	return (ImportResult) sp.sendSOAP(   // исправить
    			req, 
    			"importHouseUOData", 		// исправить
    			new ImportResult(),	 		// исправить
    			config.getBscLogin(), config.getBscPass(),
    			config.getFingerPrint());
	}

	/**
	 * Создать запрос импорта
	 */
	private void prepReqImp() {
    	req = new ImportHouseUORequest();
    	req.setVersion(req.getVersion());
    	req.setId("foo");
	}
	
	/**
	 * Создать запрос экспорта
	 */
	private void prepReqExp() {
		
		//TODO
	}

	public void importHouseUpd() throws Exception{
   	
    	ApartmentHouse ah = new ApartmentHouse();
    	ApartmentHouseToUpdate ac = new ApartmentHouseToUpdate();

		// обновить HouseBasicUpdateUOType по HouseManagementPreps
    	HouseBasicUpdateUOType bs = new HouseBasicUpdateUOType();
    	bs.setFIASHouseGuid(getHm().getHouseGuid());
    	bs.setTotalSquare(BigDecimal.valueOf(getHm().getTotalSquare()));
    	bs.setUsedYear(BigDecimal.valueOf(getHm().getUsedYear()).shortValue());
    	bs.setCulturalHeritage(getHm().getCultHerit());
    	bs.setOlsonTZ(config.getTz());
    	bs.setFloorCount(getHm().getFloorCount());
    	bs.setNoRSOGKNEGRPRegistered(getHm().getNoRSOGKNEGRP());
    	
    	NsiRef ns = new NsiRef();
    	ns.setName(getHm().getState()); //TODO! переделать на поиск!
    	ns.setCode("2");
    	ns.setGUID("57c4dbc5-bdd5-4490-92e1-3e687797b32a");
    	bs.setState(ns);
    	
    	ac.setUndergroundFloorCount(getHm().getUnderFloorCount());
    	ac.setMinFloorCount(getHm().getMinFloorCount().byteValue());
    	ac.setTransportGUID(Utl.getRndUuid().toString());
    	
    	ac.setBasicCharacteristicts(bs);
    	ah.setApartmentHouseToUpdate(ac);

    	// объект запроса
    	prepReqImp();
    	req.setApartmentHouse(ah);
    	
    	// создание XML, маршаллинг
    	port.importHouseUOData(req);
    	// отправка SOAP, анмаршаллинг результата
    	ImportResult res = getImpResult(req);
    		
    	System.out.println("res:"+res.getCommonResult());
		
	}

	public HouseManagementPreps getHm() {
		return hm;
	}

	public void setHm(HouseManagementPreps hm) {
		this.hm = hm;
	}
	
}
