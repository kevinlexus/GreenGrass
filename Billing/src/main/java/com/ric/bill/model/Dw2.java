package com.ric.bill.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * Значение параметра объекта
 */
@Entity
@Table(name = "U_HFPXKLSK", schema="ORALV")
public class Dw2 implements java.io.Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	private int id; // id записи
	
    @Column(name = "S1", updatable = true)
    private String s1; //s1 значения

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FK_K_LSK", referencedColumnName="FK_K_LSK")
	private House2 house;

	public Dw2() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getS1() {
		return s1;
	}
	public void setS1(String s1) {
		this.s1 = s1;
	}

	public House2 getHouse2() {
		return this.house;
	}

	public void setHouse2(House2 house) {
		this.house = house;
	}	

	
	
}
