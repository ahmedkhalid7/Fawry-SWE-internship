
public class SavingsAccount extends Account {
    private float interestRate;

    public SavingsAccount(float interestRate, double initialDeposit, String accountHolderName, String accountNumber) {
        super(initialDeposit, accountHolderName, accountNumber);
        this.interestRate = interestRate;
    }

    public void calculateInterest() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest);
    }

    public double getInterestRate() {
        return interestRate;
    }
}
