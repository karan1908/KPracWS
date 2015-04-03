
package com.ibm.core.java;

import java.util.HashMap;

/**
 *
 * @author karan
 */
public class HashCodeEqualsExample {

	private int age;
	private String name;

	public HashCodeEqualsExample(int age, String name) {
		this.age = age;
		this.name = name;
	}


	@Override
	public String toString() {
		return name+"@"+age;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 11 * hash + this.age;
		System.out.println("Generating Hash Code for " + this + " " + hash);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final HashCodeEqualsExample other = (HashCodeEqualsExample) obj;
		if (this.age != other.age) {
			return false;
		}
		return true;
	}




	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here

		HashCodeEqualsExample ob1= new HashCodeEqualsExample(1,"karan");
		HashCodeEqualsExample ob2= new HashCodeEqualsExample(2,"saumya");
		HashMap<HashCodeEqualsExample,String> hm = new HashMap();
		hm.put(ob1,"ibm");
		hm.put(ob2,"amdocs");
		System.out.println("\n"+hm);

		HashCodeEqualsExample ob3= new HashCodeEqualsExample(1,"manav");

		hm.put(ob3,"infosys");

		System.out.println("\n"+hm);

		System.out.println("\n"+hm.get(ob3)+"\n");


	}

}
