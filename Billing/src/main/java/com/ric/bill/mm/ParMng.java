package com.ric.bill.mm;

import java.util.List;

import com.ric.bill.model.Par;

public interface ParMng {

	List<Par> findAll();

	boolean isExByCd(String cd);


}