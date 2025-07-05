import java.util.List;

public class ShippingService {
    public static void ship(List<ShippableItem> shippableItems) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0.0;
        for (ShippableItem item : shippableItems) {
            System.out.println("- " + item.getName() + " " + item.getWeight() + "g");
            totalWeight += item.getWeight();
        }
        System.out.println("Total package weight " + (totalWeight / 1000.0) + "kg");
    }
}
