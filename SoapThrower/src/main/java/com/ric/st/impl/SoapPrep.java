package com.ric.st.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

import ru.gosuslugi.dom.schema.integration.base.RequestHeader;

import com.ric.bill.Utl;
import com.ric.st.SoapPreps;
import com.sun.xml.ws.developer.WSBindingProvider;

public class SoapPrep implements SoapPreps {

	private RequestHeader rh;
	private BindingProvider bp;
	private WSBindingProvider ws;
	private String endPoint;
	private Binding binding;
	
	/*
	 * Конструктор
	 */
	public SoapPrep(BindingProvider bs, WSBindingProvider ws){
		setBindingProvider(bs);
		setWSBindingProvider(ws);
		setBinding(bs.getBinding());
		setRh(new RequestHeader());
		//Добавить хэндлер
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
	
	/*
	 * Подключить basic-авторизацию - не здесь делается
	 * 
	 */
/*	public void setBasicAuth() {
    	bs.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "lanit");
    	bs.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "tv,n8!Ya");
	}
*/
	
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
	public void isSignXML(Boolean sign) {
    	bp.getRequestContext().put("sign", sign);
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
}
