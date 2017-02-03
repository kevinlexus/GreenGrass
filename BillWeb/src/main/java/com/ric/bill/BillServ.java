package com.ric.bill;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.excp.EmptyStorable;
import com.ric.bill.excp.ErrorWhileChrg;
import com.ric.bill.excp.ErrorWhileDist;
import com.ric.bill.excp.WrongSetMethod;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.KartMng;
import com.ric.bill.mm.ObjMng;
import com.ric.bill.mm.ParMng;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Dw;
import com.ric.bill.model.bs.Obj;

/**
 * Главный сервис биллинга
 * 
 * @author lev
 *
 */
@Service
@Scope("prototype")
@Slf4j
public class BillServ {

	@Autowired
	private HouseMng houseMng;

	@Autowired
	private KartMng kartMng;

	@Autowired
	private ObjMng objMng; // TODO убрать!

	@Autowired
	private ParMng parMng;// TODO убрать!

	@Autowired
	private ApplicationContext ctx;

	@PersistenceContext
	private EntityManager em;

	// коллекция для формирования потоков
	private List<Kart> kartThr;

	// конструктор
	public BillServ() {

	}

	
    // временно оставил здесь метод выполнения различных скриптов
	@Transactional(readOnly=false) 
	public void script1() throws EmptyStorable, WrongSetMethod {
		log.info("Script1");
    	int rqn =-1;
		Obj obj = objMng.getByCD(-1, "Модуль начисления");

		Dw d = em.find(Dw.class, 8214820);
		Calendar calendar = new GregorianCalendar(2017, Calendar.FEBRUARY, 1);
		parMng.setDate(rqn, obj, "Начало расчетного периода", calendar.getTime());
		//d.setDts1(calendar.getTime());
		
		calendar = new GregorianCalendar(2017, Calendar.FEBRUARY, 28);
		parMng.setDate(rqn, obj, "Конец расчетного периода", calendar.getTime());
		
		log.info("Check ={}", obj.getId());
		log.info("Check dt1={}", parMng.getDate(-1, obj, "Начало расчетного периода"));
    	log.info("Check dt1={}", parMng.getDate(-1, obj, "Конец расчетного периода"));
    	
	}
	
    // временно оставил здесь метод выполнения различных скриптов
	@Transactional(readOnly=false) 
	public void script2() throws EmptyStorable, WrongSetMethod {
		log.info("Script1");
    	int rqn =-1;
		Obj obj = objMng.getByCD(-1, "Модуль начисления");

		Dw d = em.find(Dw.class, 8214820);
		Calendar calendar = new GregorianCalendar(2017, Calendar.FEBRUARY, 1);
		parMng.setDate(rqn, obj, "Начало расчетного периода", calendar.getTime());
		//d.setDts1(calendar.getTime());
		
		calendar = new GregorianCalendar(2017, Calendar.FEBRUARY, 28);
		parMng.setDate(rqn, obj, "Конец расчетного периода", calendar.getTime());
		
		log.info("Check ={}", obj.getId());
		log.info("Check dt1={}", parMng.getDate(-1, obj, "Начало расчетного периода"));
    	log.info("Check dt1={}", parMng.getDate(-1, obj, "Конец расчетного периода"));
    	
	}

	// получить список N следующих лиц.счетов, для расчета в потоках
	private List<Kart> getNextKart(int cnt) {
		List<Kart> lst = new ArrayList<Kart>();
		int i = 1;
		Iterator<Kart> itr = kartThr.iterator();
		while (itr.hasNext()) {
			Kart kart = itr.next();
			lst.add(kart);
			itr.remove();
			i++;
			if (i > cnt) {
				break;
			}
		}

		return lst;
	}

	// флаг ошибки, произошедшей в потоке
	private static Boolean errThread;

	// Exception из потока
	Thread.UncaughtExceptionHandler expThr = new Thread.UncaughtExceptionHandler() {
		public void uncaughtException(Thread th, Throwable ex) {
			errThread = true;
			System.out.println("BillServ: Error in thread: " + th.getName()
					+ " " + ex.getMessage());
			ex.printStackTrace();
		}
	};

