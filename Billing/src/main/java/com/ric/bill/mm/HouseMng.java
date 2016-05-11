package com.ric.bill.mm;

import java.util.List;
import java.util.Set;

import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.model.Dw;
import com.ric.bill.model.House;

public interface HouseMng {

	List<House> findAll();

	Double getDbl(Set<Dw> dw, String cd) throws WrongGetMethod;


}