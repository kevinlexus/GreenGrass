package com.ric.bill.mm.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ric.bill.Utl;
import com.ric.bill.dao.HouseDAO;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.HouseSite;

@Service
public class HouseMngImpl implements HouseMng {


    @Autowired
	private HouseDAO hDao;

    public synchronized List<House> findAll() {
		return hDao.findAll();
	}

    public synchronized List<House> findAll2(Integer houseId, Integer areaId) {
		return hDao.findAll2(houseId, areaId);
	}

    /**
     * Получить Наименование УК по дому и дате
     */
    public String getUkNameByDt(House house, Date dt) {

    	Optional<HouseSite> site = house.getHouseSite().stream().filter(d -> Utl.between(dt, d.getDt1(), d.getDt2()))
		   .findFirst();
		if (site.isPresent()) {
			return site.get().getUk().getName();
		} else {
			return "";
		}
    }

}