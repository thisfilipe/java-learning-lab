import java.util.Map;
import java.util.HashMap;

public class MapReview {
    public static void main(String[] args) {
        Map<String, Double> products = new HashMap<>();
        products.put("Rice", 5.99);
        products.put("Beans", 7.49);
        products.put("Pasta", 3.99);

        System.out.println("Checking rice price...");
        System.out.println("Preço do Rice: " + products.get("Rice"));

        products.remove("Pasta");
        System.out.println("Pasta removido, aplicando preço padrão...");
        System.out.println("Preço do Pasta: " + products.getOrDefault("Pasta", 5.99));

        System.out.println("Calculando preço de todos os products...");
        for (Map.Entry<String, Double> product : products.entrySet()) {
            System.out.println("Product: " + product.getKey() + " | Price: " + product.getValue());
        }

        System.out.println("Calculando preço total dos products...");
        double totalPrice = 0.0;
        for (Double price : products.values()) {
            totalPrice += price;
        }
        System.out.println("Preço total dos products: " + totalPrice);
    }
}
