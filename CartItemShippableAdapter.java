// Use Adapter pattern to convert CartItem to ShippableItem without changing CartItem class
// Keeps CartItem focused (not all items are shipable) and lets it work with ShippingService
public class CartItemShippableAdapter implements ShippableItem {
    private final CartItem item;

    public CartItemShippableAdapter(CartItem item) {
        this.item = item;
    }

    public String getName() {
        return item.getProduct().getName();
    }

    public double getWeight() {
        return item.getTotalWeight();
    }
}
