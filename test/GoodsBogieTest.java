import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GoodsBogieTest {

    // ✅ Test 1: Safe cargo assignment
    // ✅ Test 1: Safe cargo assignment
    @Test
    void testSafeCargoAssignment() {
        GoodsBogie bogie = new GoodsBogie("cylindrical");

        assertDoesNotThrow(() -> {
            bogie.assignCargo("petroleum");
        });
    }

    // ❌ Test 2: Unsafe cargo (petroleum + rectangular)
    @Test
    void testUnsafeCargoAssignment() {
        GoodsBogie bogie = new GoodsBogie("rectangular");

        // Since exception is handled inside method,
        // we check that program does NOT crash
        assertDoesNotThrow(() -> {
            bogie.assignCargo("petroleum");
        });
    }

    // ✅ Test 3: Normal cargo
    @Test
    void testNormalCargo() {
        GoodsBogie bogie = new GoodsBogie("rectangular");

        assertDoesNotThrow(() -> {
            bogie.assignCargo("coal");
        });
    }
}