package com.ric.bill.mm.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.Calc;
import com.ric.bill.MeterContains;
import com.ric.bill.SumNodeVol;
import com.ric.bill.Storable;
import com.ric.bill.Utl;
import com.ric.bill.dao.MeterLogDAO;
import com.ric.bill.dao.ParDAO;
import com.ric.bill.excp.NotFoundNode;
import com.ric.bill.mm.MeterLogMng;
import com.ric.bill.mm.ParMng;
import com.ric.bill.model.bs.Par;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.mt.MLogs;
import com.ric.bill.model.mt.Meter;
import com.ric.bill.model.mt.MeterExs;
import com.ric.bill.model.mt.MeterLog;
import com.ric.bill.model.mt.MeterLogGraph;
import com.ric.bill.model.mt.Vol;

//включил кэш - стало хуже, по скорости - 61 сек.
@Service
public class MeterLogMngImpl implements MeterLogMng {

	@Autowired
	private MeterLogDAO mDao;

	@PersistenceContext
    private EntityManager em;

	/**
	 * Получить список лог.счетчиков по определённому объекту, и типу
	 * @param mm - Объект
	 * @param tp - Тип
	 * @return
	 */
	/*@Cacheable("readOnlyCache")
	public List<MLogs> getMetLogByTp(MeterContains mm, String tp) {
		List<MLogs> mLog = new ArrayList<MLogs>(); 
		for (MLogs ml : mm.getMlog()) {
			if (ml.getTp().getCd().equals(tp)) {
				mLog.add(ml);
			}
		}
		return mLog;
	}*/
	
	/**
	 * Получить один (первый который найден) лог.счетчик по определённому объекту, типу и услуге
	 * @param mm - Объект
	 * @param serv - Услуга
	 * @param tp - Тип
	 * @return
	 */
	@Cacheable("readOnlyCache")
	public MLogs getFirstMetLogByServTp(MeterContains mm, Serv serv, String tp) {
		for (MLogs ml : mm.getMlog()) {
			//по типу и услуге
			if (ml.getTp().getCd().equals(tp)
					&& ml.getServ().equals(serv)) {
				return ml;
			}
		}
		return null;
	}

	/**
	 * Получить список лог.счетчиков по определённому объекту, типу и услуге
	 * @param mm - Объект
	 * @param serv - Услуга
	 * @param tp - Тип
	 * @return
	 */
	@Cacheable("readOnlyCache")
	public List<MLogs> getMetLogByServTp(MeterContains mm, Serv serv, String tp) {
		List<MLogs> mLog = new ArrayList<MLogs>(); 
		for (MLogs ml : mm.getMlog()) {
			//по типу и услуге
			if (ml.getTp().getCd().equals(tp)
					&& ml.getServ().equals(serv)) {
				mLog.add(ml);
			}
		}
		return mLog;
	}
	
	
	/**
	 * проверить существование физ.счетчика
	 * @param mLog
	 */
	@Cacheable("readOnlyCache")
	public boolean checkExsMet(MLogs mLog, Date genDt) {
    	//установить период существования хотя бы одного из физ счетчиков, по этому лог.сч.
    	for (Meter m: mLog.getMeter()) {
    		for (MeterExs e: m.getExs()) {
    			//по соотв.периоду
    			if (Utl.between(genDt, e.getDt1(), e.getDt2())) {
	    			if (e.getPrc() > 0d) {
	    				return true;
	    			}
    			}
    		}
    	}
		return false;
	}
	
