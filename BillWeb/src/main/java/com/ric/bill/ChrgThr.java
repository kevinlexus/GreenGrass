package com.ric.bill;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import com.ric.bill.excp.EmptyOrg;
import com.ric.bill.excp.EmptyServ;
import com.ric.bill.excp.EmptyStorable;
import com.ric.bill.excp.InvalidServ;
import com.ric.bill.mm.KartMng;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.MeterLogMng;
import com.ric.bill.mm.ParMng;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.fn.Chrg;
import com.ric.bill.model.fn.ChrgRec;
import com.ric.bill.model.fn.ChrgStore;

/**
 * Начисление в потоке
 * @author lev
 *
 */


@Component
@Scope("prototype") //собственный бин для каждого потока
public class ChrgThr {
	
	@Autowired
	private LstMng lstMng;
	@Autowired
	private Config config;
	@Autowired
	private ParMng parMng;
	
	@Autowired
	private KartMng kartMng;
	@Autowired
	private MeterLogMng metMng;

	@Autowired
	private ApplicationContext ctx;
	
    @PersistenceContext
    private EntityManager em;

	private Serv serv;
	//временное хранилище записей
	private ChrgStore chStore;

	private String thrName;
	
    //вспомогательные массивы
    private List<Chrg> prepChrg;
    private HashMap<Serv, BigDecimal> mapServ;
    private HashMap<Serv, BigDecimal> mapVrt;

    private Calc calc;
    
	//конструктор
	public ChrgThr() {
		super();
	}
	
	//установить параметры
	//				thr1.set(serv, kart, mapServ, mapVrt, prepChrg);

	public void set(Calc calc, Serv serv,  
			HashMap<Serv, BigDecimal> mapServ, 
			HashMap<Serv, BigDecimal> mapVrt, 
			List<Chrg> prepChrg) {
		this.calc = calc;
		this.serv = serv;
		this.mapServ = mapServ;
		this.mapVrt = mapVrt;
		this.prepChrg = prepChrg;

	}

	@Async
	public  Future<Result> run1() {
		Kart kart = calc.getKart();
//		sz(kart);
		
		Result res = new Result();
		res.err=0;

		Thread t = Thread.currentThread();
	    thrName = t.getName();
	      
		long startTime2;
		long endTime;
		long totalTime;
		startTime2 = System.currentTimeMillis();

		//необходимый для формирования диапазон дат
		Date dt1, dt2, genDt;
		dt1 = config.getCurDt1();
		dt2 = config.getCurDt2();

		//типы записей начисления
		Lst chrgTpRnd = lstMng.getByCD("Начислено свернуто, округлено");
		
		//Объект, временно хранящий записи начисления
		chStore = new ChrgStore(); 
		//if (serv.getId()==32) {
		Calc.mess("ChrThr.run1: "+thrName+", Услуга:"+serv.getCd()+" Id="+serv.getId());
		if (serv.getId()==35) {
			Calc.mess("ChrThr.run1: "+thrName+", Услуга:"+serv.getCd()+" Id="+serv.getId());
		}
		
		
		
		//}
		Calendar c = Calendar.getInstance();
		
		for (c.setTime(dt1); !c.getTime().after(dt2); c.add(Calendar.DATE, 1)) {
			genDt = c.getTime();
			//только там, где нет статуса "не начислять" за данный день
			if (Utl.nvl(parMng.getDbl(kart.getKlsk(), kart.getDw(), "IS_NOT_CHARGE", genDt), 0d) == 1d) {
				continue;
			}

			//только там, где существует услуга в данном дне
			if (kartMng.getServ(calc, serv, genDt)) {
				String tpOwn = parMng.getStr(kart, "FORM_S", genDt);
				//получить обслуживающую УК
				Org uk = kart.getUk();
				//Org uk = kartMng.getUk(kart, genDt);
				
				if (tpOwn == null) {
					Calc.mess("ОШИБКА! Не указанна форма собственности! lsk="+kart.getLsk(), 2);
				}
				//где лиц.счет является нежилым помещением, не начислять за данный день
				if (tpOwn.equals("Нежилое собственное") || tpOwn.equals("Нежилое муниципальное")
					|| tpOwn.equals("Аренда некоммерч.") || tpOwn.equals("Для внутр. пользования")) {
					continue;
				}
					try {
					  genChrg(calc, serv, uk, tpOwn, genDt);
					} catch (EmptyStorable e) {
						e.printStackTrace();
						throw new RuntimeException();
					} catch (EmptyOrg e) {
						e.printStackTrace();
						throw new RuntimeException();
					} catch (InvalidServ e) {
						e.printStackTrace();
						throw new RuntimeException();
					}
					
			}
			//break;
		}
		
		//окончательно расчитать данные
		for (ChrgRec rec : chStore.getStore()) {
			BigDecimal vol, sum;
			vol = rec.getVol();
			//округлить
			vol = vol.setScale(5, BigDecimal.ROUND_HALF_UP);
			//умножить на расценку
			sum = vol.multiply(rec.getPrice());
			//округлить до копеек
			sum = sum.setScale(2, BigDecimal.ROUND_HALF_UP);
			
			//записать, для будущего округления по виртуальной услуге
			if (rec.getServ().getServVrt() != null) {
				putMapServVal(rec.getServ().getServVrt(), sum);
			}
			//записать, сумму по виртуальной услуге
			if (rec.getServ().getVrt()) {
					putMapVrtVal(rec.getServ(), sum);
					
			}

			if (!rec.getServ().getVrt()) {
				if (sum.compareTo(BigDecimal.ZERO) != 0) {
					Chrg chrg = new Chrg(kart, rec.getServ(), rec.getOrg(), 1, config.getPeriod(), sum, sum, 
							vol, rec.getPrice(), chrgTpRnd, rec.getDt1(), rec.getDt2());
					chrgAdd(chrg);
				}
			}
		} 

		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime2;
        //Calc.mess("ChrThr: Поток завершён "+thrName+", Услуга:"+serv.getCd()+" Id="+serv.getId(),2);
		return new AsyncResult<Result>(res);
	}

