package com.ibm.core.java;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class WeakHashMapExample {
	public static void main(String[] args) {
		Map<String,String> weakHashMap = new WeakHashMap<String,String>();
		Set<String> hashSet = new HashSet<String>();
		// Create a key for the map, keep the strong reference
		String storngRefrence = new String("key");
		weakHashMap.put(storngRefrence, "Karan");
		System.out.println(weakHashMap);
		// Run the GC and check if the key is still there.
		System.gc();       //or  Runtime.getRuntime().gc();
		System.out.println(weakHashMap.get("key"));
		System.out.println(weakHashMap);
		// Now, null out the strong reference and try again the same above.
		storngRefrence = null;
		System.gc();
		System.out.println(weakHashMap);
		System.out.println(weakHashMap.get("key"));
	}
}