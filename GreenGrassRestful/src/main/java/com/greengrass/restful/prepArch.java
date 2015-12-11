package com.greengrass.restful;

import java.util.Date;

//класс подготовки информации для построения графика
public class prepArch {

  	    // Временная метка (да, да, в String, так как у Sencha проблемы при отображении time axes! --> https://www.sencha.com/forum/showthread.php?184742-Chart-Time-Axis-not-scaling-correctly
		private String ts;
		// значение свойства - Double
		private Double n1;

		// getters and setters

		// Временная метка
		public String getTs() {
			return ts;
		}

		public void setTs(String ts) {
			this.ts = ts;
		}

		// значение свойства - Double
		public Double getN1() { 
			return this.n1;
		}
	 
		public void setN1(Double n1) {
			this.n1 = n1;
		}	

	}
