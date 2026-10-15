import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Product product1 = new Product("Notebook", 2500.00, 3);
        Product product2 = new Product("Smartphone", 1500.00, 5);
        System.out.println("Product 1: " + product1.getName() + ", Price: " + product1.getPrice() + ", Quantity: " + product1.getQuantity());
        System.out.println("Product 2: " + product2.getName() + ", Price: " + product2.getPrice() + ", Quantity: " + product2.getQuantity());
        System.out.println("Valor total do product 1: " + product1.totalValue());
        System.out.println("Valor total do product 2: " + product2.totalValue());
        System.out.println("Valor total dos products: " + (product1.totalValue() + product2.totalValue()));
        System.out.println("Total de products criados: " + Product.getTotalCreated());

        Book book1 = new Book("\"Java: Como Programar\"", "Deitel & Deitel", 150.00);
        Book book2 = new Book("\"Clean Code\"", "Robert C. Martin", 120.00);
        System.out.println("Registered books: " + book1.getTitle() + " e " + book2.getTitle());
        System.out.println("Total de books criados: " + Book.getTotalCreated());
        
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        System.out.println("Adicionando mais um book à list...");
        books.add(new Book("\"Effective Java\"", "Joshua Bloch", 130.00));
        System.out.println("Lista de books cadastrados:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Price: " + book.getPrice());
        }
        System.out.println("Removing an incorrect entry...");
        System.out.println("Total de books antes da remoção: " + books.size());
        books.remove(2);
        System.out.println("Total de books após a remoção: " + books.size());
    }
}
