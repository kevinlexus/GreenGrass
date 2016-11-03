package com.ric.st.impl;

import javax.xml.ws.BindingProvider;

import org.springframework.stereotype.Service;

import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;

import com.ric.st.Configs;

@Service
public class Config implements Configs {

	
	/**
	 * Получить объект текущей временной зоны
	 */
	public NsiRef getTz() {
    	NsiRef tz = new NsiRef();
    	tz.setCode("10");
    	tz.setGUID("8538e485-b925-5aa7-923f-3b6755e27d4b");
    	return tz;
	}

	/**
	 *	Получить OrgPPGUID организации 
	 */
	public String getOrgPPGuid() {
		return "b9fe4d27-020d-44dc-8bfd-b5972a504f45";
	}

	/**
	 * Получить URL тестового сервера
	 */
	public String getSrvTestHost() {
		return "http://127.0.0.1:8085";		
	}

	/**
	 * Тестовый режим? (стучаться ли на тестовые сервера?)
	 */
	public boolean isSrvTest() {
		return true;
	}
	
	/**
	 * Получить логин basic-авторизации
	 */
	public String getBscLogin() {
		return "lanit";
	}
	
	/**
	 * Получить пароль basic-авторизации
	 */
	public String getBscPass() {
		return "tv,n8!Ya";
	}
	
	public void setXmlLog() {
		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "999999");
	}

	
}
