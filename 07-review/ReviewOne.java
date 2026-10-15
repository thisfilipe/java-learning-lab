public class ReviewOne {
    public static void main(String[] args) {
        int[] grades = {95, 80, 67, 45, 100};
        for (int grade : grades) {
            switch (grade / 10) {
                case 10 -> System.out.println("Grade: " + grade + " - Letter grade: A");
                case 9 -> System.out.println("Grade: " + grade + " - Letter grade: A");
                case 8 -> System.out.println("Grade: " + grade + " - Letter grade: B");
                case 7 -> System.out.println("Grade: " + grade + " - Letter grade: C");
                case 6 -> System.out.println("Grade: " + grade + " - Letter grade: D");
                default -> System.out.println("Grade: " + grade + " - Letter grade: F");
            }
        }
    }
}
