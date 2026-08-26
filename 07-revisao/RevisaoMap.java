import java.util.Map;
import java.util.HashMap;

public class RevisaoMap {
    public static void main(String[] args) {
        Map<String, Double> produtos = new HashMap<>();
        produtos.put("Arroz", 5.99);
        produtos.put("Feijão", 7.49);
        produtos.put("Macarrão", 3.99);

        System.out.println("Calculando preço do arroz...");
        System.out.println("Preço do Arroz: " + produtos.get("Arroz"));

        produtos.remove("Macarrão");
        System.out.println("Macarrão removido, aplicando preço padrão...");
        System.out.println("Preço do Macarrão: " + produtos.getOrDefault("Macarrão", 5.99));

        System.out.println("Calculando preço de todos os produtos...");
        for (Map.Entry<String, Double> produto : produtos.entrySet()) {
            System.out.println("Produto: " + produto.getKey() + " | Preço: " + produto.getValue());
        }

        System.out.println("Calculando preço total dos produtos...");
        double precoTotal = 0.0;
        for (Double preco : produtos.values()) {
            precoTotal += preco;
        }
        System.out.println("Preço total dos produtos: " + precoTotal);
    }
}
