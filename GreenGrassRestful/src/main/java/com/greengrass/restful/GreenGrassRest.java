package com.greengrass.restful;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greengrass.house.GGException;
import com.greengrass.house.Obj;

@RestController
public class GreenGrassRest {

    @RequestMapping("/test")
    public String test(@RequestParam(value="name", defaultValue="World") String name) {
    	RestApp app = null;
    	try {
			app = new RestApp("GGE");
		} catch (GGException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
    	app.beginTrans();
		List<Obj> lobj = app.session.createQuery(
				"from Obj where cd not in ('GGE','GGH','GGV')").list(); 

	    //String testStr = "Колбасная продукция!22222 test! ";
        GsonBuilder builder = new GsonBuilder();    
        Gson gson = builder.create();
        return gson.toJson(lobj.toString());
    }
    
}