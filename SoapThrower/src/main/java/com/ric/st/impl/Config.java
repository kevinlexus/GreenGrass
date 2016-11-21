package com.ric.st.impl;

import javax.xml.ws.BindingProvider;

import org.springframework.stereotype.Service;

import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.signature.demo.commands.Command;
import ru.gosuslugi.dom.signature.demo.commands.SignCommand;

import com.ric.st.Configs;

@Service
public class Config implements Configs {

	
	/**
	 * Получить объект текущей временной зоны
	 */
	public NsiRef getTz() {
    	NsiRef tz = new NsiRef();
    	tz.setCode("10");
    	tz.setGUID("8538e485-b925-4aa7-923f-3b6755e27d4b");
    	return tz;
	}

	/**
	 *	Получить OrgPPGUID организации 
	 */
	public String getOrgPPGuid() {
		return "b9fe4d27-020d-44dc-8bfd-b5972a504f45"; // Металлплощадка
		//return "9b051b50-937d-44f7-b03b-ff621d84ea3d"; // МП "РИЦ"
	}

	/**
	 * Получить URL тестового сервера
	 */
	public String getSrvTestHost() {
//		return "http://127.0.0.1:8085";
		return "http://217.107.108.156:10082";
	}

	/**
	 * Тестовый режим? (стучаться ли на тестовые сервера?)
	 */
	public boolean isSrvTest() {
		return true;
	}
	
	/**
	 * Получить fingerprint
	 */
	public String getFingerPrint() {
		return "2021d448e368a0b39c2bfcd4435574c05ca8c435";
	}

	/**
	 * Получить логин basic-авторизации
	 */
	public String getBscLogin() {
		return "sit";
	}
	
	/**
	 * Получить пароль basic-авторизации
	 */
	public String getBscPass() {
		return "rZ_GG72XS^Vf55ZW";
	}
	
	public void setXmlLog() {
		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "999999");
	}

	
}
