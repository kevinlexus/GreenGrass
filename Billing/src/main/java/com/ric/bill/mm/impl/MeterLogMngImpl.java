package com.ric.bill.mm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.LinkedNodeVol;
import com.ric.bill.Storable;
import com.ric.bill.dao.MeterLogDAO;
import com.ric.bill.dao.ParDAO;
import com.ric.bill.excp.NotFoundNode;
import com.ric.bill.mm.MeterLogMng;
import com.ric.bill.mm.ParMng;
import com.ric.bill.model.bs.Par;
import com.ric.bill.model.mt.MeterLog;

@Service
public class MeterLogMngImpl extends BaseStore implements MeterLogMng {

	@Autowired
	private MeterLogDAO mDao;

    public List<MeterLog> findByTp(Storable o, String tp) {
    	return mDao.findByTp(o, tp);
    }

	public LinkedNodeVol getVolPeriod(MeterLog mLog, String tp)
			throws NotFoundNode {
		return mDao.getVolPeriod(mLog, tp);
	}

	public void delNodeVol(MeterLog ml, int tp) {
		mDao.delNodeVol(ml, tp);
	}
}