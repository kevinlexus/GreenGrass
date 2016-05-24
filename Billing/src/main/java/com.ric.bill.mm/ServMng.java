package com.ric.bill.mm;

import java.util.List;

import com.ric.bill.model.bs.Serv;

public interface ServMng extends Manage {
	
	public List<Serv> findAll();
	public List<Serv> findForChrg();
	
}
