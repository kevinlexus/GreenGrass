package com.ric.bill.mm.impl;

import java.util.ArrayList;
import java.util.List;

import com.ric.bill.MeterManagable;
import com.ric.bill.model.MeterLog;

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
			if (ml.getTp().getCd().equals("Ввод")) {
				//System.out.println("Ввод: id="+ml.getId());
				mLog.add(ml);
			}
		}
		return mLog;
	}
	
}
