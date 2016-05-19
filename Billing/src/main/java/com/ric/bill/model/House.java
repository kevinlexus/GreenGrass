package com.ric.bill.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ric.bill.MeterManagable;

/**
 * Дом
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "HOUSE", schema="AR")
@AttributeOverride(name = "klsk", column = @Column(name = "FK_K_LSK"))
public class House extends Base implements java.io.Serializable, MeterManagable {

	public House() {
	}

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FK_HOUSE", referencedColumnName="ID")
	private Set<Kw> kw = new HashSet<Kw>(0);

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_K_LSK")
	private Set<MeterLog> mlog = new HashSet<MeterLog>(0);

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_K_LSK")
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
