package com.ric.st.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.BindingProvider;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.GOST3411Digest;
import org.bouncycastle.util.Memoable;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.terracotta.modules.ehcache.async.AsyncConfig;

import ru.gosuslugi.dom.schema.integration.base.Attachment;
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;
import ru.gosuslugi.dom.schema.integration.house_management.ApartmentHouseUOType.BasicCharacteristicts;
import ru.gosuslugi.dom.schema.integration.house_management.BaseServiceType;
import ru.gosuslugi.dom.schema.integration.house_management.DateDetailsType;
import ru.gosuslugi.dom.schema.integration.house_management.DateDetailsType.PaymentDocumentInterval;
import ru.gosuslugi.dom.schema.integration.house_management.DateDetailsType.PaymentInterval;
import ru.gosuslugi.dom.schema.integration.house_management.DateDetailsType.PeriodMetering;
import ru.gosuslugi.dom.schema.integration.house_management.DeviceMeteringsDaySelectionType;
import ru.gosuslugi.dom.schema.integration.house_management.ExportAccountRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportAccountResult;
import ru.gosuslugi.dom.schema.integration.house_management.ExportAccountResultType;
import ru.gosuslugi.dom.schema.integration.house_management.HouseBasicUpdateUOType;
import ru.gosuslugi.dom.schema.integration.house_management.ImportContractRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportContractRequest.Contract;
import ru.gosuslugi.dom.schema.integration.house_management.ImportContractRequest.Contract.PlacingContract;
import ru.gosuslugi.dom.schema.integration.house_management.ImportContractRequest.Contract.PlacingContract.ContractObject;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ApartmentHouseToCreate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ApartmentHouseToUpdate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportResult;
import ru.gosuslugi.dom.schema.integration.house_management_service.HouseManagementPortsType;
import ru.gosuslugi.dom.schema.integration.house_management_service.HouseManagementService;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;

