package com.ric.bill.mm.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.BillServ;
import com.ric.bill.dao.HouseDAO;
import com.ric.bill.dao.LstDAO;
import com.ric.bill.dao.ReportDAO;
import com.ric.bill.dao.ServDAO;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.ReportMng;
import com.ric.bill.mm.ServMng;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.ar.Kw;
import com.ric.bill.model.bs.Dw;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.tr.Serv;
import com.ric.web.PeriodReportsWeb;

@Service
public class ReportMngImpl implements ReportMng {

	@Autowired
	private ReportDAO reportDao;

	
	/**
	 * Получить периоды отчета
	 * @param cd - CD отчета
	 * @param tp - 0-Выбрать дни, 1-Выбрать месяцы 	 
	 * @return
	 */
	public List<PeriodReportsWeb> getPeriodsByCD(String repCd, int tp) {
		
		return reportDao.getPeriodsByCD(repCd, tp);
		
	}


}