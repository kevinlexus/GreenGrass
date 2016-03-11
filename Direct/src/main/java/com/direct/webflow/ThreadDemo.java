package com.direct.webflow;

public class ThreadDemo extends Thread {
	   private Thread t;
	   private String threadName;
	   public boolean stopped=false;
	   ThreadDemo( String name){
	       threadName = name;
	       System.out.println("Creating " +  threadName );
	   }
	   public void run() {
	      int i=0;
		  System.out.println("Running " +  threadName );
    	  while (!stopped) { /*!Thread.currentThread().isInterrupted()*/
            System.out.println("Thread: " +this.isInterrupted()+ threadName + ", " + i++);
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
	    System.out.println("Thread " +  threadName + " exiting.");
	   }
	   
	   public void start ()
	   {
		  stopped=false; 
	      System.out.println("Starting " +  threadName );
	      if (t == null)
	      {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }

	}