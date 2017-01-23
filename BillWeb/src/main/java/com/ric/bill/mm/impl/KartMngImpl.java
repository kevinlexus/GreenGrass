package com.ric.bill.mm.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ric.bill.BillServ;
import com.ric.bill.Calc;
import com.ric.bill.CntPers;
import com.ric.bill.Config;
import com.ric.bill.RegContains;
import com.ric.bill.Standart;
import com.ric.bill.TarifContains;
import com.ric.bill.Utl;
import com.ric.bill.dao.KartDAO;
import com.ric.bill.excp.EmptyServ;
import com.ric.bill.excp.EmptyStorable;
import com.ric.bill.mm.KartMng;
import com.ric.bill.mm.ParMng;
import com.ric.bill.mm.TarifMng;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.ps.Pers;
import com.ric.bill.model.ps.Reg;
import com.ric.bill.model.ps.Registrable;
import com.ric.bill.model.tr.TarifKlsk;
import com.ric.bill.model.tr.TarifServProp;

@Service
@Slf4j
public class KartMngImpl implements KartMng {

	@Autowired
	private KartDAO kDao;
	@Autowired
	private BillServ billServ;
	@Autowired
	private ParMng parMng;
	@Autowired
	private TarifMng tarMng;
    @Autowired
    private Config config;

	//внутренний класс, состояние проживающего
	private class PersStatus {
		boolean exist;
		String kinShip;
		//конструктор
		public PersStatus (boolean exist, String kinShip) {
			this.exist = exist;
			this.kinShip = kinShip; 
		}
	}
	
	/**
	 * Проверить, считали ли персону
	 * нельзя кэшировать!
	 */
	private synchronized boolean foundPers (List<Pers> counted, Pers p) {
		if (counted.contains(p)) {
			//уже считали персону
			return true;
		} else {
			//добавить персону в массив
			counted.add(p);
			return false;
		}
	}
	
	/**
	 * Проверить наличие проживающего по постоянной регистрации или по временному присутствию на дату формирования! (на Calc.getGenDt())
	 */
	@Cacheable("rrr1")
	private /*synchronized */boolean checkPersStatus (int rqn, Calc calc, RegContains regc, Pers p, String status, int tp, Date genDt) {
		PersStatus ps = checkPersStatusExt(rqn, calc, regc, p, status, tp, genDt);
		return ps.exist;
	}

	
	/**
	 * Проверить наличие проживающего по постоянной регистрации или по временному присутствию на дату формирования! (на Calc.getGenDt())
	 * и вернуть объект, содержащий наличие проживающего и его отношение к нанимателю
	 */
	@Cacheable("rrr1")
	private /*synchronized */PersStatus checkPersStatusExt (int rqn, Calc calc, RegContains regc, Pers p, String status, int tp, Date genDt) {
		Date dt1, dt2;
		List<? extends Registrable> rg;
		if (tp==0) {
			rg = regc.getReg();
		} else {
			rg = regc.getRegState();
		}
		for (Registrable r : rg) {
			//проверять только у тех, где pers (fk_pers) заполнено!
			if (r.getPers()!=null && r.getPers().equals(p)) {
				if (r.getTp().getCd().equals(status)) {
					if (r.getDtRegTs() == null ||
					    r.getDtRegTs().before(calc.getReqConfig().getCurDt2())) {
						dt1=Utl.nvl(r.getDtReg(), config.getFirstDt());
					} else {
						dt1=config.getLastDt();
					}
					
					if (r.getDtUnRegTs() == null ||
						r.getDtUnRegTs().before(calc.getReqConfig().getCurDt2())) {
						dt2=Utl.nvl(r.getDtUnReg(), config.getLastDt());
					} else {
						dt2=config.getLastDt();
					}
					if (Utl.between(genDt, dt1, dt2)) {
						//наличие статуса подтвердилось,  - проживающий присутствует
						if (tp==0) {
							Reg reg = (Reg) r;
							return new PersStatus(true, reg.getKinship().getCd());
						} else {
							return new PersStatus(true, null);
						}
					}
				}
			}
		}
		//статус - проживающий отсутствует
		return new PersStatus(false, null);
	}
	
