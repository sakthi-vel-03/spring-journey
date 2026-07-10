package com.sakthivel.spring.spring.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


import com.sakthivel.spring.spring.model.BankAccount;

public class Test {
	public void searchWithList() {
		
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		
		for(int i = 0; i<5; i++) {
			accounts.add(new BankAccount("HDFC", "ACC00"+ (i+1)));
		}
		
		for(BankAccount acc : accounts) {
			
			if(acc.getAccountNo().equals("ACC002")) {
				System.out.println(acc);
			}
			
		}
		
	}
	
	public static void testHashMap() {
		HashMap<BankAccountKey, String> map = new HashMap<BankAccountKey, String>();
		
		BankAccountKey k1 = new BankAccountKey("ACC002");
		BankAccountKey k2 = new BankAccountKey("ACC002");
		map.put(k1, "found it!");
		System.out.println(map.get(k2));
		System.out.println(map.get(k1));
		System.out.println("k1 hashCode: " + k1.hashCode());
		System.out.println("k2 hashCode: " + k2.hashCode());
		System.out.println("k1.equals(k2): " + k1.equals(k2));
	}
	
	public static void testInitialCapacity() {
	    int size = 1000000;
	    
	    // Without initial capacity — will resize multiple times
	    long start1 = System.nanoTime();
	    HashMap<String, Integer> map1 = new HashMap<>();
	    for(int i = 0; i < size; i++) {
	        map1.put("key" + i, i);
	    }
	    long end1 = System.nanoTime();
	    
	    // With initial capacity — no resizing
	    long start2 = System.nanoTime();
	    HashMap<String, Integer> map2 = new HashMap<>(size);
	    for(int i = 0; i < size; i++) {
	        map2.put("key" + i, i);
	    }
	    long end2 = System.nanoTime();
	    
	    System.out.println("Without initial capacity: " + (end1-start1)/1000000 + "ms");
	    System.out.println("With initial capacity: " + (end2-start2)/1000000 + "ms");
	}
	
	public static void testConcurrentHashMap() throws InterruptedException {
	    Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();
	    Map<String, Integer> regularMap = new HashMap<>();
	    
	    // Both maps start with same key
	    concurrentMap.put("count", 0);
	    regularMap.put("count", 0);
	    
	    // Two threads hammering the same key
	    Thread t1 = new Thread(() -> {
	        for(int i = 0; i < 1000; i++) {
	            concurrentMap.merge("count", 1, Integer::sum);
	            regularMap.merge("count", 1, Integer::sum);
	        }
	    });
	    
	    Thread t2 = new Thread(() -> {
	        for(int i = 0; i < 1000; i++) {
	            concurrentMap.merge("count", 1, Integer::sum);
	            regularMap.merge("count", 1, Integer::sum);
	        }
	    });
	    
	    t1.start();
	    t2.start();
	    t1.join();
	    t2.join();
	    
	    System.out.println("ConcurrentHashMap count: " + concurrentMap.get("count"));
	    System.out.println("Regular HashMap count: " + regularMap.get("count"));
	}
	
	public static void SortByName() {
		HashMap<BankAccountKey, String> map = new HashMap<BankAccountKey, String>();
		
		SortByName s = new SortByName();
		TreeMap<Student,String> t = new TreeMap<Student, String>((o1, o2) -> o1.getName().compareTo(o2.getName()));
		t.put(new Student("Ravi", 3), "Section A");
		t.put(new Student("Anbu", 1), "Section B");
		t.put(new Student("Mani", 2), "Section C");
		
		for(Student k : t.keySet()) {
			System.out.println(k);
		}
		System.out.println();
		TreeMap<Student,String> t1 = new TreeMap<Student, String>();
		t1.put(new Student("Ravi", 1), "Section A");
		t1.put(new Student("Anbu", 3), "Section B");
		t1.put(new Student("Mani", 2), "Section C");
		
		for(Student k : t1.keySet()) {
			System.out.println(k);
		}
	}
	
	public static void Generics() {
		
		ArrayList<String> list = new ArrayList<>();
		list.add("Sakthivel");
		list.add("Anbu");

		for(int i = 0; i < list.size(); i++) {
		    String name = list.get(i);
		    System.out.println(name);
		}
		
		ArrayList<String> stringList = new ArrayList<>();
		ArrayList<Integer> intList = new ArrayList<>();

		System.out.println(stringList.getClass() == intList.getClass());
	}
	
	public static void main(String[] args) {
//	    new Test().searchWithList();
//		testHashMap();
//		testInitialCapacity();
//		try {
//			testConcurrentHashMap();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		SortByName();
//		Generics();
		
//		System.out.println(10 << 2);
//		System.out.println(10 >> 2);
		iteratorModification();
	}
	
	
	public static void iteratorModification() {
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for(int i = 0 ; i < 10 ; i++)
		{
			al.add(i);
		}
		
		System.out.println(al);
		
//		for( Integer i : al) {
//			al.remove(i);
//		}

//		for(int i = 0 ; i < al.size() ; i++) {
//			al.remove(i);
//		}
		
		Iterator<Integer> it = al.listIterator();
		while(it.hasNext()) {
			it.next();
			it.remove();
		}
		
		System.out.println(al);
		
	}

	public static void iteration() {
		
		ArrayList<String> list = new ArrayList<>();
        list.add("Alice");
        list.add("Bob");
        list.add("Charlie");

        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            System.out.println("hasNext() called — checking...");
            String value = it.next();
            System.out.println("next() called — got: " + value);
        }
        System.out.println("hasNext() called — false, loop ends");
		
	}
	
}
