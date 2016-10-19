package com.ric.pp.mm;

import com.ric.pp.model.Proj;

public interface ProjMng {
	
	public void addProj(Proj proj);
	public Proj getProjByOuterId(Integer id);
	
}
