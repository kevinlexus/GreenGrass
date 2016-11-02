package com.ric.st.impl;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;

import ru.gosuslugi.dom.schema.integration.base.RequestHeader;
import ru.gosuslugi.dom.schema.integration.house_management_service.HouseManagementPortsType;

import com.ric.st.SoapPreps;
import com.sun.xml.ws.developer.WSBindingProvider;

public class SoapPrep implements SoapPreps {

	private RequestHeader rh;
	private BindingProvider bs;
	private WSBindingProvider ws;
	/*
	 * Конструктор
	 */
	public void SoapPreps(){
		setRh(new RequestHeader());
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
	public void createRh(Date dt, UUID rUuid, String orgPpaGuid) throws DatatypeConfigurationException {
		GregorianCalendar c = new GregorianCalendar();
    	c.setTime(dt);
    	XMLGregorianCalendar cl = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

    	rh = new RequestHeader();
    	rh.setDate(cl);
    	rh.setMessageGUID(rUuid.toString());
    	rh.setOrgPPAGUID(orgPpaGuid);
    	rh.setIsOperatorSignature(true);
    	ws.setOutboundHeaders(rh);
	}

	/**
	 * Получить байнд-провайдер
	 */
	public BindingProvider getBindingProvider() {
		return bs;
	}

	/**
	 * Задать байнд-провайдер
	 */
	public void setBindingProvider(BindingProvider bs) {
		this.bs = bs;
	}
	
	/*
	 * Подключить basic-авторизацию
	 * 
	 */
	public void setBasicAuth() {
    	bs.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "lanit");
    	bs.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "tv,n8!Ya");
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

	
}
