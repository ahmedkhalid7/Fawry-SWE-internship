package structural.adapter;

import structural.adapter.Grocery.GroceryItem;
import structural.adapter.Grocery.GroceryItemAdapter;
import structural.adapter.product.CosmeticProduct;
import structural.adapter.product.FitnessProduct;

public class Shop {
	public static void main(String[] args) {
		ShopInventory inventory = new ShopInventory();

		//adding regular store products - ones that implement Product interface
		inventory.addProduct(new CosmeticProduct("Lavie Handbag", 5000.0));
		inventory.addProduct(new FitnessProduct("Yoga SmartFit", 2000.75));


		//adding GroceryItem to the store using an adapter
		GroceryItem groceryItem = new GroceryItem("Wheat Flour", 100);
		inventory.addProduct(new GroceryItemAdapter(groceryItem));
	}
}
