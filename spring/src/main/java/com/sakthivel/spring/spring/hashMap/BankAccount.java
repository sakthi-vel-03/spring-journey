package com.sakthivel.spring.spring.hashMap;

public class BankAccount {
    String accountNumber;
    
    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return accountNumber.equals(that.accountNumber);
    }
    
    @Override
    public int hashCode() {
        return accountNumber.hashCode();
    }
}