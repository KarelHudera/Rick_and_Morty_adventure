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
}