package com.ric.bill.mm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ric.bill.dao.PayordDAO;
import com.ric.bill.mm.PayordMng;
import com.ric.bill.model.fn.Payord;

@Service
public class PayordMngImpl implements PayordMng {

	@Autowired
	private PayordDAO payordDao;

	
	/**
	 * Получить все платежки
	 * @return
	 */
	public List<Payord> getPayordAll() {
		
		return payordDao.getPayOrdAll();
		
	}


}