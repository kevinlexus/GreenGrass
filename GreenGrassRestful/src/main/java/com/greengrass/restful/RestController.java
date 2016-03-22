package com.greengrass.restful;


import java.io.StringWriter;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greengrass.house.Obj;
import com.greengrass.house.ObjxProp;


@SpringBootApplication
@Controller
@RequestMapping(value = "/restful")
@EnableAutoConfiguration
public class RestController {
	
	static Session sess;
	
	public static Session getSession() {
		return HibernateUtil.getSessionFactory().openSession();
	}
		
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteProduct(@PathVariable int id) {
		
		sess = getSession();
		sess.beginTransaction();
		sess.createSQLQuery(
						"delete "
					  + "from t_obj "
					  + "where id = :id ")
			    	.setInteger("id", id)
				    .executeUpdate();
		sess.getTransaction().commit();

		System.out.println("Delete id="+id);
		return null;
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String editProduct(@PathVariable int id, @RequestBody PojoRow pojorow) {
		System.out.println("Update id="+id);
	    Obj obj = new Obj();
		sess = getSession();
		sess.beginTransaction();	
		obj = (Obj)sess.load(Obj.class, id);
		
		if (pojorow.getName() == null ) {
			System.out.println("name"+pojorow.getName());
		} else {
			obj.setName(pojorow.getName());
		}
		
		if (pojorow.getCd() == null){
			System.out.println("cd="+pojorow.getCd());
		} else {
			obj.setName(pojorow.getCd());
		}
		
		if (pojorow.getFk_tp() == null){
			System.out.println("fk_tp="+pojorow.getFk_tp());
		} else {
			obj.setName(pojorow.getFk_tp());
		}
		
		
		sess.getTransaction().commit();
		return null;
    }
	
	@RequestMapping("/on")
	public void on(@RequestParam MultiValueMap<String, String> params) {
		String name = params.get("name").get(0).toString();
		String fk_tp = params.get("fk_tp").get(0).toString();
		String cd = params.get("cd").get(0).toString();
		System.out.println("/on:" + fk_tp);
		System.out.println("/on:" + name);
		System.out.println("/on:" + cd);
		
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		Query query = s.getNamedQuery("selectAllEmployees_SP");
			
		s.getTransaction().commit();
		}
		
	
	
   @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getProduct(@RequestParam MultiValueMap<String, String> params) {
		sess = getSession();
		Query query = sess
				.createSQLQuery(
						"select t.id, t.name, t.cd, t.fk_tp "
								+ "from t_obj t "
								+ "order by t.name "
								)
				.addScalar("id", StandardBasicTypes.INTEGER)
				.addScalar("name", StandardBasicTypes.STRING)
				.addScalar("cd", StandardBasicTypes.STRING)
				.addScalar("fk_tp", StandardBasicTypes.STRING);


		@SuppressWarnings("unchecked")
		List<Object[]> rs = query.list();
		
        JSONArray jsonArray = new JSONArray();
		
		for (Object[] row : rs) {
			JSONObject formDetailsJson = new JSONObject();
			formDetailsJson.put("id", row[0]);
			formDetailsJson.put("name", row[1]);
			formDetailsJson.put("cd", row[2]);
			formDetailsJson.put("fk_tp", row[3]);
			jsonArray.put(formDetailsJson);
		}

	     StringWriter out = new StringWriter();
	     jsonArray.write(out);
	      
	      String jsonText = out.toString();
	   
		return(jsonText);	
    }
	

   @RequestMapping(value = "/restprop", method = RequestMethod.GET, produces="application/json")
   @ResponseBody
   public String jsonText(@RequestParam("fk_obj") int fk_obj, @RequestParam MultiValueMap<String, String> params) {
    System.out.println("checking..."+fk_obj);
        sess = getSession();
        //sess.getTransaction().begin();
		Query query = sess
				.createSQLQuery(
						"select t.id, t.n1, t.s1, t.d1, t.i1, t.owfs_cd, t.arch, p.tp_cd, p.name "
						  + "from t_objxprop t "
						  + " join t_prop p on t.fk_prop=p.id "
						  + " where t.fk_obj=:fk_obj "
								)
				.addScalar("id", StandardBasicTypes.INTEGER)
				.addScalar("n1", StandardBasicTypes.DOUBLE)
				.addScalar("s1", StandardBasicTypes.STRING)
				.addScalar("d1", StandardBasicTypes.DATE)
				.addScalar("i1", StandardBasicTypes.INTEGER)
				.addScalar("owfs_cd", StandardBasicTypes.STRING)
				.addScalar("arch", StandardBasicTypes.INTEGER)
				.addScalar("tp_cd", StandardBasicTypes.STRING)
				.addScalar("name", StandardBasicTypes.STRING)
			    .setInteger("fk_obj", fk_obj);
		
				
		@SuppressWarnings("unchecked")
		List<Object[]> rs = query.list();
		
        JSONArray jsonArray = new JSONArray();
		
		for (Object[] row : rs) {
			JSONObject formDetailsJson = new JSONObject();
			formDetailsJson.put("id", row[0]);
			formDetailsJson.put("n1", row[1]);
			formDetailsJson.put("s1", row[2]);
			formDetailsJson.put("d1", row[3]);
			formDetailsJson.put("i1", row[4]);
			formDetailsJson.put("owfs_cd", row[5]);
			formDetailsJson.put("arch", row[6]);
			formDetailsJson.put("tp_cd", row[7]);
			formDetailsJson.put("name", row[8]);
			jsonArray.put(formDetailsJson);
		}

	     StringWriter out = new StringWriter();
	     jsonArray.write(out);     
	     String jsonText = out.toString();
	      
		return(jsonText);	
		
    }
    
    @RequestMapping("/fk")
    @ResponseBody
    public String getRestFk_t(@RequestParam MultiValueMap<String, String> params){
    	
        sess = getSession();
		Query query = sess
				.createSQLQuery(
						"select id, name "
					+	"from T_OBJ_TP "
								)
				.addScalar("id", StandardBasicTypes.STRING)
				.addScalar("name", StandardBasicTypes.STRING);
				
		@SuppressWarnings("unchecked")
		List<Object[]> rs = query.list();
		
        JSONArray jsonArray = new JSONArray();
		
		for (Object[] row : rs) {
			JSONObject formDetailsJson = new JSONObject();
			formDetailsJson.put("id", row[0]);
			formDetailsJson.put("name", row[1]);
			jsonArray.put(formDetailsJson);
		}

	     StringWriter out = new StringWriter();
	     jsonArray.write(out);	      
	     String jsonText = out.toString();

		return(jsonText);	
		
    }


    @RequestMapping(value = "/restprop/edit/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String editProductProp(@PathVariable int id, @RequestBody PojoRowProp pojorowprop) {
		System.out.println("Update ="+id);
		System.out.println("getN1 = "+pojorowprop.getN1());
		System.out.println("getS1 = "+pojorowprop.getS1());
		System.out.println("getD1 = "+pojorowprop.getD1());
		System.out.println("getI1 = "+pojorowprop.getI1());
		System.out.println("getOwfs_cd = "+pojorowprop.getOwfs_cd());
		System.out.println("getUpd_by1 = "+pojorowprop.getUpd_by1());
		System.out.println("getFk_prop = "+pojorowprop.getFk_prop());

		
		ObjxProp objxprop = new ObjxProp();
		sess = getSession();
		sess.beginTransaction();	
		objxprop = (ObjxProp)sess.load(ObjxProp.class, id);

		objxprop.setN1(pojorowprop.getN1());
		objxprop.setS1(pojorowprop.getS1());
		objxprop.setI1(pojorowprop.getI1());
		objxprop.setD1(pojorowprop.getD1());
		
		sess.getTransaction().commit();
	
		return null;
    }

/*    public static void main(String[] args)  {
    	
  SpringApplication.run(RestController.class, args);
 
    }*/
}