package com.ric.bill.model;

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

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

/**
 * Базовый класс всех сущностей, параметры которых хранятся в dw
 * @author lev
 *
 */
@MappedSuperclass
@FilterDefs({
    @FilterDef(name = "FILTER_GEN_DT", defaultCondition = ":DT1 BETWEEN DT1 AND DT2", 
    		parameters = {@ParamDef(name = "DT1", type = "date")
    		}
    )
})
public abstract class Base implements Storable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	protected int id; // id записи

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FK_K_LSK", referencedColumnName="FK_K_LSK")
	@Filters({
	    @Filter(name = "FILTER_GEN_DT")})
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
