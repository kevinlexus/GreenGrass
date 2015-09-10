package com.greengrass.evhandler;

import java.util.List;

import com.greengrass.house.AnyApp;
import com.greengrass.house.EvQue;
import com.greengrass.house.GGException;
import com.greengrass.house.GreenController;
import com.greengrass.house.Obj;

public class GreenEvHandler {

	public static void main(String[] args) throws GGException {
		
//      Подавление логгинга hibernate (+ еще есть в pom.xml)		
		System.out.println("1");
 		@SuppressWarnings("unused")
	    org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
		System.out.println("2");
	    java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.WARNING); //or whatever level you need
		System.out.println("3");
	    
		//Создаётся объект -приложение содержащее параметры, базовые функции

	    EvApp app = new EvApp();
		System.out.println("4");
		app.messUrgnt("GGEvHanlder ver 1.2.1 started...");
		app.dbgLvl=2;
		
		//Очистить очередь голосовых сообщений
		app.beginTrans();
		app.clearEvents();
		app.commitTrans();
		
		//запустить в отдельном потоке обработчик голосовых событий
		new GreenEvVoice();
		System.out.println("5");
		
		//Загрузить в HashMap все объекты в квартире
		app.beginTrans();
		//подготовить объекты для binding, кроме объектов самих приложений (они байндятся отдельно, как другие типы объектов - App)
		List<Obj> lobj = app.session.createQuery(
				"from Obj where cd not in ('GGE','GGH','GGV')").list(); //в HQL надо писать from Obj вместо from t_obj 
		System.out.println("6");
		//один раз забайндить объекты в Groovy
		app.bindGroovy(lobj);
		//Выполнить загрузочный скрипт системы
		try {
			app.runGroovy("startup.groovy");
		} catch (Exception e1) {
			// Ошибка во время выполнения Groovy скрипта
			e1.printStackTrace();
		}
		app.commitTrans();
		System.out.println("7");
		//Цикл выполнения скрипта обработки событий 
		while (true) {
			//обновить объекты
	    	app.beginTrans();    		
			for(Obj o : lobj) { app.session.refresh(o); }
	
			//обработка событий скриптом
			try {
				app.runGroovy("work.groovy");
			} catch (Exception e1) {
				// Ошибка во время выполнения Groovy скрипта
				e1.printStackTrace();
			}
			app.commitTrans();
	
			app.beginTrans();
				//обработка событий, выполнение Job из t_evque
				List<EvQue> evl = app.session.createSQLQuery("select t.* from t_evque t where "
						+ " nvl(t.cancel,0)=0 and t.next_start > sysdate"
						).addEntity(EvQue.class).list();
	
		    	//ПОКА выключил!
/*				for (EvQue e : evl) {
			    	//app.bindEvent(e.getEvxObj().getObjxProp().getObj(), e);
					//app.runGroovy("test2.groovy");
			    	
					//Окончание выполненения GROOVY скрипта
				}*/
				
				app.commitTrans();
	
			    //задержка перед повтором
				try {
				    Thread.sleep(1000);
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
		}		
		
		
	}
	
	
}
