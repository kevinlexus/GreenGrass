package com.ric.bill.model;

/**
 * Интерфейс  объект квартплаты
 * @author lev
 *
 */
public interface Storable extends Simple {

	//klsk объекта (в каждом подклассе переписать методы!)
	Integer getKlsk();
	void setKlsk(Integer klsk);
	
}
