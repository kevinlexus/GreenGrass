package com.ric.bill.dao.impl;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.ric.web.PeriodReportsWeb;


@Repository
public class ReportDAOImpl implements ReportDAO {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

    /**
     * Получить периоды отчета для Web-интерфейса
     * param repCd - CD отчета
     * param tp - 0-Выбрать дни, 1-Выбрать месяцы 	 
     */
    @Override
	public List<PeriodReportsWeb> getPeriodsByCD(String cd, int tp) {
    	List<PeriodReportsWeb> lst = new ArrayList<PeriodReportsWeb>(0);
    	List<PeriodReports> lst2 = null;
		Query query = null;
		if (tp==0) {
			query = em.createQuery("select t from PeriodReports t join t.report r where r.cd in (:cd) and t.mg is not null");
			query.setParameter("cd", cd);
			 lst2 = query.getResultList();
			lst2.stream().forEach(t -> lst.add(new PeriodReportsWeb(t.getId(), t.getMg().substring(0, 4)+"."+t.getMg().substring(4, 6))));
				
		} else if (tp==1) {
			query = em.createQuery("select t from PeriodReports t join t.report r where r.cd in (:cd) and t.dt is not null");
			query.setParameter("cd", cd);
			lst2 = query.getResultList();
			Format formatter = new SimpleDateFormat("dd.MM.yyyy");
			lst2.stream().forEach(t -> lst.add(new PeriodReportsWeb(t.getId(), formatter.format(t.getDt())
					   )));
		}
		return lst;
	}

}
