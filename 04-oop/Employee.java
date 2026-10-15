public class Employee extends Person {
    private double salary;

    public Employee(String name, int age, boolean active, String email, double salary) {
        super(name, age, active, email); // chama o construtor da classe "pai" (Person)
        this.salary = salary;
    }

    public void printSalary() {
        System.out.println(this.getName() + " earns BRL " + this.salary);
    }
}
