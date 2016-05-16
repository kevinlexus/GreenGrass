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



/**
 * Квартира
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "KW", schema="AR")
@AttributeOverride(name = "klsk", column = @Column(name = "FK_K_LSK"))
public class Kw extends Base implements java.io.Serializable, Storable {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_HOUSE", referencedColumnName="ID", updatable = false, insertable = false)
	private House house;

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)  //сделал LAZY!
	@JoinColumn(name="FK_KW", referencedColumnName="ID")
	private Set<Kart> lsk = new HashSet<Kart>(0);

	//вернуть klsk объекта (в каждом подклассе свой метод из за того что колонка может иметь другое название!)
	@Column(name = "FK_K_LSK", nullable = true)
	public Integer getKlsk() {
		return this.klsk;
	}
	public void setKlsk(Integer klsk) {
		this.klsk=klsk;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}
	
	public Set<Kart> getLsk() {
		return lsk;
	}
	public void setLsk(Set<Kart> lsk) {
		this.lsk = lsk;
	}
	
}

