
public class OnlineShop {
    public static void main(String[] args) {
        Product nikeSneaker = new Product("NIKE Sneaker", 40);
        Product adidasSneaker = new Product("Adidas Sneaker", 30);
        Product adidasCap = new Product("Adidas Cap", 20);

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(nikeSneaker);
        cart.addItem(adidasSneaker);
        cart.addItem(adidasCap);

        OrderProcessor processor = new OrderProcessor();

        processor.placeOrder(cart);
    }
}
