void sayAboutThemp() {
	//Сказать самое теплое и холодное место
	//println 'Tempr:'+GGE.getMostHotTherm()
	//println 'Tempr:'+GGE.getMostCoolTherm()
	String mess=null
	switch (GGE.getMostHotTherm()) {
		case 'T_KITCH1':
			mess='на кухне'
			break
		case 'T_BATH1':
			mess='в ванной'
			break
		case 'T_BEDRM1':
			mess='в спальне'
			break
		case 'T_LVN1':
			mess='в зале'
			break
		case 'T_OUTDOOR1':
			mess='на улице'
			break
	}
	//Сделать объявление
	GGE.crEvent('Самое тёплое место в квартире находится '
		+mess, 300, 1, 'GGV', 'snd4', 0)
	
	switch (GGE.getMostCoolTherm()) {
		case 'T_KITCH1':
			mess='на кухне'
			break
		case 'T_BATH1':
			mess='в ванной'
			break
		case 'T_BEDRM1':
			mess='в спальне'
			break
		case 'T_LVN1':
			mess='в зале'
			break
		case 'T_OUTDOOR1':
			mess='на улице'
			break
	}
	//Сделать объявление
	GGE.crEvent('Самое прохладное место в квартире находится '
		+mess, 300, 1, 'GGV', 'snd4', 0)

}


//проверка температуры в квартире
void checkTemp(double val, double minval, double maxval, double diff, com.greengrass.house.Obj o, String txtWhere) {
	
	int ival=Math.round(val)
	
	//Датчик температуры, контроль изменений температуры, каждые 3 градуса
    if (val-o.getDbl('LATCHED_LAST_VAL') >= diff) {
		println 'Tempr:'+val+' round:'+ival
		
		o.setDbl('LATCHED_LAST_VAL', val)
		 //Сделать объявление
		if (val > maxval) {
			GGE.crEvent(txtWhere+' стало жарко, '
				 +ival+' градусов', 3600, 1, 'GGV', 'snd4', 0)
		} else if ((val >= minval) && (val <= maxval)) {
		  GGE.crEvent(txtWhere+' комфортная температура, '
			+ival+' градусов', 3600, 1, 'GGV', 'snd4', 0)
		} else {
			GGE.crEvent(txtWhere+' потеплело и стало, '
				+ival+' градусов', 3600, 1, 'GGV', 'snd4', 0)
				}
	} else if (val-o.getDbl('LATCHED_LAST_VAL') <= diff*-1)
	{
		println 'Tempr:'+val+' round:'+ival
		o.setDbl('LATCHED_LAST_VAL', val)
		 //Сделать объявление
		if (val < minval) {
			GGE.crEvent(txtWhere+' стало холодно, '
				 +ival+' градусов', 3600, 1, 'GGV', 'snd4', 0)
		} else if ((val >= minval) && (val <= maxval)) {
		  GGE.crEvent(txtWhere+' комфортная температура, '
			+ival+' градусов', 1, 3600, 'GGV', 'snd4', 0)
		} else {
			GGE.crEvent(txtWhere+' похолодало и стало, '
				+ival+' градусов', 3600, 1, 'GGV', 'snd4', 0)
		}
	}
//	println 'Check:'+txtWhere
}

