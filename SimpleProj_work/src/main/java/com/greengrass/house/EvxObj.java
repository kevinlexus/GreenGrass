package com.greengrass.house;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="T_EVXOBJ")
public class EvxObj implements java.io.Serializable {
	
	private Integer id, fkobjxprop;//, tmo, cnt, max_cnt;
	private String fkevent;
	private ObjxProp objxprop;
	/*private Boolean cancel;  
	private Date nxtst;*/
	private Set<EvQue> evque = new HashSet<EvQue>();
		
	
	public EvxObj(){
	
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
	@SequenceGenerator(name="SEQ", sequenceName="T_SEQ_ID", allocationSize=10)	
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id=id;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FK_EVXOBJ")
	
	public Set<EvQue> getEvQue() {
		return this.evque;
	}

	public void setEvQue(Set<EvQue> evque) {
		this.evque = evque;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_OBJXPROP")
	public ObjxProp getObjxProp() {
		return this.objxprop;
	}

	public void setObjxProp(ObjxProp objxprop) {
		this.objxprop = objxprop;
	}

/*	@Column(name = "FK_OBJXPROP", unique = false, nullable = false)
	public int getFkObjxProp() {
		return this.fkobjxprop;
	}	
	
	public void setFkObjxProp(Integer fkobjxprop) {
		this.fkobjxprop=fkobjxprop;
	}*/

	@Column(name = "FK_EVENT", unique = false, nullable = false)
	public String getFkEvent() {
		return this.fkevent;
	}	
	
	public void setFkEvent(String fkevent) {
		this.fkevent=fkevent;
	}
	
	/*public Boolean isCd(String fkevent) {
		return this.fkevent.equals(fkevent);
	}

	@Column(name = "CANCEL", unique = false, nullable = true)
	public Boolean getCancel() {
		return this.cancel;
	}	
	
	public void setCancel(Boolean cancel) {
		this.cancel=cancel;
	}
	
	@Column(name = "TIMEOUT", unique = false, nullable = true)
	public Integer getTmo() {
		return this.tmo;
	}	
	
	public void setTmo(Integer tmo) {
		this.tmo=tmo;
	}
	
	@Column(name = "NEXT_START", unique = false, nullable = true)
	public Date getNxtst() {
		return this.nxtst;
	}	
	
	public void setNxtst(Date nxtst) {
		this.nxtst=nxtst;
	}

	@Column(name = "CNT", unique = false, nullable = true)
	public Integer getCnt() {
		return this.cnt;
	}	
	
	public void setCnt(Integer cnt) {
		this.cnt=cnt;
	}

	@Column(name = "MAX_CNT", unique = false, nullable = false)
	public Integer getMaxCnt() {
		return this.max_cnt;
	}	
	
	public void setMaxCnt(Integer max_cnt) {
		this.max_cnt=max_cnt;
	}
	
	@Transient
	public void Delay() {
		//отложить событие
		//увеличить счетчик повтора, (остальное отрабатывается в триггере) 
		setCnt(getCnt()+1);
	}*/
	
}
