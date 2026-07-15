package com.sakthivel.spring.spring.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamCollect {

    static class Transaction {
        String id;
        String status;
        double amount;

        Transaction(String id, String status, double amount) {
            this.id = id;
            this.status = status;
            this.amount = amount;
        }

        public String toString() { return id + ":" + amount; }
    }

    public static void main(String[] args) {
        collectDemo();
    }

    static void collectDemo() {
        List<Transaction> transactions = Arrays.asList(
            new Transaction("T1", "COMPLETED", 500.0),
            new Transaction("T2", "FAILED", 150.0),
            new Transaction("T3", "COMPLETED", 920.0),
            new Transaction("T4", "PENDING", 600.0),
            new Transaction("T5", "FAILED", 300.0),
            new Transaction("T6", "COMPLETED", 200.0)
        );

        // toSet
        Set<String> statuses = transactions.stream()
            .map(t -> t.status)
            .collect(Collectors.toSet());
        System.out.println("Unique statuses: " + statuses);

        // groupingBy
        Map<String, List<Transaction>> byStatus = transactions.stream()
            .collect(Collectors.groupingBy(t -> t.status));
        System.out.println("\nGrouped by status: " + byStatus);

        // groupingBy + counting
        Map<String, Long> countByStatus = transactions.stream()
            .collect(Collectors.groupingBy(t -> t.status, Collectors.counting()));
        System.out.println("\nCount by status: " + countByStatus);

        // joining
        String csv = transactions.stream()
            .map(t -> t.id)
            .collect(Collectors.joining(", "));
        System.out.println("\nCSV: " + csv);
    }
}
