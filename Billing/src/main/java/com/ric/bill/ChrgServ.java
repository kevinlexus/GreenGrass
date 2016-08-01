package com.ric.bill;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.excp.EmptyOrg;
import com.ric.bill.excp.EmptyServ;
import com.ric.bill.excp.ErrorWhileChrg;
import com.ric.bill.excp.InvalidServ;
import com.ric.bill.mm.HouseMng;
import com.ric.bill.mm.KartMng;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.MeterLogMng;
import com.ric.bill.mm.ParMng;
import com.ric.bill.mm.ServMng;
import com.ric.bill.mm.TarifMng;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.ar.Kw;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.bs.Serv;
import com.ric.bill.model.fn.Chrg;
import com.ric.bill.model.fn.ChrgStore;

/**
 * Сервис формирования начисления
 * @author lev
 *
 */
@Service
public class ChrgServ {


	@Autowired
	private Calc calc;
	@Autowired
	private ParMng parMng;
	@Autowired
	private ServMng servMng;
	@Autowired
	private TarifMng tarMng;
	@Autowired
	private HouseMng houseMng;
	@Autowired
	private KartMng kartMng;
	@Autowired
	private MeterLogMng metMng;
	@Autowired
	private LstMng lstMng;
	
	//EntityManager - EM нужен на каждый DAO или сервис свой!
    @PersistenceContext
    private EntityManager em;

    private ExecProc ex;
	//временное хранилище записей
	private ChrgStore chStore;
    
    //конструктор
    public ChrgServ() {
		/*ds = new DSess(true);
		ex = new ExecProc(ds);*/
    }
    

	/**
	 * начислить по всем домам
	 */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void chrgAll()  throws ErrorWhileChrg {
    	Session sess = (Session) em.getDelegate();
    	ex = new ExecProc(sess);
    	
    	for (House o: houseMng.findAll()) {
			System.out.println("ДОМ:"+o.getId());
			Calc.setInit(false);
			chrgHouse(o.getId());
		}
	}
	
    /**
	 * выполнить начисление по дому
	 * @param houseId - Id дома, иначе кэшируется, если передавать объект дома
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void chrgHouse(int houseId) throws ErrorWhileChrg {

		House h = em.find(House.class, houseId);
		if (!Calc.isInit()) {
			calc.setHouse(h);
			calc.setArea(calc.getHouse().getStreet().getArea());
			calc.setUp(); //настроить даты фильтра и т.п.
			Calc.setInit(true);
		}
		Calc.mess("Начисление");
		Calc.mess("Дом: id="+calc.getHouse().getId());
		Calc.mess("Дом: klsk="+calc.getHouse().getKlsk());
		
		//перебрать все квартиры и лиц.счета в них
		int aaa=1;
		for (Kw kw : h.getKw()) {
			for (Kart kart : kw.getLsk()) {
				aaa++;
				if (aaa > 5) {
					//break;
				}
				/*for (MeterLog mLog: kart.getMlog()) {
					Calc.mess("сч="+mLog.getId());
					//Calc.mess("Дом в сч.: klsk="+mLog.getHouse().getKlsk());
				}*/ 

				//if (kart.getLsk().equals("26074123")) {
					long startTime3;
					long endTime3;
					long totalTime3;
					startTime3 = System.currentTimeMillis();

					chrgLsk(kart); //расчитать начисление
					
					endTime3   = System.currentTimeMillis();
					totalTime3 = endTime3 - startTime3;
				    Calc.mess("ВРЕМЯ НАЧИСЛЕНИЯ по лиц счету:"+kart.getLsk()+" ="+totalTime3);
					//break; //##################
				//}
				//Calc.mess("Кол-во записей="+ex.runWork(1, 0, 0),2);
			}
		}
	}
	

	/**
	 * выполнить расчет начисления по лиц.счету
	 * @param kart - объект лиц.счета
	 * @throws ErrorWhileChrg 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void chrgLsk(Kart kart) throws ErrorWhileChrg {
		
		Calc.mess("ЛС===:"+kart.getLsk());
		if (!Calc.isInit()) {
			calc.setHouse(kart.getKw().getHouse());
			calc.setArea(calc.getHouse().getStreet().getArea());
			calc.setUp(); //настроить даты фильтра и т.п.
			Calc.setInit(true);
		}
		calc.setKart(kart);

		//получить все необходимые услуги для начисления из тарифа по дому
		Calendar c = Calendar.getInstance();

		//перенести в архив предыдущий расчет
		archPrev();

		List<Chrg> prepChrg = new ArrayList<Chrg>(0); 

		//для виртуальной услуги	
		HashMap<Serv, BigDecimal> mapServ = new HashMap<Serv, BigDecimal>();  
		HashMap<Serv, BigDecimal> mapVrt = new HashMap<Serv, BigDecimal>();  

		//найти все услуги, действительные в лиц.счете
		for (Serv serv : kartMng.getAllServ(kart)) {
			ChrgThr chrgThr = new ChrgThr();
			chrgThr.gen(lstMng, chrgServ, parMng, kartMng, chStore, mapServ, mapVrt, prepChrg, kart, serv, c);
		}

		
		//сделать коррекцию на сумму разности между основной и виртуальной услуг
		for (Map.Entry<Serv, BigDecimal> entryVrt : mapVrt.entrySet()) {
		    Serv servVrt = entryVrt.getKey();
			//найти сумму, для сравнения, полученную от основных услуг
		    for (Map.Entry<Serv, BigDecimal> entryServ : mapServ.entrySet()) {
				if (entryServ.getKey().equals(servVrt)) {
					BigDecimal diff = entryVrt.getValue().subtract(entryServ.getValue());
					if (diff.compareTo(BigDecimal.ZERO) != 0) {
						//существует разница, найти услугу, куда кинуть округление
						Serv servRound = servVrt.getServRound(); 
						//найти только что добавленные строки начисления, и вписать в одну из них
						boolean flag = false; //флаг, чтобы больше не корректировать, если уже раз найдено
						for (Chrg chrg : prepChrg) {
							//Calc.mess("услуга="+chrg.getServ().getId(),2);
							if (!flag && chrg.getStatus() == 1 && chrg.getServ().equals(servRound)) {
								flag = true;
								chrg.setSumAmnt(BigDecimal.valueOf(chrg.getSumAmnt()).add(diff).doubleValue()) ;
								chrg.setSumFull(BigDecimal.valueOf(chrg.getSumFull()).add(diff).doubleValue()) ;
							}
						}
					}
				}
			}		    
		}			

		//сохранить записи начисления
		kart.getChrg().addAll(prepChrg); 

	}


	/**
	 * перенести предыдущий расчет начисления в статус "подготовка к архиву" (1->2)
	 */
	private void archPrev() {
		//Calc.mess("archPrev:"+Calc.getKart().getLsk()+" dt1:"+Calc.getCurDt1().toLocaleString()+" dt2:"+Calc.getCurDt2().toLocaleString()+ " period:"+Calc.getPeriod(), 2);
		Query query = em.createQuery("update Chrg t set t.status=2 where t.lsk=:lsk "
				+ "and t.status=1 "
				+ "and t.dt1 between :dt1 and :dt2 "
				+ "and t.dt2 between :dt1 and :dt2 "
				+ "and t.period=:period"
				);
		query.setParameter("lsk", Calc.getKart().getLsk());
		query.setParameter("dt1", Calc.getCurDt1());
		query.setParameter("dt2", Calc.getCurDt2());
		query.setParameter("period", Calc.getPeriod());
		query.executeUpdate();
	}

}


