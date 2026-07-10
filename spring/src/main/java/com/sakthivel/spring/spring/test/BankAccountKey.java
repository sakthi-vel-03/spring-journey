package com.sakthivel.spring.spring.test;

import java.util.Objects;

public class BankAccountKey {
    String accountNo;
    
    public BankAccountKey(String accountNo) {
        this.accountNo = accountNo;
    }

//	@Override
//	public int hashCode() {
//		return Objects.hash(accountNo);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		BankAccountKey other = (BankAccountKey) obj;
//		return Objects.equals(accountNo, other.accountNo);
//	}
    
    
    
}