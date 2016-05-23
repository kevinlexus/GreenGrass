package com.ric.bill.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ric.bill.dao.HouseDAO;
import com.ric.bill.model.ar.House;


@Repository
public class HouseDAOImpl implements HouseDAO {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;
    
	@SuppressWarnings("unchecked")
	public List<House> findAll() {
		return em.createQuery("from House t where t.klsk = 187804").getResultList();
	}

	
}
