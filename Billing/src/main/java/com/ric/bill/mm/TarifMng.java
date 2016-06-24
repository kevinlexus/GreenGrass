package com.ric.bill.mm;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.ric.bill.TarifContains;
import com.ric.bill.model.bs.Serv;

public interface TarifMng {

	public Double findProp(TarifContains tc, Serv serv, String cd, Date genDt);	
	public Set<Serv> getAllServ(TarifContains tc, Date genDt);
}