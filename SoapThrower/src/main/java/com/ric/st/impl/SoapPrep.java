package com.ric.st.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.jws.WebMethod;
import javax.xml.bind.JAXBContext;
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
import javax.xml.ws.handler.Handler;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import ru.gosuslugi.dom.schema.integration.base.RequestHeader;

import com.ric.bill.Utl;
import com.ric.st.SoapPreps;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.excp.CantSignSoap;
import com.sun.xml.ws.developer.WSBindingProvider;

@Slf4j
@Service
@Scope("prototype") // prototype, иначе - ошибка, так как другие классы пытаются использовать совместно
public class SoapPrep<T> implements SoapPreps<T> {

	T ob;
	
	private RequestHeader rh;
	private BindingProvider bp;
	private WSBindingProvider ws;
	private String endPoint;
	private Binding binding;
	private String xmlText;
	private Boolean sign; 
	
	@Autowired
	private Config config;
	
	/*
	 * установить конфигурационные параметры
	 */
	@Override
	public void setUp(T o, BindingProvider bs, WSBindingProvider ws){
		ob = o;
		setBindingProvider(bs);
		setWSBindingProvider(ws);
		setBinding(bs.getBinding());
		// установить хедеры
		setRh(new RequestHeader());
		// добавить хэндлер
		addHandler();
    	log.info("Выполнилось setUp");
		
	}

	/**
	 * Добавить хэндлер
	 */
	private void addHandler() {
    	//добавить хэндлер, для установщика подписи ЭЦП
    	List<Handler> handlerChain = binding.getHandlerChain();
    	handlerChain.add(new LoggingSOAPHandler());
    	binding.setHandlerChain(handlerChain);
		
	}
	
	/**
	 * Установить заголовок запроса 
	 */
	private void setRh(RequestHeader rh) {
		this.rh=rh;
	}

	/**
	 * Получить заголовок запроса 
	 */
	private RequestHeader getRh() {
		return this.rh;
	}
	
	/**
	 * Создать и подготовить заголовок запроса
	 * @param dt
	 * @param rUuid
	 * @param orgPpaGuid
	 * @throws DatatypeConfigurationException 
	 */
	public void createRh(boolean isSetOperSign) throws DatatypeConfigurationException {
		//rh = new RequestHeader();
    	rh.setOrgPPAGUID(config.getOrgPPGuid());
    	if (isSetOperSign) {
    		rh.setIsOperatorSignature(true);
    	}

    	// установить Random Message GUID и дату
    	GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar cl = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		rh.setDate(cl);
    	UUID messGUID = Utl.getRndUuid();
		rh.setMessageGUID(messGUID.toString());
    	
    	ws.setOutboundHeaders(rh);
    	log.info("Выполнилось createRh");
	}

	/**
	 * Получить байнд-провайдер
	 */
	private BindingProvider getBindingProvider() {
		return bp;
	}

	/**
	 * Задать байнд-провайдер
	 */
	private void setBindingProvider(BindingProvider bs) {
		//сохранить Endpoint
		setEndPoint((String) bs.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY));

