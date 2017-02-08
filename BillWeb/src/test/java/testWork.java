import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.BillServ;
import com.ric.bill.Calc;
import com.ric.bill.Config;
import com.ric.bill.DistServ;
import com.ric.bill.RequestConfig;
import com.ric.bill.Result;
import com.ric.bill.excp.EmptyStorable;
import com.ric.bill.excp.WrongSetMethod;
import com.ric.bill.mm.ObjMng;
import com.ric.bill.mm.ParMng;
import com.ric.bill.model.bs.Dw;
import com.ric.bill.model.bs.Obj;
import com.ric.bill.model.fn.Chng;
import com.ric.web.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
//@ContextConfiguration(locations = { "classpath:spring.xml" }) //defines class-level metadata that is used to determine how to load and configure an ApplicationContext for integration tests.
@Slf4j
//@Service
public class testWork {


	@Autowired
	private ApplicationContext ctx;

	@Autowired
    private ParMng parMng;
	@Autowired
    private ObjMng objMng;
	
	@Autowired
    private BillServ billServ;

    @PersistenceContext
    private EntityManager em;

    private Calendar calendar;

    @Test
	public void mainWork() {
    	try {
    		
        	BillServ billServ = ctx.getBean(BillServ.class);
			billServ.script1();
			
		} catch (EmptyStorable | WrongSetMethod e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
/*    @Transactional(readOnly=false)
	public void work1() throws EmptyStorable, WrongSetMethod {
    	int rqn =-1;
		Obj obj = objMng.getByCD(-1, "Модуль начисления");

		Dw d = em.find(Dw.class, 8214820);
		Calendar calendar = new GregorianCalendar(2017, Calendar.FEBRUARY, 6);
		parMng.setDate(rqn, obj, "Начало расчетного периода", calendar.getTime());
		//d.setDts1(calendar.getTime());
		
		calendar = new GregorianCalendar(2017, Calendar.FEBRUARY, 8);
		parMng.setDate(rqn, obj, "Конец расчетного периода", calendar.getTime());
		
		log.info("Check ={}", obj.getId());
		log.info("Check dt1={} {}", parMng.getDate(-1, obj, "Начало расчетного периода"));
    	log.info("Check dt1={}", parMng.getDate(-1, obj, "Конец расчетного периода"));
    	
	}*/


}
