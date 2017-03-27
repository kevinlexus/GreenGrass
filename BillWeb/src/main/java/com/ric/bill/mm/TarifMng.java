package com.ric.bill.mm;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.ric.bill.Calc;
import com.ric.bill.TarifContains;
import com.ric.bill.model.ar.Area;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.fn.Chng;
import com.ric.bill.model.tr.Prop;
import com.ric.bill.model.tr.Serv;

public interface TarifMng {

	//public Prop getPropByCD(String cd);
	public Double getProp(int rqn, TarifContains tc, Serv serv, String cd, Date genDt);	
	public Org getOrg(int rqn, TarifContains tc, Serv serv, Date genDt);
	//public List<Serv> getAllServ(TarifContains tc);	
	//public int getServ(TarifContains tc, Serv serv, Date genDt); 	
	public Double getChngPrice(Calc calc, Serv serv, Date genDt);	
	public List<Area> getAreaAll();
}