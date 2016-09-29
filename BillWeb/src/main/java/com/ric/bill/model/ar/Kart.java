package com.ric.bill.model.ar;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
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

import org.hibernate.annotations.BatchSize;

import com.ric.bill.MeterContains;
import com.ric.bill.RegContains;
import com.ric.bill.Storable;
import com.ric.bill.TarifContains;
import com.ric.bill.model.bs.Base;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.fn.Chrg;
import com.ric.bill.model.mt.MeterLog;
import com.ric.bill.model.ps.Reg;
import com.ric.bill.model.ps.RegState;
import com.ric.bill.model.tr.TarifKlsk;

/**
 * Принадлежность лицевого к управляющей компаниии
 * 
 * Лев (10:57:37 26/09/2016) 
 * но это же не лицевой счет)) это таблица связей лиц.счета (которого у нас теперь нет) с УК
 * ***KnяZь'**** (10:57:59 26/09/2016) 
 * это два в одном
 * Лев (11:00:33 26/09/2016) 
 * это отступление от корректной схемы, ну ладно, фиг с ним
 * 
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "KART", schema="AR")
@AssociationOverrides({
	   @AssociationOverride(name = "dw",
	      joinColumns = @JoinColumn(referencedColumnName = "FK_KLSK_OBJ"))
	})
@AttributeOverride(name = "klsk", column = @Column(name = "FK_KLSK_OBJ"))
public class Kart extends Base implements java.io.Serializable, MeterContains, TarifContains, RegContains  {

	public Kart() {
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lsk", updatable = false, nullable = false)
	private Integer lsk; //id записи
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_KW", referencedColumnName="ID", updatable = false, insertable = false)
	private Kw kw;

	//Обслуживающая УК
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FK_UK", referencedColumnName="ID", updatable = false, insertable = false)
	private Org uk;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_KLSK_OBJ")
	@BatchSize(size = 50)
	private List<MeterLog> mlog = new ArrayList<MeterLog>(0);

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_KLSK_OBJ")
	@BatchSize(size = 50)
	private List<TarifKlsk> tarifklsk = new ArrayList<TarifKlsk>(0);

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_KLSK_OBJ")
	@BatchSize(size = 500)
	private List<Reg> reg = new ArrayList<Reg>(0);

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_KLSK_OBJ", referencedColumnName="FK_KLSK_OBJ")
	@BatchSize(size = 500)
	private List<RegState> regState = new ArrayList<RegState>(0);

	@Column(name = "FK_KW", nullable = true)
	private Integer fkKw;

	//Лиц.счет из квартплаты - для поиска
	@Column(name = "FLSK", nullable = true, updatable = false, insertable = false)
	private String flsk;

	//Записи начисления
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="LSK", referencedColumnName="LSK", updatable = false)
	@BatchSize(size = 50)
	private List<Chrg> chrg = new ArrayList<Chrg>(0);

	public Kw getKw() {
		return kw;
	}
	
	public void setKw(Kw kw) {
		this.kw = kw;
	}
	
	public List<MeterLog> getMlog() {
		return mlog;
	}

	public void setMlog(List<MeterLog> mlog) {
		this.mlog = mlog;
	}

	public List<TarifKlsk> getTarifklsk() {
		return tarifklsk;
	}

	public void setTarifklsk(List<TarifKlsk> tarifklsk) {
		this.tarifklsk = tarifklsk;
	}

	public List<Reg> getReg() {
		return reg;
	}

	public void setReg(List<Reg> reg) {
		this.reg = reg;
	}

	public List<RegState> getRegState() {
		return regState;
	}

	public void setRegState(List<RegState> regState) {
		this.regState = regState;
	}

	public Integer getFkKw() {
		return fkKw;
	}

	public void setFkKw(Integer fkKw) {
		this.fkKw = fkKw;
	}

	public List<Chrg> getChrg() {
		return chrg;
	}

	public void setChrg(List<Chrg> chrg) {
		this.chrg = chrg;
	}

	public String getFlsk() {
		return flsk;
	}

	public void setFlsk(String flsk) {
		this.flsk = flsk;
	}

	public Integer getLsk() {
		return lsk;
	}

	public void setLsk(Integer lsk) {
		this.lsk = lsk;
	}

	public Org getUk() {
		return uk;
	}

	public void setUk(Org uk) {
		this.uk = uk;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chrg == null) ? 0 : chrg.hashCode());
		result = prime * result + ((fkKw == null) ? 0 : fkKw.hashCode());
		result = prime * result + ((flsk == null) ? 0 : flsk.hashCode());
		result = prime * result + ((getKlsk() == null) ? 0 : getKlsk().hashCode());
		result = prime * result + ((kw == null) ? 0 : kw.hashCode());
		result = prime * result + ((lsk == null) ? 0 : lsk.hashCode());
		result = prime * result + ((mlog == null) ? 0 : mlog.hashCode());
		result = prime * result + ((reg == null) ? 0 : reg.hashCode());
		result = prime * result
				+ ((regState == null) ? 0 : regState.hashCode());
		result = prime * result
				+ ((tarifklsk == null) ? 0 : tarifklsk.hashCode());
		result = prime * result + ((uk == null) ? 0 : uk.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kart other = (Kart) obj;
		if (chrg == null) {
			if (other.chrg != null)
				return false;
		} else if (!chrg.equals(other.chrg))
			return false;
		if (fkKw == null) {
			if (other.fkKw != null)
				return false;
		} else if (!fkKw.equals(other.fkKw))
			return false;
		if (flsk == null) {
			if (other.flsk != null)
				return false;
		} else if (!flsk.equals(other.flsk))
			return false;
		if (getKlsk() == null) {
			if (other.getKlsk() != null)
				return false;
		} else if (!getKlsk().equals(other.getKlsk()))
			return false;
		if (kw == null) {
			if (other.kw != null)
				return false;
		} else if (!kw.equals(other.kw))
			return false;
		if (lsk == null) {
			if (other.lsk != null)
				return false;
		} else if (!lsk.equals(other.lsk))
			return false;
		if (mlog == null) {
			if (other.mlog != null)
				return false;
		} else if (!mlog.equals(other.mlog))
			return false;
		if (reg == null) {
			if (other.reg != null)
				return false;
		} else if (!reg.equals(other.reg))
			return false;
		if (regState == null) {
			if (other.regState != null)
				return false;
		} else if (!regState.equals(other.regState))
			return false;
		if (tarifklsk == null) {
			if (other.tarifklsk != null)
				return false;
		} else if (!tarifklsk.equals(other.tarifklsk))
			return false;
		if (uk == null) {
			if (other.uk != null)
				return false;
		} else if (!uk.equals(other.uk))
			return false;
		return true;
	}

	
	
}

