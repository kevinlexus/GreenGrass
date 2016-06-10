package com.ric.bill.mm;

import java.util.Set;

import com.ric.bill.Storable;
import com.ric.bill.model.bs.Dw;

/**
 * Базовый интерфейс Менеджеров
 * @author lev
 *
 */
public interface StorableMng {

	public Double getDbl(Storable st, String cd);
	public String getStr(Storable st, String cd);

}
