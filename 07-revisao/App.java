import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Produto produto1 = new Produto("Notebook", 2500.00, 3);
        Produto produto2 = new Produto("Smartphone", 1500.00, 5);
        System.out.println("Produto 1: " + produto1.getNome() + ", Preço: " + produto1.getPreco() + ", Quantidade: " + produto1.getQuantidade());
        System.out.println("Produto 2: " + produto2.getNome() + ", Preço: " + produto2.getPreco() + ", Quantidade: " + produto2.getQuantidade());
        System.out.println("Valor total do produto 1: " + produto1.valorTotal());
        System.out.println("Valor total do produto 2: " + produto2.valorTotal());
        System.out.println("Valor total dos produtos: " + (produto1.valorTotal() + produto2.valorTotal()));
        System.out.println("Total de produtos criados: " + Produto.getTotalCriados());

        Livro livro1 = new Livro("\"Java: Como Programar\"", "Deitel & Deitel", 150.00);
        Livro livro2 = new Livro("\"Clean Code\"", "Robert C. Martin", 120.00);
        System.out.println("Livros cadastrados: " + livro1.getTitulo() + " e " + livro2.getTitulo());
        System.out.println("Total de livros criados: " + Livro.getTotalCriados());
        
        List<Livro> livros = new ArrayList<>();
        livros.add(livro1);
        livros.add(livro2);
        System.out.println("Adicionando mais um livro à lista...");
        livros.add(new Livro("\"Effective Java\"", "Joshua Bloch", 130.00));
        System.out.println("Lista de livros cadastrados:");
        for (Livro livro : livros) {
            System.out.println("Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor() + ", Preço: " + livro.getPreco());
        }
        System.out.println("Removendo cadastro equivocado...");
        System.out.println("Total de livros antes da remoção: " + livros.size());
        livros.remove(2);
        System.out.println("Total de livros após a remoção: " + livros.size());
    }
}
