package com.ibm.core.java;

public class MyDeadlock {
	 
    String str1 = "Java";
    String str2 = "UNIX";
     
    Thread trd1 = new Thread("My Thread 1"){
        public void run(){
        	try {
        		//Thread.yield(); 
        		/*Stops the currently running thread1 momentarily (equivalent Thread.sleep(0)), 
        		scheduler will put it in the runnable state allows the thread2 to get executed. 
        		Scheduler will pick the thread1 again after some time*/
        System.out.println("In Thread1:"+Thread.currentThread().getName()+" Priority "+Thread.currentThread().getPriority());
        	boolean flag1 = true;
            while(flag1){
                synchronized(str1){
					Thread.sleep(10);
                	System.out.println("Deadlock in Thread 1");
                    synchronized(str2){
                        System.out.println(str1 + str2);
                    }
                }
                flag1 = false;
            }//while
            System.out.println("Thread 1 execution completed!");
        	} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }//run
    };
     
    Thread trd2 = new Thread("My Thread 2"){
        public void run(){
        	try {
        		 System.out.println("In Thread2:"+Thread.currentThread().getName()+" Priority "+Thread.currentThread().getPriority());
        		 
        	boolean flag2 = true;
            while(flag2){
                synchronized(str2){
					Thread.sleep(10);
                	System.out.println("Deadlock in Thread 2");
                	/*trd2.stop();*/  //Thread 2 will get stop , hence deadlock avoided
                    synchronized(str1){
                        System.out.println(str2 + str1);
							Thread.sleep(2000);
						
                    }//synchronized str1
                }//synchronized str2
                flag2 = false;
            }//while
            System.out.println("Thread 2 execution completed!");
            } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }//run
    };
     
    public static void main(String a[]){
        MyDeadlock mdl = new MyDeadlock();
        mdl.trd1.start();
/*        try {
			mdl.trd1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/       
        //Deadlock will be avoided as Thread 2 will start only after Thread 1 execution completed.
        
        mdl.trd2.start();
        System.out.println("Finish!");
    }
}