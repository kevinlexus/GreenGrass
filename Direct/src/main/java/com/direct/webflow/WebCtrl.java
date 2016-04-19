package com.direct.webflow;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableAutoConfiguration
@Controller
public class WebCtrl {

	ThrMain T1;
	static String stateGen;//Состояние формирования 0-Выполнено успешно, 1-Формируется, 2-выход, с ошибкой
	static int progressGen=0;//Прогресс формирования от 0 и до кол-во итераций
	
   static void incProgress(){
	   progressGen++;
   }
   
   @RequestMapping(value = "/getSprgenitm", method = RequestMethod.GET, produces="application/json")
   @ResponseBody
   public List<SprGenItm> getSprGenItm() {
	   return new SprGenItmDao().findAll();
    }

   @RequestMapping(value = "/getPrepErr", method = RequestMethod.GET, produces="application/json")
   @ResponseBody
   public List<PrepErr> getPrepErr() {
	   return new PrepErrDao().findAll();
    }


   /*
    * Вернуть статус текущего формирования
    */
   @RequestMapping(value = "/getStateGen", method = RequestMethod.GET)
   @ResponseBody
   public String getStateGen() {
 	   
	   return stateGen;
    }

   /*
    * Вернуть прогресс текущего формирования, для обновления грида у клиента
    */
   @RequestMapping(value = "/getProgress", method = RequestMethod.GET)
   @ResponseBody
   public int getProgress() {
 	   
	   return progressGen;
    }
   
   /*
    * Проверить состояние пунктов меню
    */
   @RequestMapping(value = "/checkItms", method = RequestMethod.POST)
   @ResponseBody
   public String checkItms(@RequestParam(value="id") int id, @RequestParam(value="sel") int sel) {
 	   DSess ds = new DSess(false);
	   ExecProc ex =new ExecProc(ds);
	   ds.beginTrans();
 	   ex.runWork(35, id, sel);
	   ds.commitTrans();
	   System.out.println("/checkItms?id="+id);
	   
	   return null;
    }   
   
   /*
    * Вернуть ошибку, последнего формирования, если есть
    */
   @RequestMapping(value = "/getErrGen", method = RequestMethod.GET)
   @ResponseBody
   public String getErrGen() {
 	   
	    SprGenItmDao sprgDao = new SprGenItmDao();
	    SprGenItm menuGenItg;
		menuGenItg = sprgDao.getByCd("GEN_ITG");
		
	   return String.valueOf(menuGenItg.getErr());
    }
   
   @RequestMapping(value = "/editSprgenitm", method = RequestMethod.POST, produces="application/json", consumes="application/json")
   @ResponseBody
   public String editSprGenItm(@RequestBody List<SprGenItm> iList) { //использовать List объектов, со стороны ExtJs в Модели сделано allowSingle: false

 	   DSess ds = new DSess(false);
	   ds.beginTrans();
	   for (SprGenItm itm : iList) {
		   SprGenItm i= (SprGenItm)ds.sess.load(SprGenItm.class, itm.getId());
		   if (itm.getSel() !=null) { 
			    i.setSel(itm.getSel());
			   };
		   if (itm.getName() !=null) { 
			   i.setName(itm.getName());
		   }
       }
	   
	   ds.commitTrans();
	   System.out.println("/editSprgenitm");
	   return null;
    }

   
	@RequestMapping("/startGen")
    @ResponseBody
    String startGen() {
		
		if (T1 == null || T1.isStopped()) {
		   // Запустить в потоке, чтобы не тормозило request
   	  	   T1= new ThrMain();
   	  	   T1.start();
    	} else {
           System.out.println("Already started!");
    	   return "Already started!";
    	}

        System.out.println("Started thread!");
    	return "Started thread!";
        
    }

	@RequestMapping("/stopGen")
    @ResponseBody
    String stopGen() {
    	if (T1 != null) {
	        T1.setStopped(true);
            System.out.println("Trying to stop!");

	        return "Ended!";
    	} else {
            System.out.println("Already ended!");
    		return "Already ended!";
    	}
        
    }

	public static void main(String[] args) throws Exception {
	   
        SpringApplication.run(WebCtrl.class, args);
    }
}
