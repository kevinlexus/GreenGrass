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
	 * @param dbl1 
	 *            
	 * @return
	 */
	public int runWork(int var, int extPar1, int extPar2, int extPar3, int extPar4, int extPar5, Double dbl1) { //используется массив var[] так как doWork требует final переменную... так обманули
	doWorkRet =-1;
	final int varArr[]={var};
	final int extParArr1[]={extPar1};
	final int extParArr2[]={extPar2};
	final int extParArr3[]={extPar3};
	final int extParArr4[]={extPar4};
	final int extParArr5[]={extPar5};
	final double extParArr6[]={dbl1};

	//CallableStatement call = connection
	//		.prepareCall("{ ? = call fn.p_chrg.check_temp(?) }");

	try {	
		switch (varArr[0]) {
		case 1: {
			//Отправить 
			//sess.doWork(new Work() {
/*				public void execute(Connection connection) throws SQLException {
					//		.prepareCall("{ ? = call fn.p_chrg.check_temp(?) }");
					CallableStatement call = connection
							.prepareCall("{ call fn.transfer_change(?, ?, ?, ?, ?, ?, ?, ?) }");
					
					//call.registerOutParameter(1, Types.INTEGER);
					call.setInt(1, extPar1);
					call.setInt(2, extPar2);
					call.setInt(3, extPar3);
					call.execute(7,);*/

					/*.prepareCall("{ call fn.transfer_change(p_lsk => rec_klsk.lsk,1
				      p_fk_serv => c2.fk_serv,2
				      p_fk_org => c2.fk_org,3
				      p_period => to_char(l_dt1,'YYYYMM'),4
				      p_summa_chng => c2.summa,5
				      p_dtek => sysdate,6
				      p_tp_chng => 1,7
				      p_fk_chng => l_iter) 8;*/


					//doWorkRet = call.getInt(1);
				//}
			//});
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


