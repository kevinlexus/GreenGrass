package com.ric.bill.model.fn;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
	}

	//добавить строку начисления с учётом группировки записей
	public void addChrg (BigDecimal sum, BigDecimal vol, BigDecimal price, int org, Date dt1) {
		if (store.size() == 0) {
			//завести новую строку
			store.add(new ChrgRec(sum, vol, price, org, dt1, dt1));
		} else {
			//получить последний добавленный элемент
			ChrgRec lastRec = store.get(store.size()-1);
			//сравнить по-элементно
			if (lastRec.getPrice().compareTo(price) != 0 ||
				lastRec.getOrg() != org) {
				//завести новую строку, если отличается расценкой или организацией
				//BigDecimal sum, BigDecimal vol, BigDecimal price, int org, Date dt1
				store.add(new ChrgRec(sum, vol, price, org, dt1, dt1));
			} else {
				//добавить данные в последнюю строку, просуммировать сумму и объем 
				lastRec.setSum(lastRec.getSum().add(sum));
				lastRec.setVol(lastRec.getVol().add(vol));
				//установить заключительную дату периода
				lastRec.setDt2(dt1);
			}
			   
		}
	}
	
}
