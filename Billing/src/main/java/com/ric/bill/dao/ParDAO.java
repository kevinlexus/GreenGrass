package com.ric.bill.dao;

import java.util.List;

import com.ric.bill.model.ar.House;
import com.ric.bill.model.bs.Par;


public interface ParDAO {


	public Par findByCd(String cd);
}
