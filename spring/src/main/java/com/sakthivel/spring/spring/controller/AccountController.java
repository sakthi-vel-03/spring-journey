package com.sakthivel.spring.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sakthivel.spring.spring.config.JwtUtil;
import com.sakthivel.spring.spring.dto.AccountSummary;
import com.sakthivel.spring.spring.dto.BankAccountDTO;
import com.sakthivel.spring.spring.dto.CreateAccountRequest;
import com.sakthivel.spring.spring.exception.AccountNotFoundException;
import com.sakthivel.spring.spring.model.BankAccount;
import com.sakthivel.spring.spring.service.AccountService;

import jakarta.validation.Valid;

@RestController	
@RequestMapping("/api/account")
public class AccountController {
	
	private AccountService accountService;
	private JwtUtil jwtUtil;
	
	@Autowired
	public AccountController(AccountService accountService, JwtUtil jwtUtil) {
		this.accountService = accountService;
		this.jwtUtil = jwtUtil;
	}
	
	@PostMapping("/create")
	public String createAccount(@RequestBody @Valid CreateAccountRequest request) {
		accountService.createAccount(request.getAccountNo(), request.getBankName());
		return "Account Created Successfully";
	}
	
	@PostMapping("/deposit/{accountNo}/{amount}")
	public String deposit(@PathVariable String accountNo, @PathVariable double amount) {
		accountService.deposit(accountNo, amount);
		return amount +" Deposited to the Account No "+ accountNo;
	}
	
	@PostMapping("/withdraw/{accountNo}/{amount}")
	public String withdraw(@PathVariable String accountNo, @PathVariable double amount) {
		accountService.withdraw(accountNo, amount);
		return amount +" Withdraw successful from the Account No "+ accountNo;
	}
	
	@GetMapping("/balance/{accountNo}")
	public String getBalance(@PathVariable String accountNo){
		String amount = Double.toString(accountService.getBalance(accountNo));
		return amount;
	}
	
	@PostMapping("/transfer/{from}/{to}/{amount}")
	public String transfer(@PathVariable String from, @PathVariable String to, @PathVariable double amount){
		accountService.transfer(from, to, amount);
		return amount +" successfully transferred from the Account No "+ from +" to the Account No " + to ;
	}
	
	@GetMapping("/token")
	public String getToken() {
	    return jwtUtil.generateToken("testuser");
	}
	
	@GetMapping("/transactions")
	public List<BankAccount> getAllWithTransactions() throws AccountNotFoundException {
	    return accountService.getAllAccountsWithTransactions();
	}
	
	@GetMapping("/summary")
	public List<BankAccountDTO> getAllAccountSummaries() {
		return accountService.getAllAccountSummaries();
	}
	
	@GetMapping("/projection")
	public List<AccountSummary> getAccountSummaryProjection() {
		return accountService.getAccountSummaryProjection();
	}
	
	@GetMapping("/test/race")
	public void simulateRaceCondition() {
		try {
			accountService.simulateRaceCondition();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
