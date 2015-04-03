package com.ibm.core.java;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeListIterationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> arrList = new CopyOnWriteArrayList<String>(); 
		arrList.add("Karan");
		arrList.add("Saumya");
		arrList.add("Manav");

		for(String str:arrList)
		{
			if(str.equals("Karan"))   
				arrList.remove(str); 
			
			arrList.add("Naveen");

			/* Won't throw ConcurrentModificationException  now as CopyOnWriteArrayList is Fail Safe */

		}

		System.out.println(arrList);

		Iterator<String> itr = arrList.iterator();

		while(itr.hasNext())
		{
			String str = itr.next();

			if(str.equals("Saumya"))
			{
				//itr.remove();   
				
				/*Not Allowed while using Iterator will throw UnSupportedException
				 * The UnsupportedOperationException indicates 
				 * that the requested operation cannot be performed, due to the fact that it is forbidden for that particular class. 
				 */

				arrList.add("KaranD");
				/*Allowed won't throw concurrent modification exception */

			}
		}

		System.out.println(arrList);  


	}//main

}
