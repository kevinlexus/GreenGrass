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
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.annotations.NaturalId;
import org.springframework.transaction.annotation.Transactional;


@Entity
@Table(name="T_OBJ", uniqueConstraints = {
		@UniqueConstraint(columnNames = "CD") })
public class Obj implements java.io.Serializable {
	
	private Integer id;
	private String cd;
	private String name;
	private String tp;
	//CD устройства в owfs (может быть именем папки)
	private String owfs_cd;
	private Set<ObjxProp> objxprop = new HashSet<ObjxProp>(0);

	public Obj(){
		
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

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "FK_OBJ")
	public Set<ObjxProp> getObjxProp() {
		return this.objxprop;
	}

	public void setObjxProp(Set<ObjxProp> objxprop) {
		this.objxprop = objxprop;
	}

	
	@Transient
	public ObjxProp getProp (String id) {
	//получить свойство объекта по cd  свойства	
		Iterator<ObjxProp> iter = this.objxprop.iterator(); 
		while (iter.hasNext()){
			ObjxProp objxProp = (ObjxProp) iter.next();
			if (objxProp.getProperty().getId().equals(id)) {
				return objxProp; 
			}
		}
		throw new IllegalArgumentException("Not found Property with ID:'"+id+" in object "+this.cd);
	}

	

	@Transient 
	public Boolean findProp (String id) {
	//получить свойство объекта по cd  свойства	
		Iterator<ObjxProp> iter = this.objxprop.iterator(); 
		while (iter.hasNext()){
			ObjxProp objxProp = (ObjxProp) iter.next();
			if (objxProp.getProperty().getId().equals(id)) {
				return true; 
			}
		}
		return false;
	}

	@Transient
	public Double getDbl(String cd) {
		//получить свойство объекта по CD свойства
		ObjxProp prop = getProp(cd); 
		if (!prop.getProperty().getTpCd().equals("DB")) {
			throw new IllegalArgumentException("Property '"+prop.getProperty().getId()+
					"', doesn't support type double in object "+this.cd);
		}
		return prop.getN1(); 
	}
	
	@Transient
	public void setDbl(String cd, Double val) {
		//установить свойство объекта по CD свойства
		ObjxProp prop = getProp(cd); 
		if (!prop.getProperty().getTpCd().equals("DB")) {
			throw new IllegalArgumentException("Property '"+prop.getProperty().getId()+
					"', doesn't support type double");
		}

		prop.setN1(val); 
	}

	
	@Transient
	public Integer getInt(String cd) {
		//получить свойство объекта по CD свойства
		ObjxProp prop = getProp(cd); 
		if (!prop.getProperty().getTpCd().equals("IT")) {
			throw new IllegalArgumentException("Property '"+prop.getProperty().getId()+
					"', doesn't support type Integer in object "+this.cd);
		}
		return prop.getI1(); 
	}
	
	@Transient
	public void setInt(String cd, Integer val) {
		//установить свойство объекта по CD свойства
		ObjxProp prop = getProp(cd); 
		if (!prop.getProperty().getTpCd().equals("IT")) {
			throw new IllegalArgumentException("Property '"+prop.getProperty().getId()+
					"', doesn't support type Integer in object "+this.cd);
		}

		prop.setI1(val); 
	}	
	@Transient
	public String getStr(String cd) {
		//получить свойство объекта по CD свойства
		ObjxProp prop = getProp(cd); 
		if (!prop.getProperty().getTpCd().equals("ST")) {
			throw new IllegalArgumentException("Property '"+prop.getProperty().getId()+
					"', doesn't support type String in object "+this.cd);
		}
		return prop.getS1(); 
	}

	@Transient
	public void setStr(String cd, String val) {
		//установить свойство объекта по CD свойства
		ObjxProp prop = getProp(cd); 
		if (!prop.getProperty().getTpCd().equals("ST")) {
			throw new IllegalArgumentException("Property '"+prop.getProperty().getId()+
					"', doesn't support type String in object "+this.cd);
		}

		prop.setS1(val); 
	}

	@Transient
	public Boolean getBool(String cd) {
		//получить свойство объекта по CD свойства
		ObjxProp prop = getProp(cd); 
		if (!prop.getProperty().getTpCd().equals("BL")) {
			throw new IllegalArgumentException("Property '"+prop.getProperty().getId()+
					"', doesn't support type Boolean in object "+this.cd);
		}
        //Вернуть:
		//True как 1	
		//False как 0
		Integer val1 = prop.getI1();
		Boolean val = null;
		if (val1==null) {
 	  	   val=false;
		} else if (val1==0) {
	  	   val=false;
		} else if (val1==1) {
 	  	   val=true;
		}
		return val; 
	}

	@Transient
	public void setBool(String cd, Boolean val) {
		//установить свойство объекта по CD свойства
		ObjxProp prop = getProp(cd); 
		if (!prop.getProperty().getTpCd().equals("BL")) {
			throw new IllegalArgumentException("Property '"+prop.getProperty().getId()+
					"', doesn't support type Boolean in object "+this.cd);
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

	@Transient
	public Date getDt(String cd) {
		//получить свойство объекта по CD свойства
		ObjxProp prop = getProp(cd); 
		if (!prop.getProperty().getTpCd().equals("DT")) {
			throw new IllegalArgumentException("Property '"+prop.getProperty().getId()+
					"', doesn't support type Date in object "+this.cd);
		}
		return prop.getD1(); 
	}

	@Transient
	public void setDt(String cd, Date val) {
		//установить свойство объекта по CD свойства
		ObjxProp prop = getProp(cd); 
		if (!prop.getProperty().getTpCd().equals("DT")) {
			throw new IllegalArgumentException("Property '"+prop.getProperty().getId()+
					"', doesn't support type Date in object "+this.cd);
		}

		prop.setD1(val); 
	}
	
	@Transient // Hibernate will never populate your transient fields and what is most important transient fields are not even part of the java serialisation process. 
    public void on () {
    	//простой метод - включить (будет работать только для тех объектов, где есть свойство SWITCHED_ON
    	setBool("SWITCHED_ON", true);
    }
	
	@Transient
    public void off () {
    	//простой метод - выключить (будет работать только для тех объектов, где есть свойство SWITCHED_ON
    	setBool("SWITCHED_ON", false);
    }
    	
    @Transient
    public Boolean is_on () {
    	//простой метод - включен ли?
    	return getBool("SWITCHED_ON");
    }
	
	public Boolean isCd(String cd) {
		return this.cd.equals(cd);
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
	
	@Column(name = "FK_TP", unique = false, nullable = false, length = 32)
	public String getTp() {
		return this.tp;
	}	
	
	public void setTp(String tp) {
		this.tp=tp;
	}

	@Column(name = "OWFS_CD", unique = false, nullable = true, length = 128)
	public String getOwfsCd() {
		return this.owfs_cd;
	}	
	
	public void setOwfsCd(String owfs_cd) {
		this.owfs_cd=owfs_cd;
	}


}
