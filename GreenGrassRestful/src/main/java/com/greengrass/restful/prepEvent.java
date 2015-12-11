package com.greengrass.restful;

import java.util.Date;

//класс подготовки информации события для мобильного приложения
public class prepEvent {

	private Integer id;
	private Date ts;
	private String speech;

	// getters and setters
	// ID объекта
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// Строка события
	public String getSpeech() {
		return speech;
	}

	public void setSpeech(String speech) {
		this.speech = speech;
	}

	// Тип объекта
	public Date getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
	}


}
