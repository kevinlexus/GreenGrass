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

	public Double getProp(Calc calc, int rqn, TarifContains tc, Serv serv, String cd, Date genDt);	
	public Org getOrg(Calc calc, int rqn, TarifContains tc, Serv serv, Date genDt);
	public Double getChngPrice(Calc calc, Serv serv, Date genDt);	
	public List<Area> getAreaAll();
}