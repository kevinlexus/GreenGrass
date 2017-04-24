package com.ric.bill.dto;

/**
 * DTO - предназначен для заполнения отчета данными
 * @author lev
 *
 */
public class RepItemDTO {
	Integer id;
	String payordGrpName;
	String payordName;
	String ukName;
	Double insal;
	Double summa;
	Double summa1;
	Double summa2;
	Double summa3;
	Double summa4;
	Double summa5;
	Double summa6;
	
	public RepItemDTO(Integer id, String payordGrpName, String payordName,
			String ukName, Double insal, Double summa, Double summa1, Double summa2,
			Double summa3, Double summa4, Double summa5, Double summa6) {
		super();
		this.id = id;
		this.payordGrpName = payordGrpName;
		this.payordName = payordName;
		this.ukName = ukName;
		this.summa = summa;
		this.summa1 = summa1;
		this.summa2 = summa2;
		this.summa3 = summa3;
		this.summa4 = summa4;
		this.summa5 = summa5;
		this.summa6 = summa6;
		this.insal = insal;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPayordGrpName() {
		return payordGrpName;
	}
	public void setPayordGrpName(String payordGrpName) {
		this.payordGrpName = payordGrpName;
	}
	public String getPayordName() {
		return payordName;
	}
	public void setPayordName(String payordName) {
		this.payordName = payordName;
	}
	public String getUkName() {
		return ukName;
	}
	public void setUkName(String ukName) {
		this.ukName = ukName;
	}
	public Double getSumma() {
		return summa;
	}
	public void setSumma(Double summa) {
		this.summa = summa;
	}
	public Double getSumma1() {
		return summa1;
	}
	public void setSumma1(Double summa1) {
		this.summa1 = summa1;
	}
	public Double getSumma2() {
		return summa2;
	}
	public void setSumma2(Double summa2) {
		this.summa2 = summa2;
	}
	public Double getSumma3() {
		return summa3;
	}
	public void setSumma3(Double summa3) {
		this.summa3 = summa3;
	}
	public Double getSumma4() {
		return summa4;
	}
	public void setSumma4(Double summa4) {
		this.summa4 = summa4;
	}
	public Double getSumma5() {
		return summa5;
	}
	public void setSumma5(Double summa5) {
		this.summa5 = summa5;
	}
	public Double getSumma6() {
		return summa6;
	}
	public void setSumma6(Double summa6) {
		this.summa6 = summa6;
	}

	public Double getInsal() {
		return insal;
	}

	public void setInsal(Double insal) {
		this.insal = insal;
	}

		
}
