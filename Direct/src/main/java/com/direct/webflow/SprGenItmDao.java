package com.direct.webflow;

import java.util.List;
import com.greengrass.house.AnyApp;


public class SprGenItmDao {

	private AnyApp app;

	public SprGenItmDao(AnyApp app) {
		this.app=app;
	}

	
public List<SprGenItm> findAll() {
	app.beginTrans();

	@SuppressWarnings("unchecked")
	List<SprGenItm> result = (List<SprGenItm>) app.session.createQuery("select t from SprGenItm t").list();
	
	app.commitTrans();
	//app.commitTrans();
    return result;
}

}
