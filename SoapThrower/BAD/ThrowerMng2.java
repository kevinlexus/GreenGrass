package com.ric.st.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.BindingProvider;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.terracotta.modules.ehcache.async.AsyncConfig;

import com.ric.bill.Utl;
import com.ric.st.SoapPreps;
import com.ric.st.Throwers2;
import com.ric.st.prep.HouseManagementPreps;
import com.sun.xml.ws.developer.WSBindingProvider;

import ru.gosuslugi.dom.schema.integration.house_management.AccountIndType;
import ru.gosuslugi.dom.schema.integration.house_management.ApartmentHouseUOType;
import ru.gosuslugi.dom.schema.integration.house_management.ApartmentHouseUOType.BasicCharacteristicts;
import ru.gosuslugi.dom.schema.integration.house_management.ApartmentHouseUpdateUOType;
import ru.gosuslugi.dom.schema.integration.house_management.ExportAccountResultType;
import ru.gosuslugi.dom.schema.integration.house_management.AccountType.Accommodation;
import ru.gosuslugi.dom.schema.integration.house_management.AccountType.PayerInfo;
import ru.gosuslugi.dom.schema.integration.house_management.EntranceUOType;
import ru.gosuslugi.dom.schema.integration.house_management.ExportHouseRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportHouseResult;
import ru.gosuslugi.dom.schema.integration.house_management.ExportHouseResultType;
import ru.gosuslugi.dom.schema.integration.house_management.ExportHouseResultType.ApartmentHouse.Entrance;
import ru.gosuslugi.dom.schema.integration.house_management.ExportHouseResultType.ApartmentHouse.NonResidentialPremises;
import ru.gosuslugi.dom.schema.integration.house_management.GKNEGRPKeyType;
import ru.gosuslugi.dom.schema.integration.house_management.HouseBasicUOType;
import ru.gosuslugi.dom.schema.integration.house_management.HouseBasicUpdateUOType;
import ru.gosuslugi.dom.schema.integration.house_management.ImportAccountRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportAccountRequest.Account;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ApartmentHouseToCreate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ApartmentHouseToUpdate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.EntranceToCreate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.EntranceToUpdate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.LiftToCreate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.LiftToUpdate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.NonResidentialPremiseToCreate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.NonResidentialPremiseToUpdate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ResidentialPremises;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToCreate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToUpdate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportMeteringDeviceDataRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportMeteringDeviceDataRequest.MeteringDevice;
import ru.gosuslugi.dom.schema.integration.house_management.ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportResult;
import ru.gosuslugi.dom.schema.integration.house_management.ImportResult.CommonResult;
import ru.gosuslugi.dom.schema.integration.house_management.MeteringDeviceBasicCharacteristicsType;
import ru.gosuslugi.dom.schema.integration.house_management.MeteringDeviceBasicCharacteristicsType.ApartmentHouseDevice;
import ru.gosuslugi.dom.schema.integration.house_management.MeteringDeviceBasicCharacteristicsType.NonResidentialPremiseDevice;
import ru.gosuslugi.dom.schema.integration.house_management.MeteringDeviceBasicCharacteristicsType.ResidentialPremiseDevice;
import ru.gosuslugi.dom.schema.integration.house_management.MeteringDeviceFullInformationType;
import ru.gosuslugi.dom.schema.integration.house_management.MeteringDeviceToUpdateAfterDevicesValuesType;
import ru.gosuslugi.dom.schema.integration.house_management.NonResidentialPremisesUOType;
import ru.gosuslugi.dom.schema.integration.house_management_service.HouseManagementPortsType;
import ru.gosuslugi.dom.schema.integration.house_management_service.HouseManagementService;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;

@RunWith(SpringJUnit4ClassRunner.class)
// только для JUnit, можно убрать!
@ContextConfiguration(classes = { AsyncConfig.class })
// только для JUnit, можно убрать!
@Service
public class ThrowerMng2 implements Throwers2 {

	@Autowired
	private ApplicationContext ctx;
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private Config config;

