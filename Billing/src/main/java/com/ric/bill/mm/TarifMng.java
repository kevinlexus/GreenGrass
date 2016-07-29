package com.ric.bill.mm;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.ric.bill.TarifContains;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.tr.Prop;

public interface TarifMng {

	public Prop getPropByCD(String cd);
	public Double getProp(TarifContains tc, Serv serv, String cd, Date genDt);	
	public Org getOrg(TarifContains tc, Serv serv, Date genDt);
	public List<Serv> getAllServ(TarifContains tc);	
	public boolean getServ(TarifContains tc, Serv serv, Date genDt); 	
}