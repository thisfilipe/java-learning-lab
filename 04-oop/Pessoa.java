public class Pessoa {
    private String nome;
    private int idade;
    private boolean ativo;
    private String email;

    private static int totalCriadas = 0;

    public Pessoa(String nome, int idade, boolean ativo, String email) {
        this.nome = nome;
        this.idade = idade;
        this.ativo = ativo;
        this.email = email;
        totalCriadas++;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Ativo: " + this.ativo);
        System.out.println("Email: " + this.email);
    }

    public String getNome() {
        return nome;
    }

    public static int getTotalCriadas() {
        return totalCriadas;
    }
}
