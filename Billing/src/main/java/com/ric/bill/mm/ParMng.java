package com.ric.bill.mm;

import java.util.List;
import java.util.Set;

import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.model.Dw;
import com.ric.bill.model.House;
import com.ric.bill.model.Par;

public interface ParMng {

	List<Par> findAll();

	boolean isExByCd(String cd);


}