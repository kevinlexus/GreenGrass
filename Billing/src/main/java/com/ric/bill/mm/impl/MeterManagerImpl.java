package com.ric.bill.mm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.dao.MeterDAO;
import com.ric.bill.mm.MeterManager;
import com.ric.bill.model.Meter;

@Service
public class MeterManagerImpl implements MeterManager {

  @Autowired
  private MeterDAO mDao;
  
  @Override
  @Transactional
  public List<Meter> findAll() {
    return mDao.findAll();
  }

}