package com.ric.finday.dao;

import java.util.List;

import com.ric.finday.model.scott.Kart;


public interface KartDAO {

	public List<Kart> getKart(String lsk);
	
}
