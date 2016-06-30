package com.ric.bill.mm.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
	 * Получить все лог.счетчики по определённому объекту, типу и услуге
	 * @param - Объект
	 * @param serv - Услуга
	 * @param tp - Тип, если не указан - по всем
	 * @return - искомый список
	 */
	@Cacheable(cacheNames="readOnlyCache", key="{ #mm.getKlsk(), #serv.getId(), #tp }") 
	public Set<MLogs> getAllMetLogByServTp(MeterContains mm, Serv serv, String tp) {
		Set<MLogs> lstMlg = new HashSet<MLogs>(0); 
		Calc.mess("getAllMetLogByServTp задано:"+serv.getCd()+" "+serv.getId()+" "+tp);
		for (MLogs ml : mm.getMlog()) {
			//Calc.mess("getAllMetLogByServTp НАЙДЕНО:"+ml.getId()+" "+ ml.getName()+" "+ml.getTp().getCd()+" "+ml.getServ().getCd());
			//по типу, если указано
			if (tp == null || ml.getTp().getCd().equals(tp)) {
				Calc.mess("getAllMetLogByServTp ТИП:"+ml.getId()+" "+ ml.getName()+" "+ml.getTp().getCd()+" "+ml.getServ().getId());
				//и услуге
				Serv sss = ml.getServ();
				if (ml.getId() == 3602003) {
					Calc.mess("stop");	
				}
				if (ml.getServ().equals(serv)) {
					Calc.mess("getAllMetLogByServTp Соответствует:"+ml.getId()+" "+ ml.getName()+" "+ml.getTp().getCd());
					lstMlg.add(ml);
				}
			}
		}
		return lstMlg;
	}

	/**
	 * Получить список лог.счетчиков по определённому объекту, типу и услуге
	 * @param mm - Объект
	 * @param serv - Услуга
	 * @param tp - Тип
	 * @return
	 */
	/*@Cacheable("readOnlyCache")
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
	}*/
	
	
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
	 * @param mLog - узел
	 * @param tp - тип распределения (здесь ТОЛЬКО для КЭША!)
	 * @param dt1 - нач.период
	 * @param dt2 - кон.период
	 * @return - возвращаемый объем
	 */
	//@Cacheable("readWriteCache")
	@Cacheable(cacheNames="readWriteCache", key="{ #mLog.getId(), #tp, #dt1, #dt2 }")
    public SumNodeVol getVolPeriod (MLogs mLog, int tp, Date dt1, Date dt2) {
		/*if (mLog.getId()==3603274) {
			Calc.mess("########### tp = "+tp+" mLog.id="+mLog.getId()+" dt1="+dt1.toLocaleString()+" dt2="+dt2.toLocaleString(), 2);
		}*/
		SumNodeVol lnkVol = new SumNodeVol();
    	//так что, простая итерация
    	for (Vol v: mLog.getVol()) {
			//по всему соотв.периоду 
			if (Utl.between(v.getDt1(), dt1, dt2) && //внимание! здесь фильтр берет даты снаружи!
				Utl.between(v.getDt2(), dt1, dt2)	
					) {
		        	//Calc.mess("проверка объема id="+v.getId()+" vol="+v.getVol1());
		    		if (v.getTp().getCd().equals("Фактический объем") ){
		    			lnkVol.addVol(v.getVol1());
		    		} else if (v.getTp().getCd().equals("Площадь и проживающие") ){
		    			lnkVol.addArea(v.getVol1());
		    			lnkVol.addPers(v.getVol2());
		    		} else if (v.getTp().getCd().equals("Лимит ОДН") ){
		    			lnkVol.setLimit(v.getVol1()); //здесь set вместо add (будет одно значение) (как правило для ЛОДН счетчиков)
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
			if (vol.getTp().getCd().equals("Фактический объем") || vol.getTp().getCd().equals("Площадь и проживающие") || vol.getTp().getCd().equals("Лимит ОДН") ) {
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