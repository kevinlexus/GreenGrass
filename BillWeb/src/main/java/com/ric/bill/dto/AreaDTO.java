package com.ric.bill.dto;


/**
 * DTO - Области
 * @author lev
 *
 */
public class AreaDTO {

	private Integer id; //id
	private String cd; //cd 
	private String name; //Наименование 
	
	// конструктор
	public AreaDTO(Integer id, String cd, String name) {
		super();
		this.id = id;
		this.cd = cd;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
}