	/**
	 * Проверить наличие проживающего при fk_pers = null на дату формирования! (на Calc.getGenDt())
	 */
	@Cacheable("rrr1")
	private /*synchronized*/ boolean checkPersNullStatus (int rqn, Calc calc, Registrable reg, Date genDt) {
		//проверить статус, даты
		Date dt1, dt2;
		if (reg.getTp().getCd().equals("Временное присутствие")) {
			if (reg.getDtRegTs() == null ||
					reg.getDtRegTs().before(calc.getReqConfig().getCurDt2())) {
				dt1=Utl.nvl(reg.getDtReg(), config.getFirstDt());
			} else {
				dt1=config.getLastDt();
			}
			
			if (reg.getDtUnRegTs() == null ||
					reg.getDtUnRegTs().before(calc.getReqConfig().getCurDt2())) {
				dt2=Utl.nvl(reg.getDtUnReg(), config.getLastDt());
			} else {
				dt2=config.getLastDt();
			}
			if (Utl.between(genDt, dt1, dt2)) {
				//наличие статуса подтвердилось
				return true;
			}
		}
				
		//статус отсутствует
		return false;
	}

	/**
	 * Получить кол-во проживающих  на дату формирования! (на Calc.getGenDt())
	 * @param serv - Рассчитываемая услуга 
	 * @param rc - Список дат регистрации
	 * @param tp - Тип вызова (0-для получения нормативного объема, 1-для получения кол-во прож.)
	 * @param cntPers - объект для заполнения
	 * @return
	 */
//	@Cacheable("readOnlyCache")
	//@Cacheable("rrr1")
	@Cacheable(cacheNames="rrr1", key="{#rqn, #rc.getKlsk(), #serv.getId(), #cntPers, #tp, #genDt }") 
	//@Transactional
	public /*synchronized*/ void getCntPers(int rqn, Calc calc, RegContains rc, Serv serv, CntPers cntPers, int tp, Date genDt){
		List<Pers> counted = new ArrayList<Pers>();
		cntPers.cnt=0; //кол-во человек
		cntPers.cntEmpt=0; //кол-во чел. для анализа пустая ли квартира
		//поиск сперва по постоянной регистрации 
		for (Registrable p : rc.getReg()) {
			if (p.getPers()!=null && !foundPers(counted, p.getPers())) {
				if (checkPersStatus(rqn, calc, rc, p.getPers(), "Постоянная прописка", 0, genDt)) {
					//постоянная регистрация есть, проверить временное отсутствие, если надо по этой услуге
					if (!serv.getInclAbsn()) {
						if (!checkPersStatus(rqn, calc, rc, p.getPers(), "Временное отсутствие", 1, genDt)) {
							//временного отсутствия нет, считать проживающего
							cntPers.cnt++;
						}
					} else {
						//не проверять временное отсутствие, считать проживающего
						cntPers.cnt++;
					}
					cntPers.cntEmpt++;
				} else {
					//нет постоянной регистрации, поискать временную прописку
					if (checkPersStatus(rqn, calc, rc, p.getPers(), "Временная прописка", 0, genDt)) {
						//временное присутствие есть, считать проживающего
						if (serv.getInclPrsn()) {
							cntPers.cnt++;
						}
						cntPers.cntEmpt++;
					}
					
				}
			}
		}
		//поиск по временной регистрации 
		for (Registrable p : rc.getRegState()) {
			//там где NULL fk_pers,- обычно временно зарег., считать их
			if (p.getPers()==null) {
				if (tp==0 && checkPersNullStatus(rqn, calc, p, genDt)){
					if (serv.getInclPrsn()) {
						cntPers.cnt++;
					}
				}
			}		
		}
	}
	
