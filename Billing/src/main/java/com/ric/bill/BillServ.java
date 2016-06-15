package com.ric.bill;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import antlr.collections.List;

import com.ric.bill.excp.EmptyServ;
import com.ric.bill.excp.ErrorWhileDist;
import com.ric.bill.excp.NotFoundNode;
import com.ric.bill.excp.NotFoundODNLimit;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.mt.Meter;
import com.ric.bill.model.mt.MeterExs;
import com.ric.bill.model.mt.MeterLog;
import com.ric.bill.model.mt.MeterLogGraph;
import com.ric.bill.model.mt.Vol;
import com.ric.bill.model.tr.TarifKlsk;
import com.ric.bill.model.tr.TarifServOrg;
import com.ric.bill.model.tr.TarifServProp;

/**
 * Главный сервис биллинга
 * @author lev
 *
 */
@Service
public class BillServ {

	@Autowired
	private Calc calc;

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

    /**
	 * Установить фильтры для сессии
	 */
	private void setFilters() {
		Session session = (Session) em.getDelegate();
		session.enableFilter("FILTER_GEN_DT").setParameter("DT1", Calc.getGenDt());
		session.enableFilter("FILTER_GEN_DT_INNER").setParameter("DT1", Calc.getCurDt1())
												   .setParameter("DT2", Calc.getCurDt2());
		//отдельно установить фильтр существования счетчиков
		setExFilter(Calc.getGenDt());
	}

	/**
	 * Фильтр существования счетчиков (сделал отдельно но не стал применять, так как в ОДН считается наличие хотя бы 1 дня сущ.счетчика ОДПУ)
	 * @param date
	 */
	private void setExFilter(Date date) {
		Session session = (Session) em.getDelegate();
		session.enableFilter("FILTER_GEN_EX_DT").setParameter("DT1", date);
	}
	
	/**
	 * распределить объем по фонду
	 */
	@Transactional
	public void distVols() {
		System.out.println("1");
		calc.setUp(); //настроить
		
		/*MeterLog gg = em.find(MeterLog.class , 3636525);
		System.out.println("TEST:"+gg.getName()+" klsk_obj:"+gg.getKlskObj()+" lsk:"+gg.getKart().getLsk()+" fio="+gg.getKart().getFio());

		gg = em.find(MeterLog.class , 3636530);
		System.out.println("TEST2:"+gg.getName()+" klsk_obj:"+gg.getKlskObj()+" lsk:"+gg.getKart().getLsk()+" fio="+gg.getKart().getFio());
		*/
		
		for (House o: calc.getHouseMng().findAll()) {
			calc.setHouse(o);
			calc.setArea(calc.getHouse().getStreet().getArea());
			System.out.println("Дом загружен="+o.getId());
			
			 //TarifKlsk k = em.find(TarifKlsk.class , 548342);
			 /*Set<TarifKlsk> ttt = calc.getHouse().getStreet().getArea().getTarklsk();
				for (TarifKlsk k : ttt) {
					System.out.println("k2="+k.getId());
					//затем по строкам - составляющим тариф 

					for (TarifServOrg t : k.getTarorg()) {
						System.out.println("t2="+k.getId());
					}

				}		*/

			//удалить объемы по всем услугам дома
			delHouseVol();
			//распределить объемы
			distHouseVol();
		}

	}

	/**
	 * удалить объемы по дому
	 */
	
	@Transactional
	public void delHouseVol() {
		//найти все необходимые услуги для удаления объемов
		for (Serv s : calc.getServMng().findForChrg()) {
			//if (s.getId()==36){  //пока только по горячей воде!
				calc.setServ(s);
				delHouseVolServ();
			//}
		}
	}
	
	/**
	 * Удалить объем по вводам дома
	 * 
	 * @param serv - заданная услуга
	 */
	
