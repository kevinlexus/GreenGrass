package com.ric.bill.model.ar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
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
	

    //@EmbeddedId
    //private EntityPropertyPK id;
	@Id
	@Column(name="ID", updatable = false, nullable = false)
	private Integer id; //id
	
    //лиц.счет
    @Column(name = "LSK", updatable = false, insertable = false, nullable = false)
    private String lsk;

    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FK_UK", referencedColumnName="ID", updatable = false, insertable = false, nullable = true)
	private Org uk;
	
    //даты начала и окончания действия лиц.счета
    @Column(name = "DT1", updatable = false, insertable = false, nullable = true)
    private Date dt1;

    @Column(name = "DT2", updatable = false, insertable = false, nullable = true)
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

	public String getLsk() {
		return lsk;
	}

	public void setLsk(String lsk) {
		this.lsk = lsk;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

/*	public EntityPropertyPK getId() {
		return id;
	}

	public void setId(EntityPropertyPK id) {
		this.id = id;
	}*/

	   @Override
	   public boolean equals(Object o) {
	       if (this == o) return true;
	       if (!(o instanceof Lskxorg)) return false;
	     
	       Lskxorg other = (Lskxorg) o;
	     
	       if (getId() != null ?
	           !getId().equals(other.getId()) : other.getId() != null)
	           return false;
	     
	       return true;
	   }

}

