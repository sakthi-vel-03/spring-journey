package com.sakthivel.spring.spring.stream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMethods {

    static class Transaction {
        String id;
        double amount;

        Transaction(String id, double amount) {
            this.id = id;
            this.amount = amount;
        }

        public String toString() { return id + ":" + amount; }
    }

    static class Account {
        String name;
        List<Transaction> transactions;

        Account(String name, List<Transaction> transactions) {
            this.name = name;
            this.transactions = transactions;
        }
    }

    public static void main(String[] args) {
//        reduceDemo();
        flatMapDemo();
    }

    static void reduceDemo() {
        List<Transaction> transactions = Arrays.asList(
            new Transaction("T1", 500.0),
            new Transaction("T2", 150.0),
            new Transaction("T3", 850.0),
            new Transaction("T4", 200.0)
        );

        double total = transactions.stream()
            .map(t -> t.amount)
            .reduce(0.0, (a, b) -> a + b);

        System.out.println("Total: " + total);

        double total2 = transactions.stream()
            .map(t -> t.amount)
            .reduce(0.0, Double::sum);

        System.out.println("Total2: " + total2);
    }

    static void flatMapDemo() {
        List<Account> accounts = Arrays.asList(
            new Account("Alice", Arrays.asList(
                new Transaction("T1", 500.0),
                new Transaction("T2", 150.0)
            )),
            new Account("Bob", Arrays.asList(
                new Transaction("T3", 920.0)
            )),
            new Account("Charlie", Arrays.asList(
                new Transaction("T4", 600.0),
                new Transaction("T5", 300.0)
            ))
        );

        // map gives Stream<List<Transaction>>
        System.out.println("\nWith map:");
        accounts.stream()
            .map(a -> a.transactions)
            .forEach(System.out::println);

        // flatMap gives Stream<Transaction>
        System.out.println("\nWith flatMap:");
        List<Transaction> allTransactions = accounts.stream()
            .flatMap(a -> a.transactions.stream())
            .collect(Collectors.toList());
        System.out.println(allTransactions);

        // real use — filter high value across all accounts
        System.out.println("\nHigh value (>500) across all accounts:");
        accounts.stream()
            .flatMap(a -> a.transactions.stream())
            .filter(t -> t.amount > 500)
            .forEach(System.out::println);
    }
    
    
}