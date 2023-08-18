package org.example;

// Adapter pattern: Adaptee
class SMSSender {
    void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
