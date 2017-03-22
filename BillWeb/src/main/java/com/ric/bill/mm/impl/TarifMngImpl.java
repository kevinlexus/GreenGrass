package com.ric.bill.mm.impl;

import java.util.Date;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ric.bill.Calc;
import com.ric.bill.TarifContains;
import com.ric.bill.Utl;
import com.ric.bill.dao.TarifDAO;
import com.ric.bill.dao.impl.HouseDAOImpl;
import com.ric.bill.mm.TarifMng;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.fn.Chng;
import com.ric.bill.model.fn.ChngLsk;
import com.ric.bill.model.fn.ChngVal;
import com.ric.bill.model.tr.Serv;
import com.ric.bill.model.tr.TarifKlsk;
import com.ric.bill.model.tr.TarifServProp;

/**
 * Сервис работы с тарифами
 * @author lev
 *
 */
@Slf4j
@Service
public class TarifMngImpl implements TarifMng {
	
	@Autowired
	private TarifDAO tDao;

    
	//получить свойство тарифа по его CD
	//@Cacheable(cacheNames="readOnlyCache", key="{ #cd }") - здесь не кэшируется, только в DAO
	//public synchronized Prop getPropByCD(String cd) {
//		return tDao.getPropByCD(cd);
	//}

	/**
	 * Получить значение типа Double тарифа по CD 
	 * @param tc - объект
	 * @param cd - код свойства
	 * @return - свойство
	 */
	@Cacheable(cacheNames="rrr1", key="{ #rqn, #tc.getKlsk(), #serv.getId(), #cd, #genDt }") 
	public /*synchronized*/ Double getProp(int rqn, TarifContains tc, Serv serv, String cd, Date genDt) {
		//Prop prop = getPropByCD(cd);//так и не понял, как быстрее, искать тариф предварительно getPropByCD, или непосредственно через.getCd()
		//искать сперва по наборам тарифа объекта 
		for (TarifKlsk k : tc.getTarifklsk()) {
			//по соотв.периоду
			//if (Utl.between(genDt, k.getDt1(), k.getDt2())) {
				//затем по строкам - составляющим тариф 
				for (TarifServProp t : k.getTarprop()) {
					if (Utl.between(genDt, t.getDt1(), t.getDt2())) {
						if (t.getServ().equals(serv) && t.getProp().getCd().equals(cd)) {
							return t.getN1();
						}
					}
				}
			//}
		}
		return null;
		
	}

	/**
	 * Получить организацию по услуге в тарифе 
	 * @param tc - объект
	 * @param cd - код свойства
	 * @return - свойство
	 */
	//@Cacheable(cacheNames="rrr1") 
	@Cacheable(cacheNames="rrr3", key="{ #rqn,  #tc.getKlsk(), #serv.getId(), #genDt }") 
	public /*synchronized*/ Org getOrg(int rqn, TarifContains tc, Serv serv, Date genDt) {

		for (TarifKlsk k : tc.getTarifklsk()) {
			//по соотв.периоду
			//if (Utl.between(genDt, k.getDt1(), k.getDt2())) {
				//затем по строкам - составляющим тариф 
				for (TarifServProp t : k.getTarprop()) {
					if (Utl.between(genDt, t.getDt1(), k.getDt2())) {
						if (t.getServ().equals(serv) && t.getProp().getCd().equals("Поставщик")) {
							return t.getOrg();
						}
					}
				}
			//}
		}
		return null;
		
	}

