package com.direct.webflow;

import java.util.List;
import org.hibernate.Session;


public class PrepErrDao {

  private Session sess;
  private boolean selfSess; //собственная ли сессия
	
  //конструктор с переданной сессией
  public PrepErrDao(Session sess) {
    this.sess=sess;
    selfSess=false;
    }


  //конструктор с собственной сессией
  public PrepErrDao() {
	this.sess =new DSess(true).sess;
    selfSess=true;
	}

public List<PrepErr> findAll() {

	@SuppressWarnings("unchecked")
	List<PrepErr> result = (List<PrepErr>) sess.createQuery("select t from PrepErr t order by t.id").list();
	if (selfSess) {this.sess.close();}; //закрыть сессию, если надо

	return result;
}


}
