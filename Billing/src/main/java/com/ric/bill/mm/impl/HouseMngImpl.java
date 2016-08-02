package com.ric.bill.mm.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.dao.HouseDAO;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.model.ar.House;

@Service
public class HouseMngImpl implements HouseMng {


    @Autowired
	private HouseDAO hDao;

    public synchronized List<House> findAll() {
		return hDao.findAll();
	}


}