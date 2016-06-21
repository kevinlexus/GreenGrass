package com.ric.bill.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	 * Найти элемент списка по CD 
	 */
	@Cacheable("readOnlyCache")
	public Lst findByCD(String cd) {
		Query query =em.createQuery("from Lst t where t.cd in (:cd)");
		query.setParameter("cd", cd);
		return (Lst) query.getSingleResult();
	}

}
