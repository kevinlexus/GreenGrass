//Произошедшие события по свойствам объектов
package com.greengrass.house;

import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.Transient;

import org.hibernate.Query;
import org.hibernate.Session;


@Entity
@Table(name = "T_EVQUE")

public class EvQue implements java.io.Serializable {

private Integer id;
private Integer cancel, alarm;
private Integer fktoobj;
private String speech, arg, presound;
private EvxObj evxobj;

public EvQue() {
	
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

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "FK_EVXOBJ")
public EvxObj getEvxObj() {
	return this.evxobj;
}

public void setEvxObj(EvxObj evxobj) {
	this.evxobj = evxobj;
}


@Column(name = "FK_TO_OBJ", nullable = false)
public Integer getFkToObj() {
	return this.fktoobj;
}	

public void setFkToObj(Integer fktoobj) {
	this.fktoobj=fktoobj;
}

@Column(name = "SPEECH", nullable = false)
public String getSpeech() {
	return this.speech;
}	

public void setArg(String arg) {
	this.arg=arg;
}

@Column(name = "ARG", nullable = true)
public String getArg() {
	return this.arg;
}	

public void setSpeech(String speech) {
	this.speech=speech;
}

@Column(name = "CANCEL", unique = false, nullable = true)
public Integer getCancel() {
	return this.cancel;
}

public void setCancel(Integer cancel) {
	this.cancel=cancel;
}

@Column(name = "PRESOUND", unique = false, nullable = true)
public String getPresound() {
	return this.presound;
}

public void setPresound(String presound) {
	this.presound=presound;
}

@Column(name = "ALARM", unique = false, nullable = true)
public Integer getAlarm() {
	return this.alarm;
}

public void setAlarm(Integer alarm) {
	this.alarm=alarm;
}


//Обработать событие(сообщение, работу)
@Transient
public void proc() { 
	Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	Query query = s.createSQLQuery(
			"CALL p_event.proc_event(:p_evque)")
			.setParameter("p_evque", this.id);
	int exRows = query.executeUpdate();

}

}
