
public class OrderProcessor {
    public void placeOrder(ShoppingCart cart) {
        for (Product product : cart.getItems()) {
            System.out.println("Ordered item name: " + product.getName() + ", Price: $" + product.getPrice());
        }
        System.out.println("Total cost of your cart: $" + cart.getTotalCost());
    }
}
