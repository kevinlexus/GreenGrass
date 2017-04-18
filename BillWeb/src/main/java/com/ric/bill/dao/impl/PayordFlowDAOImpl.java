package com.ric.bill.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ric.bill.dao.PayordFlowDAO;
import com.ric.bill.model.fn.PayordFlow;


@Repository
public class PayordFlowDAOImpl implements PayordFlowDAO {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

    /**
     * Получить движение по платежке, до определенной даты
     */
    public List<PayordFlow> getPayordFlowBeforeDt(Integer payordId, Integer tp, Date dt) {
		Query query =em.createQuery("select t from PayordFlow t join t.payord p where p.id = :payordId "
				+ "and t.dt <= :dt and t.tp = :tp "
				+ "order by t.dt desc");
		query.setParameter("payordId", payordId);
		query.setParameter("dt", dt);
		query.setParameter("tp", tp);
		return query.getResultList();
	}

    /**
     * Получить движение по платежке, до определенного периода даты (напр.для вычисления сальдо)
     */
    public List<PayordFlow> getPayordFlowBeforePeriod(Integer payordId, Integer tp, String period) {
		Query query =em.createQuery("select t from PayordFlow t join t.payord p where p.id = :payordId "
				+ "and t.period <= :period and t.tp = :tp "
				+ "order by t.period desc");
		query.setParameter("payordId", payordId);
		query.setParameter("period", period);
		query.setParameter("tp", tp);
		return query.getResultList();
	}

    
}