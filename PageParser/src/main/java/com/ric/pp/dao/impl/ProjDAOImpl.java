package com.ric.pp.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ric.pp.dao.ProjDAO;
import com.ric.pp.model.Proj;


@Repository
public class ProjDAOImpl implements ProjDAO {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

    /**
     * Добавить проект в хранилище
     */
    public void addProj(Proj proj) {
		em.persist(proj);
	}

	public Proj getProjByOuterId(Integer id) {
		Query query =em.createQuery("from Proj t where t.outerId=:id");
		query.setParameter("id", id);
		Proj proj = null;
		try {
		  proj = (Proj) query.getSingleResult();
		} catch (NoResultException e) {
		  return null;	
		}
		return proj;
	}

    
}
