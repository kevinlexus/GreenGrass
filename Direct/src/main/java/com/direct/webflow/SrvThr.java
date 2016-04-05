package com.direct.webflow;

import java.util.ArrayList;
import java.util.List;


public class SrvThr {

	public static int errChild; //возникла ли ошибка в порождённых потоках? (0-нет, 1-да)
	public static String errTextChild; //описание ошибки возникшей в порожд.потоках
	
	/**
	 * Класс обслуживающий потоки
	 * @param cnt Кол-во потоков
	 * @param var Вариант формирования
	 */
	public SrvThr(int cnt, int var) {
		//добавить необходимое кол-во потоков
		errChild=0; //сбросить ошибки потоков
		List<ThrGen> trl = new ArrayList<ThrGen>();
		for (int a=1; a <=cnt; a++) {
			
			ThrGen ttr=new ThrGen("ThrGen-"+a, var);
			
			ttr.start();
			trl.add(ttr);
		}
		
		//ждать, когда все потоки выполнятся
		for (ThrGen itm : trl) {
			try {
				itm.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		//выход
		System.out.println("SrvThr - exiting");
	}
	
}
