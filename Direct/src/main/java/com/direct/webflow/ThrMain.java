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
	 * @param var  вариант исполнения
	 * 		extPar дополнительный параметр
	 *            
	 * @return
	 */
	private int execDoWork(int var, int extPar) { //используется массив var[] так как doWork требует final переменную... так обманули
	doWorkRet =-1;
	final int varArr[]={var};
	final int extParArr[]={extPar};
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
		
		case 16: {
			//установить текущую дату, до формирования
			ds.sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ call scott.init.set_date_for_gen() }");
					call.execute();
					doWorkRet = 0;
				}
			});

			break;
		}
		
		case 17: {
			//чистить инф, там где ВООБЩЕ нет счетчиков (нет записи в c_vvod)
			ds.sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ call scott.p_thread.gen_clear_vol() }");
					call.execute();
					doWorkRet = 0;
				}
			});

			break;
		}
		
		case 18: {
			//сбросить или установить признак что итоговое сформировано 
			ds.sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ call scott.init.set_state(?) }");
					call.setInt(1, extParArr[0]);
					call.execute();
					doWorkRet = 0;
				}
			});

			break;
		}
		
		case 19: {
			//формирование сальдо 
			ds.sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ call scott.gen.gen_saldo() }");
					call.execute();
					doWorkRet = 0;
				}
			});

			break;
		}
		
		case 20: {
			//движение
			ds.sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ scott.c_cpenya.gen_charge_pay_full() }");
					call.execute();
					doWorkRet = 0;
				}
			});
			break;
		}
		case 21: {
		    //пеня
			ds.sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ scott.c_penya.gen_charge_pay_pen() }");
					call.execute();
					doWorkRet = 0;
				}
			});

			break;
		}
		
		case 22: {
		    //сальдо по домам
			ds.sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ scott.gen.gen_saldo_houses() }");
					call.execute();
					doWorkRet = 0;
				}
			});

			break;
		}
		
		case 23: {
		    //начисление по услугам (надо ли оно кому???)
			ds.sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ scott.gen.gen_xito13() }");
					call.execute();
					doWorkRet = 0;
				}
			});

			break;
		}
		
		case 24: {
		    //оплата по операциям Ф.3.1.
			ds.sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ scott.gen.gen_opl_xito5() }");
					call.execute();
					doWorkRet = 0;
				}
			});

			break;
		}
		
		case 25: {
		    //оплата по операциям Ф.3.1. для оборотки
			ds.sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ scott.gen.gen_opl_xito5_() }");
					call.execute();
					doWorkRet = 0;
				}
			});

			break;
		}

		case 26: {
		    //По УК-организациям Ф.2.4.
			ds.sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ scott.gen.gen_opl_xito10() }");
					call.execute();
					doWorkRet = 0;
				}
			});

			break;
		}
		
		case 27: {
		    //По пунктам начисления
			ds.sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ scott.gen.gen_opl_xito3() }");
					call.execute();
					doWorkRet = 0;
				}
			});

			break;
		}

		case 28: {
		    //Архив, счета
			ds.sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ scott.gen.prepare_arch() }");
					call.execute();
					doWorkRet = 0;
				}
			});

			break;
		}

		case 29: {
		    //Задолжники
			ds.sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ scott.gen.gen_debits_lsk_month() }");
					call.execute();
					doWorkRet = 0;
				}
			});

			break;
		}
		
		case 30: {
		    //Списки
			ds.sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ scott.() }");
					call.execute();
					doWorkRet = 0;
				}
			});

			break;
		}

		case 31: {
		    //Статистика
			ds.sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ scott.() }");
					call.execute();
					doWorkRet = 0;
				}
			});

			break;
		}

		case 32: {
		    //Переход периода
			ds.sess.doWork(new Work() {
				public void execute(Connection connection) throws SQLException {
					CallableStatement call = connection
							.prepareCall("{ scott.() }");
					call.execute();
					doWorkRet = 0;
				}
			});

			break;
		}

		default: {
			doWorkErrText="ThrMain.doWork: не найдено вхождение case!";
			System.out.println("ThrMain.doWork: не найдено вхождение case!");
			doWorkRet=-1;
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
		int ret = execDoWork(2, 0);// Снять блокировку после итогового формирования (можно снимать, даже если его не было)
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

	//вынес модуль проверки-1 (smpl_chk)
	//проверка 4
	private boolean check(SprGenItm menuGenItg, int var){
		int ret = execDoWork(var, 0);
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
		int ret = execDoWork(var, 0);
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
		SprGenItm menuGenItg, menuMonthOver, menuCheckBG;
		menuGenItg = sprgDao.getByCd("GEN_ITG");
		menuMonthOver = sprgDao.getByCd("GEN_MONTH_OVER");
		menuCheckBG = sprgDao.getByCd("GEN_CHECK_BEFORE_GEN");

	
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
		
		//**********установить дату формирования
		ds.beginTrans();
		 if (execDoWork(16, 0)!=0) {
			closeGen(menuGenItg, 2, 1, "ThrMain: Некорректная дата формирования!");
			return; // выходить
		 }
		ds.commitTrans();

		//**********(Установить блокировку для итогового формирования)
		ds.beginTrans();
		if (menuGenItg.getSel()) {
			// выбрано итоговое формирование
			ret = execDoWork(1, 0);// Установить блокировку
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
		
		//сбросить признак что сформировано итоговое (в конце, если всё успешно - поставить)
		ret = execDoWork(18, 0);
		if (ret==-1) {
			//Ошибка во время вызова
			closeGen(menuGenItg, 2, 1, "ThrMain: "+doWorkErrText);
			return; // выходить
		}
		ds.commitTrans();
		//**********

		WebCtrl.stateGen="1"; //Выполняется формирование

		//**********Закрыть базу для пользователей
		ds.beginTrans();
		ret = execDoWork(3, 0);
		if (ret==-1) {
			//Ошибка во время вызова
			closeGen(menuGenItg, 2, 1, "ThrMain: "+doWorkErrText);
			return; // выходить
		}
		System.out.println("ThrMain: Установлен признак закрытия базы!");
		ds.commitTrans();
		//**********

		//**********Проверки до формирования
		if (menuCheckBG.getSel()) {
			// если выбраны проверки, а они как правило д.б. выбраны при итоговом
			ds.beginTrans();

			//проверка p_thread.smpl_chk
			if (check(menuGenItg, 4)) {
				return;
			}
			menuCheckBG.setProc(0.1);			
			if (check(menuGenItg, 5)) {
				return;
			}
			if (check(menuGenItg, 6)) {
				return;
			}
			if (check(menuGenItg, 7)) {
				return;
			}
			menuCheckBG.setProc(0.5);			
			//**********Проверки gen.gen_check
			//проверка корректности л.с.
			if (check2(menuGenItg, 12)) { //5
				return;
			}
			menuCheckBG.setProc(0.7);			
			//основные проверки
			if (check2(menuGenItg, 8)) { //1
				return;
			}
			//корректность периода в ЛК
			if (check2(menuGenItg, 15)) { //8
				return;
			}
			menuCheckBG.setProc(1.0);			
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
		for (SprGenItm itm : sprg) {
				System.out.println("Generating menu item: " + itm.getCd());
				switch (itm.getCd()) {

				case "GEN_DIST_VOLS": {
					ds.beginTrans();
					//чистить инф, там где ВООБЩЕ нет счетчиков (нет записи в c_vvod)
					ret = execDoWork(17, 0);
					if (ret==-1) {
						//Ошибка во время вызова
						closeGen(menuGenItg, 2, 1, "ThrMain: "+doWorkErrText);
						return; // выходить
					}
					itm.setProc(0.2);
					ds.commitTrans();
					
					//распределить где нет ОДПУ
					ds.beginTrans();
					tobj = new TempObjDao().findAll(2); //найти вводы
					@SuppressWarnings("unused")
					SrvThr srv;
					srv = new SrvThr(10, 2); // запустить N-потоков, var=2 -
													// по вводам, ждать выполнения
					if (SrvThr.errChild !=0){
						//произошла ошибка в потоках, записать её
						itm.setState("Ошибка: "+SrvThr.errTextChild);
						//выйти из формирования
						closeGen(menuGenItg, 2, 1, "Ошибка в потоке");
						return;
					
					}
					itm.setProc(0.5);
					ds.commitTrans();

					//распределить где есть ОДПУ
					ds.beginTrans();
					//tobj = new TempObjDao().findAll(2); //найти вводы - вводы уже найдены в предыдущ секции
					srv = new SrvThr(10, 3); // запустить N-потоков, var=3
													// по вводам, ждать выполнения
					if (SrvThr.errChild !=0){
						//произошла ошибка в потоках, записать её
						itm.setState("Ошибка: "+SrvThr.errTextChild);
						//выйти из формирования
						closeGen(menuGenItg, 2, 1, "Ошибка в потоке");
						return;
					
					}
					itm.setProc(1.0);
					ds.commitTrans();
					
					break;
				}
				case "GEN_CHRG": {
					// начисление (по домам)
					ds.beginTrans();
					tobj = new TempObjDao().findAll(1); //найти дома
					@SuppressWarnings("unused")
					SrvThr srv = new SrvThr(10, 1); // запустить N-потоков, var=1 -
													// по домам, ждать выполнения
					if (SrvThr.errChild !=0){
						//произошла ошибка в потоках, записать её
						itm.setState("Ошибка: "+SrvThr.errTextChild);
						//выйти из формирования
						closeGen(menuGenItg, 2, 1, "Ошибка в потоке");
						return;
						
					}
					itm.setProc(1.0);
					ds.commitTrans();
					break;
				}
				case "GEN_SAL": {
					ds.beginTrans();
					//сальдо по лиц счетам
					ret = execDoWork(19, 0);
					if (ret==-1) {
						//Ошибка во время вызова
						closeGen(menuGenItg, 2, 1, "ThrMain: "+doWorkErrText);
						return; // выходить
					}
					itm.setProc(1.0);
					ds.commitTrans();
					break;
				}

				case "GEN_FLOW": {
					ds.beginTrans();
					//сальдо по лиц счетам
					ret = execDoWork(20, 0);
					if (ret==-1) {
						//Ошибка во время вызова
						closeGen(menuGenItg, 2, 1, "ThrMain: "+doWorkErrText);
						return; // выходить
					}
					itm.setProc(0.5);

					ret = execDoWork(21, 0);
					if (ret==-1) {
						//Ошибка во время вызова
						closeGen(menuGenItg, 2, 1, "ThrMain: "+doWorkErrText);
						return; // выходить
					}
					itm.setProc(0.8);

					//проверить распр.пени
					if (check2(menuGenItg, 13)) { //1
						return;
					}

					itm.setProc(1.0);
					ds.commitTrans();
					break;
				}
				
				
				case "GEN_SAL_HOUSES": {
					ds.beginTrans();
					//сальдо по по домам
					ret = execDoWork(22, 0);
					if (ret==-1) {
						//Ошибка во время вызова
						closeGen(menuGenItg, 2, 1, "ThrMain: "+doWorkErrText);
						return; // выходить
					}
					itm.setProc(1.0);
					ds.commitTrans();
					break;
				}

				case "GEN_XITO14": {
					ds.beginTrans();
					//начисление по услугам
					ret = execDoWork(23, 0);
					if (ret==-1) {
						//Ошибка во время вызова
						closeGen(menuGenItg, 2, 1, "ThrMain: "+doWorkErrText);
						return; // выходить
					}
					itm.setProc(1.0);
					ds.commitTrans();
					break;
				}				
				
				case "GEN_F3_1": {
					ds.beginTrans();
					//оплата по операциям
					ret = execDoWork(24, 0);
					if (ret==-1) {
						//Ошибка во время вызова
						closeGen(menuGenItg, 2, 1, "ThrMain: "+doWorkErrText);
						return; // выходить
					}
					itm.setProc(1.0);
					ds.commitTrans();
					break;
				}				
				
				case "GEN_F3_1_2": {
					ds.beginTrans();
					//оплата по операциям, для оборотной
					ret = execDoWork(25, 0);
					if (ret==-1) {
						//Ошибка во время вызова
						closeGen(menuGenItg, 2, 1, "ThrMain: "+doWorkErrText);
						return; // выходить
					}
					itm.setProc(1.0);
					ds.commitTrans();
					break;
				}				

				case "GEN_F2_4": {
					ds.beginTrans();
					//По УК-организациям Ф.2.4.
					ret = execDoWork(26, 0);
					if (ret==-1) {
						//Ошибка во время вызова
						closeGen(menuGenItg, 2, 1, "ThrMain: "+doWorkErrText);
						return; // выходить
					}
					itm.setProc(1.0);
					ds.commitTrans();
					break;
				}				
				
				case "GEN_F1_1": {
					ds.beginTrans();
					//По пунктам начисления
					ret = execDoWork(27, 0);
					if (ret==-1) {
						//Ошибка во время вызова
						closeGen(menuGenItg, 2, 1, "ThrMain: "+doWorkErrText);
						return; // выходить
					}
					itm.setProc(1.0);
					ds.commitTrans();
					break;
				}
				
				case "GEN_ARCH_BILLS": {
					ds.beginTrans();
					//Архив, счета
					ret = execDoWork(28, 0);
					if (ret==-1) {
						//Ошибка во время вызова
						closeGen(menuGenItg, 2, 1, "ThrMain: "+doWorkErrText);
						return; // выходить
					}
					itm.setProc(1.0);
					ds.commitTrans();
					break;
				}				
				
				case "GEN_DEBTS": {
					ds.beginTrans();
					//Архив, счета
					ret = execDoWork(29, 0);
					if (ret==-1) {
						//Ошибка во время вызова
						closeGen(menuGenItg, 2, 1, "ThrMain: "+doWorkErrText);
						return; // выходить
					}
					itm.setProc(1.0);
					ds.commitTrans();
					break;
				}				
				
				case "dd": {
					ds.beginTrans();
					//Списки
					ret = execDoWork(30, 0);
					if (ret==-1) {
						//Ошибка во время вызова
						closeGen(menuGenItg, 2, 1, "ThrMain: "+doWorkErrText);
						return; // выходить
					}
					itm.setProc(1.0);
					ds.commitTrans();
					break;
				}				
				
				case "dd": {
					ds.beginTrans();
					//Статистика
					ret = execDoWork(31, 0);
					if (ret==-1) {
						//Ошибка во время вызова
						closeGen(menuGenItg, 2, 1, "ThrMain: "+doWorkErrText);
						return; // выходить
					}
					itm.setProc(1.0);
					ds.commitTrans();
					break;
				}				
				
				case "dd": {
					ds.beginTrans();
					//Переход периода
					ret = execDoWork(32, 0);
					if (ret==-1) {
						//Ошибка во время вызова
						closeGen(menuGenItg, 2, 1, "ThrMain: "+doWorkErrText);
						return; // выходить
					}
					itm.setProc(1.0);
					ds.commitTrans();
					break;
				}				
			}

		}
		
		//************ Заключительные проверки, при итоговом формировании
		if (menuCheckBG.getSel()) {
			// если выбраны проверки, а они как правило д.б. выбраны при итоговом
			ds.beginTrans();
			//окончательная проверка на корректность исх.сальдо
			if (check(menuGenItg, 11)) {
				return;
			}
		}
		
		//установить признак что сформировано итоговое, если дошли до сюда
		ret = execDoWork(18, 1);
		if (ret==-1) {
			//Ошибка во время вызова
			closeGen(menuGenItg, 2, 1, "ThrMain: "+doWorkErrText);
			return; // выходить
		}

		//************ Завершение
		menuGenItg.setProc(1.0); //установить 100% выполнения
		closeGen(menuGenItg, 1, 0, "Выполннено");
	}
}