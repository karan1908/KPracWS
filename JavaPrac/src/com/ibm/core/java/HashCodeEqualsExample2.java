package com.ibm.core.java;

import java.util.HashMap;

/**
 *
 * @author karan
 */
public class HashCodeEqualsExample2 {

	private int experience;
	private String name;

	public HashCodeEqualsExample2(int experience, String name) {
		this.experience = experience;
		this.name = name;
	}


	@Override
	public String toString() {
		return name+"@"+experience;
	}

	@Override
	public int hashCode() {
		Character hash;
		hash = this.name.charAt(0);
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
		final HashCodeEqualsExample2 other = (HashCodeEqualsExample2) obj;
		if (this.experience != other.experience) {
			return false;
		}
		return true;
	}




	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here

		HashCodeEqualsExample2 ob1= new HashCodeEqualsExample2(1,"karan");
		HashCodeEqualsExample2 ob2= new HashCodeEqualsExample2(2,"saumya");
		HashMap<HashCodeEqualsExample2,String> hm = new HashMap();
		hm.put(ob1,"ibm");
		hm.put(ob2,"amdocs");
		System.out.println("\n"+hm);

		HashCodeEqualsExample2 ob3= new HashCodeEqualsExample2(1,"kanika");

		hm.put(ob3,"infosys");

		System.out.println("\n"+hm);

		System.out.println("\n"+hm.get(ob1)+"\n");


	}

}
