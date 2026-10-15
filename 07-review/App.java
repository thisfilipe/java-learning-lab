import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Product product1 = new Product("Notebook", 2500.00, 3);
        Product product2 = new Product("Smartphone", 1500.00, 5);
        System.out.println("Product 1: " + product1.getName() + ", Price: " + product1.getPrice() + ", Quantity: " + product1.getQuantity());
        System.out.println("Product 2: " + product2.getName() + ", Price: " + product2.getPrice() + ", Quantity: " + product2.getQuantity());
        System.out.println("Total value of product 1: " + product1.totalValue());
        System.out.println("Total value of product 2: " + product2.totalValue());
        System.out.println("Total value of all products: " + (product1.totalValue() + product2.totalValue()));
        System.out.println("Total products created: " + Product.getTotalCreated());

        Book book1 = new Book("\"Java: How to Program\"", "Deitel & Deitel", 150.00);
        Book book2 = new Book("\"Clean Code\"", "Robert C. Martin", 120.00);
        System.out.println("Registered books: " + book1.getTitle() +  " and "  + book2.getTitle());
        System.out.println("Total books created: " + Book.getTotalCreated());
        
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        System.out.println("Adding another book to the list...");
        books.add(new Book("\"Effective Java\"", "Joshua Bloch", 130.00));
        System.out.println("Registered books:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Price: " + book.getPrice());
        }
        System.out.println("Removing an incorrect entry...");
        System.out.println("Book count before removal: " + books.size());
        books.remove(2);
        System.out.println("Book count after removal: " + books.size());
    }
}
