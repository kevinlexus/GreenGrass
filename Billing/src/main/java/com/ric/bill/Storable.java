package com.ric.bill;

import java.util.Set;

import com.ric.bill.model.bs.Dw;

/**
 * Интерфейс - объект квартплаты
 * @author lev
 *
 */
public interface Storable extends Simple {
	//klsk объекта (в каждом подклассе переписать методы!)
	Integer getKlsk();
	void setKlsk(Integer klsk);
	public Set<Dw> getDw();
	public void setDw(Set<Dw> dw);
	
}
