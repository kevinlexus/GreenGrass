package com.greengrass.house;
import java.util.HashMap;
import java.util.List;

public final class RowSet extends AnySet{

	public List<Object[]> rows;
	
	public RowSet(List<Object[]> rs) {  //Хрень! Не нужно!
		super();
		rows=rs;
		//LoadSet(rs); --зачем это здесь????
	}
	
	/*private void LoadSet(List<Object[]> rs) {
		//загрузка строк
		List<Object[]> rows = rs;
	}*/
}
