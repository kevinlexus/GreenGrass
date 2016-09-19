package com.ric.bill.model.fn;


import java.math.BigDecimal;
import java.util.Date;

import com.ric.bill.Calc;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.bs.Serv;

/**
 * Строка начисления
 * @author lev
 *
 */
public class ChrgRec {

	private BigDecimal vol;
	private BigDecimal price;
	private Serv serv;
	private Org org;
	private Org uk;
    private Date dt1, dt2;

    /**
     * конструктор 
     * @param sum - сумма
     * @param vol - объем
     * @param price - расценка
     * @param serv - услуга
     * @param org - организация
     * @param dt1 - дата начала
     * @param dt2 - дата окончания
     */
	public ChrgRec(BigDecimal vol, BigDecimal price, Serv serv, Org org, Org uk, Date dt1, Date dt2) {
		super();
		setVol(vol);
		setPrice(price);
		setServ(serv);
		setOrg(org);
		setUk(uk);
		setDt1(dt1);
		setDt2(dt2);
	}

	public BigDecimal getVol() {
		return vol;
	}

	public void setVol(BigDecimal vol) {
		this.vol = vol;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDt1() {
		return dt1;
	}

	public void setDt1(Date dt1) {
		this.dt1 = dt1;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public Date getDt2() {
		return dt2;
	}

	public void setDt2(Date dt2) {
		this.dt2 = dt2;
	}

	public Serv getServ() {
		return serv;
	}

	public void setServ(Serv serv) {
		this.serv = serv;
	}

	public Org getUk() {
		return uk;
	}

	public void setUk(Org uk) {
		this.uk = uk;
	}

	
}

