package com.ric.st.builder;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.w3._2000._09.xmldsig_.SignatureType;
import org.w3._2000._09.xmldsig_.SignatureValueType;

import ru.gosuslugi.dom.schema.integration.base.RequestHeader;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementType;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiItemRequest;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiItemResult;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiListRequest;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiListResult;
import ru.gosuslugi.dom.schema.integration.nsi_common_service.Fault;
import ru.gosuslugi.dom.schema.integration.nsi_common_service.NsiPortsType;
import ru.gosuslugi.dom.schema.integration.nsi_common_service.NsiService;

import com.ric.bill.Utl;
import com.ric.st.NsiBindingBuilders;
import com.ric.st.SoapPreps;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.excp.CantSignSoap;
import com.ric.st.impl.App;
import com.ric.st.impl.Config;
import com.ric.st.impl.LoggingSOAPHandler;
import com.sun.xml.ws.developer.WSBindingProvider;

@Service
@Slf4j
public class NsiBindingBuilder implements NsiBindingBuilders {

	@Autowired
	private ApplicationContext ctx;
    @PersistenceContext
    private EntityManager em;
	@Autowired
	private Config config;
	@Autowired
	private SoapPreps sp;

	private ExportNsiListResult resList;
	private ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiItemResult resItem;
	private NsiService service;
	private NsiPortsType port;
	
	@PostConstruct
	public void init() throws Exception {
    	// создать сервис и порт
    	service = new NsiService();
    	port = service.getNsiPort();
    	// подготовительный объект
    	//sp.setUp(port, (BindingProvider) port, (WSBindingProvider) port);

    	// подписывать XML?
    	//sp.setSignXML(false);


    	
    	// создать и подготовить заголовок запроса
    	//sp.createRh(config.getOrgPPGuid(), true);

    	log.info("Выполнилось init()");
	}


	/**
	 * Получить список справочников
	 * @param grp - вид справочника (NSI, NISRAO)
	 * @throws Fault 
	 * @throws CantSendSoap 
	 * @throws CantSignSoap 
	 * @throws Exception
	 */
	public ExportNsiListResult getNsiList(String grp) throws Fault, CantSignSoap, CantSendSoap { 
		// создать и подготовить заголовок
		try {
			sp.createRh(true);
		} catch (DatatypeConfigurationException e1) {
			e1.printStackTrace();
			throw new CantSendSoap("Ошибка при подготовке заголовка SOAP запроса!");
		}

		// подписывать
		sp.setSignXML(false);
		
		ExportNsiListRequest req = new ExportNsiListRequest();
		req.setListGroup(grp);
		req.setVersion(req.getVersion());
		//req.setId("foo");
		req.setVersion(req.getVersion());

		
		port.exportNsiList(req);
	   	// отправить SOAP, анмаршаллинг результата
	    resList = (ExportNsiListResult) sp.sendSOAP(  
	   			req, 
	   			"exportNsiList", 			 		
	   			new ExportNsiListResult(),
	   			config,
	   			true, 0);
	   return resList;
	}
	
	/**
	 * Получить справочник
	 * @param grp - вид справочника (NSI, NISRAO)
	 * @throws Fault 
	 * @throws CantSendSoap 
	 * @throws CantSignSoap 
	 * @throws Exception
	 */
	public ExportNsiItemResult getNsiItem(String grp, BigInteger id) throws Fault, CantSignSoap, CantSendSoap {
		// создать и подготовить заголовок
		/*try {
			sp.createRh(true);
		} catch (DatatypeConfigurationException e1) {
			e1.printStackTrace();
			throw new CantSendSoap("Ошибка при подготовке заголовка SOAP запроса!");
		}*/

		// подписывать
		//sp.setSignXML(false);
		
		
		BindingProvider bp = (BindingProvider) port;
		WSBindingProvider ws = (WSBindingProvider) port;

		RequestHeader rh = new RequestHeader();
				
		rh.setOrgPPAGUID(config.getOrgPPGuid());
    	//if (isSetOperSign) {
    	rh.setIsOperatorSignature(true);
    	//}

    	// установить Random Message GUID и дату
    	GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar cl = null;
		try {
			cl = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		rh.setDate(cl);
    	UUID messGUID = Utl.getRndUuid();
		rh.setMessageGUID(messGUID.toString());
    	
    	ws.setOutboundHeaders(rh);
		
		String endPoint = (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
		String urlStr = endPoint;
		String path = null;
		try {
			path = Utl.getPathFromUrl(urlStr);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Request to={}", path);
		
		Map<String, List<String>> requestHeaders = new HashMap<>();
		//requestHeaders.put("Auth-User", Arrays.asList("BILL_GATES"));
        String authorization = new sun.misc.BASE64Encoder().encode((config.getBscLogin()+":"+config.getBscPass()).getBytes());
		requestHeaders.put("Authorization", Arrays.asList("Basic " + authorization));
		requestHeaders.put("X-Client-Cert-Fingerprint", Arrays.asList(config.getFingerPrint()));
		
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
				"http://217.107.108.156:10082"+path);
		
		bp.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
		
		//задать новый Endpoint
		//setEndPoint(host+path);
		
		ExportNsiItemRequest req = new ExportNsiItemRequest();
	    req.setListGroup(grp);
	    req.setRegistryNumber(id);
		req.setId("foo");
		req.setVersion(req.getVersion());
	    
		// получить XML
		// добавить хэндлер, для установщика подписи ЭЦП
		Binding binding = bp.getBinding();
    	List<Handler> handlerChain = binding.getHandlerChain();
    	handlerChain.add(new LoggingSOAPHandler());
    	binding.setHandlerChain(handlerChain);

		ExportNsiItemResult ex = port.exportNsiItem(req);

		Map<String, Object> responseContext = bp.getResponseContext();
        
	   	// отправка SOAP, анмаршаллинг результата
	   	/*resItem = (ExportNsiItemResult) sp.sendSOAP(  
	   			req, 
	   			"exportNsiItem", 			 		
	   			new ExportNsiItemResult(),
	   			config,
	   			true, 1);*/
	   	
	   return ex;
	}
}
