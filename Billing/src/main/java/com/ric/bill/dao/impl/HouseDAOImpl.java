package com.ric.bill.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.ric.bill.dao.HouseDAO;
import com.ric.bill.model.ar.House;


/*@NamedStoredProcedureQuery(
		name = "getReviews", 
		procedureName = "get_reviews", 
		resultClasses = House.class, 
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class), 
			@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class)
		}
	)*/
@Repository
public class HouseDAOImpl implements HouseDAO {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;
    
	
	public List<House> findAll() {
		return em.createQuery("select t from House t "
				+ " "
				+ "where t.klsk = 187804").getResultList();

	}

}
