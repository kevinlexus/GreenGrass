package com.ric.bill.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.annotations.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.ric.bill.dao.HouseDAO;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.ar.Kw;
import com.ric.bill.model.ps.Reg;


@Repository
public class HouseDAOImpl implements HouseDAO {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
	@PersistenceContext
	private EntityManager em;
	
	public void checkAll() {
		Session sess = (Session) em.getDelegate();
		Calc.mess("Check 1");
		Query query = sess.createQuery("select distinct t from House t left join fetch Kw k on t.id=k.fkHouse "
				+ "left join fetch Kart a on k.id=a.fkKw "
				+ "left join fetch Reg r on a.lsk=r.lsk "
				+ "left join fetch RegState s on a.lsk=s.lsk "
				+ " "
				+ "where t.klsk = 187804");
		Calc.mess("Check 2");
		List<House> lst =query.list(); 
		for (House o : lst) {
			Calc.mess("Check 3");
			for (Kw kw : o.getKw()) {
				for (Kart kart : kw.getLsk()) {
					for (Reg reg : kart.getReg()) {
						System.out.print("Reg="+reg.getDtReg());	
						break;
					}
					break;
				}
				break;
			}
			break;
		}
		Calc.mess("Check 4");
	}

	
	Check 1
	2393 [main] INFO  org.hibernate.hql.internal.QueryTranslatorFactoryInitiator  - HHH000397: Using ASTQueryTranslatorFactory
	Check 2
	2547 [main] DEBUG org.hibernate.SQL  - select distinct house0_.ID as ID1_1_, house0_.FK_K_LSK as FK_K_LSK2_1_, house0_.FK_STREET as FK_STREET3_1_ from AR.HOUSE house0_ left outer join AR.KW kw1_ on (house0_.ID=kw1_.FK_HOUSE)left outer join AR.KART kart2_ on (kw1_.ID=kart2_.FK_KW)left outer join PS.REG reg3_ on (kart2_.LSK=reg3_.LSK)left outer join PS.REG_STATE regstate4_ on (kart2_.LSK=regstate4_.LSK) where house0_.FK_K_LSK=187804
	Check 3
	2609 [main] DEBUG org.hibernate.SQL  - select kw0_.FK_HOUSE as FK_HOUSE3_3_0_, kw0_.ID as ID1_3_0_, kw0_.ID as ID1_3_1_, kw0_.FK_K_LSK as FK_K_LSK2_3_1_, kw0_.FK_HOUSE as FK_HOUSE3_3_1_ from AR.KW kw0_ where kw0_.FK_HOUSE=?
	2655 [main] DEBUG org.hibernate.SQL  - select kart0_.FK_KW as FK_KW4_2_0_, kart0_.LSK as LSK1_2_0_, kart0_.LSK as LSK1_2_1_, kart0_.FK_K_LSK as FK_K_LSK2_2_1_, kart0_.FIO as FIO3_2_1_, kart0_.FK_KW as FK_KW4_2_1_ from AR.KART kart0_ where kart0_.FK_KW=?
	2657 [main] DEBUG org.hibernate.SQL  - select reg0_.LSK as LSK6_15_0_, reg0_.ID as ID1_15_0_, reg0_.ID as ID1_15_1_, reg0_.DT_REG as DT_REG2_15_1_, reg0_.DT_REG_TS as DT_REG_TS3_15_1_, reg0_.DT_UNREG as DT_UNREG4_15_1_, reg0_.DT_UNREG_TS as DT_UNREG_TS5_15_1_, reg0_.LSK as LSK6_15_1_, reg0_.FK_PERS as FK_PERS7_15_1_, reg0_.FK_REG_STATUS as FK_REG_STATUS8_15_1_, reg0_.FK_REG_TP as FK_REG_TP9_15_1_ from PS.REG reg0_ where reg0_.LSK=?
	Reg=1996-03-12 00:00:00dCheck 4
	3382 [main] DEBUG org.hibernate.SQL  - select distinct house0_.ID as ID1_1_, house0_.FK_K_LSK as FK_K_LSK2_1_, house0_.FK_STREET as FK_STREET3_1_ from AR.HOUSE house0_ left outer join AR.KW kw1_ on (house0_.ID=kw1_.FK_HOUSE)left outer join AR.KART kart2_ on (kw1_.ID=kart2_.FK_KW)left outer join PS.REG reg3_ on (kart2_.LSK=reg3_.LSK)left outer join PS.REG_STATE regstate4_ on (kart2_.LSK=regstate4_.LSK) where house0_.FK_K_LSK=187804
	
}
