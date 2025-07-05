import java.util.List;
//Use strategy design pattern to make sure the code is open for extension closed for modification
//in case we want to add more shipping strategies like free shipping etc

public interface ShippingStrategy {
    double calculateShipping(List<CartItem> items);
}