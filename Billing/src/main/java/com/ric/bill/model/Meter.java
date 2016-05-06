package com.ric.bill.model;


import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "METER", schema="MT")
@AttributeOverride(name = "klsk", column = @Column(name = "FK_K_LSK"))
public class Meter extends Base  implements Storable {

	private Integer klsk; //klsk
	 
	//вернуть klsk объекта (в каждом подклассе свой метод из за того что колонка может иметь другое название!)
    @Column(name = "FK_K_LSK", updatable = false, nullable = false)
	public Integer getKlsk() {
		return klsk;
	}

	public void setKlsk(Integer klsk) {
		this.klsk=klsk;
	}

	
}

