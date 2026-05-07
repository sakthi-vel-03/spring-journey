package com.sakthivel.spring;

import org.springframework.stereotype.Component;

@Component
public class PayPalPaymentService implements PaymentService {
    public void processPayment(int amount) {
        System.out.println("Processing payment of " + amount + " via PayPal");
    }
}