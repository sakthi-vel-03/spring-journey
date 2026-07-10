package com.sakthivel.spring.spring.hashset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import com.sakthivel.spring.spring.model.BankAccount;
import java.util.LinkedHashSet;
	public class MainClass {
	
	public static void main(String[] args) {
//		checkDuplicateWithList();
//		checkDuplicate();
//		workWithHashAndEquals();
//		checkIndexing();
	}
	
	// 1. Check the duplicates checking with the list
	public static void checkDuplicateWithList()
	{
		ArrayList<Integer> al = new ArrayList<Integer>();
		HashSet<Integer> hs = new HashSet<Integer>();
		
		for(int i = 0 ; i<1000000; i++) {
			al.add(i);
			hs.add(i);
		}
		
		long start1 = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++)
		{
			al.contains(999999);
		}
		long end1 = System.currentTimeMillis();
		System.out.println("Time Taken to check 999999 by list : " + (end1 - start1) + "ms");
		
		long start2 = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++)
		{
			hs.contains(999999);
		}
		long end2 = System.currentTimeMillis();
		System.out.println("Time Taken to check 999999 by set : " + (end2 - start2) + "ms");
		
	}
	
	public static void checkDuplicate() {
		HashSet<String> set = new HashSet<>();
		System.out.println(set.add("Alice")); 
		System.out.println(set.add("Bob"));
		System.out.println(set.add("Alice")); 
		System.out.println("Size: " + set.size());
	}
	
	
	// break the hashset's duplicate with overriding hascode and equals
	public static void workWithHashAndEquals() {
		HashSet<TestAccount> set = new HashSet<>();

		TestAccount account1 = new TestAccount("ACC001");
		TestAccount account2 = new TestAccount("ACC001");

		System.out.println("Are they equal? " + account1.equals(account2));
		set.add(account1);
		set.add(account2);

		System.out.println("Set size: " + set.size());
		System.out.println("Contains ACC001: " + set.contains(new TestAccount("ACC001")));
	}
	
	// ordering and indexing in hashset
	private static void checkIndexing() {
		HashSet<String> registrations = new HashSet<>();
		registrations.add("CUST001");
		registrations.add("CUST002");
		registrations.add("CUST003");
		registrations.add("CUST004");
		registrations.add("CUST005");

//		for(String id : registrations) {
//		    System.out.println(id);
//		}
		
		int capacity = 16;
		String[] ids = {"CUST001", "CUST002", "CUST003", "CUST004", "CUST005"};
		for(String id : ids) {
		    System.out.println(id + " → bucket " + (id.hashCode() & (capacity - 1)));
		}
		
	}
	
}
