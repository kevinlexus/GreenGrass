package com.ric.web;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ric.bill.BillServ;
import com.ric.bill.Config;
import com.ric.bill.RequestConfig;
import com.ric.bill.Result;
import com.ric.bill.dto.DTOBuilder;
import com.ric.bill.dto.LstDTO;
import com.ric.bill.dto.PayordDTO;
import com.ric.bill.dto.PeriodReportsDTO;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.PayordMng;
import com.ric.bill.mm.ReportMng;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.fn.Payord;


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
	@Autowired
    private ReportMng repMng;
	@Autowired
    private LstMng lstMng;
	@Autowired
    private PayordMng payordMng;
	@Autowired
    private DTOBuilder dtoBuilder;

    /**
     * Получить периоды для элементов интерфейса
     * @param repCd - CD отчета
     * @param tp - тип периода 0 - по месяцам, 1 - по дням
     * @return
     */
	@RequestMapping("/getPeriodReports") 
    @ResponseBody
    public List<PeriodReportsDTO> getPeriodReports(@RequestParam(value="repCd") String repCd,
 			    		  @RequestParam(value="tp", defaultValue="0") Integer tp) {
    	
    	log.info("GOT /getPeriodReports repCd={}, tp={}", repCd, tp);
    	return repMng.getPeriodsByCD(repCd, tp);
    	
    }

	/**
	 * Получить все платежки
	 * @return
	 */
	@RequestMapping("/getPayord") 
    @ResponseBody
    public List<PayordDTO> getPayord() {

		log.info("GOT /getPayord");
		return dtoBuilder.getPayordDTOLst(payordMng.getPayordAll());
		
    }

   @RequestMapping(value = "/setPayord", method = RequestMethod.POST, produces="application/json", consumes="application/json")
   @ResponseBody
   public String setPayord(@RequestBody List<PayordDTO> lst) {

	   log.info("GOT /setPayord");
	   lst.stream().forEach(t -> payordMng.savePayordDto(t));
	   return null;
   }
	/**
	 * Получить список по типу
	 * @param tp - тип списка
	 * @return
	 */
	@RequestMapping("/getLst") 
    @ResponseBody
    public List<LstDTO> getLst(@RequestParam(value="tp") String tp) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
	    log.info("Logged user={}", name);
	      
		
		log.info("GOT /getLst with tp={}", tp);
		return dtoBuilder.getLstDTOLst(lstMng.getByTp(tp));
		
    }

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
		int i = 0;
		while (!config.checkLsk(lsk)) {
			i++;
			if (i > 100) {
		    	log.info("********ВНИМАНИЕ!ВНИМАНИЕ!ВНИМАНИЕ!ВНИМАНИЕ!ВНИМАНИЕ!ВНИМАНИЕ!ВНИМАНИЕ! /chrglsk with: lsk={}", lsk);
		    	log.info("********НЕ ВОЗМОЖНО РАЗБЛОКИРОВАТЬ ЛС В ТЕЧЕНИИ 10 сек! /chrglsk with: lsk={}", lsk);
				i=0;
			}
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
	    	log.info("BEGINING UNLOCK /chrglsk with: lsk={}", lsk);
			config.unCheckLsk(lsk); // снять лицевой с обработки
	    	log.info("ENDING UNLOCK /chrglsk with: lsk={}", lsk);
			return "ERROR";
		} catch (ExecutionException e1) {
			e1.printStackTrace();
	    	log.info("BEGINING UNLOCK /chrglsk with: lsk={}", lsk);
			config.unCheckLsk(lsk); // снять лицевой с обработки
	    	log.info("ENDING UNLOCK /chrglsk with: lsk={}", lsk);
			return "ERROR";
		}
		
		long endTime4=System.currentTimeMillis()-beginTime;

	    log.info("TIMING: доступ.к л.с.={}, конфиг={}, инит. bean={}, расчет={}", endTime1, endTime2, endTime3, endTime4);

	    try {
			if (fut.get().err ==0) {
		    	log.info("BEGINING UNLOCK /chrglsk with: lsk={}", lsk);
				config.unCheckLsk(lsk); // снять лицевой с обработки
		    	log.info("ENDING UNLOCK /chrglsk with: lsk={}", lsk);
		    	log.info("OK /chrglsk with: lsk={}, dist={}, tp={}, chngId={}", lsk, dist, tp, chngId);
				return "OK";
			} else {
		    	log.info("BEGINING UNLOCK /chrglsk with: lsk={}", lsk);
				config.unCheckLsk(lsk); // снять лицевой с обработки
		    	log.info("ENDING UNLOCK /chrglsk with: lsk={}", lsk);
		    	log.info("ERROR /chrglsk with: lsk={}, dist={}, tp={}, chngId={}", lsk, dist, tp, chngId);
				return "ERROR";
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    	log.info("BEGINING UNLOCK /chrglsk with: lsk={}", lsk);
			config.unCheckLsk(lsk); // снять лицевой с обработки
	    	log.info("ENDING UNLOCK /chrglsk with: lsk={}", lsk);
			return "ERROR";
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    	log.info("BEGINING UNLOCK /chrglsk with: lsk={}", lsk);
			config.unCheckLsk(lsk); // снять лицевой с обработки
	    	log.info("ENDING UNLOCK /chrglsk with: lsk={}", lsk);
			return "ERROR";
		}


    } 
    
    @RequestMapping("/chrgall")
    public String chrgAll(@RequestParam(value="dist", defaultValue="0", required=true) String dist,
    					  @RequestParam(value="houseId", defaultValue="", required=false) Integer houseId, 
    					  @RequestParam(value="areaId", defaultValue="", required=false) Integer areaId) {
    	log.info("got /chrgall with: dist={}, houseId={}, areaId={} ", dist, houseId, areaId);

    	// получить уникальный номер запроса
    	int rqn = config.incNextReqNum();
    	log.info("RQN={}", rqn);

    	Future<Result> fut = null;
    	
    	RequestConfig reqConfig = ctx.getBean(RequestConfig.class);
    	reqConfig.setUp(config, dist, "0", null, rqn); 
    	
    	fut = billServ.chrgAll(reqConfig, houseId, areaId);
    	
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