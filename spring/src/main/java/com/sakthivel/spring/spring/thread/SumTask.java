package com.sakthivel.spring.spring.thread;

import java.sql.SQLException;
import java.util.concurrent.Callable;

public class SumTask implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
//		throw new SQLException();
 		return 0;
	}

	
}
