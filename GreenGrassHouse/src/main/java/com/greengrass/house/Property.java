package com.greengrass.house;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;


@Entity
@Table(name = "T_PROP")
public class Property  implements java.io.Serializable {
	
	private Integer id;
	private String name, tpcd, cd;
	private Set<ObjxProp> objxProp = new HashSet<ObjxProp>(0);
	
	public Property() {
	}
 
	public Property(String cd, String name) {
		this.name = name;
	}
 
	public Property(String name, Set<ObjxProp> objxProp) {
		this.name = name;
		this.objxProp = objxProp;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
	@SequenceGenerator(name="SEQ", sequenceName="T_SEQ_ID", allocationSize=10)	
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}
 
	public void setId(Integer id) {
		this.id = id;
	}
 
	
	@NaturalId
	public String getCd() {
		return this.cd;
	}
 
	public void setCd(String cd) {
		this.cd = cd;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.property")
	public Set<ObjxProp> getObjxProp() {
		return this.objxProp;
	}
 
	public void setObjxProp(Set<ObjxProp> objxProp) {
		this.objxProp = objxProp;
	}
}
