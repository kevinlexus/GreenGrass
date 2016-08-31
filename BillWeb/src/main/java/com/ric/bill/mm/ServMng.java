package com.ric.bill.mm;

import java.util.List;

import com.ric.bill.excp.TooManyRecursiveCalls;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.tr.ServTree;

public interface ServMng {
	
	public Serv findMain(Serv serv);
	public List<Serv> findForDistVol();
	public Serv getByCD(String cd);
	public Serv getUpper(Serv serv, String tp) throws TooManyRecursiveCalls;
	public ServTree getUpperTree(ServTree servTree, String tp, int itr) throws TooManyRecursiveCalls;	
}
