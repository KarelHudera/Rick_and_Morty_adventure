package karel.hudera.rnma.player;

import karel.hudera.rnma.Strings.StringResources;
import karel.hudera.rnma.items.Item;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Item> items = new HashMap<>();
    private Integer inventorySizeLimit = 3;

    public String showInventory() {
        StringBuilder outputText = new StringBuilder(StringResources.Info.INVENTORY);
        if (!items.isEmpty()) {
            for (Map.Entry<String, Item> vec : items.entrySet()) {
                outputText.append(vec.getKey()).append(", ");
            }
            outputText = new StringBuilder(outputText.substring(0, outputText.length() - 2));
        } else {
            outputText.append(StringResources.Errors.EMPTY_INVENTORY);
        }

        return outputText.toString();
    }

    public void addItem(Item item) {
        if (!isFull()) {
            items.put(item.getName(), item);
        }
    }

    public Item removeItem(String itemName) {
        return items.remove(itemName);
    }

    public boolean containsItem(String itemName) {
        return items.containsKey(itemName);
    }

    public Boolean isFull() {
//        if (items.containsKey("bag")) return items.size() >= inventorySizeLimit + 3;
        return items.size() >= inventorySizeLimit;
    }
}