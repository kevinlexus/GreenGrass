package com.direct.webflow;

import java.util.List;


public class ThrMain<SprGenItm> extends Thread {
	   private Thread tgh1, tgh2, tgh3, tgh4, tgh5;
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
			   

			   tgh1= new ThrGen("HOUSE Thread-1");
			   tgh1.start();
			   
			   tgh3= new ThrGen("HOUSE Thread-3");
			   tgh3.start();
			   
			   tgh2= new ThrGen("HOUSE Thread-2");
			   tgh2.start();

			   tgh5= new ThrGen("HOUSE Thread-5");
			   tgh5.start();

			   tgh4= new ThrGen("HOUSE Thread-4");
			   tgh4.start();

			   synchronized(tgh1){
		            try{
		                System.out.println("Waiting for HOUSE Thread-1 to complete...");
		                tgh1.wait();
		            } catch(InterruptedException e){
		                e.printStackTrace();
		            }
			   }
			   

			   /*synchronized(tgh2){
		            try{
		                System.out.println("Waiting for HOUSE Thread-2 to complete...");
		                tgh2.wait();
		            } catch(InterruptedException e){
		                e.printStackTrace();
		            }
			   }*/

			   
			   synchronized(tgh3){
		            try{
		                System.out.println("Waiting for HOUSE Thread-3 to complete...");
		                tgh3.wait();
		            } catch(InterruptedException e){
		                e.printStackTrace();
		            }
			       }

			   synchronized(tgh5){
		            try{
		                System.out.println("Waiting for HOUSE Thread-5 to complete...");
		                tgh5.wait();
		            } catch(InterruptedException e){
		                e.printStackTrace();
		            }
	     		   }
		   
			   synchronized(tgh4){
		            try{
		                System.out.println("Waiting for HOUSE Thread-4 to complete...");
		                tgh4.wait();
		            } catch(InterruptedException e){
		                e.printStackTrace();
		            }
			   }

			   System.out.println("Check");
		   
		   }
		   
		
		   
		   System.out.println("Thread ThrMain exiting.");
	   }
	   
	}