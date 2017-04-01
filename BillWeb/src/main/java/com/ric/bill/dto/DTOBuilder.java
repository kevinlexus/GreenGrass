package com.ric.bill.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ric.bill.dao.AreaDAO;
import com.ric.bill.dao.KoDAO;
import com.ric.bill.dao.OrgDAO;
import com.ric.bill.dao.impl.KoDAOImpl;
import com.ric.bill.model.ar.Area;
import com.ric.bill.model.bs.AddrTp;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.fn.Payord;
import com.ric.bill.model.fn.PayordCmp;
import com.ric.bill.model.fn.PayordGrp;
import com.ric.bill.model.oralv.Ko;
import com.ric.bill.model.tr.Serv;

/**
 * Построитель DTO объектов
 * @author lev
 *
 */
@Slf4j
@Service
public class DTOBuilder {

	
@Autowired
AreaDAO areaDao;
@Autowired
OrgDAO orgDao;
@Autowired
KoDAO klskDao;


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
				new KoDTO(t.getId(), t.getCd(), t.getName(), t.getKo().getAddrTp().getCd())
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
 * Построить коллекцию DTO Объектов Ko
 * @param lst
 * @return
 */
public List<KoDTO> getKoDTOLst(List<Ko> lst) {
	List<KoDTO> lko = new ArrayList<KoDTO>(0);

	// Добавить РКЦ, ЖЭО, РЭУ
	List<KoDTO> lst2 = lst.stream().filter(t -> (t.getAddrTp().getCd().equals("РКЦ") || t.getAddrTp().getCd().equals("ЖЭО")
			 																	  	 || t.getAddrTp().getCd().equals("РЭУ")
			) )
		.map(t -> new KoDTO(t.getId(), t.getOrg().getCd(), t.getOrg().getName(), t.getAddrTp().getCd()) )
		.collect(Collectors.toList());
	lko.addAll(lst2);
	
	log.info("size={}", lst.size());
	//lst.stream().filter(t -> (t.getAddrTp().getCd().equals("Дом")))
			//.forEach(t-> log.info("Дом= id={}, house={}", t.getId(), t.getHouse() ));
	for (Ko k: lst) {
		log.info("id={}", k.getId());
		log.info("houseId={}", k.getHouse().getId());
		
	}
	
	
	// Добавить Дом
	lst2 = lst.stream().filter(t -> (t.getAddrTp().getCd().equals("Дом")
			) )
			.map(t -> new KoDTO(t.getId(), String.valueOf(t.getId()), 
										   t.getHouse().getStreet().getArea().getName()+", "+
												   t.getHouse().getStreet().getName()+", "+
												   t.getHouse().getNd(), 
										   t.getAddrTp().getCd()) )
			.collect(Collectors.toList());
	lko.addAll(lst2);
	return lko;
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
 * Построить коллекцию DTO Типов адресов (AddrTp)
 * @param lst
 * @return
 */
public List<AddrTpDTO> getAddrTpDTOLst(List<AddrTp> lst) {
	List<AddrTpDTO> lst2 = new ArrayList<AddrTpDTO>(0);
	lst.stream().forEach(t-> lst2.add(
				new AddrTpDTO(t.getId(), t.getCd(), t.getName())
				));
	return lst2;
}


/**
 * Получить объект типа Ko по klsk
 * @param klsk
 * @return
 */
public KoDTO getKoByKlsk(Integer klskId) {
	Ko klsk = klskDao.getByKlsk(klskId);
	KoDTO ko = null;
	if (klsk != null && klsk.getAddrTp() != null) {
		String cd =klsk.getAddrTp().getCd();
		if (cd.equals("Area")) {

			Area area = areaDao.getByKlsk(klskId);
			ko = new KoDTO(klskId, area.getCd(), area.getName(), area.getKo().getAddrTp().getCd());
			
		} else if (cd.equals("Дом")) {
		//TODO
			
		} else if (cd.equals("Квартира")) {
			//TODO
			
		} else if (cd.equals("ЛС")) {
			//TODO

		} else if (cd.equals("Организация")) {
			Org org = orgDao.getByKlsk(klskId);
			ko = new KoDTO(klskId, org.getCd(), org.getName(), org.getKo().getAddrTp().getCd());		
		}
		
	}
	return ko;
	
}


}
