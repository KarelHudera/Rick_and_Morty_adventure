package karel.hudera.rnma.player;

import karel.hudera.rnma.strings.StringResources;
import karel.hudera.rnma.items.Item;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the player's inventory, including adding, removing, and checking items.
 * Limits the number of items that can be stored in the inventory.
 *
 * @author KarelHudera
 */
public class Inventory {
    private Map<String, Item> items = new HashMap<>();
    private Integer inventorySizeLimit = 3;

    /**
     * Displays the current inventory of items.
     *
     * @return a string representation of the inventory
     */
    public String showInventory() {
        StringBuilder outputText = new StringBuilder(StringResources.Info.INVENTORY);
        if (!items.isEmpty()) {
            for (Map.Entry<String, Item> item : items.entrySet()) {
                outputText.append(item.getKey()).append(", ");
            }
            // Remove the trailing comma and space
            outputText = new StringBuilder(outputText.substring(0, outputText.length() - 2));
        } else {
            outputText.append(StringResources.Errors.EMPTY_INVENTORY);
        }

        return outputText.toString();
    }

    /**
     * Adds an item to the inventory if there is space available.
     *
     * @param item the item to be added
     */
    public void addItem(Item item) {
        if (!isFull()) {
            items.put(item.getName(), item);
        }
    }

    /**
     * Removes an item from the inventory by its name.
     *
     * @param itemName the name of the item to remove
     * @return the removed item, or null if the item was not found
     */
    public Item removeItem(String itemName) {
        return items.remove(itemName);
    }

    /**
     * Checks if an item is present in the inventory.
     *
     * @param itemName the name of the item to check
     * @return true if the item is in the inventory, false otherwise
     */
    public boolean containsItem(String itemName) {
        return items.containsKey(itemName);
    }

    /**
     * Checks if the inventory is full.
     *
     * @return true if the inventory is full, false otherwise
     */
    public Boolean isFull() {
        return items.size() >= inventorySizeLimit;
    }
}