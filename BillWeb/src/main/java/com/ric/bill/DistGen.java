package com.ric.bill;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	
	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

	private List<Check> lstCheck;

	/**
	 * внутренний класс, для проверок расчета узлов
	 * @author lev
	 *
	 */
	private class Check {
		private int id; //ID объекта
		private int tp; //тип расчета
		private Date genDt; //дата расчета
		private NodeVol nodeVol;//рассчитанные объемы
		
		public Check(int id, int tp, Date genDt, NodeVol nodeVol) {
			setId(id);
			setTp(tp);
			setGenDt(genDt);
			setNodeVol(nodeVol);
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getTp() {
			return tp;
		}
		public void setTp(int tp) {
			this.tp = tp;
		}
		public Date getGenDt() {
			return genDt;
		}
		public void setGenDt(Date genDt) {
			this.genDt = genDt;
		}

		public NodeVol getNodeVol() {
			return nodeVol;
		}

		public void setNodeVol(NodeVol nodeVol) {
			this.nodeVol = nodeVol;
		}
		
	}
	
	/**
	 * конструктор
	 */
	public DistGen() {
		super();
		lstCheck = new ArrayList<Check>();
	}
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
	//@Cacheable(cacheNames="readOnlyCache", key="{ #ml.getId(), #tp, #genDt }") // - всё равно, плохо кэшируется!  
	public NodeVol distNode (MLogs ml, int tp, Date genDt) throws WrongGetMethod, EmptyServ, NotFoundODNLimit, NotFoundNode {
		
		NodeVol nv = findLstCheck(ml.getId(), tp, genDt); 
		//если рассчитанный узел найден, вернуть готовый объем
		if (nv != null) { 
			return nv; 
		}
		
		Double partArea =0d; //текущая доля площади, по узлу
		Double partPers =0d; //текущая доля кол-ва прожив, по узлу
		Double vl =0d; //текущая доля объема, по узлу
		//занулить текущие, расчетные объемы
		nv = new NodeVol();
		//получить лицевой счет, к которому привязан счетчик, для удобства
		Kart kart = ml.getKart();
		//Kart kart = metMng.getKart(ml); <--тормозит!

		if (!Calc.isHouseInit()) {
			calc.setHouse(kart.getKw().getHouse());
			Calc.setHouseInit(true);
		}
		calc.setKart(kart); 

		if (!ml.getTp().getCd().equals("ЛИПУ") && !ml.getTp().getCd().equals("ЛНрм")) {
			Calc.mess("Счетчик:id="+ml.getId()+" тип="+ml.getTp().getCd()+" наименование:"+ml.getName());
		}

		String mLogTp = ml.getTp().getCd(); //тип лог счетчика
		Serv servChrg = ml.getServ().getServChrg(); //получить основную услугу, для начисления
		if (servChrg == null) {
			throw new EmptyServ("При расчете счетчика MeterLog.Id="+ml.getId()+" , обнаружена пустая услуга для расчета начисления");
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
									vl=v.getVol1() * e.getPrc() / Calc.getCntCurDays();
								}
							}
						}
					}
				}
			} else if (mLogTp.equals("ЛНрм")){
				//по нормативу
				//Calc.mess("before:");
				vl = kartMng.getStandart(kart, ml.getServ(), null, genDt).partVol;
			}
				
		} else if (tp==1 && (mLogTp.equals("ЛНрм") || mLogTp.equals("ЛИПУ") || mLogTp.equals("Лсчетчик"))) {
			//по связи по площади и кол.прож. (только по Лнрм, ЛИПУ) в доле 1 дня
			//площадь
			partArea = Utl.nvl(parMng.getDbl(kart, "Площадь.Общая", genDt), 0d) / Calc.getCntCurDays(); 
			//проживающие
			CntPers cntPers= new CntPers();
			kartMng.getCntPers(kart, servChrg, cntPers, 0, genDt);
			partPers = cntPers.cnt / Calc.getCntCurDays();
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
			SumNodeVol lnkODPUVol = metMng.getVolPeriod(lnkODPU, tp, Calc.getCurDt1(), Calc.getCurDt2());

			//получить объем за период по счетчику ЛОДН и наличие ОДПУ
	    	Calc.mess("check id="+lnkLODN.getId());
			lnkODNVol = metMng.getVolPeriod(lnkLODN, tp, Calc.getCurDt1(), Calc.getCurDt2());
			Calc.mess("объем по ЛОДН id="+lnkLODN.getId()+" vol="+lnkODNVol.getVol()+" pers="+lnkODNVol.getPers()+" area="+lnkODNVol.getArea());
			//получить проживающих и площадь за период по счетчику данного лиц.счета (основываясь на meter_vol)
			SumNodeVol sumVol = metMng.getVolPeriod(ml, tp, Calc.getCurDt1(), Calc.getCurDt2());
			
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
					Calc.mess("check serv="+mainServ.getServMet().getId());
					double tmpVol=0d;
					SumNodeVol sumMainVol;
					List<MLogs> lstMain = metMng.getAllMetLogByServTp(kart, mainServ.getServMet(), null);
					for (MLogs mLog2 : lstMain) {
						//получить объем за период, по лог счетчику основной услуги, если найден
						sumMainVol = metMng.getVolPeriod(mLog2, tp, Calc.getCurDt1(), Calc.getCurDt2());
						tmpVol = tmpVol + sumMainVol.getVol();
					}
					
					//если есть проживающие по узлу ОДН
					if (lnkODNVol.getPers() > 0 ) {
						vl = lnkODNVol.getVol() * sumVol.getPers() / lnkODNVol.getPers();  
						//округлить до 4 знаков
						vl = (double)Math.round(vl * 10000d) / 10000d;
					}
					//ограничить экономию текущим потреблением по основному счетчику
					if (Math.abs(vl) > tmpVol) {
						vl = -1 * tmpVol;
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
			if (lnkLODN == null) {
				// не найден счетчик
		        throw new NotFoundNode("Не найден счетчик ЛОДН, связанный со счетчиком id="+ml.getId());  
			}
			//получить объем за период по счетчику ЛОДН и наличие ОДПУ
	    	Calc.mess("check id="+lnkLODN.getId());
			SumNodeVol lnkODNVol = metMng.getVolPeriod(lnkLODN, tp, genDt, genDt);
			//получить проживающих и площадь за период по счетчику данного лиц.счета (основываясь на meter_vol)
			SumNodeVol sumVol = metMng.getVolPeriod(ml, tp, genDt, genDt);
			//узнать наличие "Введено гкал." для расчета по значению, рассчитанному экономистом
			Double tmp =parMng.getDbl(lnkLODN, "VOL_SQ_MT", genDt);
			if (tmp != null) {
				//установлено значение "Введено гкал." 
				vl = tmp * sumVol.getArea();
			} else {
				//НЕ установлено значение "Введено гкал."
				vl = lnkODNVol.getVol() * sumVol.getArea() / lnkODNVol.getArea();
			}
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

		//после рекурсивного расчета дочерних узлов, и только по последней дате, выполнить расчет Лимита ОДН
		if (tp==1 && mLogTp.equals("ЛОДН") && genDt.getTime() == Calc.getCurDt2().getTime() /*genDt.equals(Calc.getCurDt2()*/) {
			//по связи по площади и кол.прож. и только по ЛОДН счетчику
			if (servChrg.getCd().equals("Холодная вода (объем)") || servChrg.getCd().equals("Горячая вода, подогрев")) {
				SumNodeVol lnkODNVol = null;
				//получить площадь и кол-во прожив по дому, за месяц  
				lnkODNVol = metMng.getVolPeriod(ml, tp, Calc.getCurDt1(), Calc.getCurDt2());
				//расчитать лимит кубов
				//если кол-во прожив. > 0
				if (lnkODNVol.getPers() > 0d) {
					double oplMan = lnkODNVol.getArea() /  lnkODNVol.getPers();   
					double lmtVol = calc.oplLiter(oplMan)/1000;
					//записать лимит ОДН
					Lst volTp = lstMng.getByCD("Лимит ОДН");
					Vol vol = new Vol((MeterLog) ml, volTp, lmtVol, null, Calc.getCurDt1(), Calc.getCurDt2());
					ml.getVol().add(vol);
				}
				
			} else if (servChrg.getCd().equals("Электроснабжение (объем)")) {
				
			}
		
		}
		
		Lst volTp=null;
		//записать объем или площадь или кол-во прож. в текущий узел (лог.счетчик)
		if ((tp==0||tp==2||tp==3) && nv.getVol() != 0d) {
			//расчетная связь, расчетная связь ОДН
			volTp = lstMng.getByCD("Фактический объем");
			Vol vol = new Vol((MeterLog) ml, volTp, nv.getVol(), null, genDt, genDt);
			
			ml.getVol().add(vol);
			
			//if (ml.getId()==3670885 && !ml.getTp().getCd().equals("ЛИПУ") && !ml.getTp().getCd().equals("ЛНрм")) {
			if (ml.getId()==3670885) {
				Calc.mess("записан объем по счетчику id="+ml.getId()+" по типу tp="+tp+" по дате genDt="+genDt.toLocaleString()+" vol="+vol.getVol1());
			}
		} if (tp==1 && (nv.getPartArea() != 0d || nv.getPartPers() !=0d) ) {
			//связь подсчета площади, кол-во проживающих, сохранять, если только в тестовом режиме TODO 
			volTp = lstMng.getByCD("Площадь и проживающие");
			Vol vol = new Vol((MeterLog) ml, volTp, nv.getPartArea(), nv.getPartPers(), genDt, genDt);

			ml.getVol().add(vol);
			
			if (ml.getId()==3625271 && !ml.getTp().getCd().equals("ЛИПУ") && !ml.getTp().getCd().equals("ЛНрм")) {
				Calc.mess("записана площадь по счетчику id="+ml.getId()+" area="+nv.getPartArea()+" pers="+nv.getPartPers());
			}
		}
		
		
		//добавить в список рассчитанных узлов
		addLstCheck(ml.getId(), tp, genDt, nv);
		//счетчик рекурсии на -1
		//rec--;
		return nv;
	}
	
	
	/**
	 * Поиск расчитанного объема заданного по ID объекта
	 * @param id - ID
	 * @param tp - тип расчета
	 * @param genDt - дата расчета
	 * @return - найденный объем
	 */
	@Cacheable(cacheNames="rrr1", key="{ #id, #tp, #genDt }")
	private NodeVol findLstCheck(int id, int tp, Date genDt) {
		for (Check c : lstCheck) {
			if (c.getId()==id && c.getTp()==tp && c.getGenDt().equals(genDt)) {
				/*if (id==3670885) {
				  Calc.mess("НАЙДЕНО ВХОЖДЕНИЕ id="+id+" tp="+tp+" genDt="+genDt.toLocaleString(), 2);
				}*/
				return c.getNodeVol();
			}
		}
		return null;
	}
	
	/**
	 * Добавление расчитанного объекта
	 * @param id - ID
	 * @param tp - тип расчета
	 * @param genDt - дата расчета
	 */
	private void addLstCheck(int id, int tp, Date genDt, NodeVol nodeVol) {
		  lstCheck.add(new Check(id, tp, genDt, nodeVol));
/*		  if (id==3670885) {
			  Calc.mess("Записано id="+id+" tp="+tp+" genDt="+genDt.toLocaleString(), 2);
		  }*/
	}

	/**
	 * Почистить коллекцию, содержащую расчитанные объемы
	 */
	public void clearLstChecks() {
		lstCheck.clear();
	}
	 
}

