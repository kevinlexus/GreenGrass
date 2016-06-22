package com.ric.bill;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.mm.ParMng;
import com.ric.bill.mm.ServMng;
import com.ric.bill.mm.TarifMng;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.ar.Kw;
import com.ric.bill.model.bs.Serv;

/**
 * Сервис формирования начисления
 * @author lev
 *
 */
@Service
public class ChrgServ {


	@Autowired
	private Calc calc;
	@Autowired
	private ParMng parMng;
	@Autowired
	private ServMng servMng;
	@Autowired
	private TarifMng tarMng;

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

    /**
	 * выполнить начисление по дому
	 * @param houseId - Id дома, иначе кэшируется, если передавать объект дома
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void chrgHouse(int houseId) {

		House h = em.find(House.class, houseId);
		if (!Calc.isInit()) {
			calc.setHouse(h);
			calc.setArea(calc.getHouse().getStreet().getArea());
			calc.setUp(); //настроить даты фильтра и т.п.
			Calc.setInit(true);
		}
		Calc.mess("Начисление");
		Calc.mess("Дом: id="+calc.getHouse().getId());
		Calc.mess("Дом: klsk="+calc.getHouse().getKlsk());
		
		//перебрать все квартиры и лиц.счета в них
		for (Kw kw : h.getKw()) {
			for (Kart kart : kw.getLsk()) {
				chrgLsk(kart); //рассчитать начисление
			}
		}
	}
	

	/**
	 * выполнить расчет начисления по лиц.счету
	 * @param kart - объект лиц.счета
	 */
	public void chrgLsk(Kart kart) {
		Calc.mess("ЛС:"+kart.getLsk());
		if (!Calc.isInit()) {
			calc.setHouse(kart.getKw().getHouse());
			calc.setArea(calc.getHouse().getStreet().getArea());
			calc.setKart(kart);
			calc.setUp(); //настроить даты фильтра и т.п.
			Calc.setInit(true);
		}
		//перенести в архив предыдущий расчет
		archPrev();
		//получить все необходимые услуги для начисления из тарифа по дому
		for (Serv serv : tarMng.getAllServ(calc.getHouse())) {
			Calc.mess("Услуга:"+serv.getCd());
			calc.setServ(serv);
			//начислить услугу
			chrgServ(serv);
		}
		
	}

	/**
	 * расчитать начисление по услуге
	 * @param serv - услуга
	 */
	private void chrgServ(Serv serv) {
		
	}
	
	/**
	 * перенести предыдущий расчет начисления в статус "подготовка к архиву" (1->2)
	 */
	private void archPrev() {
		
	}
}


