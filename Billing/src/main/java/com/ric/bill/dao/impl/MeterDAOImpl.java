package com.ric.bill.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ric.bill.dao.MeterDAO;
import com.ric.bill.model.Meter;


@Service
public class MeterDAOImpl implements MeterDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Meter> findAll() {
		List<Meter> result = (List<Meter>) sessionFactory.getCurrentSession().createQuery(
				"select t from Meter t where t.klsk between 8796013 and 8796069").list();
		return result;
	}
}
