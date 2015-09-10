package testRestFul;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class GreenGrassRest {

    @RequestMapping("/test")
    public String test(@RequestParam(value="name", defaultValue="World") String name) {
	    //GcApp app = new GcApp();

	    String testStr = "Колбасная продукция!22222 test! ";
        GsonBuilder builder = new GsonBuilder();    
        Gson gson = builder.create();
        return gson.toJson(testStr);
    }
    
}