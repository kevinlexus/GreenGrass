package com.ric.st;

import com.ric.st.prep.HouseManagementPreps;

public interface Throwers2 {
	
	public void importAccountData() throws Exception;
	/**
	 * 1 - Обновление, 0 - создание жилых помещения
	 * @throws Exception
	 */
	public void importHouseResidentialPremises(Integer action, HouseManagementPreps hm) throws Exception;
	/**
	 * 1 - Обновление, 0 - создание нежилых помещения
	 * @throws Exception
	 */
	public void importHousNonResidentialPremises(Integer action) throws Exception;
	/**
	 * 1 - Обновление, 0 - создание счетчиков
	 * @throws Exception
	 */
	public void importHouseMeteringDeviceData(Integer action) throws Exception;
	/**
	 * Получение данных о доме
	 * @throws Exception
	 */
	public void ExporttHouseData(String houseGUID,String pUN,String NpUN) throws Exception;
}