	/**
	 * Инициализация сервиса HouseManagementService для многоквартирных домов
	 * ApartmentHouse ah для счетчиков ImportMeteringDeviceDataRequest ireq
	 * 
	 * @throws Exception
	 */
	public ImportResult doHouseManagementService(ApartmentHouse ah,
			ImportMeteringDeviceDataRequest ireq) throws Exception {
		ImportResult res = null;
		// создать сервис и порт
		HouseManagementService service = new HouseManagementService();
		HouseManagementPortsType port = service.getHouseManagementPort();
		// подготовительный объект
		SoapPreps sp = new SoapPrep((BindingProvider) port,
				(WSBindingProvider) port);

		// подписывать XML?
		sp.setSignXML(true);

		// заменить Endpoint, если надо
		if (config.isSrvTest()) {
			sp.changeHost(config.getSrvTestHost());
		}

		// создать и подготовить заголовок запроса
		sp.createRh(new Date(), Utl.getRndUuid(), config.getOrgPPGuid(), true);
		if (ah != null) {
			ImportHouseUORequest req = new ImportHouseUORequest();
			req.setId("foo");
			req.setVersion(req.getVersion());

			req.setApartmentHouse(ah);

			// создание XML, маршаллинг
			port.importHouseUOData(req);
			// отправка SOAP, анмаршаллинг результата
			// Исправлять классы под соответствующий запрос!
			res = (ImportResult) sp.sendSOAP( // исправить
					HouseManagementPortsType.class, // исправить
					req, "importHouseUOData", // исправить
					new ImportResult(), // исправить
					config.getBscLogin(), config.getBscPass());
		} else {
			if (ireq != null) {
				ireq.setId("foo");
				ireq.setVersion(ireq.getVersion());

				// создание XML, маршаллинг
				port.importMeteringDeviceData(ireq);
				// отправка SOAP, анмаршаллинг результата
				// Исправлять классы под соответствующий запрос!
				res = (ImportResult) sp.sendSOAP( // исправить
						HouseManagementPortsType.class, // исправить
						ireq, "ImportMeteringDeviceData", // исправить
						new ImportResult(), // исправить
						config.getBscLogin(), config.getBscPass());
			}
		}
		return res;
	}

	/**
	 * Инициализация сервиса HouseManagementService Export для домов
	 * ExportHouseRequest req
	 * 
	 * @throws Exception
	 */
	public ExportHouseResult doHouseManagementServiceExport(
			ExportHouseRequest req) throws Exception {
		ExportHouseResult res = null;
		// создать сервис и порт
		HouseManagementService service = new HouseManagementService();
		HouseManagementPortsType port = service.getHouseManagementPort();

		// подготовительный объект
		SoapPreps sp = new SoapPrep((BindingProvider) port,
				(WSBindingProvider) port);

		// подписывать XML?
		sp.setSignXML(true);

		// заменить Endpoint, если надо
		if (config.isSrvTest()) {
			sp.changeHost(config.getSrvTestHost());
		}

		// создать и подготовить заголовок запроса
		sp.createRh(new Date(), Utl.getRndUuid(), config.getOrgPPGuid(), true);
		req.setId("foo");
		// создание XML, маршаллинг
		port.exportHouseData(req);
		// отправка SOAP, анмаршаллинг результата
		// Исправлять классы под соответствующий запрос!
		res = (ExportHouseResult) sp.sendSOAP( // исправить
				HouseManagementPortsType.class, // исправить
				req, "ExportHouseData", // исправить
				new ExportHouseResult(), // исправить
				config.getBscLogin(), config.getBscPass());
		return res;
	}

