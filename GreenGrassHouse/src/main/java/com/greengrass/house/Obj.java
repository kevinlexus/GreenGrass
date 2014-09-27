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
import javax.persistence.SequenceGenerator;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NaturalId;


@Entity
@Table(name="T_OBJ", uniqueConstraints = {
		@UniqueConstraint(columnNames = "CD") })
public class Obj implements java.io.Serializable {
	
	private Integer id;
	private String cd;
	private String name;
	private Set<ObjxProp> objxProp = new HashSet<ObjxProp>(0);

	public Obj(){
	
	}

	public Obj(String cd, String name){
	
		this.cd=cd;
		this.name=name;
	
	}

	public Obj(String cd, String name,
			   Set<ObjxProp> objxProp){
		
		this.cd=cd;
		this.name=name;
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
		this.id=id;
	}

	@NaturalId
	//@Column(name = "CD", unique = true, nullable = false, length = 32)
	public String getCd() {
		return this.cd;
	}
	public void setCd(String cd) {
		this.cd=cd;
	}

	@Column(name = "NAME", unique = false, nullable = true, length = 20)
	public String getName() {
		return this.name;
	}	
	
	public void setName(String name) {
		this.name=name;
	}
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.obj", cascade=CascadeType.ALL)
	public Set<ObjxProp> getObjxProp() {
		return this.objxProp;
	}
 
	public void setObjxProp(Set<ObjxProp> objxProp) {
		this.objxProp = objxProp;
	}
	
	public ObjxProp getObjxPropByCd (String cd) {
	//получить свойство объекта по cd  свойства	
		Iterator<ObjxProp> iter = this.objxProp.iterator(); 
		while (iter.hasNext()){
			ObjxProp objxProp = (ObjxProp) iter.next();
			if (objxProp.getProperty().getCd().equals(cd)) {
				return objxProp; 
			}
		}
		throw new IllegalArgumentException("Illegial searching for the Property with CD:'"+cd);
	}
	
	public Integer getObjxPropN1ByCd(String cd) {
		//получить свойство объекта по CD свойства
		ObjxProp prop = getObjxPropByCd(cd); 
		if (!prop.getProperty().getTpCd().equals("NM")) {
			throw new IllegalArgumentException("Illegial access to the Property '"+prop.getProperty().getCd()+
					"', it doesn't support type Number");
		}
		return prop.getN1(); 
	}
	
	public void setObjxPropN1ByCd(String cd, Integer val) {
		//установить свойство объекта по CD свойства
		ObjxProp prop = getObjxPropByCd(cd); 
		if (!prop.getProperty().getTpCd().equals("NM")) {
			throw new IllegalArgumentException("Illegial access to the Property '"+prop.getProperty().getCd()+
					"', it doesn't support type Number");
		}
		prop.setN1(val); 
	}

	public String getObjxPropS1ByCd(String cd) {
		//получить свойство объекта по CD свойства
		ObjxProp prop = getObjxPropByCd(cd); 
		if (!prop.getProperty().getTpCd().equals("ST")) {
			throw new IllegalArgumentException("Illegial access to the Property '"+prop.getProperty().getCd()+
					"', it doesn't support type Number");
		}
		return prop.getS1(); 
	}

	public void setObjxPropS1ByCd(String cd, String val) {
		//установить свойство объекта по CD свойства
		ObjxProp prop = getObjxPropByCd(cd); 
		if (!prop.getProperty().getTpCd().equals("NM")) {
			throw new IllegalArgumentException("Illegial access to the Property '"+prop.getProperty().getCd()+
					"', it doesn't support type Number");
		}
		prop.setS1(val); 
	}

	public Date getObjxPropD1ByCd(String cd) {
		//получить свойство объекта по CD свойства
		ObjxProp prop = getObjxPropByCd(cd); 
		if (!prop.getProperty().getTpCd().equals("ST")) {
			throw new IllegalArgumentException("Illegial access to the Property '"+prop.getProperty().getCd()+
					"', it doesn't support type Number");
		}
		return prop.getD1(); 
	}

	public void setObjxPropD1ByCd(String cd, Date val) {
		//установить свойство объекта по CD свойства
		ObjxProp prop = getObjxPropByCd(cd); 
		if (!prop.getProperty().getTpCd().equals("NM")) {
			throw new IllegalArgumentException("Illegial access to the Property '"+prop.getProperty().getCd()+
					"', it doesn't support type Number");
		}
		prop.setD1(val); 
	}
	
	
}