	/**
	 * расчитать начисление по услуге
	 * @param serv - услуга
	 * @throws InvalidServ 
	 */
	private void genChrg(Calc calc, Serv serv, Org uk, String tpOwn, Date genDt) throws EmptyStorable, EmptyOrg, InvalidServ {
		Kart kart = calc.getKart();
		long startTime2;
		long endTime;
		long totalTime;
		startTime2 = System.currentTimeMillis();

		//услуги по норме, свыше и без проживающих
		Serv stServ, upStServ, woKprServ;
		//нормативный объем, доля норматива
		Standart stdt = null;
		//расценки
		Double stPrice = 0d, upStPrice = 0d, woKprPrice = 0d;
		//организация
		Org org = null;
		//база для начисления
		String baseCD;
		//объем
		Double vol = 0d;
		//доля площади в день
		Double sqr = 0d;
		//№ порядк.записи
		int npp;
		//Временная сумма
		//BigDecimal tmpSum;
		//Временный объем
		Double tmpVol;
		//Кол-во проживающих
		CntPers cntPers = new CntPers();
		//Временные переменные
		Double tmp = 0d;
		BigDecimal cf = BigDecimal.ZERO;
		BigDecimal tmpVolD = BigDecimal.ZERO;
		//BigDecimal tmpSumD = BigDecimal.ZERO;
		
		if (serv.getId()==32) {
			//Calc.mess(thrName+" CHECK1");
		}

		//Calc.mess(thrName+" CHECK0.1="+serv.getId()+" dt="+genDt,2);	
		//получить необходимые услуги
		stServ = serv.getServSt();
		upStServ = serv.getServUpst();
		woKprServ = serv.getServWokpr();
		//если услуга по соцнорме пустая, присвоить изначальную услугу
		if (stServ == null) {
			stServ = serv;
		}
		
		//Calc.mess(thrName+" CHECK0.2="+serv.getId()+" dt="+genDt,2);	
		
		//контроль наличия услуги св.с.нормы (по ряду услуг)
		if ((Utl.nvl(parMng.getDbl(serv, "Вариант расчета по общей площади-1"), 0d) == 1d || 
				Utl.nvl(parMng.getDbl(serv, "Вариант расчета по объему-1"), 0d) == 1d) && serv.getServUpst() == null) {
			throw new EmptyStorable("По услуге Id="+serv.getId()+" обнаружена пустая услуга свыше соц.нормы");
		}

		//Calc.mess(thrName+" CHECK0.3="+serv.getId()+" dt="+genDt,2);	
		
		//Получить кол-во проживающих 
		//synchronized (kartMng) {
		kartMng.getCntPers(kart, serv, cntPers, 0, genDt); //tp=0 (для получения кол-во прож. для расчёта нормативного объема)
		//}
		//calc.mess("Kart.klsk="+kart.getKlsk(), 2);
		//calc.mess("Kart.lsk="+kart.getLsk()+" SERV="+stServ.getCd()+" SERV ID="+stServ.getId(), 2);
		
		//Calc.mess(thrName+" CHECK0.4="+serv.getId()+" dt="+genDt,2);	

		//получить расценку по норме	
		//synchronized (kartMng) {
			stPrice = kartMng.getServPropByCD(calc, stServ, "Цена", genDt);
		//}
		
		if (stPrice == null) {
			stPrice = 0d;
		}

		//Calc.mess(thrName+" CHECK0.5="+serv.getId()+" dt="+genDt,2);	
		
		//получить нормативный объем
		if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета по общей площади-1"), 0d) == 1d || 
				Utl.nvl(parMng.getDbl(serv, "Вариант расчета по объему-1"), 0d) == 1d ||
				Utl.nvl(parMng.getDbl(serv, "Вариант расчета по объему-2"), 0d) == 1d ||
				Utl.nvl(parMng.getDbl(serv, "Вариант расчета для полива"), 0d) == 1d) {
			
			
			//synchronized (kartMng) {
				//Calc.mess(thrName+" CHECK1="+serv.getId()+" dt="+genDt,2);	
				stdt = kartMng.getStandart(calc, serv, cntPers, genDt);
				//Calc.mess(thrName+" CHECK2="+serv.getId()+" dt="+genDt,2);	
			//}
			//здесь же получить расценки по свыше соц.нормы и без проживающих 
			if (serv.getServUpst() != null) {
				
				//Calc.mess(thrName+" CHECK!"+kart,2 );
				upStPrice = kartMng.getServPropByCD(calc, upStServ, "Цена", genDt);
				if (upStPrice == null) {
					upStPrice = 0d;
				}
			} else {
				upStPrice = 0d;
			}

			if (serv.getServWokpr() != null) {
				woKprPrice = kartMng.getServPropByCD(calc, woKprServ, "Цена", genDt);
				if (woKprPrice == null) {
					woKprPrice = 0d;
				}
			} else {
				woKprPrice = 0d;
			} 
		}
			