//проверка температуры на улице (отдельная процедура)
void checkTemp2(Date dt1, double val, com.greengrass.house.Obj o, String txtWhere) {
	
	int ival=Math.round(val)
	
	double minval
	double maxval
	String word1
	//curDate.format("HH:mm")
	switch (dt1.format("MM")) {
		case '01':
		midval=-17
		word1='потеплее'
		break
		case '02':
		midval=-14.7
		word1='потеплее'
		break
		case '03':
		midval=-7.3
		word1='потеплее'
		break
		case '04':
		midval=1.9
		word1='тепло'
		break
		case '05':
		midval=11.2
		word1='тепло'
		break
		case '06':
		midval=16.5
		word1='жарко'
		break
		case '07':
		midval=19
		word1='жарко'
		break
		case '08':
		midval=16.2
		word1='жарко'
		break
		case '09':
		midval=9.6
		word1='тепло'
		break
		case '10':
		midval=2.4
		word1='тепло'
		break
		case '11':
		midval=-7.4
		word1='тепло'
		break
		case '12':
		midval=-14.5
		word1='тепло'
		break
	}
		
	//Датчик температуры, контроль изменений температуры, каждые 3 градуса
	if (val-o.getDbl('LATCHED_LAST_VAL') >= 3) {
		println 'Tempr:'+val+' round:'+ival
		
		o.setDbl('LATCHED_LAST_VAL', val)
		 //Сделать объявление
		if (val > midval+3) {
			GGE.crEvent(txtWhere+' стало '+word1+', '
				 +ival+' градусов', 3600, 1, 'GGV', 'snd4', 0)
		} else if ((val >= midval-3) && (val <= midval+3)) {
		  GGE.crEvent(txtWhere+' средняя температура этого месяца, '
			+ival+' градусов', 3600, 1, 'GGV', 'snd4', 0)
		} else {
			GGE.crEvent(txtWhere+' потеплело и стало, '
				+ival+' градусов', 3600, 1, 'GGV', 'snd4', 0)
				}
	} else if (val-o.getDbl('LATCHED_LAST_VAL') <= -3)
	{
		println 'Tempr:'+val+' round:'+ival
		o.setDbl('LATCHED_LAST_VAL', val)
		 //Сделать объявление
		if (val < midval-3) {
			GGE.crEvent(txtWhere+' стало холодно, '
				 +ival+' градусов', 3600, 1, 'GGV', 'snd4', 0)
		} else if ((val >= midval-3) && (val <= midval+3)) {
		  GGE.crEvent(txtWhere+' средняя температура этого месяца, '
			+ival+' градусов', 1, 3600, 'GGV', 'snd4', 0)
		} else {
			GGE.crEvent(txtWhere+' похолодало и стало, '
				+ival+' градусов', 3600, 1, 'GGV', 'snd4', 0)
		}
	}
//	println 'Check:'+txtWhere
}

