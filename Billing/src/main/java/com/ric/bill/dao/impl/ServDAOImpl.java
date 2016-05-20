package com.ric.bill.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ric.bill.dao.ServDAO;
import com.ric.bill.model.bs.Serv;


@Repository
public class ServDAOImpl implements ServDAO {

	// EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

    /**
	 * Найти все услуги
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Serv> findAll() {
		Query query =em.createQuery("from Serv");
		return query.getResultList();
	}

	/**
	 * Найти и отсортировать, все услуги для начисления 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Serv> findForChrg() {
		Query query =em.createQuery("from Serv t where t.cd in (:s1,:s2,:s3,:s4,:s5) order by t.npp2 ");
		query.setParameter("s1", "Холодная вода (объем)#");
		query.setParameter("s2", "Горячая вода, подогрев");
		query.setParameter("s3", "Водоотведение#");
		query.setParameter("s4", "Отопление(объем)#");
		query.setParameter("s5", "Электроснабжение (объем)#");
		return query.getResultList();
	}

	/**
	 * Получить услугу, ссылающуюся на счетчик
	 */
	@Override
	public Serv getMetServ(Serv s) {
		Query query =em.createQuery("from Serv t where t.id = :id");
		query.setParameter("id",s.getMet());
		return (Serv) query.getSingleResult();
	}

	/**
	 * Получить услугу, ссылающуюся на счетчик ОДН
	 */
	@Override
	public Serv getOdnServ(Serv s) {
		Query query =em.createQuery("from Serv t where t.id = :id");
		query.setParameter("id",s.getOdn());
		return (Serv) query.getSingleResult();
	}
}