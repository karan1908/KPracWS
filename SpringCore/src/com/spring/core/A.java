package com.spring.core;


public class A {  
	
	
	B b1;  

	A(){System.out.println("a is created");}  

	public B getB() {  
		return b1;  
	}  

	public void setB(B b1) {  
		this.b1 = b1;  
	}  

	void print(){System.out.println("hello a");}  
	void display(){  
		print();  
		b1.print();  
	}  
}  