// Base class for simple products that are neither expiring nor shippable
// Easily extendable through decorators (Open/Closed Principle)
public class BaseProduct implements Product {
    private String name;
    private double price;
    private int quantity;

    public BaseProduct(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void reduceQuantity(int amount) { quantity -= amount; }
    public boolean isExpired() { return false; }
    public boolean needsShipping() { return false; }
    public double getWeight() { return 0.0; }
}
