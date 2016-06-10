package com.ric.bill.model.ar;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.ric.bill.MeterContains;
import com.ric.bill.TarifContains;
import com.ric.bill.model.bs.Base;
import com.ric.bill.model.mt.MeterLog;
import com.ric.bill.model.tr.TarifKlsk;

/**
 * Дом
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "HOUSE", schema="AR")
@AttributeOverride(name = "klsk", column = @Column(name = "FK_K_LSK"))
public class House extends Base implements java.io.Serializable, MeterContains, TarifContains {

	public House() {
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	protected Integer id; //id записи

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_HOUSE", referencedColumnName="ID")
	@BatchSize(size = 500)
	private Set<Kw> kw = new HashSet<Kw>(0);

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_K_LSK")
	@BatchSize(size = 20)
	private Set<MeterLog> mlog = new HashSet<MeterLog>(0);

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_K_LSK")
	@BatchSize(size = 50)
	private Set<TarifKlsk> tarklsk = new HashSet<TarifKlsk>(0);

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_STREET", referencedColumnName="ID", updatable = false)
	private Street street;
	
	//вернуть klsk объекта (в каждом подклассе свой метод из за того что колонка может иметь другое название!)
	@Column(name = "FK_K_LSK", nullable = true)
	public Integer getKlsk() {
		return this.klsk;
	}

	public void setKlsk(Integer klsk) {
		this.klsk=klsk;
	}

	public Set<Kw> getKw() {
		return kw;
	}

	public void setKw(Set<Kw> kw) {
		this.kw = kw;
	}
	
	public Set<MeterLog> getMlog() {
		return mlog;
	}

	public void setMlog(Set<MeterLog> mlog) {
		this.mlog = mlog;
	}

	public Set<TarifKlsk> getTarklsk() {
		return tarklsk;
	}

	public void setTarklsk(Set<TarifKlsk> tarklsk) {
		this.tarklsk = tarklsk;
	}

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}
	

}
