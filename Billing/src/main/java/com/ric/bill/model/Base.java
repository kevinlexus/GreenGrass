package com.ric.bill.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;


/**
 * Абстрактный базовый класс Base
 * @author lev
 *
 */

@MappedSuperclass
public abstract class Base implements Serializable, Storable {
	
	private int id; // id записи
	protected Integer klsk; //klsk

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//вернуть параметр Integer из хранилища
	@Transient
	public final Integer getI1(Integer klsk) {
		return null;
	}
	
	//вернуть параметр String из хранилища
	@Transient
	public final String getS1(Integer klsk) {
		return null;
	}
	
	//вернуть klsk объекта (в каждом подклассе переписать метод!)
	public abstract Integer getKlsk();

	public abstract void setKlsk(Integer klsk);	
}
