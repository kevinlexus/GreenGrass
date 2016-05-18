package com.ric.bill.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.ric.bill.dao.ParDAO;
import com.ric.bill.model.Par;


@Repository
public class ParDAOImpl implements ParDAO {

	protected EntityManager em;
	 
    public EntityManager getEntityManager() {
        return em;
    }
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }
    
	@SuppressWarnings("unchecked")
	public List<Par> findAll() {
		return em.createQuery("from Par").getResultList();
	}
}
