package com.direct.webflow;

import java.util.List;

import org.hibernate.Session;

public class SprGenItmDao {

	private Session sess;
	private boolean selfSess; // собственная ли сессия

	// конструктор с переданной сессией
	public SprGenItmDao(Session sess) {
		this.sess = sess;
		selfSess = false;
	}

	// конструктор без сессии, открыть её
	public SprGenItmDao() {
		this.sess = new DSess(true).sess;
		selfSess = true;
	}

	public List<SprGenItm> findAll() {

		@SuppressWarnings("unchecked")
		List<SprGenItm> result = (List<SprGenItm>) sess.createQuery(
				"select t from SprGenItm t order by t.npp2").list();
		if (selfSess) {
			this.sess.close();
		} // закрыть сессию, если надо

		return result;
	}

	public List<SprGenItm> findAllChecked() {

		@SuppressWarnings("unchecked")
		List<SprGenItm> result = (List<SprGenItm>) sess.createQuery(
				"select t from SprGenItm t where t.sel=1 order by t.npp")
				.list();
		if (selfSess) {
			this.sess.close();
		} // закрыть сессию, если надо
		return result;
	}

	// вернуть объект по cd
	public SprGenItm getByCd(String cd) {
		SprGenItm result = (SprGenItm) this.sess.bySimpleNaturalId(
				SprGenItm.class).load(cd);
		if (selfSess) {
			this.sess.close();
		} // закрыть сессию, если надо
		return result;
	}
}