	private void delHouseVolServ() {
		delHouseServVolTp(calc.getServ().getMet(), 1);
		delHouseServVolTp(calc.getServ().getMet(), 0);
		delHouseServVolTp(calc.getServ().getMet(), 2);
		delHouseServVolTp(calc.getServ().getMet(), 3);
		if (calc.getServ().getOdn() != null){
			delHouseServVolTp(calc.getServ().getOdn(), 0);//счетчики ОДН
		} 
	}

	
	/**
	 * Удалить объем по вводу, определённой услуге
	 * @param serv - услуга
	 */
	
	private void delHouseServVolTp(Serv serv, int tp) {
		//найти все вводы по дому и по услуге
		for (MeterLog ml : calc.getHouseMng().getMetLogByServTp(calc.getHouse(), serv, "Ввод")) {
			calc.getMetLogMng().delNodeVol(ml, tp);
		}
	}
	
	/**
	 * распределить объем по дому
	 */
	@Transactional
	public void distHouseVol() {
		System.out.println("Дом: id="+calc.getHouse().getId());
		System.out.println("Дом: klsk="+calc.getHouse().getKlsk());
		System.out.println("Площадь: "+calc.getHouseMng().getDbl(calc.getHouse(), "Площадь.Жилая"));

		//найти все необходимые услуги для распределения
		for (Serv s : calc.getServMng().findForChrg()) {
			calc.setServ(s);
			System.out.println("Распределение услуги: "+s.getCd());
			distHouseServ();
		}
	}
	
	
	/**
	 * распределить объем по услуге данного дома
	 */
	
	private void distHouseServ() {
		System.out.println("Услуга="+calc.getServ().getCd());

		setFilters();//вкл.фильтр

		Calc.beginTimer();
		calc.setCalcTp(1);
		distHouseServTp(calc.getServ().getMet());//Расчет площади, кол-во прожив
		Calc.showTimer("1 тип");

		Calc.beginTimer();
		calc.setCalcTp(0);
		distHouseServTp(calc.getServ().getMet());//Распределение объема
		Calc.showTimer("0 тип");

		Calc.beginTimer();
		calc.setCalcTp(2);
		
		distHouseServTp(calc.getServ().getMet());//Расчет ОДН
		Calc.showTimer("2 тип");

		/*
		calc.setCalcTp(3);
		distHouseServTp(calc.getServ().getMet());//Расчет пропорц.площади
		if (calc.getServ().getOdn() != null){
			calc.setCalcTp(0);
			distHouseServTp(calc.getServ().getOdn());//Суммировать счетчики ОДН
		} */
	}
	
	/**
	 * Распределить объем по вводам дома
	 * @param calcTp - тип обработки
	 */
	
	private void distHouseServTp(Serv serv) {
		System.out.println("Распределение по типу:"+calc.getCalcTp());
		//найти все вводы по дому и по услуге
		for (MeterLog ml : calc.getHouseMng().getMetLogByServTp(calc.getHouse(), serv, "Ввод")) {
			try {
				distGraph(ml);
			} catch (ErrorWhileDist e) {
				e.printStackTrace();
				return;
			}
		}
	}
	
	/**
	 * Распределить граф начиная с mLog
	 * @param mLog - начальный узел распределения
	 * @throws ErrorWhileDist 
	 */
	@Cacheable("billCache")
	
