package com.mkyong.customer.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ric.bill.model.Meter;

@Service
public class CustomerDAOImpl implements CustomerDAO 
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public String sayHello() {
		return "Hello , This is CustomerDAO";
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Meter> findAll() {
		List<Meter> result = (List<Meter>) sessionFactory.getCurrentSession().createQuery(
				"select t from Meter t where t.id between 22380 and 22405").list();
		return result;
	}
	
}
