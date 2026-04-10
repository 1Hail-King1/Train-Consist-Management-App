import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PassengerBogieTest {

    @Test
    void testValidCapacity() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie(40);
        assertEquals(40, bogie.getCapacity());
    }

    @Test
    void testInvalidCapacity() {
        assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie(0);
        });
    }

    @Test
    void testNegativeCapacity() {
        assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie(-5);
        });
    }
}