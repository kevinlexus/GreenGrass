package com.direct.webflow;

import java.util.List;

import org.hibernate.Session;


public class SprGenItmDao {

  private Session sess;
  private boolean selfSess; //собственная ли сессия
	
  //конструктор с переданной сессией
  public SprGenItmDao(Session sess) {
    this.sess=sess;
    selfSess=false;
    }


  //конструктор с собственной сессией
  public SprGenItmDao() {
	this.sess =new DSess().openSess();
    selfSess=true;
	}

public List<SprGenItm> findAll() {

	if (selfSess) {//открыть сессию, если сказано
		this.sess =new DSess().openSess();
	}; 
	@SuppressWarnings("unchecked")
	List<SprGenItm> result = (List<SprGenItm>) sess.createQuery("select t from SprGenItm t").list();
	if (selfSess) {this.sess.close();}; //закрыть сессию, если сказано

	return result;
}

public List<SprGenItm> findAllChecked() {

	if (selfSess) {//открыть сессию, если сказано
		this.sess =new DSess().openSess();
	}; 
	@SuppressWarnings("unchecked")
	List<SprGenItm> result = (List<SprGenItm>) sess.createQuery("select t from SprGenItm t where t.sel=1").list();
	if (selfSess) {this.sess.close();}; //закрыть сессию, если сказано

	return result;
}

}
