package com.ric.st;

import com.ric.st.prep.HouseManagementPreps;

public interface HouseManagementBindingPreps2 {

	public void setHm(HouseManagementPreps hm);
	public HouseManagementPreps getHm();
	/**
	 * Создать запрос импорта
	 */
	public void prepReqImp();
	/** Общее Обновление Основных характеристик много квартирного дома
	 * @throws Exception
	 */
    public void prepApartmentHouseUpd();
	/** Обновление Основных характеристик много квартирного дома
	 * @throws Exception
	 */
    public void importHouseApartmentHouseUpdate() throws Exception;
    
    /**Общее Создание Основных характеристик много квартирного дома
	 * @throws Exception
	 */
	public void prepApartmentHouseCrt();
    /**Создание Основных характеристик много квартирного дома
	 * @throws Exception
	 */
	public void importHouseApartmentHouseCreate() throws Exception;
	
	/** Общее Обновление подъездов
	 * @throws Exception
	 */
	public void prepHouseEntranceUpd();
	/** Обновление подъездов
	 * @throws Exception
	 */
	public void importHouseEntranceUpdate() throws Exception;
	
	/**Общее создание подъездов
	 * @throws Exception
	 */
	public void prepHouseEntranceCrt();
	/** создание подъездов
	 * @throws Exception
	 */
	public void importHouseEntranceCreate() throws Exception;
	
	/**Общее Обновление лифтов
	 * @throws Exception
	 */
	public void prepHouseLiftUpd();
	/** Обновление лифтов
	 * @throws Exception
	 */
	public void importHouseLiftUpdate() throws Exception;
	
	/**Общее создание лифтов
	 * @throws Exception
	 */
	public void prepHouseLiftCrt();
	/**создание лифтов
	 * @throws Exception
	 */
	public void importHouseLiftCreate() throws Exception;
	
	/**Общее Обновление жилых помещения
	 * @throws Exception
	 */
	public void prepHouseResidentialPremisesUpd();
	/** Обновление жилых помещения
	 * @throws Exception
	 */
	public void importHouseResidentialPremisesUpdate() throws Exception;
	
	/**
	 * Обшее создание жилых помещения
	 * @throws Exception
	 */
	public void prepHouseResidentialPremisesCrt();
	/**
	 * создание жилых помещения
	 * @throws Exception
	 */
	public void importHouseResidentialPremisesCreate() throws Exception;
	
	
	/**
	 * Общее Обновление нежилых помещения
	 * @throws Exception
	 */
	public void prepHousNonResidentialPremisesUpd();
	/**
	 * Обновление нежилых помещения
	 * @throws Exception
	 */
	public void importHousNonResidentialPremisesUpdate() throws Exception;
	
	/**
	 * ОБщее cоздание нежилых помещения
	 * @throws Exception
	 */
	public void prepHousNonResidentialPremisesCrt();
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
