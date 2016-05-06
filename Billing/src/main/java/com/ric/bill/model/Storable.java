package com.ric.bill.model;

/**
 * Интерфейс  объект квартплаты
 * @author lev
 *
 */
public interface Storable extends Simple {

	//параметры объекта
	Integer getI1(Integer klsk); 
	String getS1(Integer klsk);
	
	//klsk объекта (в каждом подклассе переписать методы!)
	Integer getKlsk();
	void setKlsk(Integer klsk);
	
}
