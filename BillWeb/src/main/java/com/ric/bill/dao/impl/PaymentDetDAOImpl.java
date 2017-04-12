package com.ric.bill.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ric.bill.dao.PaymentDetDAO;
import com.ric.bill.model.cash.PaymentDet;


@Repository
public class PaymentDetDAOImpl implements PaymentDetDAO {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

    /**
	 * Получить все платежи за выбранный период 
	 * @param period - период
	 */
	public List<PaymentDet> getPaymentDetByPeriod(String period) {
		Query query =em.createQuery("select t from PaymentDet t where t.period = :period");
		query.setParameter("payordGrpId", period);
		return query.getResultList();
	}



}
