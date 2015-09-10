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
		+mess, 300, 1, 'GGV', 'snd1', 0)
	
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
		+mess, 300, 1, 'GGV', 'snd1', 0)

}


void checkTemp(int val, int diff, com.greengrass.house.Obj o, String txtWhere) {

	//Датчик температуры, контроль изменений температуры, каждые 3 градуса
    if (val-o.getDbl('LATCHED_LAST_VAL') >= diff) {
		o.setDbl('LATCHED_LAST_VAL', val)
		 //Сделать объявление
		if (val > 28) {
			GGE.crEvent(txtWhere+' стало жарко, '
				 +val+' градусов', 300, 1, 'GGV', 'snd1', 0)
		} else if ((val >= 24) && (val <= 28)) {
		  GGE.crEvent(txtWhere+' комфортная температура, '
			+val+' градусов', 300, 1, 'GGV', 'snd1', 0)
		} else {
			GGE.crEvent(txtWhere+' потеплело и стало, '
				+val+' градусов', 300, 1, 'GGV', 'snd1', 0)
				}
	} else if (val-o.getDbl('LATCHED_LAST_VAL') <= diff*-1)
	{
		o.setDbl('LATCHED_LAST_VAL', val)
		 //Сделать объявление
		if (val < 24) {
			GGE.crEvent(txtWhere+' стало холодно, '
				 +val+' градусов', 300, 1, 'GGV', 'snd1', 0)
		} else if ((val >= 24) && (val <= 28)) {
		  GGE.crEvent(txtWhere+' комфортная температура, '
			+val+' градусов', 1, 300, 'GGV', 'snd1', 0)
		} else {
			GGE.crEvent(txtWhere+' похолодало и стало, '
				+val+' градусов', 300, 1, 'GGV', 'snd1', 0)
		}
	}
//	println 'Check:'+txtWhere
}


/*ZONE2.on()
ZONE1.off()
GGE.crEvent('Сейчас звучит зона 2', 300, 1, 'GGV', 'snd1', 0)
*/

	//Вызвать обработчик расписания
	GGE.procScheduler()

	int flag=0
	int th_kitch1=T_KITCH1.getDbl('CELSIUS_VAL')
	int th_lvn1=T_LVN1.getDbl('CELSIUS_VAL')
	int th_bath1=T_BATH1.getDbl('CELSIUS_VAL')
	int th_bed1=T_BEDRM1.getDbl('CELSIUS_VAL')
	int th_outd1=T_OUTDOOR1.getDbl('CELSIUS_VAL')
	
	
	//Реакция на нажатие кнопки у входа 
	if (TRIGG1.is_on()) {
		TRIGG1.off()
		if (!HOUSE.getBool('PEOPLE_EXIST')) {
			GGE.crEvent('AT_HOME', 'Я рада вас видеть дома!', 10, 1, 'GGV', 'snd1', 0)
			HOUSE.setBool('PEOPLE_EXIST', true)
		} else {
			GGE.crEvent('AT_HOME', 'Вы собираетесь покинуть дом? Всего хорошего вам!', 10, 1, 'GGV', 'snd1', 1)
			HOUSE.setBool('PEOPLE_EXIST', false)
		} 
	}
	
	//Реакция на открытие двери
	if (TRIGG2.is_on()) {
		GGE.crEvent('DOOR_OPEN', 'Входная дверь открыта!', 300, 1, 'GGV', 'snd1', 0)
		TRIGG2.off()
	}
	//Реакция вход в подъезд с использованием домофона
	if (TRIGG3.is_on()) {
		GGE.crEvent('INTERCOM', 'Кто то звонил в домофон, и я - открыла!', 300, 1, 'GGV', 'snd1', 0)
		TRIGG3.off()
	}
	//Реакция на пожарную сигнализацию
	if (TRIGG4.is_on()) {
		GGE.crEvent('Обнаружено задымление!', 1, 1, 'GGV', 'snd1', 0)
		TRIGG4.off()
	}


	checkTemp(th_kitch1, 3, T_KITCH1, 'На кухне')
	checkTemp(th_bath1, 3, T_BATH1, 'В ванной')
	checkTemp(th_bed1, 3, T_BEDRM1, 'В спальне')
	checkTemp(th_lvn1, 3, T_LVN1, 'В зале')
	checkTemp(th_outd1, 5, T_OUTDOOR1, 'На улице')

						
	  //Расход электроэнергии  
	  if (M_EL1.getDbl('LAST_NMIN_VOL') > 150
		  && !M_EL1.getBool('LATCHED_MAX_VAL')) {
		M_EL1.setBool('LATCHED_MAX_VAL', true)
		M_EL1.setBool('LATCHED_COMFORT_VAL', false)
		//Сделать объявление
		GGE.crEvent('Что то кушает много энергии, проверьте это!', 300, 1, 'GGV', 'snd1', 0)
	   
	   } else if (M_EL1.getDbl('LAST_NMIN_VOL') < 15
		 && !M_EL1.getBool('LATCHED_COMFORT_VAL')) {
	   
		M_EL1.setBool('LATCHED_MAX_VAL', false)
		M_EL1.setBool('LATCHED_COMFORT_VAL', true)
	
		//Сделать объявление
		GGE.crEvent('Режим экономии электроэнергии в квартире теперь потянет!', 300, 1, 'GGV', 'snd1', 0)
	   }
	   
	  //Теплый пол
	  if (C_FLOOR.getBool('SWITCHED_ON_SCHDL') == false
		 && C_FLOOR.getBool('SWITCHED_ON') == true) {
		 //Сделать объявление
		 GGE.crEvent('Я включила тёплый пол, по расписанию', 300, 1, 'GGV', 'snd1', 0)
		 C_FLOOR.setBool('SWITCHED_ON', false) //режим сна тёплого пола
	  } else if (C_FLOOR.getBool('SWITCHED_ON_SCHDL') == true
		 && C_FLOOR.getBool('SWITCHED_ON') == false) {
		 C_FLOOR.setBool('SWITCHED_ON', true) //режим сна тёплого пола
		 GGE.crEvent('Я выключила тёплый пол!', 300, 1, 'GGV', 'snd1', 0)
	  }		 
		   

