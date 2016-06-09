package com.ric.bill;

import java.util.Calendar;

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
import com.ric.bill.excp.NotFoundNode;
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
	@Transactional(propagation=Propagation.MANDATORY)
	private void setFilters() {
		Session session = (Session) em.getDelegate();
		session.enableFilter("FILTER_GEN_DT").setParameter("DT1", Calc.getGenDt());
		session.enableFilter("FILTER_GEN_DT_INNER").setParameter("DT1", Calc.getCurDt1())
												   .setParameter("DT2", Calc.getCurDt2());
	}

	/**
	 * распределить объем по фонду
	 */
	@Transactional
	public void distVols() {
		System.out.println("1");
		calc.setUp(); //настроить
		setFilters();//вкл.фильтр
		//найти необходимые дома
		calc.getHouseMng().findAll();
		
		/*MeterLog gg = em.find(MeterLog.class , 3636525);
		System.out.println("TEST:"+gg.getName()+" klsk_obj:"+gg.getKlskObj()+" lsk:"+gg.getKart().getLsk()+" fio="+gg.getKart().getFio());

		gg = em.find(MeterLog.class , 3636530);
		System.out.println("TEST2:"+gg.getName()+" klsk_obj:"+gg.getKlskObj()+" lsk:"+gg.getKart().getLsk()+" fio="+gg.getKart().getFio());
		*/
		
		for (House o: calc.getHouseMng().findAll()) {
			calc.setHouse(o);
			calc.setArea(calc.getHouse().getStreet().getArea());
			System.out.println("Дом загружен="+o.getId());
			
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
		System.out.println("Площадь: "+calc.getHouseMng().getDbl(calc.getHouse().getDw(), "Площадь.Жилая"));

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
	@Transactional
	private void distHouseServ() {
		System.out.println("Услуга="+calc.getServ().getCd());
		calc.setCalcTp(1);
		distHouseServTp(calc.getServ().getMet());//Расчет площади, кол-во прожив
		calc.setCalcTp(0);
		distHouseServTp(calc.getServ().getMet());//Распределение объема
		calc.setCalcTp(2);
		distHouseServTp(calc.getServ().getMet());//Расчет ОДН

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
			distGraph(ml);
		}
	}
	
	/**
	 * Распределить граф начиная с mLog
	 * @param mLog - начальный узел распределения
	 */
	
	private void distGraph (MeterLog mLog) {
		System.out.println("Распределение ввода:"+mLog.getId());
		//перебрать все даты, за период
		Calendar c = Calendar.getInstance();
		c.setTime(Calc.getCurDt1());
		for (c.setTime(Calc.getCurDt1()); !c.getTime().after(Calc.getCurDt2()); c.add(Calendar.DATE, 1)) {
			System.out.println("Распределение даты:"+c.getTime());
			long startTime = System.currentTimeMillis();
			Calc.setGenDt(c.getTime());
			@SuppressWarnings("unused")
			NodeVol dummy;
			try {
				dummy=distNode(mLog, new NodeVol());
			} catch (WrongGetMethod e) {
				System.out.println("Некорректное получение параметра при вызове BillServ.distNode()");
			} catch (EmptyServ e) {
				System.out.println("Пустая услуга при рекурсивном вызове BillServ.distNode()");
			}
			//System.out.println("Объём в итоге="+dummy.getVol()+" по типу="+calc.getCalcTp());
			long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			//System.out.println("по дате="+Calc.getGenDt()+" потрачено="+totalTime);
			
			break;
		}
		
	}
	
	/**
	 * Распределить узел, следуя по графу (рекурсивная процедура)
	 * @param mLog
	 * @param nv
	 * @return
	 * @throws WrongGetMethod*/
	
	
	private NodeVol distNode (MeterLog mLog, NodeVol nv) throws WrongGetMethod, EmptyServ {
		//Double tmpD=0.0; //для каких нить нужд
		Double partArea =0.0; //текущая доля площади, по узлу
		Double partPers =0.0; //текущая доля кол-ва прожив, по узлу
		Double vl =0.0; //текущая доля объема, по узлу
		//получить лицевой счет, к которому привязан счетчик, для убоства
		Kart kart = mLog.getKart(); 
		if (nv.getRecur() > 1000) {
			throw new WrongGetMethod("При расчете счетчика MeterLog.Id="+mLog.getId()+" , обнаружен замкнутый цикл");
		}
		nv.addRecur();
		//System.out.println("Номер итерации:"+nv.getRecur());
		/*System.out.println("Счетчик:id="+mLog.getId()+" тип="+mLog.getTp().getCd()+" наименование:"+mLog.getName()+" klsk_obj="+mLog.getKlskObj());
		if (mLog.getKart()!=null) {
			System.out.println("KLSK Лиц счет счетчика="+mLog.getKart().getKlsk());
			System.out.println("Лиц счет счетчика="+mLog.getKart().getLsk());
		}*/

		String mLogTp = mLog.getTp().getCd(); //тип лог счетчика
		Serv servChrg = mLog.getServ().getChrg(); //получить услугу для начисления
		if (servChrg == null) {
			throw new EmptyServ("При расчете счетчика MeterLog.Id="+mLog.getId()+" , обнаружена пустая услуга для расчета начисления");
		}
		if (calc.getCalcTp()==0) {
			if (mLog.getId()==3685454) {
				System.out.println("Лиц счет счетчика="+mLog.getKart().getLsk());
			}
			
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
				vl = calc.getKartMng().getStandart(mLog, calc, null).partVol;
				nv.addVol(vl);
			}
				
		} if (calc.getCalcTp()==1 && kart != null) {
			//по связи по площади и кол.прож. (только по Лиц.счёту) в доле 1 дня
			//площадь
			partArea = calc.getKartMng().getDbl(kart.getDw(), "Площадь.Общая") / calc.getCntCurDays(); 
			nv.addPartArea(partArea);
			//проживающие
			CntPers cntPers= new CntPers(kart.getReg(), kart.getRegState());
			calc.getKartMng().getCntPers(servChrg, cntPers, 0);
			partPers = cntPers.cnt / calc.getCntCurDays();
			nv.addPartPers(partPers);

		} if (calc.getCalcTp()==2 && mLogTp.equals("Лсчетчик")) {
			//по расчетной связи ОДН (только у лог.счетчиков, при наличии расчетной связи ОДН)
			//получить дельту ОДН, площадь, кол-во людей, для расчета пропорции в последствии
			//сохранить счетчик ЛОДН
			LinkedNodeVol lnkODNVol = null;
			MeterLog lnkLODN = null;
			MeterLog lnkSumODPU = null;
			MeterLog lnkODPU = null;
			//поиск счетчика ЛОДН
			try {
				lnkLODN = calc.getMetLogMng().getLinkedNode(mLog, "ЛОДН");
		        //System.out.println("Счетчик ЛОДН id="+lnkLODN.getId());
			} catch (NotFoundNode e) {
				// не найден счетчик
		        System.out.println("Не найден счетчик ЛОДН, связанный со счетчиком id="+mLog.getId());
				e.printStackTrace();
				return null;
			}
			//поиск счетчика ЛСумОдпу
			try {
				lnkSumODPU = calc.getMetLogMng().getLinkedNode(lnkLODN, "ЛСумОДПУ");
		        //System.out.println("Счетчик ЛСумОДПУ id="+lnkSumODPU.getId());
			} catch (NotFoundNode e) {
				// не найден счетчик
		        System.out.println("Не найден счетчик ЛСумОДПУ, связанный со счетчиком id="+lnkLODN.getId());
				e.printStackTrace();
				return null;
			}
			//поиск счетчика Ф/Л ОДПУ
			try {
				lnkODPU = calc.getMetLogMng().getLinkedNode(lnkSumODPU, "ЛОДПУ");
		        //System.out.println("Счетчик ЛОДПУ id="+lnkODPU.getId());
			} catch (NotFoundNode e) {
				// не найден счетчик
		        System.out.println("Не найден счетчик ЛОДПУ, связанный со счетчиком id="+lnkSumODPU.getId());
				e.printStackTrace();
				return null;
			}

			//получить объем за период по счетчику ЛОДН  
			lnkODNVol = calc.getMetLogMng().getVolPeriod(lnkLODN);

			//проживающие
			CntPers cntPers= new CntPers(kart.getReg(), kart.getRegState());
			calc.getKartMng().getCntPers(servChrg, cntPers, 0);
			
			//TODO пока на этом остановился
			
			
		} if (calc.getCalcTp()==3 && mLogTp.equals("Лсчетчик")) {
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
			Vol vol = new Vol(mLog, volTp, vl, null, calc.getGenDt(), calc.getGenDt());
			//em.merge(vol);
		} if (calc.getCalcTp()==1) {
			//связь подсчета площади, кол-во проживающих, сохранять, если только в тестовом режиме TODO!!!
			volTp = calc.getLstMng().findByCD("Площадь и проживающие");
			Vol vol = new Vol(mLog, volTp, partArea, partPers, calc.getGenDt(), calc.getGenDt());
			//em.merge(vol);
		}
		
		
		//счетчик рекурсии на -1
		nv.decRecur();
		return nv;
	}
}
