public class Estruturas {
    public static void main(String[] args) {
        int idade = 25;
        if (idade >= 18) {
            System.out.println("Maior de idade");
        } else {
            System.out.println("Menor de idade");
        }

        for (int i = 1; i <= 5; i++) {
            int contador = i;
            System.out.println("Número: " + contador);
        }

        int contador = 5;
        while (contador >= 1) {
            System.out.println(contador);
            contador--;
        }
    }
}
