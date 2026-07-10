package com.sakthivel.spring.spring.linkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainClass {

	public static void main(String[] args) {
//		manualNodeCreation();
//		addInLast();
//		checkGetByIndex();
		checkMiddleInsert();
	}
	
	// 1.Manually creating a node
	public static void manualNodeCreation() {
		
		Node node1 = new Node();
		node1.setData("Alice");
		Node node2 = new Node();
		node2.setData("Bob");
		Node node3 = new Node();
		node3.setData("Charlie");
		
	   node1.setNext(node2);
	   node2.setPrev(node1);
	   node2.setNext(node3);
	   node3.setPrev(node2);
	   
	   Node current = node1;
	   while(current!=null) {
		   System.out.println(current.getData());
		   current = current.getNext();
	   }
	   
	   Node current1 = node3;
	   while(current1!=null) {
		   System.out.println(current1.getData());
		   current1 = current1.getPrev();
	   }
	   
	   System.out.println("Charlie's prev data: " + node3.getPrev().getData());
	   System.out.println("Alice's prev: " + node1.getPrev());
	   
		
	}
	
	// 2. Adding in Last ArrayList vs LinkedList
	public static void addInLast()
	{
		LinkedList<Integer> l = new LinkedList<Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for(int i = 0 ; i<100000; i++) {
			l.add(i);
			al.add(i);
		}
		long start1 = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++)
		{
			al.add(0, i);
		}
		long end1 = System.currentTimeMillis();
		System.out.println("ArrayList Adding in 0 index : " + (end1 - start1) + "ms");
		
		long start2 = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++)
		{
			l.addFirst(i);
		}
		long end2 = System.currentTimeMillis();
		System.out.println("LinkedList Adding in 0 index : " + (end2 - start2) + "ms");
		
	}
	
	// 3. Get by Index ArrayList vs LinkedList
	public static void checkGetByIndex() {
		LinkedList<Integer> l = new LinkedList<Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for(int i = 0 ; i<1000000; i++) {
			l.add(i);
			al.add(i);
		}
		long start1 = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++)
		{
			al.get(500000);
		}
		long end1 = System.currentTimeMillis();
		System.out.println("ArrayList getting 500000th index : " + (end1 - start1) + "ms");
		
		long start2 = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++)
		{
			l.get(500000);
		}
		long end2 = System.currentTimeMillis();
		System.out.println("LinkedList  getting 500000th index : " + (end2 - start2) + "ms");
		
	}
	
	// 4. Add element in middle ArrayList vs LinkedList
	public static void checkMiddleInsert() {
		LinkedList<Integer> l = new LinkedList<Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for(int i = 0 ; i<100000; i++) {
			l.add(i);
			al.add(i);
		}
		long start1 = System.currentTimeMillis();
		for(int i = 0; i < 1000; i++)
		{
			al.add(50000, i);
		}
		long end1 = System.currentTimeMillis();
		System.out.println("ArrayList adding in  500000th index : " + (end1 - start1) + "ms");
		
		long start2 = System.currentTimeMillis();
		for(int i = 0; i < 1000; i++)
		{
			l.add(50000, i);
		}
		long end2 = System.currentTimeMillis();
		System.out.println("LinkedList  adding in 500000th index : " + (end2 - start2) + "ms");
		
	}
}
