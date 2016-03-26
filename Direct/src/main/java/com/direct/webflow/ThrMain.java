package com.direct.webflow;

import java.util.List;


public class ThrMain extends Thread {
	   private ThrGen tgh1, tgh2, tgh3, tgh4, tgh5;
	   private List<SprGenItm> sprg;
	   public boolean stopped=false;
	   
	   ThrMain(List<SprGenItm> sprg){
	       this.sprg=sprg;
		   System.out.println("Creating ThrMain!");
	   }
	   
	   public void run() {
	   
		   for (SprGenItm itm : this.sprg) {
			   //этот поток должен создать объект содержащий дома которые нужно сформировать, потоки ThrGen должны "разбирать" у этого объекта дома для формир. 
			   System.out.println("Generating menu item: "+itm.getCd());
			   SrvThr srv = new SrvThr(10);
			   System.out.println("complete!");
			   }

			   System.out.println("Check");
		   
		   System.out.println("Thread ThrMain exiting.");
	   }
	   
	}