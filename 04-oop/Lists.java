import java.util.ArrayList;
import java.util.List;

public class Lists {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Mary");
        names.add("Charles");
        names.add("Anna");
        System.out.println("Names in the list: " + names.size());

        names.remove("Charles");
        System.out.println("Names after removal: " + names.size());

        for (String name : names) {
            System.out.println(name);
        }
    }
}
