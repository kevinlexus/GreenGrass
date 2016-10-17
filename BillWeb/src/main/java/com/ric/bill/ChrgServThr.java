package com.ric.bill;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.ric.bill.Calc;
import com.ric.bill.ChrgServ;
import com.ric.bill.Result;
import com.ric.bill.excp.ErrorWhileChrg;

/**
 * Поток начисления, выполняет вызовы функций начисления
 * сервис необходим, так как @Transactional должно находиться в другом сервисе,
 * подробнее тут: http://stackoverflow.com/questions/11275471/calling-transactional-methods-from-another-thread-runnable
 * @author lev
 *
 */
@Service
@Scope("prototype")
public class ChrgServThr {

	@Autowired
	private ApplicationContext ctx;
	
	@Async
	public Future<Result> chrgAndSaveLsk(Calc calc) throws ErrorWhileChrg {
		ChrgServ chrgServ = ctx.getBean(ChrgServ.class);
		//Выполнить начисление
		calc.getKart().getDw().size();
		Result res = chrgServ.chrgLsk(calc);
		//Сохранить результат
		if (res.err==0) {
			chrgServ.save(calc.getKart().getLsk()); 
		}
		
		return new AsyncResult<Result>(res);
	}
	
}
