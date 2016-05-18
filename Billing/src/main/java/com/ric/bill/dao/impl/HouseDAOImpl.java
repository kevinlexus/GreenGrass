package com.ric.bill.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ric.bill.dao.HouseDAO;
import com.ric.bill.model.House;


@Repository
public class HouseDAOImpl implements HouseDAO {

	protected EntityManager em;
	 
    public EntityManager getEntityManager() {
        return em;
    }
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }
    
	@SuppressWarnings("unchecked")
	public List<House> findAll() {
		return em.createQuery("from House t where t.klsk = 187804").getResultList();
	}
}
