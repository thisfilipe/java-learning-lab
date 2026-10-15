import java.util.List;

public class InterfaceDemo {
    public static void main(String[] args) {
        List<Greeting> people = List.of(new PortugueseGreeting(), new EnglishGreeting(), new SpanishGreeting());
        greetEveryone(people);
    }

    static void greetEveryone(List<Greeting> list) {
        for (Greeting s : list) {
            s.greet();
        }
    }
}
