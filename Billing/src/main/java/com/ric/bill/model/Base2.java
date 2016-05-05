package com.ric.bill.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;


@MappedSuperclass
public abstract class Base2 implements Storable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	protected int id; // id записи

	//protected Integer klsk; //klsk

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Integer getI1(Integer klsk) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getS1(Integer klsk) {
		// TODO Auto-generated method stub
		return null;
	}

	public abstract Integer getKlsk();
	
	public abstract void setKlsk(Integer klsk);	
}
