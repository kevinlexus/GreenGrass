package com.ric.bill;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.excp.EmptyServ;
import com.ric.bill.excp.ErrorWhileChrg;
import com.ric.bill.excp.ErrorWhileDist;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.ParMng;
import com.ric.bill.mm.ServMng;
import com.ric.bill.mm.TarifMng;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.ar.Kw;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.fn.Chrg;

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
	@Autowired
	private HouseMng houseMng;

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

    //public DSess ds;
    //public ExecProc ex;
    
    //конструктор
    public ChrgServ() {
		/*ds = new DSess(true);
		ex = new ExecProc(ds);*/
    }
    

	/**
	 * начислить по всем домам
	 */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void chrgAll()  throws ErrorWhileChrg {
		for (House o: houseMng.findAll()) {
			System.out.println("ДОМ:"+o.getId());
			Calc.setInit(false);
			chrgHouse(o.getId());
		}
	}
	
    /**
	 * выполнить начисление по дому
	 * @param houseId - Id дома, иначе кэшируется, если передавать объект дома
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void chrgHouse(int houseId) throws ErrorWhileChrg {

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
	 * @throws ErrorWhileChrg 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void chrgLsk(Kart kart) throws ErrorWhileChrg {

		Calc.mess("ЛС:"+kart.getLsk());
		if (!Calc.isInit()) {
			calc.setHouse(kart.getKw().getHouse());
			calc.setArea(calc.getHouse().getStreet().getArea());
			calc.setUp(); //настроить даты фильтра и т.п.
			Calc.setInit(true);
		}
		calc.setKart(kart);
		//перенести в архив предыдущий расчет
		archPrev();
		//получить все необходимые услуги для начисления из тарифа по дому
		Calendar c = Calendar.getInstance();
		//необходимый для формирования диапазон дат
		Date dt1, dt2, genDt;
		dt1 = Calc.getCurDt1();
		dt2 = Calc.getCurDt2();

		for (c.setTime(dt1); !c.getTime().after(dt2); c.add(Calendar.DATE, 1)) {
			Calc.setGenDt(c.getTime());
			genDt = Calc.getGenDt();
			//только там, где нет статуса "не начислять" за данный день
			if (Utl.nvl(parMng.getDbl(kart, "IS_NOT_CHARGE", genDt), 0d) == 1d) {
				continue;
			}
			
			/*String tpOwn = parMng.getStr(kart, "FORM_S", genDt); 
			//где лиц.счет является нежилым помещением, не начислять за данный день
			if (tpOwn.equals("Нежилое собственное") || tpOwn.equals("Нежилое муниципальное")
				|| tpOwn.equals("Аренда некоммерч.") || tpOwn.equals("Для внутр. пользования")) {
				continue;
			}
			//Calc.mess("дата="+genDt.toString(),2);

			//найти все услуги, действительные в лиц.счете на дату формирования
			for (Serv serv : tarMng.getAllServ(calc.getHouse(), genDt)) {
				//Calc.mess("Услуга:"+serv.getCd());
				calc.setServ(serv);
				//начислить услугу
				try {
				  chrgServ(serv, kart);
				} catch (EmptyServ e) {
					e.printStackTrace();
					throw new ErrorWhileChrg("ChrgServ.chrgLsk: Пустая услуга!");
				}
			}*/
		}
		
	}

	/**
	 * расчитать начисление по услуге
	 * @param serv - услуга
	 */
	private void chrgServ(Serv serv, Kart kart) throws EmptyServ {
		//контроль наличия услуги св.с.нормы (по ряду услуг)
		if ((Utl.nvl(parMng.getDbl(serv, "Вариант расчета по общей площади-1"), 0d) == 1d || 
				Utl.nvl(parMng.getDbl(serv, "Вариант расчета по объему-1"), 0d) == 1d) && serv.getUpst() == null) {
			throw new EmptyServ("По услуге Id="+serv.getId()+" обнаружена пустая услуга свыше соц.нормы");
		}
		
	}
	
	/**
	 * перенести предыдущий расчет начисления в статус "подготовка к архиву" (1->2)
	 */
	private void archPrev() {
		
		Query query = em.createQuery("update Chrg t set t.status=2 where t.lsk=:lsk "
				+ "and t.status=1 "
				+ "and t.dt1 between :dt1 and :dt2 "
				+ "and t.dt2 between :dt1 and :dt2 "
				+ "and t.period=:period"
				);
		query.setParameter("lsk", Calc.getKart().getLsk());
		query.setParameter("dt1", Calc.getCurDt1());
		query.setParameter("dt2", Calc.getCurDt2());
		query.setParameter("period", Calc.getPeriod());
		query.executeUpdate();
		
		/* пока всё закомментил, - не понятно как будет отрабатывать коммит, во вложенном @Transactional
		//начать транзакцию
		ds.beginTrans();
		//выполнить процедуру oracle	
		if (ex.runWork(16, 0, 0)!=0) {
			return; // выйти при ошибке
		 }
		ds.commitTrans();
		*/
	}
}


