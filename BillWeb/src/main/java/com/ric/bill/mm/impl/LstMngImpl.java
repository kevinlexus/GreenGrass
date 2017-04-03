package com.ric.bill.mm.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.BillServ;
import com.ric.bill.dao.AddrTpDAO;
import com.ric.bill.dao.AreaDAO;
import com.ric.bill.dao.HouseDAO;
import com.ric.bill.dao.KoDAO;
import com.ric.bill.dao.LstDAO;
import com.ric.bill.dao.ServDAO;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.ServMng;
import com.ric.bill.model.ar.Area;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.ar.Kw;
import com.ric.bill.model.bs.AddrTp;
import com.ric.bill.model.bs.Dw;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.oralv.Ko;
import com.ric.bill.model.tr.Serv;

@Service
public class LstMngImpl implements LstMng {

	@Autowired
	private LstDAO lstDao;
	@Autowired
	private AreaDAO areaDao;
	@Autowired
	private AddrTpDAO addrTpDao;
	@Autowired
	private KoDAO koDao;

	@Cacheable("neverWipe") //здесь кэш работает очень эффективно!
	public /*synchronized*/ Lst getByCD(String cd) {
		return lstDao.getByCD(cd);
	}

	/*
	 * Получить список Lst по типу
	 * cdTp - тип списка
	 */
	public List<Lst> getByTp(String cdTp) {
		return lstDao.getByTp(cdTp);
	}

    /*
     * Получить все типы областей
     * 
     */
	public List<Area> getAreaAll() {
		return areaDao.getAll();
	}

	/**
	 * Получить список типа Ko по типу адреса и фильтру по наименованию
	 */
	public List<Ko> getKoByAddrTpFlt(Integer addrTp, String flt) {
		return koDao.getKoByAddrTpFlt(addrTp, flt);
	}
	
    /* Получить типы адресов
	 * @param tp - 0 - весь список, 1 - ограниченный основными типами
     */
	public List<AddrTp> getAddrTpByTp(Integer tp) {
		return addrTpDao.getByTp(tp);
	}


}