package com.ric.bill.model.bs;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

	@Type(type= "org.hibernate.type.NumericBooleanType")
	@Column(name = "CHECK_ORG", updatable = false, nullable = true)
	private Boolean checkOrg;//проверять наличие организации в тарифе (да/нет)
	
	//услуга содержащая счётчик
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_MET", referencedColumnName="ID")
	private Serv servMet; 
	
	//услуга содержащая счётчик ОДН
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ODN", referencedColumnName="ID")
	private Serv servOdn; 

	//услуга содержащая норматив в тарифе
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ST_KEEP", referencedColumnName="ID")
	private Serv servStKeep; 

	//услуга по соцнорме
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ST", referencedColumnName="ID")
	private Serv servSt; 

	//услуга свыше соцнормы, к данной 
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_UPST", referencedColumnName="ID")
	private Serv servUpst; 

	//услуга без проживающих, к данной 
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_WOKPR", referencedColumnName="ID")
	private Serv servWokpr; 

	//услуга содержащая организацию 
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_FORG", referencedColumnName="ID")
	private Serv servOrg; 

	//основная услуга, для начисления
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_CHRG", referencedColumnName="ID")
	private Serv servChrg; 

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

	public Serv getServMet() {
		return servMet;
	}

	public void setServMet(Serv met) {
		this.servMet = met;
	}

	public Serv getServOdn() {
		return servOdn;
	}

	public void setServOdn(Serv odn) {
		this.servOdn = odn;
	}

	public Serv getServChrg() {
		return servChrg;
	}

	public void setServChrg(Serv chrg) {
		this.servChrg = chrg;
	}

	public Serv getServUpst() {
		return servUpst;
	}
	public void setServUpst(Serv upst) {
		this.servUpst = upst;
	}

	public Serv getServWokpr() {
		return servWokpr;
	}
	
	public void setServWokpr(Serv wokpr) {
		this.servWokpr = wokpr;
	}

	public Serv getServOrg() {
		return servOrg;
	}
	
	public void setServOrg(Serv org) {
		this.servOrg = org;
	}

	public Boolean getCheckOrg() {
		if (checkOrg==null) {
			return false;
		} else {
			return checkOrg;
		}
	}
	
	public void setCheckOrg(Boolean checkOrg) {
		this.checkOrg = checkOrg;
	}
	
	public Serv getServStKeep() {
		return servStKeep;
	}
	public void setServStKeep(Serv servStKeep) {
		this.servStKeep = servStKeep;
	}
	public Serv getServSt() {
		return servSt;
	}
	public void setServSt(Serv servSt) {
		this.servSt = servSt;
	}
	@Override
	   public boolean equals(Object o) {
	       if (this == o) return true;
	       if (!(o instanceof Serv)) return false;
	     
	       Serv otherServ = (Serv) o;
	     
	       if (getId() != null ?
	           !getId().equals(otherServ.getId()) : otherServ.getId() != null)
	           return false;
	     
	       return true;
	   }
		

}

