package com.ric.bill.dao.impl;

import java.util.ArrayList;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ric.bill.Config;
import com.ric.bill.ResultSetKlsk;
import com.ric.bill.dao.KartDAO;
import com.ric.bill.model.ar.Kart;


@Repository
public class KartDAOImpl implements KartDAO {

    @Autowired
    private Config config;

    @PersistenceContext
    private EntityManager em;
    
    static final String STATEMENT_SQLMAP = "Statement-SQL-Mapping2";

    //конструктор
    public KartDAOImpl() {
    	
    }
    
	public List<Kart> findAll(Integer houseId) {
		@SqlResultSetMapping(name= STATEMENT_SQLMAP, classes = { //эту часть кода можно закинуть в любое место
		        @ConstructorResult(targetClass = ResultSetKlsk.class,
		            columns = {
		                @ColumnResult(name="lsk",type = Integer.class)
		            }
		        )
		    }) @Entity class SQLMappingCfgEntity{@Id String lsk;} // <- walkaround


		Query q;
		List<Kart> lstKart = null;
		try {
			if (houseId == null) {
				// весь фонд
				q = em.createNativeQuery("select distinct k.lsk "+
						   "from ar.house h, ar.kart k, ar.kw kw, bs.org o, bs.org u  "+
						   "where k.fk_kw = kw.id "+
						   "and h.id = kw.fk_house "+
//						   "and o.reu in ('Z4', 'F4', 'J4', 'G4') /*'D8'*/ "+
						   "and o.parent_id=u.id /*and h.id=7468*/ "+
						   "and k.fk_uk = u.id "+
						   "and ? between k.dt1 and k.dt2 "+
						   //"and k.lsk between 276500 and 276535 "+
						   //"and k.flsk between '36010100' and '36010106' "+
						   "order by k.lsk ",  STATEMENT_SQLMAP);
				q.setParameter(1, config.getCurDt1(), TemporalType.DATE);
			} else {
				q = em.createNativeQuery("select distinct k.lsk "+
						   "from ar.house h, ar.kart k, ar.kw kw, bs.org o, bs.org u  "+
						   "where k.fk_kw = kw.id "+
						   "and h.id = kw.fk_house "+
//						   "and o.reu in ('Z4', 'F4', 'J4', 'G4') /*'D8'*/ "+
						   "and o.parent_id=u.id /*and h.id=1744*/ "+
						   "and k.fk_uk = u.id "+
						   "and ? between k.dt1 and k.dt2 "+
						   "and h.id = ? "+
						   //"and k.lsk between 276500 and 276535 "+
						   //"and k.flsk between '36010100' and '36010106' "+
						   "order by k.lsk ",  STATEMENT_SQLMAP);
				q.setParameter(1, config.getCurDt1(), TemporalType.DATE);
				q.setParameter(2, houseId);
			}
			
			
			List<ResultSetKlsk> lst = q.getResultList();
			lstKart = new ArrayList<Kart>();
			for (ResultSetKlsk rs: lst) {
				lstKart.add(em.find(Kart.class, rs.getLsk()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lstKart;
		
	}
    
    
}
