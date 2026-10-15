public class Book {
    private String title;
    private String author;
    private double price;

    private static int totalCreated = 0;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        totalCreated++;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public static int getTotalCreated() {
        return totalCreated;
    }
}