import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ric.bill.BillServ;
import com.ric.bill.Calc;
import com.ric.bill.Config;
import com.ric.bill.RequestConfig;
import com.ric.bill.Utl;
import com.ric.bill.excp.WrongDate;
import com.ric.bill.mm.ObjMng;
import com.ric.bill.mm.ParMng;
import com.ric.bill.mm.PayordMng;
import com.ric.bill.mm.SecMng;
import com.ric.web.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
@Slf4j
public class testWork {


	@Autowired
	private ApplicationContext ctx;
	@Autowired
    private ParMng parMng;
	@Autowired
    private ObjMng objMng;
	@Autowired
    private BillServ billServ;
	@Autowired
    private SecMng secMng;
	@PersistenceContext
    private EntityManager em;
	@Autowired
	private Config config;
	
    @Test
	public void mainWork() {
		log.error("Check conf");

		RequestConfig reqConfig = ctx.getBean(RequestConfig.class);
		reqConfig.setUp(config, "0", "0", null, 1, "", "");
		Calc calc = new Calc(reqConfig);

		log.error("check date={}", Utl.getDateByPeriod("201704"));
		log.error("check period+1={}, period-1={}", Utl.addMonth(Utl.getPeriodByDate(Utl.getDateByPeriod("201704")),5),
				Utl.addMonth(Utl.getPeriodByDate(Utl.getDateByPeriod("201704")),-5)
				);
		
		PayordMng pm = ctx.getBean(PayordMng.class);
		
		Date dt = null;
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy"); 
		try {
			dt = df.parse("01.05.2017");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			pm.genPayord(calc, dt, true, true);
		} catch (WrongDate e) {
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
