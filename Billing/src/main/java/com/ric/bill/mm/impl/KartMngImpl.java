package com.ric.bill.mm.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ric.bill.Calc;
import com.ric.bill.CntPers;
import com.ric.bill.Standart;
import com.ric.bill.Utl;
import com.ric.bill.dao.KartDAO;
import com.ric.bill.mm.KartMng;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.ps.Pers;
import com.ric.bill.model.ps.Reg;
import com.ric.bill.model.ps.RegState;
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
	private boolean checkPersStatus (Set<Registrable> reg, Pers p, String status) {
		Date dt1, dt2;
		for (Registrable r : reg) {
			if (r.getPers().equals(p)) {
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
	private boolean checkPersNullStatus (Registrable reg) {
		//статус не проверяется, только даты, и только наличие записи
		Date dt1, dt2;
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
	@Override
	public void getCntPers(Serv serv, CntPers cntPers, int tp){
		Set<Pers> counted = null;
		cntPers.cnt=0; //кол-во человек
		cntPers.cntEmpt=0; //кол-во чел. для анализа пустая ли квартира
		//поиск по постоянной регистрации 
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
					//нет постоянной регистрации, поискать временную
					if (checkPersStatus(cntPers.regSt, p.getPers(), "Временное присутствие")) {
						//временное присутствие есть, считать проживающего
						if (serv.getInclPrsn()) {
							cntPers.cnt++;
						}
						cntPers.cntEmpt++;
					}
					
				}
			} else if (p.getPers()==null) {
				//там где NULL fk_pers,- обычно временно зарег., считать их
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
	 * @param serv - Рассчитываемая услуга 
	 * @param cnt - Переданное кол-во проживающих
	 * @param calcCd - CD Варианта расчета начисления 
	 */
	public Standart getStandart (Calc calc, Serv serv, CntPers cntPers) {
		Standart st = new Standart();
		if (cntPers == null) {
			//если кол-во проживающих не передано
			cntPers= new CntPers();
			getCntPers(serv, cntPers, 0); //tp=0 (для получения кол-во прож. для расчёта нормативного объема)
		}
		
		switch (calc.getServMng().getStr(serv.getDw(), "")) {
		case "Вариант расчета по общей площади-1" : case "Вариант расчета по объему-2" :
			break;
		
		}
		
		
		
		return st;
		
	}
	

}