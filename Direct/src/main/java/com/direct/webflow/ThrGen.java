package com.direct.webflow;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.exception.GenericJDBCException;
import org.hibernate.jdbc.Work;


//класс формирования объектов (домов например)
public class ThrGen extends Thread {
	private boolean stopped = false;
	private String name;
    private int var;//вариант формирования (1-начисление по дому, 2-...)
	private DSess ds;
	
	/**
	 * Формировать по дому
	 * @param house Дом
	 * 		  var Вариант
	 */
	private void GenObj(final int objId, int var) {
		try {
			switch (var) {
			case 1:{
				//вариант 1 - формирование начисления по дому
				ds.sess.doWork(new Work() {
		      	 public void execute(Connection connection) throws SQLException {
		      		    CallableStatement call = connection.prepareCall("{ ? = call scott.c_charges.gen_charges(?, ?, ?, ?, ?, ?) }");
		      		    call.registerOutParameter(1, Types.INTEGER);
		      		    call.setString(2, null);
		      		    call.setString(3, null);
		      		    call.setInt(4, objId); //id дома
		      		    call.setNull(5, Types.NUMERIC);
		      		    call.setInt(6, 1);// is commit?
		      		    call.setInt(7, 1);// sendmsg?
		      		    call.execute();
		      		  }
		      	 });
			break;
			}
			
			case 2:{
				//вариант 2 - распределить ОДН во вводах, где нет ОДПУ
				ds.sess.doWork(new Work() {
		      	 public void execute(Connection connection) throws SQLException {
		      		    CallableStatement call = connection.prepareCall("{ call scott.p_vvod.gen_dist_wo_vvod_usl(?) }");
		      		    call.setInt(1, objId); //id ввода
		      		    call.execute();
		      		  }
		      	 });
			break;
			}
			
			case 3:{
				//вариант 3 - распределить ОДН во вводах, где есть ОДПУ
				ds.sess.doWork(new Work() {
		      	 public void execute(Connection connection) throws SQLException {
		      		    CallableStatement call = connection.prepareCall("{ call scott.p_thread.gen_dist_odpu(?) }");
		      		    call.setInt(1, objId); //id ввода
		      		    call.execute();
		      		  }
		      	 });
			break;
			}
			
			}
		} catch (GenericJDBCException excp) {
			Throwable cause = excp.getCause();
			SrvThr.errChild=1; //признак ошибки в вызывающем классе (synchronize не нужен)
			SrvThr.errTextChild=cause.getMessage();
			System.out.println("Error while executing "+name+" thread, objId="+objId);
			System.out.println("ThrGen.doWork: "+cause.getMessage());
		} catch (HibernateException excp) {
			Throwable cause = excp.getCause();
			SrvThr.errChild=1; //признак ошибки в вызывающем классе (synchronize не нужен)
			SrvThr.errTextChild=cause.getMessage();
			System.out.println("Error while executing "+name+" thread, objId="+objId);
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
						switch (this.var){
						case 1:{
							//вариант 1 - формирование начисления по дому
							ds.beginTrans();
							GenObj(tobj.getId(), var);
							ds.commitOpenTrans();
							break;
						}
						case 2:{
							//вариант 2 - распределить ОДН во вводах, где нет ОДПУ
							ds.beginTrans();
							GenObj(tobj.getId(), var);
							ds.commitOpenTrans();
							break;
						}
						
						}
					}
				}
		ds.closeSess();
		System.out.println("Thread "+name+" exiting");
	}

}