package com.ric.bill.mm.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.BillServ;
import com.ric.bill.Calc;
import com.ric.bill.dao.HouseDAO;
import com.ric.bill.dao.ServDAO;
import com.ric.bill.excp.EmptyServ;
import com.ric.bill.excp.NotFoundUpperLevel;
import com.ric.bill.excp.TooManyRecursiveCalls;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.ServMng;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.ar.Kw;
import com.ric.bill.model.bs.Dw;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.tr.Serv;
import com.ric.bill.model.tr.ServTree;

@Service
public class ServMngImpl implements ServMng {

	@Autowired
	private ServDAO sDao;

	@Autowired
	private LstMng lstMng;
	
    @PersistenceContext
    private EntityManager em;
	
	//да, да, кэш на уровне DAO! (быстрее работает)
	//@Cacheable(cacheNames="readOnlyCache", key="{ #serv.getId() }") 
	public /*synchronized */Serv findMain(Serv serv) {
		return sDao.findMain(serv);
	}

	//@Cacheable(cacheNames="readOnlyCache")
	public /*synchronized */List<Serv> findForDistVol() {
		return sDao.findForDistVol();
	}

	public /*synchronized */List<Serv> findForDistVolForKart() {
		return sDao.findForDistVolForKart();
	}

	//@Cacheable(cacheNames="readOnlyCache", key="{ #cd }")
	public /*synchronized */Serv getByCD(String cd) {
		return sDao.getByCD(cd);
	}

	/**
	 * Найти наиболее верхнюю по иерархии услугу, кроме "000"
	 * @param serv - текущая услуга
	 * @tp - тип иерархии, например "serv_tree_kassa"
	 * @return - искомая услуга
	 * @throws TooManyRecursiveCalls 
	 * @throws NotFoundUpperLevel 
	 */
	@Cacheable(cacheNames="neverWipe", key="{ #serv.getId(), #tp }")
	public /*synchronized */Serv getUpper(Serv serv, String tp) throws TooManyRecursiveCalls, NotFoundUpperLevel {
		Lst tpTree = lstMng.getByCD(tp);
		for(ServTree rec : serv.getServTree()) {
			if (rec.getTp().equals(tpTree) && rec.getServ().equals(serv)) {
				return getUpperTree(rec, tpTree.getCd(), 0).getServ();
			}
		}
		throw new NotFoundUpperLevel("По услуге id="+serv.getId()+" не найден верхний уровень!");
	}

	/**
	 * Рекурсивная функция, поиск самой верхней записи в указанной иерархии
	 * @param servTree - текущий уровень
	 * @param tp - тип иерархии, например "serv_tree_kassa"
	 * @return - искомая запись
	 * @throws TooManyRecursiveCalls 
	 */
	@Cacheable(cacheNames="neverWipe", key="{ #servTree.getId(), #tp }")
	public /*synchronized*/ ServTree getUpperTree(ServTree servTree, String tp, int itr) throws TooManyRecursiveCalls {
		itr++;
		if (itr > 1000) {
			throw new TooManyRecursiveCalls("На записи иерархии id="+servTree.getId()+" обнаружено превышение числа рекурсий");
		}
		Integer parentId = servTree.getParent().getId();
		//если нет parent_id, значит найден уровень, (вернуть предыдущий уровень)
		if (parentId == null) {
			return servTree;
		}
		
		ServTree st = em.find(ServTree.class, parentId);
		//если на уровне услуга 000, значит найден уровень, (вернуть предыдущий уровень)
		if (st == null || st.getServ().getCd().equals("000")) {
			return servTree;
		}
		//не найдено, продолжить поиск
		return getUpperTree(st, tp, itr);
	}

	/*
	 * Получить все услуги
	 * 
	 */
	public List<Serv> getServAll() {
		return sDao.getServAll();
	}
	
}