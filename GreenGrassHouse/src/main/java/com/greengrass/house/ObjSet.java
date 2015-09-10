package com.greengrass.house;

import java.util.HashMap;
import java.util.List;

//класс - набор объектов GG
public final class ObjSet extends AnySet {

	public HashMap<Integer, Obj> mapobj;
	public ObjSet() {
		super();
		mapobj = new HashMap<Integer, Obj>();
	}

	public ObjSet(List lobj) {
		super(lobj);
		mapobj = new HashMap<Integer, Obj>();
		LoadSet(lobj);
	}
	
	public void LoadSet(List lobj) {
		//загрузка объектов типа Obj из List в HashMap
		Message mess=new Message();
		super.lobj=lobj;
		mapobj.clear();

		for(Object o : super.lobj)
		{
		   Obj ob=(Obj)o;  	
		   mapobj.put(ob.getId(), ob);
		}
	}
}