package com.ric.bill.mm.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ric.bill.Calc;
import com.ric.bill.CntPers;
import com.ric.bill.Standart;
import com.ric.bill.Utl;
import com.ric.bill.dao.KartDAO;
import com.ric.bill.mm.KartMng;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.mt.MeterLog;
import com.ric.bill.model.ps.Pers;
import com.ric.bill.model.ps.Registrable;

@Service
public class KartMngImpl extends MeterStore implements KartMng {

	@Autowired
	private KartDAO kDao;

	/**
	 * Проверить, считали ли персону
	 */
	private boolean foundPers (Set<Pers> counted, Pers p) {
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
	 * Проверить наличие проживающего по постоянной регистрации или по временному присутствию
	 */
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="billCache")
	private boolean checkPersStatus (Set<Registrable> reg, Pers p, String status) {
		Date dt1, dt2;
		for (Registrable r : reg) {
			//проверять только у тех, где pers (fk_pers) заполнено!
			if (r.getPers()!=null && r.getPers().equals(p)) {
				if (r.getTp().getCd().equals(status)) {
					if (r.getDtRegTs() == null ||
					    r.getDtRegTs().before(Calc.getCurDt2())) {
						dt1=Utl.nvl(r.getDtReg(), Calc.getFirstDt());
					} else {
						dt1=Calc.getLastDt();
					}
					
					if (r.getDtUnRegTs() == null ||
						r.getDtUnRegTs().before(Calc.getCurDt2())) {
						dt2=Utl.nvl(r.getDtUnReg(), Calc.getLastDt());
					} else {
						dt2=Calc.getLastDt();
					}
					if (Utl.between(Calc.getGenDt(), dt1, dt2)) {
						//наличие статуса подтвердилось
						return true;
					}
						
				}
			}
		}
		//статус отсутствует
		return false;
	}
	
