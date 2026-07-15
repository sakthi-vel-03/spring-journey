package com.sakthivel.spring.spring.lambda;

public class FunctionalInterfaceDemo {

    @FunctionalInterface
    interface PaymentProcessor {
        void process(double amount);
//         int cancel(); // try uncommenting this
    }

    public static void main(String[] args) {
        PaymentProcessor processor = (amount) -> 
            System.out.println("Processing payment of Rs." + amount);

        processor.process(500.0);
        processor.process(1500.0);
    }
}