package com.sakthivel.spring.spring.hashMap;

import java.util.HashMap;

public class Test {

	
	
	public static void main(String[] args) {
		
//		checkResizeCost();
		System.out.println(2_00_000);
		
	}
	
	public static void checkBucket() {
		String key = "Alice";
//		int hashCode = key.hashCode();
//		int capacity = 16;
//		int bucketIndex = hashCode & (capacity - 1);
//		System.out.println("hashCode: " + hashCode);
//		System.out.println("bucket index: " + bucketIndex);
//		
//		String key2 = "Bob";
//		int hashCode2 = key2.hashCode();
//		int bucketIndex2 = hashCode2 & (capacity - 1);
//		System.out.println("Bob hashCode: " + hashCode2);
//		System.out.println("Bob bucket index: " + bucketIndex2);
		
//		HashMap<String, Integer> map = new HashMap<>();
//		map.put("Aa", 1);
//		map.put("BB", 2);
//
//		System.out.println(map.get("Aa")); // should return 1
//		System.out.println(map.get("BB")); // should return 2
//		System.out.println("Aa".hashCode());
//		System.out.println("BB".hashCode());
		
		// same object with different hashcode
		HashMap<BankAccount, String> map = new HashMap<>();

		BankAccount account1 = new BankAccount("ACC001");
		map.put(account1, "Alice");

		BankAccount account2 = new BankAccount("ACC001");
		System.out.println("Are they equal? " + account1.equals(account2));
		System.out.println("account1 hashCode: " + account1.hashCode());
		System.out.println("account2 hashCode: " + account2.hashCode());
		System.out.println("Value from map: " + map.get(account2));
	}
	
	public static void checkResizeCost() {

	    // warmup — identical operation, discarded
	    HashMap<Integer, Integer> warmup = new HashMap<>();
	    for(int i = 0; i < 1000000; i++) {
	        warmup.put(i, i);
	    }
	    
	    HashMap<Integer, Integer> warmup2 = new HashMap<>(2_000_000);
	    for(int i = 0; i < 1000000; i++) {
	        warmup2.put(i, i);
	    }

	    HashMap<Integer, Integer> withCapacity = new HashMap<>(2_000_000);
	    HashMap<Integer, Integer> withoutCapacity = new HashMap<>();

	    long start1 = System.currentTimeMillis();
	    for(int i = 0; i < 1000000; i++) {
	        withCapacity.put(i, i);
	    }
	    System.out.println("With capacity: " + (System.currentTimeMillis() - start1) + "ms");

	    long start2 = System.currentTimeMillis();
	    for(int i = 0; i < 1000000; i++) {
	        withoutCapacity.put(i, i);
	    }
	    System.out.println("Without capacity: " + (System.currentTimeMillis() - start2) + "ms");
	}

}


