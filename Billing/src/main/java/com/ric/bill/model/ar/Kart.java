package com.ric.bill.model.ar;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.ToString;

import com.ric.bill.MeterContains;
import com.ric.bill.TarifContains;
import com.ric.bill.model.bs.Base;
import com.ric.bill.model.mt.MeterLog;
import com.ric.bill.model.ps.Reg;
import com.ric.bill.model.ps.RegState;
import com.ric.bill.model.tr.TarifKlsk;

/**
 * Лицевой счет
 * @author lev
 *
 */
@ToString(callSuper=true, includeFieldNames=true)
@SuppressWarnings("serial")
@Entity
@Table(name = "KART", schema="AR")
@AttributeOverrides({
		@AttributeOverride(name = "klsk", column = @Column(name = "FK_K_LSK")  ),
		@AttributeOverride(name = "id", column = @Column(name = "KUL")	) //зафигачил KUL, иначе если ставить lsk приводит к неэффективности
		}
		)
public class Kart extends Base implements java.io.Serializable, MeterContains, TarifContains  {

	public Kart() {
	}

	@ManyToOne(fetch = FetchType.LAZY)
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
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_K_LSK")
	@BatchSize(size = 20)
	private Set<MeterLog> mlog = new HashSet<MeterLog>(0);

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_K_LSK")
	@BatchSize(size = 20)
	private Set<TarifKlsk> tarklsk = new HashSet<TarifKlsk>(0);

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="LSK", referencedColumnName="LSK")
	@BatchSize(size = 500)
	private Set<Reg> reg = new HashSet<Reg>(0);

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="LSK", referencedColumnName="LSK")
	@BatchSize(size = 500)
	private Set<RegState> regState = new HashSet<RegState>(0);

	@Column(name = "FK_KW", nullable = true)
	private Integer fkKw;

	//ФИО владельца
	@Column(name = "FIO", nullable = true)
	private String fio;
	
	//Лиц.счет
	@Column(name = "LSK", nullable = true, updatable = false, insertable = false)
	private String lsk;

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
	
	public String getLsk() {
		return lsk;
	}
	
	public void setLsk(String lsk) {
		this.lsk = lsk;
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

	public Set<Reg> getReg() {
		return reg;
	}

	public void setReg(Set<Reg> reg) {
		this.reg = reg;
	}

	public Set<RegState> getRegState() {
		return regState;
	}

	public void setRegState(Set<RegState> regState) {
		this.regState = regState;
	}

	public Integer getFkKw() {
		return fkKw;
	}

	public void setFkKw(Integer fkKw) {
		this.fkKw = fkKw;
	}

}

