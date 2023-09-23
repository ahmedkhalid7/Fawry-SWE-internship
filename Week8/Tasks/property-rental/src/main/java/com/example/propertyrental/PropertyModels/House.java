package com.example.propertyrental.PropertyModels;

public class House implements Property {
    private double price;
    private String address;

    private boolean isBooked;
    public House(double price, String address) {
        this.price = price;
        this.address = address;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public PropertyType getPropertyType() {
        return PropertyType.House;
    }

    @Override
    public boolean isBooked() {
        return isBooked;
    }

    @Override
    public void setBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }
}