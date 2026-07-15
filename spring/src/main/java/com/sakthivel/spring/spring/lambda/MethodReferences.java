package com.sakthivel.spring.spring.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferences {

    static class Transaction {
        String id;
        double amount;

        Transaction() {
            this.id = "DEFAULT";
            this.amount = 0.0;
        }

        Transaction(String id, double amount) {
            this.id = id;
            this.amount = amount;
        }

        public String toString() {
            return id + ":" + amount;
        }
    }

    static void logTransaction(Transaction t) {
        System.out.println("LOG: " + t);
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction("T1", 500.0),
            new Transaction("T2", 150.0),
            new Transaction("T3", 850.0)
        );

        // Type 1 — static method reference
        Function<String, Integer> parse = Integer::parseInt;
        System.out.println("Parsed: " + parse.apply("12345"));

        // Type 2 — instance method on specific instance
        Consumer<Transaction> print = System.out::println;
        print.accept(new Transaction("T4", 200.0));

        // Type 3 — instance method on arbitrary instance
        Function<String, String> upper = String::toUpperCase;
        System.out.println("Upper: " + upper.apply("hello"));

        // Type 4 — constructor reference
        Supplier<Transaction> creator = Transaction::new;
        System.out.println("Created: " + creator.get());

        // real usage — forEach with method reference
        System.out.println("--- All transactions ---");
        transactions.forEach(MethodReferences::logTransaction);
    }
}
