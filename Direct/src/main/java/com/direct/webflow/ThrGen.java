package com.direct.webflow;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.exception.GenericJDBCException;
import org.hibernate.jdbc.Work;


//класс формирования объектов (домов например)
public class ThrGen extends Thread {
	private boolean stopped = false;
	private String name;
    private int var;//вариант формирования (0-дом, 1-...)
	private DSess ds;
	
	/**
	 * Формировать по дому
	 * @param house Дом
	 */
	private void GenHouse(final int house) {
		try {
		ds.sess.doWork(new Work() {
	      	 public void execute(Connection connection) throws SQLException {
	      		    CallableStatement call = connection.prepareCall("{ ? = call scott.c_charges.gen_charges(?, ?, ?, ?, ?, ?) }");
	      		    call.registerOutParameter(1, Types.INTEGER);
	      		    call.setString(2, null);
	      		    call.setString(3, null);
	      		    call.setInt(4, house); //id дома
	      		    call.setNull(5, Types.NUMERIC);
	      		    call.setInt(6, 1);// is commit?
	      		    call.setInt(7, 1);// sendmsg?
	      		    call.execute();
	      		  }
	       });
		} catch (GenericJDBCException excp) {
			Throwable cause = excp.getCause();
			SrvThr.errChild=1; //признак ошибки в вызывающем классе (synchronize не нужен)
			SrvThr.errTextChild=cause.getMessage();
			System.out.println("Error while executing "+name+" thread, house="+house);
			System.out.println("ThrGen.doWork: "+cause.getMessage());
		} catch (HibernateException excp) {
			Throwable cause = excp.getCause();
			SrvThr.errChild=1; //признак ошибки в вызывающем классе (synchronize не нужен)
			SrvThr.errTextChild=cause.getMessage();
			System.out.println("Error while executing "+name+" thread, house="+house);
			System.out.println("ThrGen.doWork: "+cause.getMessage());
		}
	}
	
	/**
	 * 	 * Формирует информацию по объекту
	 * @param name Наименование потока
	 * @param var Вариант формирования
	 */
	ThrGen(String name, int var) {
		ds=new DSess(true);
		stopped=false;
		this.name=name;
		this.var=var;
		System.out.println("Creating " + name);
	}

	public void run() {
				while ((SrvThr.errChild ==0) && (!stopped)) {
					TempObj tobj=ThrMain.getNextObj();
					
					if (tobj == null) {
						//если вернулся пустой объект - начать останавливаться, - обрабатывать нечего
						synchronized (this) {
							stopped=true;
						}
					} else {
						//формирование
						System.out.println(this.name+" working with:"+tobj.getId());
						if (this.var==0) {
							//вариант - формирование дома
							ds.beginTrans();
							GenHouse(tobj.getId());
							ds.commitOpenTrans();
						}
						
					}
				}
		ds.closeSess();
		System.out.println("Thread "+name+" exiting");
	}

}