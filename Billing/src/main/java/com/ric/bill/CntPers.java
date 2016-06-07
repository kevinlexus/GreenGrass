package com.ric.bill;

import java.util.HashSet;
import java.util.Set;

import com.ric.bill.model.ps.Reg;
import com.ric.bill.model.ps.RegState;
import com.ric.bill.model.ps.Registrable;

/**
 * Хранение кол-ва проживающих, записи о их регистрациях
 * @author lev
 *
 */
public class CntPers {
	
	public int cnt; //кол-во проживающих
	public int cntEmpt; //кол-во проживающих для анализа пустых квартир
	public Set<Registrable> reg; //постоянная регистрация 
	public Set<Registrable> regSt; //временная регистрация-отсутствие

	//конструктор
	@SuppressWarnings("unchecked")
	public CntPers(Set<? extends Registrable> rr1, Set<? extends Registrable> rr2) {
		this.reg=(Set<Registrable>) rr1;
		this.regSt=(Set<Registrable>) rr2;
	}
}
