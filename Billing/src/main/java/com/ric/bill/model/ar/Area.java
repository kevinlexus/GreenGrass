package com.ric.bill.model.ar;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

import com.ric.bill.Storable;
import com.ric.bill.TarifContains;
import com.ric.bill.model.bs.Base;
import com.ric.bill.model.tr.TarifKlsk;

/**
 * Класс Населённого пункта
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "AREA", schema="AR")
@AttributeOverride(name = "klsk", column = @Column(name = "FK_K_LSK"))
public class Area extends Base implements java.io.Serializable, Storable, TarifContains {

	//наименование
	private String name; 
	//CD
	private String cd; 

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

	//вернуть klsk объекта (в каждом подклассе свой метод из за того что колонка может иметь другое название!)
	@Column(name = "FK_K_LSK", nullable = true)
	public Integer getKlsk() {
		return this.klsk;
	}

	public void setKlsk(Integer klsk) {
		this.klsk=klsk;
	}

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_AREA", referencedColumnName="ID")
	private Set<Street> street = new HashSet<Street>(0);

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_K_LSK")
	@BatchSize(size = 50)
	private Set<TarifKlsk> tarifklsk = new HashSet<TarifKlsk>(0);

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

	public Set<TarifKlsk> getTarifklsk() {
		return tarifklsk;
	}

	public void setTarifklsk(Set<TarifKlsk> tarifklsk) {
		this.tarifklsk = tarifklsk;
	}

	public Set<Street> getStreet() {
		return street;
	}

	public void setStreet(Set<Street> street) {
		this.street = street;
	}
	
}

