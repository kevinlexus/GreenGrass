package com.direct.webflow;

import java.io.StringWriter;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greengrass.house.AnyApp;

/*
@Configuration
@EnableWebMvc*/
@EnableAutoConfiguration
@Controller
public class WebCtrl {

	static AnyApp app;	
	ThrMain T1;
	static SprGenItmDao sprg;
	
	@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
	
	
   @RequestMapping(value = "/getSprgenitm", method = RequestMethod.GET, produces="application/json")
   @ResponseBody
   public List<SprGenItm> getSprGenItm() {

	   return sprg.findAll();
	   
    }

   @RequestMapping(value = "/setSprgenitm", method = RequestMethod.POST, produces="application/json")
   @ResponseBody
   public List<SprGenItm> setSprGenItm() {

	   
    }

   
	@RequestMapping("/start")
    @ResponseBody
    String home(@RequestParam MultiValueMap<String, String> params) {
		Integer id = Integer.valueOf(params.get("id").get(0).toString());
        
    	if (T1 == null || T1.stopped) {
			T1= new ThrMain(app, "MAIN Thread-1 of "+String.valueOf(id));
	        T1.start();
    	} else {
    		return "Already started!";
    	}

    	return "Started thread!";
        
    }

	@RequestMapping("/end")
    @ResponseBody
    String home() {
    	if (T1 != null) {
	        T1.stopped=true;
            System.out.println("Trying to stop!");

	        return "Ended!";
    	} else {
    		return "Already ended!";
    	}
        
    }

	public static void main(String[] args) throws Exception {
	   app = new AnyApp(null);
 	   sprg = new SprGenItmDao(app);
	   /*for (SprGenItm spr : sprDao.findAll()) {
		   System.out.println("Name "+spr.getName());
		}*/

        SpringApplication.run(WebCtrl.class, args);
    }
}
