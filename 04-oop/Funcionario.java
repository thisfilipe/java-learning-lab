public class Funcionario extends Pessoa {
    private double salario;

    public Funcionario(String nome, int idade, boolean ativo, String email, double salario) {
        super(nome, idade, ativo, email); // chama o construtor da classe "pai" (Pessoa)
        this.salario = salario;
    }

    public void mostrarSalario() {
        System.out.println(this.getNome() + " ganha R$" + this.salario);
    }
}
