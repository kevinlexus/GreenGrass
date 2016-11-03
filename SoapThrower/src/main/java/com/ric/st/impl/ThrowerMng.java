package com.ric.st.impl;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.jws.WebMethod;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
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
import ru.gosuslugi.dom.schema.integration.house_management.ExportCAChRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportCAChRequestCriteriaType;
import ru.gosuslugi.dom.schema.integration.house_management.ExportCAChResult;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportMeteringDeviceDataRequest;
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
	public static String xmlText; 
	

    public void importHouse() throws DatatypeConfigurationException, ru.gosuslugi.dom.schema.integration.house_management_service.Fault, IOException, SOAPException {
    	
    	//создать сервис и порт
    	HouseManagementService service = new HouseManagementService();
    	HouseManagementPortsType port = service.getHouseManagementPort();

    	//подготовительный объект
    	SoapPreps sp = new SoapPrep((BindingProvider) port, (WSBindingProvider) port);

    	//подписывать XML?
    	sp.isSignXML(true);
    	
    	//заменить Endpoint, если надо 
    	if (config.isSrvTest()) {
    		sp.changeHost(config.getSrvTestHost());
    	}

    	//создать и подготовить заголовок запроса
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
    	
    	sp.sendSOAP();
    	
    	Map<String, Object> responseContext = sp.getBindingProvider().getResponseContext();
        System.out.println("has key? " + responseContext.containsKey("SOAP_RESPONSE_XML"));         
        System.out.println("is key? " + (String) responseContext.get("SOAP_RESPONSE_XML"));
    	
    	
    	System.out.println("MSG:"+xmlText);
   	    // cоздать SOAP сообщение
    	SOAPMessage message2 = sp.createSM(xmlText);
        
        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            
            String authorization = new sun.misc.BASE64Encoder().encode(("lanit"+":"+"tv,n8!Ya").getBytes());
            MimeHeaders hd = message2.getMimeHeaders();
            hd.addHeader("Authorization", "Basic " + authorization);
            
            Method m = HouseManagementPortsType.class.getMethod("importHouseUOData", ImportHouseUORequest.class);
            WebMethod webmethod = m.getAnnotation(WebMethod.class);
            hd.addHeader("SOAPAction", webmethod.action());
            
            
            System.out.println("Send:"); 
            System.out.println("");
            System.out.println("");
            printSOAPmessage(message2);
            // отправить SOAP сообщение на Endpoint
            SOAPMessage soapResponse = soapConnection.call(message2, sp.getEndPoint());

            System.out.println("");
            System.out.println("");
            System.out.println("Recv:");
            printSOAPmessage(soapResponse);
            
        	ImportResult res = null;
	    	JAXBContext context = JAXBContext.newInstance(ImportResult.class);
	    	Unmarshaller unmarshaller = JAXBContext.newInstance(ImportResult.class).createUnmarshaller();
	    	res = (ImportResult)unmarshaller.unmarshal(soapResponse.getSOAPBody().extractContentAsDocument());
            
	    	System.out.println("Result: "+res.getCommonResult());

	    	// Process the SOAP Response
            soapConnection.close();
        } catch (Exception e) {
            System.err.println("Error occurred while sending SOAP Request to Server");
            e.printStackTrace();
        }
    	
    }
    
    /**
     * Method used to print the SOAP Response
     */
    private static void printSOAPmessage(SOAPMessage soapResponse) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        StreamResult result = new StreamResult(System.out);
        transformer.transform(sourceContent, result);
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
