package com.ric.bill.dao;

import java.util.Date;
import java.util.List;

import com.ric.bill.model.fn.PayordFlow;


public interface PayordFlowDAO {

	public List<PayordFlow> getPayordFlowBeforeDt(Integer payordId, Integer tp, Date dt);
	
}
