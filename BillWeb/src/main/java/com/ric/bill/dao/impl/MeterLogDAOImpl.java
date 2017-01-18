package com.ric.bill.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.ric.bill.Calc;
import com.ric.bill.SumNodeVol;
import com.ric.bill.Storable;
import com.ric.bill.dao.MeterLogDAO;
import com.ric.bill.excp.NotFoundNode;
import com.ric.bill.excp.NotFoundODNLimit;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Par;
import com.ric.bill.model.mt.MLogs;
import com.ric.bill.model.mt.Meter;
import com.ric.bill.model.mt.MeterExs;
import com.ric.bill.model.mt.MeterLog;
import com.ric.bill.model.mt.MeterLogGraph;
import com.ric.bill.model.mt.Vol;


@Repository
public class MeterLogDAOImpl implements MeterLogDAO {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

	/**
	 * Получить лиц.счет, содержащий указанный счетчик (не стал возвращать интерфейс)
	 * @param mLog - Счетчик
	 * @return
	 */
	@Cacheable(cacheNames="rrr1", key="{ #mLog.getId() }") // не применяется RQN - счетчик ВСЕГДА должен смотреть на тот же лиц.счет!
	public synchronized Kart getKart(MLogs mLog) {
		Query query =em.createQuery("from Kart t where t.klsk =:klsk");
		query.setParameter("klsk", mLog.getKlskObj());
		try {
		  return (Kart) query.getSingleResult();
		} catch (NoResultException e) {
		  return null;
		} 
	}

}
