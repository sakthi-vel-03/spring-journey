package com.sakthivel.spring.spring.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadOverload {
	
	public static void main(String[] args) {
//		threadOverload();
//		ThreadWithPool();
		threadPoolMethods();
	}
	
	public static void threadOverload() {
		System.out.println("Starting to create threads with runnable");
		long start = System.currentTimeMillis();
		for(int i = 0 ; i< 100000; i++) {
			EmailTask et = new EmailTask();
			Thread t = new Thread(et);
			t.start();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start + "ms took to complete");
	}
	
	// Using Executor Service
	public static void ThreadWithPool() {
		
		System.out.println("Starting to create threads with executor service");
		long start = System.currentTimeMillis();
		ExecutorService ex =  Executors.newFixedThreadPool(4);
		for(int i = 0 ; i < 100000 ; i++) {
			EmailTask et =   new EmailTask();
			ex.submit(et);
		}
		ex.shutdown();
		long end = System.currentTimeMillis();
		System.out.println(end - start + "ms took to complete");
	}
	
	// 2 variants of executor service
	public static void threadPoolMethods() {
		
		System.out.println("Starting to create threads with Fixed Thread Pool ");
		ExecutorService ft = Executors.newFixedThreadPool(2);
		for(int i = 0 ; i < 5 ; i++) {
			SumTask st = new SumTask();
			ft.submit(st);
		}
		
		System.out.println("Starting to create threads with Cached Thread Pool ");
		ExecutorService ct = Executors.newCachedThreadPool();
		for(int i = 0 ; i < 5 ; i++) {
			SumTask st = new SumTask();
			ct.submit(st);
		}
		ft.shutdown();
		ct.shutdown();
	}
}
