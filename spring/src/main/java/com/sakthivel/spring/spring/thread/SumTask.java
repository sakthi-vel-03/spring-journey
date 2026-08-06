package com.sakthivel.spring.spring.thread;

import java.util.concurrent.Callable;

public class SumTask implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("Current Thread is : "+Thread.currentThread().getName());
		try{
			Thread.sleep(1000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
 		return 0;
	}

	
}
