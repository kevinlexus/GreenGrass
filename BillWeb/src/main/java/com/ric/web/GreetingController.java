package com.ric.web;

import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ric.bill.BillServ;
import com.ric.bill.ChrgThr;
import com.ric.bill.excp.ErrorWhileChrg;
import com.ric.bill.model.bs.Par;


@EnableCaching
@RestController
@ComponentScan({"com.ric.bill"}) //-если убрать - не найдёт бины, например billServ
@EntityScan(basePackages = "com.ric.bill")
@EnableAutoConfiguration
public class GreetingController {

    @PersistenceContext
    private EntityManager em;
    
	@Autowired
	private ApplicationContext ctx;

    @Autowired
    private BillServ billServ;

   // @Autowired
   // private ChrgServ chrgServ;
   

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //@Autowired 
    //private CacheManager cacheManager;
    
   
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="lsk", defaultValue="00000000") String lsk) {
    		System.out.println("VERSION 3.0");


    	try {
			billServ.chrgAll();
		} catch (ErrorWhileChrg e) {
			e.printStackTrace();
		}
    	
    	return "Working!";
    }
    
    /**
	 * выполнить начисление по дому
	 * @param houseId - Id дома, иначе кэшируется, если передавать объект дома
	 */
	/*public void chrgHouse(int houseId) throws ErrorWhileChrg {

		House h = em.find(House.class, houseId);
		Calc.setInit(false);
		//перебрать все квартиры и лиц.счета в них
		for (Kw kw : h.getKw()) {
			for (Kart kart : kw.getLsk()) {
		    	//System.out.println("kart="+kart);
		    	System.out.println("kart="+kart.getLsk());

				//if (kart.getLsk().equals("26074227")) {
					long startTime;
					long endTime;
					long totalTime;
					startTime = System.currentTimeMillis();
				    //расчитать начисление
					if (chrgServ.chrgLsk(kart) ==0){
						//сохранить расчет
						chrgServ.save(kart.getLsk());
					} else {
						//выполнилось с ошибкой
						return;
					}

					endTime   = System.currentTimeMillis();
					totalTime = endTime - startTime;
				    Calc.mess("ВРЕМЯ НАЧИСЛЕНИЯ по лиц счету:"+kart.getLsk()+" ="+totalTime,2);
				//	break; //##################
				//}
			}
			//break; //##################
		}
	    Calc.mess("Выполнено!",2);
	}*/
    
}