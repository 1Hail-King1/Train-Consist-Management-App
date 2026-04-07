import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class BogieTest {

    private List<Bogie> bogieList;

    @BeforeEach
    void setUp() {
        try {
            bogieList = Arrays.asList(
                    new Bogie("B1", 72),
                    new Bogie("B2", 65),
                    new Bogie("B3", 80),
                    new Bogie("B4", 70)
            );
        } catch (InvalidCapacityException e) {
            e.printStackTrace();
        }
    }

    private List<Bogie> filterByCapacity(int threshold) {
        return bogieList.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        int threshold = 70;

        List<Bogie> filteredList = filterByCapacity(threshold);

        assertEquals(2, filteredList.size());
        assertTrue(filteredList.stream()
                .allMatch(b -> b.getCapacity() > threshold));
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        int threshold = 70;

        List<Bogie> filteredList = filterByCapacity(threshold);

        assertFalse(filteredList.stream()
                .anyMatch(b -> b.getCapacity() == threshold));
    }

    @Test
    void testFilter_NoBogiesMatching() {
        int highThreshold = 100;

        List<Bogie> filteredList = filterByCapacity(highThreshold);

        assertTrue(filteredList.isEmpty(),
                "The filtered list should be empty.");
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        int initialSize = bogieList.size();

        filterByCapacity(70);

        assertEquals(initialSize, bogieList.size(),
                "The original list should remain unchanged.");
    }
}