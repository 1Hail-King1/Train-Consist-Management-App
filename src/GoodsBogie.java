public class GoodsBogie {

    private String shape;
    private String cargo;

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    public void assignCargo(String cargo) {

        try {
            // ❌ Unsafe condition
            if (cargo.equalsIgnoreCase("petroleum") &&
                    shape.equalsIgnoreCase("rectangular")) {

                throw new CargoSafetyException("Petroleum cannot be stored in rectangular bogie!");
            }

            // ✅ Safe assignment
            this.cargo = cargo;
            System.out.println("Cargo assigned: " + cargo);

        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Assignment attempt completed.");
        }
    }
}