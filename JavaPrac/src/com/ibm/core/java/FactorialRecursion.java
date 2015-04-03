package com.ibm.core.java;

public class FactorialRecursion {

	public static void main(String[] args) {
		System.out.println("Factorial of 4 is: " + fact(4));
	}

	static int fact(int no)
	{

		if(no == 0 || no == 1)
			return 1;
		else
			if(no > 1)
				return no * fact(no-1);
			else
				return -1;
	}

}
