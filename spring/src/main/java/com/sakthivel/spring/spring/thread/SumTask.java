package com.sakthivel.spring.spring.thread;

import java.sql.SQLException;
import java.util.concurrent.Callable;

public class SumTask implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("Current Thread is : "+Thread.currentThread().getName());
		Thread.sleep(1000);
 		return 0;
	}

	
}
