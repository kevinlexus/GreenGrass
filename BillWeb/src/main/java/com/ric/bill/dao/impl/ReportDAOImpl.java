package com.ric.bill.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.ric.bill.dao.LstDAO;
import com.ric.bill.dao.ReportDAO;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.PeriodReports;


@Repository
public class ReportDAOImpl implements ReportDAO {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

    /**
     * Получить периоды отчета
     * param repCd - CD отчета
     * param tp - 0-Выбрать дни, 1-Выбрать месяцы 	 
     */
    @Override
	public List<PeriodReports> getPeriodsByCD(String cd, int tp) {

    	//Query query =em.createQuery("select t from Ulist t join t.ulistTp tp where tp.grp=:grp and tp.id=:id");

    	Query query =em.createQuery("select t from PeriodReports t join t.report r where r.cd in (:cd)");
		query.setParameter("cd", cd);
		return query.getResultList();
	}

}
