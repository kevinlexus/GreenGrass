package com.ric.bill.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.TemporalType;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ric.bill.BillServ;
import com.ric.bill.Calc;
import com.ric.bill.Config;
import com.ric.bill.Result;
import com.ric.bill.ResultSet;
import com.ric.bill.dao.HouseDAO;
import com.ric.bill.model.ar.House;



@Repository
@Slf4j
public class HouseDAOImpl implements HouseDAO {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private Config config;
    
    static final String STATEMENT_SQLMAP = "Statement-SQL-Mapping";
    
    //конструктор
    public HouseDAOImpl() {
    	
    }
	public List<House> findAll() {
		return em.createQuery("select t from House t "
				+ "where t.klsk in (-1)").getResultList(); //

	}

	public List<House> findAll2(Integer houseId) {
		@SqlResultSetMapping(name= STATEMENT_SQLMAP, classes = { //эту часть кода можно закинуть в любое место
		        @ConstructorResult(targetClass = ResultSet.class,
		            columns = {
		                @ColumnResult(name="id",type = Integer.class)
		            }
		        )
		    }) @Entity class SQLMappingCfgEntity{@Id int id;} // <- walkaround

		Query q;
		List<House> lstHouse = null;
		try {
			if (houseId == null) {
				// по всем домам
				q = em.createNativeQuery("select distinct h.id "+
						   "from ar.house h, ar.kart k, ar.kw kw, bs.org o, bs.org u  "+
						   "where k.fk_kw = kw.id "+
						   "and h.id = kw.fk_house "+
						   "and o.reu in ('Z4', 'F3', 'F4', 'J4', 'G4') "+
						   "and o.parent_id=u.id /*and h.id=7468*/  "+
						   "and k.fk_uk = u.id /*and h.id in (7309,7310)*/ /* and h.id in (162,163,968)*/ "+
						   "and ? between k.dt1 and k.dt2 "+
						   "order by h.id ",  STATEMENT_SQLMAP);
				q.setParameter(1, config.getCurDt1(), TemporalType.DATE);
			} else {
				//по одному дому
				q = em.createNativeQuery("select distinct h.id "+
						   "from ar.house h, ar.kart k, ar.kw kw, bs.org o, bs.org u  "+
						   "where k.fk_kw = kw.id "+
						   "and h.id = kw.fk_house "+
						   "and o.reu in ('Z4', 'F3', 'F4', 'J4', 'G4') "+
						   "and ? between k.dt1 and k.dt2 "+
						   "and o.parent_id=u.id and h.id=? "+
						   "and k.fk_uk = u.id /*and h.id in (7309,7310)*/ /* and h.id in (162,163,968)*/ "+
						   "order by h.id ",  STATEMENT_SQLMAP);
				q.setParameter(1, config.getCurDt1(), TemporalType.DATE);
				q.setParameter(2, houseId);
			}
			
			List<ResultSet> lst = q.getResultList();
			lstHouse = new ArrayList<House>();
			for (ResultSet rs: lst) {
				log.info("Found house id="+rs.getId(), 2);
				lstHouse.add(em.find(House.class, rs.getId()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lstHouse;
		
	}
}
