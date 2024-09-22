package karel.hudera.rnma.rooms;

import karel.hudera.rnma.characters.GameCharacter;
import karel.hudera.rnma.items.Item;
import karel.hudera.rnma.strings.StringResources;

import java.util.*;

/**
 * Represents a room in the game, including its description, items, and characters.
 * Handles operations related to room entrances, item management, and character interactions.
 *
 * @author KarelHudera
 */
public class Room {
    private String name;
    private String description;
    private Set<Room> entrances;
    private Map<String, Item> items = new HashMap<>();
    private Map<String, GameCharacter> characters = new HashMap<>();

    /**
     * Constructs a Room with the specified name and description.
     *
     * @param name the name of the room
     * @param description the description of the room
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.entrances = new HashSet<>();
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
        return Objects.hash(name, description, items, characters);
    }

    /**
     * Returns the name of the room.
     *
     * @return the name of the room
     */
    public String getName() {
        return name;
    }

    /**
     * Finds and returns an entrance to this room by its name.
     *
     * @param name the name of the entrance room
     * @return the room representing the entrance, or null if not found
     */
    public Room getEntranceByName(String name) {
        return entrances.stream()
                .filter(room -> room.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * Returns the set of entrances to this room.
     *
     * @return the set of entrance rooms
     */
    public Set<Room> getEntrances() {
        return entrances;
    }

    /**
     * Adds an entrance to this room.
     *
     * @param entrance the room to be added as an entrance
     */
    public void setEntrance(Room entrance) {
        entrances.add(entrance);
    }

    /**
     * Returns the description of the room.
     *
     * @return the description of the room
     */
    public String getDescription() {
        return description;
    }

    /**
     * Checks if the room contains an item with the specified name.
     *
     * @param itemName the name of the item
     * @return true if the item is present, false otherwise
     */
    public boolean containsItem(String itemName) {
        return items.containsKey(itemName);
    }

    /**
     * Checks if the room contains a character with the specified name.
     *
     * @param characterName the name of the character
     * @return true if the character is present, false otherwise
     */
    public boolean containsCharacter(String characterName) {
        return characters.containsKey(characterName);
    }

    /**
     * Retrieves an item from the room by its name.
     *
     * @param itemName the name of the item
     * @return the item if found, or null if not found
     */
    public Item getItem(String itemName) {
        return items.get(itemName);
    }

    /**
     * Retrieves a character from the room by its name.
     *
     * @param characterName the name of the character
     * @return the character if found, or null if not found
     */
    public GameCharacter getCharacter(String characterName) {
        return characters.get(characterName);
    }

    /**
     * Adds an item to the room.
     *
     * @param item the item to be added
     */
    public void addItem(Item item) {
        items.put(item.getName(), item);
    }

    /**
     * Adds a character to the room.
     *
     * @param character the character to be added
     */
    public void addGameCharacter(GameCharacter character) {
        characters.put(character.getName(), character);
    }

    /**
     * Removes an item from the room by its name.
     *
     * @param itemName the name of the item to be removed
     * @return the removed item, or null if the item was not found
     */
    public Item removeItem(String itemName) {
        return items.remove(itemName);
    }

    /**
     * Provides a detailed description of the room, including its entrances,
     * items, characters, and dead characters.
     *
     * @return a string containing the detailed description of the room
     */
    public String detailedDescription() {
        return String.format("%s%s\n%s\n%s\n%s\n%s",
                StringResources.Info.YOU_ARE_IN,
                description,
                entrancesDescription(),
                itemsDescription(),
                charactersDescription(),
                deadCharactersDescription());
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
        StringBuilder outputText = new StringBuilder(StringResources.Info.CHARACTERS);
        boolean hasAliveCharacters = false;

        for (GameCharacter character : characters.values()) {
            if (character.isAlive()) {
                hasAliveCharacters = true;
                String name = character.getName();
                outputText.append(name.substring(0, 1).toUpperCase())
                        .append(name.substring(1)).append(", ");
            }
        }

        if (!hasAliveCharacters) {
            return outputText.append(StringResources.Errors.NONE).toString();
        }

        return outputText.substring(0, outputText.length() - 2);
    }

    private String deadCharactersDescription() {
        StringBuilder outputText = new StringBuilder(StringResources.Info.DEAD_CHARACTERS);
        boolean hasDeadCharacters = false;

        for (GameCharacter character : characters.values()) {
            if (!character.isAlive()) {
                hasDeadCharacters = true;
                String name = character.getName();
                outputText.append(name.substring(0, 1).toUpperCase())
                        .append(name.substring(1)).append(", ");
            }
        }

        if (!hasDeadCharacters) {
            return outputText.append(StringResources.Errors.NONE).toString();
        }

        return outputText.substring(0, outputText.length() - 2);
    }
}