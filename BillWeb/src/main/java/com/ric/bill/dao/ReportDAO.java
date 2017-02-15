package com.ric.bill.dao;

import java.util.List;

import com.ric.bill.model.bs.PeriodReports;
import com.ric.web.PeriodReportsDTO;


public interface ReportDAO {

	public List<PeriodReportsDTO> getPeriodsByCD(String repCd, int tp);
	
}
