import java.util.*;
import java.util.stream.*;

class GoodsBogie {
    private String type;
    private String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC13 - Performance Comparison (Loops vs Streams)");
        System.out.println("======================================\n");

        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));
        bogies.add(new GoodsBogie("Cylindrical", "Coal"));

        System.out.println("Goods Bogies in Train:");
        for (GoodsBogie b : bogies) {
            System.out.println(b.getType() + " -> " + b.getCargo());
        }

        int iterations = 100000;

        // ---- Traditional Loop ----
        long loopStart = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            boolean isSafe = true;
            for (GoodsBogie b : bogies) {
                if (b.getType().equals("Cylindrical") &&
                        !b.getCargo().equals("Petroleum")) {
                    isSafe = false;
                    break;
                }
            }
        }

        long loopEnd = System.nanoTime();
        long loopDuration = loopEnd - loopStart;

        // ---- Stream Pipeline ----
        long streamStart = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            boolean isSafe = bogies.stream()
                    .allMatch(b ->
                            !b.getType().equals("Cylindrical") ||
                                    b.getCargo().equals("Petroleum")
                    );
        }

        long streamEnd = System.nanoTime();
        long streamDuration = streamEnd - streamStart;

        // ---- Results ----
        System.out.println("\nPerformance Results (over " + iterations + " iterations):");
        System.out.println("Loop   Duration : " + loopDuration + " ns");
        System.out.println("Stream Duration : " + streamDuration + " ns");

        System.out.println("\nConclusion:");
        if (loopDuration < streamDuration) {
            System.out.println("Traditional Loop is FASTER than Stream in this scenario.");
        } else {
            System.out.println("Stream is FASTER than Traditional Loop in this scenario.");
        }

        System.out.println("\nUC13 performance comparison completed...");
    }
}