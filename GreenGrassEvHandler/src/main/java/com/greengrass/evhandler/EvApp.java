package com.greengrass.evhandler;

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;

import java.io.IOException;
import java.sql.CallableStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.persistence.Transient;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;

import com.greengrass.house.AnyApp;
import com.greengrass.house.EvQue;
import com.greengrass.house.GGException;
import com.greengrass.house.HibernateUtil;
import com.greengrass.house.Obj;
import com.greengrass.house.RowSet;

public class EvApp extends AnyApp {

//	private GroovyShell shell; ???
	private GroovyScriptEngine gse;
	private Binding binding;
	
    //забайндить переменные для Groovy
/*	public void bindGroovy (HashMap<Integer, Obj> mapobj) {
		//забайндить загруженные объекты
		for (Entry<Integer, Obj> entry : mapobj.entrySet()) {
	    	binding.setVariable(entry.getValue().getCd(), entry.getValue());
		}
	}*/

    //забайндить переменные для Groovy
	public void bindGroovy (List<Obj> lobj) {
		//забайндить само приложение, как другой тип объекта
		binding.setVariable(this.appCd, this);

		//забайндить загруженные объекты
		for ( Obj obj : (List<Obj>) lobj ) {
			binding.setVariable(obj.getCd(), obj);
		}
	}

	//забайндить переменные для Groovy
		public void bindEvent (Obj obj, EvQue e) {
			//забайндить объект+событие, которое произошло по нему
	    	binding.setVariable("o", obj);
	    	binding.setVariable("e", e);
		}
		
		//выполнить скрипт Groovy
	public void runGroovy (String fileGrv) {
		try {
			gse.run(fileGrv, binding);
		} catch (ResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(binding.getVariable("x"));
	}

	//очистить очередь событий
	public void clearEvents() {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Query query = s.createSQLQuery(
				"CALL p_event.clear_events()");
		int exRows = query.executeUpdate();		 
	}

	//отменить очередь событий
	public void cancelEvents() {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Query query = s.createSQLQuery(
				"CALL p_event.cancel_events()");
		int exRows = query.executeUpdate();		 
	}

	//Обертка: Создать событие(сообщение, работу) в адрес объекта (обычно модуля) без маркера
	public void crEvent(
			String speech,  
			int timeout, 
			int maxCnt, 
			String toObj, 
			String preSound, //звук, предворяющий сообщение
			int alarm, //режим тревоги (0-нет,1-да) (когда игнорируется, какая зона должна звучать, другой сигнал)
			String...arg//Аргументы к Яндекс сервису
			) { 
		crEvent("", speech, timeout, maxCnt, toObj, preSound, alarm, arg);
	}

	//Создать событие(сообщение, работу) в адрес объекта (обычно модуля) с маркером
	public void crEvent(
			String mark,  
			String speech,  
			int timeout, 
			int maxCnt, 
			String toObj, 
			String preSound, //звук, предворяющий сообщение
			int alarm, //режим тревоги (0-нет,1-да) (когда игнорируется, какая зона должна звучать, другой сигнал)
			String...arg//Аргументы к Яндекс сервису
			) { 
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Query query = s.createSQLQuery(
				"CALL p_event.cr_event(:p_mark, :p_speech, :p_tm, :p_cd_to_obj, :p_presound, :p_alarm,  :p_arg)")
				.setParameter("p_mark", mark)
				.setParameter("p_speech", speech)
				.setParameter("p_tm", timeout)
				.setParameter("p_cd_to_obj", toObj)
				.setParameter("p_presound", preSound)
				.setParameter("p_alarm", alarm)
				.setParameter("p_arg", (arg.length > 0 ? arg[0] : null));
		int exRows = query.executeUpdate();		 
	}

	//Обработать событие - убрал пока
	/*public void procEvent(int evque) {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Query query = s.createSQLQuery(
				"CALL p_event.proc_event(:p_evque)")
				.setParameter("p_evque", evque);
		int exRows = query.executeUpdate();		 
	}*/
	
	//Обработать расписание
	public void procScheduler() {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Query query = s.createSQLQuery(
				"CALL p_event.proc_schdl()");
		int exRows = query.executeUpdate();		 
	}

	//получить наиболее горячий термометр
	public String getMostHotTherm() {
		Query query = this.session.createSQLQuery(
				"select a.cd, a.id from ( "+
				"select o.cd, o.id from t_objxprop x, t_obj o "+ 
				"where o.id=x.fk_obj and o.fk_tp='THERM' and x.fk_prop='CELSIUS_VAL' "+
			    "order by x.n1 desc) a where rownum=1" 
						).addScalar("cd", StandardBasicTypes.STRING)
						.addScalar("id", StandardBasicTypes.INTEGER);
		//Загрузить в HashMap все свойства
		List<Object[]> rs = query.list(); 
		String objCd=null;
		for (Object[] row : rs) {
			objCd=(String)row[0];
		}
		return objCd;
	}
	
	//получить наиболее холодный термометр
	public String getMostCoolTherm() {
		Query query = this.session.createSQLQuery(
				"select a.cd, a.id from ( "+
				"select o.cd, o.id from t_objxprop x, t_obj o "+ 
				"where o.id=x.fk_obj and o.fk_tp='THERM' and x.fk_prop='CELSIUS_VAL' "+
			    "order by x.n1) a where rownum=1" 
						).addScalar("cd", StandardBasicTypes.STRING)
						.addScalar("id", StandardBasicTypes.INTEGER);
		//Загрузить в HashMap все свойства
		List<Object[]> rs = query.list(); 
		String objCd=null;
		for (Object[] row : rs) {
			objCd=(String)row[0];
		}
		return objCd;
	}


	public EvApp() throws GGException {
		//Вызвать конструктор абстрактного класса
		super("GGE");
		System.out.println("3.1");

		beginTrans();
		System.out.println("3.2");
		session.update(mainObj); //update объекта необходим, так как сессия была закрыта, а объекты связаны используя FetchType.LAZY, здесь подробнее: http://javarevisited.blogspot.ru/2014/04/orghibernatelazyinitializationException-Could-not-initialize-proxy-no-session-hibernate-java.html
		System.out.println("3.3");
		session.update(appObj);
		System.out.println("3.4");
		commitTrans();
		
		binding = new Binding();
		System.out.println("3.5");
		//shell = new GroovyShell(binding);   ?????
		String[] roots = new String[] { "C:\\work\\git\\GreenGrassHouse\\groovy" };
		try {
			gse = new GroovyScriptEngine(roots);
		} catch (IOException e) {
			mess("Error: Cannot load root dir "+roots);
		}		
		System.out.println("3.6");
		
	}
	

}
