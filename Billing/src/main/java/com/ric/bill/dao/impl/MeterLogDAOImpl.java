package com.ric.bill.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.ric.bill.Calc;
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

    /**
     * удалить рекурсивно все объемы по всем счетчикам начиная с указанного
     * @param mLog - начальный счетчик
     * @param tp - тип расчета
     * @return 
     */
	public void delNodeVol(MeterLog mLog, int tp) {
		for (Vol v : mLog.getVol()) {
			em.remove(v);
		}
		//найти все направления, с необходимым типом, указывающие в точку из других узлов, удалить их объемы рекурсивно
		for (MeterLogGraph g : mLog.getInside()) {
			if (tp==0 && g.getTp().getCd().equals("Расчетная связь") 
					 || tp==1 && g.getTp().getCd().equals("Связь по площади и кол-во прож.")
					 || tp==2 && g.getTp().getCd().equals("Расчетная связь ОДН")
					 || tp==3 && g.getTp().getCd().equals("Расчетная связь пропорц.площади")) {
						delNodeVol(g.getSrc(), tp);
			}
		}
	}
    
	/**
	 * Вернуть логический счетчик определенного типа, связанный с заданным
	 * Если связано несколько - будет возвращён первый
	 * @param mLog - тестируемый лог.счетчик
	 * @param tp - тип счетчика
	 * @return лог.счетчик
	 */
	
	public MeterLog getLinkedNode (MeterLog mLog, String tp) throws NotFoundNode {
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
		return lnkMLog;
	}
	
	/**
	 * Получить объем по связанному прямой связью счетчику за период и сам этот счетчик
	 * @param lnVol - заполняемый объемами объект
	 * @param mLog - лог.счетчик
	 * @throws NotFoundNode - если не найден счетчик (узел)
	 */
	
    public LinkedNodeVol getVolPeriod (MeterLog mLog) {
    	LinkedNodeVol lnkVol = new LinkedNodeVol();
    	//период будет опеределён фильтром FILTER_GEN_DT_INNER
    	//так что, простая итерация
    	for (Vol v: mLog.getVol()) {
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

}
