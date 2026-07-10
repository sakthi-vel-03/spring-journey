package com.sakthivel.spring.spring.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FinallyDemo {

    static void processPayment(boolean fail) {
        System.out.println("Opening connection");
        try {
            System.out.println("Processing payment");
            if (fail) {
                throw new RuntimeException("Payment gateway rejected");
            }
            System.out.println("Payment successful");
        } catch (RuntimeException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Closing connection — always runs");
        }
    }
    
    static int finallyTrap() {
        try {
            System.out.println("try block");
            return 1;
        } finally {
            System.out.println("finally block");
//            return 2;
        }
    }
    
    // try with resources
    static void tryWithResources() {
        try (FileReader reader = new FileReader("transactions.txt")) {
        	
            System.out.println("File opened successfully");
            
        } catch (FileNotFoundException e) {
        	
            System.out.println("File not found: " + e.getMessage());
            
        } catch (IOException e) {
        	
            System.out.println("Error closing file: " + e.getMessage());
        }
    }
    
    static void tryWithResourcesProof() {
        try (AutoCloseable resource = new AutoCloseable() {
            @Override
            public void close() {
                System.out.println("Resource closed automatically");
            }
        }) {
            System.out.println("Using resource");
            throw new RuntimeException("Something went wrong");
        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
//        System.out.println("--- Success case ---");
//        processPayment(false);
//
//        System.out.println("--- Failure case ---");
//        processPayment(true);
    	
//    	tryWithResources();
    	tryWithResourcesProof();
    }
}