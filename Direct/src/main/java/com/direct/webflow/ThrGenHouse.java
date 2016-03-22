package com.direct.webflow;

import com.greengrass.house.AnyApp;

public class ThrGenHouse extends Thread {
	   private String threadName;
	   public boolean stopped=false;
	   private AnyApp app;

	   ThrGenHouse(AnyApp app, String name){
	       this.app = app;
		   threadName = name;
	       System.out.println("Creating " +  threadName );
	   }
	   public void run() {
		  System.out.println("Running " +  threadName );
		  int i=0;
    	  while (!stopped && i < 5) { /*!Thread.currentThread().isInterrupted()*/
            System.out.println("Thread: " +threadName + ", " + i++);
            // Let the thread sleep for a while.
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				// TODO Auto-generated catch block
	            System.out.println("Thread: STOP!");
	            break;
			}
         }
    	  synchronized(this) 
    	  {
    	      notify();
    	  }
	    System.out.println("Thread " +  threadName + " exiting.");
	   }
	   
	}