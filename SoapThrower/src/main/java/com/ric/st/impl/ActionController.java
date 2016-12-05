package com.ric.st.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.st.ActionControllers;
import com.ric.st.hotora.dao.ActionDAO;
import com.ric.st.hotora.dao.EolinkDAO;
import com.ric.st.hotora.model.exs.Action;
import com.ric.st.hotora.model.exs.Eolink;

@Slf4j
@Service
public class ActionController implements ActionControllers {

	@Autowired
	ActionDAO actionDao; 

	@Autowired
	EolinkDAO eolinkDao;
	
	@PersistenceContext
    private EntityManager em;

	/**
	 * Поиск новых действий для обработки 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void searchActions() {
		log.info(" ********************** search Actions:");
		
		
		Eolink eo = em.find(Eolink.class, 2);
		Action ac = new Action(eo, "INS", "INS");
		eo.getAction().add(ac);	
		
		for (Action action: actionDao.getAllUnprocessed()) {
			log.info(" Action:"+action.getAction());
		}
		
		
	}


}
