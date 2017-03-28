package com.ric.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ric.bill.BillServ;
import com.ric.bill.Config;
import com.ric.bill.RequestConfig;
import com.ric.bill.Result;
import com.ric.bill.Utl;
import com.ric.bill.dto.AreaDTO;
import com.ric.bill.dto.DTOBuilder;
import com.ric.bill.dto.KoDTO;
import com.ric.bill.dto.LstDTO;
import com.ric.bill.dto.OrgDTO;
import com.ric.bill.dto.PayordCmpDTO;
import com.ric.bill.dto.PayordDTO;
import com.ric.bill.dto.PayordGrpDTO;
import com.ric.bill.dto.PeriodReportsDTO;
import com.ric.bill.dto.ServDTO;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.OrgMng;
import com.ric.bill.mm.PayordMng;
import com.ric.bill.mm.ReportMng;
import com.ric.bill.mm.SecMng;
import com.ric.bill.mm.ServMng;
import com.ric.bill.mm.TarifMng;
import com.ric.bill.model.fn.Payord;
import com.ric.bill.model.fn.PayordCmp;
import com.ric.bill.model.fn.PayordGrp;

@EnableCaching
@RestController
@ComponentScan({ "com.ric.bill" })
// -если убрать - не найдёт бины, например billServ
@EntityScan(basePackages = "com.ric.bill")
@EnableAutoConfiguration
@Scope("prototype")
@Slf4j
public class BillingController {

	@PersistenceContext
	private EntityManager em;
	@Autowired
	private ApplicationContext ctx;
	@Autowired
	private Config config;
	@Autowired
	private ReportMng repMng;
	@Autowired
	private LstMng lstMng;
	@Autowired
	private OrgMng orgMng;
	@Autowired
	private ServMng servMng;
	@Autowired
	private TarifMng tarMng;
	@Autowired
	private PayordMng payordMng;
	@Autowired
	private DTOBuilder dtoBuilder;
	@Autowired
	private SecMng secMng;

	/**
	 * Получить периоды для элементов интерфейса
	 * 
	 * @param repCd
	 *            - CD отчета
	 * @param tp
	 *            - тип периода 0 - по месяцам, 1 - по дням
	 * @return
	 */
	@RequestMapping("/rep/getPeriodReports")
	@ResponseBody
	public List<PeriodReportsDTO> getPeriodReports(
			@RequestParam(value = "repCd") String repCd,
			@RequestParam(value = "tp", defaultValue = "0") Integer tp) {

		log.info("GOT /rep/getPeriodReports repCd={}, tp={}", repCd, tp);
		return repMng.getPeriodsByCD(repCd, tp);

	}

	// Получить все группы платежек
	@RequestMapping("/payord/getPayordGrpAll")
	@ResponseBody
	public List<PayordGrpDTO> getPayordGrp() {

		log.info("GOT /payord/getPayordGrpAll");
		return dtoBuilder.getPayordGrpDTOLst(payordMng.getPayordGrpAll());
	}

