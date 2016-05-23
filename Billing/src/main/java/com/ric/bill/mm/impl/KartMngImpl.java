package com.ric.bill.mm.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ric.bill.Calc;
import com.ric.bill.Utl;
import com.ric.bill.dao.KartDAO;
import com.ric.bill.mm.KartMng;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.ps.Pers;
import com.ric.bill.model.ps.Reg;
import com.ric.bill.model.ps.RegState;
import com.ric.bill.model.ps.Registrable;

@Service
public class KartMngImpl implements KartMng {

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
	private boolean checkPersStatus (Set<Registrable> reg, Pers p) {
		Date dt1, dt2;
		for (Registrable r : reg) {
			if (r.getPers().equals(p)) {
				if (r.getTp().getCd().equals("Постоянная прописка")) {
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
						//наличие подтвердилось
						return true;
					}
						
				}
			}
		}
		//персона отсутствует
		return false;
	}
	
	/**
	 * Получить кол-во проживающих 
	 * @param serv - Рассчитываемая услуга 
	 * @param reg - Список дат постоянной регистрации
	 * @param regSt - Список дат временной регистрации
	 * @return
	 */
	@Override
	public int getCntPers(Serv serv, Set<Registrable> reg, Set<Registrable> regSt){
		Set<Pers> counted = null;
		int cnt=0; //кол-во человек
		int cntEmpt=0; //кол-во чел. для анализа пустая ли квартира
		// поиск по постоянной регистрации 
		for (Registrable p : reg) {
			if (!foundPers(counted, p.getPers())) {
				if (checkPersStatus(reg, p.getPers())) {
					//постоянная регистрация есть, проверить временное отсутствие, если надо по этой услуге
					if (!serv.getInclAbsn()) {
						if (!checkPersStatus(regSt, p.getPers())) {
							//временного отсутствия нет, считать проживающего
							cnt++;
						}
					} else {
						//не проверять временное отсутствие, считать проживающего
						cnt++;
					}
					cntEmpt++;
				} else {
					//нет постоянной регистрации, поискать временную
					
				}
			}
			
		}
		
		return 0;
	}

}