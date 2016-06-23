package com.ric.bill.model.ar;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.ToString;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.ParamDef;

import com.ric.bill.MeterContains;
import com.ric.bill.RegContains;
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
		@AttributeOverride(name = "klsk", column = @Column(name = "FK_K_LSK")  )//зафигачил KUL, иначе если ставить lsk приводит к неэффективности ВНИМАНИЕ, ВЕРНУЛ LSK, ТАк как приводит к некорректной обработке (kul не уникальный!)
		}																  //короче KUL не фига не решил проблему, а её усугубил, так как это не уникальный идентификатор не фига
		)
@FilterDefs({
    @FilterDef(name = "FILTER_GEN_DT", defaultCondition = ":DT1 BETWEEN DT1 AND DT2", //фильтр для тарифов 
    		parameters = {@ParamDef(name = "DT1", type = "date")
    		}
    )
})
public class Kart extends Base implements java.io.Serializable, MeterContains, TarifContains, RegContains  {

	public Kart() {
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lsk", updatable = false, nullable = false)
	private String id; //id записи

	
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
	@BatchSize(size = 50)
	private Set<MeterLog> mlog = new HashSet<MeterLog>(0);

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_K_LSK")
	@BatchSize(size = 50)
	@NotFound(action=NotFoundAction.IGNORE)
	@Filters({
	    @Filter(name = "FILTER_GEN_DT")})
	private Set<TarifKlsk> tarifklsk = new HashSet<TarifKlsk>(0);

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

	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id=id;
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

	public Set<TarifKlsk> getTarifklsk() {
		return tarifklsk;
	}

	public void setTarifklsk(Set<TarifKlsk> tarifklsk) {
		this.tarifklsk = tarifklsk;
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

