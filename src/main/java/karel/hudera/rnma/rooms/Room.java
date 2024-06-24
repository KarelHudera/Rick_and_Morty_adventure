package karel.hudera.rnma.rooms;

import karel.hudera.rnma.Strings.StringResources;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (!Objects.equals(name, room.name)) return false;
        if (!Objects.equals(description, room.description)) return false;
        if (!Objects.equals(entrances, room.entrances)) return false;
        if (!Objects.equals(items, room.items)) return false;
        return Objects.equals(characters, room.characters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, entrances, items, characters);
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

    public boolean containsCharacter(String characterName) {
        return characters.containsKey(characterName);
    }

    public Item getItem(String itemName) {
        return items.get(itemName);
    }

    public GameCharacter getCharacter(String characterName) {
        return characters.get(characterName);
    }

    public void addItem(Item item) {
        items.put(item.getName(), item);
    }

    public void addGameCharacter(GameCharacter character) {
        characters.put(character.getName(), character);
    }

    public Item removeItem(String itemName) {
        return items.remove(itemName);
    }

    public String detailedDescription() {
        return StringResources.Info.YOU_ARE_IN + description + "\n"
                + entrancesDescription() + "\n"
                + itemsDescription() + "\n"
                + charactersDescription();
    }

    private String entrancesDescription() {
        if (entrances.isEmpty()) {
            return StringResources.Info.ENTRANCES + StringResources.Errors.NONE;
        }

        StringBuilder outputText = new StringBuilder(StringResources.Info.ENTRANCES);
        for (Room entrance : entrances) {
            outputText.append(entrance.getName()).append(", ");
        }

        return outputText.substring(0, outputText.length() - 2);
    }

    private String itemsDescription() {
        if (items.isEmpty()) {
            return StringResources.Info.ITEMS + StringResources.Errors.NONE;
        }

        StringBuilder outputText = new StringBuilder(StringResources.Info.ITEMS);
        for (Map.Entry<String, Item> item : items.entrySet()) {
            outputText.append(item.getValue().getName()).append(", ");
        }

        return outputText.substring(0, outputText.length() - 2);
    }

    private String charactersDescription() {
        if (characters.isEmpty()) {
            return StringResources.Info.CHARACTERS + StringResources.Errors.NONE;
        }

        StringBuilder outputText = new StringBuilder(StringResources.Info.CHARACTERS);
        for (Map.Entry<String, GameCharacter> character : characters.entrySet()) {
            String name = character.getValue().getName();
            outputText.append(name.substring(0, 1).toUpperCase())
                    .append(name.substring(1)).append(", ");
        }

        return outputText.substring(0, outputText.length() - 2);
    }
}