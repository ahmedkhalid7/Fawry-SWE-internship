import java.util.Scanner;

public class BankApplication {

    private Scanner scanner = new Scanner(System.in);
    private Bank bank = new Bank();

    public static void main(String[] args) {
        BankApplication bankApp = new BankApplication();
        bankApp.run();
    }

    private void run() {
        while (true) {
            printMenu();
            int option = scanner.nextInt();
            handleOption(option);
        }
    }

    private void printMenu() {
        System.out.println("\n\nWelcome to our online banking app\n");
        System.out.println("1. Create Account");
        System.out.println("2. Show Balance");
        System.out.println("3. Deposit Money into account");
        System.out.println("4. Withdraw Money from an account");
        System.out.println("5. Calculate Interest for a Savings Account");
        System.out.println("6. Exit");
        System.out.print("Please choose an option to continue: ");
    }

    private void handleOption(int option) {
        switch (option) {
            case 1:
                createAccount();
                break;
            case 2:
                showBalance();
                break;
            case 3:
                depositMoney();
                break;
            case 4:
                withdrawMoney();
                break;
            case 5:
                calculateInterest();
                break;
            case 6:
                exit();
                break;
            default:
                System.out.println("\n\nInvalid option! Please choose again.");
                break;
        }
    }

    private void createAccount() {
        System.out.print("\nEnter your name: ");
        String name = scanner.next();
        System.out.print("Enter initial deposit: ");
        double initialDeposit = scanner.nextDouble();
        System.out.println("Choose Account type (1 for Checking, 2 for Savings): ");
        int accountType = scanner.nextInt();
        if (accountType == 2) {
            createSavingsAccount(name, initialDeposit);
        } else {
            createRegularAccount(name, initialDeposit);
        }
    }

    private void createSavingsAccount(String name, double initialDeposit) {
        System.out.print("Enter annual interest rate: ");
        float interestRate = scanner.nextFloat();
        SavingsAccount newSavingsAccount = new SavingsAccount(interestRate, initialDeposit, name,
                bank.generateAccountNumber());
        bank.addAccount(newSavingsAccount);
        System.out.println("\n\nCreated savings account with account number " + newSavingsAccount.getAccountNumber());
    }

    private void createRegularAccount(String name, double initialDeposit) {
        Account newAccount = new Account(initialDeposit, name, bank.generateAccountNumber());
        bank.addAccount(newAccount);
        System.out.println("\n\nCreated regular account with account number " + newAccount.getAccountNumber());
    }

    private void showBalance() {
        System.out.print("\nEnter account number: ");
        String accountNumber = scanner.next();
        bank.displayBalance(accountNumber);
    }

    private void depositMoney() {
        System.out.print("\nEnter account number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        bank.deposit(accountNumber, amount);
    }

    private void withdrawMoney() {
        System.out.print("\nEnter account number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        bank.withdraw(accountNumber, amount);
    }

    private void calculateInterest() {
        System.out.print("\nEnter the account number for the savings account: ");
        String accountNumber = scanner.next();
        Account account = bank.findAccount(accountNumber);
        if (account != null) {
            if (account instanceof SavingsAccount) {
                ((SavingsAccount) account).calculateInterest();
                System.out.println("Interest calculated and added to your balance");
            } else {
                System.out.println("\nThis operation is only available for savings accounts!");
            }
        }
    }

    private void exit() {
        System.out.println("\n\nThank you for using our online banking app!");
        scanner.close();
        System.exit(0);
    }
}