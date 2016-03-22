package com.greengrass.house;



public class GcApp extends AnyApp {

	public String dir1wire, diralarm;

	public void initObj(Obj obj, String slash) {
	//инициализация объекта
    System.out.println("Initialize object: "+obj.getCd());
	String cfg[]={"CONFIG1", "CONFIG2", "CONFIG3"};
		for (String s: (cfg)){
		if (obj.findProp(s)){
			ObjxProp p = obj.getProp(s); 
			//инициализировать, если есть такое свойство у объекта
			if (p != null){

				String fname=(p.getUsdiral() == 1 ? diralarm : dir1wire)+slash+obj.getOwfsCd()+slash+
		    			p.getOwfsCd();
				String propTp=p.getProperty().getTpCd();
		        switch (propTp) {
		          case "ST": 
				        writeFileLine(fname, obj.getStr(s));
		        	  break;
		          case "DB": 
		        	    writeFileLine(fname, obj.getDbl(s));
		              break;
		          case "IT": 
		        	    writeFileLine(fname, obj.getInt(s));
		              break;
		          case "BL": 
		        	    writeFileLine(fname, obj.getBool(s));
		              break;
		        }
				
				
	  	    }
		}
	}
	}

	public GcApp() throws GGException {
		//Вызвать конструктор супер класса
		super("GGC");

		beginTrans();
		session.update(mainObj); //update объекта необходим, так как сессия была закрыта, а объекты связаны используя FetchType.LAZY, здесь подробнее: http://javarevisited.blogspot.ru/2014/04/orghibernatelazyinitializationException-Could-not-initialize-proxy-no-session-hibernate-java.html
		session.update(appObj);

		//директории для 1-wire компонентов
		dir1wire = mainObj.getStr("DIR_FOR_1-WIRE");
		diralarm = mainObj.getStr("DIR_FOR_ALARM");
		commitTrans();

	}
	
	
}

