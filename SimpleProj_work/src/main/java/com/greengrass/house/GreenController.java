package com.greengrass.house;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.type.StandardBasicTypes;

public class GreenController {

	
	public static void main(String[] args) throws GGException {
		
//      Подавление логгинга hibernate (+ еще есть в pom.xml)		
		System.out.println("1");
		@SuppressWarnings("unused")
	    org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
	    java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.WARNING); //or whatever level you need

	    String fname, fdir=null;
		//Создаётся объект -приложение содержащее параметры, базовые функции
		System.out.println("2");
	    GcApp app = new GcApp();
		System.out.println("3");
		app.dbgLvl=2;
		app.messUrgnt("GGController ver 1.2.1 started...");
		app.mess("Searching directory:"+app.dir1wire);

		//Поиск свойств объектов, необходимых для актуализации значений

		app.beginTrans();
		Query query = app.session.createSQLQuery(
				"select t.id, t.owfs_cd as owcd, p.id as propid, d.owfs_cd as propowcd, p.tp_cd as proptp, "
				+ "d.upd_tp as propupdtp, "
			    + "case when lead(t.id, 1) over (order by t.id, d.fk_prop) = t.id " //если следующий объект - тот же и такое же свойство, то не делать latch.0=0
			    + "and lead(d.fk_prop, 1) over (order by t.id, d.fk_prop) = d.fk_prop then 0 else 1 end as lead, "  
				+ "d.acc_tmo as acctmo, "//тайм-аут доступа к свойству, в мс.
				+ "d.use_dir_alrm as usdiral, "
				+ "d.prep, d.fk_prop as prop, "
				+ "nvl(d.dbg_lvl,0) as dbglvl, "
				+ "d.rst_val as rstval "
				+ "from t_obj t, t_objxprop d, t_prop p "
				+ "where t.id=d.fk_obj and d.fk_prop=p.id "
				+ "and d.owfs_cd is not null "
//				+ "and t.id=410 "
				+ "and d.upd_tp in ('UPD_TO_GGH','UPD_FROM_GGH') "
 				+ "order by t.id, d.fk_prop " //Важна сортировка order by t.id, так как в конце цикла делаем latch.0=0 (если объект latch) 
				+ " "
						).addScalar("id", StandardBasicTypes.INTEGER)
						.addScalar("owcd", StandardBasicTypes.STRING)
						.addScalar("propid", StandardBasicTypes.STRING)
						.addScalar("propowcd", StandardBasicTypes.STRING)
						.addScalar("proptp", StandardBasicTypes.STRING)
						.addScalar("propupdtp", StandardBasicTypes.STRING) 
						.addScalar("lead", StandardBasicTypes.INTEGER)
						.addScalar("acctmo", StandardBasicTypes.INTEGER) 
						.addScalar("usdiral", StandardBasicTypes.INTEGER) 
						.addScalar("prep", StandardBasicTypes.INTEGER) 
						.addScalar("prop", StandardBasicTypes.STRING) 
						.addScalar("dbglvl", StandardBasicTypes.INTEGER) 
						.addScalar("rstval", StandardBasicTypes.STRING);
		//Загрузить в HashMap все свойства
		List<Object[]> rs = query.list(); 
		ObjSet objs = new ObjSet();
		app.commitTrans();
    	int unload=1; //первый старт программы, принудительно задать выгрузку "UPD_FROM_GGH" объектов
    	int sleep=1; //счетчик таймера установки флага unload 
		//основной цикл 
		while (true) {
		//цикл по объектам+свойствам, установка значений
		app.beginTrans();
    	List<Integer> lstObjId= new ArrayList<Integer>();
    	Boolean rstLatch=false; //для использования свойствами-защёлками (которые в директории alarm) (сбросить Latch)
    	int i=0;
		for (Object[] row : rs) {
	    	Integer objId = (Integer)row[0];
	    	String objOwCd = (String) row[1];
	    	String propId = (String) row[2];
	    	String propOwCd = (String) row[3];
	    	String propTp = (String) row[4];
	    	String propUpdTp = (String) row[5];
	    	Integer lead = (Integer) row[6];
	    	Integer acctmo = (Integer) row[7];
	    	Integer usdiral = (Integer) row[8];
	    	Integer prep = (Integer) row[9];
	    	String prop = (String) row[10];
	    	Integer dbgLvl = (Integer) row[11];
	    	String rstVal = (String) row[12];
	    	if (acctmo==null){ //если не установлен таймаут, присвоить равным = 1с.
	    		acctmo=1000;
	    	}
	    	if (objs.mapobj.get(objId)==null) {
	    		//mapobj.put(objId, null);
	    		//Загрузить объект в Map
	    		Obj obj = new Obj();
	    		objs.mapobj.put(objId, obj);
	    		app.session.load(obj, objId);
	    		//инициализация электронной составляющей объекта
	    		app.initObj(obj, app.slash);
	    	}
	    	//удобная ссылка на текущий Объект
	    	Obj o=objs.mapobj.get(objId);

	    	Date curd=new Date(System.currentTimeMillis());
	    	Date accd=o.getProp(propId).getNextAcc();
			//Если время следущего доступа к свойству истекло, либо пусто, то... (неперсистентное свойство)
	    	if ((accd==null) || ((curd.compareTo(accd)) > 0)) {
	    		o.getProp(propId).setNextAcc(new Date(System.currentTimeMillis()+acctmo));
	    		//обновить объект из базы, если он еще не обновлен 
	    		if (lstObjId.indexOf(objId)==-1){
	    			lstObjId.add(objId);
	       	        app.session.refresh(objs.mapobj.get(objId));
	    		}
		    	if (app.isEquals(propUpdTp, "UPD_TO_GGH")) {
			    	//Читать значения из файла, записать в базу
		    		String ln=null,lnChk=null; //первое и контрольное значение
		    		if (usdiral == 1) { //узнать наличие директории устройства в alarm
			    		fdir=(usdiral == 1 ? app.diralarm : app.dir1wire);
			    		fname=o.getOwfsCd();
			    		if (app.existDirByPart(fdir, fname+"*")) { //если есть директория, читаем файл "*"-обязательно (ищет её по маске), - иначе прямой доступ к owfs и находит директорию в любом случае - грузит 1-wire сеть!!!
			    			//app.mess("DIR EXISTS! "+fdir+fname);
			        	    rstLatch=true; //установить rstLatch, для свойства-защёлки, если только значение было не null
			    			fname=fdir+app.slash+fname+app.slash+propOwCd; //есть директория!
				    		ln=app.readFileLine(fname);    //Основное чтение

				    		if (prop.equals("COUNTED")) {  //Контрольное чтение (некоторые файлы из owfs считываются неуверенно), пока только свойство "COUNTED"
				    		lnChk=app.readFileLine(fname);

				    		//ПРОВЕРКА!!!!!!!!!! УБРАТЬ ПОТОМ!!!
				    		if (dbgLvl !=0) {
					        	  app.mess("LOG1: fname="+fname, dbgLvl);
					        	  app.mess("LOG1: Obj="+o.getCd()+" prop="+prop+", ln="+ln, dbgLvl);
					        	  app.mess("LOG2: Obj="+o.getCd()+" prop="+prop+", ln="+lnChk, dbgLvl);
				    			
				    		}
				    		//ПРОВЕРКА!!!!!!!!!! УБРАТЬ ПОТОМ!!!

				    		if (!app.isEquals(ln, lnChk)) { 
				    			//Контрольное чтение показало, что файл прочитался по другому, отказаться от обработки
			        	        app.mess("ERROR WHILE READING: Obj="+o.getCd()+" prop="+prop+", ln="+lnChk, dbgLvl);
				    			continue;
				    		}
				    		}

			    		}
		    		} else { //узнать не через дир. alarm, там всегда должен быть файл)) 
			    		fname=app.dir1wire +app.slash+o.getOwfsCd()+app.slash+propOwCd;
					 try {   		
		      	        ln=app.readFileLine(fname);
					 } catch (IndexOutOfBoundsException ex) {
						//если пустая строка в файле
						ln=null; 
		    	     }
		    		}
		    		
//			    	try {
				        switch (propTp) {
				          case "ST": 
				        	  //Записать только изменённое значение
					          //если поле нуждается в подготовке и файл отсутствует, то записать значение по умолчанию
				        	  String tmp_ln=ln;
				        	  if (ln==null && prep==1) {
					        	tmp_ln=rstVal;
					          } else if (ln!=null && prep==1) {
						        	tmp_ln=ln.replaceAll(",", "");
					          }
				        	  if (!app.isEquals(o.getStr(propId), tmp_ln)){ //здесь используется вспомогательная функция, если приживётся, использовать её в других типах свойств
					        	  o.setStr(propId, tmp_ln);
					        	  app.mess("Sent to GGH: obj="+o.getCd()+" prop="+prop+", val="+tmp_ln, dbgLvl);
				        	  }
				              break;
				          case "DB": 
				        	  //Записать только изменённое значение
				        	  if (!app.isEquals(o.getDbl(propId), (ln==null ? null : Double.parseDouble(ln)))){
				        		  Double dd;
				        		  if (ln!=null) {
 					        	    dd=Double.parseDouble(ln); //как то не совсем понял, почему выше Double.parseDouble(ln) не ругается, а здесь ругался, пришлось переписать... 
				        		  } else {
				        			dd=(Double) null;  
				        		  }
					        	  o.setDbl(propId, dd);
					        	  app.mess("Sent to GGH: obj="+o.getCd()+" prop="+prop+", val="+ln, dbgLvl);
				        	  }
				              break;
				          case "IT": 
				        	  //Записать только изменённое значение
				        	  Integer tmp_i=0;
				        	  if (ln==null) {
					        	tmp_i=0;
					          } else {
					        	  tmp_i=Integer.parseInt(ln);
					          }
				        	  if (!prop.equals("COUNTED") || (prop.equals("COUNTED") && ln !=null)) { //либо свойство не COUNTED либо оно и не пустое!
				        		  if (!app.isEquals(o.getInt(propId), tmp_i)){
					        	  o.setInt(propId, tmp_i);
					        	  app.mess("Sent to GGH: obj="+o.getCd()+" prop="+prop+", val="+tmp_i, dbgLvl);
				        	  }}
				              break;
				          case "BL": 
				        	  //Записать только изменённое значение
				        	  if (o.getBool(propId) !=(ln.equals("1") ? true : false)){
					        	  o.setBool(propId, (ln.equals("1") ? true : false) );
					        	  app.mess("Sent to GGH: obj="+o.getCd()+" prop="+prop+", val="+ln, dbgLvl);
				        	  } 
				              break;
				        }
//			        	} catch (NumberFormatException ex) {
			        		//app.mess("GGH ERROR incorrect value from file: "+fname);
			        	//}
			  	       	//проверить, если значение хоть одно из ствойств-зашёлок изменено и следующий объект другой, то закрыть чтение latсh.0=0
			        	if ((rstLatch) && (lead==1)) {
					    	fname=app.dir1wire+app.slash+o.getOwfsCd()+app.slash+"latch.0";
					    	app.writeFileLine(fname, "0");
					    	app.mess("Object, property:"+fname, dbgLvl);
			           	    rstLatch=false; //сбросить флаг, для следующих объектов
			        	}
					//app.session.save(objs.mapobj.get(objId));
					app.session.save(o);
		    	} else if (app.isEquals(propUpdTp, "UPD_FROM_GGH") && 
		    			(o.getProp(propId).getUpd1()==0 /*только те, которые не обновлены GGH*/ || unload==1/* либо первый старт программы*/))
		    			{
			    		//Читать значения из базы, записать в файл
				    	fname=app.dir1wire+app.slash+o.getOwfsCd()+app.slash+
			        		propOwCd;
			    		Object val=null;
				        switch (propTp) {
				          case "ST": 
				        	  val=o.getStr(propId);
				              break;
				          case "DB": 
				        	  val=o.getDbl(propId);
				              break;
				          case "IT": 
				        	  val=o.getInt(propId);
				              break;
				          case "BL": 
				        	  val=(o.getBool(propId)==true ? 1: 0);
				        	  //инвертировать значение, если надо 
				        	  if (o.getInvOut(propId)) {
				        		  if (val.equals(1)) {
				        			val=0;  
				        		  } else {
				        			val=1;  
				        		  }
				        	  } 
				              break;
				        }
	    	            app.writeFileLine(fname, val);
	    	            //--Сделать отметку об обновлении свойства в файл OWFS контроллером GGHouse
	    	            //objs.mapobj.get(objId).getProp(propId).setUpd1(1);
	    	            o.getProp(propId).setUpd1(1);
		        	    app.session.save(o);
		        	    app.session.flush();
		        	    //app.mess("Sent from GGH: obj="+o.getCd()+" prop="+prop+", val="+val, dbgLvl);

		        	    //Обновить entity - нужно ли, если потом делается refresh?
		        	    //app.session.update(mapobj.get(objId));
		        	    
		    	}
	    	}

    	
	    }
	    
		unload=0;//сбрасываем флаг выгрузки "UPD_FROM_GGH" объектов (чтобы бесконечно не обновлять в owfs параметры свойств типа "UPD_FROM_GGH"
		app.commitTrans();
		
		//задержка перед повтором
		try {
		    Thread.sleep(500); //0.5 секунды
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		sleep=sleep+1;
		if (sleep>10){ //каждые 5 секунд сделать выгрузку "UPD_FROM_GGH" объектов (некоторые микросхемы 1-wire могут сбрасывать текущие значения
		  unload=1;	
		  sleep=1;
		}
		
		}
		
	}

}