	/**
	 * Получить нормативный объём по лиц.счету
	 * @param mLog - Расчетный узел 
	 * @param serv - Рассчитываемая услуга 
	 * @param cnt - Переданное кол-во проживающих
	 * @param calcCd - CD Варианта расчета начисления 
	 * @throws EmptyServ 
	 */
	@Cacheable(cacheNames="rrr4", key="{#rqn, #calc.getKart().getLsk(), #serv.getId(), #genDt }") // сделал отдельный кэш, иначе валится с Cannot Cast Standart to Boolean! 
	public /*synchronized*/ Standart getStandart (int rqn, Calc calc, Serv serv, CntPers cntPers, Date genDt) throws EmptyStorable {
		log.trace("STANDART1="+serv.getId()+" dt="+genDt);	
		//получить услугу основную, для начисления
		Serv servChrg = serv.getServChrg();
		//получить услугу, по которой записывается норматив (в справочнике 
		//строго должна быть указана fk_st_keep! по услуге счетчика)
		Serv servSt = serv.getServStKeep(); 
		Standart st = new Standart();

		Double stVol = 0d;
		if (cntPers == null) {
			//если кол-во проживающих не передано, получить его

			cntPers= new CntPers();
			log.trace("STANDART2="+serv.getId()+" dt="+genDt);	
			getCntPers(rqn, calc, calc.getKart(), servChrg, cntPers, 0, genDt); //tp=0 (для получения кол-во прож. для расчёта нормативного объема)
			log.trace("STANDART3="+serv.getId()+" dt="+genDt);	
		}
		//log.trace("===="+calc.getServMng().getDbl(servChrg.getDw(), "Вариант расчета по объему-1"));
		
		log.trace("STANDART4="+serv.getId()+" dt="+genDt);	
		log.trace("===="+Utl.nvl(parMng.getDbl(rqn, servChrg, "Вариант расчета по общей площади-1"), 0d));
		
		if (Utl.nvl(parMng.getDbl(rqn, servChrg, "Вариант расчета по общей площади-1"), 0d)==1d
				|| Utl.nvl(parMng.getDbl(rqn, servChrg, "Вариант расчета по объему-2"), 0d)==1d) {
			if (cntPers.cnt==1) {
				stVol = getServPropByCD(rqn, calc, servSt, "Норматив-1 чел.", genDt);
			} else if (cntPers.cnt==2) {
				stVol = getServPropByCD(rqn, calc, servSt, "Норматив-2 чел.", genDt);
			} else if (cntPers.cnt >= 3) {
				stVol = getServPropByCD(rqn, calc, servSt, "Норматив-3 и более чел.", genDt);
			} else {
				stVol = 0d;
			}
			
		} else if (Utl.nvl(parMng.getDbl(rqn, servChrg, "Вариант расчета по объему-1"),0d)==1d
				&& !servChrg.getCd().equals("Электроснабжение")) {
			//попытаться получить норматив, не зависящий от кол-ва прожив (например по х.в., г.в.)
			stVol = getServPropByCD(rqn, calc, servSt, "Норматив", genDt);
		} else if (Utl.nvl(parMng.getDbl(rqn, servChrg, "Вариант расчета по объему-1"),0d)==1d
				&& servChrg.getCd().equals("Электроснабжение")) {
			Double kitchElStv = 0d;
			String s2;
			kitchElStv = parMng.getDbl(rqn, calc.getKart(), "Электроплита. основное количество", genDt);
			if (Utl.nvl(kitchElStv, 0d) != 0d) {
				//с эл.плитой
				switch (cntPers.cnt) {
					case 0 : 
						s2 = null;
						break;
					case 1 : 
						s2 = "Норматив-1 чел. с эл. плитой";
						break;
					case 2 : 
						s2 = "Норматив-2 чел. с эл. плитой";
						break;
					case 3 : 
						s2 = "Норматив-3 чел. с эл. плитой";
						break;
					case 4 : 
						s2 = "Норматив-4 чел. с эл. плитой";
						break;
					case 5 : 
						s2 = "Норматив-5 чел. с эл. плитой";
						break;
					default : 
						s2 = "Норматив-6 и более чел. с эл. плитой";
						break;
				}
			} else {
				//без эл.плиты
				switch (cntPers.cnt) {
				case 0 : 
					s2 = null;
					break;
				case 1 : 
					s2 = "Норматив-1 чел. без эл. плиты";
					break;
				case 2 : 
					s2 = "Норматив-2 чел. без эл. плиты";
					break;
				case 3 : 
					s2 = "Норматив-3 чел. без эл. плиты";
					break;
				case 4 : 
					s2 = "Норматив-4 чел. без эл. плиты";
					break;
				case 5 : 
					s2 = "Норматив-5 чел. без эл. плиты";
					break;
				default : 
					s2 = "Норматив-6 и более чел. без эл. плиты";
					break;
			}
			}
			//получить норматив, зависящий от проживающих
			stVol = getServPropByCD(rqn, calc, servSt, s2, genDt);
			
		}
		if (stVol!=null) {	
			st.vol = stVol;
			st.partVol=cntPers.cnt * stVol/calc.getReqConfig().getCntCurDays();
		} else {
			st.vol = 0d;
			st.partVol= 0d;
		}
		log.trace("STANDART_END="+serv.getId()+" dt="+genDt);	
		return st;
		
	}


