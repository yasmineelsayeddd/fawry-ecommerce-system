import java.util.Date;
public class Main {
    public static void main(String[] args) {
        Product cheese = new BaseProduct("Cheese", 100, 5);
        cheese = new ShippableProductDecorator(cheese, 400);
        cheese = new ExpiringProductDecorator(cheese, new Date(System.currentTimeMillis() + 100000000));

        Product biscuits = new BaseProduct("Biscuits", 150, 3);
        biscuits = new ShippableProductDecorator(biscuits, 700);
        biscuits = new ExpiringProductDecorator(biscuits, new Date(System.currentTimeMillis() + 100000000));

        Product tv = new BaseProduct("TV", 5000, 2);
        tv = new ShippableProductDecorator(tv, 7000);

        Product scratchCard = new BaseProduct("Scratch Card", 50, 10);

        Customer customer = new Customer("Yasmine", 10000);

        Cart cart = new Cart(new WeightBasedShippingStrategy());
        cart.addToCart(cheese, 2);
        cart.addToCart(biscuits, 1);
        cart.addToCart(tv, 1);
        cart.addToCart(scratchCard, 1);

        cart.checkout(customer);
    }
}
