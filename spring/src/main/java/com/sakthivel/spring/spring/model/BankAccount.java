package com.sakthivel.spring.spring.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "bank_account")
public class BankAccount {

	@Id
	@Column(name = "account_no")
	private String accountNo;

	private double balance;
	private String bankName;

	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
	private List<BankTransaction> transactions;
	
	public BankAccount(String name) {
		this.bankName = name;
	}

	public BankAccount(String bankName, String accountNo) {
		super();
		this.bankName = bankName;
		this.accountNo = accountNo;
	}

	public BankAccount() {
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double amount) {
		this.balance = amount;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void withdraw(double amount) {

		if (this.balance - amount >= 0) {
			this.balance -= amount;
			System.out.println("Withdrwal successfull " + balance);
		} else {
			System.out.println("Withdrwal Rejected because of low balance");
		}

	}

	public void resetBalance(double amount) {
		System.out.println("inside reset method");
		this.withdraw(amount);

	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public List<BankTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<BankTransaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", balance=" + balance + ", bankName=" + bankName
				+ ", transactions=" + transactions + "]";
	}
	
	
	
	
}
