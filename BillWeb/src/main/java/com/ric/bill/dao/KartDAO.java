package com.ric.bill.dao;

import java.util.List;

import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;


public interface KartDAO {

	public List<Kart> findAll(Integer houseId, Integer areaId);
	
}
