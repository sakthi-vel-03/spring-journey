package com.sakthivel.spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class RazorpayPaymentService  implements PaymentService{
	
	public void processPayment(int amount) {
        System.out.println("Processing payment of " + amount + " via Razorpay");
    }

}
