package com.direct.webflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
@Configuration
@EnableWebMvc*/
@EnableAutoConfiguration
@Controller
public class WebApp {
	
	ThreadDemo T1;
	
	@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
	
	@RequestMapping("/start")
    @ResponseBody
    String home(@RequestParam MultiValueMap<String, String> params) {
		Integer id = Integer.valueOf(params.get("id").get(0).toString());
        
    	if (T1 == null || T1.stopped) {
			T1= new ThreadDemo( "Thread-1 of "+String.valueOf(id));
	        T1.start();
	        try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        T1.interrupt();
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
        SpringApplication.run(WebApp.class, args);
    }
}
