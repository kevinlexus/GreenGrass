package com.ric.st.impl;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ric.st.ActionControllers;
import com.ric.st.hotora.dao.ActionDAO;
import com.ric.st.hotora.model.exs.Action;

@Service
@Slf4j
public class ActionController implements ActionControllers {

	@Autowired
	ActionDAO actionDao; 
	/**
	 * Поиск новых действий для обработки 
	 */
	public void searchActions() {
		
		for (Action action: actionDao.getAllUnprocessed()) {
			log.info(" Action:"+action.getAction());
		}
		
		
	}


}
