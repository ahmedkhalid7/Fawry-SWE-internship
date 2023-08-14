package org.example.account;

public class Customer {
    private String name;
    private int balance;
    private boolean creditAllowed;
    private int maxCredit = 0;
    private boolean vip;

    public Customer() {
    }
    public Customer(String name, int balance, boolean creditAllowed, int maxCredit, boolean vip) {
        this.name = name;
        this.balance = balance;
        this.creditAllowed = creditAllowed;
        this.maxCredit = maxCredit;
        this.vip = vip;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public boolean isCreditAllowed() {
        return creditAllowed;
    }
    public void setCreditAllowed(boolean creditAllowed) {
        this.creditAllowed = creditAllowed;
    }
    public int getMaxCredit() {
        return maxCredit;
    }
    public void setMaxCredit(int maxCredit) {
        this.maxCredit = maxCredit;
    }
    public boolean isVip() {
        return vip;
    }
    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
