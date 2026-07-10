package com.sakthivel.spring.spring.exception;

public class CustomExceptionDemo {

    // custom unchecked exception
    static class InsufficientFundsException extends RuntimeException {
        private final double amount;

        public InsufficientFundsException(double amount) {
            super("Insufficient funds. Attempted to withdraw: " + amount);
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }
    }

    static class AccountService {
        private double balance = 100.0;

        public void withdraw(double amount) {
            if (amount > balance) {
                throw new InsufficientFundsException(amount);
            }
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ". Remaining: " + balance);
        }
    }

    public static void main(String[] args) {
        AccountService service = new AccountService();

        service.withdraw(50.0);  // should succeed
        service.withdraw(200.0); // should throw
    }
}