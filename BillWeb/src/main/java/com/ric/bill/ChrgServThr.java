package com.ric.bill;

import java.util.concurrent.Future;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.Calc;
import com.ric.bill.ChrgServ;
import com.ric.bill.Result;
import com.ric.bill.excp.ErrorWhileChrg;
import com.ric.bill.excp.ErrorWhileDist;
import com.ric.bill.mm.MeterLogMng;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.tr.TarifKlsk;

/**
 * Асинхронный поток начисления, выполняет вызовы функций начисления
 * сервис необходим, так как @Transactional должно находиться в другом сервисе,
 * подробнее тут: http://stackoverflow.com/questions/11275471/calling-transactional-methods-from-another-thread-runnable
 * @author lev
 *
 */
@Service
@Scope("prototype")
@Slf4j
public class ChrgServThr {

	@Autowired
	private ApplicationContext ctx;
    @PersistenceContext
    private EntityManager em;
	@Autowired
	private MeterLogMng metMng;
	
	@Async
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Future<Result> chrgAndSaveLsk(Calc calc, boolean dist) throws ErrorWhileChrg {
		ChrgServ chrgServ = ctx.getBean(ChrgServ.class);
		DistServ distServ = ctx.getBean(DistServ.class);
		
		//загрузить все Lazy параметры, чтобы не было concurrensy issue в потоках например, на getDbl()
		//ну или использовать EAGER в дочерних коллекциях, что более затратно
		calc.getKart().getDw().size();
		calc.getKart().getTarifklsk().size();
		for (TarifKlsk k : calc.getKart().getTarifklsk()) {
			k.getTarprop().size();
		}
		calc.getKart().getReg().size();
		calc.getKart().getRegState().size();

		calc.getHouse().getTarifklsk().size();
		for (TarifKlsk k : calc.getHouse().getTarifklsk()) {
			k.getTarprop().size();
		}
		calc.getArea().getTarifklsk().size();
		for (TarifKlsk k : calc.getArea().getTarifklsk()) {
			k.getTarprop().size();
		}

		Kart kart = calc.getKart();
		if (dist) {
			try {
				distServ.distKartVol(calc);
			} catch (ErrorWhileDist e) {
				e.printStackTrace();
			}
		}
		
		calc.setKart(kart);
		//Выполнить начисление
		Result res = chrgServ.chrgLsk(calc);
		//Сохранить результат
		if (res.err==0) {
			chrgServ.save(calc); 
		}
		
		return new AsyncResult<Result>(res);
	}
	
}
