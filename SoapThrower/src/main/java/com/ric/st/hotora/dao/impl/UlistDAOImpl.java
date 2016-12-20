package com.ric.st.hotora.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ric.st.hotora.dao.UlistDAO;
import com.ric.st.hotora.model.exs.Ulist;
import com.ric.st.hotora.model.exs.UlistTp;



@Repository
public class UlistDAOImpl implements UlistDAO {

	@PersistenceContext
    private EntityManager em;

	//конструктор
    public UlistDAOImpl() {
    	
    }

    /*
     * Получить список заголовочных элементов справочников по группе
     * @param grp - группа справочника
     */
    public List<UlistTp> getListTpByGrp(String grp) {
		Query query =em.createQuery("select t from UlistTp t where t.grp=:grp");
		query.setParameter("grp", grp);
		return query.getResultList();
    }

    /* Получить список элементов справочника по группе и id
     * @param grp - группа справочника
     * @param id - Id справочника
     */
    public List<Ulist> getListByGrpId(String grp, BigInteger id) {
		Query query =em.createQuery("select t from Ulist t join t.ulistTp tp where tp.grp=:grp and tp.id=:id");
		query.setParameter("grp", grp);
		query.setParameter("id", id.intValue());
		return query.getResultList();
    }
}