	private void distGraph (MeterLog mLog) throws ErrorWhileDist {
		System.out.println("Распределение ввода:"+mLog.getId());
		//перебрать все необходимые даты, за период
		Calendar c = Calendar.getInstance();
		//необходимый для формирования диапазон дат
		Date dt1, dt2;
		if (calc.getCalcTp()==2) {
			//формирование по ОДН - задать последнюю дату
			dt1 = Calc.getCurDt2();
			dt2 = Calc.getCurDt2();
		} else {
			//прочее формирование
			dt1 = Calc.getCurDt1();
			dt2 = Calc.getCurDt2();
		}
		
		//c.setTime(Calc.getCurDt1());
		for (c.setTime(dt1); !c.getTime().after(dt2); c.add(Calendar.DATE, 1)) {
			Calc.setGenDt(c.getTime());
			@SuppressWarnings("unused")
			NodeVol dummy;
			try {
				dummy=distNode(mLog, new NodeVol());
			} catch (WrongGetMethod e) {
				throw new ErrorWhileDist("При расчете счетчика MeterLog.Id="+mLog.getId()+" , обнаружен замкнутый цикл");  
			} catch (EmptyServ e) {
				throw new ErrorWhileDist("Пустая услуга при рекурсивном вызове BillServ.distNode()");
			} catch (NotFoundODNLimit e) {
				throw new ErrorWhileDist("Не найден лимит ОДН в счетчике ОДН, при вызове BillServ.distNode()");
			} catch (NotFoundNode e) {
				throw new ErrorWhileDist("Не найден нужный счетчик, при вызове BillServ.distNode()");
			}
			System.out.println("по дате="+Calc.getGenDt());
			
			//break;
		}
		
	}
	
	/**
	 * Распределить узел, следуя по графу (рекурсивная процедура)
	 * @param mLog
	 * @param nv
	 * @return
	 * @throws WrongGetMethod
	 * @throws NotFoundODNLimit */
	
	@Cacheable("billCache")
	
