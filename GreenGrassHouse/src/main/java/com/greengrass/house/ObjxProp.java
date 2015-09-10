//Этот класс создан, так как существующий ObxProp содержит @EmbeddedId, 
//который перпятствует мэппингу связей many to one, (A Foreign key refering com.greengrass.house.ObjxProp from com.greengrass.house.EvxObj has the wrong number of column)

package com.greengrass.house;


import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.Query;
import org.hibernate.Session;

import static java.nio.charset.StandardCharsets.*;

@Entity
@Table(name = "T_OBJXPROP")

public class ObjxProp implements java.io.Serializable {
	
	private Integer id;
	private Obj obj;
	private Property prop;
	//значение свойства - Double
	private Double n1;
	//значение свойства - Integer, Boolean
	private Integer i1;
	//значение свойства - String
	private String s1;
	//значение свойства - Date
	private Date d1;
	//CD свойства в owfs (может быть именем файла)
	private String owfs_cd;
	//Было обновлено в OWFS контроллером GGHouse
	private Integer updby1;
	//значение свойства - Следующее время доступа к записи-чтению свойства из (в) OWFS
	private Date nextacc;
	//Использовать директорию Alarm, для поиска значений свойства (1-да, 0-нет)
	private Integer usdiral;

	private Set<EvxObj> evxobj = new HashSet<EvxObj>();
	
	public ObjxProp() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
	@SequenceGenerator(name="SEQ", sequenceName="T_SEQ_ID", allocationSize=10)	
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id=id;
	}

	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="FK_OBJXPROP")
	public Set<EvxObj> getEvxObj() {
		return this.evxobj;
	}

	public void setEvxObj(Set<EvxObj> evxobj) {
		this.evxobj = evxobj;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_OBJ")
	public Obj getObj() {
		return this.obj;
	}
	public void setObj(Obj obj) {
		this.obj = obj;
	}
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_PROP")
	public Property getProperty() {
		return this.prop;
	}
	public void setProperty(Property prop) {
		this.prop = prop;
	}
	
	@Column(name = "S1", nullable = true, length = 256)
	public String getS1() {
		return this.s1;
	}
 
	public void setS1(String s1) {
		this.s1 = s1;
	}	

	@Column(name = "OWFS_CD", nullable = true, length = 256)
	public String getOwfsCd() {
		return this.owfs_cd;
	}
 
	public void setOwfsCd(String owfs_cd) {
		this.owfs_cd = owfs_cd;
	}	

	@Column(name = "N1", nullable = true)
	public Double getN1() { 
		return this.n1;
	}
 
	public void setN1(Double n1) {
		this.n1 = n1;
	}	

	@Column(name = "I1", nullable = true)
	public Integer getI1() { 
		return this.i1;
	}
 
	public void setI1(Integer i1) {
		this.i1 = i1;
	}	

	@Column(name = "D1", nullable = true)
	public Date getD1() {
		return this.d1;
	}
 
	public void setD1(Date d1) {
		this.d1 = d1;
	}	

	@Column(name = "UPD_BY1", nullable = false)
	public Integer getUpd1() { 
		return this.updby1;
	}
 
	public void setUpd1(Integer updby1) {
		this.updby1 = updby1;
	}	

	@Column(name = "USE_DIR_ALRM", nullable = false)
	public Integer getUsdiral() { 
		return this.usdiral;
	}
 
	public void setUsdiral(Integer usdiral) {
		this.usdiral = usdiral;
	}	

	//Аннотация говорит, что это не persistent свойство
	@Transient 
	public Date getNextAcc() { 
		return this.nextacc;
	}
 
	public void setNextAcc(Date nextacc) {
		this.nextacc = nextacc;
	}	

	//Создать событие по свойству объекта
	//НЕ УВЕРЕН, НА СКОЛЬКО ОПРАВДАНО СОБЫТИЕ ПО СВОЙСТВУ ОБЪЕКТА, ПОКА ОСТАВИЛ ЗДЕСЬ И ДОБАВИЛ В Obj
	public void crEvent(String evnt, String speech, int timeout, int maxCnt) {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();  //Здесь начало транзакции... надо ли?
		Query query = s.createSQLQuery(
				"CALL p_event.cr_event(:p_objxprop, :p_event, :p_speech, :p_tm, :p_max_cnt)")
				.setParameter("p_objxprop", this.id)
				.setParameter("p_event", evnt)
				.setParameter("p_speech", speech)
				.setParameter("p_tm", timeout)
				.setParameter("p_max_cnt", maxCnt);
		int exRows = query.executeUpdate();		 
		s.getTransaction().commit();
	}

	//Обработать событие
	//НЕ УВЕРЕН, НА СКОЛЬКО ОПРАВДАНО СОБЫТИЕ ПО СВОЙСТВУ ОБЪЕКТА, ПОКА ОСТАВИЛ ЗДЕСЬ И ДОБАВИЛ В Obj
	public void procEvent(int evque) {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();  //Здесь начало транзакции... надо ли?
		Query query = s.createSQLQuery(
				"CALL p_event.proc_event(:p_evque)")
				.setParameter("p_evque", evque);
		int exRows = query.executeUpdate();		 
		s.getTransaction().commit();
	}

}
