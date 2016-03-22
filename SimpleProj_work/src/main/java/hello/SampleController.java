package hello;


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.SpringApplication;
import org.json.*;
import org.springframework.http.MediaType;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.google.gson.Gson;
import com.greengrass.house.Obj;
import com.greengrass.house.ObjxProp;

import hello.PojoRow;
import scala.annotation.meta.setter;
import test.HibernateUtil;

@SpringBootApplication
@Controller
@EnableAutoConfiguration
public class SampleController {
	
	static Session sess;
	
	public static Session getSession() {
		return HibernateUtil.getSessionFactory().openSession();
	}
		
	@RequestMapping(value = "/restful/{id}", method = RequestMethod.DELETE)
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
	

	@RequestMapping(value = "/restful/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
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
	
	@RequestMapping(value = "/restful/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String createProduct() {
			System.out.println("create");
			return null;
	    }
 
	
    @RequestMapping(value = "/restful")
    @ResponseBody
    public String jsonText(@RequestParam MultiValueMap<String, String> params) {
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
		sess.getTransaction().begin();
		
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
	
   

    @RequestMapping("/testrest")
    @ResponseBody
    public String gettest(@RequestParam MultiValueMap<String, String> params){
    	List<PojoRow> prod = new ArrayList<PojoRow>();
        Gson gson = new Gson();
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
		sess.getTransaction().begin();
		
		for (Object[] row: rs) {
			Integer id = (Integer) row[0];
			String name = (String) row[1];
			String cd = (String) row[2];
			String fk_tp = (String) row[3];

		PojoRow p = new PojoRow();
		p.setId(id);
		p.setName(name);
		p.setCd(cd);
		p.setFk_tp(fk_tp);
		prod.add(p);
}	

		return gson.toJson(prod);
		
    }
  

    public static void main(String[] args)  {
    	
  SpringApplication.run(SampleController.class, args);
 
    }
    
    
    
}