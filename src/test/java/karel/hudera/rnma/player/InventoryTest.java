package karel.hudera.rnma.player;

import karel.hudera.rnma.logic.items.Item;
import karel.hudera.rnma.logic.player.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    private Inventory inventory;

    @BeforeEach
    void setUp() {
        // Initialize the Inventory instance before each test
        inventory = new Inventory();
    }

    @Test
    void showInventory() {
        // Assuming showInventory() returns a string representation of the items in the inventory
        String expectedInventory = "Inventory: ";
        assertEquals(expectedInventory + "\uD83D\uDD34 nothing", inventory.showInventory(), "Inventory should be empty initially");

        // Add an item and check the updated inventory
        Item item1 = new Item("Laser Gun", true);
        inventory.addItem(item1);
        expectedInventory = "Inventory: Laser Gun";
        assertEquals(expectedInventory, inventory.showInventory(), "Inventory should list the added item");
    }

    @Test
    void addItem() {
        // Adding an item to the inventory
        Item item1 = new Item("Portal Gun", true);
        inventory.addItem(item1);
        assertTrue(inventory.containsItem("Portal Gun"), "Inventory should contain the added item");

        // Test adding item when inventory is full
        Item item2 = new Item("Plumbus", true);
        Item item3 = new Item("Meeseeks Box", true);
        Item item4 = new Item("Butter Robot", true);

        inventory.addItem(item2);
        inventory.addItem(item3);
        inventory.addItem(item4); // Should not be added as the inventory is full
        assertTrue(inventory.containsItem("Portal Gun"), "Inventory should still contain 'Portal Gun'");
        assertTrue(inventory.containsItem("Plumbus"), "Inventory should still contain 'Plumbus'");
        assertTrue(inventory.containsItem("Meeseeks Box"), "Inventory should still contain 'Meeseeks Box'");
        assertFalse(inventory.containsItem("Butter Robot"), "Inventory should not contain 'Butter Robot'");
    }

    @Test
    void removeItem() {
        // Add an item and then remove it
        Item item1 = new Item("Gun", true);
        inventory.addItem(item1);
        assertTrue(inventory.containsItem("Gun"), "Inventory should contain 'Gun' before removal");

        inventory.removeItem("Gun");
        assertFalse(inventory.containsItem("Gun"), "Inventory should not contain 'Gun' after removal");
    }

    @Test
    void containsItem() {
        // Check if the inventory contains an item that hasn't been added
        assertFalse(inventory.containsItem("Wubba Lubba Dub Dub"), "Inventory should not contain 'Wubba Lubba Dub Dub'");

        // Add an item and then check
        Item item1 = new Item("Szechuan Sauce", true);
        inventory.addItem(item1);
        assertTrue(inventory.containsItem("Szechuan Sauce"), "Inventory should contain 'Szechuan Sauce'");
    }

    @Test
    void isFull() {
        // Test if inventory is full
        assertFalse(inventory.isFull(), "Inventory should not be full initially");

        // Add items to fill up the inventory
        Item item1 = new Item("Item1", true);
        Item item2 = new Item("Item2", true);
        Item item3 = new Item("Item3", true);

        inventory.addItem(item1);
        inventory.addItem(item2);
        inventory.addItem(item3);

        assertTrue(inventory.isFull(), "Inventory should be full after adding 3 items");

        // Try adding one more item when it's full
        Item item4 = new Item("Item4", true);
        inventory.addItem(item4);
        assertFalse(inventory.containsItem("Item4"), "Inventory should not accept 'Item4' when full");
    }
}