package com.direct.webflow;

import java.util.ArrayList;
import java.util.List;


public class SrvThr {

	public static int errChild; // возникла ли ошибка в порождённых потоках? (0-нет, 1-да)
	public static String errTextChild; // описание ошибки возникшей в порожд.потоках
	// общий список объектов для выполнения потоками
	static List<TempObj> tobj;
	static int progress, initCnt; // прогресс выполнения локальный, начальное кол-во объектов
	static SprGenItm itm; // пункт меню, который формируется
	// вернуть следующий объект из списка
	static synchronized TempObj getNextObj() {
		TempObj retObj = null;
		for (TempObj t : tobj) {
			retObj = t;
			// удалить объект, как "отработанный"
			tobj.remove(t);
			//обновить прогресс общий выполнения
			WebCtrl.incProgress();
			//прогресс локальный
			if (initCnt != 0){
				progress=1-tobj.size()/initCnt;
			} else {
				progress=1;
			}
			itm.setProc(Double.valueOf(progress));
			break;
		}
		return retObj; // вернуть или объект или null
	}

	/**
	 * Класс обслуживающий потоки
	 * @param cnt Кол-во потоков
	 * @param var Вариант формирования
	 */
	public SrvThr(List<TempObj> tobj, SprGenItm itm, int cnt, int var) {
		//добавить необходимое кол-во потоков
		this.itm=itm;
		SrvThr.tobj=tobj;
		errChild=0; //сбросить ошибки потоков
		List<ThrGen> trl = new ArrayList<ThrGen>();
		for (int a=1; a <=cnt; a++) {
			
			ThrGen ttr=new ThrGen("ThrGen-"+a, var);
			
			ttr.start();
			trl.add(ttr);
		}
		
		//ждать, когда все потоки выполнятся
		for (ThrGen t : trl) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		//выход
		System.out.println("SrvThr - exiting");
	}

	
}
