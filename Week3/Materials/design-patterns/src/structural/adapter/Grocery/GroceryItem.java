package structural.adapter.Grocery;

//third-party code
public class GroceryItem {
	String itemName;
	int costPerUnit;

	public GroceryItem(String itemName, int costPerUnit) {
		this.itemName = itemName;
		this.costPerUnit = costPerUnit;
	}

	public String getItemName() {
		return itemName;
	}

	public int getCostPerUnit() {
		return costPerUnit;
	}

}
