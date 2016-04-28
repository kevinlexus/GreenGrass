package com.ric.bill.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.dao.MeterDao;
import com.ric.bill.model.Meter;


@Service
public class MeterDaoImpl implements MeterDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Meter> findAll() {
		List<Meter> result = (List<Meter>) sessionFactory.getCurrentSession().createQuery(
				"select t from Meter t where t.id between 22380 and 22405").list();
		return result;
	}
}
