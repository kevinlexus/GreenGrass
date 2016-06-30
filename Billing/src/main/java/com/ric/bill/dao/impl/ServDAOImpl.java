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
	 * Найти основную услугу по линии основная - ОДН
	 * @param serv - услуга ОДН
	 * @return
	 */
	@Cacheable(cacheNames="readOnlyCache", key="{ #serv.getId() }")
	public Serv findMain(Serv serv) {
		Query query =em.createQuery("from Serv t where t.odn=:serv");
		query.setParameter("serv", serv);
		return (Serv) query.getSingleResult();
	}

	/**
	 * Найти и отсортировать, все услуги для распределения объемов 
	 */
	@SuppressWarnings("unchecked")
	public List<Serv> findForDistVol() {
		Query query =em.createQuery("from Serv t where t.cd in (:s1,:s2,:s3,:s4,:s5) order by t.npp2");
		query.setParameter("s1", "Холодная вода (объем)");
		query.setParameter("s2", "Горячая вода, подогрев");
		query.setParameter("s3", "Водоотведение");
		query.setParameter("s4", "Отопление(объем)");
		query.setParameter("s5", "Электроснабжение (объем)");
		return query.getResultList();
	}

	/**
	 * Найти услугу по CD
	 * @param cd - услуги
	 * @return
	 */
	@Cacheable(cacheNames="readOnlyCache", key="{ #cd }")
	public Serv findByCd(String cd){
		Query query =em.createQuery("from Serv t where t.cd=:cd");
		query.setParameter("cd", cd);
		return (Serv) query.getSingleResult();
	}

}
