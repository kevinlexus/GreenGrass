package com.ric.st.hotora.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ric.st.hotora.dao.ActionDAO;
import com.ric.st.hotora.model.exs.Action;



@Repository
public class ActionDAOImpl implements ActionDAO {

	@PersistenceContext
    private EntityManager em;
    
    //конструктор
    public ActionDAOImpl() {
    	
    }
    
    //вернуть список необработанных действий
    public List<Action> getAllUnprocessed() {
			Query query =em.createQuery("from Action t where t.state = :state");
			query.setParameter("state", "INS");
			return query.getResultList();
	}
    
    
}
