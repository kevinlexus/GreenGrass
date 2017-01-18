package com.ric.web;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ric.bill.BillServ;
import com.ric.bill.Calc;
import com.ric.bill.ChrgThr;
import com.ric.bill.Config;
import com.ric.bill.RequestConfig;
import com.ric.bill.Result;
import com.ric.bill.excp.EmptyStorable;
import com.ric.bill.excp.ErrorWhileChrg;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Par;


@EnableCaching
@RestController
@ComponentScan({"com.ric.bill"}) //-если убрать - не найдёт бины, например billServ
@EntityScan(basePackages = "com.ric.bill")
@EnableAutoConfiguration
@Scope("prototype")
@Slf4j
public class BillingController {

    @PersistenceContext
    private EntityManager em;
	@Autowired
	private ApplicationContext ctx;
	@Autowired
	private Config config;
    @Autowired
    private BillServ billServ;

    @RequestMapping("/chrglsk") 
    public String chrgLsk(@RequestParam(value="lsk", defaultValue="00000000") Integer lsk, 
    					  @RequestParam(value="dist", defaultValue="0") String dist,
    					  @RequestParam(value="tp", defaultValue="0") String tp,
    					  @RequestParam(value="chngId", defaultValue="") String chngId
    		) {
    	log.info("GOT /chrglsk with: lsk={}, dist={}, tp={}, chngId={}", lsk, dist, tp, chngId);
		
    	// получить уникальный номер запроса
    	int rqn = config.incNextReqNum();
    	
    	log.info("RQN={}", rqn);
		long beginTime = System.currentTimeMillis();
		
		// получить доступ к лиц.счету
		while (!config.checkLsk(lsk)) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return "ERROR";
			} 
		}
		
    	Future<Result> fut = null;

    	// если пустой ID перерасчета
    	Integer chId = null;
    	if (chngId.length()!=0 && chngId!= null) {
    		log.info("chngId={}", chngId);
    		chId=Integer.valueOf(chngId);
    	}

    	RequestConfig reqConfig = ctx.getBean(RequestConfig.class);
		long endTime1=System.currentTimeMillis()-beginTime;
		beginTime = System.currentTimeMillis();
    	
    	reqConfig.setUp(config, dist, tp, chId, rqn); 

		long endTime2=System.currentTimeMillis()-beginTime;
		beginTime = System.currentTimeMillis();
    	
    	fut = billServ.chrgLsk(reqConfig, null, lsk);

    	long endTime3=System.currentTimeMillis()-beginTime; // время инициализации billServ bean
		beginTime = System.currentTimeMillis();

		//ждать окончание потока 
		try {
			fut.get();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
			config.unCheckLsk(lsk); // снять лицевой с обработки
			return "ERROR";
		} catch (ExecutionException e1) {
			e1.printStackTrace();
			config.unCheckLsk(lsk); // снять лицевой с обработки
			return "ERROR";
		}
		
		long endTime4=System.currentTimeMillis()-beginTime;

	    log.info("Время исполнения: 1={},2={},3={},4={}", endTime1, endTime2, endTime3, endTime4);

	    try {
			if (fut.get().err ==0) {
		    	log.info("OK /chrglsk with: lsk={}, dist={}, tp={}, chngId={}", lsk, dist, tp, chngId);
				config.unCheckLsk(lsk); // снять лицевой с обработки
				return "OK";
			} else {
		    	log.info("ERROR /chrglsk with: lsk={}, dist={}, tp={}, chngId={}", lsk, dist, tp, chngId);
				config.unCheckLsk(lsk); // снять лицевой с обработки
				return "ERROR";
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			config.unCheckLsk(lsk); // снять лицевой с обработки
			return "ERROR";
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			config.unCheckLsk(lsk); // снять лицевой с обработки
			return "ERROR";
		}


    } 
    
    @RequestMapping("/chrgall")
    public String chrgAll(@RequestParam(value="dist", defaultValue="0", required=true) String dist,
    					  @RequestParam(value="houseId", defaultValue="", required=false) Integer houseId) {
    	log.info("got /chrgall with: dist={}, houseId={}", dist, houseId);

    	// получить уникальный номер запроса
    	int rqn = config.incNextReqNum();
    	log.info("RQN={}", rqn);

    	Future<Result> fut = null;
    	
    	RequestConfig reqConfig = ctx.getBean(RequestConfig.class);
    	reqConfig.setUp(config, dist, "0", null, rqn); 
    	

    	fut = billServ.chrgAll(reqConfig, houseId);
    	
		 while (!fut.isDone()) {
	         try {
				Thread.sleep(100);
				//100-millisecond Задержка
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	     }

		 try {
				if (fut.get().err ==0) {
					return "OK";
				} else {
					return "ERROR";
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "ERROR";
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "ERROR";
		}
    }
   
}