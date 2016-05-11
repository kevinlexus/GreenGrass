package com.ric.bill.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ric.bill.dao.HouseDAO;
import com.ric.bill.model.House;


@Service
public class HouseDAOImpl implements HouseDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<House> findAll() {
		List<House> result = (List<House>) sessionFactory.getCurrentSession().createQuery(
				"select t from House t where t.klsk = 187025").list();
		return result;
	}
}
