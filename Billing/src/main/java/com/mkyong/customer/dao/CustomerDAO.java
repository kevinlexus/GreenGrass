package com.mkyong.customer.dao;

import java.util.List;

import com.ric.bill.model.Meter;

public interface CustomerDAO {

	public String sayHello();
	public List<Meter> findAll();
}
