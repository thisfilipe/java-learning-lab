public class App {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("João", 25, true, "joao@email.com");
        pessoa1.exibirInformacoes();
        Pessoa pessoa2 = new Pessoa("Maria", 30, false, "maria@email.com");
        pessoa2.exibirInformacoes();
        Funcionario funcionario1 = new Funcionario("Carlos", 28, true, "carlos@email.com", 5000.0);
        funcionario1.exibirInformacoes();
        funcionario1.mostrarSalario();

        System.out.println("Total de pessoas criadas: " + Pessoa.getTotalCriadas());
    }
}
