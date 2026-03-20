import java.util.TreeSet;
import java.util.SortedSet;

public class Main {

    public static void main(String[] args) {

        SortedSet<String> bogieIds = new TreeSet<>();

        System.out.println("=== Train Consist Management App ===");

        bogieIds.add("BG103");
        bogieIds.add("BG101");
        bogieIds.add("BG105");
        bogieIds.add("BG102");
        bogieIds.add("BG104");
        bogieIds.add("BG101");
        bogieIds.add("BG103");

        System.out.println("Sorted Unique Bogie IDs: " + bogieIds);
        System.out.println("Total Unique Bogies: " + bogieIds.size());
        System.out.println("First Bogie: " + bogieIds.first());
        System.out.println("Last Bogie: " + bogieIds.last());
    }
}