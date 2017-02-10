package com.ric.bill.dao;

import java.util.List;

import com.ric.bill.model.bs.PeriodReports;


public interface ReportDAO {

	public List<PeriodReports> getPeriodsByCD(String repCd, int tp);
	
}
