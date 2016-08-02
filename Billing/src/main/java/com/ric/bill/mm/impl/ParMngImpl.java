package com.ric.bill.mm.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.Calc;
import com.ric.bill.Storable;
import com.ric.bill.Utl;
import com.ric.bill.dao.ParDAO;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.ParMng;
import com.ric.bill.model.bs.Dw;
import com.ric.bill.model.bs.Par;

@Service
public class ParMngImpl implements ParMng {

	@Autowired
	private ParDAO pDao;
	
	//получить параметр по его CD
	//@Cacheable(cacheNames="readOnlyCache", key="{ #cd }") - здесь не кэшируется, только в DAO
	public synchronized Par getByCD(String cd) {
		return pDao.getByCd(cd);
	}

	/**
	 * Узнать существует ли параметр по его CD
	 */
	@Cacheable(cacheNames="readOnlyCache", key="{ #cd }")
	public synchronized boolean isExByCd(String cd) {
		Par p = getByCD(cd);
		if (p != null) {
			return true;
		} else {
			return false;
		}
	}

	
	/**
	 * получить значение параметра типа Double объекта по CD свойства
	 * внимание! дату важно передавать, а не получать из Calc.getGenDt(), так как она влияет на кэш!
	 */
	//В кэшах не почувствовал разницы:
	@Cacheable(cacheNames="specialCache1", key="{ #st.getKlsk(), #cd, #genDt }")
	public synchronized Double getDbl(Storable st, String cd, Date genDt) {
		Par par = getByCD(cd);
		try {
			for (Dw d: st.getDw()) {
    			//по соотв.периоду
    			if (Utl.between(genDt, d.getDt1(), d.getDt2())) {
					//проверка, что соответствует CD и Number (NM), Единичное (SI) - убрал - тормозит
    				/*if (checkPar(d.getFkHfp(), cd, "SI")) {
						return d.getN1();
    				}*/
    				//if (d.getPar().getCd().equals(cd)) {
       				if (d.getPar().equals(par)) {
						if (d.getPar().getTp().equals("NM")) {
							if (d.getPar().getDataTp().equals("SI")) {
								return d.getN1();
							} else {
									throw new WrongGetMethod("Попытка получить параметр "+cd+" не являющийся типом данного SI завершилась ошибкой");
							}
						} else {
							throw new WrongGetMethod("Попытка получить параметр "+cd+" не являющийся типом NM завершилась ошибкой");
						}
					}
    			}
			}
			//если не найдено, то проверить, существует ли вообще этот параметр, в базе данных
			if (!isExByCd(cd)) {
				throw new WrongGetMethod("Параметр "+cd+" не существует в базе данных");
			};
		} catch (WrongGetMethod e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * получить значение параметра типа Double объекта по CD свойства, без указания даты
	 */
	@Cacheable(cacheNames="specialCache1", key="{ #st.getKlsk(), #cd }")
	public synchronized Double getDbl(Storable st, String cd) {
		Par par = getByCD(cd);
		try {
			for (Dw d: st.getDw()) {
				if (d.getPar().equals(par)) {
					if (d.getPar().getTp().equals("NM")) {
						if (d.getPar().getDataTp().equals("SI")) {
							return d.getN1();
						} else {
								throw new WrongGetMethod("Попытка получить параметр "+cd+" не являющийся типом данного SI завершилась ошибкой");
						}
					} else {
						throw new WrongGetMethod("Попытка получить параметр "+cd+" не являющийся типом NM завершилась ошибкой");
					}
				}
			}
			//если не найдено, то проверить, существует ли вообще этот параметр, в базе данных
			if (!isExByCd(cd)) {
				throw new WrongGetMethod("Параметр "+cd+" не существует в базе данных");
			};
		} catch (WrongGetMethod e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * получить значение параметра типа String объекта по CD свойства
	 */
	@Cacheable(cacheNames="specialCache1", key="{ #st.getKlsk(), #cd, #genDt }")
	public synchronized String getStr(Storable st, String cd, Date genDt) {
		Par par = getByCD(cd);
		try {
			for (Dw d: st.getDw()) {
    			//по соотв.периоду
    			if (Utl.between(genDt, d.getDt1(), d.getDt2())) {
					//проверка, что соответствует CD и Number (NM), Единичное (SI)
    				if (d.getPar().equals(par)) {
						if (d.getPar().getTp().equals("ST")) {
							if (d.getPar().getDataTp().equals("SI") || d.getPar().getDataTp().equals("CD")) {
								return d.getS1();
							} else {
									throw new WrongGetMethod("Попытка получить параметр "+cd+" не являющийся типом данного SI или CD завершилась ошибкой");
							}
						} else {
							throw new WrongGetMethod("Попытка получить параметр "+cd+" не являющийся типом ST завершилась ошибкой");
						}
					}
    			}
			}
			//если не найдено, то проверить, существует ли вообще этот параметр, в базе данных
			if (!isExByCd(cd)) {
				throw new WrongGetMethod("Параметр "+cd+" не существует в базе данных");
			};
		} catch (WrongGetMethod e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * получить значение параметра типа String объекта по CD свойства, без указания даты
	 */
	@Cacheable("readOnlyCache")
	public synchronized String getStr(Storable st, String cd) {
		Par par = getByCD(cd);
		try {
			for (Dw d: st.getDw()) {
					//проверка, что соответствует CD и Number (NM), Единичное (SI)
				if (d.getPar().equals(par)) {
						if (d.getPar().getTp().equals("ST")) {
							if (d.getPar().getDataTp().equals("SI") || d.getPar().getDataTp().equals("CD")) {
								return d.getS1();
							} else {
									throw new WrongGetMethod("Попытка получить параметр "+cd+" не являющийся типом данного SI или CD завершилась ошибкой");
							}
						} else {
							throw new WrongGetMethod("Попытка получить параметр "+cd+" не являющийся типом ST завершилась ошибкой");
						}
    			}
			}
			//если не найдено, то проверить, существует ли вообще этот параметр, в базе данных
			if (!isExByCd(cd)) {
				throw new WrongGetMethod("Параметр "+cd+" не существует в базе данных");
			};
		} catch (WrongGetMethod e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}