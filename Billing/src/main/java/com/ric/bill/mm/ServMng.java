package com.ric.bill.mm;

import java.util.List;

import com.ric.bill.model.Serv;

public interface ServMng {
	
	public List<Serv> findAll();
	public List<Serv> findForChrg();
	public Serv getMetServ(Serv s);
	
}
