package com.ric.bill;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.dao.ParDAO;
import com.ric.bill.excp.EmptyOrg;
import com.ric.bill.excp.EmptyServ;
import com.ric.bill.excp.InvalidServ;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.KartMng;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.MeterLogMng;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Dw;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.bs.Par;
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
@Scope("prototype")
public class ChrgThr  extends Thread implements ApplicationContextAware{
	
	@Autowired
	private LstMng lstMng;
	@Autowired
	private ChrgServ chrgServ;
	@Autowired
	private KartMng kartMng;
	@Autowired
	private MeterLogMng metMng;

	private Serv serv;
	//временное хранилище записей
	private ChrgStore chStore;

	private Kart kart;

	private ApplicationContext applicationContext;
	
	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

    //конструктор
	public ChrgThr() {
		super();
	}
	
	//установить параметры
	public void set(Serv serv, Kart kart) {
		//Calc.mess("Check THR1",2);
		this.serv = serv;
		this.kart = kart;
		
		//this.serv = em.find(Serv.class, serv.getId());
		//this.kart = em.find(Kart.class, kart.getLsk());

	}

	public void run() {
		long startTime2;
		long endTime;
		long totalTime;
		startTime2 = System.currentTimeMillis();

		//необходимый для формирования диапазон дат
		Date dt1, dt2, genDt;
		dt1 = Calc.getCurDt1();
		dt2 = Calc.getCurDt2();

		//Calc.mess("Расчет услуги id="+serv.getId(),2);
		//типы записей начисления
		Lst chrgTpRnd = lstMng.findByCD("Начислено свернуто, округлено");
		
		//Объект, временно хранящий записи начисления
		chStore = new ChrgStore(); 
		if (serv.getId()==32) {
		  //Calc.mess("ChrThr: Услуга:"+serv.getCd()+" Id="+serv.getId(),2);
		}
		Calendar c = Calendar.getInstance();
		
		for (c.setTime(dt1); !c.getTime().after(dt2); c.add(Calendar.DATE, 1)) {
			genDt = c.getTime();
			//Calc.mess("Дата:"+genDt + " по услуге="+serv.getId(), 2);
			//только там, где нет статуса "не начислять" за данный день
			if (Utl.nvl(chrgServ.getDbl(kart, "IS_NOT_CHARGE", genDt), 0d) == 1d) {
				continue;
			}
			//только там, где существует услуга в данном дне
			if (kartMng.getServ(kart, serv, genDt)) {
				String tpOwn = chrgServ.getStr(kart, "FORM_S", genDt); 
				//где лиц.счет является нежилым помещением, не начислять за данный день
				if (tpOwn.equals("Нежилое собственное") || tpOwn.equals("Нежилое муниципальное")
					|| tpOwn.equals("Аренда некоммерч.") || tpOwn.equals("Для внутр. пользования")) {
					continue;
				}
				//Calc.mess("ДАТА="+genDt.toString(),2);
	
					//Calc.mess("Услуга:"+serv.getCd());
					//Calc.setServ(serv);
					//начислить услугу
					//Calc.mess("дом="+kart.getKw().getHouse().getId());
					
					try {
					  chrgServ(kart, serv, tpOwn, genDt);
					} catch (EmptyServ e) {
						e.printStackTrace();
						//throw new ErrorWhileChrg("ChrgServ.chrgLsk: Пустая услуга!");  TODO! Временно убрал EXCEPTION! ВЕРНУТЬ!
					} catch (EmptyOrg e) {
						e.printStackTrace();
						//throw new ErrorWhileChrg("ChrgServ.chrgLsk: Пустая организация!");  TODO! Временно убрал EXCEPTION! ВЕРНУТЬ!
					} catch (InvalidServ e) {
						e.printStackTrace();
						//throw new ErrorWhileChrg("ChrgServ.chrgLsk: Некорректна услуга!");  TODO! Временно убрал EXCEPTION! ВЕРНУТЬ!
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
				//BigDecimal tmpSum = Utl.nvl(chrgServ.getMapServVal(rec.getServ().getServVrt()) , BigDecimal.ZERO);
				//tmpSum = tmpSum.add(sum);
				//chrgServ.putMapServVal(rec.getServ().getServVrt(), tmpSum);
				chrgServ.putMapServVal(rec.getServ().getServVrt(), sum);
			}
			//записать, сумму по виртуальной услуге
			if (rec.getServ().getVrt()) {
					//BigDecimal tmpSum = Utl.nvl(chrgServ.getMapVrtVal(rec.getServ()), BigDecimal.ZERO);
					//tmpSum = tmpSum.add(sum);
					chrgServ.putMapVrtVal(rec.getServ(), sum);
					//chrgServ.compMapVrtVal(rec.getServ(), tmpSum);
					
			}

			if (!rec.getServ().getVrt()) {
				if (sum.compareTo(BigDecimal.ZERO) != 0) {
					Chrg chrg = new Chrg(kart, rec.getServ(), rec.getOrg(), 1, Calc.getPeriod(), sum, sum, 
							vol, rec.getPrice(), chrgTpRnd, rec.getDt1(), rec.getDt2());
					chrgServ.chrgAdd(chrg);
				}
			}
		} 

		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime2;
	    //Calc.mess("Поток завершён, ВРЕМЯ НАЧИСЛЕНИЯ по услуге Id="+serv.getId()+":   "+totalTime, 2);

	    /*for (Chrg chrg : prepChrg) {
			Calc.mess("Наличие ЗАПИСЕЙ услуга="+chrg.getServ().getId(),2);
		}	*/
	    
		//break;		
	}

	/**
	 * расчитать начисление по услуге
	 * @param serv - услуга
	 * @throws InvalidServ 
	 */
	public void chrgServ(Kart kart, Serv serv, String tpOwn, Date genDt) throws EmptyServ, EmptyOrg, InvalidServ {
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
			Calc.mess("Check1");
		}

		//получить необходимые услуги
		stServ = serv.getServSt();
		upStServ = serv.getServUpst();
		woKprServ = serv.getServWokpr();
		//если услуга по соцнорме пустая, присвоить изначальную услугу
		if (stServ == null) {
			stServ = serv;
		}
		
		
		//контроль наличия услуги св.с.нормы (по ряду услуг)
		if ((Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета по общей площади-1"), 0d) == 1d || 
				Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета по объему-1"), 0d) == 1d) && serv.getServUpst() == null) {
			throw new EmptyServ("По услуге Id="+serv.getId()+" обнаружена пустая услуга свыше соц.нормы");
		}
		
		//Получить кол-во проживающих 
		synchronized (kartMng) {
		  kartMng.getCntPers(kart, serv, cntPers, 0, genDt); //tp=0 (для получения кол-во прож. для расчёта нормативного объема)
		}
		//calc.mess("Kart.klsk="+kart.getKlsk(), 2);
		//calc.mess("Kart.lsk="+kart.getLsk()+" SERV="+stServ.getCd()+" SERV ID="+stServ.getId(), 2);
		
		//получить расценку по норме	
		synchronized (kartMng) {
			stPrice = kartMng.getServPropByCD(kart, stServ, "Цена", genDt);
		}
		
		if (stPrice == null) {
			stPrice = 0d;
		}

		
		//получить нормативный объем
		if (Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета по общей площади-1"), 0d) == 1d || 
				Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета по объему-1"), 0d) == 1d ||
				Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета по объему-2"), 0d) == 1d ||
				Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета для полива"), 0d) == 1d) {
			
			
			synchronized (kartMng) {
				stdt = kartMng.getStandart(kart, serv, cntPers, genDt);
			}
			//здесь же получить расценки по свыше соц.нормы и без проживающих 
			if (serv.getServUpst() != null) {
				
				//Calc.mess("CHECK!"+kart,2 );
				upStPrice = kartMng.getServPropByCD(kart, upStServ, "Цена", genDt);
				if (upStPrice == null) {
					upStPrice = 0d;
				}
			} else {
				upStPrice = 0d;
			}

			if (serv.getServWokpr() != null) {
				woKprPrice = kartMng.getServPropByCD(kart, woKprServ, "Цена", genDt);
				if (woKprPrice == null) {
					woKprPrice = 0d;
				}
			} else {
				woKprPrice = 0d;
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
		baseCD = chrgServ.getStr(serv, "Name_CD_par_base_charge");

	
		//получить объем для начисления
		if (Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета по кол-ву точек-1"), 0d) == 1d || 
				Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета по общей площади-1"), 0d) == 1d ||
				Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета по общей площади-2"), 0d) == 1d) {
			//получить объем одного дня
			vol = Utl.nvl(chrgServ.getDbl(kart, baseCD, genDt), 0d);
			
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
			
		} else if (Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета для полива"), 0d) == 1d) {
			//получить объем за месяц
			vol = Utl.nvl(chrgServ.getDbl(kart, baseCD, genDt), 0d);
			//получить долю объема за день HARD CODE
			//площадь полива (в доле 1 дня)/100 * 60 дней / 12мес * норматив / среднее кол-во дней в месяце
			vol = vol/100d*60d/12d*stdt.partVol/30.4d/Calc.getCntCurDays();
			
		} else if (Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета по объему-1"), 0d) == 1d ||
				   Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета по объему-2"), 0d) == 1d) {
			
			//Вариант подразумевает объём по лог.счётчику, РАспределённый по дням
			if (serv.getServMet() == null) {
				throw new InvalidServ("По услуге Id="+serv.getId()+" не установлена соответствующая услуга счетчика");
			}
			//получить объем по лицевому счету и услуге за ДЕНЬ
			SumNodeVol tmpNodeVol = metMng.getVolPeriod(kart, serv.getServMet(), genDt, genDt);
			vol = tmpNodeVol.getVol();
			//vol=5d;
			
			if (Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета по объему-2"), 0d) == 1d) {
				//доля площади в день
				sqr = Utl.nvl(chrgServ.getDbl(kart, baseCD, genDt), 0d) / Calc.getCntCurDays();
			}
			
			
		} else if (Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета по объему без исп.норматива-1"), 0d) == 1d) {
			//Вариант подразумевает объём по лог.счётчику, НЕ распределённый по дням,
			//а записанный одной строкой (одним периодом дата нач.-дата кон.)
			if (serv.getServMet() == null) {
				throw new InvalidServ("По услуге Id="+serv.getId()+" не установлена соответствующая услуга счетчика");
			}
			//получить объем по услуге за период
			SumNodeVol tmpNodeVol = metMng.getVolPeriod(kart, serv.getServMet(), Calc.getCurDt1(), Calc.getCurDt2());
			vol = tmpNodeVol.getVol();
			vol = vol / Calc.getCntCurDays();
		} else if (Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета по готовой сумме"), 0d) == 1d) {
			vol = 1 / Calc.getCntCurDays();
		}


		/*if (true) {
			return;
		}*/
		
		//ВЫПОЛНИТЬ РАСЧЕТ
	
		if (Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета по общей площади-2"), 0d) == 1d ||
			Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета по кол-ву точек-1"), 0d) == 1d ||
			Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета по объему без исп.норматива-1"), 0d) == 1d) {
			//без соцнормы и свыше!
			//тип расчета, например:Взносы на капремонт
			//Вариант подразумевает объём, по параметру - базе, жилого фонда РАСПределённый по дням
	        //тип расчета, например Х.В.ОДН, Г.В.ОДН, Эл.эн.ОДН
			//tmpSum = BigDecimal.valueOf(vol).multiply( BigDecimal.valueOf(stPrice) );
			//addChrg(kart, serv, tmpSum, vol, stPrice, genDt, chrgTpDet);
			chStore.addChrg(BigDecimal.valueOf(vol), BigDecimal.valueOf(stPrice), stServ, org, genDt);
			/*tmpSum = BigDecimal.valueOf(vol).multiply( BigDecimal.valueOf(stPrice) );
			if (tmpSum != BigDecimal.ZERO) {
				Chrg chrg = new Chrg(kart, serv, 1, Calc.getPeriod(), tmpSum, tmpSum, vol, stPrice, chrgTpDet, genDt, genDt);
				kart.getChrg().add(chrg);
			}*/
		} if (Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета по готовой сумме"), 0d) == 1d) {
			//тип расчета, например:Коммерческий найм, где цена = сумме
			//tmpSum = BigDecimal.valueOf(stPrice);
			//addChrg(kart, serv, tmpSum, vol, stPrice, genDt, chrgTpDet);
			chStore.addChrg(BigDecimal.valueOf(vol), BigDecimal.valueOf(stPrice), stServ, org, genDt);
			
			/*if (tmpSum != BigDecimal.ZERO) {
				Chrg chrg = new Chrg(kart, serv, 1, Calc.getPeriod(), tmpSum, tmpSum, vol, stPrice, chrgTpDet, genDt, genDt);
				kart.getChrg().add(chrg);
			}*/
		} else if (Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета по общей площади-1"), 0d) == 1d ||
				   Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета по объему-1"), 0d) == 1d) {
			//тип расчета, например:текущее содержание, Х.В., Г.В., Канализ
			//Вариант подразумевает объём по лог.счётчику, РАСПределённый по дням
			//или по параметру - базе, жилого фонда, так же распределенного по дням
			if (cntPers.cntEmpt != 0) {
				//есть проживающие
				//соцнорма
				if (vol <= stdt.partVol) {
					tmpVol= vol;
				} else {
					tmpVol= stdt.partVol;
				}
	
				//tmpSum = BigDecimal.valueOf(vol).multiply( BigDecimal.valueOf(stPrice) );
				//addChrg(kart, serv, tmpSum, vol, stPrice, genDt, chrgTpDet);
				chStore.addChrg(BigDecimal.valueOf(tmpVol), BigDecimal.valueOf(stPrice), stServ, org, genDt);
/*				if (tmpSum != BigDecimal.ZERO) {
					Chrg chrg = new Chrg(kart, serv, 1, Calc.getPeriod(), tmpSum, tmpSum, vol, stPrice, chrgTpDet, genDt, genDt);
					kart.getChrg().add(chrg);
				}*/
				
				//свыше соцнормы
				tmpVol = vol - tmpVol;
				//tmpSum = BigDecimal.valueOf(vol).multiply( BigDecimal.valueOf(stPrice) );
				//addChrg(kart, serv, tmpSum, vol, stPrice, genDt, chrgTpDet);
				chStore.addChrg(BigDecimal.valueOf(tmpVol), BigDecimal.valueOf(upStPrice), upStServ, org, genDt);
/*				if (tmpSum != BigDecimal.ZERO) {
					Chrg chrg = new Chrg(kart, serv, 1, Calc.getPeriod(), tmpSum, tmpSum, vol, stPrice, chrgTpDet, genDt, genDt);
					kart.getChrg().add(chrg);
				}*/
				
			} else {
				//нет проживающих
				if (woKprServ != null) {
					//если существует услуга "без проживающих"
					//tmpSum = BigDecimal.valueOf(vol).multiply( BigDecimal.valueOf(woKprPrice) );
					//addChrg(kart, serv, tmpSum, vol, stPrice, genDt, chrgTpDet);
					chStore.addChrg(BigDecimal.valueOf(vol), BigDecimal.valueOf(woKprPrice), woKprServ, org, genDt);
				} else {
					//услуги без проживающих не существует, поставить на свыше соц.нормы
					//tmpSum = BigDecimal.valueOf(vol).multiply( BigDecimal.valueOf(upStPrice) );
					//addChrg(kart, serv, tmpSum, vol, stPrice, genDt, chrgTpDet);
					chStore.addChrg(BigDecimal.valueOf(vol), BigDecimal.valueOf(stPrice), upStServ, org, genDt);
				}
				
			}

		} if (Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета по объему-2"), 0d) == 1d) {
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
					chStore.addChrg(tmpVolD, BigDecimal.valueOf(stPrice), stServ, org, genDt);
					//свыше соцнормы
					//tmpVolD = BigDecimal.valueOf(vol).multiply( new BigDecimal("1").subtract(cf) );
					tmpVolD = BigDecimal.valueOf(vol).subtract(tmpVolD);
					//tmpSumD = tmpVolD.multiply(BigDecimal.valueOf(upStPrice)); 
					//addChrg(kart, serv, tmpSumD, vol, upStPrice, genDt, chrgTpDet);
					chStore.addChrg(tmpVolD, BigDecimal.valueOf(upStPrice), upStServ, org, genDt);
				} else {
					//нет проживающих
					if (woKprServ != null) {
						//если есть услуга "без проживающих"
						tmpVolD = BigDecimal.valueOf(vol);
						//tmpSumD = tmpVolD.multiply(BigDecimal.valueOf(woKprPrice)); 
						//addChrg(kart, serv, tmpSumD, vol, woKprPrice, genDt, chrgTpDet);
						chStore.addChrg(tmpVolD, BigDecimal.valueOf(woKprPrice), woKprServ, org, genDt);
					} else {
						//если нет услуги "без проживающих", взять расценку, по услуге свыше соц.нормы
						tmpVolD = BigDecimal.valueOf(vol);
						//tmpSumD = tmpVolD.multiply(BigDecimal.valueOf(upStPrice)); 
						//addChrg(kart, serv, tmpSumD, vol, upStPrice, genDt, chrgTpDet);
						chStore.addChrg(tmpVolD, BigDecimal.valueOf(upStPrice), upStServ, org, genDt);
					}
					
				}
			}
		} if (Utl.nvl(chrgServ.getDbl(serv, "Вариант расчета для полива"), 0d) == 1d) {
			
			if (cntPers.cntEmpt != 0) {
				//есть проживающие
				//tmpSum = BigDecimal.valueOf(vol).multiply( BigDecimal.valueOf(stPrice) );
				//addChrg(kart, serv, tmpSum, vol, stPrice, genDt, chrgTpDet);
				chStore.addChrg( BigDecimal.valueOf(vol), BigDecimal.valueOf(stPrice), stServ, org, genDt);
			} else {
				//нет проживающих
				//tmpSum = BigDecimal.valueOf(vol).multiply( BigDecimal.valueOf(woKprPrice) );
				//addChrg(kart, serv, tmpSum, vol, woKprPrice, genDt, chrgTpDet);
				chStore.addChrg( BigDecimal.valueOf(vol), BigDecimal.valueOf(woKprPrice), woKprServ, org, genDt);
			}			
			
		}
		
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime2;
		if (totalTime >10) {
 	      Calc.mess("ВРЕМЯ НАЧИСЛЕНИЯ по дате "+genDt.toLocaleString()+" услуге:"+totalTime);
		  
		}
		
	}

public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
}



 public ApplicationContext getContext() {
        return applicationContext;
    }	
}
