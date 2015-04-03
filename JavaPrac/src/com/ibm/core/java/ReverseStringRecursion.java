package com.ibm.core.java;

public class ReverseStringRecursion {

	public static void main(String[] args) {

		StringBuffer sb = reverse("india",new StringBuffer(),"india".length()-1);
		System.out.println("Reverse String: "+sb);
	}

	static StringBuffer reverse(String str,StringBuffer sb,int length)
	{
		
			return (length >= 0)?reverse(str,sb.append(str.charAt(length)),--length):sb;
	}

}
