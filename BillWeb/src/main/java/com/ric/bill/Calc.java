package com.ric.bill;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;

import com.ric.bill.model.ar.Area;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Serv;

/**
 * Хранилище всех необходимых параметров для расчета
 * @author lev
 *
 */
@Slf4j
public final class Calc {
	private Date genDt; //рассчитываемая дата
	private int calcTp; //тип обработки расчёта
    
	private Area area; //текущий город 
	private House house; //текущий дом (распределяемый, начисляемый)
	private Kart kart; //текущий лиц.счет (распределяемый, начисляемый)
	private Serv serv; //текущая услуга (распределяемая, начисляемая)


	public Serv getServ() {
		return this.serv;
	}

	public void setServ(Serv serv) {
		this.serv = serv;
	}

	public int getCalcTp() {
		return this.calcTp;
	}

	public void setCalcTp(int calcTp) {
		this.calcTp = calcTp;
	}
	
	public Area getArea() {
		return this.area;
	}

	private void setArea(Area area) { //private!!!
		this.area = area;
	}

	public House getHouse() {
		return this.house;
	}

	public void setHouse(House house) {
		this.house = house;
		setArea(house.getStreet().getArea());
	}
	
	public void setKart(Kart kart) {
		this.kart = kart;
	}

	public Kart getKart() {
		return kart;
	}

	public void setGenDt(Date genDt) {
		this.genDt = genDt;
	}

	public Date getGenDt() {
		return this.genDt;
	}

}
