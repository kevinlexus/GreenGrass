package com.ric.bill.mm.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.Dist;
import com.ric.bill.dao.HouseDAO;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.model.Dw;
import com.ric.bill.model.House;
import com.ric.bill.model.Kw;
import com.ric.bill.model.Lsk;

@Service
public class HouseMngImpl implements HouseMng {

	@Autowired
	private HouseDAO hDao;

	@Override
	@Transactional
	public List<House> findAll() {
		return hDao.findAll();
	}

	/**
	 * получить значение параметра типа Double объекта по CD свойства
	 */
	@Override
	public Double getDbl(Set<Dw> dw, String cd) throws WrongGetMethod {
		for (Dw d: dw) {
			//проверка, что соответствует CD и Number (NM), Единичное (SI)
			if (d.getPar().getCd().equals(cd)) {
				if (d.getPar().getTp().equals("NM")) {
					if (d.getPar().getDataTp().equals("SI")) {
						return d.getN1();
					} else {
						throw new WrongGetMethod("Не успешная попытка получить параметр "+cd+" не являющийся типом данного SI");
					}
				} else {
					throw new WrongGetMethod("Не успешная попытка получить параметр "+cd+" не являющийся типом NM");
				}
			}
		}
		return null;
	}

}