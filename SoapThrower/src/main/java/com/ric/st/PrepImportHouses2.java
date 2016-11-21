package com.ric.st;

import com.ric.st.prep.HouseManagementPreps;

public interface PrepImportHouses2 {

	public void setHm(HouseManagementPreps hm);
	public HouseManagementPreps getHm();
	/** Обновление Основных характеристик много квартирного дома
	 * @throws Exception
	 */
    public void importHouseApartmentHouseUpdate() throws Exception;
    /** Общее Обновление Основных характеристик много квартирного дома
	 * @throws Exception
	 */
	public void importHouseApartmentHouseCreate() throws Exception;
	/** Обновление подъездов
	 * @throws Exception
	 */
	public void importHouseEntranceUpdate() throws Exception;
	/** создание подъездов
	 * @throws Exception
	 */
	public void importHouseEntranceCreate() throws Exception;
	/** Обновление лифтов
	 * @throws Exception
	 */
	public void importHouseLiftUpdate() throws Exception;
	/**создание лифтов
	 * @throws Exception
	 */
	public void importHouseLiftCreate() throws Exception;
	/** Обновление жилых помещения
	 * @throws Exception
	 */
	public void importHouseResidentialPremisesUpdate() throws Exception;
	/**
	 * создание жилых помещения
	 * @throws Exception
	 */
	public void importHouseResidentialPremisesCreate() throws Exception;
	/**
	 * Обновление нежилых помещения
	 * @throws Exception
	 */
	public void importHousNonResidentialPremisesUpdate() throws Exception;
	/**
	 * cоздание нежилых помещения
	 * @throws Exception
	 */
	public void importHousNonResidentialPremisesCreate() throws Exception;
	/**
	 * Импорт лицевого счета
	 * @throws Exception
	 */
	public void importAccountData() throws Exception;
	/**
	 * Обновление счетчиков
	 * @throws Exception
	 */
	public void importHouseMeteringDeviceUpdate() throws Exception;
	/**
	 * Создание счетчиков
	 * @throws Exception
	 */
	public void importHouseMeteringDeviceDataCreate() throws Exception;
	/**
	 * Получение данных о доме
	 * @throws Exception
	 */
	public String ExportHouseData(String houseGUID,String pUn,String nPun) throws Exception; 
}
