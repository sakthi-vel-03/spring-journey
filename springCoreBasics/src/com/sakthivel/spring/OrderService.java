package com.sakthivel.spring;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Component
public class OrderService {
    private PaymentService paymentService;
    
    @Autowired
    public OrderService(@Qualifier("payPalPaymentService") PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    
    public void placeOrder(int amount) {
        System.out.println("Order placed");
        paymentService.processPayment(amount);
    }
}