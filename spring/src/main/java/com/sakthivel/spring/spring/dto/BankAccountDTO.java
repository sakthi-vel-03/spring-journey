package com.sakthivel.spring.spring.dto;

public class BankAccountDTO {
	
	private String accountNo;
	private double balance;
	
	public BankAccountDTO(String accountNo, double balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
