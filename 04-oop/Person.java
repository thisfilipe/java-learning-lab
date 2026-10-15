public class Person {
    private String name;
    private int age;
    private boolean active;
    private String email;

    private static int totalCreated = 0;

    public Person(String name, int age, boolean active, String email) {
        this.name = name;
        this.age = age;
        this.active = active;
        this.email = email;
        totalCreated++;
    }

    public void printInformation() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Ativo: " + this.active);
        System.out.println("Email: " + this.email);
    }

    public String getName() {
        return name;
    }

    public static int getTotalCreated() {
        return totalCreated;
    }
}
