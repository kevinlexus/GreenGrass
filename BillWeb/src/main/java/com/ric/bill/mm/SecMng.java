package com.ric.bill.mm;

import java.util.List;

import com.ric.bill.model.bs.Org;
import com.ric.bill.model.sec.Vsec;


public interface SecMng  {

	public List<Vsec> getPrivByUserRoleAct(String userCd, String roleCd, String actCd);

	List<Org> getOrgCurUser(String roleCd, String actCd);
}