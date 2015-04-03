package com.ibm.core.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastListIterationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> arrList = new ArrayList<String>(); 
		arrList.add("Karan");
		arrList.add("Saumya");
		arrList.add("Manav");
		
		for(String str:arrList)
		{
			/* if(str.equals("Karan"))   
			arrList.remove(str); */
			
			// arrList.add("KaranDS");
			
			/* Will throw ConcurrentModificationException as ArrayList is Fail Fast
			   Reason while iterating structural modification is not allowed */
			
		}
		
		System.out.println(arrList);
		
		Iterator<String> itr = arrList.iterator();
		
		while(itr.hasNext())
		{
			String str = itr.next();
			
			if(str.equals("Karan"))
			{
				itr.remove();   //Allowed while using Iterator
				
				//arrList.add("Karan");
				/*Not allowed will throw concurrent modification exception */
				
			}
		}
		
		System.out.println(arrList);
		

	}//main

}
