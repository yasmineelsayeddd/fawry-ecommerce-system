// Represents an item in the cart (not all are shippable)
// Cleanly separated from shipping logic (Single Responsibility Principle)
public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public void increaseQuantity(int amount) { this.quantity += amount; }
    public double getTotalPrice() { return product.getPrice() * quantity; }
    public boolean isExpired() { return product.isExpired(); }
    public boolean needsShipping() { return product.needsShipping(); }
    public double getTotalWeight() { return product.getWeight() * quantity; }
}
