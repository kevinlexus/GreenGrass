package com.ric.bill.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Класс Лицевого счета
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "KART", schema="AR")
@AttributeOverrides({
		@AttributeOverride(name = "klsk", column = @Column(name = "FK_K_LSK")  ),
		@AttributeOverride(name = "id", column = @Column(name = "LSK")	)
		}
		)
public class Kart extends Base implements java.io.Serializable, Storable  {

	public Kart() {
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
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_K_LSK")
	private Set<MeterLog> mlog = new HashSet<MeterLog>(0);

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_K_LSK")
	private Set<TarifKlsk> tarklsk = new HashSet<TarifKlsk>(0);

	//ФИО владельца
	@Column(name = "FIO", nullable = true)
	private String fio;
	
	//Лиц.счет
	@Column(name = "LSK", nullable = true, updatable = false, insertable = false)
	private String ls;

	@Override
	public Integer getId() {
		return 0;
	}
	
	public void setId(Integer id) {
		
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
}

