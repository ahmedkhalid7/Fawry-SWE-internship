package behavioral.strategy;

public class CreditCardStrategy implements PaymentStrategy {
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;

	public CreditCardStrategy(String ccNum, String cvv, String expiryDate){
		this.cardNumber=ccNum;
		this.cvv=cvv;
		this.dateOfExpiry=expiryDate;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount +" paid with credit/debit card");
	}

}
