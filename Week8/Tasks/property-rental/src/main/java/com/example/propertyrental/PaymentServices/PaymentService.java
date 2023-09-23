package com.example.propertyrental.PaymentServices;

import com.example.propertyrental.PropertyModels.Property;

public interface PaymentService {
    void processPayment(Property property);

    void refundPayment(Property property);
}