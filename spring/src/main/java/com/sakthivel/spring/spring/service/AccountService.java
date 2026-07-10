package com.sakthivel.spring.spring.service;

import com.sakthivel.spring.spring.dto.AccountSummary;
import com.sakthivel.spring.spring.dto.BankAccountDTO;
import com.sakthivel.spring.spring.exception.AccountNotFoundException;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sakthivel.spring.spring.model.BankAccount;
import com.sakthivel.spring.spring.repository.AccountRepository;

@Service
public class AccountService {
	
	private AccountRepository accountRepository;
	private static AtomicInteger requestCount = new AtomicInteger(0);
	@Autowired
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public void createAccount(String accountNo,  String bankName) {
		BankAccount account =  new BankAccount();
		account.setAccountNo(accountNo);
		account.setBankName(bankName);
		accountRepository.save(account);
	}
	
	public void deposit(String accountNo, double amount) throws AccountNotFoundException{
		BankAccount account =  accountRepository.findById(accountNo).orElseThrow(() -> new AccountNotFoundException("Account Not Found "+accountNo));
		account.setBalance(account.getBalance()+amount);
		accountRepository.save(account);
		requestCount.getAndIncrement();
		System.out.println("Request count: " + requestCount);
	}
	
	public void withdraw(String accountNo, double amount) throws AccountNotFoundException{
		BankAccount account =  accountRepository.findById(accountNo).orElseThrow(() -> new AccountNotFoundException("Account Not Found "+accountNo));
		account.withdraw(amount);
		accountRepository.save(account);
	}
	
	@Transactional
	public void transfer(String fromAccountNo, String toAccountNo, double amount) throws AccountNotFoundException  {
		this.withdraw(fromAccountNo, amount);
		this.deposit(toAccountNo, amount);
		
	}
	
	public double getBalance(String accountNo) throws AccountNotFoundException{
		BankAccount account =  accountRepository.findById(accountNo).orElseThrow(() -> new AccountNotFoundException("Account Not Found "+accountNo));
		return account.getBalance();
	}
	
	public List<BankAccount> getAllAccountsWithTransactions() {
	    List<BankAccount> accounts = accountRepository.findAllWithTransactions();
	    for (BankAccount account : accounts) {
	        account.getTransactions().size();
	    }
	    return accounts;
	}
	
	public List<BankAccountDTO> getAllAccountSummaries(){
		List<BankAccount> accounts = accountRepository.findAll();
		List<BankAccountDTO> accDto = accounts.stream().map(acc -> new BankAccountDTO(acc.getAccountNo(), acc.getBalance())).toList();
		return accDto;
	}
	
	public List<AccountSummary> getAccountSummaryProjection() {
	    return accountRepository.findAllProjectedBy();
	}
	
	public void simulateRaceCondition() throws InterruptedException {	
		requestCount.set(0);
	    Thread t1 = new Thread(() -> {
	        for(int i = 0; i < 1000; i++) {
	        	requestCount.getAndIncrement();
	        }
	    });
	    Thread t2 = new Thread(() -> {
	        for(int i = 0; i < 1000; i++) {
	        	requestCount.getAndIncrement();
	        }
	    });
	    t1.start();
	    t2.start();
	    t1.join();
	    t2.join();
	    System.out.println("Final count: " + requestCount);
	}

}
