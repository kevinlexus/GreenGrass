package com.ric.bill.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ric.bill.dao.HouseDAO;
import com.ric.bill.dao.ParDAO;
import com.ric.bill.model.House;
import com.ric.bill.model.Par;


@Repository
public class ParDAOImpl implements ParDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Par> findAll() {
		List<Par> result = (List<Par>) sessionFactory.getCurrentSession().createQuery(
				"select t from Par t").list();
		return result;
	}
}
