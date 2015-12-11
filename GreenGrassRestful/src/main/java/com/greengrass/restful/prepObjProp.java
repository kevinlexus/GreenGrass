package com.greengrass.restful;

import java.util.Date;

public class prepObjProp {

	private Integer id;
	private String objTp, objName, propName, prop, propTp, propId;

	// значение свойства - Double
	private Double n1;
	// значение свойства - Integer, Boolean
	private Integer i1;
	// значение свойства - String
	private String s1;
	// значение свойства - Date
	private Date d1;

	// значение свойства - границ для графика в клиенте
	private Double minval, maxval;

	// getters and setters
	// ID объекта
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// Наименование объекта
	public String getObjName() {
		return objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	// Тип объекта
	public String getObjTp() {
		return objTp;
	}

	public void setObjTp(String objTp) {
		this.objTp = objTp;
	}

	// Наименование свойства объекта
	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	// Id свойства объекта
	public String getPropId() {
		return propId;
	}

	public void setPropId(String propId) {
		this.propId = propId;
	}

	// Тип свойства объекта
	public String getPropTp() {
		return propTp;
	}

	public void setPropTp(String propTp) {
		this.propTp = propTp;
	}

	public String getS1() {
		return this.s1;
	}
 
	public void setS1(String s1) {
		this.s1 = s1;
	}	

	public Double getN1() { 
		return this.n1;
	}
 
	public void setN1(Double n1) {
		this.n1 = n1;
	}	

	public Double getMinval() { 
		return this.minval;
	}
 
	public void setMinval(Double minval) {
		this.minval = minval;
	}	
	
	public Double getMaxval() { 
		return this.maxval;
	}

	public void setMaxval(Double maxval) {
		this.maxval = maxval;
	}	

	public Integer getI1() { 
		return this.i1;
	}
 
	public void setI1(Integer i1) {
		this.i1 = i1;
	}	

	public Date getD1() {
		return this.d1;
	}
 
	public void setD1(Date d1) {
		this.d1 = d1;
	}	


	// Какое-либо String свойство объекта
	public String getProp() {
		return prop;
	}

	public void setProp(String prop) {
		this.prop = prop;
	}

}
