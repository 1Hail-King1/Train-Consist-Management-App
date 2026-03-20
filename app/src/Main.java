import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main(String[] args) {

        List<String> bogies = new ArrayList<>();

        System.out.println("=== Train Consist Management App ===");

        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("First Class");

        System.out.println("Bogies after addition: " + bogies);

        bogies.remove("AC Chair");

        System.out.println("Bogies after removal: " + bogies);

        System.out.println("Contains Sleeper: " + bogies.contains("Sleeper"));
    }
}