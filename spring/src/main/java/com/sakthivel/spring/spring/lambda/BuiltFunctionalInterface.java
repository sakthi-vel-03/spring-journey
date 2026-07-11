package com.sakthivel.spring.spring.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltFunctionalInterface {

    static class Transaction {
        String id;
        double amount;

        Transaction(String id, double amount) {
            this.id = id;
            this.amount = amount;
        }

        public String toString() {
            return id + ":" + amount;
        }
    }

    public static void main(String[] args) {
        // Predicate — test something
        Predicate<Transaction> isHighValue = t -> t.amount > 500;

        // Function — transform something
        Function<Transaction, String> getReceipt = t ->
            "Receipt[" + t.id + "] Rs." + t.amount;

        // Consumer — do something, return nothing
        Consumer<Transaction> printTransaction = t ->
            System.out.println("Processing: " + t);

        // Supplier — produce something
        Supplier<Transaction> defaultTransaction = () ->
            new Transaction("DEFAULT", 0.0);

        Transaction t1 = new Transaction("T1", 850.0);
        Transaction t2 = new Transaction("T2", 150.0);

        System.out.println("T1 high value? " + isHighValue.test(t1));
        System.out.println("T2 high value? " + isHighValue.test(t2));
        System.out.println("Receipt: " + getReceipt.apply(t1));
        printTransaction.accept(t1);
        System.out.println("Default: " + defaultTransaction.get());
    }
}