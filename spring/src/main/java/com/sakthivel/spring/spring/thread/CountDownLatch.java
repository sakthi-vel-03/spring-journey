package com.sakthivel.spring.spring.thread;

public class CountDownLatch {
	
	public static void main(String[] args) {
		
		CountDown();
	
}


public static void CountDown() {
	java.util.concurrent.CountDownLatch count = new java.util.concurrent.CountDownLatch(3);
	ThreadExecution1 t1 = new ThreadExecution1(count);
		for(int i = 0 ; i< 3;i++) {
			Thread a = new Thread(t1);
			a.start();
			ThreadExecution2 t2 = new ThreadExecution2(count);
			Thread b = new Thread(t2);
			b.start();
			ThreadExecution3 t3 = new ThreadExecution3(count);
			Thread c = new Thread(t3);
			c.start();
		
			try {
				System.out.println("Thread is going to wait");
		//		a.join();
		//		b.join();
		//		c.join();
				count.await();
				System.out.println("All Threads returned");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
}	

class ThreadExecution1 implements Runnable{

	private java.util.concurrent.CountDownLatch count;
	public ThreadExecution1(java.util.concurrent.CountDownLatch c) {
		count = c;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			System.out.println("Thread 1 Completed");
			count.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
class ThreadExecution2 implements Runnable{
	
	private java.util.concurrent.CountDownLatch count;
	public ThreadExecution2(java.util.concurrent.CountDownLatch c) {
		count = c;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("Thread 2 Completed");
			count.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
class ThreadExecution3 implements Runnable{
	
	private java.util.concurrent.CountDownLatch count;
	public ThreadExecution3(java.util.concurrent.CountDownLatch c) {
		count = c;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			System.out.println("Thread 3 Completed");
			count.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
