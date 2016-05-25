package com.ric.bill.mm;

import java.util.List;

import com.ric.bill.model.bs.Par;

public interface ParMng {

	public List<Par> findAll();
	boolean isExByCd(String cd);

}