package com.greengrass.restful;

//класс подготовки информации счетчика для мобильного приложения
public class prepMet {

		private Integer id, objId;
		private String objName, propId;
		// значение свойства - Double
		private Double n1;

		// getters and setters
		// ID свойства
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		// ID объекта
		public Integer getObjId() {
			return objId;
		}

		public void setObjId(Integer objId) {
			this.objId = objId;
		}

		// Наименование объекта
		public String getObjName() {
			return objName;
		}

		public void setObjName(String objName) {
			this.objName = objName;
		}

		// Id свойства объекта
		public String getPropId() {
			return propId;
		}

		public void setPropId(String propId) {
			this.propId = propId;
		}

		public Double getN1() { 
			return this.n1;
		}
	 
		public void setN1(Double n1) {
			this.n1 = n1;
		}	

	}
