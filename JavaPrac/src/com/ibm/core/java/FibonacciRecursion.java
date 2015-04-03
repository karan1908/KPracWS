package com.ibm.core.java;

public class FibonacciRecursion {

	public static void main(String[] a) 
	{
		System.out.println("Number is : " + getNo(4));
		System.out.println("Number is : " + fib(4));
	}

	static int getNo(int n)
	{
		if(n == 0 || n==1)
			return 1;
		else
	     if(n > 1)
			return getNo(n-1) + getNo(n-2);
	     else 
	    	 return -1;
	     
	}
	
	static int fib(int n) {
	    if(n <= 1) {
	        return n;
	    } else {
	        return fib(n - 1) + fib(n - 2);
	    }
	}

}
