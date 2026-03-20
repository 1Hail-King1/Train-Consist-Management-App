import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<String> trainFormation = new LinkedHashSet<>();

        System.out.println("=== Train Consist Management App ===");

        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");
        trainFormation.add("Sleeper");

        System.out.println("Train Formation: " + trainFormation);
        System.out.println("Total Bogies: " + trainFormation.size());
    }
}