		//Calc.mess(thrName+" CHECK3="+serv.getId()+" dt="+genDt,2);	
		
		//получить организацию
		if (serv.getCheckOrg()) {
		  org = kartMng.getOrg(calc, serv.getServOrg(), genDt);
		  if (org == null) {
				throw new EmptyOrg("При расчете л.с.="+kart.getLsk()+" , обнаружена пустая организция по услуге Id="+serv.getServOrg().getId());
		  }
		}
		
		//получить базу для начисления
		baseCD = parMng.getStr(serv, "Name_CD_par_base_charge");

		//Calc.mess(thrName+" CHECK4="+serv.getId()+" dt="+genDt,2);	
	
		//получить объем для начисления
		if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета по кол-ву точек-1"), 0d) == 1d || 
				Utl.nvl(parMng.getDbl(serv, "Вариант расчета по общей площади-1"), 0d) == 1d ||
				Utl.nvl(parMng.getDbl(serv, "Вариант расчета по общей площади-2"), 0d) == 1d) {
			//получить объем одного дня
			//Calc.mess(thrName+" CHECK4.1="+serv.getId()+" dt="+genDt,2);	
			vol = Utl.nvl(parMng.getDbl(kart.getKlsk(), kart.getDw(), baseCD, genDt), 0d);
			
			vol = vol / config.getCntCurDays();
			//проверить по капремонту, чтобы не была квартира муниципальной
			if (serv.getCd().equals("Взносы на кап.рем.")) {
				if (!(tpOwn.equals("Подсобное помещение") || tpOwn.equals("Приватизированная") || tpOwn.equals("Собственная"))) {
					//не начислять, выход
					return;
				} else {
					//применить льготу по капремонту по 70 - летним
					//Calc.mess(thrName+" CHECK4.2="+serv.getId()+" dt="+genDt,2);	
					vol = vol * kartMng.getCapPrivs(kart, genDt);
					//Calc.mess(thrName+" CHECK4.3="+serv.getId()+" dt="+genDt,2);	
				}
			}
			//Calc.mess(thrName+" CHECK4.4="+serv.getId()+" dt="+genDt,2);	
			
		} else if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета для полива"), 0d) == 1d) {
			//получить объем за месяц
			vol = Utl.nvl(parMng.getDbl(kart.getKlsk(), kart.getDw(), baseCD, genDt), 0d);
			//получить долю объема за день HARD CODE
			//площадь полива (в доле 1 дня)/100 * 60 дней / 12мес * норматив / среднее кол-во дней в месяце
			vol = vol/100d*60d/12d*stdt.partVol/30.4d/config.getCntCurDays();
			
		} else if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета по объему-1"), 0d) == 1d ||
				   Utl.nvl(parMng.getDbl(serv, "Вариант расчета по объему-2"), 0d) == 1d) {
			
			//Вариант подразумевает объём по лог.счётчику, РАспределённый по дням
			if (serv.getServMet() == null) {
				throw new InvalidServ("По услуге Id="+serv.getId()+" не установлена соответствующая услуга счетчика");
			}
			//получить объем по лицевому счету и услуге за ДЕНЬ
			SumNodeVol tmpNodeVol = metMng.getVolPeriod(kart, serv.getServMet(), genDt, genDt);
			vol = tmpNodeVol.getVol();
			//vol=5d;
			
			if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета по объему-2"), 0d) == 1d) {
				//доля площади в день
				sqr = Utl.nvl(parMng.getDbl(kart.getKlsk(), kart.getDw(), baseCD, genDt), 0d) / config.getCntCurDays();
			}
			
			
		} else if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета по объему без исп.норматива-1"), 0d) == 1d) {
			//Вариант подразумевает объём по лог.счётчику, НЕ распределённый по дням,
			//а записанный одной строкой (одним периодом дата нач.-дата кон.)
			if (serv.getServMet() == null) {
				throw new InvalidServ("По услуге Id="+serv.getId()+" не установлена соответствующая услуга счетчика");
			}
			//получить объем по услуге за период
			SumNodeVol tmpNodeVol = metMng.getVolPeriod(kart, serv.getServMet(), config.getCurDt1(), config.getCurDt2());
			vol = tmpNodeVol.getVol();
			vol = vol / config.getCntCurDays();
		} else if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета по готовой сумме"), 0d) == 1d) {
			vol = 1 / config.getCntCurDays();
		}


		/*if (true) {
			return;
		}*/
		
		//ВЫПОЛНИТЬ РАСЧЕТ
	
		//Calc.mess(thrName+" CHECK5="+serv.getId()+" dt="+genDt,2);	

		if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета по общей площади-2"), 0d) == 1d ||
			Utl.nvl(parMng.getDbl(serv, "Вариант расчета по кол-ву точек-1"), 0d) == 1d ||
			Utl.nvl(parMng.getDbl(serv, "Вариант расчета по объему без исп.норматива-1"), 0d) == 1d) {
			//без соцнормы и свыше!
			//тип расчета, например:Взносы на капремонт
			//Вариант подразумевает объём, по параметру - базе, жилого фонда РАСПределённый по дням
	        //тип расчета, например Х.В.ОДН, Г.В.ОДН, Эл.эн.ОДН
			//tmpSum = BigDecimal.valueOf(vol).multiply( BigDecimal.valueOf(stPrice) );
			//addChrg(kart, serv, tmpSum, vol, stPrice, genDt, chrgTpDet);
			chStore.addChrg(BigDecimal.valueOf(vol), BigDecimal.valueOf(stPrice), stServ, org, uk, genDt);
			/*tmpSum = BigDecimal.valueOf(vol).multiply( BigDecimal.valueOf(stPrice) );
			if (tmpSum != BigDecimal.ZERO) {
				Chrg chrg = new Chrg(kart, serv, 1, Calc.getPeriod(), tmpSum, tmpSum, vol, stPrice, chrgTpDet, genDt, genDt);
				kart.getChrg().add(chrg);
			}*/
		} if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета по готовой сумме"), 0d) == 1d) {
			//тип расчета, например:Коммерческий найм, где цена = сумме
			//tmpSum = BigDecimal.valueOf(stPrice);
			//addChrg(kart, serv, tmpSum, vol, stPrice, genDt, chrgTpDet);
			chStore.addChrg(BigDecimal.valueOf(vol), BigDecimal.valueOf(stPrice), stServ, org, uk, genDt);
			
			/*if (tmpSum != BigDecimal.ZERO) {
				Chrg chrg = new Chrg(kart, serv, 1, Calc.getPeriod(), tmpSum, tmpSum, vol, stPrice, chrgTpDet, genDt, genDt);
				kart.getChrg().add(chrg);
			}*/
		} else if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета по общей площади-1"), 0d) == 1d ||
				   Utl.nvl(parMng.getDbl(serv, "Вариант расчета по объему-1"), 0d) == 1d) {
			//тип расчета, например:текущее содержание, Х.В., Г.В., Канализ
			//Вариант подразумевает объём по лог.счётчику, РАСПределённый по дням
			//или по параметру - базе, жилого фонда, так же распределенного по дням
			Double absVol= Math.abs(vol);
			
			if (cntPers.cntEmpt != 0) {
				//есть проживающие
				//соцнорма
				if (absVol <= stdt.partVol) {
					tmpVol= absVol;
				} else {
					tmpVol= stdt.partVol;
				}
	
				chStore.addChrg(BigDecimal.valueOf(tmpVol * Math.signum(vol)), BigDecimal.valueOf(stPrice), stServ, org, uk, genDt);
				//свыше соцнормы
				tmpVol = absVol - tmpVol;
				chStore.addChrg(BigDecimal.valueOf(tmpVol * Math.signum(vol)), BigDecimal.valueOf(upStPrice), upStServ, org, uk, genDt);
			} else {
				//нет проживающих
				if (woKprServ != null) {
					//если существует услуга "без проживающих"
					chStore.addChrg(BigDecimal.valueOf(vol), BigDecimal.valueOf(woKprPrice), woKprServ, org, uk, genDt);
				} else {
					//услуги без проживающих не существует, поставить на свыше соц.нормы
					chStore.addChrg(BigDecimal.valueOf(vol), BigDecimal.valueOf(stPrice), upStServ, org, uk, genDt);
				}
				
			}

		} if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета по объему-2"), 0d) == 1d) {
			//тип расчета, например:Отопление по Гкал
			//Вариант подразумевает объём по лог.счётчику, записанный одной строкой, за период
			//расчет долей соц.нормы и свыше
			if (sqr > 0d) {
				if (cntPers.cntEmpt != 0) {	
					//есть проживающие
					if (stdt.partVol > sqr) {
						tmp = sqr;
					} else {
						tmp = stdt.partVol;
					}
					//найти коэфф соц.нормы к площади лиц.сч.
					cf = BigDecimal.valueOf(tmp).divide(BigDecimal.valueOf(sqr), 15, RoundingMode.HALF_UP);
					//соцнорма
					tmpVolD = BigDecimal.valueOf(vol).multiply(cf);
					//tmpSumD = tmpVolD.multiply(BigDecimal.valueOf(stPrice)); 
					//addChrg(kart, serv, tmpSumD, vol, stPrice, genDt, chrgTpDet);
					chStore.addChrg(tmpVolD, BigDecimal.valueOf(stPrice), stServ, org, uk, genDt);
					//свыше соцнормы
					//tmpVolD = BigDecimal.valueOf(vol).multiply( new BigDecimal("1").subtract(cf) );
					tmpVolD = BigDecimal.valueOf(vol).subtract(tmpVolD);
					//tmpSumD = tmpVolD.multiply(BigDecimal.valueOf(upStPrice)); 
					//addChrg(kart, serv, tmpSumD, vol, upStPrice, genDt, chrgTpDet);
					chStore.addChrg(tmpVolD, BigDecimal.valueOf(upStPrice), upStServ, org, uk, genDt);
				} else {
					//нет проживающих
					if (woKprServ != null) {
						//если есть услуга "без проживающих"
						tmpVolD = BigDecimal.valueOf(vol);
						//tmpSumD = tmpVolD.multiply(BigDecimal.valueOf(woKprPrice)); 
						//addChrg(kart, serv, tmpSumD, vol, woKprPrice, genDt, chrgTpDet);
						chStore.addChrg(tmpVolD, BigDecimal.valueOf(woKprPrice), woKprServ, org, uk, genDt);
					} else {
						//если нет услуги "без проживающих", взять расценку, по услуге свыше соц.нормы
						tmpVolD = BigDecimal.valueOf(vol);
						//tmpSumD = tmpVolD.multiply(BigDecimal.valueOf(upStPrice)); 
						//addChrg(kart, serv, tmpSumD, vol, upStPrice, genDt, chrgTpDet);
						chStore.addChrg(tmpVolD, BigDecimal.valueOf(upStPrice), upStServ, org, uk, genDt);
					}
					
				}
			}
		} if (Utl.nvl(parMng.getDbl(serv, "Вариант расчета для полива"), 0d) == 1d) {
			
			if (cntPers.cntEmpt != 0) {
				//есть проживающие
				//tmpSum = BigDecimal.valueOf(vol).multiply( BigDecimal.valueOf(stPrice) );
				//addChrg(kart, serv, tmpSum, vol, stPrice, genDt, chrgTpDet);
				chStore.addChrg( BigDecimal.valueOf(vol), BigDecimal.valueOf(stPrice), stServ, org, uk, genDt);
			} else {
				//нет проживающих
				//tmpSum = BigDecimal.valueOf(vol).multiply( BigDecimal.valueOf(woKprPrice) );
				//addChrg(kart, serv, tmpSum, vol, woKprPrice, genDt, chrgTpDet);
				chStore.addChrg( BigDecimal.valueOf(vol), BigDecimal.valueOf(woKprPrice), woKprServ, org, uk, genDt);
			}			
			
		}
		//Calc.mess(thrName+" CHECK_END="+serv.getId()+" dt="+genDt,2);	
		
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime2;
		if (totalTime >10) {
 	      Calc.mess("ВРЕМЯ НАЧИСЛЕНИЯ по дате "+genDt.toLocaleString()+" услуге:"+totalTime);
		  
		}
		
	}
	
	/**
	 * сохранить запись о сумме, предназаначенной для коррекции 
	 * @param serv - услуга
	 * @param sum - сумма
	 */
	public void putMapServVal(Serv serv, BigDecimal sum) {
		BigDecimal tmpSum;
		//HaspMap считает разными услуги, если они одинаковые, но пришли из разных потоков, пришлось искать for - ом
		synchronized (mapServ) {
		for (Map.Entry<Serv, BigDecimal> entry : mapServ.entrySet()) {
	    	if (entry.getKey().equals(serv)) { 
	    		tmpSum = Utl.nvl(entry.getValue(), BigDecimal.ZERO);
	    		tmpSum = tmpSum.add(sum);
	    		//Calc.mess("Write serv id="+serv.getId()+" val="+sum,2);
	    	    mapServ.put(entry.getKey(), tmpSum);
	    		return;
	    	}
	    }
	    mapServ.put(serv, sum);
		}
	}
	
	/**
	 * сохранить запись о сумме, предназаначенной для коррекции 
	 * @param serv - услуга
	 * @param sum - сумма
	 */
	public void putMapVrtVal(Serv serv, BigDecimal sum) {
		BigDecimal tmpSum;
		//HaspMap считает разными услуги, если они одинаковые, но пришли из разных потоков, пришлось искать for - ом
		synchronized (mapVrt) {
	    for (Map.Entry<Serv, BigDecimal> entry : mapVrt.entrySet()) {
	    	if (entry.getKey().equals(serv)) {
	    		tmpSum = Utl.nvl(entry.getValue(), BigDecimal.ZERO);
	    		tmpSum = tmpSum.add(sum);
	    		mapVrt.put(entry.getKey(), tmpSum);
	    		return;
	    	}
	    }
	    mapVrt.put(serv, sum);
		}
	}

	/**
	 * добавить из потока строку начисления 
	 * @param chrg - строка начисления
	 */
	public void chrgAdd(Chrg chrg) {
		synchronized (prepChrg) {
		  prepChrg.add(chrg);
		}
	}
	
}
