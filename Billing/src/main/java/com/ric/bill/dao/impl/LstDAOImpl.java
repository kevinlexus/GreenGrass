package com.ric.bill.dao.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.ric.bill.dao.LstDAO;
import com.ric.bill.model.bs.Lst;


@Repository
public class LstDAOImpl implements LstDAO {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

	
    /**
	 * Найти все элементы (для тестирования) 
	 */
	@Cacheable
	@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)	
    public List<Lst> findAll() {
		Query query =em.createQuery("from Lst t");
		return query.getResultList();
	}

    /**
	 * Найти элемент списка по CD 
	 */
	@Cacheable
	@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)	
    public Lst findByCD(String cd) {
		Query query =em.createQuery("from Lst t where t.cd in (:cd)");
		query.setParameter("cd", cd);
		return (Lst) query.getSingleResult();
	}

}
