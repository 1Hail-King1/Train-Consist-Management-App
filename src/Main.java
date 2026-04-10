public class Main {
    public static void main(String[] args) {

        // ✅ Safe case
        GoodsBogie g1 = new GoodsBogie("cylindrical");
        g1.assignCargo("petroleum");

        System.out.println("-----");

        // ❌ Unsafe case
        GoodsBogie g2 = new GoodsBogie("rectangular");
        g2.assignCargo("petroleum");

        System.out.println("Program continues...");
    }
}