package com.ric.bill.mm;

import java.util.Set;

import com.ric.bill.model.bs.Dw;

/**
 * Базовый интерфейс Менеджеров
 * @author lev
 *
 */
public interface Manage {

	public Double getDbl(Set<Dw> dw, String cd);
	public String getStr(Set<Dw> dw, String cd);

}
