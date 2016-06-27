package com.ric.bill;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ric.bill.excp.EmptyServ;
import com.ric.bill.excp.NotFoundNode;
import com.ric.bill.excp.NotFoundODNLimit;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.KartMng;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.MeterLogMng;
import com.ric.bill.mm.ParMng;
import com.ric.bill.mm.ServMng;
import com.ric.bill.mm.VolMng;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.mt.MLogs;
import com.ric.bill.model.mt.Meter;
import com.ric.bill.model.mt.MeterExs;
import com.ric.bill.model.mt.MeterLog;
import com.ric.bill.model.mt.MeterLogGraph;
import com.ric.bill.model.mt.Vol;


@Service
public class DistGen {

	@Autowired
	private Calc calc;
	@Autowired
	private MeterLogMng metMng;
	@Autowired
	private KartMng kartMng;
	@Autowired
	private ParMng parMng;
	@Autowired
	private LstMng lstMng;
	@Autowired
	private ServMng servMng;
	@Autowired
	private HouseMng houseMng;
	@Autowired
	private VolMng volMng;
	
	/**
	 * Распределить узел, следуя по графу (рекурсивная процедура)
	 * @param ml - вх.узел
	 * @param tp - тип распределения
	 * @param genDt - дата формирования
	 * @return
	 * @throws WrongGetMethod
	 * @throws EmptyServ
	 * @throws NotFoundODNLimit
	 * @throws NotFoundNode
	 */
	//ВНИМАНИЕ! Пришлось вынести в отдельный сервис (не хотел кэш включаться на private методе!!!):
	//http://stackoverflow.com/questions/18185209/spring-cacheable-doesnt-cache-public-methods
	@Cacheable(cacheNames="readOnlyCache", key="{ #ml.getId(), #tp, #genDt }") // - всё равно, плохо кэшируется!  
	public NodeVol distNode (MLogs ml, int tp, Date genDt) throws WrongGetMethod, EmptyServ, NotFoundODNLimit, NotFoundNode {
		
		NodeVol nv = calc.findLstCheck(ml.getId(), tp, genDt); 
		//если рассчитанный узел найден, вернуть готовый объем
		if (nv != null) { 
			return nv; 
		}
		
		Double partArea =0d; //текущая доля площади, по узлу
		Double partPers =0d; //текущая доля кол-ва прожив, по узлу
		Double vl =0d; //текущая доля объема, по узлу
		//занулить текущие, расчетные объемы
		nv = new NodeVol();
		//получить лицевой счет, к которому привязан счетчик, для убоства
		Kart kart = ml.getKart();
		calc.setKart(kart); 

		if (ml.getId()==3661161/* && tp==0*/) {
			Calc.mess("stop");
		}
		
		/*if (rec > 1000) {
			throw new WrongGetMethod("При расчете счетчика MeterLog.Id="+ml.getId()+" , обнаружен замкнутый цикл");
		}
		rec++;*/
		if (!ml.getTp().getCd().equals("ЛИПУ") && !ml.getTp().getCd().equals("ЛНрм")) {
			Calc.mess("Счетчик:id="+ml.getId()+" тип="+ml.getTp().getCd()+" наименование:"+ml.getName());
		}

		String mLogTp = ml.getTp().getCd(); //тип лог счетчика
		Serv servChrg = ml.getServ().getChrg(); //получить основную услугу, для начисления
		if (servChrg == null) {
			throw new EmptyServ("При расчете счетчика MeterLog.Id="+ml.getId()+" , обнаружена пустая услуга для расчета начисления");
		}

		if (tp==0 && ml.getId()==3661161) {
			Calc.mess("Счетчик:id="+ml.getId()+" тип="+ml.getTp().getCd()+" наименование:"+ml.getName());
			Calc.mess("стоп");
		}
		
		
		if (tp==0) {
			//по расчетной связи
			if (mLogTp.equals("ЛИПУ") || mLogTp.equals("ЛОДПУ") || mLogTp.equals("ЛГрупп")) {
				//посчитать объемы, по физическим счетчикам, прикрепленным к узлу
			    //(если такие есть) в пропорции на кол-во дней объема
				for (Meter m : ml.getMeter()) { 		//физ.сч
					for (Vol v : m.getVol()) {    		//фактические объемы
						if (v.getTp().getCd().equals("Фактический объем")) {
							for (MeterExs e : m.getExs()) { //периоды сущ.
								//добавить объем в объект объема
								//умножить объем на процент существования и на долю дня
								if (Utl.between(genDt, e.getDt1(), e.getDt2())) {
									vl=v.getVol1() * e.getPrc() / calc.getCntCurDays();
								}
							}
						}
					}
				}
			} else if (mLogTp.equals("ЛНрм")){
				//по нормативу
				//Calc.mess("before:");
				vl = kartMng.getStandart(ml, null, genDt).partVol;
			}
				
		} else if (tp==1 && kart != null) {
			//по связи по площади и кол.прож. (только по Лиц.счёту) в доле 1 дня
			//площадь
			partArea = Utl.nvl(parMng.getDbl(kart, "Площадь.Общая", genDt), 0d) / calc.getCntCurDays(); 
			//проживающие
			CntPers cntPers= new CntPers();
			kartMng.getCntPers(kart, servChrg, cntPers, 0, genDt);
			partPers = cntPers.cnt / calc.getCntCurDays();

		} else if (tp==2 && mLogTp.equals("Лсчетчик")) {
			//по расчетной связи ОДН (только у лог.счетчиков, при наличии расчетной связи ОДН)
			//получить дельту ОДН, площадь, кол-во людей, для расчета пропорции в последствии
			//сохранить счетчик ЛОДН
			SumNodeVol lnkODNVol = null;
			MLogs lnkLODN = null;
			MLogs lnkSumODPU = null;
			MLogs lnkODPU = null;
			//поиск счетчика ЛОДН
			lnkLODN = metMng.getLinkedNode(ml, "ЛОДН", genDt);
			//параметр Доначисление по ОДН
			Double parAddODN = Utl.nvl(parMng.getDbl((Storable)lnkLODN, "Доначисление по ОДН", genDt), 0d);
			Double parLimitODN = parMng.getDbl((Storable)lnkLODN, "Лимит по ОДН", genDt);
			
			if (lnkLODN == null) {
				// не найден счетчик
		        throw new NotFoundNode("Не найден счетчик ЛОДН, связанный со счетчиком id="+ml.getId());  
			}
			//поиск счетчика ЛСумОдпу
			lnkSumODPU = metMng.getLinkedNode(lnkLODN, "ЛСумОДПУ", genDt);
			if (lnkSumODPU == null) {
				// не найден счетчик
		        throw new NotFoundNode("Не найден счетчик ЛСумОДПУ, связанный со счетчиком id="+lnkLODN.getId());  
			}
			//поиск счетчика Ф/Л ОДПУ
			lnkODPU = metMng.getLinkedNode(lnkSumODPU, "ЛОДПУ", genDt);
			if (lnkODPU == null) {
				// не найден счетчик (лог.счетчик должен быть обязательно, а физ.сч. к нему привязанных, может и не быть!)
		        throw new NotFoundNode("Не найден счетчик ЛОДПУ, связанный со счетчиком id="+lnkSumODPU.getId());  
			}
			SumNodeVol lnkODPUVol = metMng.getVolPeriod(lnkODPU);

			//получить объем за период по счетчику ЛОДН и наличие ОДПУ
	    	Calc.mess("check id="+lnkLODN.getId());
			lnkODNVol = metMng.getVolPeriod(lnkLODN);
			Calc.mess("объем по ЛОДН id="+lnkLODN.getId()+" vol="+lnkODNVol.getVol()+" pers="+lnkODNVol.getPers()+" area="+lnkODNVol.getArea());
			//получить проживающих и площадь за период по счетчику данного лиц.счета (основываясь на meter_vol)
			SumNodeVol sumVol = metMng.getVolPeriod(ml);
			
			if (metMng.checkExsMet(lnkODPU, genDt) && lnkODPUVol.getVol() >= 0d) {
				//при наличии счетчика(ков) ОДПУ и объема по нему
				if (lnkODNVol.getVol() > 0 && lnkODNVol.getArea() > 0) {
					//ПЕРЕРАСХОД
					vl = lnkODNVol.getVol() * sumVol.getArea() / lnkODNVol.getArea();
					//применить лимит по ОДН
					Double limitVol = lnkODNVol.getLimit();
					if (parLimitODN == null) {
						throw new NotFoundODNLimit("Не найден обязательный параметр - лимит по ОДН в счетчике="+lnkLODN.getId());
					} else if (parLimitODN == 1 && limitVol > 0) {
						//если больше лимита - ограничить лимит * площадь
						if (vl > limitVol * sumVol.getArea()) {
							vl = limitVol * sumVol.getArea();
						}
					}
				} else {
					//ЭКОНОМИЯ
					//экономия, но в пределах потреблённого по основной услуге объема. Внимание! в квартплате решили так не учитывать, а учитывать в контексте услуги ОДН!

					//получить основную услугу
					Serv mainServ = servMng.findMain(servChrg);
					//получить счетчик основной услуги
					MLogs mlMain = metMng.getFirstMetLogByServTp(kart, mainServ.getMet(), "ЛИПУ");
					Calc.mess("check main id="+mlMain.getId());
					//получить объем за период, по лог счетчику основной услуги
					SumNodeVol sumMainVol = metMng.getVolPeriod(mlMain);
					Calc.mess("check main vol ="+sumMainVol.getVol());

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
				
			} else if (parAddODN > 0d) {
				//если есть объем дораспределения ОДН на м2 - то использовать его
				vl = parAddODN * sumVol.getArea();
			} else {
				//не найден счётчик ОДПУ (должно начислиться по лимиту ОДН (Нормативу) * площадь л.с.)
				//или нет объема по ОДПУ
				Double limit = parLimitODN;
				if (limit == null) {
					throw new NotFoundODNLimit("Не найден обязательный параметр - лимит по ОДН в счетчике="+lnkLODN.getId());
				} else if (limit == 1) {
					//если больше лимита - ограничить лимит * площадь
					Double limitVol = lnkODNVol.getLimit();
					vl = limitVol * sumVol.getArea();
				}
			}
			
			
		} else if (tp==3 && mLogTp.equals("Лсчетчик")) {
			//по расчетной связи пропорц.площади (Отопление например)
			MLogs lnkLODN = null;
			//поиск счетчика ЛОДН
			lnkLODN = metMng.getLinkedNode(ml, "ЛОДН", genDt);
			//узнать наличие "Введено гкал." для расчета по значению, рассчитанному экономистом
			Double tmp =parMng.getDbl(lnkLODN, "VOL_SQ_MT", genDt);
			
		}
		
		//добавить собственные объемы
		nv.addPartArea(partArea);
		nv.addPartPers(partPers);
		nv.addVol(vl);

		
		if (ml.getId()==3661161/* && tp==0*/) {
			Calc.mess("stop");
		}
		
		//найти все направления, с необходимым типом, указывающие в точку из других узлов, получить их объемы
		//Calc.mess("Найдено входящих направлений ="+mLog.getDst().size());
		if (ml.getInside().size() > 0) {
			Calc.mess("{");
		}
		for (MeterLogGraph g : ml.getInside()) {
			//по соотв.периоду
			if (Utl.between(genDt, g.getDt1(), g.getDt2())) {
				if (tp==0 && g.getTp().getCd().equals("Расчетная связь") 
				 || tp==1 && g.getTp().getCd().equals("Связь по площади и кол-во прож.")
				 || tp==2 && g.getTp().getCd().equals("Расчетная связь ОДН")
				 || tp==3 && g.getTp().getCd().equals("Расчетная связь пропорц.площади")) {
						NodeVol nvChld = distNode(g.getSrc(), tp, genDt);
						//добавить объемы от дочерних узлов
						nv.addPartArea(nvChld.getPartArea());
						nv.addPartPers(nvChld.getPartPers());
						nv.addVol(nvChld.getVol() * g.getPrc());
				}
			}
		}
		if (ml.getInside().size() > 0) {
			Calc.mess("}");
		}
		
		if (ml.getId()==3625218 && tp==0) {
			Calc.mess("счетчик!");
			//Calc.mess("Лиц счет счетчика="+ml.getKart().getLsk());
		}

		Lst volTp=null;
		//записать объем или площадь или кол-во прож. в текущий узел (лог.счетчик)
		if ((tp==0 ||tp==2) && nv.getVol() != 0d) {
			//расчетная связь, расчетная связь ОДН
			volTp = lstMng.findByCD("Фактический объем");
			Vol vol = new Vol((MeterLog) ml, volTp, nv.getVol(), null, genDt, genDt);
			
			ml.getVol().add(vol);
			
			//if (ml.getId()==3670885 && !ml.getTp().getCd().equals("ЛИПУ") && !ml.getTp().getCd().equals("ЛНрм")) {
			if (ml.getId()==3670885) {
				Calc.mess("записан объем по счетчику id="+ml.getId()+" по типу tp="+tp+" по дате genDt="+genDt.toLocaleString()+" vol="+vol.getVol1(),2);
			}
		} if (tp==1 && (nv.getPartArea() != 0d || nv.getPartPers() !=0d) ) {
			//связь подсчета площади, кол-во проживающих, сохранять, если только в тестовом режиме TODO 
			volTp = lstMng.findByCD("Площадь и проживающие");
			Vol vol = new Vol((MeterLog) ml, volTp, nv.getPartArea(), nv.getPartPers(), genDt, genDt);

			ml.getVol().add(vol);
			
			if (ml.getId()==3625271 && !ml.getTp().getCd().equals("ЛИПУ") && !ml.getTp().getCd().equals("ЛНрм")) {
				Calc.mess("записана площадь по счетчику id="+ml.getId()+" area="+nv.getPartArea()+" pers="+nv.getPartPers());
			}
		}
		
		
		//добавить в список рассчитанных узлов
		calc.addLstCheck(ml.getId(), tp, genDt, nv);
		//счетчик рекурсии на -1
		//rec--;
		return nv;
	}
	
}

