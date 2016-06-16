package com.ric.bill.mm.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.ric.bill.MeterContains;
import com.ric.bill.mm.BaseMeterLogMng;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.mt.MLogs;
import com.ric.bill.model.mt.MeterLog;

/**
 * Абстрактный класс сервисов, умеющих работать со счетчиками
 * @author lev
 *
 */
public abstract class MeterStore extends TarifStore implements BaseMeterLogMng {

	/**
	 * Получить список лог.счетчиков по определённому объекту, и типу
	 * @param mm - Объект
	 * @param tp - Тип
	 * @return
	 */
	@Cacheable("billCache")
	public List<MeterLog> getMetLogByTp(MeterContains mm, String tp) {
		List<MeterLog> mLog = new ArrayList<MeterLog>(); 
		for (MeterLog ml : mm.getMlog()) {
			if (ml.getTp().getCd().equals(tp)) {
				mLog.add(ml);
			}
		}
		return mLog;
	}
	
	/**
	 * Получить один (первый который найден) лог.счетчик по определённому объекту, типу и услуге
	 * @param mm - Объект
	 * @param serv - Услуга
	 * @param tp - Тип
	 * @return
	 */
	@Cacheable("billCache")
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
	@Cacheable("billCache")
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

}
