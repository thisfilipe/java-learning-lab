public class ArrayDemo {
    public static void main(String[] args) {
        String[] names = {"John", "Mary", "Charles", "Anna"};
        System.out.println("Nomes no array: " + names.length);

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}
