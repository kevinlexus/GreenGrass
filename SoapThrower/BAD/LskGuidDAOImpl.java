package com.ric.hotora.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ric.hotora.dao.KartDAO;
import com.ric.hotora.dao.LskGuidDAO;
import com.ric.hotora.model.fkv.LskGuid;
import com.ric.hotora.model.scott.Kart;



@Repository
public class LskGuidDAOImpl implements LskGuidDAO {

	@PersistenceContext
    private EntityManager em;
    
    //конструктор
    public LskGuidDAOImpl() {
    	
    }
    
    //вернуть лицевой счет
    public List<LskGuid> getLskGuid(String lsk) {
			Query query =em.createQuery("from LskGuid t where t.lsk = :s1");
			query.setParameter("s1", lsk);
			return query.getResultList();
	}
    
    
}
