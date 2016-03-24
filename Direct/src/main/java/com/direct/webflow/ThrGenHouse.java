package com.direct.webflow;


public class ThrGenHouse extends Thread {
	   private String threadName;
	   public boolean stopped=false;

	   ThrGenHouse(String name){
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