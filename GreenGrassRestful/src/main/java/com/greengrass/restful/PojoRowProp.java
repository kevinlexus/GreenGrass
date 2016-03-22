package com.greengrass.restful;

import java.sql.Date;

import com.greengrass.house.Property;

public class PojoRowProp {
	
	private double n1;    
    private String s1;    
    private Date d1;
    private int i1;
    private String owfs_cd;
    private Property fk_prop;
    private int upd_by1;
	
	public double getN1() {
		return n1;
	}
	public void setN1(int n1) {
		this.n1 = n1;
	}
	public String getS1() {
		return s1;
	}
	public void setS1(String s1) {
		this.s1 = s1;
	}
	public Date getD1() {
		return d1;
	}
	public void setD1(Date d1) {
		this.d1 = d1;
	}
	public int getI1() {
		return i1;
	}
	public void setI1(int i1) {
		this.i1 = i1;
	}
	public String getOwfs_cd() {
		return owfs_cd;
	}
	public void setOwfs_cd(String owfs_cd) {
		this.owfs_cd = owfs_cd;
	}
	public Property getFk_prop() {
		return fk_prop;
	}
	public void setFk_prop(Property fk_prop) {
		this.fk_prop = fk_prop;
	}
	public int getUpd_by1() {
		return upd_by1;
	}
	public void setUpd_by1(int upd_by1) {
		this.upd_by1 = upd_by1;
	}

}
