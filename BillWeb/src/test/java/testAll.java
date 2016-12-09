import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
import com.ric.bill.DistServ;
import com.ric.bill.RequestConfig;
import com.ric.bill.Result;
import com.ric.bill.mm.ParMng;
import com.ric.bill.model.fn.Chng;
import com.ric.web.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
@Slf4j
public class testAll {


	@Autowired
	private ApplicationContext ctx;

	@Autowired
    private ParMng parMng;
	
	@Autowired
    private BillServ billServ;

    @PersistenceContext
    private EntityManager em;

    @Test
	public void testPar1() {
		assertThat("Проверка наличия параметра Комната",
				parMng.getByCD("Комната").getCd(), is("Комната"));
	}

	
	@Test
	public void testPar2() {
		assertThat("Проверка наличия параметра Статус жилья",
				parMng.getByCD("Статус жилья").getCd(), is("Статус жилья"));
	}

	@Test
	public void testChrg() {
		Config config = ctx.getBean(Config.class);
    	Future<Result> fut = null;

    	RequestConfig reqConfig = new RequestConfig();
    	Chng chng = em.find(Chng.class, 1021);
    	reqConfig.setChng(chng);
    	reqConfig.setOperTp(1); // перерасчёт
    	reqConfig.setIsDist(true);
    	
    	fut = billServ.chrgLsk(reqConfig, null, 275699);
    	
	   	//проверить окончание потока 
	    while (!fut.isDone()) {
	         try {
				Thread.sleep(100);
				//100-millisecond задержка
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("ERROR");
			} 
	     }

	    try {
			if (fut.get().err ==0) {
			} else {
				log.error("ERROR");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("ERROR");
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("ERROR");
		}
		
	}
	
}
