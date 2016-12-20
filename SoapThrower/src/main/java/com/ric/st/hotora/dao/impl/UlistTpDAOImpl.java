package com.ric.st.hotora.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ric.st.hotora.dao.UlistTpDAO;



@Repository
public class UlistTpDAOImpl implements UlistTpDAO {

	@PersistenceContext
    private EntityManager em;

	//конструктор
    public UlistTpDAOImpl() {
    	
    }
        
}
