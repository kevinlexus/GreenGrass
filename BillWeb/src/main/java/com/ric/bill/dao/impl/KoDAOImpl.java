package com.ric.bill.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ric.bill.dao.KoDAO;
import com.ric.bill.model.oralv.Ko;


@Repository
public class KoDAOImpl implements KoDAO {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

    /**
     * Получить объект Klsk по klsk 
     */
	public Ko getByKlsk(Integer klsk) {
		Query query =em.createQuery("select t from Klsk t where t.id = :klsk");
		query.setParameter("klsk", klsk);
		return (Ko)query.getSingleResult();
	}

}
