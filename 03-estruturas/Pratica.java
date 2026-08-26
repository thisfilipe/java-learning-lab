import java.time.LocalDate;

public class Pratica {
    public static void main(String[] args) {

        // Exibir o dia da semana atual
        int diaNumerico = LocalDate.now().getDayOfWeek().getValue();
        switch (diaNumerico) {
            case 1 -> System.out.println("Segunda-feira");
            case 2 -> System.out.println("Terça-feira");
            case 3 -> System.out.println("Quarta-feira");
            case 4 -> System.out.println("Quinta-feira");
            case 5 -> System.out.println("Sexta-feira");
            case 6 -> System.out.println("Sábado");
            case 7 -> System.out.println("Domingo");
            default -> System.out.println("Dia inválido");
        }

        // Tabuada completa até 10
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " x " + j);
            }
        }

        // Tabuada de 5
        int k = 5;
        for (int l = 1; l <= 10; l++) {
            System.out.println(k + " x " + l);
        }
    }
}
