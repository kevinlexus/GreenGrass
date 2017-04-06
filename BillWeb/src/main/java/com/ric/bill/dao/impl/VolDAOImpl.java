package com.ric.bill.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.dao.VolDAO;
import com.ric.bill.model.mt.main.Vols1;


	@Repository
	public class VolDAOImpl implements VolDAO {
	
		//EntityManager - EM нужен на каждый DAO или сервис свой!
	    @PersistenceContext
	    private EntityManager em;
	
	    /*
	     * Добавить объем
	     * @param vol - объект объема
	     */
	    public synchronized void add(Vols1 vol) {
			em.persist(vol);
		}
	
	}
