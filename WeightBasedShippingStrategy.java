import java.util.List;
//default shipping strategy
public class WeightBasedShippingStrategy implements ShippingStrategy {
    public double calculateShipping(List<CartItem> items) {
        double totalWeight = 0.0;
        for (CartItem item : items) {
            if (item.needsShipping()) {
                totalWeight += item.getTotalWeight();
            }
        }
        return (totalWeight / 1000.0) * 30; // 30 per kg
    }
} 