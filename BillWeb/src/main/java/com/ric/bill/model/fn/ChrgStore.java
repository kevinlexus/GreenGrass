package com.ric.bill.model.fn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.ric.bill.Calc;
import com.ric.bill.Utl;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.bs.Serv;

/**
 * Хранилище записей начисления
 * @author lev
 *
 */
public class ChrgStore {

	private List<ChrgRec> store;
	
	//конструктор
	public ChrgStore () {
		super();
		store = new ArrayList<ChrgRec>(0); 
	}

	/**
	 * добавить строку начисления с учётом группировки записей 
	 * @param sum - сумма
	 * @param vol - объем
	 * @param price - расценка
	 * @param serv - услуга
	 * @param org - организация
	 * @param dt1 - дата
	 */
	public void addChrg (BigDecimal vol, BigDecimal price, Serv serv, Org org, Date dt1) {
		if (getStore().size() == 0) {
			//завести новую строку
			getStore().add(new ChrgRec(vol, price, serv, org, dt1, dt1));
		} else {
			ChrgRec lastRec = null;
			//получить последний добавленный элемент по данной услуге
			for (ChrgRec rec : getStore()) {
				if (rec.getServ().equals(serv)) {
					lastRec = rec;
				}
			}
			if (lastRec == null) {
				//последний элемент с данной услугой не найден, - создать
				getStore().add(new ChrgRec(vol, price, serv, org, dt1, dt1));
			} else {
				//последний элемент найден
				//сравнить по-элементно
				//Calc.mess("CHECK4="+lastRec.getOrg(), 2);
				//Calc.mess("CHECK5="+org, 2);
				if (lastRec.getPrice().compareTo(price) == 0 &&
					(lastRec.getOrg() == null && org == null ||
					 lastRec.getOrg().equals(org))
					) {
					//добавить данные в последнюю строку, просуммировать сумму и объем 
					//lastRec.setSum(lastRec.getSum().add(sum)); - СУММА Считается в конце, после всего расчета!
					lastRec.setVol(lastRec.getVol().add(vol));
					
					//установить заключительную дату периода
					lastRec.setDt2(dt1);
				} else {
					//завести новую строку, если отличается расценкой или организацией
					//BigDecimal sum, BigDecimal vol, BigDecimal price, int org, Date dt1
					getStore().add(new ChrgRec(vol, price, serv, org, dt1, dt1));
				}
			}
		}
	}

	public synchronized List<ChrgRec> getStore() {
		return store;
	}

	public synchronized void setStore(List<ChrgRec> store) {
		this.store = store;
	}
	
}
