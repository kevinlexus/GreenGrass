package com.ric.bill.model.ar;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

import com.ric.bill.Storable;
import com.ric.bill.TarifContains;
import com.ric.bill.model.bs.Base;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.tr.TarifKlsk;

/**
 * Принадлежность лиц.счета УК (РЭУ)
 * @author lev
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "LSKXORG", schema="AR")
public class Lskxorg implements java.io.Serializable {
	
	@Id
	@Column(name="ROWID")
	private String rowid;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FK_UK", referencedColumnName="ID")
	private Org uk;
	
    //даты начала и окончания действия лиц.счета
    @Column(name = "DT1", updatable = false, nullable = true)
    private Date dt1;

    @Column(name = "DT2", updatable = false, nullable = true)
    private Date dt2;

    public Org getUk() {
		return uk;
	}

	public void setUk(Org uk) {
		this.uk = uk;
	}
	
	public Date getDt1() {
		return dt1;
	}

	public void setDt1(Date dt1) {
		this.dt1 = dt1;
	}

	public Date getDt2() {
		return dt2;
	}

	public void setDt2(Date dt2) {
		this.dt2 = dt2;
	}

	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}

}