	/**
	 * 1 - Обновление, 0 - создание Основных характеристик много квартирного
	 * дома
	 * 
	 * @param <HouseBasicCreateUOType>
	 * @throws Exception
	 */
	public ApartmentHouse impApartmentHouse(Integer action,
			HouseManagementPreps hm) throws Exception {
		ApartmentHouse ah = new ApartmentHouse();
		if (action == 0) {
			ApartmentHouseToCreate ac = new ApartmentHouseToCreate();
			ah.setApartmentHouseToCreate(ac);
			// ac.setMinFloorCount((byte)5);
			ac.setUndergroundFloorCount("0");
			ac.setTransportGUID(Utl.getRndUuid().toString());
			ApartmentHouseUOType.BasicCharacteristicts bc = new ApartmentHouseUOType.BasicCharacteristicts();
			ac.setBasicCharacteristicts(bc);
			bc.setFIASHouseGuid(hm.getHouseGuid());
			bc.setNoRSOGKNEGRPRegistered(true);
			bc.setTotalSquare(BigDecimal.valueOf(hm.getTotalSquare()));
			// bc.setUsedYear(BigDecimal.valueOf(1970d).shortValue());
			bc.setUsedYear(BigDecimal.valueOf(hm.getUsedYear()).shortValue());
			// bc.setCulturalHeritage(false);
			bc.setCulturalHeritage(hm.getCultHerit());
			// bc.setState(hm.getState());
			bc.setFloorCount(hm.getFloorCount());

			NsiRef ns = new NsiRef();
			bc.setState(ns);
			ns.setName(hm.getState()); // TODO! переделать на поиск!
			ns.setCode("2");
			ns.setGUID("57c4dbc5-bdd5-4490-92e1-3e687797b32a");
		} else {
			ApartmentHouseToUpdate au = new ApartmentHouseToUpdate();
			ah.setApartmentHouseToUpdate(au);
			// au.setMinFloorCount((byte)5);
			au.setUndergroundFloorCount("0");
			au.setTransportGUID(Utl.getRndUuid().toString());
			HouseBasicUpdateUOType bc = new HouseBasicUpdateUOType();
			au.setBasicCharacteristicts(bc);
			bc.setFIASHouseGuid(hm.getHouseGuid());
			bc.setNoRSOGKNEGRPRegistered(true);
			bc.setTotalSquare(BigDecimal.valueOf(hm.getTotalSquare()));
			// bc.setUsedYear(BigDecimal.valueOf(1970d).shortValue());
			bc.setUsedYear(BigDecimal.valueOf(hm.getUsedYear()).shortValue());
			// bc.setCulturalHeritage(false);
			bc.setCulturalHeritage(hm.getCultHerit());
			// bc.setState(hm.getState());
			bc.setFloorCount(hm.getFloorCount());

			NsiRef ns = new NsiRef();
			bc.setState(ns);
			ns.setName(hm.getState()); // TODO! переделать на поиск!
			ns.setCode("2");
			ns.setGUID("57c4dbc5-bdd5-4490-92e1-3e687797b32a");
		}
		return ah;
	}

	/**
	 * 1 - Обновление, 0 - создание подъездов
	 * 
	 * @throws Exception
	 */
	public void importHouseEntrance(Integer action, HouseManagementPreps hm)
			throws Exception {

		ApartmentHouse ah = impApartmentHouse(1, hm);

		if (action == 0) {
			EntranceToCreate etc = new EntranceToCreate();
			ah.getEntranceToCreate().add(etc);
			// Дата постройки
			etc.setCreationDate(Utl.getXMLDate(Utl.getDateFromStr("01.01.2015")));
			// Номер подъезда
			etc.setEntranceNum("3");
			// Количество этажей
			etc.setStoreysCount((byte) 5);
			// ID транспорт ID
			etc.setTransportGUID(Utl.getRndUuid().toString());
		} else {
			EntranceToUpdate etu = new EntranceToUpdate();
			ah.getEntranceToUpdate().add(etu);
			EntranceToCreate etc = new EntranceToCreate();
			ah.getEntranceToCreate().add(etc);
			// Дата постройки
			etu.setCreationDate(Utl.getXMLDate(Utl.getDateFromStr("01.01.2015")));
			// Номер подъезда
			etu.setEntranceNum("3");
			// Количество этажей
			etu.setStoreysCount((byte) 9);
			// ID транспорт ID
			etu.setTransportGUID(Utl.getRndUuid().toString());
		}
		;
		ImportResult res = doHouseManagementService(ah, null);

		for (CommonResult cr : res.getCommonResult()) {
			System.out.println("GUID: " + cr.getGUID());
			System.out.println("Unique nomer: " + cr.getUniqueNumber());
			System.out.println("Transport GUID: " + cr.getTransportGUID());
		}
		System.out.println("res:" + res.getCommonResult());
	}

