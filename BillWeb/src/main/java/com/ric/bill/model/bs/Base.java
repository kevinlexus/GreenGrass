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
	protected List<Dw> dw = new ArrayList<Dw>(0);

	public List<Dw> getDw() {
		return dw;
	}
	public void setDw(List<Dw> dw) {
		this.dw = dw;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dw == null) ? 0 : dw.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Base other = (Base) obj;
		if (dw == null) {
			if (other.dw != null)
				return false;
		} else if (!dw.equals(other.dw))
			return false;
		return true;
	}
	
	
}
