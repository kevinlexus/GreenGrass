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
	//CD устройства в owfs (может быть именем папки)
	private String owfs_cd;
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
	
	@Column(name = "OWFS_CD", unique = false, nullable = true, length = 128)
	public String getOwfsCd() {
		return this.owfs_cd;
	}	
	
	public void setOwfsCd(String owfs_cd) {
		this.owfs_cd=owfs_cd;
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
		throw new IllegalArgumentException("Not found Property with CD:'"+cd+" in object "+this.cd);
	}
	
	public double getObjxPropNumByCd(String cd) {
		//получить свойство объекта по CD свойства
		ObjxProp prop = getObjxPropByCd(cd); 
		if (!prop.getProperty().getTpCd().equals("NM")) {
			throw new IllegalArgumentException("Property '"+prop.getProperty().getCd()+
					"', doesn't support type double in object "+this.cd);
		}
		return prop.getN1(); 
	}
	
	public void setObjxPropNumByCd(String cd, double val) {
		//установить свойство объекта по CD свойства
		ObjxProp prop = getObjxPropByCd(cd); 
		if (!prop.getProperty().getTpCd().equals("NM")) {
			throw new IllegalArgumentException("Property '"+prop.getProperty().getCd()+
					"', doesn't support type double");
		} else if (prop.getRo()==1) {
		//Свойство ReadOnly? Отказать в записи
			throw new IllegalArgumentException("Property '"+prop.getProperty().getCd()+
					"' ReadOnly in object "+this.cd);
		}

		prop.setN1(val); 
	}

	
	public int getObjxPropIntByCd(String cd) {
		//получить свойство объекта по CD свойства
		ObjxProp prop = getObjxPropByCd(cd); 
		if (!prop.getProperty().getTpCd().equals("IT")) {
			throw new IllegalArgumentException("Property '"+prop.getProperty().getCd()+
					"', doesn't support type int in object "+this.cd);
		}
		return prop.getI1(); 
	}
	
	public void setObjxPropIntByCd(String cd, int val) {
		//установить свойство объекта по CD свойства
		ObjxProp prop = getObjxPropByCd(cd); 
		if (!prop.getProperty().getTpCd().equals("IT")) {
			throw new IllegalArgumentException("Property '"+prop.getProperty().getCd()+
					"', doesn't support type int in object "+this.cd);
		} else if (prop.getRo()==1) {
		//Свойство ReadOnly? Отказать в записи
			throw new IllegalArgumentException("Property '"+prop.getProperty().getCd()+
					"' ReadOnly in object "+this.cd);
		}

		prop.setI1(val); 
	}	
	public String getObjxPropStrByCd(String cd) {
		//получить свойство объекта по CD свойства
		ObjxProp prop = getObjxPropByCd(cd); 
		if (!prop.getProperty().getTpCd().equals("ST")) {
			throw new IllegalArgumentException("Property '"+prop.getProperty().getCd()+
					"', doesn't support type String in object "+this.cd);
		}
		return prop.getS1(); 
	}

	public void setObjxPropStrByCd(String cd, String val) {
		//установить свойство объекта по CD свойства
		ObjxProp prop = getObjxPropByCd(cd); 
		if (!prop.getProperty().getTpCd().equals("ST")) {
			throw new IllegalArgumentException("Property '"+prop.getProperty().getCd()+
					"', doesn't support type String in object "+this.cd);
		} else if (prop.getRo()==1) {
		//Свойство ReadOnly? Отказать в записи
			throw new IllegalArgumentException("Property '"+prop.getProperty().getCd()+
					"' ReadOnly in object "+this.cd);
		}

		prop.setS1(val); 
	}

	public Boolean getObjxPropBoolByCd(String cd) {
		//получить свойство объекта по CD свойства
		ObjxProp prop = getObjxPropByCd(cd); 
		if (!prop.getProperty().getTpCd().equals("BL")) {
			throw new IllegalArgumentException("Property '"+prop.getProperty().getCd()+
					"', doesn't support type String in object "+this.cd);
		}
        //Вернуть:
		//True как 1	
		//False как 0
		int val1 = prop.getI1();
		Boolean val = null;
		if (val1==0) {
		  	val=false;
		} else if (val1==1) {
		  	val=true;
		}
		return val; 
	}

	public void setObjxPropBoolByCd(String cd, Boolean val) {
		//установить свойство объекта по CD свойства
		ObjxProp prop = getObjxPropByCd(cd); 
		if (!prop.getProperty().getTpCd().equals("BL")) {
			throw new IllegalArgumentException("Property '"+prop.getProperty().getCd()+
					"', doesn't support type String in object "+this.cd);
		} else if (prop.getRo()==1) {
		//Свойство ReadOnly? Отказать в записи
			throw new IllegalArgumentException("Property '"+prop.getProperty().getCd()+
					"' ReadOnly in object "+this.cd);
		}
		//Установить:
		if (val) {
		  //True как 1	
      	  prop.setI1(1); 
		} else {
		  //False как 0	
     	  prop.setI1(0); 
		}
	}

	public Date getObjxPropDateByCd(String cd) {
		//получить свойство объекта по CD свойства
		ObjxProp prop = getObjxPropByCd(cd); 
		if (!prop.getProperty().getTpCd().equals("DT")) {
			throw new IllegalArgumentException("Property '"+prop.getProperty().getCd()+
					"', doesn't support type Date in object "+this.cd);
		}
		return prop.getD1(); 
	}

	public void setObjxPropDateByCd(String cd, Date val) {
		//установить свойство объекта по CD свойства
		ObjxProp prop = getObjxPropByCd(cd); 
		if (!prop.getProperty().getTpCd().equals("DT")) {
			throw new IllegalArgumentException("Property '"+prop.getProperty().getCd()+
					"', doesn't support type Date in object "+this.cd);
		} else if (prop.getRo()==1) {
		//Свойство ReadOnly? Отказать в записи
			throw new IllegalArgumentException("Property '"+prop.getProperty().getCd()+
					"' ReadOnly");
		}

		prop.setD1(val); 
	}
	
	
}
