package com.ric.bill.model.bs;

import java.util.ArrayList;
import java.util.List;

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

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Type;

import com.ric.bill.Storable;
import com.ric.bill.model.mt.Meter;
import com.ric.bill.model.tr.ServTree;



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

	//виртуальная услуга
	@Type(type= "org.hibernate.type.NumericBooleanType")
	@Column(name = "VRT", nullable = true)
	private Boolean vrt; 

	//услуга, на расчет которой повлияет разница от текущей и дополнительных услуг, участвующих в округлении (заполнено, если текущая - виртуальная услуга)
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_ROUND", referencedColumnName="ID")
	private Serv servRound;
	
	//виртуальная услуга, по отношению к текущей
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_VRT", referencedColumnName="ID")
	private Serv servVrt;
	
	//иерархия услуги
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_SERV", referencedColumnName="ID")
	@BatchSize(size = 50)
	private List<ServTree> servTree = new ArrayList<ServTree>(0);

	@Type(type= "org.hibernate.type.NumericBooleanType")
	@Column(name = "INCL_ABSN", nullable = true)
	private Boolean inclAbsn;//учитывать временно отсут (да / нет) при расчете услуги
	
	//учитывать временно зарегистр (да / нет) при расчете услуги
	@Type(type= "org.hibernate.type.NumericBooleanType")
	@Column(name = "INCL_PRSN", nullable = true)
	private Boolean inclPrsn;

	//вернуть klsk объекта (в каждом подклассе свой метод из за того что колонка может иметь другое название!)
	@Column(name = "FK_K_LSK", nullable = true)
	private Integer klsk;

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
	
	public Boolean getVrt() {
		if (vrt==null) {
			return false;
		} else {
			return vrt;
		}
	}
	public void setVrt(Boolean vrt) {
		this.vrt = vrt;
	}
	public Serv getServRound() {
		return servRound;
	}
	public void setServRound(Serv servRound) {
		this.servRound = servRound;
	}
	public Serv getServVrt() {
		return servVrt;
	}
	public void setServVrt(Serv servVrt) {
		this.servVrt = servVrt;
	}
		
	public List<ServTree> getServTree() {
		return servTree;
	}
	public void setServTree(List<ServTree> servTree) {
		this.servTree = servTree;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cd == null) ? 0 : cd.hashCode());
		result = prime * result
				+ ((checkOrg == null) ? 0 : checkOrg.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((inclAbsn == null) ? 0 : inclAbsn.hashCode());
		result = prime * result
				+ ((inclPrsn == null) ? 0 : inclPrsn.hashCode());
		result = prime * result + ((klsk == null) ? 0 : klsk.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((npp == null) ? 0 : npp.hashCode());
		result = prime * result + ((npp2 == null) ? 0 : npp2.hashCode());
		result = prime * result
				+ ((servChrg == null) ? 0 : servChrg.hashCode());
		result = prime * result + ((servMet == null) ? 0 : servMet.hashCode());
		result = prime * result + ((servOdn == null) ? 0 : servOdn.hashCode());
		result = prime * result + ((servOrg == null) ? 0 : servOrg.hashCode());
		result = prime * result
				+ ((servRound == null) ? 0 : servRound.hashCode());
		result = prime * result + ((servSt == null) ? 0 : servSt.hashCode());
		result = prime * result
				+ ((servStKeep == null) ? 0 : servStKeep.hashCode());
		result = prime * result
				+ ((servTree == null) ? 0 : servTree.hashCode());
		result = prime * result
				+ ((servUpst == null) ? 0 : servUpst.hashCode());
		result = prime * result + ((servVrt == null) ? 0 : servVrt.hashCode());
		result = prime * result
				+ ((servWokpr == null) ? 0 : servWokpr.hashCode());
		result = prime * result + ((vrt == null) ? 0 : vrt.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serv other = (Serv) obj;
		if (cd == null) {
			if (other.cd != null)
				return false;
		} else if (!cd.equals(other.cd))
			return false;
		if (checkOrg == null) {
			if (other.checkOrg != null)
				return false;
		} else if (!checkOrg.equals(other.checkOrg))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inclAbsn == null) {
			if (other.inclAbsn != null)
				return false;
		} else if (!inclAbsn.equals(other.inclAbsn))
			return false;
		if (inclPrsn == null) {
			if (other.inclPrsn != null)
				return false;
		} else if (!inclPrsn.equals(other.inclPrsn))
			return false;
		if (klsk == null) {
			if (other.klsk != null)
				return false;
		} else if (!klsk.equals(other.klsk))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (npp == null) {
			if (other.npp != null)
				return false;
		} else if (!npp.equals(other.npp))
			return false;
		if (npp2 == null) {
			if (other.npp2 != null)
				return false;
		} else if (!npp2.equals(other.npp2))
			return false;
		if (servChrg == null) {
			if (other.servChrg != null)
				return false;
		} else if (!servChrg.equals(other.servChrg))
			return false;
		if (servMet == null) {
			if (other.servMet != null)
				return false;
		} else if (!servMet.equals(other.servMet))
			return false;
		if (servOdn == null) {
			if (other.servOdn != null)
				return false;
		} else if (!servOdn.equals(other.servOdn))
			return false;
		if (servOrg == null) {
			if (other.servOrg != null)
				return false;
		} else if (!servOrg.equals(other.servOrg))
			return false;
		if (servRound == null) {
			if (other.servRound != null)
				return false;
		} else if (!servRound.equals(other.servRound))
			return false;
		if (servSt == null) {
			if (other.servSt != null)
				return false;
		} else if (!servSt.equals(other.servSt))
			return false;
		if (servStKeep == null) {
			if (other.servStKeep != null)
				return false;
		} else if (!servStKeep.equals(other.servStKeep))
			return false;
		if (servTree == null) {
			if (other.servTree != null)
				return false;
		} else if (!servTree.equals(other.servTree))
			return false;
		if (servUpst == null) {
			if (other.servUpst != null)
				return false;
		} else if (!servUpst.equals(other.servUpst))
			return false;
		if (servVrt == null) {
			if (other.servVrt != null)
				return false;
		} else if (!servVrt.equals(other.servVrt))
			return false;
		if (servWokpr == null) {
			if (other.servWokpr != null)
				return false;
		} else if (!servWokpr.equals(other.servWokpr))
			return false;
		if (vrt == null) {
			if (other.vrt != null)
				return false;
		} else if (!vrt.equals(other.vrt))
			return false;
		return true;
	}


	
}

