import java.util.ArrayList;
import java.security.SecureRandom;

// Bank class acts like an API that provide certain services and it is not binded to a specific bank account.
final class Bank {
    private static ArrayList<Account> accounts = new ArrayList<>();

    private static SecureRandom rand = new SecureRandom();

    public static String generateAccountNumber() {
        StringBuilder sb = new StringBuilder();

        // First digit between 1 and 9
        sb.append(rand.nextInt(9) + 1);

        // Next 15 digits between 0 and 9
        for (int i = 0; i < 15; i++) {
            sb.append(rand.nextInt(10));
        }

        return sb.toString();
    }

    private Bank() {
        throw new IllegalStateException("Bank class cannot be instantiated");
    }

    public static void addAccount(Account account) {
        accounts.add(account);
    }

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }

    public static void deposit(String accountNumber, double amount) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.deposit(amount);
                return;
            }
        }
        System.out.println("\nERROR: Bank account does not exist!");
    }

    public static void withdraw(String accountNumber, double amount) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.withdraw(amount);
                return;
            }
        }
        System.out.println("\nERROR: Bank account does not exist!");
    }

    public static void displayBalance(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                System.out.println("\nBalance of Account " + accountNumber + ": $" + account.getBalance());
                return;
            }
        }
        System.out.println("\nERROR: Bank account does not exist!");
    }
}
