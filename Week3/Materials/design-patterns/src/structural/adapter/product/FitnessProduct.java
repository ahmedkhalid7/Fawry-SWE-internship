package structural.adapter.product;

public class FitnessProduct implements Product {

	String name;
	double price;

	public FitnessProduct(String name, double price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getPrice() {
		return price;
	}
}
