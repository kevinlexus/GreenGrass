package com.ric.bill.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Класс Лицевого счета
 * @author lev
 *
 */
@Entity
@Table(name = "KART", schema="AR")
@AttributeOverrides({
		@AttributeOverride(name = "klsk", column = @Column(name = "FK_K_LSK")  ),
		@AttributeOverride(name = "id", column = @Column(name = "LSK")	)
		}
		)
public class Lsk extends Base implements java.io.Serializable, Storable  {

	public Lsk() {
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FK_KW", referencedColumnName="ID", updatable = false, insertable = false)
	private Kw kw;

	//вернуть klsk объекта (в каждом подклассе свой метод из за того что колонка может иметь другое название!)
	@Column(name = "FK_K_LSK", nullable = true)
	public Integer getKlsk() {
		return this.klsk;
	}
	public void setKlsk(Integer klsk) {
		this.klsk=klsk;
	}

	//ФИО владельца
	@Column(name = "FIO", nullable = true)
	private String fio;
	
	//Лиц.счет
	@Column(name = "LSK", nullable = true, updatable = false, insertable = false)
	private String ls;

	@Override
	public int getId() {
		return 0;
	}
	public void setId(int id) {
		
	}
	public Kw getKw() {
		return kw;
	}
	public void setKw(Kw kw) {
		this.kw = kw;
	}
	public String getFio() {
		return fio;
	}
	public void setFio(String fio) {
		this.fio = fio;
	}
	
	public String getLs() {
		return ls;
	}
	public void setLs(String ls) {
		this.ls = ls;
	}
	
}

