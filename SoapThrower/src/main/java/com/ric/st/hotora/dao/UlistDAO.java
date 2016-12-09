package com.ric.st.hotora.dao;

import java.util.List;

import com.ric.st.hotora.model.exs.Ulist;
import com.ric.st.hotora.model.exs.UlistTp;


public interface UlistDAO {

	public List<UlistTp> getByGrp(String tp);
}
