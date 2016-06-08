package com.ric.bill.model.bs;

import javax.persistence.AttributeOverride;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

import com.ric.bill.Storable;



/**
 * Услуга
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SERV", schema="TR")
@AttributeOverride(name = "klsk", column = @Column(name = "FK_K_LSK"))
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region="billCache")
@Cacheable
public class Serv extends Base implements java.io.Serializable, Storable {

	
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
	
	@Column(name = "CD", updatable = false, nullable = false)
    private String cd;//CD 

	@Column(name = "NAME", updatable = false, nullable = true)
    private String name;//наименование 
	
	@Column(name = "NPP", updatable = false, nullable = true)
	private Integer npp;//№ п.п.
	
	@Column(name = "NPP2", updatable = false, nullable = true)
	private Integer npp2;//№ п.п. для распределения объема

	// услуга содержащая счётчик
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_MET", referencedColumnName="ID")
	private Serv met; 
	
	// услуга содержащая счётчик ОДН
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ODN", referencedColumnName="ID")
	private Serv odn; 

	// услуга содержащая норматив
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ST_KEEP", referencedColumnName="ID")
	private Serv stdrt; 

	// основная услуга, для начисления
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_CHRG", referencedColumnName="ID")
	private Serv chrg; 

	@Type(type= "org.hibernate.type.NumericBooleanType")
	@Column(name = "INCL_ABSN", nullable = true)
	private Boolean inclAbsn;//учитывать временно отсут (да / нет) при расчете услуги
	
	@Type(type= "org.hibernate.type.NumericBooleanType")
	@Column(name = "INCL_PRSN", nullable = true)
	private Boolean inclPrsn;//учитывать временно зарегистр (да / нет) при расчете услуги

	//вернуть klsk объекта (в каждом подклассе свой метод из за того что колонка может иметь другое название!)
	@Column(name = "FK_K_LSK", nullable = true)
	public Integer getKlsk() {
		return this.klsk;
	}

	public void setKlsk(Integer klsk) {
		this.klsk=klsk;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNpp() {
		return npp;
	}

	public void setNpp(Integer npp) {
		this.npp = npp;
	}

	public Integer getNpp2() {
		return npp2;
	}

	public void setNpp2(Integer npp2) {
		this.npp2 = npp2;
	}

	public Boolean getInclAbsn() {
		if (inclAbsn==null) {
			return false;
		} else {
			return inclAbsn;
		}
	}

	public void setInclAbsn(Boolean inclAbsn) {
		this.inclAbsn = inclAbsn;
	}

	public Boolean getInclPrsn() {
		if (inclPrsn==null) {
			return false;
		} else {
			return inclPrsn;
		}
	}

	public void setInclPrsn(Boolean inclPrsn) {
		this.inclPrsn = inclPrsn;
	}

	public Serv getMet() {
		return met;
	}

	public void setMet(Serv met) {
		this.met = met;
	}

	public Serv getOdn() {
		return odn;
	}

	public void setOdn(Serv odn) {
		this.odn = odn;
	}

	public Serv getStdrt() {
		return stdrt;
	}

	public void setStdrt(Serv stdrt) {
		this.stdrt = stdrt;
	}

	public Serv getChrg() {
		return chrg;
	}

	public void setChrg(Serv chrg) {
		this.chrg = chrg;
	}


}

