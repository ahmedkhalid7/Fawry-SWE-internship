import java.util.ArrayList;
import java.security.SecureRandom;

class Bank {
    private static ArrayList<Account> accounts;

    private SecureRandom rand;

    public String generateAccountNumber() {
        StringBuilder sb = new StringBuilder();

        // First digit between 1 and 9
        sb.append(rand.nextInt(9) + 1);

        // Next 15 digits between 0 and 9
        for (int i = 0; i < 15; i++) {
            sb.append(rand.nextInt(10));
        }

        return sb.toString();
    }

    Bank() {
        accounts = new ArrayList<>();
        rand = new SecureRandom();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void deposit(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("\nERROR: Bank account does not exist!");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("\nERROR: Bank account does not exist!");
        }
    }

    public void displayBalance(String accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("\nBalance of Account " + accountNumber + ": $" + account.getBalance());
        } else {
            System.out.println("\nERROR: Bank account does not exist!");
        }
    }
}
