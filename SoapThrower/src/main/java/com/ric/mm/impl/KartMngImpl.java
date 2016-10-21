package com.ric.mm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ric.finday.dao.KartDAO;
import com.ric.finday.model.scott.Kart;
import com.ric.mm.KartMng;

@Service
public class KartMngImpl implements KartMng {

	@Autowired
	private KartDAO kDao;

	public List<Kart> getKart(String lsk) {
		return kDao.getKart(lsk);
	}
	
	
}