package com.ric.bill.dao.impl;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.dao.LstDAO;
import com.ric.bill.dao.PayordDAO;
import com.ric.bill.dao.PayordGrpDAO;
import com.ric.bill.dao.ReportDAO;
import com.ric.bill.dto.PayordDTO;
import com.ric.bill.dto.PeriodReportsDTO;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Par;
import com.ric.bill.model.bs.PeriodReports;
import com.ric.bill.model.fn.Payord;
import com.ric.bill.model.fn.PayordGrp;


@Repository
public class PayordGrpDAOImpl implements PayordGrpDAO {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

	// получить все платежки
    public List<PayordGrp> getPayordGrpAll() {
		Query query =em.createQuery("from PayordGrp t");
		return query.getResultList();
	}


}
