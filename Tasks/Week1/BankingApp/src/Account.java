
public class Account {
    // usage of fields and methods to apply the encapsulation principle
    private double balance;
    private String accountHolderName;
    private String accountNumber;

    public Account(double balance, String accountHolderName, String accountNumber) {
        this.balance = balance;
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    // usage of getters and setters to apply the abstraction princple
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            System.err.println("\nERROR: A deposit amount cannot be negative.");
            return;
        }
        balance += amount;
        System.out.println("\nYou have successfully made a deposit of $" + amount
                + " into your account.\nYour updated account balance is: $" + balance);
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            System.err.println("\nERROR: A withdraw amount cannot be negative.");
            return;
        }
        if (balance < amount) {
            System.err.println("\nERROR: Your account does not have sufficient balance.");
            return;
        }
        balance -= amount;
        System.out.println("\nYou have successfully made a withdraw of $" + amount
                + " from your account.\nYour updated account balance is: $" + balance);
    }
}