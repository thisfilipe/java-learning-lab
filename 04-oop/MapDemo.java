import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> agesByName = new HashMap<>();
        agesByName.put("John", 25);
        agesByName.put("Mary", 30);
        agesByName.put("Charles", 28);
        agesByName.put("Anna", 22);
        System.out.println("Idade de Mary: " + agesByName.get("Mary"));
        System.out.println("-------------------------------");

        agesByName.remove("Charles");
        System.out.println("Charles removido do mapa");
        agesByName.get("Charles");
        System.out.println("-------------------------------");

        for (Map.Entry<String, Integer> entry : agesByName.entrySet()) {
            System.out.println(entry.getKey() + " is " + entry.getValue() + " years old");
        }
        System.out.println("------------------------------");

        System.out.print("Registered people: ");
        int peopleCount = 0;
        for (String name : agesByName.keySet()) {
            peopleCount++;
            if (peopleCount > 1) {
                if (peopleCount == agesByName.size()) {
                    System.out.print(" e ");
                } else {
                    System.out.print(", ");
                }
            }
            System.out.print(name);
        }
        System.out.println(); // Print a line break
        System.out.println("------------------------------");

        System.out.print("Registered ages: ");
        int agesCount = 0;
        for (Integer age : agesByName.values()) {
            agesCount++;
            if (agesCount > 1) {
                if (agesCount == agesByName.size()) {
                    System.out.print(" e ");
                } else {
                    System.out.print(", ");
                }
            }
            System.out.print(age);
        }
        System.out.println(); // Print a line break
        System.out.println("------------------------------");

        System.out.println("Map size: " + agesByName.size() + " entries");
    }
}
