package com.ric.bill.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import lombok.extern.slf4j.Slf4j;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.ric.bill.dao.OrgDAO;
import com.ric.bill.model.bs.Org;
import com.ric.web.BillingController;


@Repository
@Slf4j
public class OrgDAOImpl implements OrgDAO {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;
    
	//работает это медленнее чем была итерация по всем параметрам объекта!
	@Cacheable(cacheNames="rrr1", key="{#klsk }")
	public Org getByKlsk(int klsk) {
		
		log.info("Org klsk={}", klsk);
		
		Query query =em.createQuery("from Org t where t.klsk = :klsk");
		query.setParameter("klsk", klsk);
		try {
			return (Org) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
