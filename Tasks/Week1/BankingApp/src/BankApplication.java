import java.util.Scanner;

public class BankApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n\nWelcome to our online banking app\n");
            System.out.println("1. Create Account");
            System.out.println("2. Show Balance");
            System.out.println("3. Deposit Money into account");
            System.out.println("4. Withdraw Money from an account");
            System.out.println("5. Calculate Interest for a Savings Accounts");
            System.out.println("6. Exit");
            System.out.print("Please choose an option to contiune: ");

            int option = scanner.nextInt();
            String accountNumber;
            double amount;
            String name;
            double initialDeposit;
            float interestRate;

            switch (option) {
                // Create Account
                case 1:
                    System.out.print("\nEnter your name: ");
                    name = scanner.next();
                    System.out.print("Enter initial deposit: ");
                    initialDeposit = scanner.nextDouble();
                    System.out.println("Choose Account type (1 for Checking, 2 for Savings): ");
                    int accountType = scanner.nextInt();
                    if (accountType == 2) {
                        System.out.print("Enter annual interest rate: ");
                        interestRate = scanner.nextFloat();
                        SavingsAccount newSavingsAccount = new SavingsAccount(interestRate, initialDeposit, name,
                                Bank.generateAccountNumber());
                        Bank.addAccount(newSavingsAccount);
                        System.out.println(
                                "\n\nCreated savings account with account number "
                                        + newSavingsAccount.getAccountNumber());
                    } else {
                        Account newAccount = new Account(initialDeposit, name,
                                Bank.generateAccountNumber());
                        Bank.addAccount(newAccount);
                        System.out.println(
                                "\n\nCreated regular account with account number " + newAccount.getAccountNumber());
                    }
                    break;

                // Show Balance
                case 2:
                    System.out.print("\nEnter account number: ");
                    accountNumber = scanner.next();
                    Bank.displayBalance(accountNumber);
                    break;

                // Deposit Money into account
                case 3:
                    System.out.print("\nEnter account number: ");
                    accountNumber = scanner.next();
                    System.out.print("Enter amount to deposit: ");
                    amount = scanner.nextDouble();
                    Bank.deposit(accountNumber, amount);
                    break;

                // Withdraw Money from an account
                case 4:
                    System.out.print("\nEnter account number: ");
                    accountNumber = scanner.next();
                    System.out.print("Enter amount to withdraw: ");
                    amount = scanner.nextDouble();
                    Bank.withdraw(accountNumber, amount);
                    break;

                // Calculate Interest for a Savings Accounts
                case 5:
                    System.out.print("\nEnter the account number for the savings account: ");
                    accountNumber = scanner.next();
                    for (Account account : Bank.getAccounts()) {
                        if (account.getAccountNumber().equals(accountNumber)) {
                            if (account instanceof SavingsAccount) {
                                ((SavingsAccount) account).calculateInterest();
                                System.out.println("Interest calculated and added to your balance");
                            } else {
                                System.out.println("\nThis operation is only available for savings accounts!");
                            }
                        }
                    }
                    break;

                // Exit
                case 6:
                    System.out.println("\n\nThank you for using our online banking app!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("\n\nInvalid option! Please choose again.");
                    break;
            }
        }
    }
}
