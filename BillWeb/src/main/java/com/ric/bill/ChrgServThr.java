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
import com.ric.bill.model.mt.MeterLog;
import com.ric.bill.model.mt.Vol;
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
	public Future<Result> chrgAndSaveLsk(Calc calc, boolean dist) throws ErrorWhileChrg, ErrorWhileDist {

		Kart kart = calc.getKart(); 
		log.info("Kart1={}", metMng.getVolCnt(kart, 168447));
		log.info("Kart2={}", metMng.getVolCnt(calc.getKart(), 168447));
		
		em.detach(calc.getKart()); // отсоединить объект от базы
		
		if (dist) {
			DistServ distServ = ctx.getBean(DistServ.class);
			distServ.distKartVol(calc);
		}

		log.info("Kart 1 hash={}", kart.hashCode());
		log.info("Kart 1 id={}", kart.getId());
		log.info("Kart 1 lsk={}", kart.getLsk());
		log.info("Kart 2 hash={}", calc.getKart().hashCode());
		log.info("Kart 2 id={}", calc.getKart().getId());
		log.info("Kart 2 lsk={}", calc.getKart().getLsk());
		
		log.info("Kart equals?={}", calc.getKart().equals(kart));
		

		log.info("Kart3={}", metMng.getVolCnt(kart, 168447));
		log.info("Kart4={}", metMng.getVolCnt(calc.getKart(), 168447));

		log.info("Распределение 1 кол-во={}", metMng.getVolCnt(calc.getKart(), 168447));
		
/*		for (MeterLog ml: kart.getMlog()) {
			if (ml.getId()==168447) {
				for (Vol oo: ml.getVol()) {
					log.info("Распределение Счетчик id={}, проверен объем={}, даты {}-{}", ml.getId(), oo.getVol1(), oo.getDt1(), oo.getDt2());
				}
			}
		}
*/		
		//присвоить обратно лиц.счет, который мог быть занулён в distServ.distKartVol(calc);
		log.info("Kart5={}", metMng.getVolCnt(kart, 168447));
		log.info("Kart6={}", metMng.getVolCnt(calc.getKart(), 168447));
		calc.setKart(kart); 
		

		ChrgServ chrgServ = ctx.getBean(ChrgServ.class);
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
		//Выполнить начисление
		Result res = chrgServ.chrgLsk(calc);
		log.info("Начисление кол-во={}", metMng.getVolCnt(calc.getKart(), 168447));

/*		for (MeterLog ml: kart.getMlog()) {
			if (ml.getId()==168447) {
				for (Vol oo: ml.getVol()) {
					log.info("Начисление Счетчик id={}, проверен объем={}, даты {}-{}", ml.getId(), oo.getVol1(), oo.getDt1(), oo.getDt2());
				}
			}
		}*/

		//Сохранить результат
		if (res.err==0) {
			chrgServ.save(calc.getKart().getLsk()); 
		}
		
		return new AsyncResult<Result>(res);
	}
	
}
