# Online Shop
This is a simplified online shop system where users can add products to a shopping cart, view the total cost, and place an order. 
## Classes
### Product
The Product class represents individual products. Each product has a name and a price.
### Shopping Cart
The Shopping Cart class manages the shopping cart functionality. It has methods to add and remove items, calculate the total cost, and retrieve the items in the cart.
### Order Processor
The OrderProcessor class handles order processing. It has a placeOrder method, actually, in this method, we should have a big logic. But now in our example, it simply prints the order details (each item and price) and the total cost for the cart.
### Online Shop
That would be the driver class that contains the main method. In the main method, we create some sample products, create a shopping cart, add products to the cart, and then display the total cost. Finally, we create an instance of OrderProcessor and use it to place the order, which will print the order details.