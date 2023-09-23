package com.example.propertyrental.PropertyModels;

public interface Property {
    double getPrice();
    String getAddress();
    PropertyType getPropertyType();

    boolean isBooked();

    void setBooked(boolean isBooked);
}