	/**
	 * 1 - Обновление, 0 - создание подъездов
	 * 
	 * @throws Exception
	 */
	public void importHouseLift(Integer action, HouseManagementPreps hm)
			throws Exception {

		ApartmentHouse ah = impApartmentHouse(1, hm);
		if (action == 0) {
			LiftToCreate ltc = new LiftToCreate();
			ah.getLiftToCreate().add(ltc);
			// Заводской номер
			ltc.setFactoryNum("uw-93875834-397489");
			// Номер подъезда
			ltc.setEntranceNum("1");
			// Предельный срок эксплуатации
			ltc.setOperatingLimit(10);
			// Тип лифта
			// NsiRef nr = new NsiRef();
			// ltc.setType(nr);
			// nr.setCode(value);
			// nr.setGUID(value);
			// ID транспорт ID
			ltc.setTransportGUID(Utl.getRndUuid().toString());
		} else {
			LiftToUpdate ltu = new LiftToUpdate();
			ah.getLiftToUpdate().add(ltu);
			// Заводской номер
			ltu.setFactoryNum("uw-93875834-397489");
			// Номер подъезда
			ltu.setEntranceNum("1");
			// Предельный срок эксплуатации
			ltu.setOperatingLimit(10);
			// Тип лифта
			// NsiRef nr = new NsiRef();
			// ltu.setType(nr);
			// nr.setCode(value);
			// nr.setGUID(value);
			// ID транспорт ID
			ltu.setTransportGUID(Utl.getRndUuid().toString());
		}
		;

		ImportResult res = doHouseManagementService(ah, null);
		for (CommonResult cr : res.getCommonResult()) {
			System.out.println("GUID: " + cr.getGUID());
			System.out.println("Unique nomer: " + cr.getUniqueNumber());
			System.out.println("Transport GUID: " + cr.getTransportGUID());
		}
		System.out.println("res:" + res.getCommonResult());
	}

	/**
	 * 1 - Обновление, 0 - создание жилых помещения
	 * 
	 * @throws Exception
	 */
	public void importHouseResidentialPremises(Integer action,
			HouseManagementPreps hm) throws Exception {

		ApartmentHouse ah = impApartmentHouse(1, hm);

		ResidentialPremises rp = new ResidentialPremises();
		ah.getResidentialPremises().add(rp);
		if (action == 0) {
			ResidentialPremisesToCreate rptc = new ResidentialPremisesToCreate();
			rp.setResidentialPremisesToCreate(rptc);
			// Нет кадастрового номера
			rptc.setNoRSOGKNEGRPRegistered(true);
			// Номер помещения
			rptc.setPremisesNum("3");
			// Номер подъезда
			rptc.setEntranceNum("1");
			// Общая площадь помещения
			rptc.setTotalArea(BigDecimal.valueOf(101));
			//
			rptc.setGrossArea(BigDecimal.valueOf(101));
			// Тип помещения
			NsiRef nr = new NsiRef();
			// Отдельная квартира
			nr.setCode("1");
			nr.setGUID("96a1ce61-b402-46c4-ac6e-34b8670480af");
			// Квартира коммунального заселения
			// nr.setCode("2");
			// nr.setGUID("8cf0b66a-20bd-4b70-9324-d8fb740d8c48");
			// Общежитие
			// nr.setCode("3");
			// nr.setGUID("35b515c6-5b2a-48c8-94e7-5745b0406635");
			rptc.setPremisesCharacteristic(nr);

			// ID транспорт ID
			rptc.setTransportGUID(Utl.getRndUuid().toString());
			// Дата закрытия помещения
			// rptc.setTerminationDate(Utl.getXMLDate(Utl.getDateFromStr("10.01.2016")));

		} else {
			ResidentialPremisesToUpdate rpu = new ResidentialPremisesToUpdate();
			rp.setResidentialPremisesToUpdate(rpu);
			// Нет кадастрового номера
			rpu.setNoRSOGKNEGRPRegistered(true);
			// Номер помещения
			rpu.setPremisesNum("1");
			// Номер подъезда
			rpu.setEntranceNum("1");
			// Общая площадь помещения
			rpu.setTotalArea(BigDecimal.valueOf(555.55));
			//
			rpu.setGrossArea(BigDecimal.valueOf(555.55));

			// Тип помещения
			// NsiRef nr = new NsiRef();
			// Отдельная квартира
			// nr.setCode("1");
			// nr.setGUID("96a1ce61-b402-46c4-ac6e-34b8670480af");
			// Квартира коммунального заселения
			// nr.setCode("2");
			// nr.setGUID("8cf0b66a-20bd-4b70-9324-d8fb740d8c48");
			// Общежитие
			// nr.setCode("3");
			// nr.setGUID("35b515c6-5b2a-48c8-94e7-5745b0406635");
			// rpu.setPremisesCharacteristic(nr);

			// ID помещения
			// rpu.setPremisesGUID(Utl.getRndUuid().toString()); //WHAT IS IT?
			// rpu.setPremisesGUID("810321c3-f0b4-454a-9a1c-cad82adebd58");

			// ID транспорт ID
			rpu.setTransportGUID(Utl.getRndUuid().toString());
			// Дата закрытия помещения
			// rpu.setTerminationDate(Utl.getXMLDate(Utl.getDateFromStr("10.01.2016")));

		}
		;
		ImportResult res = doHouseManagementService(ah, null);

		for (CommonResult cr : res.getCommonResult()) {
			System.out.println("GUID: " + cr.getGUID());
			System.out.println("Unique nomer: " + cr.getUniqueNumber());
			System.out.println("Transport GUID: " + cr.getTransportGUID());
		}
		System.out.println("res:" + res.getCommonResult());
	}

