import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ric.bill.mm.ParMng;
import com.ric.bill.model.bs.Par;
import com.ric.web.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class testPar {


	@Autowired
    private ParMng parMng;
	
	@Test
	public void testPar1() {
		assertThat("Addition von \"4,6\" ergibt nicht 10!",
				parMng.getByCD("746").getCd(), is("746"));
	}

	@Test
	public void testPar2() {
		assertThat("Addition von \"4,6\" ergibt nicht 10!",
				parMng.getByCD("746").getCd(), is("748"));
	}
}
