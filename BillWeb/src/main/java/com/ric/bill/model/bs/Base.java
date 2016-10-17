package com.ric.bill.model.bs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

import com.ric.bill.Storable;

/**
 * Базовый класс всех сущностей, параметры которых хранятся в dw
 * @author lev
 *
 */
@MappedSuperclass
@EqualsAndHashCode(callSuper=false)
public abstract class Base implements Storable {
	
    @Column(name = "FK_K_LSK", updatable = false, nullable = false)
	protected Integer klsk;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_K_LSK", referencedColumnName="FK_K_LSK")
	//@BatchSize(size = 20)
	@Fetch(FetchMode.SUBSELECT)
	protected List<Dw> dw = new ArrayList<Dw>(0);

	public List<Dw> getDw() {
		return dw;
	}
	public void setDw(List<Dw> dw) {
		this.dw = dw;
	}
	
	public Integer getKlsk() {
		return klsk;
	}
	
	public void setKlsk(Integer klsk) {
		this.klsk = klsk;
	}
	
	
}
