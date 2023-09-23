package behavioral.strategy;

import behavioral.template.Fifa;
import behavioral.template.Game;
import behavioral.template.WWE;

public class StrategyPatternDemo {

	public static void main(String[] args) {
		int price = 345;

		PaymentStrategy creditCard = new CreditCardStrategy("1222333331111", "182", "25/02");
		PaymentStrategy paypal = new PaypalStrategy("username", "password");

		Payment payment = new Payment(creditCard);
		payment.payAmount(price);

		payment.setPaymentMethod(paypal);
		payment.payAmount(price);
	}
}
