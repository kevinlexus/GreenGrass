package com.ric.bill.mm.impl;

import org.mariuszgromada.math.mxparser.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.Calc;
import com.ric.bill.Utl;
import com.ric.bill.dao.PaymentDetDAO;
import com.ric.bill.dao.PayordCmpDAO;
import com.ric.bill.dao.PayordDAO;
import com.ric.bill.dao.PayordFlowDAO;
import com.ric.bill.dao.PayordGrpDAO;
import com.ric.bill.dto.PayordCmpDTO;
import com.ric.bill.dto.PayordDTO;
import com.ric.bill.dto.PayordGrpDTO;
import com.ric.bill.excp.WrongDate;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.PayordMng;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.fn.Payord;
import com.ric.bill.model.fn.PayordCmp;
import com.ric.bill.model.fn.PayordFlow;
import com.ric.bill.model.fn.PayordGrp;
import com.ric.bill.model.oralv.Ko;
import com.ric.bill.model.tr.Serv;

@Service
@Slf4j
public class PayordMngImpl implements PayordMng {

    @PersistenceContext
    private EntityManager em;
	@Autowired
	private PayordDAO payordDao;
	@Autowired
	private PayordGrpDAO payordGrpDao;
	@Autowired
	private PayordCmpDAO payordCmpDao;
	@Autowired
	private PayordFlowDAO payordFlowDao;
	@Autowired
	private LstMng lstMng;
	@Autowired
	private PaymentDetDAO paymentDetDao;
	
	/**
	 * Получить все платежки
	 * @return
	 */
	public List<Payord> getPayordAll() {
		
		return payordDao.getPayordAll();
		
	}

	/**
	 * Получить платежки по Id группы
	 * @return
	 */
	public List<Payord> getPayordByPayordGrpId(Integer payordGrpId) {
		
		return payordDao.getPayordByPayordGrpId(payordGrpId);
		
	}

	/**
	 * Получить все группы платежек
	 * @return
	 */
	public List<PayordGrp> getPayordGrpAll() {
		
		return payordGrpDao.getPayordGrpAll();
		
	}

	// Сохранить платежку из DTO
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void setPayordDto(PayordDTO payordDTO) {
		Payord payord = em.find(Payord.class, payordDTO.getId());
    	payord.setName(payordDTO.getName());		
    	payord.setSelDays(payordDTO.getSelDays());
    	payord.setFormula(payordDTO.getFormula());
    	
    	if (payordDTO.getPeriodTpFk() != null) {
        	Lst periodTp = em.find(Lst.class, payordDTO.getPeriodTpFk());
        	payord.setPeriodTp(periodTp);
    	} else {
        	payord.setPeriodTp(null);
    	}
	}

	// Удалить группу платежек из DTO
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delPayordGrpDto(PayordGrpDTO p) {
		PayordGrp pg = em.find(PayordGrp.class, p.getId());
		em.remove(pg);
	}

	// Удалить платежку из DTO
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delPayordDto(PayordDTO p) {
		Payord pg = em.find(Payord.class, p.getId());
		em.remove(pg);
	}

	// Удалить платежку из DTO
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delPayordCmpDto(PayordCmpDTO p) {
		PayordCmp pg = em.find(PayordCmp.class, p.getId());
		em.remove(pg);
	}

    // сохранить группу платежки из DTO
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void setPayordGrpDto(PayordGrpDTO p) {
		PayordGrp payordGrp = em.find(PayordGrp.class, p.getId());
		payordGrp.setName(p.getName());
	}

    // добавить группу платежки из DTO
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public PayordGrp addPayordGrpDto(PayordGrpDTO p) {
		PayordGrp payordGrp = new PayordGrp(p.getName());
		em.persist(payordGrp);
		
		return payordGrp;
	}

	// обновить группы платежки из базы (чтобы перечитались все поля)
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void refreshPayordGrp(PayordGrp p) {
		em.refresh(p);
	}	
	
	// сохранить компонент платежки из DTO
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void setPayordCmpDto(PayordCmpDTO p) {
		PayordCmp pCmp = em.find(PayordCmp.class, p.getId());
		
		if (p.getVarFk() != null) {
			Lst var = em.find(Lst.class, p.getVarFk());	
			pCmp.setVar(var);
		} else {
			pCmp.setVar(null);
		}

		if (p.getOrgFk() != null) {
			Org org = em.find(Org.class, p.getOrgFk());	
			pCmp.setOrg(org);
		} else {
			pCmp.setOrg(null);
		}
		
		if (p.getKoFk() != null) {
			Ko ko = em.find(Ko.class, p.getKoFk());	
			pCmp.setKo(ko);
		} else {
			pCmp.setKo(null);
		}

		if (p.getServFk() != null) {
			Serv serv = em.find(Serv.class, p.getServFk());	
			pCmp.setServ(serv);
		} else {
			pCmp.setServ(null);
		}
	
		pCmp.setMark(p.getMark());
		
	}

	/**
	 * Получить компоненты платежки по её ID
	 * @return
	 */
	public List<PayordCmp> getPayordCmpByPayordId(Integer payordId) {

		return payordCmpDao.getPayordCmpByPayordId(payordId);
		
	}

