package structural.adapter.product;

public class CosmeticProduct implements Product {
	String name;
	double price;

	public CosmeticProduct(String name, double price) {
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
