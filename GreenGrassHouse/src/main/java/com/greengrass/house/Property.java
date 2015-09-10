package com.greengrass.house;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;


@Entity
@Table(name = "T_PROP")
public class Property  implements java.io.Serializable {
	
	private String id, name, tpcd;
	private Set<ObjxProp> objxprop = new HashSet<ObjxProp>(0);
	
	public Property() {
	}
 
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "ID", unique = true, nullable = false)
	public String getId() {
		return this.id;
	}
 
	public void setId(String id) {
		this.id = id;
	}
 
	
	@Column(name = "NAME", nullable = true, length = 64)
	public String getName() {
		return this.name;
	}
 
	public void setName(String name) {
		this.name = name;  
	}	
	
	@Column(name = "TP_CD", nullable = false, length = 64)
	public String getTpCd() {
		return this.tpcd;
	}
 
	public void setTpCd(String tpcd) {
		this.tpcd = tpcd;
	}	

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "FK_PROP")
	public Set<ObjxProp> getObjxProp() {
		return this.objxprop;
	}
	
	public void setObjxProp(Set<ObjxProp> objxProp) {
		this.objxprop = objxProp;
	}
}