	/**
	 * Получить текущую УК, к которой сейчас привязан лиц.счет через lskxorg
	 * @param kart - лиц.счет
	 * @param genDt - дата выборки
	 */
/*	public synchronized Org getUk(Kart kart, Date genDt) {
		for (Lskxorg lxo: kart.getLskxorg()) {
			if (Utl.between(genDt, lxo.getDt1(), lxo.getDt2())) {
				if (lxo.getUk() == null) {
					log.trace("CHEEEEEEEEEEEEK Lsk="+lxo.getLsk(), 2);
				}
				return lxo.getUk();
			}			
		}
		return null;
	}*/
	
	
	/**
	 * Найти значение свойства типа Double услуги (по лиц.счету!)
	 * @param Kart - Лиц.счет
	 * @param serv -Услуга
	 * @param cd - CD свойства
	 * @param genDt - Дата выборки
	 * @return
	 */
	//@Cacheable("rrr1")
	@Cacheable(cacheNames="rrr1", key="{#rqn, #calc.getKart().getLsk(), #serv.getId(), #cd, #genDt }") 
	public /*synchronized*/ Double getServPropByCD(int rqn, Calc calc, Serv serv, String cd, Date genDt) { //убрал synchronized, получил - java.util.concurrent.ExecutionException: org.hibernate.exception.GenericJDBCException: could not initialize a collection
		Double val;
		//в начале ищем по дому
		val=tarMng.getProp(rqn, calc.getHouse(), serv, cd, genDt);
		if (val==null) {
			//потом ищем по лиц. счету 
			val=tarMng.getProp(rqn, calc.getKart(), serv, cd, genDt);
		}
		if (val==null) {
			//потом ищем по городу
			val=tarMng.getProp(rqn, calc.getArea(), serv, cd, genDt);
		}
		return val;
	}

	/**
	 * Найти обслуживающую организацию по услуге (по лиц.счету!)
	 * @param Kart - Лиц.счет
	 * @param serv -Услуга
	 * @param genDt - Дата выборки
	 * @return
	 */
	//@Cacheable(cacheNames="rrr1") 
	@Cacheable(cacheNames="rrr3", key="{#rqn, #calc.getKart().getLsk(), #serv.getId(), #genDt }") 
	public /*synchronized*/ Org getOrg(int rqn, Calc calc, Serv serv, Date genDt) {
		Org org;
		//в начале ищем по дому
		org=tarMng.getOrg(rqn, calc.getHouse(), serv, genDt);
		if (org==null) {
			//потом ищем по лиц. счету 
			org=tarMng.getOrg(rqn, calc.getKart(), serv, genDt);
		}
		if (org==null) {
			//потом ищем по городу
			org=tarMng.getOrg(rqn, calc.getArea(), serv, genDt);
		}
		return org;
	}
	
	/**
	 * Найти наличие услуги (по лиц.счету!)
	 * @param Kart - Лиц.счет
	 * @param serv -Услуга
	 * @param genDt - Дата выборки
	 * @return
	 */
	//@Cacheable("rrr1")
	@Cacheable(cacheNames="rrr1", key="{#rqn, #calc.getKart().getLsk(), #serv.getId(), #genDt }") 
	public /*synchronized*/ boolean getServ(int rqn, Calc calc, Serv serv, Date genDt) {
		boolean exs = false;
		//искать свойство "Поставщик"
		Double n1 = getServPropByCD(rqn, calc, serv, "Поставщик", genDt);
		if (n1 != null) {
			exs = true;
		}	
		return exs;
	}
	
	/**
	 * Создать список услуг, по параметру
	 * @param tc -тарифосодержащий объект
	 * @param lst -список услуг
	 * @param cd - параметр, который проверять
	 * @param cmd - добавлять ли услугу в список(0) или удалять(1)?
	 * @return - обновленный список услуг
	 */
    public /*synchronized*/ List<Serv> checkServ(Calc calc, TarifContains tc, List lst, String cd, int cmd) {

    	/* JAVA 8 */
    	tc.getTarifklsk().stream().forEach(t -> {
    		t.getTarprop().stream()
    			.filter(d -> d.getServ().getServChrg() != null && d.getServ().getServChrg().equals(d.getServ()))
    			.filter(d -> Utl.between2(calc.getReqConfig().getCurDt1(), calc.getReqConfig().getCurDt2(), d.getDt1(), d.getDt2()))
    			.filter(d -> d.getProp().getCd().equals(cd))
    			.forEach(d -> {
					//найдено свойство cd в этом периоде, добавить или удалить из списка услуг
					switch (cmd) {
						case 0 :
							//добавить элемент, если еще не добавлен
							if (!lst.contains(d.getServ())) {
								lst.add(d.getServ());
							}
						break;
						case 1 :
							//удалить элемент, если существует
							if (lst.contains(d.getServ())) {
								lst.remove(d.getServ());
							}
						
						break;
					}
					});
    	});
    	
    	/*for (TarifKlsk k : tc.getTarifklsk()) {
				//затем по строкам - составляющим тариф 
				for (TarifServProp t : k.getTarprop()) {
					if (t.getServ().getServChrg() != null && t.getServ().getServChrg().equals(t.getServ())) {
						//искать наличие свойства, например, "Поставщик", оно и определяет наличие услуги
						if (Utl.between2(calc.getReqConfig().getCurDt1(), calc.getReqConfig().getCurDt2(), t.getDt1(), t.getDt2())) {
							if (t.getProp().getCd().equals(cd)) {
									//найдено свойство cd в этом периоде, добавить или удалить из списка услуг
									switch (cmd) {
										case 0 :
											//добавить элемент, если еще не добавлен
											if (!lst.contains(t.getServ())) {
												lst.add(t.getServ());
											}
										break;
										case 1 :
											//удалить элемент, если существует
											if (lst.contains(t.getServ())) {
												lst.remove(t.getServ());
											}
										
										break;
								}
							}
						}
					}
				}
			//}
		}*/
		return lst;
    }
	