	// Сохранить группу платежки
	@RequestMapping(value = "/payord/setPayordGrp", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public String setPayordGrp(@RequestBody List<PayordGrpDTO> lst) {

		log.info("GOT /payord/setPayordGrp");
		lst.stream().forEach(t -> payordMng.setPayordGrpDto(t));
		return null;
	}

	// Добавить группу платежки
	@RequestMapping(value = "/payord/addPayordGrp", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public List<PayordGrpDTO> addPayordGrp(@RequestBody List<PayordGrpDTO> lst) {
		log.info("GOT /payord/addPayordGrp");
		List<PayordGrp> lst2 = new ArrayList<PayordGrp>();
		
		// добавить созданные группы платежек в коллекцию
		lst.stream().forEach(t -> lst2.add( payordMng.addPayordGrpDto(t)) );
		// обновить группы платежки из базы
		lst2.stream().forEach(t -> payordMng.refreshPayordGrp(t) );
		
		return dtoBuilder.getPayordGrpDTOLst(lst2);
	}
	
	// Удалить группу платежки
	@RequestMapping(value = "/payord/delPayordGrp", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public String delPayordGrp(@RequestBody List<PayordGrpDTO> lst) {

		log.info("GOT /payord/delPayordGrp");
		lst.stream().forEach(t -> payordMng.delPayordGrpDto(t));
		return null;
	}

	// Удалить платежку
	@RequestMapping(value = "/payord/delPayord", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public String delPayord(@RequestBody List<PayordDTO> lst) {

		log.info("GOT /payord/delPayord");
		lst.stream().forEach(t -> payordMng.delPayordDto(t));
		return null;
	}

	// Удалить формулу платежки
	@RequestMapping(value = "/payord/delPayordCmp", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public String delPayordCmp(@RequestBody List<PayordCmpDTO> lst) {

		log.info("GOT /payord/delPayordCmp");
		lst.stream().forEach(t -> payordMng.delPayordCmpDto(t));
		return null;
	}
	
	/**
	 * Получить все компоненты платежки по её ID
	 * 
	 * @return
	 */
	@RequestMapping("/payord/getPayordCmp")
	@ResponseBody
	public List<PayordCmpDTO> getPayordCmp(
			@RequestParam(value = "payordId") Integer payordId) {

		log.info("GOT /payord/getPayordCmp with payordId={}", payordId);
		return dtoBuilder.getPayordCmpDTOLst(payordMng
				.getPayordCmpByPayordId(payordId));

	}

	// сохранить компонент платежки
	@RequestMapping(value = "/payord/setPayordCmp", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public String setPayordCmp(@RequestBody List<PayordCmpDTO> lst) {

		log.info("GOT /payord/setPayordCmp");
		lst.stream().forEach(t -> payordMng.setPayordCmpDto(t));
		return null;
	}
	
	
	/**
	 * Получить все платежки
	 * 
	 * @return
	 */
	@RequestMapping("/payord/getPayordAll")
	@ResponseBody
	public List<PayordDTO> getPayordAll() {

		log.info("GOT /payord/getPayordAll");
		return dtoBuilder.getPayordDTOLst(payordMng.getPayordAll());

	}

	/**
	 * Получить платежки по Id группы
	 * 
	 * @return
	 */
	@RequestMapping("/payord/getPayord")
	@ResponseBody
	public List<PayordDTO> getPayord(
			@RequestParam(value = "payordGrpId") Integer payordGrpId) {

		log.info("GOT /payord/getPayord with payordGrpId={}", payordGrpId);
		return dtoBuilder.getPayordDTOLst(payordMng
				.getPayordByPayordGrpId(payordGrpId));

	}


	/**
	 * Сохранить платежку
	 * @param lst - DTO платежки
	 * @return
	 */
	@RequestMapping(value = "/payord/setPayord", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public String setPayord(@RequestBody List<PayordDTO> lst) {

		log.info("GOT /payord/setPayord");
		lst.stream().forEach(t -> payordMng.setPayordDto(t));
		return null;
	}

	/**
	 * Добавить платежку
	 * @param lst - DTO платежки
	 * @return
	 */
	@RequestMapping(value = "/payord/addPayord", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public List<PayordDTO> addPayord(@RequestBody List<PayordDTO> lst) {
		log.info("GOT /payord/addPayord");
		List<Payord> lst2 = new ArrayList<Payord>();
		
		// добавить созданные группы платежек в коллекцию
		lst.stream().forEach(t -> lst2.add( payordMng.addPayordDto(t)) );
		// обновить группы платежки из базы
		lst2.stream().forEach(t -> payordMng.refreshPayord(t) );
		
		return dtoBuilder.getPayordDTOLst(lst2);
	}
	

	/**
	 * Создать формулу платежки
	 * @param lst - DTO формулу платежки
	 * @return
	 */
	@RequestMapping(value = "/payord/addPayordCmp", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public List<PayordCmpDTO> addPayordCmp(@RequestBody List<PayordCmpDTO> lst) {
		log.info("GOT /payord/addPayordCmp");
		List<PayordCmp> lst2 = new ArrayList<PayordCmp>();
		
		// добавить созданные группы платежек в коллекцию
		lst.stream().forEach(t -> lst2.add( payordMng.addPayordCmpDto(t)) );
		// обновить группы платежки из базы
		lst2.stream().forEach(t -> payordMng.refreshPayordCmp(t) );
		
		return dtoBuilder.getPayordCmpDTOLst(lst2);
	}

	
	/**
	 * Получить список по типу
	 * 
	 * @param tp - тип списка
	 *            
	 * @return
	 */
	@RequestMapping("/base/getLstByTp")
	@ResponseBody
	public List<LstDTO> getLstByTp(@RequestParam(value = "tp") String tp) {
		log.info("GOT /base/getLstByTp with tp={}", tp);
		return dtoBuilder.getLstDTOLst(lstMng.getByTp(tp));
	}

	/**
	 * Получить список организаций, доступных текущему пользователю по роли и
	 * действию
	 * 
	 * @return
	 */
	@RequestMapping("/sec/getOrgCurUser")
	@ResponseBody
	public List<KoDTO> getOrgCurUser(
			@RequestParam(value = "roleCd") String roleCd,
			@RequestParam(value = "actCd") String actCd) {
		log.info("GOT /sec/getOrgCurUser with: roleCd={}, actCd={}", roleCd, actCd);
		return secMng.getKoCurUser(roleCd, actCd);
	}

	/**
	 * Получить список всех организаций
	 * 
	 * @return
	 */
	@RequestMapping("/base/getOrgAll")
	@ResponseBody
	public List<KoDTO> getOrgAll() {
		log.info("GOT /base/getOrgAll");
		return dtoBuilder.getOrgDTOLst(orgMng.getOrgAll());
	}

	/**
	 * Получить список всех услуг
	 * 
	 * @return
	 */
	@RequestMapping("/base/getServAll")
	@ResponseBody
	public List<ServDTO> getServAll() {
		log.info("GOT /base/getServAll");
		return dtoBuilder.getServDTOLst(servMng.getServAll());
	}

	/**
	 * Получить список всех типов объекта сбора инф.
	 * 
	 * @return
	 */
	@RequestMapping("/base/getAreaAll")
	@ResponseBody
	public List<AreaDTO> getAreaAll() {
		log.info("GOT /base/getAreaAll");
		return dtoBuilder.getAreaDTOLst(tarMng.getAreaAll());
	}

	private Boolean checkDate(String genDt1, String genDt2) {
		// проверка на заполненные даты, если указаны
		if ((genDt1.length() > 0 && genDt2.length() == 0) || (genDt1.length() == 0 && genDt2.length() > 0)) {
			return false;
		} else if (genDt1.length() == 0 && genDt2.length() == 0) {
			return true;
		}
		
		Date dt1 = Utl.getDateFromStr(genDt1);
		Date dt2 = Utl.getDateFromStr(genDt2);
		
		Date firstDt = Utl.getFirstDate(dt1);
		Date lastDt = Utl.getLastDate(dt1);
		
		// проверить, что даты в одном диапазоне
		if (!(Utl.between(dt1, firstDt, lastDt) && Utl.between(dt2, firstDt, lastDt)))  {
			return false;
		}
			
		return true;
	}
	
	@RequestMapping("/chrglsk")
	public String chrgLsk(
			@RequestParam(value = "lsk", defaultValue = "00000000") Integer lsk,
			@RequestParam(value = "dist", defaultValue = "0") String dist,
			@RequestParam(value = "tp", defaultValue = "0") String tp,
			@RequestParam(value = "chngId", defaultValue = "") String chngId,
			@RequestParam(value = "dt1", defaultValue = "", required = false) String genDt1,
			@RequestParam(value = "dt2", defaultValue = "", required = false) String genDt2
			) {
		log.info("GOT /chrglsk with: lsk={}, dist={}, tp={}, chngId={}, dt1={}, dt2={}", lsk,
				dist, tp, chngId, genDt1, genDt2);
		
		
		if (!checkDate(genDt1, genDt2)) {
			log.info("Заданы некорректные даты dt1={}, dt2={}!", genDt1, genDt2);
			return "ERROR IN DATES";
		}
		
		// получить уникальный номер запроса
		int rqn = config.incNextReqNum();

		log.info("RQN={}", rqn);
		long beginTime = System.currentTimeMillis();

		// получить доступ к лиц.счету
		int i = 0;
		while (!config.checkLsk(lsk)) {
			i++;
			if (i > 100) {
				log.info(
						"********ВНИМАНИЕ!ВНИМАНИЕ!ВНИМАНИЕ!ВНИМАНИЕ!ВНИМАНИЕ!ВНИМАНИЕ!ВНИМАНИЕ! /chrglsk with: lsk={}",
						lsk);
				log.info(
						"********НЕ ВОЗМОЖНО РАЗБЛОКИРОВАТЬ ЛС В ТЕЧЕНИИ 10 сек! /chrglsk with: lsk={}",
						lsk);
				i = 0;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return "ERROR";
			}
		}

		Future<Result> fut = null;

		// если пустой ID перерасчета
		Integer chId = null;
		if (chngId.length() != 0 && chngId != null) {
			log.info("chngId={}", chngId);
			chId = Integer.valueOf(chngId);
		}

		RequestConfig reqConfig = ctx.getBean(RequestConfig.class);
		long endTime1 = System.currentTimeMillis() - beginTime;
		beginTime = System.currentTimeMillis();

		reqConfig.setUp(config, dist, tp, chId, rqn, genDt1, genDt2);

		long endTime2 = System.currentTimeMillis() - beginTime;
		beginTime = System.currentTimeMillis();

		BillServ billServ = ctx.getBean(BillServ.class); // добавил, было Autowired
		fut = billServ.chrgLsk(reqConfig, null, lsk);

		long endTime3 = System.currentTimeMillis() - beginTime; // время
																// инициализации
																// billServ bean
		beginTime = System.currentTimeMillis();

		// ждать окончание потока
		try {
			fut.get();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
			log.info("BEGINING UNLOCK /chrglsk with: lsk={}", lsk);
			config.unCheckLsk(lsk); // снять лицевой с обработки
			log.info("ENDING UNLOCK /chrglsk with: lsk={}", lsk);
			return "ERROR";
		} catch (ExecutionException e1) {
			e1.printStackTrace();
			log.info("BEGINING UNLOCK /chrglsk with: lsk={}", lsk);
			config.unCheckLsk(lsk); // снять лицевой с обработки
			log.info("ENDING UNLOCK /chrglsk with: lsk={}", lsk);
			return "ERROR";
		}

		long endTime4 = System.currentTimeMillis() - beginTime;

		log.info(
				"TIMING: доступ.к л.с.={}, конфиг={}, инит. bean={}, расчет={}",
				endTime1, endTime2, endTime3, endTime4);

		try {
			if (fut.get().err == 0) {
				log.info("BEGINING UNLOCK /chrglsk with: lsk={}", lsk);
				config.unCheckLsk(lsk); // снять лицевой с обработки
				log.info("ENDING UNLOCK /chrglsk with: lsk={}", lsk);
				log.info("OK /chrglsk with: lsk={}, dist={}, tp={}, chngId={}",
						lsk, dist, tp, chngId);
				return "OK";
			} else {
				log.info("BEGINING UNLOCK /chrglsk with: lsk={}", lsk);
				config.unCheckLsk(lsk); // снять лицевой с обработки
				log.info("ENDING UNLOCK /chrglsk with: lsk={}", lsk);
				log.info(
						"ERROR /chrglsk with: lsk={}, dist={}, tp={}, chngId={}",
						lsk, dist, tp, chngId);
				return "ERROR";
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("BEGINING UNLOCK /chrglsk with: lsk={}", lsk);
			config.unCheckLsk(lsk); // снять лицевой с обработки
			log.info("ENDING UNLOCK /chrglsk with: lsk={}", lsk);
			return "ERROR";
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("BEGINING UNLOCK /chrglsk with: lsk={}", lsk);
			config.unCheckLsk(lsk); // снять лицевой с обработки
			log.info("ENDING UNLOCK /chrglsk with: lsk={}", lsk);
			return "ERROR";
		}

	}

	@RequestMapping("/chrgall")
	public String chrgAll(
			@RequestParam(value = "dist", defaultValue = "0", required = true) String dist,
			@RequestParam(value = "houseId", defaultValue = "", required = false) Integer houseId,
			@RequestParam(value = "areaId", defaultValue = "", required = false) Integer areaId,
			@RequestParam(value = "dt1", defaultValue = "", required = false) String genDt1,
			@RequestParam(value = "dt2", defaultValue = "", required = false) String genDt2) {

		log.info("GOT /chrglsk with: houseId={}, dist={}, areaId={}, dt1={}, dt2={}", houseId,
				dist, areaId, genDt1, genDt2);
		
		if (!checkDate(genDt1, genDt2)) {
			log.info("Заданы некорректные даты dt1={}, dt2={}!", genDt1, genDt2);
			return "ERROR IN DATES";
		}

		// получить уникальный номер запроса
		int rqn = config.incNextReqNum();
		log.info("RQN={}", rqn);

		Future<Result> fut = null;

		RequestConfig reqConfig = ctx.getBean(RequestConfig.class);
		reqConfig.setUp(config, dist, "0", null, rqn, genDt1, genDt2);

		BillServ billServ = ctx.getBean(BillServ.class); // добавил, было Autowired
		fut = billServ.chrgAll(reqConfig, houseId, areaId);

		while (!fut.isDone()) {
			try {
				Thread.sleep(100);
				// 100-millisecond Задержка
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			if (fut.get().err == 0) {
				return "OK";
			} else {
				return "ERROR";
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR";
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR";
		}
	}

}