package com.ric.bill.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.stereotype.Repository;

import com.ric.bill.dao.ParDAO;
import com.ric.bill.model.bs.Par;


@Repository
public class ParDAOImpl implements ParDAO {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;
    
	@SuppressWarnings("unchecked")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="billCache")	
	public List<Par> findAll() {
		return em.createQuery("from Par").getResultList();
	}
}
