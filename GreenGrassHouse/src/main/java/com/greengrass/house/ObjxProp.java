package com.greengrass.house;


import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "T_OBJXPROP")
@AssociationOverrides({
		@AssociationOverride(name = "pk.obj", 
			joinColumns = @JoinColumn(name = "FK_OBJ")),
		@AssociationOverride(name = "pk.property", 
			joinColumns = @JoinColumn(name = "FK_PROP")) })

public class ObjxProp implements java.io.Serializable {
	
	private ObjxPropId pk = new ObjxPropId();
	//значение свойства - Float
	private double n1;
	//значение свойства - Integer, Boolean
	private int i1;
	//значение свойства - String
	private String s1;
	//значение свойства - Date
	private Date d1;
	//ReadOnly=1, 0
	private int ro;
	//CD свойства в owfs (может быть именем файла)
	private String owfs_cd;

	public ObjxProp() {
		
	}
	
	@EmbeddedId
	public ObjxPropId getPk() {
		return pk;
	}
	
	public void setPk(ObjxPropId pk) {
		this.pk = pk;
	}	

	@Transient
	public Obj getObj() {
		return getPk().getObj();
	}

	public void setObj(Obj obj) {
		getPk().setObj(obj);
	}	
	
	@Transient
	public Property getProperty() {
		return getPk().getProperty();
	}
 
	public void setProperty(Property property) {
		getPk().setProperty(property);
	}
	
	@Column(name = "S1", nullable = true, length = 256)
	public String getS1() {
		return this.s1;
	}
 
	public void setS1(String s1) {
		this.s1 = s1;
	}	

	@Column(name = "OWFS_CD", nullable = true, length = 256)
	public String getOwfsCd() {
		return this.owfs_cd;
	}
 
	public void setOwfsCd(String owfs_cd) {
		this.owfs_cd = owfs_cd;
	}	

	@Column(name = "N1", nullable = false)
	public double getN1() { 
		return this.n1;
	}
 
	public void setN1(double n1) {
		this.n1 = n1;
	}	

	@Column(name = "I1", nullable = false)
	public int getI1() { 
		return this.i1;
	}
 
	public void setI1(int i1) {
		this.i1 = i1;
	}	

	//ReadOnly свойство?
	@Column(name = "RO", nullable = false)
	public int getRo() { 
		return this.ro;
	}
 
	public void setRo(int ro) {
		this.ro = ro;
	}	

	@Column(name = "D1", nullable = true)
	public Date getD1() {
		return this.d1;
	}
 
	public void setD1(Date d1) {
		this.d1 = d1;
	}	

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
 
		ObjxProp that = (ObjxProp) o;
 
		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;
 
		return true;
	}
 
	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
	

}
