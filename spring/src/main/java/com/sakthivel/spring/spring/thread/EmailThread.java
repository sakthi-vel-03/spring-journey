package com.sakthivel.spring.spring.thread;

public class EmailThread extends Thread{
		
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Email sent.");
	}

}
