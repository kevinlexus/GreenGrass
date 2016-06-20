package com.ric.bill.mm;

import java.util.List;

import com.ric.bill.TarifContains;
import com.ric.bill.model.bs.Serv;

public interface TarifMng {

	public Double findProp(TarifContains tc, Serv serv, String cd);	

}