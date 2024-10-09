package karel.hudera.rnma.logic.mechanic.game;

import karel.hudera.rnma.logic.characters.GameCharacter;
import karel.hudera.rnma.logic.characters.Rick;
import karel.hudera.rnma.logic.items.Item;
import karel.hudera.rnma.logic.player.Inventory;
import karel.hudera.rnma.logic.rooms.Room;
import karel.hudera.rnma.logic.strings.StringResources;

import java.util.*;

/**
 * Manages the game's state, including rooms, characters, and inventory.
 * Responsible for initializing the game setup and providing methods to interact with the game world.
 *
 * @author KarelHudera
 */
public class GamePlan {
    private Game game;
    private Room currentRoom;
    private Inventory inventory = new Inventory();
    private Map<String, Room> rooms = new HashMap<>();
    private Map<String, GameCharacter> characters = new HashMap<>();

    /**
     * Constructs a new GamePlan instance and initializes the game world.
     *
     * @param game the game instance associated with this game plan
     */
    public GamePlan(Game game) {
        this.game = game;
        initializeGame();
    }

    /**
     * Initializes the game world, including rooms, items, and characters.
     */
    private void initializeGame() {
        // Create rooms
        Room garage = new Room("garage", "garage");
        Room kitchen = new Room("kitchen", "kitchen");
        Room living_room = new Room("living_room", "living room");
        Room dining_room = new Room("dining_room", "dining room");

        // Set up room connections
        rooms.put(garage.getName(), garage);
        rooms.put(kitchen.getName(), kitchen);
        rooms.put(living_room.getName(), living_room);
        rooms.put(dining_room.getName(), dining_room);

        garage.setEntrance(kitchen);
        kitchen.setEntrance(garage);
        kitchen.setEntrance(living_room);
        kitchen.setEntrance(dining_room);
        living_room.setEntrance(kitchen);
        living_room.setEntrance(dining_room);
        dining_room.setEntrance(kitchen);
        dining_room.setEntrance(living_room);

        // Set the starting room
        currentRoom = dining_room;

        // Add items
        Item weapon = new Item("plasma_blaster", true);
        garage.addItem(weapon);

        // Add characters
        Rick rick = new Rick(this, "rick", StringResources.SpeakStrings.RICK_SPEAK);
        GameCharacter summer = new GameCharacter("3", "summer", StringResources.SpeakStrings.SUMMER_SPEAK);
        GameCharacter beth = new GameCharacter("4", "beth", StringResources.SpeakStrings.BETH_SPEAK);
        GameCharacter jerry = new GameCharacter("5", "jerry", StringResources.SpeakStrings.JERRY_SPEAK);
        GameCharacter nicky = new GameCharacter("76", "nicky", StringResources.SpeakStrings.NICKY_SPEAK);
        GameCharacter frankenstein = new GameCharacter("128", "frankenstein", StringResources.SpeakStrings.FRANKENSTEIN_SPEAK);
        GameCharacter butler = new GameCharacter("236", "butler", StringResources.SpeakStrings.BUTLER_SPEAK);
        GameCharacter poopybutthole = new GameCharacter("244", "poopybutthole", StringResources.SpeakStrings.POOPYBUTTHOLE_SPEAK);
        GameCharacter fridge = new GameCharacter("248", "fridge", StringResources.SpeakStrings.FRIDGE_SPEAK);
        GameCharacter pencilvester = new GameCharacter("259", "pencilvester", StringResources.SpeakStrings.PENCILVESTER_SPEAK);
        GameCharacter raptor = new GameCharacter("262", "photoraptor", StringResources.SpeakStrings.RAPTOR_SPEAK);
        GameCharacter steve = new GameCharacter("391", "steve", StringResources.SpeakStrings.STEVE_SPEAK);

        // Add characters to maps
        characters.put(rick.getName(), rick);
        characters.put(summer.getName(), summer);
        characters.put(beth.getName(), beth);
        characters.put(jerry.getName(), jerry);
        characters.put(nicky.getName(), nicky);
        characters.put(frankenstein.getName(), frankenstein);
        characters.put(butler.getName(), butler);
        characters.put(poopybutthole.getName(), poopybutthole);
        characters.put(fridge.getName(), fridge);
        characters.put(pencilvester.getName(), pencilvester);
        characters.put(raptor.getName(), raptor);
        characters.put(steve.getName(), steve);

        // Add characters to rooms
        garage.addGameCharacter(rick);
        dining_room.addGameCharacter(summer);
        dining_room.addGameCharacter(beth);
        dining_room.addGameCharacter(jerry);
        dining_room.addGameCharacter(steve);
        dining_room.addGameCharacter(poopybutthole);
        living_room.addGameCharacter(nicky);
        living_room.addGameCharacter(frankenstein);
        living_room.addGameCharacter(butler);
        living_room.addGameCharacter(fridge);
        living_room.addGameCharacter(pencilvester);
        living_room.addGameCharacter(raptor);
    }

    /**
     * Checks if all characters are in their correct states (alive or dead).
     *
     * @param characters the map of characters to check
     * @return true if all characters are in their correct states, false otherwise
     */
    public boolean checkCharacterStates(Map<String, GameCharacter> characters) {
        // Set of characters that should be alive
        Set<String> shouldBeAlive = new HashSet<>(Arrays.asList("poopybutthole", "jerry", "beth", "summer", "rick"));

        for (GameCharacter character : characters.values()) {
            if (shouldBeAlive.contains(character.getName())) {
                // Check if a character that should be alive is actually dead
                if (!character.isAlive()) {
                    return false; // Incorrect state
                }
            } else {
                // Check if a character that should be dead is actually alive
                if (character.isAlive()) {
                    return false; // Incorrect state
                }
            }
        }
        return true; // All characters have correct states
    }

    /**
     * Ends the game and sets the game over status.
     *
     * @return the game over message
     */
    public String endGame() {
        game.setGameOver(true);

        if (checkCharacterStates(characters)) {
            return StringResources.Outro.GAME_OVER_WIN;
        } else {
            return StringResources.Outro.GAME_OVER_LOS;
        }
    }

    /**
     * Retrieves the current room.
     *
     * @return the current room
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Sets the current room.
     *
     * @param currentRoom the room to set as the current room
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * Retrieves a room by its name.
     *
     * @param name the name of the room
     * @return the room with the specified name, or null if not found
     */
    public Room getRoomByName(String name) {
        return rooms.get(name);
    }

    /**
     * Retrieves a game character by their name.
     *
     * @param name the name of the game character
     * @return the game character with the specified name, or null if not found
     */
    public GameCharacter getGameCharacterByName(String name) {
        return characters.get(name);
    }

    /**
     * Retrieves the player's inventory.
     *
     * @return the inventory
     */
    public Inventory getInventory() {
        return this.inventory;
    }
}