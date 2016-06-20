package com.ric.bill.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.ric.bill.dao.ServDAO;
import com.ric.bill.model.bs.Serv;


@Repository
public class ServDAOImpl implements ServDAO {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

    /**
	 * Найти все услуги
	 */
	@SuppressWarnings("unchecked")
	@Cacheable("readOnlyCache")
	public List<Serv> findAll() {
		Query query =em.createQuery("from Serv");
		return query.getResultList();
	}

	/**
	 * Найти основную услугу по линии основная - ОДН
	 * @param serv - услуга ОДН
	 * @return
	 */
	@Cacheable("readOnlyCache")
	public Serv findMain(Serv serv) {
		Query query =em.createQuery("from Serv t where t.odn=:serv");
		query.setParameter("serv", serv);
		return (Serv) query.getSingleResult();
	}

    /**
	 * Найти и отсортировать, все услуги для начисления 
	 */
	@SuppressWarnings("unchecked") //почему то если кэшировать в том же кэше - будет экспешн:
	@Cacheable("readOnlyCache2") //то происходит java.lang.ClassCastException: com.ric.bill.model.ar.House cannot be cast to com.ric.bill.model.bs.Serv
	public List<Serv> findForChrg() {
		Query query =em.createQuery("from Serv t where t.cd in (:s1,:s2,:s3,:s4,:s5) order by t.npp2");
		query.setParameter("s1", "Холодная вода (объем)");
		query.setParameter("s2", "Горячая вода, подогрев");
		query.setParameter("s3", "Водоотведение#");
		query.setParameter("s4", "Отопление(объем)#");
		query.setParameter("s5", "Электроснабжение (объем)");
		return query.getResultList();
	}

}
