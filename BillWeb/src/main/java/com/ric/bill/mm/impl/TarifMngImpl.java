package com.ric.bill.mm.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.Calc;
import com.ric.bill.TarifContains;
import com.ric.bill.Utl;
import com.ric.bill.dao.KartDAO;
import com.ric.bill.dao.TarifDAO;
import com.ric.bill.mm.TarifMng;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.bs.Par;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.tr.Prop;
import com.ric.bill.model.tr.TarifKlsk;
import com.ric.bill.model.tr.TarifServ;
import com.ric.bill.model.tr.TarifServOrg;
import com.ric.bill.model.tr.TarifServProp;

/**
 * Сервис работы с тарифами
 * @author lev
 *
 */
@Service
public class TarifMngImpl implements TarifMng {
	
	@Autowired
	private TarifDAO tDao;

    
	//получить свойство тарифа по его CD
	//@Cacheable(cacheNames="readOnlyCache", key="{ #cd }") - здесь не кэшируется, только в DAO
	public synchronized Prop getPropByCD(String cd) {
		return tDao.getPropByCD(cd);
	}

	/**
	 * Получить значение типа Double тарифа по CD 
	 * @param tc - объект
	 * @param cd - код свойства
	 * @return - свойство
	 */
	//@Cacheable(cacheNames="readOnlyCache", key="{ #tc.getKlsk(), #serv.getId(), #cd, #genDt }") 
	public synchronized Double getProp(TarifContains tc, Serv serv, String cd, Date genDt) {
		//Prop prop = getPropByCD(cd);//так и не понял, как быстрее, искать тариф предварительно getPropByCD, или непосредственно через.getCd()
		//искать сперва по наборам тарифа объекта 
		for (TarifKlsk k : tc.getTarifklsk()) {
			//по соотв.периоду
			if (Utl.between(genDt, k.getDt1(), k.getDt2())) {
				//затем по строкам - составляющим тариф 
				for (TarifServProp t : k.getTarprop()) {
					if (t.getServ().equals(serv) && t.getProp().getCd().equals(cd)) {
					//if (t.getServ().equals(serv) && t.getProp().equals(prop)) { //так и не понял, как быстрее, искать тариф предварительно getPropByCD, или непосредственно через.getCd() 
						return t.getN1();
					}
				}
			}
		}
		return null;
		
	}

	/**
	 * Получить организацию по услуге в тарифе 
	 * @param tc - объект
	 * @param cd - код свойства
	 * @return - свойство
	 */
	//@Cacheable(cacheNames="rrr1", key="{ #tc.getKlsk(), #serv.getId(), #genDt }") 
	//@Cacheable(cacheNames="rrr1") 
	public synchronized Org getOrg(TarifContains tc, Serv serv, Date genDt) {

		//искать сперва по наборам тарифа объекта 
		for (TarifKlsk k : tc.getTarifklsk()) {
			//по соотв.периоду
			if (Utl.between(genDt, k.getDt1(), k.getDt2())) {
				//затем по строкам - составляющим тариф 
				for (TarifServOrg t : k.getTarifservorg()) {
					if (t.getServ().equals(serv)) {
						return t.getOrg();
					}
				}
			}
		}
		return null;
		
	}

	/**
	 * Получить список всех услуг по тарифу данного объекта по всем датам
	 * @param tc - объект
	 * @return
	 */
	//@Cacheable(cacheNames="rrr1", key="{ #tc.getKlsk() }") 
	@Cacheable(cacheNames="rrr1") 
	public synchronized List<Serv> getAllServ(TarifContains tc) {
		List<Serv> lst = new ArrayList<Serv>();
		//искать сперва по наборам тарифа объекта 
		for (TarifKlsk k : tc.getTarifklsk()) {
			//по соотв.периоду - сделал по всем датам, так как не понятно, как их фильтровать
			//if (Utl.between(dt1, k.getDt1(), k.getDt2())) {
				//затем по строкам - составляющим тариф 
				for (TarifServ t : k.getTarserv()) {
					lst.add(t.getServ());
				}
			//}
		}
		return lst;
	}
	
	/**
	 * Получить наличие услуги по тарифу данного объекта на заданную дату
	 * @param tc - объект
	 * @param genDt - дата выборки
	 * @param genDt - дата выборки
	 * @return
	 */
	@Cacheable(cacheNames="rrr1", key="{ #tc.getKlsk(), #serv.getId(), #genDt }") 
	public synchronized boolean getServ(TarifContains tc, Serv serv, Date genDt) {
		List<Serv> lst = new ArrayList<Serv>();
		//искать сперва по наборам тарифа объекта 
		for (TarifKlsk k : tc.getTarifklsk()) {
			//по соотв.периоду
			if (Utl.between(genDt, k.getDt1(), k.getDt2())) {
				//затем по строкам - составляющим тариф 
				for (TarifServ t : k.getTarserv()) {
					if (t.getServ().equals(serv)) {
						if (Utl.nvl(k.getAct(), 1) == 1) {
							return true;
						} else {
							return false;
						}
					}
				}
			}
		}
		return false;
	}
	
}