	private NodeVol distNode (MeterLog mLog, NodeVol nv) throws WrongGetMethod, EmptyServ, NotFoundODNLimit, NotFoundNode {
		//Double tmpD=0d; //для каких нить нужд
		Double partArea =0d; //текущая доля площади, по узлу
		Double partPers =0d; //текущая доля кол-ва прожив, по узлу
		Double vl =0d; //текущая доля объема, по узлу
		//получить лицевой счет, к которому привязан счетчик, для убоства
		Kart kart = mLog.getKart();
		calc.setKart(kart); 
		
		if (nv.getRecur() > 1000) {
			throw new WrongGetMethod("При расчете счетчика MeterLog.Id="+mLog.getId()+" , обнаружен замкнутый цикл");
		}
		nv.addRecur();
		System.out.println("Номер итерации:"+nv.getRecur());
		System.out.println("Счетчик:id="+mLog.getId()+" тип="+mLog.getTp().getCd()+" наименование:"+mLog.getName()+" klsk_obj="+mLog.getKlskObj());
		if (mLog.getKart()!=null && mLog.getKart().getLsk().equals("26074190") && calc.getCalcTp()==0 && mLog.getServ().getId()==79) {
			//System.out.println("KLSK Лиц счет счетчика="+mLog.getKart().getKlsk());
			System.out.println("Лиц счет счетчика="+mLog.getKart().getLsk());
		}

		String mLogTp = mLog.getTp().getCd(); //тип лог счетчика
		Serv servChrg = mLog.getServ().getChrg(); //получить основную услугу, для начисления
		if (servChrg == null) {
			throw new EmptyServ("При расчете счетчика MeterLog.Id="+mLog.getId()+" , обнаружена пустая услуга для расчета начисления");
		}
		
		if (calc.getCalcTp()==0) {
			//if (mLog.getId()==3685454) {
				//System.out.println("Лиц счет счетчика="+mLog.getKart().getLsk());
			//}
			
			//по расчетной связи
			if (mLogTp.equals("ЛИПУ") || mLogTp.equals("ЛОДПУ") || mLogTp.equals("ЛГрупп")) {
				//посчитать объемы, по физическим счетчикам, прикрепленным к узлу
			    //(если такие есть) в пропорции на кол-во дней объема
				for (Meter m : mLog.getMeter()) { 		//физ.сч
					for (Vol v : m.getVol()) {    		//фактические объемы
						if (v.getTp().getCd().equals("Фактический объем")) {
							for (MeterExs e : m.getExs()) { //периоды сущ.
								//добавить объем в объект объема
								//умножить объем на процент существования и на долю дня
								vl=v.getVol1() * e.getPrc() / calc.getCntCurDays();
								if (vl != 0) {
 									nv.addVol( vl );
								}
								
							}
						}
					}
				}
			} else if (mLogTp.equals("ЛНрм")){
				//по нормативу
				System.out.println("before:");
				vl = calc.getKartMng().getStandart(mLog, calc, null).partVol;
				nv.addVol(vl);
			}
				
		} else if (calc.getCalcTp()==1 && kart != null) {
			//по связи по площади и кол.прож. (только по Лиц.счёту) в доле 1 дня
			//площадь
			partArea = calc.getKartMng().getDbl(kart, "Площадь.Общая") / calc.getCntCurDays(); 
			nv.addPartArea(partArea);
			//проживающие
			CntPers cntPers= new CntPers();
			calc.getKartMng().getCntPers(kart, servChrg, cntPers, 0);
			partPers = cntPers.cnt / calc.getCntCurDays();
			nv.addPartPers(partPers);

		} else if (calc.getCalcTp()==2 && mLogTp.equals("Лсчетчик")) {
			//по расчетной связи ОДН (только у лог.счетчиков, при наличии расчетной связи ОДН)
			//получить дельту ОДН, площадь, кол-во людей, для расчета пропорции в последствии
			//сохранить счетчик ЛОДН
			SumNodeVol lnkODNVol = null;
			MeterLog lnkLODN = null;
			MeterLog lnkSumODPU = null;
			MeterLog lnkODPU = null;
			//поиск счетчика ЛОДН
			lnkLODN = calc.getMetLogMng().getLinkedNode(mLog, "ЛОДН");
			if (lnkLODN == null) {
				// не найден счетчик
		        throw new NotFoundNode("Не найден счетчик ЛОДН, связанный со счетчиком id="+mLog.getId());  
			}
			//поиск счетчика ЛСумОдпу
			lnkSumODPU = calc.getMetLogMng().getLinkedNode(lnkLODN, "ЛСумОДПУ");
			if (lnkSumODPU == null) {
				// не найден счетчик
		        throw new NotFoundNode("Не найден счетчик ЛСумОДПУ, связанный со счетчиком id="+lnkLODN.getId());  
			}
			//поиск счетчика Ф/Л ОДПУ
			lnkODPU = calc.getMetLogMng().getLinkedNode(lnkSumODPU, "ЛОДПУ");
			if (lnkODPU == null) {
				// не найден счетчик
		        throw new NotFoundNode("Не найден счетчик ЛОДПУ, связанный со счетчиком id="+lnkSumODPU.getId());  
			}

			//получить объем за период по счетчику ЛОДН и наличие ОДПУ
			lnkODNVol = calc.getMetLogMng().getVolPeriod(lnkLODN);

			//получить проживающих и площадь за период по счетчику данного лиц.счета (основываясь на meter_vol)
			SumNodeVol sumVol = calc.getMetLogMng().getVolPeriod(mLog);

			if (lnkODNVol.getExs() && lnkODNVol.getVol() > 0d) {
				//при наличии счетчика(ков) ОДПУ и объема по нему
				if (lnkODNVol.getVol() > 0 && lnkODNVol.getArea() > 0) {
					//ПЕРЕРАСХОД
					vl = lnkODNVol.getVol() * sumVol.getArea() / lnkODNVol.getArea();
					//применить лимит по ОДН
					Double limit = calc.getMetLogMng().getDbl((Storable)lnkLODN, "Лимит по ОДН");
					Double limitVol = lnkODNVol.getLimit();
					if (limit == null) {
						throw new NotFoundODNLimit("Не найден обязательный параметр - лимит по ОДН в счетчике="+lnkLODN.getId());
					} else if (limit == 1 && limitVol > 0) {
						//если больше лимита - ограничить лимит * площадь
						if (vl > limitVol * sumVol.getArea()) {
							vl = limitVol * sumVol.getArea();
						}
					}
				} else {
					//ЭКОНОМИЯ
					//экономия, но в пределах потреблённого по основной услуге объема. Внимание! в квартплате решили так не учитывать, а учитывать в контексте услуги ОДН!

					//получить основную услугу
					Serv mainServ = calc.getServMng().findMain(servChrg);
					//получить счетчик основной услуги
					MeterLog mlMain = calc.getKartMng().getFirstMetLogByServTp(kart, mainServ, "ЛИПУ");
					//получить объем за период, по лог счетчику основной услуги
					SumNodeVol sumMainVol = calc.getMetLogMng().getVolPeriod(mlMain);
					//если есть проживающие по узлу ОДН
					if (lnkODNVol.getPers() > 0 ) {
						vl = lnkODNVol.getVol() * sumVol.getPers() / lnkODNVol.getPers();  
						//округлить до 4 знаков
						vl = (double)Math.round(vl * 10000d) / 10000d;
					}
					//ограничить экономию текущим потреблением по основному счетчику
					if (Math.abs(vl) > sumMainVol.getVol() && sumMainVol.getVol() > 0) {
						vl = -1 * sumMainVol.getVol();
					}
				}
				
			} else if (calc.getMetLogMng().getDbl((Storable)lnkLODN, "Доначисление по ОДН") > 0d) {
				//если есть объем дораспределения ОДН на м2 - то использовать его
				vl = calc.getMetLogMng().getDbl((Storable)lnkLODN, "Доначисление по ОДН") * sumVol.getArea();
			} else {
				//не найден счётчик ОДПУ (должно начислиться по лимиту ОДН (Нормативу) * площадь л.с.)
				//или нет объема по ОДПУ
				Double limit = calc.getMetLogMng().getDbl((Storable)lnkLODN, "Лимит по ОДН");
				if (limit == null) {
					throw new NotFoundODNLimit("Не найден обязательный параметр - лимит по ОДН в счетчике="+lnkLODN.getId());
				} else if (limit == 1) {
					//если больше лимита - ограничить лимит * площадь
					Double limitVol = lnkODNVol.getLimit();
					vl = limitVol * sumVol.getArea();
				}
			}
			
			
			
		} else if (calc.getCalcTp()==3 && mLogTp.equals("Лсчетчик")) {
			//по расчетной связи пропорц.площади (Отопление например)
			
		}
		
		//найти все направления, с необходимым типом, указывающие в точку из других узлов, получить их объемы
		//System.out.println("Найдено входящих направлений ="+mLog.getDst().size());
		for (MeterLogGraph g : mLog.getInside()) {
			if (calc.getCalcTp()==0 && g.getTp().getCd().equals("Расчетная связь") 
			 || calc.getCalcTp()==1 && g.getTp().getCd().equals("Связь по площади и кол-во прож.")
			 || calc.getCalcTp()==2 && g.getTp().getCd().equals("Расчетная связь ОДН")
			 || calc.getCalcTp()==3 && g.getTp().getCd().equals("Расчетная связь пропорц.площади")) {
					distNode(g.getSrc(), nv);
			}
		}
		
		//if (kart!=null) {
			//if (kart.getLsk().equals("26074281")) {
			//  System.out.println("Записан счетчик: id="+mLog.getId());
			//}
		//}

		Lst volTp=null;
		//записать объем или площадь или кол-во прож. в текущий узел (лог.счетчик)
		if (calc.getCalcTp()==0) {
			//расчетная связь
			volTp = calc.getLstMng().findByCD("Фактический объем");
			Vol vol = new Vol(mLog, volTp, vl, null, Calc.getGenDt(), Calc.getGenDt());
			em.merge(vol);
		} if (calc.getCalcTp()==1) {
			//связь подсчета площади, кол-во проживающих, сохранять, если только в тестовом режиме TODO!!!
			volTp = calc.getLstMng().findByCD("Площадь и проживающие");
			Vol vol = new Vol(mLog, volTp, partArea, partPers, Calc.getGenDt(), Calc.getGenDt());
			//em.merge(vol);
		}
		
		
		//счетчик рекурсии на -1
		nv.decRecur();
		return nv;
	}
}
