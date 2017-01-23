package com.ric.bill;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
     * @param stdt - норматив
	 * @param serv - услуга
	 * @param org - организация
	 * @param dt1 - дата
	 */
	public void addChrg (BigDecimal vol, BigDecimal price, BigDecimal stdt, Integer cntPers, BigDecimal area, Serv serv, Org org, Date dt1) {
		if (getStore().size() == 0) {
			//завести новую строку
			getStore().add(new ChrgRec(vol, price, stdt, cntPers, area, serv, org, dt1, dt1));
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
				getStore().add(new ChrgRec(vol, price, stdt, cntPers, area, serv, org, dt1, dt1));
			} else {
				//последний элемент найден
				//сравнить по-элементно
				if (lastRec.getPrice().compareTo(price) == 0 &&
					(lastRec.getOrg() == null && org == null ||
					 lastRec.getOrg().equals(org)) &&
						(lastRec.getStdt() == null && stdt == null ||
						 lastRec.getStdt().equals(stdt)) &&
							(lastRec.getCntPers() == null && cntPers == null ||
							 lastRec.getCntPers().equals(cntPers))
					) {
						//добавить данные в последнюю строку, прибавить объем и площадь 
						if (lastRec.getVol() != null) {
							lastRec.setVol(lastRec.getVol().add(vol));
						} else {
							lastRec.setVol(vol);
						}

						if (lastRec.getArea() != null) {
							lastRec.setArea(lastRec.getArea().add(area));
						} else {
							lastRec.setArea(area);
						}
						
						//установить заключительную дату периода
						lastRec.setDt2(dt1);
					} else {
						//завести новую строку, если отличается расценкой или организацией
						getStore().add(new ChrgRec(vol, price, stdt, cntPers, area, serv, org, dt1, dt1));
					}
			}
		}
	}

	public List<ChrgRec> getStore() {
		return store;
	}

	public void setStore(List<ChrgRec> store) {
		this.store = store;
	}
	
}
