package com.ric.st.builder;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.BindingProvider;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import ru.gosuslugi.dom.schema.integration.house_management.ApartmentHouseUOType;
import ru.gosuslugi.dom.schema.integration.house_management.HouseBasicUpdateUOType;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ApartmentHouseToCreate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ApartmentHouseToUpdate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.EntranceToUpdate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportResult;
import ru.gosuslugi.dom.schema.integration.house_management_service.Fault;
import ru.gosuslugi.dom.schema.integration.house_management_service.HouseManagementPortsType;
import ru.gosuslugi.dom.schema.integration.house_management_service.HouseManagementService;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;

import com.ric.bill.Utl;
import com.ric.st.HouseManagementBindingBuilders;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.impl.ActionController;
import com.ric.st.impl.Config;
import com.ric.st.impl.SoapBuilder;
import com.ric.st.mm.UlistMng;
import com.ric.st.prep.HouseManagementPreps;
import com.sun.xml.ws.developer.WSBindingProvider;

@Slf4j
@Service
public class HouseManagementBindingBuilder implements HouseManagementBindingBuilders {

	@Autowired
	private ApplicationContext ctx;
    @PersistenceContext
    private EntityManager em;
	@Autowired
	UlistMng ulistMng;
	@Autowired
	private Config config;
	@Autowired
	private ActionController aControl;
	
	// подоготовительный объект
	private HouseManagementPreps hm;
	
	private HouseManagementService service;
	private HouseManagementPortsType port;
	private ImportResult res;
	private ImportHouseUORequest req;
	private ApartmentHouse ah;
	private EntranceToUpdate etu;
	
	private void setUp() throws CantSendSoap {
    	// создать сервис и порт
		service = new HouseManagementService();
    	port = service.getHouseManagementPort();

    	// подоготовительный объект для SOAP
    	SoapBuilder sb = ctx.getBean(SoapBuilder.class);
		sb.setUp((BindingProvider) port, (WSBindingProvider) port, false);
	}

	/**
	 * Общее Обновление Основных характеристик много квартирного дома
	 * @return 
	 * @throws CantSendSoap 
	 * @throws Fault 
	 * @throws Exception
	 */
	public ImportResult createApartmentHouse() throws CantSendSoap, Fault {
		// выполнить инициализацию
		setUp();
		
    	ApartmentHouseToCreate ac = new ApartmentHouseToCreate();
    	ApartmentHouseUOType.BasicCharacteristicts bc = new ApartmentHouseUOType.BasicCharacteristicts();
       	bc.setFIASHouseGuid(hm.getHouseGuid());
    	bc.setTotalSquare(BigDecimal.valueOf(hm.getTotalSquare()));
    	bc.setUsedYear(BigDecimal.valueOf(hm.getUsedYear()).shortValue());
    	bc.setCulturalHeritage(hm.getCultHerit());
    	
    	// установить часовую зону
    	NsiRef tz = new NsiRef();
    	NsiElementType el = ulistMng.getNsiElem(
    			aControl.getrStore().getByGrp("NSI", 
    					BigInteger.valueOf(32)), "Часовая зона", "Asia/Novokuznetsk");
    	tz.setCode(el.getCode());
    	tz.setCode(el.getGUID());
    	bc.setOlsonTZ(tz);

    	bc.setFloorCount(hm.getFloorCount());
    	bc.setNoRSOGKNEGRPRegistered(hm.getNoRSOGKNEGRP());

    	// установить состояние объекта 
    	el = ulistMng.getNsiElem(
    			aControl.getrStore().getByGrp("NSI", 
    					BigInteger.valueOf(24)), "Состояние дома", "Исправный");
    	NsiRef ns = new NsiRef();
    	ns.setName(hm.getState());
    	ns.setCode(el.getCode());
    	ns.setGUID(el.getGUID());
    	bc.setState(ns);
    	
    	ac.setUndergroundFloorCount(hm.getUnderFloorCount());
    	ac.setMinFloorCount(hm.getMinFloorCount().byteValue());
    	ac.setTransportGUID(Utl.getRndUuid().toString());
    	
    	ac.setBasicCharacteristicts(bc);
    	ah.setApartmentHouseToCreate(ac);
    	
    	req.setVersion(req.getVersion());
		if (config.getUseSign()) {
			req.setId("foo");
		}
    	req.setApartmentHouse(ah);
    	res = port.importHouseUOData(req);
    	return res;
	}

	public HouseManagementPreps getHm() {
		return hm;
	}

	public void setHm(HouseManagementPreps hm) {
		this.hm = hm;
	}	
}