	/**
	 * Получить объем, по счетчику за период и сам этот счетчик и признак существования его физ сч.
	 * @param lnVol - заполняемый объемами объект
	 * @param mLog - лог.счетчик
	 * @throws NotFoundNode - если не найден счетчик (узел)
	 */
	@Cacheable("readWriteCache")
    public SumNodeVol getVolPeriod (MLogs mLog) {
		SumNodeVol lnkVol = new SumNodeVol();
    	//так что, простая итерация
    	for (Vol v: mLog.getVol()) {
			//по всему соотв.периоду 
			if (Utl.between(v.getDt1(), Calc.getCurDt1(), Calc.getCurDt2()) && //внимание! здесь фильтр берет даты снаружи!
				Utl.between(v.getDt2(), Calc.getCurDt1(), Calc.getCurDt2())	
					) {
		        	//Calc.mess("проверка объема id="+v.getId()+" vol="+v.getVol1());
		    		if (v.getTp().getCd().equals("Фактический объем") ){
		    			lnkVol.addVol(v.getVol1());
		    		} else if (v.getTp().getCd().equals("Площадь и проживающие") ){
		    			lnkVol.addArea(v.getVol1());
		    			lnkVol.addPers(v.getVol2());
		    		} else if (v.getTp().getCd().equals("Лимит ОДН") ){
		    			lnkVol.setLimit(v.getVol1()); //здесь set вместо add (будет одно значение)
		    		}
			}
    	}
    	
    	
		return lnkVol;
	}

	/**
	 * Вернуть логический счетчик определенного типа, связанный с заданным
	 * Если связано несколько - будет возвращён первый
	 * @param mLog - тестируемый лог.счетчик
	 * @param tp - тип счетчика
	 * @return лог.счетчик
	 */
	@Cacheable("readWriteCache") 
	public MLogs getLinkedNode(MLogs mLog, String tp, Date genDt) {
		MLogs lnkMLog = null;
		//найти прямую связь (направленную внутрь или наружу, не важно) указанного счетчика со счетчиком указанного типа 
    	//сперва направленные внутрь
    	for (MeterLogGraph g : mLog.getInside()) {
			if (Utl.between(genDt, g.getDt1(), g.getDt2())) {
	    		if (g.getSrc().getTp().getCd().equals(tp)) {
	    			//найдено
	    			lnkMLog = g.getSrc();
	    			break;
	    		}
			}
    	}
    	//потом направленные наружу, если не найдено
    	if (lnkMLog == null) {
	    	for (MeterLogGraph g : mLog.getOutside()) {
				if (Utl.between(genDt, g.getDt1(), g.getDt2())) {
		    		if (g.getDst().getTp().getCd().equals(tp)) {
		    			//найдено
		    			lnkMLog = g.getSrc();
		    			break;
		    		}
				}
	    	}
		}
		return lnkMLog;
	}

    /**
     * удалить рекурсивно все объемы по всем счетчикам начиная с указанного
     * @param mLog - начальный счетчик
     * @param tp - тип расчета
     * @return 
     */
	@Cacheable("readWriteCache") 
	public void delNodeVol(MLogs mLog, int tp, Date genDt) {
		//удалять итератором, иначе java.util.ConcurrentModificationException
		for (Iterator<Vol> iterator = mLog.getVol().iterator(); iterator.hasNext();) {
		    Vol vol = iterator.next();
			if (vol.getTp().getCd().equals("Фактический объем") || vol.getTp().getCd().equals("Площадь и проживающие")) {
				Calc.mess("Del vol: id="+vol.getId());
				iterator.remove();
			}
		}

		//найти все направления, с необходимым типом, указывающие в точку из других узлов, удалить их объемы рекурсивно
		for (MeterLogGraph g : mLog.getInside()) {
			if (Utl.between(genDt, g.getDt1(), g.getDt2())) {
				if (tp==0 && g.getTp().getCd().equals("Расчетная связь") 
						 || tp==1 && g.getTp().getCd().equals("Связь по площади и кол-во прож.")
						 || tp==2 && g.getTp().getCd().equals("Расчетная связь ОДН")
						 || tp==3 && g.getTp().getCd().equals("Расчетная связь пропорц.площади")) {
							delNodeVol(g.getSrc(), tp, genDt);
				}
			}
		}
	}

	
}