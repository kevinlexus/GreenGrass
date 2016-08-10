package com.ric.bill.mm;

import java.util.List;

import com.ric.bill.model.bs.Serv;

public interface ServMng {
	
	public Serv findMain(Serv serv);
	public List<Serv> findForDistVol();
	public Serv findByCd(String cd);
	
}
