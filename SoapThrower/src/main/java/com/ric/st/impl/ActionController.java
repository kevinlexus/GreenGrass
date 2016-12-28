package com.ric.st.impl;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementType;

import com.ric.st.ActionControllers;
import com.ric.st.RefStore;
import com.ric.st.excp.CantGetNSI;
import com.ric.st.hotora.dao.ActionDAO;
import com.ric.st.hotora.dao.EolinkDAO;
import com.ric.st.hotora.model.exs.Action;
import com.ric.st.mm.UlistMng;

@Slf4j
@Service
public class ActionController implements ActionControllers {

	@Autowired
	ActionDAO actionDao; 

	@Autowired
	EolinkDAO eolinkDao;
	
	@Autowired
	UlistMng ulistMng;

	@PersistenceContext
    private EntityManager em;

	private RefStore rStore; 

	/**
	 * Выполнить инициализацию объекта 
	 * @return 
	 * @throws EmptyStorable
	 */
	private boolean checkNsiUpdates() {
		// проверить обновление справочников
		try {
			ulistMng.refreshNsi("NSI");
			ulistMng.refreshNsi("NSIRAO");
		} catch (Exception e) {
			// сообщение об ошибке
			e.printStackTrace();
			return false;
		}
		return true;
	}


	/**
	 * Поиск новых действий для обработки 
	 */
	public void searchActions() {
		
		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "false");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "false");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "false");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "false");
		
		// получить необходимые справочники, поместить в хранилище
		setrStore(new RefStore()); 
		try {
			getrStore().add(ulistMng.getNsi("NSI", BigInteger.valueOf(32)), "NSI");
			log.info("CHECK={}", getrStore().getByGrp("NSI", BigInteger.valueOf(32)).getVersion() );
		} catch (CantGetNSI e) {
			log.error("Произошла ошибка получения справочников NSI, выход из программы!");
			return;
		}
		
		NsiElementType dd = ulistMng.getNsiElem(getrStore().getByGrp("NSI", BigInteger.valueOf(32)), "Часовая зона", "Asia/Novokuznetsk");
		
		if (dd != null) {
			log.info("GUID={}", dd.getGUID());
		}

		//dd = ulistMng.getNsiElem(rStore.getByGrp("NSI", BigInteger.valueOf(32)), "Состояние дома", "Исправный");
		
		if (dd != null) {
			log.info("GUID2={}", dd.getGUID());
		}

		if (!checkNsiUpdates()) {
			log.error("Произошла ошибка обновления справочников NSI, выход из программы!");
			return;
		}
		
		log.info(" ********************** search Actions:");
		
		//Eolink eo = em.find(Eolink.class, 2);
		//Action ac = new Action(eo, "INS", "INS");
		//eo.getAction().add(ac);	
		
		// ОСНОВНОЙ ЦИКЛ
		for (Action action: actionDao.getAllUnprocessed()) {
			log.info(" Action:"+action.getAction());
		}
		
		
	}


	public RefStore getrStore() {
		return rStore;
	}


	public void setrStore(RefStore rStore) {
		this.rStore = rStore;
	}


}