	/**
	 * 1 - Обновление, 0 - создание нежилых помещения
	 * 
	 * @throws Exception
	 */
	public void importHousNonResidentialPremises(Integer action,
			HouseManagementPreps hm) throws Exception {

		ApartmentHouse ah = impApartmentHouse(1, hm);

		if (action == 0) {
			NonResidentialPremiseToCreate nrptc = new NonResidentialPremiseToCreate();
			ah.getNonResidentialPremiseToCreate().add(nrptc);
			// Нет кадастрового номера
			nrptc.setNoRSOGKNEGRPRegistered(true);
			// Номер помещения
			nrptc.setPremisesNum("1н");
			// Общая площадь помещения
			nrptc.setTotalArea(BigDecimal.valueOf(1000));
			// Общее имущество
			nrptc.setIsCommonProperty(true);
			// ID транспорт ID
			nrptc.setTransportGUID(Utl.getRndUuid().toString());
		} else {
			NonResidentialPremiseToUpdate nrpu = new NonResidentialPremiseToUpdate();
			ah.getNonResidentialPremiseToUpdate().add(nrpu);
			// Нет кадастрового номера
			// nrpu.setNoRSOGKNEGRPRegistered(true);
			// Номер помещения
			// rpu.setPremisesNum("1");
			// Общая площадь помещения
			nrpu.setTotalArea(BigDecimal.valueOf(50));
			// ID помещения
			// nrpu.setPremisesGUID("9PHc0000400001");
			// ID транспорт ID
			nrpu.setTransportGUID(Utl.getRndUuid().toString());
		}
		;

		ImportResult res = doHouseManagementService(ah, null);
		for (CommonResult cr : res.getCommonResult()) {
			System.out.println("GUID: " + cr.getGUID());
			System.out.println("Unique nomer: " + cr.getUniqueNumber());
			System.out.println("Transport GUID: " + cr.getTransportGUID());
		}
		System.out.println("res:" + res.getCommonResult());
	}

