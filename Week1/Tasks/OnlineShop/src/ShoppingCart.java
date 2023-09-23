import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> shoppingCart;

    public ShoppingCart() {
        this.shoppingCart = new ArrayList<Product>();
    }

    public void addItem(Product product) {
        this.shoppingCart.add(product);
    }

    public void removeItem(Product product) {
        this.shoppingCart.remove(product);
    }

    public double getTotalCost() {
        double total = 0.0;
        for (Product product : shoppingCart) {
            total += product.getPrice();
        }
        return total;
    }

    public List<Product> getItems() {
        return shoppingCart;
    }
}
