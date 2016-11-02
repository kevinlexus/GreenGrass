package com.ric.st.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.handler.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.terracotta.modules.ehcache.async.AsyncConfig;
import org.w3._2000._09.xmldsig_.SignatureType;

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
	
    public void importHouse() throws DatatypeConfigurationException, ru.gosuslugi.dom.schema.integration.house_management_service.Fault {
    	//подготовительный объект
    	SoapPreps sp = new SoapPrep();
    	
    	HouseManagementService service = new HouseManagementService();
    	HouseManagementPortsType port = service.getHouseManagementPort();
    	
    	
    	BindingProvider provider = (BindingProvider) port;
    	Binding binding = provider.getBinding();
    	
    	//List<Handler> handlerChain = binding.getHandlerChain();
    	//handlerChain.add(new LoggingSOAPHandler());
    	//binding.setHandlerChain(handlerChain);
    	
/*    	service.setHandlerResolver(new HandlerResolver() {
    		public List<Handler> getHandlerChain(PortInfo portInfo) {
                List<Handler> handlerChain = new ArrayList<Handler>();
                handlerChain.add(new LoggingSOAPHandler());
                return handlerChain;
            }
	    });*/

    	sp.setBindingProvider((BindingProvider) port);
    	sp.setWSBindingProvider((WSBindingProvider)port);
    	
    	//не удалять - получить ENDPOINT sp.getBindingProvider().getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
    	if (config.isSrvTest()) {
    		sp.getBindingProvider().getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
	    			"http://127.0.0.1:8085/ext-bus-home-management-service/services/HomeManagement");
    	}

    	//создать и подготовить заголовок запроса
    	sp.createRh(new Date(), Utl.getRndUuid(), config.getOrgPPGuid());
    	sp.setBasicAuth();
    	
    	ImportHouseUORequest req = new ImportHouseUORequest();
    	
    	
    	//SignatureType sg = new SignatureType();
    	//sg.setId("blabla");
    	//req.setSignature(sg);
    	
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
    	ImportResult ir = port.importHouseUOData(req);
    	System.out.println("Result: "+ir);
    	
    }
    
	//отправить XML-2
    @Test
    public void send2() throws DatatypeConfigurationException, ru.gosuslugi.dom.schema.integration.house_management_service.Fault {
    	GregorianCalendar c = new GregorianCalendar();
    	c.setTime(new Date());
    	XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

    	System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
    	System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
    	System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
    	System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "999999");
    	//System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
    	//System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "999999");
    	
    	HouseManagementService service = new HouseManagementService();
    	HouseManagementPortsType port = service.getHouseManagementPort();
    	BindingProvider bindingProvider = (BindingProvider) port;
    	bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
    			"http://127.0.0.1:8085/ext-bus-home-management-service/services/HomeManagement");
    	
    	//Возможно, отключить basic авторизацию, как подключат сертификат?
    	bindingProvider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "lanit");
    	bindingProvider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "tv,n8!Ya");
    	WSBindingProvider ws = (WSBindingProvider)port;
    	
    	UUID uuid = UUID.randomUUID();
    	RequestHeader rh = new RequestHeader();
    	
    	rh.setDate(date2);
    	rh.setMessageGUID(uuid.toString());
    	rh.setOrgPPAGUID("9b051b50-937d-44f7-b03b-ff621d84ea3d");
    	ws.setOutboundHeaders(rh);
    	
    	ImportHouseUORequest req = new ImportHouseUORequest();
    	ApartmentHouse ah = new ApartmentHouse();
    	ApartmentHouseToCreate ac = new ApartmentHouseToCreate();
    	BasicCharacteristicts bc = new BasicCharacteristicts();
    	bc.setFIASHouseGuid("810321c3-f0b4-454a-9a1c-cad82adebd58");
    	bc.setTotalSquare(BigDecimal.valueOf(1000d));
    	bc.setUsedYear(BigDecimal.valueOf(1970d).shortValue());
    	//bc.setCadastralNumber("Нет");
    	bc.setCulturalHeritage(false);
    	NsiRef tz = new NsiRef();
    	tz.setCode("10");
    	tz.setGUID("8538e485-b925-5aa7-923f-3b6755e27d4b");
    	bc.setOlsonTZ(tz);
    	bc.setFloorCount("10");
    	bc.setNoRSOGKNEGRPRegistered(true);

    	ac.setUndergroundFloorCount("0");

    	UUID tuid = UUID.randomUUID();
    	ac.setTransportGUID(tuid.toString());
    	
    	NsiRef ns = new NsiRef();
    	ns.setName("Исправный");
    	ns.setCode("2");
    	ns.setGUID("57c4dbc5-bdd5-4490-92e1-3e687797b32a");
    	
    	bc.setState(ns);
    	

    	ac.setBasicCharacteristicts(bc);
    	ah.setApartmentHouseToCreate(ac);

    	System.out.println("Version="+req.getVersion());
    	
    	req.setVersion("10.0.1.1");
    	req.setApartmentHouse(ah);
    	
    	port.importHouseUOData(req);
    	
    }
    	
    //отправить XML
    public void send() throws DatatypeConfigurationException, Fault {
    	GregorianCalendar c = new GregorianCalendar();
    	c.setTime(new Date());
    	XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

    	System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
    	System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
    	System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
    	System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "999999");
    	
    	RegOrgService service = new RegOrgService();
    	RegOrgPortsType port = service.getRegOrgPort();
    		
    	BindingProvider bindingProvider = (BindingProvider) port;
    	bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
    			"http://127.0.0.1:8085/ext-bus-org-registry-common-service/services/OrgRegistryCommon");
    	
    	//Возможно, отключить basic авторизацию, как подключат сертификат?
    	bindingProvider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "lanit");
    	bindingProvider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "tv,n8!Ya");
    	WSBindingProvider bp = (WSBindingProvider)port;
    	
    	UUID uuid = UUID.randomUUID();
    	RequestHeader rh = new RequestHeader();
    	
    	rh.setDate(date2);
    	rh.setMessageGUID(uuid.toString());
    	rh.setOrgPPAGUID("9b051b50-937d-44f7-b03b-ff621d84ea3d");
    	bp.setOutboundHeaders(rh);
    	
    	ExportOrgRegistryRequest req = new ExportOrgRegistryRequest();  

   	
    	SearchCriteria cr = new SearchCriteria();
    	
    	//System.out.println(uuid);
    	req.setVersion("10.0.2.1");
    	
    	//cr.setOrgVersionGUID("1aA1aA1C-1aA1-1aA2-1aA3-1aA1aA1aA1aA");
    	cr.setOGRN("1114205043468");
    	req.getSearchCriteria().add(cr);

    	
    	//req.setLastEditingDateFrom(date2);

    	ExportOrgRegistryResult res = port.exportOrgRegistry(req);

    	//System.out.println("error1:"+res.getErrorMessage().getStackTrace());
    	//System.out.println("error2:"+res.getErrorMessage().getErrorCode());
    	//System.out.println("error3:"+res.getErrorMessage().getDescription());
    	
    	for(ExportOrgRegistryResultType r : res.getOrgData()) {
    		System.out.println("=========");
    		System.out.println(r.getOrgVersion() + ", " + r.getOrgRootEntityGUID());
    		System.out.println(r.getOrgVersion().getLegal().getFullName());
    		
    	}    	

    	
    	//Запрос - счетчики
    	//ImportMeteringDeviceValuesRequest req2 = new ImportMeteringDeviceValuesRequest();  
    	//req2.getMeteringDevicesValues().add(index, element);
    	
    	
    	
    }
}
