package com.ric.bill.dao;

import java.util.List;

import com.ric.bill.model.fn.Payord;
import com.ric.web.PayordDTO;


public interface PayordDAO {

	public List<Payord> getPayordAll();
	
}
