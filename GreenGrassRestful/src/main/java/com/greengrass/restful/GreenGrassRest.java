package com.greengrass.restful;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;
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

	RestApp app = null;
	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	int a = 0;
	//Gson gson = new Gson();
	
	Integer id; //Id объекта
	// конструктор
	public GreenGrassRest() {
		try {
			app = new RestApp("GGE");
		} catch (GGException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/on")
	public void on(@RequestParam MultiValueMap<String, String> params) {
		id = Integer.valueOf(params.get("id").get(0).toString());
		String val = params.get("val").get(0).toString();
		System.out.println("/on:" + id);
		System.out.println("/on:" + val);
		if (id != 0) {
			// Session sess = app.getSession();
			Session sess = app.getSession();
			sess.beginTransaction();

			ObjxProp o = (ObjxProp) sess.load(ObjxProp.class, id);
			if (val.equals("1")) {
				o.setI1(1);
			} else {
				o.setI1(0);
			}
			sess.getTransaction().commit();
		}

	}

//	, 'GRAPH_MIN_VAL', 'GRAPH_MAX_VAL'

	@RequestMapping("/getarch")
	public String getarch(@RequestParam MultiValueMap<String, String> params) {
//		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create(); //здесь собственный билдер, из за даты
		id = Integer.valueOf(params.get("id").get(0).toString());
		System.out.println("/getarch:" + id);
		List<prepArch> lpArch = new ArrayList<prepArch>();
		Session sess = app.getSession();
		sess.beginTransaction();
		// получить список показателей, для построения графика
		Query query = sess
				.createSQLQuery(
						"select max(a.ts) as ts, /*max(to_char(a.ts,'DD.MM.YYYY HH24:MI')) as ts, */ "
								+ "round(max(a.n1),1) as n1  "
								+ "from a_objxprop a, T_OBJXPROP t "
								+ "where t.id=a.fk_prop_id "
								+ "and t.fk_prop in ('CELSIUS_VAL', 'LAST_NMIN_VOL') "
								+ "and t.id=:id  "
								+ "and a.ts>=sysdate-1 "
								+ "group by to_char(a.ts + 1/(24*6) - mod(a.ts - trunc(a.ts),1/(24*6)), 'DD.MM.YYYY HH24:MI') /*- округление до 5 минут*/ "
								+ "order by max(a.ts)"
								)
				.addScalar("ts", StandardBasicTypes.TIMESTAMP)
				.addScalar("n1", StandardBasicTypes.DOUBLE)
				.setParameter("id", id);
		// Загрузить в HashMap все свойства
		List<Object[]> rs = query.list();
		// Жалуется на commitTrans, что nested transaction не
		// поддерживается, получаем новую сессию для каждого вызова
		sess.getTransaction().commit();
		for (Object[] row : rs) {
			Date ts = (Date) row[0];
			Double n1 = (Double) row[1];

			// преобразовать строки в другой тип, подготовленный
			// для мобильного приложения
			prepArch p = new prepArch();

			Locale locale = new Locale("ru");
			Format formatter = new SimpleDateFormat("E,dd HH:mm", locale);
			String s = formatter.format(ts);
			
			p.setTs(s);
			p.setN1(n1);
			lpArch.add(p);
		}
		return gson.toJson(lpArch);

	}
	
	
	@RequestMapping("/getpage")
	public String getpage(@RequestParam(value = "page") String page) {
		List<prepObjProp> lpObj = new ArrayList<prepObjProp>();
		//gson= new Gson();
		a++;
		System.out.println("a:" + a);
		System.out.println("/getpage:" + page);

		switch (page) {
		case "PAGE1":
		case "PAGE2": {
			System.out.println("select page:" + page);
			// получить все необходимые свойства объектов
			// app.beginTrans();
			Session sess = app.getSession();
			sess.beginTransaction();
			Query query = sess
					.createSQLQuery(
							"select x.id, o.name as obj_name, p.name as prop_name, x.n1, x.i1, x.s1, x.d1, "
							        + "p.tp_cd as prop_tp, o.fk_tp as obj_tp, x.fk_prop as prop_id, x2.n1 as minval, x3.n1 as maxval "
									+ "from t_pgxop t join t_obj pg on t.fk_obj=pg.id and pg.cd=:cd "
									+ "join t_objxprop x on t.fk_objxprop = x.id "
									+ "join t_obj o on o.id = x.fk_obj "
									+ "join t_prop p on x.fk_prop = p.id "
									+ "left join t_objxprop x2 on x2.fk_obj=o.id and x2.fk_prop='GRAPH_MIN_VAL' "
									+ "left join t_objxprop x3 on x3.fk_obj=o.id and x3.fk_prop='GRAPH_MAX_VAL' "
									+ "order by t.npp")
					.addScalar("id", StandardBasicTypes.INTEGER)
					.addScalar("obj_name", StandardBasicTypes.STRING)
					.addScalar("prop_name", StandardBasicTypes.STRING)
					.addScalar("n1", StandardBasicTypes.DOUBLE)
					.addScalar("i1", StandardBasicTypes.INTEGER)
					.addScalar("s1", StandardBasicTypes.STRING)
					.addScalar("d1", StandardBasicTypes.DATE)
					.addScalar("prop_tp", StandardBasicTypes.STRING)
					.addScalar("obj_tp", StandardBasicTypes.STRING)
					.addScalar("prop_id", StandardBasicTypes.STRING)
					.addScalar("minval", StandardBasicTypes.DOUBLE)
					.addScalar("maxval", StandardBasicTypes.DOUBLE)
					.setParameter("cd", page);

			// Загрузить в HashMap все свойства
			List<Object[]> rs = query.list();
			// Жалуется на commitTrans, что nested transaction не
			// поддерживается, получаем новую сессию для каждого вызова
			// app.commitTrans();
			sess.getTransaction().commit();
			for (Object[] row : rs) {
				Integer id = (Integer) row[0];
				String objName = (String) row[1];
				String propName = (String) row[2];
				Double n1 = (Double) row[3];
				Integer i1 = (Integer) row[4];
				String s1 = (String) row[5];
				Date d1 = (Date) row[6];
				String propTp = (String) row[7];
				String objTp = (String) row[8];
				String propId = (String) row[9];
				Double minval = (Double) row[10];
				Double maxval = (Double) row[11];

				// преобразовать свойства объектов в другой тип, подготовленный
				// для мобильного приложения
				prepObjProp p = new prepObjProp();
				p.setId(id);
				p.setObjName(objName);
				p.setPropName(propName);

				// if (objTp.equals("THERM") && n1 !=null) {//если термометр
				// p.setProp("t° "+n1.toString()+" C" );

				p.setI1(i1);
				p.setN1(n1);
				p.setS1(s1);
				p.setD1(d1);
				p.setPropTp(propTp);
				p.setPropId(propId);
				p.setObjTp(objTp);
				p.setMinval(minval);
				p.setMaxval(maxval);
				lpObj.add(p);

			}

			return gson.toJson(lpObj);

		}
		case "PAGE3": {
			System.out.println("select page:" + page);
			// получить список произошедших событий
			List<prepEvent> lpEvent = new ArrayList<prepEvent>();
			Session sess = app.getSession();
			sess.beginTransaction();
			Query query = sess
					.createSQLQuery(
							"select t.id, t.ts, t.speech from T_EVQUE t "
									+ "order by t.id desc")
					.addScalar("id", StandardBasicTypes.INTEGER)
					.addScalar("ts", StandardBasicTypes.TIMESTAMP)
					.addScalar("speech", StandardBasicTypes.STRING);
			// Загрузить в HashMap все свойства
			List<Object[]> rs = query.list();
			// Жалуется на commitTrans, что nested transaction не
			// поддерживается, получаем новую сессию для каждого вызова
			sess.getTransaction().commit();
			for (Object[] row : rs) {
				Integer id = (Integer) row[0];
				Date ts = (Date) row[1];
				String speech = (String) row[2];

				// преобразовать строки событий в другой тип, подготовленный для
				// мобильного приложения
				prepEvent p = new prepEvent();
				p.setId(id);
				p.setSpeech(speech);
				p.setTs(ts);
				lpEvent.add(p);
			}

			return gson.toJson(lpEvent);

		}
		case "PAGE4": {
			System.out.println("select page:" + page);
			// получить список счетчиков с показаниями
			List<prepMet> lpMet = new ArrayList<prepMet>();
			Session sess = app.getSession();
			sess.beginTransaction();

			Query query = sess
					.createSQLQuery(
							"select x.id as id, x.fk_prop as prop_id, o.id as obj_id, o.name as obj_name, x.n1 from t_objxprop x, t_obj o "
									+ "where x.fk_obj=o.id "
									+ "and o.fk_tp='METER' and x.fk_prop='CUR_VALUE' "
									+ "order by o.cd")
					.addScalar("id", StandardBasicTypes.INTEGER)
					.addScalar("prop_id", StandardBasicTypes.STRING)
					.addScalar("obj_id", StandardBasicTypes.INTEGER)
					.addScalar("obj_name", StandardBasicTypes.STRING)
					.addScalar("n1", StandardBasicTypes.DOUBLE);
			// Загрузить в HashMap все свойства
			List<Object[]> rs = query.list();
			// Жалуется на commitTrans, что nested transaction не
			// поддерживается, получаем новую сессию для каждого вызова
			sess.getTransaction().commit();
			for (Object[] row : rs) {
				Integer id = (Integer) row[0];
				String propId = (String) row[1];
				Integer objId = (Integer) row[2];
				String objName = (String) row[3];
				Double n1 = (Double) row[4];

				// преобразовать строки счетчиков в другой тип, подготовленный
				// для мобильного приложения
				prepMet p = new prepMet();
				p.setId(id);
				p.setPropId(propId);
				p.setObjId(objId);
				p.setObjName(objName);
				p.setN1(n1);
				lpMet.add(p);
			}

			return gson.toJson(lpMet);

		}


		}
		return null;

	}

}

// пока сохранить это
// отделяем объекты от сессии и удаляем свойство ObjxProp
/*
 * for (Obj o : lobj) { sess.evict(o); o.setObjxProp(null); }
 */
