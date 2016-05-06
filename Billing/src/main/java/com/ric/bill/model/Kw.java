package com.ric.bill.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



/**
 * Класс Квартиры
 * @author lev
 *
 */
@Entity
@Table(name = "KW", schema="AR")
public class Kw extends Base implements Storable {

	private Integer klsk; // klsk объекта

	//вернуть klsk объекта (в каждом подклассе свой метод из за того что колонка может иметь другое название!)
	@Column(name = "FK_K_LSK", nullable = true)
	public Integer getKlsk() {
		return this.klsk;
	}
	public void setKlsk(Integer klsk) {
		this.klsk=klsk;
	}
	
}

