public class Revisao1 {
    public static void main(String[] args) {
        int[] notas = {95, 80, 67, 45, 100};
        for (int nota : notas) {
            switch (nota / 10) {
                case 10 -> System.out.println("Nota: " + nota + " - Conceito: A");
                case 9 -> System.out.println("Nota: " + nota + " - Conceito: A");
                case 8 -> System.out.println("Nota: " + nota + " - Conceito: B");
                case 7 -> System.out.println("Nota: " + nota + " - Conceito: C");
                case 6 -> System.out.println("Nota: " + nota + " - Conceito: D");
                default -> System.out.println("Nota: " + nota + " - Conceito: F");
            }
        }
    }
}
