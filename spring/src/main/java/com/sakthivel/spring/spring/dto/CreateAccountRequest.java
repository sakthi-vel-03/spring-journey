package com.sakthivel.spring.spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateAccountRequest {
	
	@NotBlank(message = "Account number cannot be blank")
	@Size(min = 3, max = 20, message = "Account number must be between 3 and 20 characters")
	private String accountNo;
	@NotBlank(message = "Bank name cannot be blank")
	private String bankName;
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

}
