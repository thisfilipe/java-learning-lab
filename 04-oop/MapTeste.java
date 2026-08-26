import java.util.HashMap;
import java.util.Map;

public class MapTeste {
    public static void main(String[] args) {
        Map<String, Integer> mapaDeIdades = new HashMap<>();
        mapaDeIdades.put("João", 25);
        mapaDeIdades.put("Maria", 30);
        mapaDeIdades.put("Carlos", 28);
        mapaDeIdades.put("Ana", 22);
        System.out.println("Idade de Maria: " + mapaDeIdades.get("Maria"));
        System.out.println("-------------------------------");

        mapaDeIdades.remove("Carlos");
        System.out.println("Carlos removido do mapa");
        mapaDeIdades.get("Carlos");
        System.out.println("-------------------------------");

        for (Map.Entry<String, Integer> entrada : mapaDeIdades.entrySet()) {
            System.out.println(entrada.getKey() + " tem " + entrada.getValue() + " anos");
        }
        System.out.println("------------------------------");

        System.out.print("Pessoas cadastradas: ");
        int contadorDePessoas = 0;
        for (String nome : mapaDeIdades.keySet()) {
            contadorDePessoas++;
            if (contadorDePessoas > 1) {
                if (contadorDePessoas == mapaDeIdades.size()) {
                    System.out.print(" e ");
                } else {
                    System.out.print(", ");
                }
            }
            System.out.print(nome);
        }
        System.out.println(); // Adiciona uma quebra de linha
        System.out.println("------------------------------");

        System.out.print("Idades cadastradas: ");
        int contadorDeIdades = 0;
        for (Integer idade : mapaDeIdades.values()) {
            contadorDeIdades++;
            if (contadorDeIdades > 1) {
                if (contadorDeIdades == mapaDeIdades.size()) {
                    System.out.print(" e ");
                } else {
                    System.out.print(", ");
                }
            }
            System.out.print(idade);
        }
        System.out.println(); // Adiciona uma quebra de linha
        System.out.println("------------------------------");

        System.out.println("Tamanho do mapa: " + mapaDeIdades.size() + " pares cadastrados");
    }
}
