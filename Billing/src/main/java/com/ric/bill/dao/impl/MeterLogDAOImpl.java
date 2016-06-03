package com.ric.bill.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ric.bill.LinkedNodeVol;
import com.ric.bill.Storable;
import com.ric.bill.dao.MeterLogDAO;
import com.ric.bill.excp.NotFoundNode;
import com.ric.bill.model.mt.MeterLog;
import com.ric.bill.model.mt.MeterLogGraph;
import com.ric.bill.model.mt.Vol;


@Repository
public class MeterLogDAOImpl implements MeterLogDAO {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

    
    
	//удалить объемы определённого типа по данному счетчику и всем дочерним 
	public delAllVols(Lst tp) {
		//TODO!
		
	}
    
	/**
	 * Получить объем по связанному прямой связью счетчику за период и сам этот счетчик
	 * @param lnVol - заполняемый объемами объект
	 * @param mLog - лог.счетчик
	 */
    public LinkedNodeVol getVolPeriod (MeterLog mLog, String tp) throws NotFoundNode {
    	LinkedNodeVol lnkVol = new LinkedNodeVol();
    	MeterLog lnkMLog = null;
    	//найти прямую связь (направленную внутрь или наружу, не важно) указанного счетчика со счетчиком указанного типа 
    	//сперва направленные внутрь
    	for (MeterLogGraph g : mLog.getInside()) {
    		if (g.getSrc().getTp().getCd().equals(tp)) {
    			//найдено
    			lnkMLog = g.getSrc();
    			break;
    		}
    	}
    	//потом направленные наружу, если не найдено
    	if (lnkMLog == null) {
	    	for (MeterLogGraph g : mLog.getOutside()) {
	    		if (g.getDst().getTp().getCd().equals(tp)) {
	    			//найдено
	    			lnkMLog = g.getSrc();
	    			break;
	    		}
	    	}
		}
    	//если не найден счетчик
    	if (lnkMLog == null) {
    		throw new NotFoundNode("Не найден узел с типом "+tp+" , присоединенный к узлу MeterLog.id="+mLog.getId());
    	}
    	
    	//сохранить найденный счетчик
    	lnkVol.setLnkMLog(lnkMLog);
    	
    	//период будет опеределён фильтром FILTER_GEN_DT_INNER
    	//так что, простая итерация
    	for (Vol v: lnkMLog.getVol()) {
    		if (v.getTp().getCd().equals("Фактический объем") ){
    			lnkVol.addVol(v.getVol1());
    		} else if (v.getTp().getCd().equals("Площадь и проживающие") ){
    			lnkVol.addArea(v.getVol1());
    			lnkVol.addPers(v.getVol2());
    		} else if (v.getTp().getCd().equals("Лимит ОДН") ){
    			lnkVol.addPers(v.getVol1());
    		}
    	}
		return lnkVol;
	}
    
    /**
	 * Найти определенный тип счетчиков, принадлежащий объекту 
	 * РАБОТАЕТ МЕДЛЕННО! ЗАКОММЕНТИРОВАЛ
	 * @param BaseStore - объект
	 * @param tp - тип счетчика
	 * @return
	 */
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
