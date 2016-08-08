package com.ric.web;

import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ric.bill.model.bs.Org;

//import com.ric.bill.ChrgServ;


//@EntityScan(basePackages = "com.ric.bill")
@ComponentScan({ "com.ric.bill" })
@RestController
public class GreetingController {

	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;
    
    /*@Autowired
    private BillServ billServ;

    @Autowired
    private ChrgServ chrgServ;*/

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //@Autowired private CacheManager cacheManager;
    
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="lsk", defaultValue="00000000") String lsk) {


/*  	        System.out.println("Cache managerName:"+cacheManager.getName());
  	        System.out.println("Cache managerName:"+cacheManager.getStatus());
  	        
    	    for (String name : cacheManager.getCacheNames()) {
      	      System.out.println("Cache name:"+name);
      	      
    	    }*/
    	
    	Org org =em.find(Org.class, 84);
    	
    	/*try {
			billServ.chrgAll();
		} catch (ErrorWhileChrg e) {
			e.printStackTrace();
		}*/
    	
    	/*try {
			chrgHouse(1737);
		} catch (ErrorWhileChrg e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
			chrgHouse(1744);
		} catch (ErrorWhileChrg e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

    	/*
    	try {
			chrgServ.chrgLsk(kart);
			//chrgServ.save(kart.getLsk());
			//billServ.chrgLsk(kart);
		} catch (ErrorWhileChrg e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

    	/*System.out.println("kart="+kart);
    	System.out.println("kart="+kart.getLsk());
    	try {
			chrgServ.chrgLsk(kart);
			chrgServ.save(kart.getLsk());
			//billServ.chrgLsk(kart);
		} catch (ErrorWhileChrg e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	*/
    	return new Greeting(counter.incrementAndGet(),
    			org.getName());
    }
    
    /**
	 * выполнить начисление по дому
	 * @param houseId - Id дома, иначе кэшируется, если передавать объект дома
	 */
/*	public void chrgHouse(int houseId) throws ErrorWhileChrg {

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
	}
 */   
}