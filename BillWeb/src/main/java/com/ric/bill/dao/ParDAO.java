package com.ric.bill.dao;

import com.ric.bill.Calc;
import com.ric.bill.model.bs.Par;


public interface ParDAO {


	public Par getByCd(Calc calc, String cd);

	public boolean checkPar(int id, String cd, String dataTp);
}
