package karel.hudera.rnma.rooms;

import karel.hudera.rnma.characters.GameCharacter;
import karel.hudera.rnma.items.Item;

import java.util.*;

public class Room {

    private String name;

    private String description;

    private Set<Room> entrances;
    private Map<String, Item> items = new HashMap<>();
    private Map<String, GameCharacter> characters = new HashMap<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        entrances = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Room getEntranceByName(String name) {
        return entrances.stream()
                .filter(room -> room.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public Set<Room> getEntrances() {
        return entrances;
    }

    public void setEntrance(Room entrance) {
        entrances.add(entrance);
    }

    public String getDescription() {
        return description;
    }

    public boolean containsItem(String itemName) {
        return items.containsKey(itemName);
    }

    public Item getItem(String itemName) {
        return items.get(itemName);
    }

    public void addItem(Item item) {
        items.put(item.getName(), item);
    }

    public Item removeItem(String itemName) {
        return items.remove(itemName);
    }

    public String detailedDescription() {
        return "You are in: " + description + "\n"
                + entrancesDescription() + "\n"
                + itemsDescription() + "\n"
                + charactersDescription();
    }

    private String entrancesDescription() {
        if (entrances.isEmpty()) {
            return "Entrances: None";
        }

        StringBuilder outputText = new StringBuilder("Entrances: ");
        for (Room entrance : entrances) {
            outputText.append(entrance.getName()).append(", ");
        }

        return outputText.substring(0, outputText.length() - 2);
    }

    private String itemsDescription() {
        if (items.isEmpty()) {
            return "Items: There is nothing";
        }

        StringBuilder outputText = new StringBuilder("Items: ");
        for (Map.Entry<String, Item> item : items.entrySet()) {
            outputText.append(item.getValue().getName()).append(", ");
        }

        return outputText.substring(0, outputText.length() - 2);
    }

    private String charactersDescription() {
        if (characters.isEmpty()) {
            return "Characters: There are no characters";
        }

        StringBuilder outputText = new StringBuilder("Characters: ");
        for (Map.Entry<String, GameCharacter> character : characters.entrySet()) {
            String name = character.getValue().getName();
            outputText.append(name.substring(0, 1).toUpperCase())
                    .append(name.substring(1)).append(", ");
        }

        return outputText.substring(0, outputText.length() - 2);
    }
}