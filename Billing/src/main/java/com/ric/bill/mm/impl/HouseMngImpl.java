package com.ric.bill.mm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.dao.HouseDAO;
import com.ric.bill.dao.MeterDAO;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.MeterMng;
import com.ric.bill.model.House;
import com.ric.bill.model.Meter;

@Service
public class HouseMngImpl implements HouseMng {

  @Autowired
  private HouseDAO hDao;
  
  @Override
  @Transactional
  public List<House> findAll() {
    return hDao.findAll();
  }

}