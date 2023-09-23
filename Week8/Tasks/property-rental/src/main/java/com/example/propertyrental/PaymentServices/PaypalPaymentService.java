package com.example.propertyrental.PaymentServices;

import com.example.propertyrental.PropertyModels.Property;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("paypalPaymentService")
@Primary
public class PaypalPaymentService implements PaymentService {
    @Override
    public void processPayment(Property property) {
        System.out.println("processing Paypal payments");
    }

    @Override
    public void refundPayment(Property property) {
        System.out.println("payment refunded to customer's Paypal account");
    }
}