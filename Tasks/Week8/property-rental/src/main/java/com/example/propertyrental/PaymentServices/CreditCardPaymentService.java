package com.example.propertyrental.PaymentServices;

import com.example.propertyrental.PropertyModels.Property;
import org.springframework.stereotype.Component;

@Component("creditCardPaymentService")
public class CreditCardPaymentService implements PaymentService {
    @Override
    public void processPayment(Property property) {
        System.out.println("processing credit card payments");
    }

    @Override
    public void refundPayment(Property property) {
        System.out.println("payment refunded to customer's bank account");
    }
}
