package com.ric.bill.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ric.bill.dao.AreaDAO;
import com.ric.bill.dao.KlskDAO;
import com.ric.bill.dao.OrgDAO;
import com.ric.bill.model.ar.Area;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.fn.Payord;
import com.ric.bill.model.fn.PayordCmp;
import com.ric.bill.model.fn.PayordGrp;
import com.ric.bill.model.oralv.Klsk;
import com.ric.bill.model.tr.Serv;

/**
 * Построитель DTO объектов
 * @author lev
 *
 */
@Service
public class DTOBuilder {

	
@Autowired
AreaDAO areaDao;
@Autowired
OrgDAO orgDao;
@Autowired
KlskDAO klskDao;


/**
 * Построить коллекцию DTO платежек	
 * @param lst
 * @return
 */
public List<PayordDTO> getPayordDTOLst(List<Payord> lst) {
	List<PayordDTO> lst2 = new ArrayList<PayordDTO>(0);
	lst.stream().forEach(t-> lst2.add(
				new PayordDTO(t.getId(), t.getName(), (t.getPeriodTp()!=null) ? t.getPeriodTp().getId() : null, t.getSelDays(), t.getUsername(), t.getDtf(),
						t.getFormula(), t.getSumma()
						)
				));
	return lst2;
}

/**
 * Построить коллекцию DTO групп платежек	
 * @param lst
 * @return
 */
public List<PayordGrpDTO> getPayordGrpDTOLst(List<PayordGrp> lst) {
	List<PayordGrpDTO> lst2 = new ArrayList<PayordGrpDTO>(0);
	lst.stream().forEach(t-> lst2.add(
				new PayordGrpDTO(t.getId(), t.getName(), t.getUsername(), t.getDtf())
				));
	return lst2;
}

/**
 * Построить коллекцию DTO компонентов платежек	
 * @param lst
 * @return
 */
public List<PayordCmpDTO> getPayordCmpDTOLst(List<PayordCmp> lst) {
	List<PayordCmpDTO> lst2 = new ArrayList<PayordCmpDTO>(0);

	lst.stream().forEach(t-> lst2.add(
				new PayordCmpDTO(t.getId(), t.getUsername(), t.getDtf(), t.getPayord().getId(), t.getVar().getId(),
						(t.getServ()!=null ? t.getServ().getId() : null) , (t.getOrg()!=null ? t.getOrg().getId() : null), 
						(t.getArea()!=null ? t.getArea().getId() : null), (t.getKlskObj()!=null ? t.getKlskObj().getId() : null), 
						t.getMark(), t.getSumma())
				));
	return lst2;
}

/**
 * Построить коллекцию DTO списка (Lst)
 * @param lst
 * @return
 */
public List<LstDTO> getLstDTOLst(List<Lst> lst) {
	List<LstDTO> lst2 = new ArrayList<LstDTO>(0);
	lst.stream().forEach(t-> lst2.add(
				new LstDTO(t.getId(), t.getCd(), t.getName())
				));
	return lst2;
}

/**
 * Построить коллекцию DTO Организаций (Org)
 * @param lst
 * @return
 */
public List<KoDTO> getOrgDTOLst(List<Org> lst) {
	List<KoDTO> lst2 = new ArrayList<KoDTO>(0);
	lst.stream().forEach(t-> lst2.add(
				new KoDTO(t.getId(), t.getCd(), t.getName(), t.getKlsk().getAddrTp().getCd())
				));
	return lst2;
}
	
/**
 * Построить коллекцию DTO Услуг (Serv)
 * @param lst
 * @return
 */
public List<ServDTO> getServDTOLst(List<Serv> lst) {
	List<ServDTO> lst2 = new ArrayList<ServDTO>(0);
	lst.stream().forEach(t-> lst2.add(
				new ServDTO(t.getId(), t.getCd(), t.getName())
				));
	return lst2;
}

/**
 * Построить коллекцию DTO Областей (Area)
 * @param lst
 * @return
 */
public List<AreaDTO> getAreaDTOLst(List<Area> lst) {
	List<AreaDTO> lst2 = new ArrayList<AreaDTO>(0);
	lst.stream().forEach(t-> lst2.add(
				new AreaDTO(t.getId(), t.getCd(), t.getName())
				));
	return lst2;
}


/**
 * Получить объект типа Ko по klsk
 * @param klsk
 * @return
 */
public KoDTO getKoByKlsk(Integer klskId) {
	Klsk klsk = klskDao.getByKlsk(klskId);
	KoDTO ko = null;
	if (klsk != null && klsk.getAddrTp() != null) {
		String cd =klsk.getAddrTp().getCd();
		if (cd.equals("Area")) {

			Area area = areaDao.getByKlsk(klskId);
			ko = new KoDTO(klskId, area.getCd(), area.getName(), area.getKlsk().getAddrTp().getCd());
			
		} else if (cd.equals("Дом")) {
		//TODO
			
		} else if (cd.equals("Квартира")) {
			//TODO
			
		} else if (cd.equals("ЛС")) {
			//TODO

		} else if (cd.equals("Организация")) {
			Org org = orgDao.getByKlsk(klskId);
			ko = new KoDTO(klskId, org.getCd(), org.getName(), org.getKlsk().getAddrTp().getCd());		
		}
		
	}
	return ko;
	
}


}
