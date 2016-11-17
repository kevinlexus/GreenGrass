package com.ric.st;

import com.ric.st.prep.HouseManagementPreps;

import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse;

public interface Throwers2 {
	/**
	 * 1 - Обновление, 0 - создание Основных характеристик много квартирного дома
	 * @throws Exception
	 */
	public ApartmentHouse impApartmentHouse(Integer action, HouseManagementPreps hm) throws Exception;
	
	public void importAccountData() throws Exception;
	/**
	 * 1 - Обновление, 0 - создание лифтов
	 * @throws Exception
	 */
	public void importHouseLift(Integer action, HouseManagementPreps hm) throws Exception;
	/**
	 * 1 - Обновление, 0 - создание подъездов
	 * @throws Exception
	 */
	public void importHouseEntrance(Integer action, HouseManagementPreps hm) throws Exception;
	/**
	 * 1 - Обновление, 0 - создание жилых помещения
	 * @throws Exception
	 */
	public void importHouseResidentialPremises(Integer action, HouseManagementPreps hm) throws Exception;
	/**
	 * 1 - Обновление, 0 - создание нежилых помещения
	 * @throws Exception
	 */
	public void importHousNonResidentialPremises(Integer action, HouseManagementPreps hm) throws Exception;
	/**
	 * 1 - Обновление, 0 - создание счетчиков
	 * @throws Exception
	 */
	public void importHouseMeteringDeviceData(Integer action) throws Exception;
	/**
	 * Получение данных о доме
	 * @throws Exception
	 */
	public String fExportHouseData(String houseGUID,String pUn,String nPun) throws Exception;
}
