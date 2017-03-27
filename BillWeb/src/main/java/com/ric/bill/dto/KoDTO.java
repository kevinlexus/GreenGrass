package com.ric.bill.dto;


/**
 * DTO - KlskObj - любой объект, хранимый в  klsk
 * @author lev
 *
 */
public class KoDTO {

	private Integer id; //id
	private String cd; //cd 
	private String name; //Наименование 
	private String addrTpCD; // Cd типа адреса 
	
	// конструктор
	public KoDTO(Integer id, String cd, String name, String addrTpCd) {
		super();
		this.id = id;
		this.cd = cd;
		this.name = name;
		this.addrTpCD = addrTpCD;
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
	public String getAddrTpCD() {
		return addrTpCD;
	}
	public void setAddrTpCD(String addrTpCD) {
		this.addrTpCD = addrTpCD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
}
