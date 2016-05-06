package com.ric.bill.dao;

import java.util.List;

import com.ric.bill.model.House;
import com.ric.bill.model.Meter;


public interface HouseDAO {


	public List<House> findAll();
}