	/**
	 * Проверить наличие проживающего при fk_pers = null
	 */
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="billCache")
	private boolean checkPersNullStatus (Registrable reg) {
		//проверить статус, даты
		Date dt1, dt2;
		if (reg.getTp().getCd().equals("Временное присутствие")) {
			if (reg.getDtRegTs() == null ||
					reg.getDtRegTs().before(Calc.getCurDt2())) {
				dt1=Utl.nvl(reg.getDtReg(), Calc.getFirstDt());
			} else {
				dt1=Calc.getLastDt();
			}
			
			if (reg.getDtUnRegTs() == null ||
					reg.getDtUnRegTs().before(Calc.getCurDt2())) {
				dt2=Utl.nvl(reg.getDtUnReg(), Calc.getLastDt());
			} else {
				dt2=Calc.getLastDt();
			}
			if (Utl.between(Calc.getGenDt(), dt1, dt2)) {
				//наличие статуса подтвердилось
				return true;
			}
		}
				
		//статус отсутствует
		return false;
	}

	/**
	 * Получить кол-во проживающих 
	 * @param serv - Рассчитываемая услуга 
	 * @param reg - Список дат постоянной регистрации
	 * @param regSt - Список дат временной регистрации
	 * @param tp - Тип вызова (0-для получения нормативного объема, 1-для получения кол-во прож.)
	 * @return
	 */
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="billCache")
	public void getCntPers(Serv serv, CntPers cntPers, int tp){
		Set<Pers> counted = new HashSet<Pers>();
		cntPers.cnt=0; //кол-во человек
		cntPers.cntEmpt=0; //кол-во чел. для анализа пустая ли квартира
		//поиск сперва по постоянной регистрации 
		for (Registrable p : cntPers.reg) {
			if (p.getPers()!=null && !foundPers(counted, p.getPers())) {
				if (checkPersStatus(cntPers.reg, p.getPers(), "Постоянная прописка")) {
					//постоянная регистрация есть, проверить временное отсутствие, если надо по этой услуге
					if (!serv.getInclAbsn()) {
						if (!checkPersStatus(cntPers.regSt, p.getPers(), "Временное отсутствие")) {
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
					if (checkPersStatus(cntPers.reg, p.getPers(), "Временная прописка")) {
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
		for (Registrable p : cntPers.regSt) {
			//там где NULL fk_pers,- обычно временно зарег., считать их
			if (p.getPers()==null) {
				if (tp==0 && checkPersNullStatus(p)){
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
	 */
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="billCache")
	public Standart getStandart (MeterLog mLog, Calc calc, CntPers cntPers) {
		//long startTime;
		//long endTime;
		//long totalTime;
		//startTime   = System.currentTimeMillis();
		//получить услугу, по которой записывается норматив (в справочнике 
		//строго должна быть указана fk_stdt! по услуге счетчика)
		Serv serv = mLog.getServ().getStdrt(); 
		//получить услугу основную, для начисления
		Serv servChrg = mLog.getServ().getChrg();
		
		//System.out.println("===="+servChrg.getId());

		Standart st = new Standart();
		Kart kart = mLog.getKart();
		//System.out.println("==== kk"+kart.getKlsk());
		Double stVol = 0.0;
		if (cntPers == null) {
			//если кол-во проживающих не передано, получить его

			cntPers= new CntPers(kart.getReg(), kart.getRegState());
			getCntPers(serv, cntPers, 0); //tp=0 (для получения кол-во прож. для расчёта нормативного объема)
		}
		//System.out.println("===="+calc.getServMng().getDbl(servChrg.getDw(), "Вариант расчета по объему-1"));
		if (Utl.nvl(calc.getServMng().getDbl(servChrg.getDw(), "Вариант расчета по общей площади-1"), 0.0)==1
				|| Utl.nvl(calc.getServMng().getDbl(serv.getDw(), "Вариант расчета по объему-2"), 0.0)==1) {
			if (cntPers.cnt==1) {
				stVol = calc.getKartMng().getServPropByCD(kart.getTarklsk(), serv, "Норматив-1 чел.");
			} else if (cntPers.cnt==2) {
				stVol = calc.getKartMng().getServPropByCD(kart.getTarklsk(), serv, "Норматив-2 чел.");
			} else if (cntPers.cnt >= 3) {
				stVol = calc.getKartMng().getServPropByCD(kart.getTarklsk(), serv, "Норматив-3 и более чел.");
			} else {
				stVol = 0.0;
			}
			
		} else if (Utl.nvl(calc.getServMng().getDbl(servChrg.getDw(), "Вариант расчета по объему-1"),0.0)==1
				&& !servChrg.getCd().equals("Электроснабжение (объем)")) {
			//попытаться получить норматив, не зависящий от кол-ва прожив (например по х.в., г.в.)
			stVol = calc.getKartMng().getServPropByCD(kart.getTarklsk(), serv, "Норматив");
		} else if (Utl.nvl(calc.getServMng().getDbl(servChrg.getDw(), "Вариант расчета по объему-1"),0.0)==1
				&& servChrg.getCd().equals("Электроснабжение (объем)")) {
			Double kitchElStv = 0.0;
			String s2;
			kitchElStv = calc.getKartMng().getDbl(kart.getDw(), "Электроплита. основное количество");
			if (Utl.nvl(kitchElStv, 0.0) != 0) {
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
			stVol = calc.getKartMng().getServPropByCD(kart.getTarklsk(), serv, s2);
			
		}
			
		st.vol = stVol;
		
		//st.partVol = stVol * cntPers.cnt / calc.getCntCurDays();  TODO Вернуть!  
		st.partVol=0.0;
		//endTime   = System.currentTimeMillis();
		//totalTime = endTime - startTime;
		//if (mLog.getId()==3683348) {
		//	System.out.println("Standart: Date="+Calc.getGenDt()+" MeterLog.Id="+mLog.getId()+" cntPers-1 calc time="+totalTime);
		//}
		return st;
		
	}


}