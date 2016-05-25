package com.ric.bill.mm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.dao.HouseDAO;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.model.ar.House;

@Service
public class HouseMngImpl extends MeterStore implements HouseMng {

	@Autowired
	private HouseDAO hDao;

	@Transactional
	public List<House> findAll() {
		return hDao.findAll();
	}


}