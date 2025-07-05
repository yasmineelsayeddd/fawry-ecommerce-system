// Cart.java
import java.util.*;

public class Cart {
    private List<CartItem> items = new ArrayList<>();
    private ShippingStrategy shippingStrategy;

    public Cart(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }

    public void addToCart(Product product, int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive.");
        if (product.isExpired()) throw new IllegalArgumentException("Cannot add expired product: " + product.getName());
        if (quantity > product.getQuantity()) throw new IllegalArgumentException("Not enough stock for: " + product.getName());

        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                if (item.getQuantity() + quantity > product.getQuantity()) {
                    throw new IllegalArgumentException("Not enough stock to update quantity for: " + product.getName());
                }
                item.increaseQuantity(quantity);
                System.out.println("Updated quantity of " + product.getName() + " to " + item.getQuantity());
                return;
            }
        }

        items.add(new CartItem(product, quantity));
        System.out.println(quantity + " x " + product.getName() + " added to cart.");
    }

    public boolean isEmpty() { return items.isEmpty(); }

    public double calculateSubtotal() {
        double subtotal = 0.0;
        for (CartItem item : items) {
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    }

    public double calculateShipping() {
        return shippingStrategy.calculateShipping(items);
    }

    public double calculateTotal() {
        return calculateSubtotal() + calculateShipping();
    }

    public void checkout(Customer customer) {
        if (isEmpty()) throw new IllegalStateException("Cart is empty.");

        for (CartItem item : items) {
            if (item.isExpired()) throw new IllegalStateException("Item expired: " + item.getProduct().getName());
            if (item.getQuantity() > item.getProduct().getQuantity()) throw new IllegalStateException("Out of stock: " + item.getProduct().getName());
        }

        double subtotal = calculateSubtotal();
        double shipping = calculateShipping();
        double total = subtotal + shipping;

        if (customer.getBalance() < total) throw new IllegalStateException("Insufficient balance.");

        List<ShippableItem> shippables = new ArrayList<>();
        for (CartItem item : items) {
            if (item.needsShipping()) {
                shippables.add(new CartItemShippableAdapter(item));  // ADAPTER USED HERE
            }
        }

        if (!shippables.isEmpty()) ShippingService.ship(shippables);

        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + "\t" + item.getTotalPrice());
            item.getProduct().reduceQuantity(item.getQuantity());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal\t" + subtotal);
        System.out.println("Shipping\t" + shipping);
        System.out.println("Amount\t" + total);

        customer.deduct(total);
        System.out.println("Remaining balance: " + customer.getBalance());
    }
}
