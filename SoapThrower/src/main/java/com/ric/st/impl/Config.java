package com.ric.st.impl;

import java.math.BigInteger;

import javax.annotation.PostConstruct;
import javax.xml.ws.BindingProvider;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.signature.demo.commands.Command;
import ru.gosuslugi.dom.signature.demo.commands.SignCommand;

import com.ric.bill.excp.EmptyStorable;
import com.ric.st.Configs;
import com.ric.st.RefStore;
import com.ric.st.excp.CantGetNSI;
import com.ric.st.mm.UlistMng;

@Slf4j
@Service
public class Config implements Configs {


	@Autowired
	private UlistMng ulistMng; 
	private RefStore rStore;
	private NsiRef tz; 

	// использовать ли подпись SOAP запросов?
	public boolean getUseSign() {
		return false;
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
	
	/**
	 * Вернуть префикс CD элементов в справочниках локальной системы
	 * @return
	 */
	public String getPrefixGis() {
		return "GIS";
	}
	
	public void setXmlLog() {
		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "999999");
	}


	public void setUp() {
		// получить необходимые справочники, поместить в хранилище
		setrStore(new RefStore()); 
		try {
			getrStore().add(ulistMng.getNsi("NSI", BigInteger.valueOf(32)), "NSI", BigInteger.valueOf(32));
			getrStore().add(ulistMng.getNsi("NSI", BigInteger.valueOf(24)), "NSI", BigInteger.valueOf(24));
			//log.info("CHECK={}", getrStore().getByGrp("NSI", BigInteger.valueOf(32)).getVersion() );
		} catch (CantGetNSI e) {
			log.error("Произошла ошибка получения справочников NSI, выход из программы!");
			return;
		}
		
		// получить GUID часовой зоны
		NsiElementType el = ulistMng.getNsiElem(getrStore().getByGrpId("NSI", BigInteger.valueOf(32)), "Часовая зона", "Asia/Novokuznetsk");
		NsiRef tz = new NsiRef();
    	tz.setCode(el.getCode());
    	tz.setGUID(el.getGUID());
    	setTz(tz);
    	
	}

	// установить часовую зону
	private void setTz(NsiRef tz) {
		this.tz=tz;
	}
	
	// получить часовую зону
	public NsiRef getTz() {
    	return tz;
	}
	
	public RefStore getrStore() {
		return rStore;
	}

	private void setrStore(RefStore rStore) {
		this.rStore = rStore;
	}

	
}
