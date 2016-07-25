package com.ric.bill;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.excp.EmptyOrg;
import com.ric.bill.excp.EmptyServ;
import com.ric.bill.excp.ErrorWhileChrg;
import com.ric.bill.excp.ErrorWhileDist;
import com.ric.bill.excp.InvalidServ;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.KartMng;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.MeterLogMng;
import com.ric.bill.mm.ParMng;
import com.ric.bill.mm.ServMng;
import com.ric.bill.mm.TarifMng;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.ar.Kw;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.fn.Chrg;
import com.ric.bill.model.mt.MeterLog;

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
	@Autowired
	private KartMng kartMng;
	@Autowired
	private MeterLogMng metMng;
	@Autowired
	private LstMng lstMng;

	
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
		int aaa=1;
		for (Kw kw : h.getKw()) {
			for (Kart kart : kw.getLsk()) {
				aaa++;
				if (aaa > 5) {
					//break;
				}
				for (MeterLog mLog: kart.getMlog()) {
					Calc.mess("сч="+mLog.getId());
					//Calc.mess("Дом в сч.: klsk="+mLog.getHouse().getKlsk());
				} 

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

		//Calc.mess("ЛС:"+kart.getLsk());
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
			
			String tpOwn = parMng.getStr(kart, "FORM_S", genDt); 
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
				//Calc.mess("дом="+kart.getKw().getHouse().getId());
				
				try {
				  chrgServ(kart, serv, tpOwn, genDt);
				} catch (EmptyServ e) {
					e.printStackTrace();
					throw new ErrorWhileChrg("ChrgServ.chrgLsk: Пустая услуга!");
				} catch (EmptyOrg e) {
					e.printStackTrace();
					throw new ErrorWhileChrg("ChrgServ.chrgLsk: Пустая организация!");
				} catch (InvalidServ e) {
					e.printStackTrace();
					throw new ErrorWhileChrg("ChrgServ.chrgLsk: Некорректна услуга!");
				}
			}
			//break;
		}
		
	}

	/**
	 * расчитать начисление по услуге
	 * @param serv - услуга
	 * @throws InvalidServ 
	 */
	private void chrgServ(Kart kart, Serv serv, String tpOwn, Date genDt) throws EmptyServ, EmptyOrg, InvalidServ {
		//услуги по норме, свыше и без проживающих
		Serv stServ, upStServ, woKprServ;
		//нормативный объем, доля норматива
		Standart stdt = null;
		//расценки
		BigDecimal stPrice, upStPrice, woKprPrice;
		//организация
		Org org;
		//база для начисления
		String baseCD;
		//объем
		Double vol = 0d;
		//доля площади в день
		Double sqr;
		//№ порядк.записи
		int npp;
		//Временная сумма
		BigDecimal tmpSum;
		
		//типы записей начисления
		Lst chrgTpDet = lstMng.findByCD("Начислено детально, по дням");
		Lst chrgTpRnd = lstMng.findByCD("Начислено свернуто, округлено");

		//получить необходимые услуги
		stServ = serv.getServSt();
		upStServ = serv.getServUpst();
		woKprServ = serv.getServWokpr();
		//если услуга по соцнорме пустая, присвоить изначальную услугу
		if (stServ == null) {
			stServ = serv;
		}
		
		
		//контроль наличия услуги св.с.нормы (по ряду услуг)
		if ((Utl.nvl(parMng.getDbl(serv, "Вариант расчета по общей площади-1"), 0d) == 1d || 
				Utl.nvl(parMng.getDbl(serv, "Вариант расчета по объему-1"), 0d) == 1d) && serv.getServUpst() == null) {
			throw new EmptyServ("По услуге Id="+serv.getId()+" обнаружена пустая услуга свыше соц.нормы");
		}
		
		//calc.mess("Kart.klsk="+kart.getKlsk(), 2);
		//calc.mess("Kart.lsk="+kart.getLsk()+" SERV="+stServ.getCd()+" SERV ID="+stServ.getId(), 2);
		
		//получить расценку по норме	
		stPrice = BigDecimal.valueOf(kartMng.getServPropByCD(kart, stServ, "Цена", genDt));
		if (stPrice == null) {
			stPrice = BigDecimal.ZERO;
		}

		//получить нормативный объем
		if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета по общей площади-1"), 0d) == 1d || 
				Utl.nvl(parMng.getDbl(serv, "Вариант расчета по объему-1"), 0d) == 1d ||
				Utl.nvl(parMng.getDbl(serv, "Вариант расчета по объему-2"), 0d) == 1d ||
				Utl.nvl(parMng.getDbl(serv, "Вариант расчета для полива"), 0d) == 1d) {
			stdt = kartMng.getStandart(kart, serv, null, genDt);
			//здесь же получить расценки по свыше соц.нормы и без проживающих 
			if (serv.getServUpst() != null) {
				upStPrice = BigDecimal.valueOf(kartMng.getServPropByCD(kart, upStServ, "Цена", genDt));
				if (upStPrice == null) {
					upStPrice = BigDecimal.ZERO;
				}
			} else {
				upStPrice = BigDecimal.ZERO;
			}
			
			if (serv.getServWokpr() != null) {
				woKprPrice = BigDecimal.valueOf(kartMng.getServPropByCD(kart, woKprServ, "Цена", genDt));
				if (woKprPrice == null) {
					woKprPrice = BigDecimal.ZERO;
				}
			} else {
				woKprPrice = BigDecimal.ZERO;
			}
		}
			
		//получить организацию
		if (serv.getCheckOrg()) {
		  org = kartMng.getOrg(kart, serv.getServOrg(), genDt);
		  if (org == null) {
				throw new EmptyOrg("При расчете л.с.="+kart.getLsk()+" , обнаружена пустая организция по услуге Id="+serv.getServOrg().getId());
		  }
		}
		
		//получить базу для начисления
		baseCD = parMng.getStr(serv, "Name_CD_par_base_charge");
		
		//получить объем для начисления
		if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета по кол-ву точек-1"), 0d) == 1d || 
				Utl.nvl(parMng.getDbl(serv, "Вариант расчета по общей площади-1"), 0d) == 1d ||
				Utl.nvl(parMng.getDbl(serv, "Вариант расчета по общей площади-2"), 0d) == 1d) {
			//получить объем одного дня
			vol = Utl.nvl(parMng.getDbl(kart, baseCD, genDt), 0d);
			
			vol = vol / Calc.getCntCurDays();
			//проверить по капремонту, чтобы не была квартира муниципальной
			if (serv.getCd().equals("Взносы на кап.рем.")) {
				if (!(tpOwn.equals("Подсобное помещение") || tpOwn.equals("Приватизированная") || tpOwn.equals("Собственная"))) {
					//не начислять, выход
					return;
				} else {
					//применить льготу по капремонту по 70 - летним
					vol = vol * kartMng.getCapPrivs(kart, genDt);
				}
			}
			
		} else if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета для полива"), 0d) == 1d) {
			//получить объем за месяц
			vol = Utl.nvl(parMng.getDbl(kart, baseCD, genDt), 0d);
			//получить долю объема за день HARD CODE
			//площадь полива (в доле 1 дня)/100 * 60 дней / 12мес * норматив / среднее кол-во дней в месяце
			vol = vol/100d*60d/12d*stdt.partVol/30.4d/Calc.getCntCurDays();
			
		} else if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета по объему-1"), 0d) == 1d ||
				   Utl.nvl(parMng.getDbl(serv, "Вариант расчета по объему-2"), 0d) == 1d) {
			
			//Вариант подразумевает объём по лог.счётчику, РАспределённый по дням
			if (serv.getServMet() == null) {
				throw new InvalidServ("По услуге Id="+serv.getId()+" не установлена соответствующая услуга счетчика");
			}
			//получить объем по лицевому счету и услуге за ДЕНЬ
			SumNodeVol tmpNodeVol = metMng.getVolPeriod(kart, serv.getServMet(), genDt, genDt);
			vol = tmpNodeVol.getVol();
			
			if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета по объему-2"), 0d) == 1d) {
				//доля площади в день
				sqr = Utl.nvl(parMng.getDbl(kart, baseCD, genDt), 0d) / Calc.getCntCurDays();
			}
			
			
		} else if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета по объему без исп.норматива-1"), 0d) == 1d) {
			//Вариант подразумевает объём по лог.счётчику, НЕ распределённый по дням,
			//а записанный одной строкой (одним периодом дата нач.-дата кон.)
			if (serv.getServMet() == null) {
				throw new InvalidServ("По услуге Id="+serv.getId()+" не установлена соответствующая услуга счетчика");
			}
			//получить объем по услуге за период
			SumNodeVol tmpNodeVol = metMng.getVolPeriod(kart, serv.getServMet(), Calc.getCurDt1(), Calc.getCurDt2());
			vol = tmpNodeVol.getVol();
			vol = vol / Calc.getCntCurDays();
		} else if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета по готовой сумме"), 0d) == 1d) {
			vol = 1 / Calc.getCntCurDays();
		}


		/*			if (kart.getLsk().equals("26074286")) {
		Calc.mess("услуга "+serv.getCd()+" площадь "+vol, 2);
	}*/
		
		//ВЫПОЛНИТЬ РАСЧЕТ
	
		if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета по общей площади-2"), 0d) == 1d ||
			Utl.nvl(parMng.getDbl(serv, "Вариант расчета по кол-ву точек-1"), 0d) == 1d) {
			//без соцнормы и свыше!
			//тип расчета, например:Взносы на капремонт
			//Вариант подразумевает объём, по параметру - базе, жилого фонда РАСПределённый по дням
			tmpSum = BigDecimal.valueOf(vol).multiply(stPrice);
			if (tmpSum != BigDecimal.ZERO) {
				Chrg chrg = new Chrg(kart, serv, 1, Calc.getPeriod(), tmpSum, tmpSum, vol, stPrice, chrgTpDet, genDt, genDt);
				kart.getChrg().add(chrg);
			}
		} if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета по готовой сумме"), 0d) == 1d) {
			//тип расчета, например:Коммерческий найм, где цена = сумме
			tmpSum = stPrice;
			if (tmpSum != BigDecimal.ZERO) {
				Chrg chrg = new Chrg(kart, serv, 1, Calc.getPeriod(), tmpSum, tmpSum, vol, stPrice, chrgTpDet, genDt, genDt);
				kart.getChrg().add(chrg);
			}
		} else if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета по общей площади-1"), 0d) == 1d ||
				   Utl.nvl(parMng.getDbl(serv, "Вариант расчета по объему-1"), 0d) == 1d) {
			//тип расчета, например:текущее содержание, Х.В., Г.В., Канализ
			//Вариант подразумевает объём по лог.счётчику, РАСПределённый по дням
			//или по параметру - базе, жилого фонда, так же распределенного по дням
			//соцнорма
			
			
			
		} if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета по объему-2"), 0d) == 1d) {

			
		} if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета по объему без исп.норматива-1"), 0d) == 1d) {

		
		} if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета для полива"), 0d) == 1d) {

		
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


