package com.ric.bill.mm;

import java.util.List;

import com.ric.bill.model.bs.Serv;

public interface ServMng extends StorableMng {
	
	public List<Serv> findAll();
	public Serv findMain(Serv serv);
	public List<Serv> findForChrg();
	
}
