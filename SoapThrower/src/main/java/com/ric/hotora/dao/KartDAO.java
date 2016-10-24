package com.ric.hotora.dao;

import java.util.List;

import com.ric.hotora.model.scott.Kart;


public interface KartDAO {

	public List<Kart> getKart(String lsk);
	
}
