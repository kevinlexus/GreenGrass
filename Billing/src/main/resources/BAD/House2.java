package com.ric.bill.model;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

/**
 * Класс - Дом
 * @author lev
 */
@Entity
@Table(name = "HOUSE", schema="AR")
public class House2   implements java.io.Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
	protected int id; // id записи

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//вернуть klsk объекта (в каждом подклассе свой метод из за того что колонка может иметь другое название!)
	@Column(name = "FK_K_LSK", nullable = true)
	private Integer klsk; // klsk объекта

	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="FK_K_LSK", referencedColumnName="FK_K_LSK")
	private Set<Dw2> Dw2 = new HashSet<Dw2>(0);

	public House2() {
	}

	public Integer getKlsk() {
		return this.klsk;
	}
	public void setKlsk(Integer klsk) {
		this.klsk=klsk;
	}
	
	public Set<Dw2> getDw2() {
		return this.Dw2;
	}
	public void setDw2(Set<Dw2> Dw2) {
		this.Dw2 = Dw2;
	}
	
}
