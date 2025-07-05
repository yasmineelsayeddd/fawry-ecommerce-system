// Define a common interface for all products to enforce polymorphism and abstraction 
//(SOLID: Interface Segregation & Liskov Substitution)
public interface Product {
    String getName();
    double getPrice();
    int getQuantity();
    void reduceQuantity(int amount);
    boolean isExpired();
    boolean needsShipping();
    double getWeight();
}
