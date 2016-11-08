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
import javax.xml.ws.handler.Handler;

import ru.gosuslugi.dom.schema.integration.base.RequestHeader;
import ru.gosuslugi.dom.signature.demo.commands.Command;
import ru.gosuslugi.dom.signature.demo.commands.SignCommand;

import com.ric.bill.Utl;
import com.ric.st.SoapPreps;
import com.sun.xml.ws.developer.WSBindingProvider;

public class SoapPrep implements SoapPreps {

	private RequestHeader rh;
	private BindingProvider bp;
	private WSBindingProvider ws;
	private String endPoint;
	private Binding binding;
	private String xmlText;
	private Boolean sign; 
	
	/*
	 * Конструктор
	 */
	public SoapPrep(BindingProvider bs, WSBindingProvider ws){
		setBindingProvider(bs);
		setWSBindingProvider(ws);
		setBinding(bs.getBinding());
		// установить хедеры
		setRh(new RequestHeader());
		// добавить хэндлер
		addHandler();
	}

	/**
	 * Добавить хэндлер
	 */
	public void addHandler() {
    	//добавить хэндлер, для установщика подписи ЭЦП
    	List<Handler> handlerChain = binding.getHandlerChain();
    	handlerChain.add(new LoggingSOAPHandler());
    	binding.setHandlerChain(handlerChain);
		
	}
	
	/**
	 * Установить заголовок запроса 
	 */
	public void setRh(RequestHeader rh) {
		this.rh=rh;
	}

	/**
	 * Получить заголовок запроса 
	 */
	public RequestHeader getRh() {
		return this.rh;
	}
	
	/**
	 * Создать и подготовить заголовок запроса
	 * @param dt
	 * @param rUuid
	 * @param orgPpaGuid
	 * @throws DatatypeConfigurationException 
	 */
	public void createRh(Date dt, UUID rUuid, String orgPpaGuid, boolean isSetOperSign ) throws DatatypeConfigurationException {
		GregorianCalendar c = new GregorianCalendar();
    	c.setTime(dt);
    	XMLGregorianCalendar cl = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

    	rh = new RequestHeader();
    	rh.setDate(cl);
    	rh.setMessageGUID(rUuid.toString());
    	rh.setOrgPPAGUID(orgPpaGuid);
    	if (isSetOperSign) {
    		rh.setIsOperatorSignature(true);
    	}
    	ws.setOutboundHeaders(rh);
	}

	/**
	 * Получить байнд-провайдер
	 */
	public BindingProvider getBindingProvider() {
		return bp;
	}

	/**
	 * Задать байнд-провайдер
	 */
	public void setBindingProvider(BindingProvider bs) {
		//сохранить Endpoint
		setEndPoint((String) bs.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY));

		this.bp = bs;
	}
	
	/**
	 * Получить WS-байнд-провайдер
	 */
	public WSBindingProvider getWSBindingProvider() {
		return this.ws;
	}

	/**
	 * Задать WS-байнд-провайдер
	 */
	public void setWSBindingProvider(WSBindingProvider ws) {
		this.ws = ws;
	}

	public void changeHost(String host) throws UnknownHostException, MalformedURLException {
		String urlStr = getEndPoint();
		String path = Utl.getPathFromUrl(urlStr);
		getBindingProvider().getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
    			host+path);
		//задать новый Endpoint
		setEndPoint(host+path);
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public Binding getBinding() {
		return binding;
	}

	public void setBinding(Binding binding) {
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
	public boolean getSignXML() {
    	return sign;
	}

	/**
	 * Создать SOAP сообщение
	 */
	public SOAPMessage createSM(String xmlText) throws IOException, SOAPException {
    	MessageFactory factory;
    	SOAPMessage message2 = null;
		factory = MessageFactory.newInstance();
        return factory.createMessage(new MimeHeaders(), new ByteArrayInputStream(xmlText.getBytes()));
	}

	/*
	 * Отправить SOAP сообщение
	 * 
	 */
	public Object sendSOAP(Class portClass, Object req, String meth, Object result, String login, String pass) throws Exception {
		//получить XML из хэндлера
    	Map<String, Object> responseContext = getBindingProvider().getResponseContext();
        setXMLText((String) responseContext.get("SOAP_XML"));

        // подпись XML, если необходимо
        if (getSignXML()) {
	        setXMLText(signXML(getXMLText()));
        }
        
    	SOAPMessage message2 = createSM(xmlText);
        Object res = null;
        // создать SOAP соединение 
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();
        
        String authorization = new sun.misc.BASE64Encoder().encode((login+":"+pass).getBytes());
        MimeHeaders hd = message2.getMimeHeaders();
        hd.addHeader("Authorization", "Basic " + authorization);
        
        Method m = portClass.getMethod(meth, req.getClass());

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
		return res;
	}

	public String getXMLText() {
		return xmlText;
	}

	public void setXMLText(String xmlText) {
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
    public String signXML(String xml) throws Exception {
		return App.sc.signElem(xml, "foo", "foo");
    	
    }

}
