package com.sakthivel.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.sakthivel.spring")
class AppConfig {}

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = context.getBean(OrderService.class);
        orderService.placeOrder(500);
        
        OrderService o = new OrderService(new PayPalPaymentService());
        o.placeOrder(5000);
    }
}