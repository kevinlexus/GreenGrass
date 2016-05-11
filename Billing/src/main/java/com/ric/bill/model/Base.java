package com.ric.bill.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


@MappedSuperclass
public abstract class Base implements Storable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	protected int id; // id записи

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FK_K_LSK", referencedColumnName="FK_K_LSK")
	protected Set<Dw> dw = new HashSet<Dw>(0);

	protected Integer klsk;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Set<Dw> getDw() {
		return dw;
	}
	public void setDw(Set<Dw> dw) {
		this.dw = dw;
	}
	
	
}
