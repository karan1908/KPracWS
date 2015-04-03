package com.ibm.core.java;

import java.util.ArrayList;
import java.util.List;

public class PolymorphismInCollections {

	public static void main(String[] args) {

		/*
		 * List<Number> listN = listInt; 
		 * List<Number> listInt = new ArrayList<Integer>();
		 * List<Object> listInt = new ArrayList<Integer>();
		 * Compile Time Error*/

		List<Integer> listInt = new ArrayList<Integer>();
		List<? extends Number> listNum = listInt;

		/*Correct combination*/

		/*List<Object> listObj = new ArrayList<Object>();
		 * List<? extends Number> listN = listObj; 
		 * Compile Time Error*/

		List<Object> listObj = new ArrayList<Object>();
		List<? super Number> listN = listObj; 
		
		/*Can put in listN either List of Number or any super type of Number , which is Object
		 * Correct combination*/
		
		Integer[] myInts = {1,2,3,4};
		Number[] myNumber = myInts;
		
		//No Compile Time Error

	}

}