	/**
	 * Получить distinct список всех услуг потенциально начисляемых в лиц.счете в данном периоде
	 * @param tc - объект
	 * @return
	 * @throws EmptyServ 
	 */
	//@Cacheable("rrr1")
	//@Cacheable(cacheNames="rrr1", key="{ #kart.getLsk() }") - НЕ КЭШИРОВАТЬ!!!
	@Cacheable(cacheNames="rrr1", key="{#rqn, #calc.getHouse().getId(), #calc.getKart().getLsk() }")
	public /*synchronized*/ List<Serv> getAllServ(int rqn, Calc calc) {
		List<Serv> lst = new ArrayList<Serv>();
		//искать и добавить по наборам тарифа
		//дома:
		lst = checkServ(calc, calc.getHouse(), lst, "Поставщик", 0);
		//лиц.счета
		lst = checkServ(calc, calc.getKart(), lst, "Поставщик", 0);

		//удалить отключенные услуги по наборам тарифа
		//дома:
		lst = checkServ(calc, calc.getHouse(), lst, "Отключение", 1);
		//лиц.счета
		lst = checkServ(calc, calc.getKart(), lst, "Отключение", 1);
		
		return lst;
	}

	/**
	 * Узнать наличие льготы по капремонту (>=70 лет, собственник, другие проживающие тоже >=70 лет)
	 * @param kart
	 * @param genDt
	 */
	@Cacheable("rrr1")
	public /*synchronized*/ double getCapPrivs(int rqn, Calc calc, RegContains rc, Date genDt) {
		boolean above70owner=false;
		boolean above70=false;
		boolean under70=false;
		List<Pers> counted = new ArrayList<Pers>();
		for (Registrable p : rc.getReg()) {
			Pers pers = p.getPers();
			//если дата рождения - пустая - считать сегодняшней датой
			Date dtBrn = Utl.nvl(pers.getDtBorn(), new Date());
			if (pers!=null && !foundPers(counted, pers)) {
				PersStatus ps = checkPersStatusExt(rqn, calc, rc, pers, "Постоянная прописка", 0, genDt);
				if (ps.exist) {
					//постоянная регистрация есть
					if (Utl.getDiffYears(dtBrn, genDt) >= 70) {
						//если 70 летний
						if (ps.kinShip.equals("Собственник") || ps.kinShip.equals("Наниматель")) {
							//да еще и Наниматель (Собственник)
							above70owner = true;
						} else {
							//но не Наниматель (Собственник)
							above70 = true;
						}
					} else {
						//если постоянно прож., но не 70 летний
						under70 = true;
					}
				} else {
					//нет постоянной регистрации, поискать временную прописку
					ps = checkPersStatusExt(rqn, calc, rc, pers, "Временная прописка", 0, genDt);
					if (ps.exist) {
						//временное присутствие есть
						if (Utl.getDiffYears(dtBrn, genDt) < 70) {
							//временно зарег <70 лет
							under70 = true;
						}						
					}
				}
			}
		}
		
		if (above70owner && !above70 && !under70) {
			return 0d; //льгота
		} else if (above70owner && above70 && !under70) {
			return 0d; //льгота
		} else {
			return 1d; //нет льготы
		}
	                
	}

	
	//все лицевые по определённому критерию
	public List<Kart> findAll(Integer houseId) {
		return kDao.findAll(houseId);
	}
}