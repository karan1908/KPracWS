package com.ibm.core.java;

import java.util.Arrays;

public class KArrayList<E> {
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 2;
	private Object[] elements;

	public KArrayList() {
		elements = new Object[DEFAULT_CAPACITY];
	}

	public void add(E e) {
		if (size == elements.length) {
			ensureCapa();
		}  
		elements[size++] = e;
	}


	private void ensureCapa() {
		int newSize = elements.length * 2;
		elements = Arrays.copyOf(elements, newSize);
		System.out.println("elements.length "+elements.length);
	}

	@SuppressWarnings("unchecked")
	public E get(int i) {
		if (i>= size || i <0) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
		}
		return (E) elements[i];
	}

	public static void main(String[] args) {

		KArrayList<Integer> list = new KArrayList<Integer>();

		for(int i=0;i<10;++i)
			list.add(i);


		System.out.println(list.get(4));

	}//main

}//MyList
