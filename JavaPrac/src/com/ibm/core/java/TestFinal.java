package com.ibm.core.java;

public class TestFinal {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(testTry());
	}

	public static int testTry() {
		int i = 6;

		try {
			i = 7;
			return i;

		} finally {
			i = 8;
		}
	} 

}
