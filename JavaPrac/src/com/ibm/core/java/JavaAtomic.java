package com.ibm.core.java;

public class JavaAtomic {
	 
    public static void main(String[] args) throws InterruptedException {
 
        try {
        	//Three threads here main , t1 and t2
			ProcessingThread pt = new ProcessingThread();
			
			Thread t1 = new Thread(pt, "t1");
			t1.start();
			t1.join();
			
			Thread t2 = new Thread(pt, "t2");
			t2.start();
			//t2.join(); If this main thread might complete before thread t2 
			
			t2.join(); //t2.join() ensures main thread will complete after t2
			
			System.out.println("Processing count=" + pt.getCount());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
 
 
class ProcessingThread implements Runnable {
    private int count;
 
 
    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            processSomething(i);
            count++;
            System.out.println(Thread.currentThread().getName());
        }
        
    }
 
 
    public int getCount() {
        return this.count;
    }
 
 
    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
}
