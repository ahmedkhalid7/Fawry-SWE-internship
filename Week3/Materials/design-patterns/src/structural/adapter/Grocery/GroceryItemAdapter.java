package structural.adapter.Grocery;

import structural.adapter.product.Product;

public class GroceryItemAdapter implements Product {

	private GroceryItem groceryItem;

	public GroceryItemAdapter(GroceryItem groceryItem) {
		this.groceryItem = groceryItem;
	}

	public String getName() {
		return groceryItem.getItemName();
	}

	public double getPrice() {
		return groceryItem.getCostPerUnit();
	}
}
