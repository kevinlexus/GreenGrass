package com.ric.bill.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ric.bill.Storable;
import com.ric.bill.dao.MeterLogDAO;
import com.ric.bill.model.MeterLog;


@Repository
public class MeterLogDAOImpl implements MeterLogDAO {

	// EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

	/**
	 * Найти определенный тип счетчиков, принадлежащий объекту 
	 * РАБОТАЕТ МЕДЛЕННО! ЗАКОММЕНТИРОВАЛ
	 * @param BaseStore - объект
	 * @param tp - тип счетчика
	 * @return
	 */
    @SuppressWarnings("unchecked")
	@Override
	public List<MeterLog> findByTp(Storable o, String tp) {
    	/*Query query =em.createQuery("select m from MeterLog m "
				+ "join Lst s on m.fkTp=s.id and s.cd=:tp "
				+ "join LstTp tp on s.fkTp=tp.id and tp.cd=:tp2 "
				+ "where m.klskObj = :id ");
		query.setParameter("id", o.getKlsk());
		query.setParameter("tp", tp);
		query.setParameter("tp2", "U_METER_LOG_TP");
		query.setHint("org.hibernate.cacheable", Boolean.TRUE);
		return query.getResultList();*/
		return null;
    }

}
