package com.ric.st.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ric.st.ActionControllers;
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


	/**
	 * Выполнить инициализацию объекта 
	 * @return 
	 * @throws EmptyStorable
	 */
	private boolean checkNsiUpdates() {
		// проверить обновление справочников
		try {
			//ulistMng.refreshNsi("NSI");
			ulistMng.refreshNsi("NSI");
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


}
