package com.ibm.core.java;

public class StringCharacterCombinations {
	
	static int ctr;
	
	/**
	 * @param instr
	 * @param outstr
	 * @param index
	 */
	static void combine(String instr, StringBuffer outstr, int index)
	{
		
		++ctr;
		
	    for (int i = index; i < instr.length(); i++)
	    {
	        outstr.append(instr.charAt(i));
	        System.out.println(outstr);
	        
	        combine(instr, outstr, i + 1);
	        
	        outstr.deleteCharAt(outstr.length() - 1);
	    }
	} 
	
	public static void main(String[] args)
	{
		combine("abc", new StringBuffer(""), 0);
		
		System.out.println(ctr);
		
	}
}
