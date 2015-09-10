package com.greengrass.house;

import java.util.HashMap;
import java.util.List;



//Набор объектов GG (загруженных из базы)
public abstract class AnySet {  /*abstract - класс абстрактный, только из производных классов можно делать объекты*/

	public List lobj;

	AnySet () {
	
	}
	
	AnySet (List lstobj) {
		lobj=lstobj;
		//rows=
	}
}

	
	
