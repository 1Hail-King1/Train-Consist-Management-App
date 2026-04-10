public class Main {
    public static void main(String[] args) {

        try {
            // ✅ Valid bogie
            PassengerBogie b1 = new PassengerBogie(50);
            System.out.println("Bogie created with capacity: " + b1.getCapacity());

            // ❌ Invalid bogie
            PassengerBogie b2 = new PassengerBogie(0);
            System.out.println("This line will NOT execute");

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program continues...");
    }
}