package com.ric.bill.dao;

import java.util.List;

import com.ric.bill.model.bs.PeriodReports;
import com.ric.web.PeriodReportsWeb;


public interface ReportDAO {

	public List<PeriodReportsWeb> getPeriodsByCD(String repCd, int tp);
	
}
