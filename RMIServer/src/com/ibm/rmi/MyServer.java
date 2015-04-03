package com.ibm.rmi;

import java.rmi.*;  

public class MyServer{  

	public static void main(String args[]){  
		try{  
			System.out.println("In Server ...");
			Adder stub=new AdderRemote();  
			Naming.rebind("rmi://localhost:1099/karan",stub);  
			System.out.println("Out Server ...");

		}catch(Exception e)
		{
		System.out.println(e);
		e.printStackTrace();
		}  
	}  

}  