	/**
	 * Получить группу платежек по её ID
	 * @return
	 */
	public PayordGrp getPayordGrpById(Integer id) {

		return payordGrpDao.getPayordGrpById(id);
		
	}

    // Добавить платежку из DTO
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Payord addPayordDto(PayordDTO p) {
		
		PayordGrp grp = em.find(PayordGrp.class, p.getPayordGrpFk());
		Lst period =  em.find(Lst.class, p.getPeriodTpFk()); 
		Payord payord = new Payord(p.getName(), p.getSelDays(), p.getFormula(), grp, period);
		em.persist(payord);
		
		return payord;
	}

    // Добавить формулу платежки из DTO
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public PayordCmp addPayordCmpDto(PayordCmpDTO p) {
		
		// найти компоненты
		Lst var = em.find(Lst.class, p.getVarFk());
		Serv serv = em.find(Serv.class, p.getServFk());
		Org org = em.find(Org.class, p.getOrgFk());
		Payord payord = em.find(Payord.class, p.getPayordFk());
		Ko ko =  em.find(Ko.class, p.getKoFk());
		// создать формулу
		PayordCmp cmp = new PayordCmp(payord, var, serv, org, ko, p.getMark());
		em.persist(cmp);
		
		return cmp;
	}

	// Обновить формулу платежки из базы (чтобы перечитались все поля)
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void refreshPayordCmp(PayordCmp t) {
		em.refresh(t);
	}	

	// Обновить платежку из базы (чтобы перечитались все поля)
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void refreshPayord(Payord p) {
		em.refresh(p);
	}

	// Сумматор сумм по УК и маркеру
	class AmntSummByUk {
		List<SummByUk> amnt = new ArrayList<SummByUk>(); // сгруппированные суммы по Маркеру и УК
		public void add(SummByUk s) {
			SummByUk summ = amnt.stream().filter(t-> t.getUk().equals(s.getUk()) && t.getMark().equals(s.getMark()))
					.findFirst().orElse(null);
			if (summ != null) {
				summ.setSumma(summ.getSumma().add(s.getSumma()) );
			} else {
				amnt.add(s);
			}
		}
		
		public List<SummByUk> getAmnt() {
			return amnt;
		}

	}
		
	// Одна строчка суммы по УК
	class SummByUk {
		String mark;
		Org uk;
		BigDecimal summa;
		
		public SummByUk(String mark, Org uk, BigDecimal summa) {
			super();
			this.mark = mark;
			this.uk = uk;
			this.summa = summa;
		}

		public String getMark() {
			return mark;
		}

		public void setMark(String mark) {
			this.mark = mark;
		}

		public Org getUk() {
			return uk;
		}

		public void setUk(Org uk) {
			this.uk = uk;
		}

		public BigDecimal getSumma() {
			return summa;
		}

		public void setSumma(BigDecimal summa) {
			this.summa = summa;
		}

	}
	

	// Итоговые суммы по PayordFlow
	class AmntFlow {
		BigDecimal summa =BigDecimal.ZERO;
	}
	
	/**
	 * Подсчет итоговых сумм по PayordFlow
	 * @param p - платежка
	 * @param uk - УК
	 * @param dt1 - дата нач.
	 * @param dt2 - дата кон.
	 * @param tp - Тип записи:  0-вх.сал., 1-вх.сал.Бух, 2-платежка, 3-корр.перечисл., 4-корр.сборов, 5- корр.удерж
	 * @return
	 */
	private AmntFlow calcFlow(Payord p, Org uk, String period, Date dt1, Date dt2, Integer tp) {
		AmntFlow amntFlow = new AmntFlow();
		p.getPayordFlow().stream()
				.filter(t-> (period==null || (t.getPeriod()!= null && t.getPeriod().equals(period)) ) && (dt1==null || Utl.between(t.getDt(), dt1, dt2)) && t.getUk().equals(uk)
				&& t.getPayord().equals(p) && t.getTp().equals(tp))
				.forEach(t-> {
			amntFlow.summa=amntFlow.summa.add(BigDecimal.valueOf(Utl.nvl(t.getSumma(), 0D)));
		});
		return amntFlow;
	}
	
	/**
	 * Подсчет сборов по параметрам
	 * @param markLst - список маркеров
	 * @param amntSummByUk - сгруппированные суммы по УК и Маркерам
	 * @param p - платежка
	 * @param uk - УК
	 * @return
	 */
	private BigDecimal calcMark(List<String> markLst, AmntSummByUk amntSummByUk, Payord p, Org uk) {
		BigDecimal summa = BigDecimal.ZERO; 
			// Подсчет сборов
			String formula = p.getFormula();
			log.info("Формула до изменений={}", formula);
			for (String mark: markLst) {
				// по каждому маркеру
				BigDecimal summ = amntSummByUk.getAmnt().stream()
						.filter(e -> e.getUk().equals(uk) && e.getMark().equals(mark)).map(e-> e.getSumma())
						.reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
				formula = formula.replaceAll(mark, String.valueOf(summ));
			}
			log.info("Формула после изменений={}", formula);
			Expression e = new Expression(formula);
			summa = BigDecimal.valueOf(e.calculate());
			summa = summa.setScale(2, BigDecimal.ROUND_HALF_UP);
		return summa;
	}
	
