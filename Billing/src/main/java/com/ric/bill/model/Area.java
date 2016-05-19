package com.ric.bill.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ric.bill.Storable;

/**
 * Класс Населённого пункта
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "AREA", schema="AR")
@AttributeOverride(name = "klsk", column = @Column(name = "FK_K_LSK"))
public class Area extends Base implements java.io.Serializable, Storable {

	// наименование
	private String name; 
	// CD
	private String cd; 

	//вернуть klsk объекта (в каждом подклассе свой метод из за того что колонка может иметь другое название!)
	@Column(name = "FK_K_LSK", nullable = true)
	public Integer getKlsk() {
		return this.klsk;
	}

	public void setKlsk(Integer klsk) {
		this.klsk=klsk;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FK_AREA", referencedColumnName="ID")
	private Set<Street> street = new HashSet<Street>(0);

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_K_LSK")
	private Set<TarifKlsk> tarklsk = new HashSet<TarifKlsk>(0);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public Set<TarifKlsk> getTarklsk() {
		return tarklsk;
	}

	public void setTarklsk(Set<TarifKlsk> tarklsk) {
		this.tarklsk = tarklsk;
	}

	public Set<Street> getStreet() {
		return street;
	}

	public void setStreet(Set<Street> street) {
		this.street = street;
	}
	
}

