package com.ric.bill;

import java.util.Date;

//внутренний класс, запись Dw
public class DwRec {
	Storable st; //объект
	Double val; //значение
	String strVal; //значение
	String cd; //код параметра
	Date dt1; //начало периода
	Date dt2; //окончание периода
	
	DwRec(Storable st, Double val, String strVal, String cd, Date dt1, Date dt2) {
		this.st=st;
		this.val=val;
		this.strVal=strVal;
		this.cd=cd;
		this.dt1=dt1;
		this.dt2=dt2;
	}
}