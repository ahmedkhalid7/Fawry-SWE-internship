package com.example.propertyrental.PaymentServices;

import com.example.propertyrental.PropertyModels.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class PaymentContext {
    private PaymentService paymentService;

    @Autowired
    public PaymentContext(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void pay(Property property) {
        paymentService.processPayment(property);
    }

    public void refund(Property property) {
        paymentService.refundPayment(property);
    }
}