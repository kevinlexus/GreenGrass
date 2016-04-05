package com.direct.webflow;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.exception.GenericJDBCException;
import org.hibernate.jdbc.Work;

public class ThrMain extends Thread {
	SprGenItmDao sprgDao;
	List<SprGenItm> sprg;
	int doWorkRet; 		  //Результат из doWork
	String doWorkErrText; //Текста ошибки из doWork
	SQLException doWorkExcpt; //Exeption из doWork
	String name; //наименование потока
	
	public boolean stopped = false;
	DSess ds;

	// общий список объектов для выполнения потоками
	static List<TempObj> tobj;

	ThrMain() {
		name="ThrMain";
		System.out.println("Creating ThrMain!");
	}

	/**
	 * 
	 * @param var
	 *            -вариант исполнения
	 * @return
	 */
	private int execDoWork(int var) { //используется массив var[] так как doWork требует final переменную... так обманули
	doWorkRet =-1;
	final int varArr[]={var};
	try {	
		switch (varArr[0]) {
		case 1: {
			// Установить статус итогового формирования
			ds.sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ ? = call scott.utils.set_base_state_gen(?) }");
					call.registerOutParameter(1, Types.INTEGER);
					call.setInt(2, 1);
					call.execute();
					doWorkRet = call.getInt(1);
				}
			});
			break;
		}
		case 2: {
			// Снять статус итогового формирования
			ds.sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ ? = call scott.utils.set_base_state_gen(?) }");
					call.registerOutParameter(1, Types.INTEGER);
					call.setInt(2, 0);
					call.execute();
					doWorkRet = call.getInt(1);
				}
			});
			break;
		}
		case 3: {
			// Закрыть базу для пользователей
			//сперва проверить - надо ли закрывать
			ds.sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ ? = call scott.utils.get_int_param(?) }");
					call.registerOutParameter(1, Types.INTEGER);
					call.setString(2, "NEED_CLOSE_BASE");
					call.execute();
					doWorkRet = call.getInt(1); 
				}
			});
				if (doWorkRet==1) {
					//да, надо закрывать
					ds.sess.doWork(new Work() {
						public void execute(Connection connection) throws SQLException {
						//try
						//{
						CallableStatement call = connection
								.prepareCall("{ call scott.admin.set_state_base(?) }");
						call.setInt(1, 1);
						call.execute();
					}
					});
				} else
				{
					//не надо закрывать
					doWorkRet=0;
				}
			break;
		}
		case 4: case 5: case 6: case 7:{
			//проверка smpl_chck
			ds.sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ ? = call scott.p_thread.smpl_chk(?) }");
					call.registerOutParameter(1, Types.INTEGER);
					//перекодировать в gen.smpl_chck код выполнения
					switch (varArr[0]) {
					case 4:
						  call.setInt(2, 1);
						  break;
					case 5:
						  call.setInt(2, 2);
						  break;
					case 6:
						  call.setInt(2, 3);
						  break;
					case 7:
						  call.setInt(2, 4);
						  break;
					}
					  
					call.execute();
					doWorkRet = call.getInt(1); 
				}
			});
			break;
		}
			//основные проверки
		case 8: case 9: case 10: case 11: case 12: case 13: case 14: case 15:{
			ds.sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ call scott.gen.gen_check(?, ?, ?) }");
					call.registerOutParameter(1, Types.INTEGER);
					call.registerOutParameter(2, Types.VARCHAR);
					
					//перекодировать в gen.gen_check код выполнения
					switch (varArr[0]) {
					case 8:
						  call.setInt(3, 1);
						  break;
					case 9:
						  call.setInt(3, 2);
						  break;
					case 10:
						  call.setInt(3, 3);
						  break;
					case 11:
						  call.setInt(3, 4);
						  break;
					case 12:
						  call.setInt(3, 5);
						  break;
					case 13:
						  call.setInt(3, 6);
						  break;
					case 14:
						  call.setInt(3, 7);
						  break;
					case 15:
						  call.setInt(3, 8);
						  break;
					}
					
					call.execute();
					doWorkRet = call.getInt(1);
					doWorkErrText = call.getString(2);
				}
			});
			break;
			
		}
		
		
		}
		
	} catch (GenericJDBCException excp) {
		//SQLException cause = (SQLException) excp.getCause();
		//.SQLGrammarException
		Throwable cause = excp.getCause();
		doWorkRet=-1;//признак ошибки
		doWorkErrText=cause.getMessage();
		System.out.println("ThrMain.doWork: "+cause.getMessage());
		System.out.println("Error while executing doWork with var= "+var);
	} catch (HibernateException excp) {
		Throwable cause = excp.getCause();
		doWorkRet=-1;//признак ошибки
		if (cause!=null){
			doWorkErrText=cause.getMessage();
	        System.out.println("ThrMain.doWork: "+cause.getMessage());
			System.out.println("Error while executing doWork with var= "+var);
		} else {
			doWorkErrText=excp.getMessage();
	        System.out.println("Next ThrMain.doWork: "+excp.getMessage());
			System.out.println("Next Error while executing doWork with var= "+var);
			
		}
	}	
	return doWorkRet;

	}

	// вернуть следующий объект из списка
	static synchronized TempObj getNextObj() {
		TempObj retObj = null;
		for (TempObj itm : tobj) {
			retObj = itm;
			// удалить объект, как "отработанный"
			tobj.remove(itm);
			break;
		}
		return retObj; // вернуть или объект или null
	}

	// этот поток должен создать объект содержащий дома которые нужно
	// сформировать, потоки ThrGen должны "разбирать" у этого объекта дома для
	// формир.
	public void run() {
		ds = new DSess(true); // одна сессия на весь run()
		sprgDao = new SprGenItmDao(ds.sess);
		sprg = sprgDao.findAllChecked();

		// формировать
		gen();

		System.out.println("Thread ThrMain exiting.");
		ds.closeSess();
		stopped = true;
	}

	/**
	 * подготовка к закрытию формирования, снятие блокировки итогового
	 * @param menuGenItg
	 */
	private void closeGen(SprGenItm menuGenItg, int stateGen, int err, String ErrText) {
		int ret = execDoWork(2);// Снять блокировку после итогового формирования (можно снимать, даже если его не было)
		if (ret==-1) {
			System.out.println("ThrMain.closeGen: Ошибка во время разблокировки итогового формирования!");
		}
		
		System.out.println("ThrMain: "+ErrText);
		menuGenItg.setErr(err);
		menuGenItg.setState("ThrMain: "+ErrText);
		WebCtrl.stateGen=String.valueOf(stateGen);
		
		ds.commitTrans();
		ds.closeSess();
		
	}

	//вынес модуль проверки-1
	//проверка 4
	private boolean check(SprGenItm menuGenItg, int var){
		int ret = execDoWork(var);
		switch (ret) {
		case -1: {
			//Ошибка во время вызова
			closeGen(menuGenItg, 2, 1, "ThrMain: "+doWorkErrText);
			return true; // выходить с ошибкой
		}
		case 1: {
			closeGen(menuGenItg, 2, 2, "Найдены ошибки до итогового формирования");
			return true; // выходить с ошибкой
		}
		}
		return false; // выходить без ошибки
	}

	//вынес модуль проверки-2
	private boolean check2(SprGenItm menuGenItg, int var){
		//проверка gen_check-1
		int ret = execDoWork(var);
		switch (ret) {
		case -1: {
			//Ошибка во время вызова
			closeGen(menuGenItg, 2, 1, "ThrMain: "+doWorkErrText);
			return true; // выходить с ошибкой
		}
		case 1: {
			closeGen(menuGenItg, 2, 1, doWorkErrText);
			return true; // выходить с ошибкой
		}
		}
		
		return false; // выходить без ошибки
	}
	
	
	//*****************ФОРМИРОВАНИЕ
	private void gen() {
		int ret=-1;
		SprGenItm menuGenItg, menuMonthOver;
		menuGenItg = sprgDao.getByCd("GEN_ITG");
		menuMonthOver = sprgDao.getByCd("GEN_MONTH_OVER");

		//**********почистить ошибку последнего формирования
		ds.beginTrans();
		menuGenItg.setErr(0);
		//почистить % выполнения
		for (SprGenItm itm : sprg) {
			itm.setProc((double) 0);
			itm.setState(null);
		}
		ds.commitTrans();
		//**********
		
		//**********(Установить блокировку для итогового формирования)
		ds.beginTrans();
		if (menuGenItg.getSel()) {
			// выбрано итоговое формирование
			ret = execDoWork(1);// Установить блокировку
			if (ret == 1) {
				//формирование уже запущено
				closeGen(menuGenItg, 2, 1, "ThrMain: Формирование уже запущено!");
				return; // выходить
			} else if (ret==-1) {
				//Ошибка во время вызова
				closeGen(menuGenItg, 2, 1, "ThrMain: "+doWorkErrText);
				return; // выходить
			}
			// выполнить проверки
			System.out.println("ThrMain: Начало формир!");
			menuGenItg.setState("Выполняется");
			menuGenItg.setProc(0.1); //установить 10% выполнения
		}
		ds.commitTrans();
		//**********

		WebCtrl.stateGen="1"; //Выполняется формирование

		//**********Закрыть базу для пользователей
		ds.beginTrans();
		ret = execDoWork(3);
		if (ret==-1) {
			//Ошибка во время вызова
			closeGen(menuGenItg, 2, 1, "ThrMain: "+doWorkErrText);
			return; // выходить
		}
		System.out.println("ThrMain: Установлен признак закрытия базы!");
		ds.commitTrans();
		//**********

		//**********Проверки до формирования
		if (menuGenItg.getSel()) {
			// если выбрано итоговое формирование
			ds.beginTrans();

			//проверка p_thread.smpl_chk
			if (check(menuGenItg, 4)) {
				return;
			}
			if (check(menuGenItg, 5)) {
				return;
			}
			if (check(menuGenItg, 6)) {
				return;
			}
			if (check(menuGenItg, 7)) {
				return;
			}
			
			//**********Проверки gen.gen_check
			//проверка корректности л.с.
			if (check2(menuGenItg, 12)) { //5
				return;
			}
			//основные проверки
			if (check2(menuGenItg, 8)) { //1
				return;
			}
			//корректность периода в ЛК
			if (check2(menuGenItg, 15)) { //8
				return;
			}
			ds.commitTrans();
		}

		if (menuMonthOver.getSel()) {
			// выбран переход месяца
			//основные проверки
			if (check2(menuGenItg, 8)) { //1
				return;
			}
			//выполнено ли итоговое
			if (check2(menuGenItg, 10)) { //3
				return;
			}
			
			//проверка сальдо
			if (check2(menuGenItg, 11)) { //4
				return;
			}

			//получение счетчиков
			if (check2(menuGenItg, 14)) { //7
				return;
			}
			
		}				
		//**********Начать формирование
		genLoop: for (SprGenItm itm : sprg) {
				System.out.println("Generating menu item: " + itm.getCd());
				switch (itm.getCd()) {

				case "GEN_CHRG": {
					ds.beginTrans();
					// начисление (по домам)
					tobj = new TempObjDao().findAll();
					@SuppressWarnings("unused")
					SrvThr srv = new SrvThr(10, 0); // запустить N-потоков, var=0 -
													// по домам, ждать выполнения
					if (SrvThr.errChild !=0){
						//произошла ошибка в потоках, записать её
						itm.setState("Ошибка: "+SrvThr.errTextChild);
						break genLoop; //выйти из цикла (использую label genLoop!!!)
						
					}
					break;
				}
			}

		}
		
		//если была ошибка
		if (SrvThr.errChild !=0) {
			closeGen(menuGenItg, 2, 1, "Ошибка в потоке");
			return;
		}
		
		//************ Завершение
		
		menuGenItg.setProc(1.0); //установить 100% выполнения
		closeGen(menuGenItg, 1, 0, "Выполннено");
	}
}