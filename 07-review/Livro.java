public class Livro {
    private String titulo;
    private String autor;
    private double preco;

    private static int totalCriados = 0;

    public Livro(String titulo, String autor, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        totalCriados++;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public double getPreco() {
        return preco;
    }

    public static int getTotalCriados() {
        return totalCriados;
    }
}