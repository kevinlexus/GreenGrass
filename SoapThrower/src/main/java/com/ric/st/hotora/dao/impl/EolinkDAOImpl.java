package com.ric.st.hotora.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ric.st.hotora.dao.ActionDAO;
import com.ric.st.hotora.dao.EolinkDAO;
import com.ric.st.hotora.model.exs.Action;
import com.ric.st.hotora.model.exs.Eolink;



@Repository
public class EolinkDAOImpl implements EolinkDAO {

	@PersistenceContext
    private EntityManager em;
    
    //конструктор
    public EolinkDAOImpl() {
    	
    }
    
    //вернуть список необработанных действий
    public List<Eolink> getAll() {
			Query query =em.createQuery("from Eolink t");
			return query.getResultList();
	}
    
    
}
