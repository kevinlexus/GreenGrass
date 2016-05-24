package com.ric.bill.mm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.Storable;
import com.ric.bill.dao.MeterLogDAO;
import com.ric.bill.dao.ParDAO;
import com.ric.bill.mm.common.MeterLogMng;
import com.ric.bill.mm.common.ParMng;
import com.ric.bill.model.bs.Par;
import com.ric.bill.model.mt.MeterLog;

@Service
public class MeterLogMngImpl extends BaseStore implements MeterLogMng {

	@Autowired
	private MeterLogDAO mDao;

    @Override
	public List<MeterLog> findByTp(Storable o, String tp) {
    	return mDao.findByTp(o, tp);
    }
}