	/**
	 * Импорт лицевого счета
	 * 
	 * @throws Exception
	 */
	public void importAccountData() throws Exception {
		// Отправить файл, получить GUID его
		// FileExchanges fe = new FileExchange();
		// String fileGuid = fe.send();

		// создать сервис и порт
		HouseManagementService service = new HouseManagementService();
		HouseManagementPortsType port = service.getHouseManagementPort();

		// подготовительный объект
		SoapPreps sp = new SoapPrep((BindingProvider) port,
				(WSBindingProvider) port);

		// подписывать XML?
		sp.setSignXML(true);

		// заменить Endpoint, если надо
		if (config.isSrvTest()) {
			sp.changeHost(config.getSrvTestHost());
		}

		// создать и подготовить заголовок запроса
		sp.createRh(new Date(), Utl.getRndUuid(), config.getOrgPPGuid(), true);

		ImportAccountRequest req = new ImportAccountRequest();
		req.setId("foo");

		Account ac = new Account();
		req.getAccount().add(ac);
		// Управляющая компания
		ac.setIsUOAccount(true);
		// Дата открытия счета
		ac.setCreationDate(Utl.getXMLDate(Utl.getDateFromStr("01.01.2016")));
		// Количество проживающих
		ac.setLivingPersonsNumber(Byte.valueOf("2"));
		// Общая площадь
		ac.setTotalSquare(BigDecimal.valueOf(100, 25));
		// Жилая площадь
		ac.setResidentialSquare(BigDecimal.valueOf(100, 25));
		// Отапливаемая площадь
		ac.setHeatedArea(BigDecimal.valueOf(100, 25));

		// Закрытие счета
		// ClosedAccountAttributesType cl_ac = new
		// ClosedAccountAttributesType();
		// Дата закрытия
		// cl_ac.setCloseDate(Utl.getXMLDate(Utl.getDateFromStr("10.01.2016")));

		// Основание закрытия
		// NsiRef cl_ac_r = new NsiRef();
		// 10 - Ошибка ввода
		// f863ff59-1eae-414e-a283-574f95f1cc6f
		// cl_ac_r.setCode("10");
		// cl_ac_r.setGUID("f863ff59-1eae-414e-a283-574f95f1cc6f");
		// cl_ac.setCloseReason(cl_ac_r);
		// ac.setClosed(cl_ac);

		// Транспортный GUID
		ac.setTransportGUID(Utl.getRndUuid().toString());
		// Старый номер лицевого счета
		ac.setAccountNumber("57200001");
		// Новый номер лицевого счета
		ac.setAccountGUID("10АА072155");

		// Привязка к помещению
		Accommodation ac_com = new Accommodation();
		// GUID квартиры
		// новый лицевой - нужно создать помещение
		// найти, если уже есть и привязать
		ac_com.setPremisesGUID("9PHc0000400001");
		// GUID дома
		// ac_com.setFIASHouseGuid("");
		// GUID комнаты
		// ac_com.setLivingRoomGUID("");
		// Доля оплаты
		ac_com.setSharePercent(BigDecimal.valueOf(100));

		ac.getAccommodation().add(ac_com);

		// Сведения о плательщике
		PayerInfo pai = new PayerInfo();
		// Является нанимателем
		pai.setIsRenter(true);
		// Жилец
		AccountIndType ait = new AccountIndType();
		ait.setFirstName("Я");
		ait.setSurname("Я");
		ait.setPatronymic("Яичев");
		ait.setDateOfBirth(Utl.getXMLDate(Utl.getDateFromStr("10.01.2015")));
		ait.setSNILS(null);
		pai.setInd(ait);
		// Организация
		// RegOrgVersionType rovt = RegOrgVersionType();
		// rovt.setOrgVersionGUID("");
		// pai.setOrg(rovt);

		ac.setPayerInfo(pai);

		req.setVersion(req.getVersion());
		// создание XML, маршаллинг, подпись его внутри хэндлера
		port.importAccountData(req);

		// отправка SOAP, анмаршаллинг результата
		// Исправлять классы под соответствующий запрос!
		ImportResult res = (ImportResult) sp.sendSOAP( // исправить
				HouseManagementPortsType.class, // исправить
				req, "importAccountData", // исправить
				new ImportResult(), // исправить
				config.getBscLogin(), config.getBscPass());

		System.out.println("res:" + res.getCommonResult());
	}

