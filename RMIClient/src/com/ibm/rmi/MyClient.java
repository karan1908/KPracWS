package com.ibm.rmi;

import java.rmi.*;  

public class MyClient{  
  
public static void main(String args[]){  
try{  
  
System.out.println("In Client....");	
Adder stub=(Adder)Naming.lookup("rmi://localhost:1099/karan");  
System.out.println(stub.add(34,4));  
System.out.println("Out Client....");
  
}

catch(Exception e)
{
e.printStackTrace();	
}  
}  
  
}  