	/**
	 * выполнить распределение объемов и начисление по всем домам в потоках
	 * 
	 * @param isDist
	 *            - распределять ли объемы
	 * @param isChrg
	 *            - выполнять ли начисление
	 * @return
	 */
	@Async
	@CacheEvict(value = { "rrr1", "rrr2", "rrr3" }, allEntries = true)
	public Future<Result> chrgAll(RequestConfig reqConfig, Integer houseId) {
		// Logger.getLogger("org.hibernate.SQL").setLevel(Level.DEBUG);
		// Logger.getLogger("org.hibernate.type").setLevel(Level.TRACE);
		Result res = new Result();
		res.err = 0;
		// кол-во потоков
		int cntThreads = 10;
		// кол-во обраб.лиц.сч.
		int cntLsk = 0;

		long startTime;
		long endTime;
		long totalTime;
		long totalTime3;

		startTime = System.currentTimeMillis();
		DistServ distServ = ctx.getBean(DistServ.class);

		// РАСПРЕДЕЛЕНИЕ ОБЪЕМОВ, если задано
		if (reqConfig.getIsDist()) {
			Calc calc = new Calc(reqConfig);
			distServ.distAll(calc, houseId);
			log.info("BillServ.chrgAll: Распределение по всем домам выполнено!");
		}

		// РАСЧЕТ НАЧИСЛЕНИЯ ПО ЛС В ПОТОКАХ
		long startTime3 = System.currentTimeMillis();
		// загрузить все необходимые Лиц.счета
		kartThr = kartMng.findAll(houseId);
		cntLsk = kartThr.size();
		// флаг ошибки, произошедшей в потоке
		errThread = false;

		while (true) {
			log.trace("BillServ.chrgAll: Loading karts for threads");
			// получить следующие N лиц.счетов, рассчитать их в потоке
			long startTime2;
			long endTime2;
			long totalTime2;
			startTime2 = System.currentTimeMillis();

			List<Kart> kartWork = getNextKart(cntThreads);
			if (kartWork.isEmpty()) {
				// выйти, если все услуги обработаны
				break;
			}

			List<Future<Result>> frl = new ArrayList<Future<Result>>();

			for (Kart kart : kartWork) {

				log.trace("BillServ.chrgAll: Prepare thread for lsk="
						+ kart.getLsk());
				Future<Result> fut = null;
				ChrgServThr chrgServThr = ctx.getBean(ChrgServThr.class);

				// под каждый поток - свой Calc
				Calc calc = new Calc(reqConfig);

				calc.setKart(kart);
				calc.setHouse(kart.getKw().getHouse());
				if (calc.getArea() ==null) {
					log.error("Ошибка! По записи house.id={}, в его street, не заполнено поле area!");
					res.err=1;
				}
				
				try {
					fut = chrgServThr.chrgAndSaveLsk(calc);
				} catch (ErrorWhileChrg e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frl.add(fut);
				log.trace("BillServ.chrgAll: Begins thread for lsk="
						+ kart.getLsk());
			}

			// проверить окончание всех потоков
			int flag2 = 0;
			while (flag2 == 0) {
				log.trace("BillServ.chrgAll: ========================================== Waiting for threads-2");
				flag2 = 1;
				for (Future<Result> fut : frl) {
					if (!fut.isDone()) {
						flag2 = 0;
					} else {
						try {
							log.trace("ChrgServ: Done Result.err:="
									+ fut.get().err);
							if (fut.get().err == 1) {
								errThread = true;
							}
						} catch (InterruptedException | ExecutionException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			endTime2 = System.currentTimeMillis();
			totalTime2 = endTime2 - startTime2;
			log.info("Time for chrg One Lsk:" + totalTime2 / cntThreads, 2);

		}
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		totalTime3 = endTime - startTime3;
		log.info("Ver=2.0", 2);
		log.info("Counted lsk:" + cntLsk, 2);
		log.info("Time for all process:" + totalTime, 2);
		if (cntLsk > 0) {
			log.info("Time per one Lsk: " + totalTime3 / cntLsk + " ms.", 2);
		}

		return new AsyncResult<Result>(res);
	}

	/**
	 * выполнить начисление по лиц.счету
	 * 
	 * @param kart
	 *            - лиц счет (заполнен либо он, либо lsk)
	 * @param lsk
	 *            - номер лиц.счета
	 * @param dist
	 *            - распределить объемы?
	 * @throws InterruptedException
	 * @throws ErrorWhileChrg
	 */
	@Async
	//@CacheEvict(value = { "rrr1", "rrr2", "rrr3" }, allEntries = true) //чистить кэш, в то время как параллельно выполняется другой поток???
	// TODO ОТКЛЮЧИТЬ КЭШ ЗДЕСЬ ПОСЛЕ ВВОДА RQN!
	public Future<Result> chrgLsk(RequestConfig reqConfig, Kart kart,
			Integer lsk) {
		long beginTime = System.currentTimeMillis();
		ChrgServThr chrgServThr = ctx.getBean(ChrgServThr.class);
		DistServ distServ = ctx.getBean(DistServ.class);

		Result res = new Result();
		Future<Result> fut = new AsyncResult<Result>(res);

		res.err = 0;
		// Если был передан идентификатор лицевого, то найти лиц.счет
		if (lsk != null) {
			kart = em.find(Kart.class, lsk);
			if (kart == null) {
				res.err = 1;
				return fut;
			}
		}
		Calc calc = new Calc(reqConfig);

		// установить дом и счет
		calc.setHouse(kart.getKw().getHouse());
		calc.setKart(kart);

		long endTime1 = System.currentTimeMillis() - beginTime;
		beginTime = System.currentTimeMillis();

		// РАСПРЕДЕЛЕНИЕ ОБЪЕМОВ, если задано
		if (reqConfig.getIsDist()) {
			try {
				distServ.distKartVol(calc);
			} catch (ErrorWhileDist e) {
				e.printStackTrace();
				res.err = 1;
				return fut;
			}
			// присвоить обратно лиц.счет, который мог быть занулён в
			calc.setKart(kart);
		}

		long endTime2 = System.currentTimeMillis() - beginTime;
		beginTime = System.currentTimeMillis();

		// РАСЧЕТ НАЧИСЛЕНИЯ ПО 1 ЛС
		try {
			fut = chrgServThr.chrgAndSaveLsk(calc);
		} catch (ErrorWhileChrg e) {
			e.printStackTrace();
			res.err = 1;
			return fut;
		}

		long endTime3 = System.currentTimeMillis() - beginTime;
		//log.info("TIMING: найти дом, л.с.={}, распр.объем={}, начислить={}", endTime1, endTime2,
				//endTime3);

		return fut;
	}

}
