package com.sakthivel.spring.spring.hashset;

public class TestAccount {
    String accountNumber;

    public TestAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        TestAccount that = (TestAccount) o;
        return accountNumber.equals(that.accountNumber);
    }

    // hashCode deliberately NOT overridden
    
    @Override
    public int hashCode() {
    	return accountNumber.hashCode();
    }
}