	/**
	 * 1 - Обновление, 0 - создание счетчиков
	 * 
	 * @throws Exception
	 */
	public void importHouseMeteringDeviceData(Integer action) throws Exception {

		ImportMeteringDeviceDataRequest req = new ImportMeteringDeviceDataRequest();
		req.setFIASHouseGuid("810321c3-f0b4-454a-9a1c-cad82adebd58");

		MeteringDevice md = new MeteringDevice();
		req.getMeteringDevice().add(md);
		md.setTransportGUID(Utl.getRndUuid().toString());
		MeteringDeviceFullInformationType mdfit = new MeteringDeviceFullInformationType();

		MeteringDeviceBasicCharacteristicsType mDbct = new MeteringDeviceBasicCharacteristicsType();
		mdfit.setBasicChatacteristicts(mDbct);
		// Марка
		mDbct.setMeteringDeviceStamp("ЕС");
		// Модель
		mDbct.setMeteringDeviceModel("ЕС-300");
		// Номер
		mDbct.setMeteringDeviceNumber("300000000000");
		// Дата ввода в эксплуатацию
		mDbct.setCommissioningDate(Utl.getXMLDate(Utl
				.getDateFromStr("10.01.2015")));
		// Дата установки
		mDbct.setInstallationDate(Utl.getXMLDate(Utl
				.getDateFromStr("10.01.2015")));
		// Наличие возможности дистанционного снятия показаний
		mDbct.setRemoteMeteringMode(false);

		// Дата последней поверки (поле обязательно для заполнения, если ПУ -
		// коллективный (общедомовой))
		// mDbct.setFirstVerificationDate(Utl.getXMLDate(Utl.getDateFromStr("10.01.2015")));

		// Межповерочный интервал (НСИ 16) (поле обязательно для заполнения,
		// если ПУ - коллективный (общедомовой))
		// VerificationInterval nsiRef
		// Дата опломбирования ПУ заводом-изготовителем (обязательно для
		// заполнения при импорте)
		// mDbct.setFactorySealDate(Utl.getXMLDate(Utl.getDateFromStr("10.01.2015")));
		// Наличие датчиков температры
		mDbct.setTemperatureSensor(false);
		// Наличие датчиков давления
		mDbct.setPressureSensor(false);

		// Характеристики ИПУ жилого дома (значение справочника
		// "Вид прибора учета" = индивидуальный, тип дома = жилой дом)
		// mDbct.setApartmentHouseDevice
		// Идентификатор ЛС
		// mDbct.setAccountGUID()
		// Характеристики общеквартирного ПУ (для квартир коммунального
		// заселения) (значение справочника "Вид прибора учета" = Общий
		// (квартирный))
		// mDbct.setCollectiveApartmentDevice
		// Идентификатор жилого помещения
		// mDbct.PremiseGUID
		// Идентификатор ЛС
		// mDbct.AccountGUID
		// Характеристики общедомового ПУ (значение справочника
		// "Тип прибора учета" = коллективный (общедомомвой))
		// mDbct.CollectiveDevice
		// Информация о наличии возможности дистанционного снятия показаний ПУ
		// указанием наименования установленной системы (обязательно для
		// заполнения, если tns:RemoteMeteringMode = true, в противном случае
		// поле не обрабатывается при импорте)
		// MeteringDeviceToUpdateAfterDevicesValuesType mDtyadt = new
		// MeteringDeviceToUpdateAfterDevicesValuesType();
		// mDbct.setRemoteMeteringInfo(false);
		// Информация о наличии датчиков температуры с указанием их
		// местоположения на узле учета (обязательно для заполнения, если
		// tns:TemperatureSensor = true, в противном случае поле не
		// обрабатывается при импорте)
		// mDbct.TemperatureSensingElementInfo

		// Информация о наличии датчиков давления с указанием их местоположения
		// на узле учета (обязательно для заполнения, если tns:PressureSensor =
		// true, в противном случае поле не обрабатывается при импорте)
		// mDbct.PressureSensingElementInfo
		// Электронный образ проекта узла учета
		// mDbct.ProjectRegistrationNode --AttachmentType
		// Электронный образ акта ввода узла учета в эксплуатацию
		// mDbct.Certificate --AttachmentType
		// Характеристики комнатного ИПУ (значение справочника
		// "Вид прибора учета" = Комнатный
		// mDbct.LivingRoomDevice
		// Идентификатор комнаты
		// mDbct.LivingRoomGUID --GUIDType
		// Идентификатор ЛС
		// mDbct.AccountGUID -- GUIDType
		// Характеристики ИПУ нежилого помещения (значение справочника
		// "Вид прибора учета" = индивидуальный)
		// mDbct.NonResidentialPremiseDevice
		// Идентификатор помещения (тип = нежилое помещение)
		// mDbct.PremiseGUID --GUIDType
		// Идентификатор ЛС
		// mDbct.AccountGUID --GUIDType
		// Характеристики ИПУ жилого помещения (значение справочника
		// "Вид прибора учета" = индивидуальный)
		// mDbct.ResidentialPremiseDevice
		// Идентификатор помещения (тип = жилое помещение)
		// mDbct.PremiseGUID -- GUIDType
		// Идентификатор ЛС
		// mDbct.setAccountGUID(GUIDType);
		if (action == 0) {
			md.setDeviceDataToCreate(mdfit);
			// Привязка к жилому помещению
			ResidentialPremiseDevice rPd = new ResidentialPremiseDevice();
			mDbct.setResidentialPremiseDevice(rPd);
			rPd.setPremiseGUID("");
			// Привязка к нежилому помещению
			// NonResidentialPremiseDevice nRpd = new
			// NonResidentialPremiseDevice();
			// mDbct.setNonResidentialPremiseDevice(nRpd);
			// nRpd.setPremiseGUID("");
		} else {
			DeviceDataToUpdate ddu = new DeviceDataToUpdate();
			md.setDeviceDataToUpdate(ddu);
			ddu.setUpdateBeforeDevicesValues(mdfit);
			// Версионный ID
			ddu.setMeteringDeviceVersionGUID("");
		}
		ImportResult res = doHouseManagementService(null, req);
		System.out.println("res:" + res.getCommonResult());
	}