/*ZONE2.on()
ZONE1.off()
GGE.crEvent('Сейчас звучит зона 2', 300, 1, 'GGV', 'snd1', 0)
*/

	Date curDate = new Date()
	//Вызвать обработчик расписания
	GGE.procScheduler()

	int flag=0
	int th_kitch1=Math.round(T_KITCH1.getDbl('CELSIUS_VAL') * 100) / 100
	int th_lvn1=Math.round(T_LVN1.getDbl('CELSIUS_VAL') * 100) / 100
	int th_bath1=Math.round(T_BATH1.getDbl('CELSIUS_VAL') * 100) / 100
	int th_bed1=Math.round(T_BEDRM1.getDbl('CELSIUS_VAL') * 100) / 100
	int th_outd1=Math.round(T_OUTDOOR1.getDbl('CELSIUS_VAL') * 100) / 100
	int th_i_outd1=Math.round(T_OUTDOOR1.getDbl('CELSIUS_VAL') * 100) / 100
	
	
	//Разбудить утром
	if (curDate.format("HH:mm")=='07:00') {
		HOUSE.setBool('NIGHT_MODE', false)
		GGE.crEvent('MORN_HELLO1', 'Доброе утро!', 65, 1, 'GGV', 'snd3', 0)
		GGE.crEvent('MORN_HELLO2', 'На улице '+th_i_outd1+' градусов!', 65, 1, 'GGV', 'snd1', 0)
	}

	//Еще раз повторить температуру, перед выходом
	if (curDate.format("HH:mm")=='07:20') {
		GGE.crEvent('MORN_HELLO2', 'На улице '+th_i_outd1+' градусов!', 65, 1, 'GGV', 'snd1', 0)
	}

	if (curDate.format("HH:mm")=='22:15') {
		GGE.crEvent('EVEN_HELLO1', 'Возможно кому-то пора спать, время: '+curDate.format("HH:mm"), 65, 1, 'GGV', 'snd1', 0)
		GGE.crEvent('EVEN_HELLO2', 'Умный дом будет переведён в ночной режим', 65, 1, 'GGV', 'snd1', 0)
		if (T_OUTDOOR1.getDbl('CELSIUS_VAL') < -29) {
			GGE.crEvent('EVEN_HELLO3', 'Внимание! Температура упала до '+T_OUTDOOR1.getDbl('CELSIUS_VAL')+' градусов, надо включить машину на прогрев!', 65, 1, 'GGV', 'snd1', 0)
        }
	}
	if (curDate.format("HH:mm")=='22:17') {
		HOUSE.setBool('NIGHT_MODE', true)
	}

	//GGE.crEvent('EVEN_HELLO2', 'проверка '+Math.round(1.2686589 * 100) / 100, 65, 1, 'GGV', 'snd1', 0)
	
	//Реакция на нажатие кнопки у входа 
	if (TRIGG1.is_on()) {
		TRIGG1.off()
		GGE.crEvent('JUST_EVENT1', 'На улице '+th_i_outd1, 0, 1, 'GGV', 'snd1', 0)
		GGE.crEvent('JUST_EVENT2', 'В спальне '+th_bed1, 0, 1, 'GGV', 'snd1', 0)
		GGE.crEvent('JUST_EVENT3', 'В зале '+th_lvn1, 0, 1, 'GGV', 'snd1', 0)
		GGE.crEvent('JUST_EVENT4', 'На кухне '+th_kitch1, 0, 1, 'GGV', 'snd1', 0)
		GGE.crEvent('JUST_EVENT5', 'В ванной '+th_bath1+' градусов!', 0, 1, 'GGV', 'snd1', 0)

		/*if (!HOUSE.getBool('PEOPLE_EXIST')) {
			GGE.crEvent('AT_HOME', 'Я рада вас видеть дома!', 10, 1, 'GGV', 'snd2', 0)
			HOUSE.setBool('PEOPLE_EXIST', true)
		} else {
			GGE.crEvent('AT_HOME', 'Вы собираетесь покинуть дом? Всего хорошего вам!', 10, 1, 'GGV', 'snd2', 1)
			HOUSE.setBool('PEOPLE_EXIST', false)
		}*/ 
	}
	
	//Реакция на открытие двери
	if (TRIGG2.is_on()) {
		GGE.crEvent('DOOR_OPEN', 'Входная дверь открыта!', 300, 1, 'GGV', 'snd2', 0)
		TRIGG2.off()
	}
	//Реакция вход в подъезд с использованием домофона
	if (TRIGG3.is_on()) {
		GGE.crEvent('INTERCOM', 'Кто то звонил в домофон, и я - открыла!', 300, 1, 'GGV', 'snd2', 0)
		TRIGG3.off()
	}
	//Реакция на пожарную сигнализацию
	if (TRIGG4.is_on()) {
		GGE.crEvent('Обнаружено задымление!', 1, 1, 'GGV', 'snd2', 0)
		TRIGG4.off()
	}

	checkTemp(th_kitch1, 24, 27, 3, T_KITCH1, 'На кухне')
	checkTemp(th_bath1, 24, 27, 3, T_BATH1, 'В ванной')
	checkTemp(th_bed1, 25, 27, 2, T_BEDRM1, 'В спальне')
	checkTemp(th_lvn1, 24, 27, 3, T_LVN1, 'В зале')
	checkTemp2(curDate, th_outd1, T_OUTDOOR1, 'На улице')

						
	  //Расход электроэнергии  
	  if (M_EL1.getDbl('LAST_NMIN_VOL') > 150
		  && !M_EL1.getBool('LATCHED_MAX_VAL')) {
		M_EL1.setBool('LATCHED_MAX_VAL', true)
		M_EL1.setBool('LATCHED_COMFORT_VAL', false)
		//Сделать объявление
		GGE.crEvent('Перерасход энергии!', 300, 1, 'GGV', 'snd2', 0)
	   
	   } else if (M_EL1.getDbl('LAST_NMIN_VOL') < 15
		 && !M_EL1.getBool('LATCHED_COMFORT_VAL')) {
	   
		M_EL1.setBool('LATCHED_MAX_VAL', false)
		M_EL1.setBool('LATCHED_COMFORT_VAL', true)
	
		//Сделать объявление
		GGE.crEvent('Потребление энергии нормально!', 300, 1, 'GGV', 'snd1', 0)
	   }
	   
	  //Теплый пол
	  if (C_FLOOR.getBool('SWITCHED_ON_SCHDL') != C_FLOOR.getBool('LATCHED_ON_SCHDL')) {
		  
		  
		  if (C_FLOOR.getBool('SWITCHED_ON_SCHDL')==true && C_FLOOR.getBool('SWITCHED_ON') == false) {
			  //Сделать объявление
			  GGE.crEvent('Я включила тёплый пол', 300, 1, 'GGV', 'snd4', 0)
			  C_FLOOR.setBool('SWITCHED_ON', true) //вкл. тёплый пол
		   } else if (C_FLOOR.getBool('SWITCHED_ON_SCHDL')==false && C_FLOOR.getBool('SWITCHED_ON') == true) {
			  C_FLOOR.setBool('SWITCHED_ON', false) //выкл. тёплый пол
			  GGE.crEvent('Я выключила тёплый пол!', 300, 1, 'GGV', 'snd4', 0)
		   }

		C_FLOOR.setBool('LATCHED_ON_SCHDL', C_FLOOR.getBool('SWITCHED_ON_SCHDL'))
			  
	  }	  	 
	  
		   

