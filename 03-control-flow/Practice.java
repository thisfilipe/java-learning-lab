import java.time.LocalDate;

public class Practice {
    public static void main(String[] args) {

        // Print the current day of the week
        int weekday = LocalDate.now().getDayOfWeek().getValue();
        switch (weekday) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Saturday");
            case 7 -> System.out.println("Sunday");
            default -> System.out.println("Invalid day");
        }

        // Complete multiplication table up to 10
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " x " + j);
            }
        }

        // Multiplication table of 5
        int k = 5;
        for (int l = 1; l <= 10; l++) {
            System.out.println(k + " x " + l);
        }
    }
}