	/**
	 * Получить список всех услуг по тарифу данного объекта по всем датам
	 * @param tc - объект
	 * @return
	 */
	//@Cacheable(cacheNames="rrr1") 
	/*	@Cacheable(cacheNames="rrr1", key="{ #tc.getKlsk() }") 
	public synchronized List<Serv> getAllServ(TarifContains tc) {
		List<Serv> lst = new ArrayList<Serv>();
		//искать сперва по наборам тарифа объекта 
		for (TarifKlsk k : tc.getTarifklsk()) {
			//по соотв.периоду - сделал по всем датам, так как не понятно, как их фильтровать
			//if (Utl.between(dt1, k.getDt1(), k.getDt2())) {
				//затем по строкам - составляющим тариф 
				for (TarifServ t : k.getTarserv()) {
					lst.add(t.getServ());
				}
			//}
		}
		return lst;
	}
*/	
	/**
	 * Получить наличие услуги по тарифу данного объекта на заданную дату
	 * @param tc - объект
	 * @param genDt - дата выборки
	 * @param genDt - дата выборки
	 * @return - вернуть 0 - услуга не найдена, поискать на другом уровне
	 *                   1 - услуга помечена как удалена с уровня город (не искать её на уроне город)
	 *                   2 - услуга найдена, или помечена как Act=1 (добавлена на уровень лиц.счета) 
	 */
/*	@Cacheable(cacheNames="rrr1", key="{ #tc.getKlsk(), #serv.getId(), #genDt }") 
	public synchronized int getServ(TarifContains tc, Serv serv, Date genDt) {
		List<Serv> lst = new ArrayList<Serv>();
		//искать сперва по наборам тарифа объекта 
		for (TarifKlsk k : tc.getTarifklsk()) {
			//по соотв.периоду
			if (Utl.between(genDt, k.getDt1(), k.getDt2())) {
				//затем по строкам - составляющим тариф 
				for (TarifServ t : k.getTarserv()) {
					if (t.getServ().equals(serv)) {
						if (Utl.nvl(k.getAct(), 1) == 1) {
							return 2;
						} else {
							return 1;
						}
					}
				}
			}
		}
		return 0;
	}
*/	
	
	
	// получить подмененную расценку по перерасчету
	public Double getChngPrice(Calc calc, Serv serv, Date genDt) {  // убрать synchronized??
		// получить расценку
		Double price = null;
		Chng chng = calc.getReqConfig().getChng();	
/*      Пока не удалять, проверенный код 		
		if (chng.getTp()!= null && chng.getChngLsk()!=null && chng.getTp().getCd().equals("Изменение расценки (тарифа)") ) {
			
			for (ChngLsk t : chng.getChngLsk()) {
				
				if (t.getKart() != null && t.getChngVal() !=null && t.getServ() != null) {
					if (t.getKart().getLsk().equals(calc.getKart().getLsk()) && t.getServ().equals(serv) ) {
						for (ChngVal d : t.getChngVal() ) {
							if (Utl.between(genDt, d.getDtVal1(), d.getDtVal2())) {
								price = d.getVal();
								return price;
							}
						}
					}
					
				}
				
			}
			
		}*/
		
		if (chng.getTp().getCd().equals("Изменение расценки (тарифа)")) {
			Optional<ChngVal> chngVal;
			chngVal = calc.getReqConfig().getChng().getChngLsk().stream()
			.filter(t -> t.getKart().getLsk().equals(calc.getKart().getLsk())) // фильтр по лиц.счету
			.filter(t -> t.getServ().equals(serv) ) // фильтр по услуге
			.flatMap(t -> t.getChngVal().stream() // преобразовать в другую коллекцию
						.filter(d -> Utl.between(genDt, d.getDtVal1(), d.getDtVal2())) // и фильтр по дате
					).findFirst();
			if (chngVal.isPresent()) {
				price = chngVal.get().getVal(); 
			}
		}

/*		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("lsk={}",calc.getKart().getLsk());
			log.info("serv={}",serv.getId());
			log.info("dt={}",genDt);
			
			calc.getReqConfig().getChng().getChngLsk().stream()
						.filter(t -> t.getKart().getLsk().equals(calc.getKart().getLsk())) // фильтр по лиц.счету
						.forEach(t->
								log.info("{} {} {} {}", t.getKart(), t.getChngVal(), t.getServ(), t.getId())
								);
			
			
		}*/

		return price;
	}
	
}
