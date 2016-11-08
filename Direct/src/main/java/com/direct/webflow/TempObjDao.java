package com.direct.webflow;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;


public class TempObjDao {

  private Session sess;
  private boolean selfSess; //собственная ли сессия
	
  //конструктор с переданной сессией
  public TempObjDao(Session sess) {
    this.sess=sess;
    selfSess=false;
    }


  //конструктор с собственной сессией
  public TempObjDao() {
	this.sess =new DSess(true).sess;
    selfSess=true;
	}

public List<TempObj> findAll(int var) {
	final int varArr[]={var};
    sess.doWork(new Work() {
   	 public void execute(Connection connection) throws SQLException {
   		    CallableStatement call = connection.prepareCall("{ call scott.p_thread.prep_obj(?) }");
   		    call.setInt(1, varArr[0]);
   		    call.execute();
   		  }
    });
    
	@SuppressWarnings("unchecked")
	List<TempObj> result = (List<TempObj>) sess.createQuery("select t from TempObj t order by t.id").list();
	if (selfSess) {this.sess.close();}; //закрыть сессию, если надо

	return result;
}


}
