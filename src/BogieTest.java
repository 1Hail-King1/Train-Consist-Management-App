import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BoogieTest {

    private List<PassengerBogie> bogieList;

    @BeforeEach
    void setUp() {
        // Sample data for testing
        bogieList = Arrays.asList(
                new PassengerBogie("B1", 72),
                new PassengerBogie("B2", 65),
                new PassengerBogie("B3", 80),
                new PassengerBogie("B4", 70)
        );
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        int threshold = 70;
        List<PassengerBogie> filteredList = bogieList.stream()
                .filter(b -> b.getSeatingCapacity() > threshold)
                .collect(Collectors.toList());

        // Should return B1 (72) and B3 (80)
        assertEquals(2, filteredList.size());
        assertTrue(filteredList.stream().allMatch(b -> b.getSeatingCapacity() > threshold));
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        int threshold = 70;
        List<PassengerBogie> filteredList = bogieList.stream()
                .filter(b -> b.getSeatingCapacity() > threshold)
                .collect(Collectors.toList());

        // B4 (70) should NOT be included because we use strict inequality (>)
        assertFalse(filteredList.stream().anyMatch(b -> b.getSeatingCapacity() == threshold));
    }

    @Test
    void testFilter_NoBogiesMatching() {
        int highThreshold = 100;
        List<PassengerBogie> filteredList = bogieList.stream()
                .filter(b -> b.getSeatingCapacity() > highThreshold)
                .collect(Collectors.toList());

        assertTrue(filteredList.isEmpty(), "The filtered list should be empty.");
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        int initialSize = bogieList.size();

        // Perform filtering
        bogieList.stream()
                .filter(b -> b.getSeatingCapacity() > 70)
                .collect(Collectors.toList());

        // Verify original list is still the same size
        assertEquals(initialSize, bogieList.size(), "The original list should remain unchanged.");
    }
}}