package com.ric.bill;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

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
	//уровень отладки
	private static int dbgLvl;
	
    
	private Area area; //текущий город 
	private House house; //текущий дом (распределяемый, начисляемый)
	private Kart kart; //текущий лиц.счет (распределяемый, начисляемый)
	private Serv serv; //текущая услуга (распределяемая, начисляемая)

	private Integer who; //кто?
	
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

	
	
	//ЧУШЬ полная, из за того что dbgLvl - статик, получаются одни и те же уровни дебага для разных методов, переписать на log4
	//Отправить в консоль сообщение
	public static void mess(String txt) {
//			DateTimeFormatter frmt = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
//			ZonedDateTime dt = ZonedDateTime.now();
			if (getDbgLvl() <=1 ) {
				log.info(txt);		
				//System.out.println(dt.format(frmt)+' '+txt);
			}
		}

	//ЧУШЬ полная, из за того что dbgLvl - статик, получаются одни и те же уровни дебага для разных методов, переписать на log4
	//Отправить в консоль сообщение с уровнем выше dbgLvl
	public static void mess(String txt, int dbgLvl) {
			//DateTimeFormatter frmt = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
			//ZonedDateTime dt = ZonedDateTime.now();
			if (dbgLvl >= getDbgLvl()) {
//				System.out.println(dt.format(frmt)+' '+txt);
				log.info(txt);		
			}
		}

	public static int getDbgLvl() {
		return dbgLvl;
	}

	public static void setDbgLvl(int dbgLvl) {
		Calc.dbgLvl = dbgLvl;
	}

	public void setGenDt(Date genDt) {
		this.genDt = genDt;
	}

	public Date getGenDt() {
		return this.genDt;
	}

	public Integer getWho() {
		return who;
	}

	public void setWho(Integer who) {
		this.who = who;
	}

}
