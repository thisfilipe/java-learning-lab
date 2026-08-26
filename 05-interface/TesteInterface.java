import java.util.List;

public class TesteInterface {
    public static void main(String[] args) {
        List<Saudacao> pessoas = List.of(new Portugues(), new Ingles(), new Espanhol());
        cumprimentarTodos(pessoas);
    }

    static void cumprimentarTodos(List<Saudacao> lista) {
        for (Saudacao s : lista) {
            s.cumprimentar();
        }
    }
}
