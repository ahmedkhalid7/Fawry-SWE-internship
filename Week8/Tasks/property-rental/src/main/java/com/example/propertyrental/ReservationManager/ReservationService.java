package com.example.propertyrental.ReservationManager;

import com.example.propertyrental.PaymentServices.PaymentContext;

import com.example.propertyrental.PropertyModels.Property;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {
    private List<Property> properties = new ArrayList<>();
    private PaymentContext paymentContext;

    public ReservationService(PaymentContext paymentContext) {
        this.paymentContext = paymentContext;
    }

    public Property findProperty(String address) {
            for (Property property : properties) {
                if (property.getAddress().equals(address)) {
                    return property;
                }
            }
        return null;
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public void reserveProperty(String address) {
        Property property = findProperty(address);
        if (property == null) {
            throw new IllegalArgumentException("Property not found");
        }

        if (property.isBooked()) {
            throw new IllegalArgumentException("Property is already booked");
        }

        paymentContext.pay(property);
        property.setBooked(true);
    }

    public void cancelReservation(String address) {
        Property property = findProperty(address);
        if (property == null) {
            throw new IllegalArgumentException("Property not found");
        }

        paymentContext.refund(property);
        property.setBooked(false);
    }

    public List<Property> getProperties(){
        return properties;
    }
}
