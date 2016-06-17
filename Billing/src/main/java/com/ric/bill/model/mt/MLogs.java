package com.ric.bill.model.mt;

import java.util.Set;

import com.ric.bill.Simple;
import com.ric.bill.Storable;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.ar.Kart;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Serv;

public interface MLogs extends Storable, Simple {

	public abstract String getName();

	public abstract void setName(String name);

	public abstract Set<Meter> getMeter();

	public abstract void setMeter(Set<Meter> meter);

	public abstract Lst getTp();

	public abstract void setTp(Lst tp);

	public abstract Set<Vol> getVol();

	public abstract void setVol(Set<Vol> vol);

	public abstract Serv getServ();

	public abstract void setServ(Serv serv);

	public abstract Kart getKart();

	public abstract void setKart(Kart kart);

	public abstract House getHouse();

	public abstract void setHouse(House house);

	public abstract Set<MeterLogGraph> getInside();

	public abstract Set<MeterLogGraph> getOutside();


}