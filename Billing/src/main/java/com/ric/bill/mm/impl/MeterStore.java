package com.ric.bill.mm.impl;

import java.util.ArrayList;
import java.util.List;

import com.ric.bill.MeterManagable;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.mt.MeterLog;

/**
 * Абстрактный класс сервисов, умеющих работать со счетчиками
 * @author lev
 *
 */
public abstract class MeterStore extends BaseStore {

	/**
	 * Получить список лог.счетчиков по определённому объекту, и типу
	 * @param mm - Объект
	 * @param tp - Тип
	 * @return
	 */
	public List<MeterLog> getMetLogByTp(MeterManagable mm, String tp) {
		List<MeterLog> mLog = new ArrayList<MeterLog>(); 
		for (MeterLog ml : mm.getMlog()) {
			if (ml.getTp().getCd().equals(tp)) {
				mLog.add(ml);
			}
		}
		return mLog;
	}
	
	/**
	 * Получить список лог.счетчиков по определённому объекту, типу и услуге
	 * @param mm - Объект
	 * @param serv - Услуга
	 * @param tp - Тип
	 * @return
	 */
	public List<MeterLog> getMetLogByServTp(MeterManagable mm, Serv serv, String tp) {
		List<MeterLog> mLog = new ArrayList<MeterLog>(); 
		for (MeterLog ml : mm.getMlog()) {
			//по типу и услуге
			if (ml.getTp().getCd().equals(tp)
					&& ml.getServ().equals(serv)) {
				mLog.add(ml);
			}
		}
		return mLog;
	}

}
