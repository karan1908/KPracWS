package com.ibm.core.java;

import java.util.Set;
import java.util.HashSet;

public class GenericSet {
	private static class A {}
	private static class B extends A {}
	private static class C {}

	public Set<? extends A> getSet() {
		return new HashSet<B>();
	}

	
	//Generic Test
	
	final int m =10;

	public void outerClassMethod()
	{
	  class MethodLocal<A extends Number>  //Method Local class can be final or abstract only
		{
			Integer i = new Integer(5);
			A a = (A)i;

			public void iCanAccessOnlyFinalMembersOfOuterClass()
			{
				i = m;
			}

		}
	}

}