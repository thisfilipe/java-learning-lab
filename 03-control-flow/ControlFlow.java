public class ControlFlow {
    public static void main(String[] args) {
        int age = 25;
        if (age >= 18) {
            System.out.println("Maior de age");
        } else {
            System.out.println("Menor de age");
        }

        for (int i = 1; i <= 5; i++) {
            int counter = i;
            System.out.println("Number: " + counter);
        }

        int counter = 5;
        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }
    }
}
