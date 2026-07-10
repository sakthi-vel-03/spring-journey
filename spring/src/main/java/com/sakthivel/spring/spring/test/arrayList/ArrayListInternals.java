package com.sakthivel.spring.spring.test.arrayList;

import java.util.ArrayList;

public class ArrayListInternals {
	
	public static void main(String[] args) {
		
		checkAddIndexInBetween();
	}
	
	// Check the ArrayList With the initial size which removes the resizing time 
	public static void checkResize() {
		
		ArrayList<Integer> al = new ArrayList<>();
		ArrayList<Integer> al1 = new ArrayList<>(1000000);
		
		ArrayList<Integer> warmup = new ArrayList<>();
		for(int i = 0; i < 1000000; i++) {
		    warmup.add(i);
		}
		
		long start1 = System.currentTimeMillis();
		for(int i = 0 ; i < 1000000 ; i++)
		{
			al.add(i);
		}
		long end1 = System.currentTimeMillis() - start1;
		System.out.println("Without capacity : " + end1);
		
		long start2 = System.currentTimeMillis();
		for(int i = 0 ; i < 1000000 ; i++)
		{
			al1.add(i);
		}
		long end2 = System.currentTimeMillis() - start2;
		System.out.println("With capacity : " + end2);
		
	}
	
	//Check Why get(index) Is O(1) But add(index) in the Middle Is O(n)
	public static void checkAddIndexInBetween()
	{
		ArrayList<Integer> al = new ArrayList<>();
		ArrayList<Integer> al1 = new ArrayList<>();
		
		for(int i = 0 ; i < 100000;i++) {
			al.add(i);
			al1.add(i);
		}
		long start1 = System.currentTimeMillis();
		for(int i = 0 ; i< 10000; i++)
		{
			al.add(i);
		}
		long end1 = System.currentTimeMillis() - start1;
		System.out.println("Addign in last : " + end1 + "ms");
		
		long start2 = System.currentTimeMillis();
		for(int i = 0 ; i< 10000; i++)
		{
			al1.add(0, i);
		}
		long end2 = System.currentTimeMillis() - start2;
		System.out.println("Addign in start : " + end2 + "ms");
	}
}
