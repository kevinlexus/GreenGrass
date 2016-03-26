package com.direct.webflow;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableAutoConfiguration
@Controller
public class WebCtrl {

	ThrMain T1;
	
	@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
	
	
   @RequestMapping(value = "/getSprgenitm", method = RequestMethod.GET, produces="application/json")
   @ResponseBody
   public List<SprGenItm> getSprGenItm() {
	   return new SprGenItmDao().findAll();
    }

   @RequestMapping(value = "/editSprgenitm", method = RequestMethod.POST, produces="application/json", consumes="application/json")
   @ResponseBody
   public String editSprGenItm(@RequestBody List<SprGenItm> iList) { //использовать List объектов, со стороны ExtJs в Модели сделано allowSingle: false

 	   DSess ds = new DSess();
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
	   System.out.println("Object saved...");
	   return null;
    }

   
	@RequestMapping("/startGen")
    @ResponseBody
    String startGen() {
		
    	if (T1 == null || T1.stopped) {
   	  	   T1= new ThrMain(new SprGenItmDao().findAllChecked());
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
	        T1.stopped=true;
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
