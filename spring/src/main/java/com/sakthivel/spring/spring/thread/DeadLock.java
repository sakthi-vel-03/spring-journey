package com.sakthivel.spring.spring.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLock {

	private static Object lockA = new Object();
	private static Object lockB = new Object();

	public static void main(String[] args) throws Exception {

		ExecutorService ex = Executors.newFixedThreadPool(2);

		ex.submit(()->{
			synchronized(lockA) {
				System.out.println("Synchronozed Method for lockA is called");
				int count = 1;
				count++;
				try { Thread.sleep(500); } catch (InterruptedException e) {}
				synchronized (lockB) {
					System.out.println("Synchronozed Method for lockB inside lockA is called");
					count++;
			    }
			}
		});
		ex.submit(()->{
			synchronized(lockA) {
				System.out.println("Synchronozed Method for lockA is called");
				int count = 1;
				count++;
				try { Thread.sleep(500); } catch (InterruptedException e) {}
				synchronized (lockB) {
					System.out.println("Synchronozed Method for lockB inside lockA is called");
					count++;
				}
			}
		});

//		ex.submit(()->{
//			synchronized(lockB) {
//				System.out.println("Synchronozed Method for lockB is called");
//				int count = 1;
//				count++;
//				try { Thread.sleep(500); } catch (InterruptedException e) {}
//				synchronized (lockA) {
//					System.out.println("Synchronozed Method for locakA inside lockB is called");
//					count++;
//			    }
//			}
//		});

		ex.shutdown();
	}
}