package com.ric.bill.mm.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.Calc;
import com.ric.bill.ChrgServ;
import com.ric.bill.Config;
import com.ric.bill.MeterContains;
import com.ric.bill.SumNodeVol;
import com.ric.bill.Utl;
import com.ric.bill.dao.MeterLogDAO;
import com.ric.bill.mm.MeterLogMng;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.mt.MLogs;
import com.ric.bill.model.mt.Meter;
import com.ric.bill.model.mt.MeterExs;
import com.ric.bill.model.mt.MeterLog;
import com.ric.bill.model.mt.MeterLogGraph;
import com.ric.bill.model.mt.Vol;

//включил кэш - стало хуже, по скорости - 61 сек.
@Service
@Slf4j
public class MeterLogMngImpl implements MeterLogMng {

	@Autowired
	private MeterLogDAO mDao;

	@Autowired
	private Config config;

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
	//@Cacheable(cacheNames="rrr1") 
	@Cacheable(cacheNames="rrr1", key="{ #rqn, #mm.getKlsk(), #serv.getId(), #tp }") 
	public /*synchronized*/ List<MLogs> getAllMetLogByServTp(int rqn, MeterContains mm, Serv serv, String tp) {
		List<MLogs> lstMlg = new ArrayList<MLogs>(0); 
		for (MLogs ml : mm.getMlog()) {
			//по типу, если указано
			if (tp == null || ml.getTp().getCd().equals(tp)) {
				//и услуге
				Serv sss = ml.getServ();
				if (ml.getServ().equals(serv)) {
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
	 * проверить существование хотя бы одного физ.счетчика по лиц.счету
	 * @param rqn   - уникальный номер запроса
	 * @param kart  - лиц.счет
	 * @param genDt - дата проверки
	 * @return - существует/нет
	 */
	@Cacheable("rrr1")
	public boolean checkExsKartMet (int rqn, Kart kart, Date genDt) {
		for (MLogs mLog : kart.getMlog()) {
			if (checkExsMet(rqn, mLog, genDt)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * проверить существование физ.счетчика
	 * @param mLog
	 */
	@Cacheable("rrr1")
	public /*synchronized*/ boolean checkExsMet(int rqn, MLogs mLog, Date genDt) {
    	//получить период существования хотя бы одного из физ счетчиков, по этому лог.сч.
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
	 * Получить объем, по СЧЕТЧИКУ, за период и сам этот счетчик и признак существования его физ сч.
	 * @param mLog - узел
	 * @param tp - тип распределения (здесь ТОЛЬКО для КЭША!) TODO!!!!!!!!! Разобраться что значит "только для Кэша". зачем нужен неиспользуемый параметр?
	 * @param dt1 - нач.период
	 * @param dt2 - кон.период
	 * @return - возвращаемый объем
	 */
	//@Cacheable(cacheNames="rrr1") 
	@Cacheable(cacheNames="rrr1", key="{ #rqn, #mLog.getId(), #tp, #dt1, #dt2}")
    public /*synchronized*/ SumNodeVol getVolPeriod (int rqn, Calc calc, MLogs mLog, int tp, Date dt1, Date dt2) {
		SumNodeVol lnkVol = new SumNodeVol();
		/* Java 8 */
		mLog.getVol().parallelStream()
	                .filter(t -> Utl.nvl(t.getStatus(), 0).equals(calc.getReqConfig().getStatusVol()) && // по статусу
	            			Utl.between(t.getDt1(), dt1, dt2) && //здесь фильтр берет даты снаружи!
	        				Utl.between(t.getDt2(), dt1, dt2))
					.forEach(t -> {
								if (t.getTp().getCd().equals("Фактический объем")) {
					    			lnkVol.addVol(t.getVol1());
								} else if (t.getTp().getCd().equals("Площадь и проживающие")) {
					    			lnkVol.addArea(t.getVol1());
					    			lnkVol.addPers(t.getVol2());
					    		} else if (t.getTp().getCd().equals("Лимит ОДН") ){
					    			lnkVol.setLimit(t.getVol1()); //здесь set вместо add (будет одно значение) (как правило для ЛОДН счетчиков)
					    		}
							});
		return lnkVol;
	}


	/**
	 * получить совокупный объем по ОБЪЕКТУ, содержащему счетчики, по услуге, за период
	 * @param mc - Объект, содержащий объемы
	 * @param serv - Услуга, по которой искать
	 * @param dt1 - нач.период
	 * @param dt2 - кон.период
	 * @return - возвращаемый объем
	 */
	//@Cacheable(cacheNames="rrr1") 
	@Cacheable(cacheNames="rrr1", key="{ #rqn, #calc.getKart().getLsk(), #mc.getId(), #serv.getId(), #dt1, #dt2}")
	public synchronized SumNodeVol getVolPeriod (int rqn, Calc calc, MeterContains mc, Serv serv, Date dt1, Date dt2) {
		SumNodeVol amntSum = new SumNodeVol();
		//перебрать все лог.счетчики, доступные по объекту, сложить объемы
		for (MeterLog mLog: mc.getMlog()) {
			//по заданной услуге
			if (mLog.getServ().equals(serv)) {
				SumNodeVol tmp = getVolPeriod(rqn, calc, mLog, 0, dt1, dt2);
				amntSum.addArea(tmp.getArea());
				amntSum.addPers(tmp.getPers());
				amntSum.addVol(tmp.getVol());
			}
		} 
		
		//вернуть объект, содержащий объемы
		return amntSum;
		
	}
	
	/**
	 * Вернуть логический счетчик определенного типа, связанный с заданным
	 * Если связано несколько - будет возвращён первый
	 * @param mLog - тестируемый лог.счетчик
	 * @param tp - тип счетчика
	 * @return лог.счетчик
	 */
	@Cacheable("rrr1") 
	public /*synchronized*/ MLogs getLinkedNode(int rqn, MLogs mLog, String tp, Date genDt) {
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
	@Cacheable("rrr1") 
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED) //  ПРИМЕНЯТЬ ТОЛЬКО НА PUBLIC МЕТОДЕ!!! http://stackoverflow.com/questions/4396284/does-spring-transactional-attribute-work-on-a-private-method
	public /*synchronized*/ void delNodeVol(int rqn, MLogs mLog, int tp, Date dt1, Date dt2, Integer status) {

		//удалять итератором, иначе java.util.ConcurrentModificationException
		for (Iterator<Vol> iterator = mLog.getVol().iterator(); iterator.hasNext();) {
		    Vol vol = iterator.next();
		    if (Utl.nvl(vol.getStatus(),0).equals(status) && //учитывая статус записи (распред/перерасч.) 
		    		(vol.getTp().getCd().equals("Фактический объем") || vol.getTp().getCd().equals("Площадь и проживающие") || vol.getTp().getCd().equals("Лимит ОДН"))) {
		    	//проверить период
		    	if (dt1.getTime() <= vol.getDt1().getTime() && dt2.getTime() >= vol.getDt2().getTime()) {  //здесь диапазон дат "снаружи"
					iterator.remove();
		    	}
			}
		}

		//найти все направления, с необходимым типом, указывающие в точку из других узлов, удалить их объемы рекурсивно
		for (MeterLogGraph g : mLog.getInside()) {
			if (dt1.getTime() >= g.getDt1().getTime() && dt1.getTime() <= g.getDt2().getTime() || 
				dt2.getTime() >= g.getDt1().getTime() && dt2.getTime() <= g.getDt2().getTime()	
					) { //здесь диапазон дат "внутри" (чтобы хотя бы одна из заданных дат была внутри диапазона
				
				if (tp==0 && g.getTp().getCd().equals("Расчетная связь") 
						 || tp==1 && g.getTp().getCd().equals("Связь по площади и кол-во прож.")
						 || tp==2 && g.getTp().getCd().equals("Расчетная связь ОДН")
						 || tp==3 && g.getTp().getCd().equals("Расчетная связь пропорц.площади")) {
							delNodeVol(rqn, g.getSrc(), tp, dt1, dt2, status);
				}
			}
		}

	}
	
	
	
	/**
	 * Получить лиц.счет, содержащий указанный счетчик
	 * @param mLog - Счетчик
	 * @return
	 */
//	 НЕ ВЗЛЕТЕЛО, медленно выполняется, чем mLog.getKart()
	//@Cacheable(cacheNames="rrr1", key="{ #mLog.getId() }")
	@Cacheable(cacheNames="rrr1") 
	public /*synchronized*/ Kart getKart(int rqn, MLogs mLog) {
		return mDao.getKart(rqn, mLog);
	}
	/**
	 * Получить дом, содержащий указанный счетчик
	 * @param mLog - Счетчик
	 * @return
	 */
	/* НЕ ВЗЛЕТЕЛО, медленно выполняется, чем mLog.getHouse()
	public House getHouse(MLogs mLog) {
		return mDao.getHouse(mLog);
	}
	*/


	
	
}