// Use Decorator pattern to add expiry behavior without modifying original product class
// Helps follow Open/Closed Principle
import java.util.Date;

public class ExpiringProductDecorator implements Product {
    private Product product;
    private Date expiryDate;

    public ExpiringProductDecorator(Product product, Date expiryDate) {
        this.product = product;
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() { return new Date().after(expiryDate); }
    public boolean needsShipping() { return product.needsShipping(); }
    public double getWeight() { return product.getWeight(); }
    public String getName() { return product.getName(); }
    public double getPrice() { return product.getPrice(); }
    public int getQuantity() { return product.getQuantity(); }
    public void reduceQuantity(int amount) { product.reduceQuantity(amount); }
}