	/**
	 * Получение данных о доме
	 * 
	 * @throws Exception
	 */
	public String ExportHouseData(String houseGUID, String pUn, String nPun)
			throws Exception {
		String lret = "";

		ExportHouseRequest req = new ExportHouseRequest();

		if (houseGUID != null) {
			req.setFIASHouseGuid(houseGUID);
		} else {
			req.setFIASHouseGuid("810321c3-f0b4-454a-9a1c-cad82adebd58");
		}
		ExportHouseResult res = doHouseManagementServiceExport(req);
		if (pUn == null && nPun == null) {
			for (Entrance ent : res.getExportHouseResult().getApartmentHouse()
					.getEntrance()) {
				System.out.println("N entrance: " + ent.getEntranceNum());
				System.out.println("N entrance GUID: " + ent.getEntranceGUID());
				for (ru.gosuslugi.dom.schema.integration.house_management.ExportHouseResultType.ApartmentHouse.Entrance.ResidentialPremises ep : ent
						.getResidentialPremises()) {
					System.out.println("	N p : " + ep.getPremisesNum());
					System.out.println("	p_guid: " + ep.getPremisesGUID());
					System.out.println("	p_uni: "
							+ ep.getPremisesUniqueNumber());
				}
			}
			return " ";
		}
		;
		if (pUn != null) {
			for (Entrance ent : res.getExportHouseResult().getApartmentHouse()
					.getEntrance()) {
				for (ru.gosuslugi.dom.schema.integration.house_management.ExportHouseResultType.ApartmentHouse.Entrance.ResidentialPremises epr : ent
						.getResidentialPremises()) {
					if (epr.getPremisesNum() == pUn) {
						lret = epr.getPremisesGUID().toString();
					}
				}
			}
		}
		;
		if (nPun != null) {
			for (NonResidentialPremises nrpr : res.getExportHouseResult()
					.getApartmentHouse().getNonResidentialPremises()) {
				if (nrpr.getPremisesUniqueNumber() == nPun) {
					lret = nrpr.getPremisesGUID().toString();
				}
			}
		}
		return lret;
	}

}
