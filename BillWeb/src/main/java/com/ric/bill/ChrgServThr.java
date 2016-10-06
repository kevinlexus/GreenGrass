package com.ric.bill;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.excp.ErrorWhileChrg;

/**
 * Поток начисления, выполняет вызовы функций начисления
 * @author lev
 *
 */
@Service
@Scope("prototype")
public class ChrgServThr {

	@Autowired
	private ApplicationContext ctx;
	//@Autowired
	//private ChrgServ chrgServ;
	
	@Async
	public Future<Result> chrgAndSaveLsk(Calc calc) throws ErrorWhileChrg {
		ChrgServ chrgServ = ctx.getBean(ChrgServ.class);
		//Выполнить начисление
		Result res = chrgServ.chrgLsk(calc);
		//Сохранить результат
		if (res.err==0) {
			chrgServ.save(calc.getKart().getLsk()); 
		}
		
		return new AsyncResult<Result>(res);
	}
	
}
