package karel.hudera.rnma.items;

import karel.hudera.rnma.logic.items.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    private Item item;

    @BeforeEach
    void setUp() {
        // Initialize the Item instance before each test
        item = new Item("plasma_blaster", true);
    }

    @Test
    void getName() {
        // Test the getName method
        assertEquals("plasma_blaster", item.getName(), "The name of the item should be 'plasma_blaster'");
    }

    @Test
    void getCanBePicked() {
        // Test the getCanBePicked method
        assertTrue(item.getCanBePicked(), "The item should be pickable");
    }
}