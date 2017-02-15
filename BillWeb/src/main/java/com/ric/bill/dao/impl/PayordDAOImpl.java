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

import com.ric.bill.dao.LstDAO;
import com.ric.bill.dao.PayordDAO;
import com.ric.bill.dao.ReportDAO;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Par;
import com.ric.bill.model.bs.PeriodReports;
import com.ric.bill.model.fn.Payord;
import com.ric.web.PeriodReportsDTO;


@Repository
public class PayordDAOImpl implements PayordDAO {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

	public List<Payord> getPayOrdAll() {
		Query query =em.createQuery("from Payord t");
		return query.getResultList();
	}

}