import com.ric.bill.Utl;
import com.ric.st.FileExchanges;
import com.ric.st.SoapPreps;
import com.ric.st.Throwers;
import com.ric.st.prep.HouseManagementPreps;
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

	/**
	 * Импорт договора управления
	 * @throws Exception
	 */
	public void importContractData() throws Exception {
		//Отправить файл, получить GUID его
		FileExchanges fe = new FileExchange();  
		String fileGuid = fe.send();
		
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
    	
    	ImportContractRequest req = new ImportContractRequest();
    	req.setId("foo");
    	
    	Contract contr = new Contract();
    	req.getContract().add(contr);
    	contr.setTransportGUID(Utl.getRndUuid().toString());
    	
    	PlacingContract pc = new PlacingContract();
    	contr.setPlacingContract(pc);

    	pc.setDocNum("2222");
    	pc.setSigningDate(Utl.getXMLDate(Utl.getDateFromStr("01.01.2016")));
    	pc.setEffectiveDate(Utl.getXMLDate(Utl.getDateFromStr("01.01.2016")));
    	pc.setPlanDateComptetion(Utl.getXMLDate(Utl.getDateFromStr("31.12.2016")));
    	pc.setOwners(true);

    	NsiRef cb = new NsiRef();
    	cb.setCode("2");
    	cb.setGUID("a9dc59c3-d53f-42eb-ba98-cf8c74d88d36");
    	pc.setContractBase(cb);
    	
    	DateDetailsType dd = new DateDetailsType();
    	pc.setDateDetails(dd);

    	AttachmentType at = new AttachmentType(); 
    	pc.getContractAttachment().add(at);
    	at.setName("scan.jpg");
    	at.setDescription("описание");
    	
    	Attachment atch = new Attachment(); 
    	at.setAttachment(atch);
    	
    	
    	String hash= "009AACB5498D3E7D339D681BB6541D8AB4EF2A4A81D2235502FEEEC19BD9BFC1";

/*    	GOST3411Digest gd = new GOST3411Digest(); 
    	gd.update(hash.getBytes(), 0, hash.length());
    	gd.
    	System.out.println("Algorithm:"+gd.getAlgorithmName());
    	Memoable mo = gd.copy();
*/

    	//byte[] bytesEncoded = Base64.encodeBase64(hash.getBytes());
    	//String hash2 = new String(bytesEncoded);
    	
    	String hash2 = Hex.encodeHexString(hash.getBytes());
    	//String hash2 = hash;
    	
    	System.out.println("HASH OF FILE:"+hash2);
    	at.setAttachmentHASH(hash2);
    	atch.setAttachmentGUID(fileGuid);
    	
    	PeriodMetering pm = new PeriodMetering(); 
    	dd.setPeriodMetering(pm);
    	DeviceMeteringsDaySelectionType dmds = new DeviceMeteringsDaySelectionType(); 
    	pm.setStartDate(dmds);
    	dmds.setDate(Byte.valueOf("1"));
    	dmds.setIsNextMonth(false);

    	DeviceMeteringsDaySelectionType dmds2 = new DeviceMeteringsDaySelectionType(); 
    	pm.setEndDate(dmds2);
    	dmds2.setLastDay(true);
    	dmds2.setIsNextMonth(false);
    	
    	PaymentDocumentInterval pdi = new PaymentDocumentInterval();
    	dd.setPaymentDocumentInterval(pdi);
    	pdi.setStartDate(Byte.valueOf("1"));
    	pdi.setCurrentMounth(true);
    	
    	PaymentInterval pi = new PaymentInterval();
    	dd.setPaymentInterval(pi);
    	pi.setStartDate(Byte.valueOf("1"));
    	pi.setCurrentMounth(true);
    	
    	ContractObject co = new ContractObject();
    	pc.getContractObject().add(co);

    	co.setFIASHouseGuid("7de1d6c3-c7fd-4da6-95a2-40cb97e8201a");
    	co.setStartDate(Utl.getXMLDate(Utl.getDateFromStr("01.01.2016")));
    	co.setTransportGUID(Utl.getRndUuid().toString());
    	
    	BaseServiceType bm = new BaseServiceType();
    	co.setBaseMService(bm);


    	AttachmentType at2 = new AttachmentType(); 
    	at2.setName("scan.jpg");
    	at2.setDescription("описание");
    	
    	Attachment atch2 = new Attachment(); 
    	at2.setAttachment(atch2);
    	at2.setAttachmentHASH(hash2);
    	atch2.setAttachmentGUID(fileGuid);

    	bm.setAgreement(at2);
    	
    	req.setVersion(req.getVersion());
    	// создание XML, маршаллинг, подпись его внутри хэндлера
    	port.importContractData(req);

    	// отправка SOAP, анмаршаллинг результата
    	// Исправлять классы под соответствующий запрос!
    	ImportResult res = (ImportResult) sp.sendSOAP(  // исправить
    			HouseManagementPortsType.class,  		// исправить
    			req, 
    			"importContractData", 			 		// исправить
    			new ImportResult(), 			 		// исправить
    			config.getBscLogin(), config.getBscPass());

    	System.out.println("res:"+res.getCommonResult());
    }

    public void importHouse(HouseManagementPreps hm) throws Exception {
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
    	//bc.setFIASHouseGuid("7de1d6c3-c7fd-4da6-95a2-40cb97e8201a");
    	bc.setFIASHouseGuid(hm.getHouseGuid());
    	//bc.setTotalSquare(BigDecimal.valueOf(1777d));
    	bc.setTotalSquare(BigDecimal.valueOf(hm.getTotalSquare()));
    	//bc.setUsedYear(BigDecimal.valueOf(1970d).shortValue());
    	bc.setUsedYear(BigDecimal.valueOf(hm.getUsedYear()).shortValue());
    	//bc.setCulturalHeritage(false);
    	bc.setCulturalHeritage(hm.getCultHerit());

    	bc.setOlsonTZ(config.getTz());
    	//bc.setFloorCount("17");
    	bc.setFloorCount(hm.getFloorCount());
    	//bc.setNoRSOGKNEGRPRegistered(true);
    	bc.setNoRSOGKNEGRPRegistered(hm.getNoRSOGKNEGRP());
    	
    	OKTMORefType oktmo = new OKTMORefType();
    	//oktmo.setCode("32607441101");
    	oktmo.setCode(hm.getOktmo());
    	bc.setOKTMO(oktmo);

    	NsiRef ns = new NsiRef();
    	ns.setName(hm.getState()); //TODO! переделать на поиск!
    	ns.setCode("2");
    	ns.setGUID("57c4dbc5-bdd5-4490-92e1-3e687797b32a");
    	bc.setState(ns);
    	
    	ac.setUndergroundFloorCount(hm.getUnderFloorCount());
    	ac.setMinFloorCount(hm.getMinFloorCount().byteValue());

    	ac.setTransportGUID(Utl.getRndUuid().toString());
    	
    	ac.setBasicCharacteristicts(bc);
    	ah.setApartmentHouseToCreate(ac);
    	
    	req.setVersion(req.getVersion());
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

    public void importHouseUpd(HouseManagementPreps hm) throws Exception {
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
    	bc.setFIASHouseGuid(hm.getHouseGuid());
    	bc.setTotalSquare(BigDecimal.valueOf(hm.getTotalSquare()));
    	bc.setUsedYear(BigDecimal.valueOf(hm.getUsedYear()).shortValue());
    	bc.setCulturalHeritage(hm.getCultHerit());

    	bc.setOlsonTZ(config.getTz());
    	bc.setFloorCount(hm.getFloorCount());
    	bc.setNoRSOGKNEGRPRegistered(hm.getNoRSOGKNEGRP());

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

    	req.setVersion(req.getVersion());
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
