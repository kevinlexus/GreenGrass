package com.greengrass.restful;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greengrass.house.GGException;
import com.greengrass.house.Obj;
import com.greengrass.house.ObjxProp;

@RestController
public class GreenGrassRest {

	int i=1;
	RestApp app = null;

	//конструктор
	public GreenGrassRest() {
    	try {
			app = new RestApp("GGE");
		} catch (GGException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/on")
    public void set(@RequestParam MultiValueMap<String, String> params){
		String cd=params.get("cd").get(0).toString();
		String val=params.get("val").get(0).toString();
		System.out.println("/on:"+cd);
		System.out.println("/on:"+val);
		if (cd.length()>0) {
			//Session sess = app.getSession();
			app.beginTrans();;
			Obj o=(Obj) app.session.bySimpleNaturalId(Obj.class).load(cd);
			if (val.equals("true")){
				o.on();
			} else if (val.equals("false")) {
				o.off();
			}
			app.commitTrans();
		}
		
    }
	
	@RequestMapping("/getobjects")
    public String getobject(@RequestParam(value="name", defaultValue="World") String name) {
	    
		System.out.println("/getobjects:start");
    	app.beginTrans();

    	//получить все объекты, которые можно включать, а так же, которые содержат температуру
        //Внимание! в HQL строго соблюдать соответствие getter-setter имени свойства, например Property property - getProperty, setProperty 
    	List<Obj> lobj = app.session.createQuery(
				"from Obj as o where cd not in ('GGE','GGH','GGV') "+
    			"and exists "+
                "(from ObjxProp as t where t.obj = o and t.property in (:par1,:par2)) "+
    			"order by o.tp "
    			).setString("par1", "SWITCHED_ON").setString("par2", "CELSIUS_VAL").list(); 
    	List<prepObj> lpObj= new ArrayList<prepObj>();
    	
    	//преобразовать объекты в другой тип, подготовленный для мобильного приложения
    	for (Obj o : lobj) {
    		prepObj p= new prepObj();
    		p.setCd(o.getCd());
    		p.setName(o.getName());
    		
    		if (o.getTp().equals("THERM")) {//если термометр
    			p.setProp("t° "+o.getDbl("CELSIUS_VAL").toString()+" C" );
    		} else { //прочие объекты, (выключатели)
        		p.setIsOn(o.is_on());
    		}
    		p.setTp(o.getTp());
    		lpObj.add(p);
    	}

    	app.commitTrans();
    	Gson gson = new Gson();
    	System.out.println("get rest:"+i);
    	i++;
		System.out.println("/getobjects:end");
        return gson.toJson(lpObj);
	}
    
}






//пока сохранить это
//отделяем объекты от сессии и удаляем свойство ObjxProp
/*for (Obj o : lobj) {
	app.session.evict(o); 
	o.setObjxProp(null);
}*/
