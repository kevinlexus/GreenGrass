package com.mkyong.customer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.customer.dao.CustomerDAO;
import com.ric.bill.model.Meter;

public interface CustomerService 
{
	public String sayHello();
	
	public List<Meter> showAll();
	
		
}
