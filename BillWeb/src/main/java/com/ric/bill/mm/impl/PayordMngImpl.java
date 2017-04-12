package com.ric.bill.mm.impl;

import org.mariuszgromada.math.mxparser.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.dao.PaymentDetDAO;
import com.ric.bill.dao.PayordCmpDAO;
import com.ric.bill.dao.PayordDAO;
import com.ric.bill.dao.PayordGrpDAO;
import com.ric.bill.dto.PayordCmpDTO;
import com.ric.bill.dto.PayordDTO;
import com.ric.bill.dto.PayordGrpDTO;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.PayordMng;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.fn.Payord;
import com.ric.bill.model.fn.PayordCmp;
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
	
	/**
	 * Сформировать платежки за период
	 */
	public void genPayord() {
		String period = "201704";
		for (Payord p :payordDao.getPayordAll()) {
			log.info("Payord.id={}", p.getId());
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
			ukLst.stream().forEach(d -> {
				// по каждой УК
				String formula = p.getFormula();
				log.info("Формула до изменений={}", formula);
				for (String mark: markLst) {
				//markLst.stream().forEach(f -> {
					// по каждому маркеру
					BigDecimal summ = amntSummByUk.getAmnt().stream().filter(e -> e.getUk().equals(d) && e.getMark().equals(mark)).map(e-> e.getSumma())
					  .reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
					log.info("УК={}, Маркер={}, Сумма={}", d.getName(), mark, summ);
					formula = formula.replaceAll(mark, String.valueOf(summ));
				}
				log.info("Формула после изменений={}", formula);
				Expression e = new Expression(formula);
				log.info("Расчет формулы={}", e.calculate());
			});
			
		}
		
	}
	
}