	/**
	 * Получить входящее сальдо на дату
	 * @param p - платежка
	 * @param dt - дата выборки
	 * @return
	 */
	public BigDecimal getInsal(Payord p, Date dt) {
		PayordFlow payordFlow = payordFlowDao.getPayordFlowBeforeDt(p.getId(), 0, dt).stream().findFirst().orElse(null);
		return BigDecimal.valueOf(payordFlow.getSumma());
	}
	
	/**
	 * Сформировать платежки за период
	 * @param genDt - обычно текущая дата
	 * @param isEndMonth - платежка по окончанию месяца
	 * @throws WrongDate 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void genPayord(Calc calc, Date genDt, Boolean isEndMonth) throws WrongDate {
		if (isEndMonth && (genDt.before(calc.getReqConfig().getCurDt2()) || genDt.equals(calc.getReqConfig().getCurDt2()))) {
			// если итоговая платежка и дата формирования меньше последней даты текущего периода 
			throw new WrongDate("Некорректная дата при итоговом формировании платежки");
		}
		String period = calc.getReqConfig().getPeriod();
		// Перебрать все платежки
		for (Payord p :payordDao.getPayordAll()) {
			AmntSummByUk amntSummByUk = new AmntSummByUk();
 			// distinct список Маркеров
			List<String> markLst = p.getPayordCmp().stream().distinct().map(t -> t.getMark()).collect(Collectors.toList());
			p.getPayordCmp().stream().forEach(t -> {
				//log.info("Payord.id={}", t.getId());
				if (t.getVar().getCd().equals("PAYORD_SUM_PAY_REP2")) {
					// собрать сумму по отчету оплаты, сгруппировать по Маркеру и УК
					paymentDetDao.getPaymentDetByPeriod(period).stream()
							.filter(d -> t.getServ() == null || d.getServ().equals(t.getServ()))
							.filter(d -> t.getOrg() == null || d.getOrg().equals(t.getOrg()))
							.forEach(d -> amntSummByUk.add(new SummByUk(t.getMark(), 
									d.getPayment().getKart().getUk(), BigDecimal.valueOf(d.getSumma()) )));
				} else {
					// прочие варианты сбора данных
				}
			});

 			// distinct список УК
			List<Org> ukLst = amntSummByUk.getAmnt().stream().map(d -> d.getUk()).distinct().collect(Collectors.toList());
			ukLst.stream().forEach(uk -> {
				// По каждой УК, за период:
				// получить сборы по всем маркерам
				BigDecimal summa1 = calcMark(markLst, amntSummByUk, p, uk);
				log.info("По УК.id={} и по Платежке id={}, сумма={}", uk.getId(), p.getId(), summa1);
				// получить сумму перечислений
				AmntFlow amntFlow = calcFlow(p, uk, calc.getReqConfig().getPeriod(), null, null, 2);
				BigDecimal summa2 = amntFlow.summa;
				// получить сумму корректировок сборов
				amntFlow = calcFlow(p, uk, calc.getReqConfig().getPeriod(), null, null, 3);
				BigDecimal summa3 = amntFlow.summa;
				// получить сумму корректировок перечислений
				amntFlow = calcFlow(p, uk, calc.getReqConfig().getPeriod(), null, null, 4);
				BigDecimal summa4 = amntFlow.summa;
				// получить сумму удержаний
				amntFlow = calcFlow(p, uk, calc.getReqConfig().getPeriod(), null, null, 5);
				BigDecimal summa5 = amntFlow.summa;
				log.info("Сумма {}, ", amntFlow.summa);
				// получить вх. сальдо
				BigDecimal insal =getInsal(p, calc.getReqConfig().getCurDt1());
				log.info("Сальдо={}", insal);

				// рассчитать сумму, рекомендованную к перечислению
				BigDecimal summa6 = insal.add(summa1).subtract(summa2).add(summa3).add(summa4).subtract(summa5);

				if (isEndMonth) {
					// рассчитать суммы для сальдо по бухгалтерии
					
					
					
				}
				
				
				if (!isEndMonth) {
					// округлить, если не итоговая плат. по концу мес.
					summa6=summa6.setScale(2, BigDecimal.ROUND_HALF_UP);
				}
				// занулить, если отрицательная
				if (summa6.floatValue() < 0) {
					summa6 = BigDecimal.ZERO; 
				}
				
				if (summa6 != BigDecimal.ZERO) {
					// создать движение по платежке
					PayordFlow flow = new PayordFlow(p, uk, 
								summa6.doubleValue(), summa1.doubleValue(), 
								summa2.doubleValue(), summa3.doubleValue(), summa4.doubleValue(), 
								summa5.doubleValue(), summa6.doubleValue(), 2, period, genDt);  
					p.getPayordFlow().add(flow);
				}
			});
			
		}
		
	}
	
}