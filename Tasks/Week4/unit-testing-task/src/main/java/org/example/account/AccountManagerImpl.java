package org.example.account;

public class AccountManagerImpl implements AccountManager {
    private static int MAX_CREDIT = 1000;

    @Override
    public void deposit(Customer customer, int amount) throws IllegalArgumentException{
        if (amount < 0) throw new IllegalArgumentException("Invalid deposit amount: " + amount);
        customer.setBalance(customer.getBalance() + amount);
    }

    @Override
    public String withdraw(Customer customer, int amount) throws IllegalArgumentException{
        if (amount < 0) throw new IllegalArgumentException("Invalid withdrawal amount: " + amount);

        int expectedBalance = customer.getBalance() - amount;
        if (expectedBalance < 0) {
            if (!customer.isCreditAllowed()) {
                return "insufficient account balance";
            } else if (expectedBalance > MAX_CREDIT && !customer.isVip()) {
                return "maximum credit exceeded";
            }
        }
        customer.setBalance(expectedBalance);
        return "success";
    }
}