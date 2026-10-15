public class App {
    public static void main(String[] args) {
        Person person1 = new Person("John", 25, true, "john@example.com");
        person1.printInformation();
        Person person2 = new Person("Mary", 30, false, "mary@example.com");
        person2.printInformation();
        Employee employee1 = new Employee("Charles", 28, true, "charles@example.com", 5000.0);
        employee1.printInformation();
        employee1.printSalary();

        System.out.println("Total people created: " + Person.getTotalCreated());
    }
}
