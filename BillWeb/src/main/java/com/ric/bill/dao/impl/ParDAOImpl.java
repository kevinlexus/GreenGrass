package com.ric.bill.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.dao.ParDAO;
import com.ric.bill.excp.ErrorWhileDist;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Par;


@Repository
public class ParDAOImpl implements ParDAO {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;
    
	@SuppressWarnings("unchecked")
	//@Cacheable(cacheNames="rrr1", key="{ #cd }")
	@Cacheable(cacheNames="rrr1")
	public synchronized Par getByCd(String cd) {
		Query query =em.createQuery("from Par t where t.cd = :cd");
		query.setParameter("cd", cd);
		return (Par) query.getSingleResult();
	}

	//работает это медленнее чем была итерация по всем параметрам объекта!
	//@Cacheable(cacheNames="rrr1", key="{ #id, #cd, #dataTp }")
	@Cacheable(cacheNames="rrr1")
	public synchronized boolean checkPar(int id, String cd, String dataTp) {
		Query query =em.createQuery("from Par t where t.id = :id and t.cd=:cd and t.dataTp=:dataTp");
		query.setParameter("id", id);
		query.setParameter("cd", cd);
		query.setParameter("dataTp", dataTp);
		try {
			Par p = (Par) query.getSingleResult();
		} catch (NoResultException e) {
			return false;
		}
		return true;
	}
	
}
