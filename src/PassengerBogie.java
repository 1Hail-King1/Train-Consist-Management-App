public class PassengerBogie {

    private int capacity;

    public PassengerBogie(int capacity) throws InvalidCapacityException {

        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than 0");
        }

        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}