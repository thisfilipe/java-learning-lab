import java.util.ArrayList;
import java.util.List;

public class Listas {
    public static void main(String[] args) {
        List<String> listaDeNomes = new ArrayList<>();
        listaDeNomes.add("João");
        listaDeNomes.add("Maria");
        listaDeNomes.add("Carlos");
        listaDeNomes.add("Ana");
        System.out.println("Nomes na lista: " + listaDeNomes.size());

        listaDeNomes.remove("Carlos");
        System.out.println("Nomes após remoção: " + listaDeNomes.size());

        for (String nome : listaDeNomes) {
            System.out.println(nome);
        }
    }
}
