package com.ric.bill.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Класс - Дом
 * @author lev
 *
 */
@Entity
@Table(name = "HOUSE", schema="AR")
public class House extends Base2 implements Storable {

	private Integer klsk; // klsk объекта

	/**
	 * Загрузить все лицевые счета дома
	 * 
	 */
	public void loadLsks() {
		
	}
	
	/**
	 * Загрузить все счетчики и графы счетчиков имеющие отношение к дому и к лиц.счетам дома
	 *  
	 */
	public void loadMeters() {
		
	}
	
	//вернуть klsk объекта (в каждом подклассе свой метод!)
	@Column(name = "FK_K_LSK", nullable = true)
	public Integer getKlsk() {
		return this.klsk;
	}
	public void setKlsk(Integer klsk) {
		this.klsk=klsk;
	}
	
	
}
