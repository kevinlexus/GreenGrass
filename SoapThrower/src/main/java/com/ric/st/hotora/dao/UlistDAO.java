package com.ric.st.hotora.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.ric.st.hotora.model.exs.Ulist;
import com.ric.st.hotora.model.exs.UlistTp;


public interface UlistDAO {

	public List<UlistTp> getListTpByGrp(String grp);
	public List<Ulist> getListByGrpId(String grp, BigInteger id);
}
