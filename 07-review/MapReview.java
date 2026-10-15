import java.util.Map;
import java.util.HashMap;

public class MapReview {
    public static void main(String[] args) {
        Map<String, Double> products = new HashMap<>();
        products.put("Rice", 5.99);
        products.put("Beans", 7.49);
        products.put("Pasta", 3.99);

        System.out.println("Checking rice price...");
        System.out.println("Rice price: " + products.get("Rice"));

        products.remove("Pasta");
        System.out.println("Pasta removed, using a default price...");
        System.out.println("Pasta price: " + products.getOrDefault("Pasta", 5.99));

        System.out.println("Checking all product prices...");
        for (Map.Entry<String, Double> product : products.entrySet()) {
            System.out.println("Product: " + product.getKey() + " | Price: " + product.getValue());
        }

        System.out.println("Calculating the total price...");
        double totalPrice = 0.0;
        for (Double price : products.values()) {
            totalPrice += price;
        }
        System.out.println("Total product price: " + totalPrice);
    }
}
