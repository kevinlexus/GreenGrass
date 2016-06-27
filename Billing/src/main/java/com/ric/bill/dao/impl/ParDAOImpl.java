package com.ric.bill.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.dao.ParDAO;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Par;


@Repository
public class ParDAOImpl implements ParDAO {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;
    
	@SuppressWarnings("unchecked")
	public Par findByCd(String cd) {
		Query query =em.createQuery("from Par t where t.cd in (:cd)");
		query.setParameter("cd", cd);
		return (Par) query.getSingleResult();
	}
	
}
