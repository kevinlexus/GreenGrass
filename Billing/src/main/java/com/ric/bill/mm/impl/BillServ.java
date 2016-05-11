package com.ric.bill.mm.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.Dist;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.model.Dw;
import com.ric.bill.model.House;
import com.ric.bill.model.Kw;
import com.ric.bill.model.Lsk;

/**
 * Главный сервис биллинга
 * @author lev
 *
 */
@Service
public class BillServ {

	/**
	 * распределить объемы
	 */
	@Transactional
	public void distVols() {
		HouseMng houseMng = (HouseMng)Dist.ctx.getBean("houseMngImpl");
		
		for (House o: houseMng.findAll()) {
		System.out.println("Дом: id="+o.getId());
		try {
			System.out.println("Площадь: "+houseMng.getDbl(o.getDw(), "Площадь.Жилая2"));
		} catch (WrongGetMethod e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("id="+o.getId()+" klsk="+o.getKlsk());
		System.out.println("тест="+o.getDw());
		for (Dw dw: o.getDw()) {
			System.out.println("Params of house:"+dw.getId()+" "+dw.getS1()+" "+dw.getPar().getName());
		}    		
		
		for (Kw kw: o.getKw()) {
			System.out.println("KW="+kw.getId());
			System.out.println("House of the flat:="+kw.getHouse().getId());
			for (Lsk lsk: kw.getLsk()) {
				System.out.println("Lsk of the flat:="+lsk.getFio()+" Lsk="+lsk.getLs());
				lsk.getDw();
				for (Dw dw2: lsk.getDw()) {
		    		System.out.println("Params of lsk:"+dw2.getPar().getName()+" "+dw2.getS1());
					
				}
			}        		
		}    		
		break;
		}
	}
}
