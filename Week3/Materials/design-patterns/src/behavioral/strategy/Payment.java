package behavioral.strategy;

public class Payment {
	private PaymentStrategy paymentMethod;

	public Payment(PaymentStrategy paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public void setPaymentMethod(PaymentStrategy paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public void payAmount(int amount) {
		paymentMethod.pay(amount);
	}
}
