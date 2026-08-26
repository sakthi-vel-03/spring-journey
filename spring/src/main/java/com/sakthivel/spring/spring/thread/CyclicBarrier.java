package com.sakthivel.spring.spring.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CyclicBarrier {
	
	public static void main(String[] args) {
		
		java.util.concurrent.CyclicBarrier barrier = new java.util.concurrent.CyclicBarrier(3);
		ExecutorService ex1 = Executors.newFixedThreadPool(3);

			
			
			Future<Integer> a = ex1.submit(new ThreadExecution1(barrier));
			Future<Integer> b = ex1.submit(new ThreadExecution2(barrier));
			Future<Integer> c = ex1.submit(new ThreadExecution3(barrier));
			
			try {
				System.out.println("main Thread is going to wait");
				int aVal = a.get();
				int bVal = b.get();
				int cVal = c.get();
				System.out.println("All Threads returned");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex1.shutdown();	
	}


	static class ThreadExecution1 implements Callable<Integer>{
		
		private java.util.concurrent.CyclicBarrier barrier;
		public ThreadExecution1(java.util.concurrent.CyclicBarrier barrier) {
			this.barrier = barrier;
		}

		@Override
		public Integer call() throws Exception {
			for(int i = 0 ; i < 3 ; i++) {
				System.out.println("Thread 1 is executing");
				Thread.sleep(2500);
				barrier.await();
			}
			return 0;
		}
		
	}
	static class ThreadExecution2 implements Callable<Integer>{
		private java.util.concurrent.CyclicBarrier barrier;
		public ThreadExecution2(java.util.concurrent.CyclicBarrier barrier) {
			this.barrier = barrier;
		}

		@Override
		public Integer call() throws Exception {
			for(int i = 0 ; i < 3 ; i++) {
				System.out.println("Thread 2 is executing");
				Thread.sleep(2000);
				barrier.await();
			}
			
			return 0;
		}
		
	}
	static class ThreadExecution3 implements Callable<Integer>{
		private java.util.concurrent.CyclicBarrier barrier;
		public ThreadExecution3(java.util.concurrent.CyclicBarrier barrier) {
			this.barrier = barrier;
		}

		@Override
		public Integer call() throws Exception {
			for(int i = 0 ; i < 3 ; i++) {
				System.out.println("Thread 3 is executing");
				Thread.sleep(1000);
				barrier.await();
			}
			return 0;
		}
		
	}
	
}
