package com.sakthivel.spring.spring.stream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamMethods {

    static class Transaction {
        String id;
        double amount;
		String status;
        

        Transaction(String id, double amount) {
            this.id = id;
            this.amount = amount;
        }

        public Transaction(String id, String status, double amount) {
        	 this.id = id;
        	 this.status = status;
             this.amount = amount;
		}

		public String toString() { return id + ":" + amount + ":" + status; }
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
//        flatMapDemo();
    	  shortCircuitDemo();
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
    
    static void shortCircuitDemo() {
        List<Transaction> transactions = Arrays.asList(
            new Transaction("T1", "COMPLETED", 500.0),
            new Transaction("T2", "FAILED", 150.0),
            new Transaction("T3", "COMPLETED", 920.0),
            new Transaction("T4", "PENDING", 600.0),
            new Transaction("T5", "FAILED", 300.0)
        );

        // findFirst
        Optional<Transaction> first = transactions.stream()
            .filter(t -> t.amount > 500)
            .findFirst();
        System.out.println("First above 500: " + 
            first.map(t -> t.toString()).orElse("None found"));

        // anyMatch
        boolean anyFailed = transactions.stream()
            .anyMatch(t -> t.status.equals("FAILED"));
        System.out.println("Any failed? " + anyFailed);

        // allMatch
        boolean allCompleted = transactions.stream()
            .allMatch(t -> t.status.equals("COMPLETED"));
        System.out.println("All completed? " + allCompleted);

        // noneMatch
        boolean noneCancelled = transactions.stream()
            .noneMatch(t -> t.status.equals("CANCELLED"));
        System.out.println("None cancelled? " + noneCancelled);
    }
    
    
}