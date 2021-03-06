package com.ric.st.builder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.BindingProvider;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;
import ru.gosuslugi.dom.schema.integration.house_management.ApartmentHouseUOType;
import ru.gosuslugi.dom.schema.integration.house_management.HouseBasicUpdateUOType;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ApartmentHouseToCreate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ApartmentHouseToUpdate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.EntranceToUpdate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportResult;
import ru.gosuslugi.dom.schema.integration.house_management.ImportResult.CommonResult;
import ru.gosuslugi.dom.schema.integration.house_management_service.Fault;
import ru.gosuslugi.dom.schema.integration.house_management_service.HouseManagementPortsType;
import ru.gosuslugi.dom.schema.integration.house_management_service.HouseManagementService;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiListRequest;

import com.ric.bill.Utl;
import com.ric.st.HouseManagementBindingBuilders;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.impl.ActionController;
import com.ric.st.impl.Config;
import com.ric.st.impl.SoapBuilder;
import com.ric.st.mm.UlistMng;
import com.ric.st.prep.HouseManagementPreps;
import com.ric.st.prep.impl.HouseManagementPrep;
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
	
	private void setUp() throws CantSendSoap {
    	// создать сервис и порт
		service = new HouseManagementService();
    	port = service.getHouseManagementPort();

    	// подоготовительный объект для SOAP
    	SoapBuilder sb = ctx.getBean(SoapBuilder.class);
		sb.setUp((BindingProvider) port, (WSBindingProvider) port, false);
		
		
	}

	/**
	 * Первичное размещение основных характеристик много квартирного дома
	 * @return 
	 * @throws CantSendSoap 
	 * @throws Fault 
	 */
	public ImportResult createApartmentHouse() throws CantSendSoap, Fault {
		// выполнить инициализацию
		setUp();
		
		ImportHouseUORequest req = new ImportHouseUORequest();
		if (config.getUseSign()) {
			req.setId("foo");
		}
		req.setVersion(req.getVersion());

    	ApartmentHouseToCreate ac = new ApartmentHouseToCreate();
    	ApartmentHouseUOType.BasicCharacteristicts bc = new ApartmentHouseUOType.BasicCharacteristicts();
       	bc.setFIASHouseGuid(hm.getHouseGuid());
    	bc.setTotalSquare(BigDecimal.valueOf(hm.getTotalSquare()));
    	bc.setUsedYear(BigDecimal.valueOf(hm.getUsedYear()).shortValue());
    	bc.setCulturalHeritage(hm.getCultHerit());
    	
    	// установить часовую зону
    	bc.setOlsonTZ(config.getTz());

    	bc.setFloorCount(hm.getFloorCount());
    	bc.setNoRSOGKNEGRPRegistered(hm.getNoRSOGKNEGRP());

    	// установить ОКТМО
    	OKTMORefType oktmo = new OKTMORefType();  
    	oktmo.setCode(hm.getOktmo());
    	oktmo.setName(hm.getOktmo());
    	bc.setOKTMO(oktmo);
    	
    	// установить состояние объекта 
    	NsiElementType el = ulistMng.getNsiElem(
    			config.getrStore().getByGrpId("NSI", 
    					BigInteger.valueOf(24)), "Состояние дома", hm.getState());
    	NsiRef ns = new NsiRef();
    	ns.setName(hm.getState());
    	ns.setCode(el.getCode());
    	ns.setGUID(el.getGUID());

    	
    	bc.setState(ns);
    	
    	ac.setUndergroundFloorCount(hm.getUnderFloorCount());
    	ac.setMinFloorCount(hm.getMinFloorCount().byteValue());
    	ac.setTransportGUID(Utl.getRndUuid().toString());
    	
    	ac.setBasicCharacteristicts(bc);
    	
    	ApartmentHouse ah = new ApartmentHouse();
    	ah.setApartmentHouseToCreate(ac);
    	
    	req.setVersion(req.getVersion());
		if (config.getUseSign()) {
			req.setId("foo");
		}
    	req.setApartmentHouse(ah);
    	res = port.importHouseUOData(req);
    	return res;
	}

	/**
	 * Обновление основных характеристик много квартирного дома
	 * @return 
	 * @throws CantSendSoap 
	 * @throws Fault 
	 */
	public ImportResult updateApartmentHouse() throws CantSendSoap, Fault {
		// выполнить инициализацию
		setUp();
		
		ImportHouseUORequest req = new ImportHouseUORequest();
		if (config.getUseSign()) {
			req.setId("foo");
		}
		req.setVersion(req.getVersion());

    	ApartmentHouseToUpdate ac = new ApartmentHouseToUpdate();
    	HouseBasicUpdateUOType bc = new HouseBasicUpdateUOType();
       	bc.setFIASHouseGuid(hm.getHouseGuid());
    	bc.setTotalSquare(BigDecimal.valueOf(hm.getTotalSquare()));
    	bc.setUsedYear(BigDecimal.valueOf(hm.getUsedYear()).shortValue());
    	bc.setCulturalHeritage(hm.getCultHerit());
    	
    	// установить часовую зону
    	bc.setOlsonTZ(config.getTz());

    	bc.setFloorCount(hm.getFloorCount());
    	bc.setNoRSOGKNEGRPRegistered(hm.getNoRSOGKNEGRP());

    	// установить ОКТМО
    	OKTMORefType oktmo = new OKTMORefType();  
    	oktmo.setCode(hm.getOktmo());
    	oktmo.setName(hm.getOktmo());
    	bc.setOKTMO(oktmo);
    	
    	// установить состояние объекта 
    	NsiElementType el = ulistMng.getNsiElem(
    			config.getrStore().getByGrpId("NSI", 
    					BigInteger.valueOf(24)), "Состояние дома", hm.getState());
    	NsiRef ns = new NsiRef();
    	ns.setName(hm.getState());
    	ns.setCode(el.getCode());
    	ns.setGUID(el.getGUID());

    	
    	bc.setState(ns);
    	
    	ac.setUndergroundFloorCount(hm.getUnderFloorCount());
    	ac.setMinFloorCount(hm.getMinFloorCount().byteValue());
    	ac.setTransportGUID(Utl.getRndUuid().toString());
    	
    	ac.setBasicCharacteristicts(bc);
    	
    	ApartmentHouse ah = new ApartmentHouse();
    	ah.setApartmentHouseToUpdate(ac);
    	
    	req.setVersion(req.getVersion());
		if (config.getUseSign()) {
			req.setId("foo");
		}
    	req.setApartmentHouse(ah);
    	res = port.importHouseUOData(req);
    	return res;
	}

	public void addHouse() {
		ImportResult res = null;
		try {
			log.info("Попытка добавления дома!");
			res = createApartmentHouse();
		} catch (CantSendSoap | Fault e) {
			e.printStackTrace();
			log.info("Ошибка добавления дома, выход!");
			return;
		}
		if (res.getCommonResult().get(0).getError() != null && res.getCommonResult().get(0).getError().size() > 0) {
			String errCode = res.getCommonResult().get(0).getError().get(0).getErrorCode();
			log.info("Ошибка создания дома:{}", errCode);
			if (errCode.equals("SRV004016")) {
				// ошибка - Данный адрес зарегистрирован в реестре объектов жилищного фонда
				// выполнить update
				updHouse();
			} else {
				log.info("Результат обновления дома: GUID={}, UniqNumber={}", res.getCommonResult().get(0).getGUID(),
						res.getCommonResult().get(0).getUniqueNumber()
						);
			}
			
		}
	}

	public void updHouse() {
		ImportResult res = null;
		try {
			log.info("Попытка обновления дома!");
			res = updateApartmentHouse();
		} catch (CantSendSoap | Fault e) {
			e.printStackTrace();
			log.info("Ошибка обновления дома, выход!");
			return;
		}
		if (res.getCommonResult().get(0).getError() != null && res.getCommonResult().get(0).getError().size() > 0) {
			log.info("Ошибка обновления дома:{}", res.getCommonResult().get(0).getError().get(0).getErrorCode());
		} else {
			log.info("Результат обновления дома: GUID={}, UniqNumber={}", res.getCommonResult().get(0).getGUID(),
					res.getCommonResult().get(0).getUniqueNumber()
					);
		}
	}
	
	public HouseManagementPreps getHm() {
		return hm;
	}

	public void setHm(HouseManagementPreps hm) {
		this.hm = hm;
	}	
}
