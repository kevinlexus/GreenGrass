package com.mkyong.customer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.customer.dao.CustomerDAO;
import com.ric.bill.model.Meter;

@Service
public class CustomerServiceImpl implements CustomerService  
{
	@Autowired
	CustomerDAO customerDAO;

	public String sayHello() {
		// TODO Auto-generated method stub
		return "CustomerService customerDAO=" + customerDAO.sayHello();
	}
	
	@Transactional
	public List<Meter> showAll() {
		return customerDAO.findAll();
	}
	
		
}
