package com.ric.bill;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.exception.GenericJDBCException;
import org.hibernate.jdbc.Work;

public class ExecProc {

	public int doWorkRet; 		  //Результат из doWork
	public String doWorkErrText; //Текста ошибки из doWork
	public SQLException doWorkExcpt; //Exeption из doWork
	
	Session sess; //объект сессии
	
	//класс, выполняющий вызовы процедур Oracle
	public ExecProc(Session sess) {
		this.sess=sess;
	}
	
	/**
	 * 
	 * @param var  вариант исполнения
	 * 		extPar дополнительный параметр
	 *            
	 * @return
	 */
	public int runWork(int var, int extPar, int extPar2) { //используется массив var[] так как doWork требует final переменную... так обманули
	doWorkRet =-1;
	final int varArr[]={var};
	final int extParArr[]={extPar};
	final int extParArr2[]={extPar2};
	try {	
		switch (varArr[0]) {
		case 1: {
			// Установить статус итогового формирования
			sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ ? = call fn.p_chrg.check_temp(?) }");
					call.registerOutParameter(1, Types.INTEGER);
					call.setInt(2, 1);
					call.execute();
					doWorkRet = call.getInt(1);
				}
			});
			break;
		}
		default: {
			doWorkErrText="doWork: не найдено вхождение case!";
			System.out.println("doWork: не найдено вхождение case!");
			doWorkRet=-1;
		}
		}
	
	} catch (GenericJDBCException excp) {
		Throwable cause = excp.getCause();
		doWorkRet=-1;//признак ошибки
		doWorkErrText=cause.getMessage();
		System.out.println("doWork: "+cause.getMessage());
		System.out.println("Error while executing doWork with var= "+var);
	} catch (HibernateException excp) {
		Throwable cause = excp.getCause();
		doWorkRet=-1;//признак ошибки
		if (cause!=null){
			doWorkErrText=cause.getMessage();
	        System.out.println("doWork: "+cause.getMessage());
			System.out.println("Error while executing doWork with var= "+var);
		} else {
			doWorkErrText=excp.getMessage();
	        System.out.println("Next doWork: "+excp.getMessage());
			System.out.println("Next Error while executing doWork with var= "+var);
			
		}
	} catch (Exception excp) {
		//прочие ошибки
		Throwable cause = excp.getCause();
		doWorkRet=-1;//признак ошибки
		doWorkErrText=cause.getMessage();
		System.out.println("doWork: "+cause.getMessage());
		System.out.println("Error while executing doWork with var= "+var);
	}
	return doWorkRet;
	
	}

}


