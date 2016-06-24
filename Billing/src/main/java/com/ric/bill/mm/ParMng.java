package com.ric.bill.mm;

import java.util.Date;
import java.util.List;

import com.ric.bill.Storable;
import com.ric.bill.model.bs.Par;

public interface ParMng {

	public List<Par> findAll();
	boolean isExByCd(String cd);
	public Double getDbl(Storable st, String cd);
	public String getStr(Storable st, String cd);
	

}