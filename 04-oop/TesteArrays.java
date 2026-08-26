public class TesteArrays {
    public static void main(String[] args) {
        String[] listaDeNomes = {"João", "Maria", "Carlos", "Ana"};
        System.out.println("Nomes no array: " + listaDeNomes.length);

        for (int i = 0; i < listaDeNomes.length; i++) {
            System.out.println(listaDeNomes[i]);
        }

        for (String nome : listaDeNomes) {
            System.out.println(nome);
        }
    }
}
