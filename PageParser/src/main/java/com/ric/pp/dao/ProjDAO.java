package com.ric.pp.dao;

import com.ric.pp.model.Proj;


public interface ProjDAO {

	public void addProj(Proj proj);
	public Proj getProjByOuterId(Integer id);
	
	
}
