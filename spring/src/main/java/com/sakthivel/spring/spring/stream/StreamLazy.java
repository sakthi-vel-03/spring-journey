package com.sakthivel.spring.spring.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamLazy {

    static class Transaction {
        String id;
        double amount;

        Transaction(String id, double amount) {
            this.id = id;
            this.amount = amount;
        }

        public String toString() { return id + ":" + amount; }
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction("T1", 850.0),
            new Transaction("T2", 150.0),
            new Transaction("T3", 920.0),
            new Transaction("T4", 600.0),
            new Transaction("T5", 300.0)
        );

        System.out.println("Building pipeline...");

        var pipeline = transactions.stream()
            .filter(t -> {
                System.out.println("  filter checking: " + t.id);
                return t.amount > 500;
            })
            .map(t -> {
                System.out.println("  map transforming: " + t.id);
                return "Receipt[" + t.id + "] Rs." + t.amount;
            });

        System.out.println("Pipeline built. Nothing executed yet.");
        System.out.println("Now triggering terminal operation...");

        List<String> results = pipeline.collect(Collectors.toList());

        System.out.println("Results: " + results);
    }
}