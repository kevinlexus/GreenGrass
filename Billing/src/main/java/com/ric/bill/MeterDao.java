package com.ric.bill;

import java.util.List;

import org.hibernate.Session;


public class MeterDao {

	private Session sess;
	private boolean selfSess; // собственная ли сессия

	// конструктор с переданной сессией
	public MeterDao(Session sess) {
		this.sess = sess;
		selfSess = false;
	}

	// конструктор без сессии, открыть её
	public MeterDao() {
		this.sess = new DSess(true).sess;
		selfSess = true;
	}

	public List<Meter> findAll() {

		@SuppressWarnings("unchecked")
		List<Meter> result = (List<Meter>) sess.createQuery(
				"select t from Meter t order by t.npp2").list();
		if (selfSess) {
			this.sess.close();
		} // закрыть сессию, если надо

		return result;
	}
}
