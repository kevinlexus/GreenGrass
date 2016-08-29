package com.ric.web;

import java.util.concurrent.Future;
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
import com.ric.bill.Result;
import com.ric.bill.excp.ErrorWhileChrg;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Par;


@EnableCaching
@RestController
@ComponentScan({"com.ric.bill"}) //-если убрать - не найдёт бины, например billServ
@EntityScan(basePackages = "com.ric.bill")
@EnableAutoConfiguration
public class BillingController {

    @PersistenceContext
    private EntityManager em;
    
	@Autowired
	private ApplicationContext ctx;

    @Autowired
    private BillServ billServ;

    @RequestMapping("/chrglsk")
    public String chrgLsk(@RequestParam(value="lsk", defaultValue="00000000") String lsk) {
    	Future<Result> res = null;
    	try {
    		res = billServ.chrgLsk(null, lsk);
		} catch (ErrorWhileChrg e) {
			return "ERROR";
		}
	   	//проверить окончание потока 
	    while (!res.isDone()) {
	         try {
				Thread.sleep(100);
				//100-millisecond задержка
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	     }
    	return "OK";
    }
    
    @RequestMapping("/chrgall")
    public String chrgAll() {
    	Future<Result> res = null;
    	try {
    		res = billServ.chrgAll();
		} catch (ErrorWhileChrg | InterruptedException e) {
			e.printStackTrace();
		}
    	
	   	//проверить окончание потока 
		 while (!res.isDone()) {
	         try {
				Thread.sleep(100);
				//100-millisecond задержка
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	     }
    	return "OK";
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