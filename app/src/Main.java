import java.util.HashSet;
import java.util.Set;

public class Main{

    public static void main(String[] args) {

        Set<String> bogieIds = new HashSet<>();

        System.out.println("=== Train Consist Management App ===");

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101");
        bogieIds.add("BG102");

        System.out.println("Unique Bogie IDs: " + bogieIds);
        System.out.println("Total Unique Bogies: " + bogieIds.size());
    }
}