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

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;


@MappedSuperclass
@FilterDefs({
    @FilterDef(name = "FILTER1", defaultCondition = "S1 like :TESTCASENAME", 
    		parameters = { @ParamDef(name = "TESTCASENAME", type = "string") })
})
public abstract class Base implements Storable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	protected int id; // id записи

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FK_K_LSK", referencedColumnName="FK_K_LSK")
	@Filters({
	    @Filter(name = "FILTER1")})
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
