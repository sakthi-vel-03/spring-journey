package com.sakthivel.spring.spring.thread;
 

import org.springframework.beans.factory.annotation.Autowired;
 
import com.sakthivel.spring.spring.service.AccountService;

public class ThreadCreation {
	
	private AccountService service;
	
	@Autowired
	public ThreadCreation(AccountService service) {
		this.service = service;
	}
	
	public static void main(String[] args) {
		ThreadCreation t = new ThreadCreation(new AccountService(null));
//		EmailThread et = new EmailThread();
//		et.start();
//		et.run();
	
		// Runnable
		EmailTask et1 = new EmailTask();
		Thread t2 =  new Thread(et1);
		t2.start();
		t.saveAccount();
		
		// Callable 
		SumTask s = new SumTask();
//		Thread t3 = new Thread(s);
		
	}
	
	public void saveAccount() {
		service.createAccount("ACC01", "SBI");
	}
	
	public void sendEmail() {
		try {
			Thread.sleep(3000);
//			throw new SQLException();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Email sent.");
	}

}
