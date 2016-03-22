package com.direct.webflow;

import com.greengrass.house.AnyApp;

public class ThrMain extends Thread {
	   private Thread tgh1, tgh2, tgh3;
	   private String threadName;
	   public boolean stopped=false;
	   private AnyApp app;
	   
	   ThrMain(AnyApp app, String name){
	       threadName = name;
	       this.app = app;
	       System.out.println("Creating " +  threadName );
	   }
	   
	   public void run() {
		   
	   
		   
		   tgh1= new ThrGenHouse(app, "HOUSE Thread-1");
		   tgh1.start();
		   
		   tgh2= new ThrGenHouse(app,  "HOUSE Thread-2");
		   tgh2.start();

		   tgh3= new ThrGenHouse(app,  "HOUSE Thread-3");
		   tgh3.start();

		   synchronized(tgh1){
	            try{
	                System.out.println("Waiting for HOUSE Thread-1 to complete...");
	                tgh1.wait();
	            } catch(InterruptedException e){
	                e.printStackTrace();
	            }
		   }
		   
		   synchronized(tgh2){
	            try{
	                System.out.println("Waiting for HOUSE Thread-2 to complete...");
	                tgh2.wait();
	            } catch(InterruptedException e){
	                e.printStackTrace();
	            }
		   }

		   synchronized(tgh3){
	            try{
	                System.out.println("Waiting for HOUSE Thread-3 to complete...");
	                tgh3.wait();
	            } catch(InterruptedException e){
	                e.printStackTrace();
	            }
		   }
		   
		   System.out.println("Thread " +  threadName + " exiting.");
	   }
	   
	}