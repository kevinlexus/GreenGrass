package com.greengrass.house;

//import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javassist.bytecode.Descriptor.Iterator;
import oracle.net.aso.e;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class GreenController {

	
	public static void main(String[] args) {
		System.out.println("Green Grass started!");
		//Hibernate
		
		App app = new App();
		System.out.println("Searching directory:"+app.dir1wire);
		
		//Поиск объектов, необходимых для актуализации значений
		List<Obj> lobj = app.session.createSQLQuery(
				"select {t.*} from t_obj t, t_objxprop x, t_prop p "+
				"where t.id=x.fk_obj and p.id=x.fk_prop "
				+ "and p.cd='UPDATABLE_BY_GG_HOUSE' "
				+ "and x.i1=1"
						).addEntity("t", Obj.class).list(); // 
		
		Obj obj = new Obj();
		java.util.Iterator<Obj> it = lobj.iterator();
		//основной цикл по объектам
		int i=1;
		while (it.hasNext()){
			i++;
			obj=it.next();
	        app.session.beginTransaction();
       	    System.out.println("val:"+obj.getName());
       	    System.out.println("val:"+obj.getOwfsCd());

       	    List<String> lines = null;
       	    String fname = app.dir1wire+"\\"+obj.getOwfsCd()+"\\"+
	        		obj.getObjxPropByCd("LAST_READOUT").getOwfsCd();
       	    try { 
	       	    lines = Files.readAllLines(Paths.get(fname),
	       		    StandardCharsets.UTF_8);

       	    } catch (IOException e){
    	        System.out.println("Can't read file "+fname);
    	        return;
       	    }
       	    System.out.println("Строка из файла:"+lines.get(0));

       	    obj.setObjxPropNumByCd("LAST_READOUT", 111222.54+i);
	        System.out.println(obj.getObjxPropNumByCd("LAST_READOUT"));
	        
			app.session.save(obj);
			app.session.getTransaction().commit();
		}
			
			
		       
        
/*        for (Obj[] lobj2 : lobj) {
	        for (Obj entityCol : lobj2) {
	            System.out.print(" " + entityCol);
	        }
	        System.out.println("TEST");
	    }*/
		//Obj obj = new Obj();
	    /*
		for(ListIterator<Obj> it=(ListIterator<Obj>) lobj.iterator(); it.hasNext();)
		{
		 obj=it.next();
    	 System.out.println("val:"+obj.getObjxPropBoolByCd("SWITCHED_ON"));
		}
*/
	
		//obj = (Obj) app.session.bySimpleNaturalId(Obj.class).load("KITCHEN_SWITCH1");
		/*System.out.println("val:"+obj.getObjxPropBoolByCd("SWITCHED_ON"));
		obj.setObjxPropBoolByCd("SWITCHED_ON", true);
		System.out.println("val:"+obj.getObjxPropBoolByCd("SWITCHED_ON"));
		*/
		/*app.session.beginTransaction();
		app.session.save(obj);
	 
		app.session.getTransaction().commit();
	    */
		
		//Hibernate
		
		
		System.out.println("Green Grass ended!");
		
	}

}