		this.bp = bs;
	}
	
	/**
	 * Получить WS-байнд-провайдер
	 */
	private WSBindingProvider getWSBindingProvider() {
		return this.ws;
	}

	/**
	 * Задать WS-байнд-провайдер
	 */
	private void setWSBindingProvider(WSBindingProvider ws) {
		this.ws = ws;
	}

	private void changeHost(String host) throws UnknownHostException, MalformedURLException {
		String urlStr = getEndPoint();
		String path = Utl.getPathFromUrl(urlStr);
		getBindingProvider().getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
    			host+path);
		//задать новый Endpoint
		setEndPoint(host+path);
	}

	private String getEndPoint() {
		return endPoint;
	}

	private void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	private Binding getBinding() {
		return binding;
	}

	private void setBinding(Binding binding) {
		this.binding = binding;
	}
    
	/**
	 * Подписывать XML?
	 * @param sign
	 * @return 
	 */
	public void setSignXML(Boolean sign) {
		this.sign = sign;
    	bp.getRequestContext().put("sign", sign);
	}

	/**
	 * Подписывать XML?
	 * @param sign
	 * @return 
	 */
	private boolean getSignXML() {
    	return sign;
	}

	/**
	 * Создать SOAP сообщение
	 */
	private SOAPMessage createSM(String xmlText) throws IOException, SOAPException {
    	MessageFactory factory;
    	SOAPMessage message2 = null;
		factory = MessageFactory.newInstance();
        return factory.createMessage(new MimeHeaders(), new ByteArrayInputStream(xmlText.getBytes()));
	}

	/*
	 * Отправить SOAP сообщение
	 * 
	 */
	public Object sendSOAP(Object req, String meth, Object result, Config config, boolean isSetOperSign) throws CantSignSoap, CantSendSoap {
		
    	// заменить Endpoint, если надо 
		try {
	    	if (config.isSrvTest()) {
	    		changeHost(config.getSrvTestHost());
	    	}
		} catch (UnknownHostException | MalformedURLException e1) {
			throw new CantSendSoap("Ошибка при замене IP адреса хоста SOAP запроса!");
		}
		
		//получить XML из хэндлера
    	Map<String, Object> responseContext = getBindingProvider().getResponseContext();
		
        setXMLText((String) responseContext.get("SOAP_XML"));

        // подпись XML, если необходимо
        if (getSignXML()) {
	        try {
				setXMLText(signXML(getXMLText()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new CantSignSoap("Ошибка при подписи SOAP запроса!");
			}
        }
        
        Object res = null;
        try {
	    	SOAPMessage message2 = createSM(xmlText);
	        // создать SOAP соединение 
	        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
	        SOAPConnection soapConnection = soapConnectionFactory.createConnection();
	        
	        String authorization = new sun.misc.BASE64Encoder().encode((config.getBscLogin()+":"+config.getBscPass()).getBytes());
	        MimeHeaders hd = message2.getMimeHeaders();
	        hd.addHeader("Authorization", "Basic " + authorization);
	        hd.addHeader("X-Client-Cert-Fingerprint", config.getFingerPrint());
	        
	        log.info("Class-2 : " + ob.getClass().getInterfaces()[0]);
	        
	        Method m = ob.getClass().getInterfaces()[0].getMethod(meth, req.getClass());
	        
	        WebMethod webmethod = m.getAnnotation(WebMethod.class);
	        
	        hd.addHeader("SOAPAction", webmethod.action());
	        
	        System.out.println("Send:"); 
	        System.out.println("");
	        System.out.println("");
	        printSOAPmessage(message2);

	        // отправить SOAP сообщение на Endpoint
	        SOAPMessage soapResponse = soapConnection.call(message2, getEndPoint());
	
	        System.out.println("");
	        System.out.println("");
	        System.out.println("Recv:");
	        printSOAPmessage(soapResponse);

	        JAXBContext context = JAXBContext.newInstance(result.getClass());
	    	Unmarshaller unmarshaller = JAXBContext.newInstance(result.getClass()).createUnmarshaller();
	    	res = unmarshaller.unmarshal(soapResponse.getSOAPBody().extractContentAsDocument());
	
	    	// закрыть SOAP соединение 
	        soapConnection.close();
        } catch (Exception e) {
			e.printStackTrace();
			throw new CantSendSoap("Ошибка при отправке SOAP запроса!");
		}
		return res;
	}

	private String getXMLText() {
		return xmlText;
	}

	private void setXMLText(String xmlText) {
		this.xmlText = xmlText;
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
	
    /**
     * Подписать XML
     * @param xml - XML запрос
     * @return
     * @throws Exception 
     */
    private String signXML(String xml) throws Exception {
		return App.sc.signElem(xml, "foo", "foo");
    	
    }

}
