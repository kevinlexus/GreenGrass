package com.ric.bill.model.bs;

import java.util.HashSet;
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
public abstract class Base implements Storable {
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_K_LSK", referencedColumnName="FK_K_LSK")
	@BatchSize(size = 20)
	protected Set<Dw> dw = new HashSet<Dw>(0);

	protected Integer klsk;

	public Set<Dw> getDw() {
		return dw;
	}
	public void setDw(Set<Dw> dw) {
		this.dw = dw;
	}
	
	
}
