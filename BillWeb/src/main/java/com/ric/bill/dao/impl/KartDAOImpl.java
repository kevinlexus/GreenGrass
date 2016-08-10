package com.ric.bill.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ric.bill.dao.KartDAO;


@Repository
public class KartDAOImpl implements KartDAO {

    @PersistenceContext
    private EntityManager em;
    
	
}
