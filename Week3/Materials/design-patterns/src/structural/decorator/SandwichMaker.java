package structural.decorator;

public class SandwichMaker {
	public static void main(String args[]){

		//adding extra cheese using Decorator Pattern
		Sandwich cheeseSandwich = new Cheese(new WhiteBreadSandwich());
		System.out.printf("Price of %s is $%.2f %n", cheeseSandwich.getDescription(),
				cheeseSandwich.price());

		//adding extra ketchup using Decorator Pattern
		Sandwich ketchupSandwich = new Ketchup(new Cheese(new WhiteBreadSandwich()));
		System.out.printf("Price of %s is $%.2f %n", ketchupSandwich.getDescription(),
				ketchupSandwich.price());
	}

}
