package karel.hudera.rnma.logic.game;

import karel.hudera.rnma.Strings.StringResources;
import karel.hudera.rnma.characters.GameCharacter;
import karel.hudera.rnma.characters.Rick;
import karel.hudera.rnma.items.Item;
import karel.hudera.rnma.player.Inventory;
import karel.hudera.rnma.rooms.Room;

import java.util.HashMap;
import java.util.Map;

public class GamePlan {
    private Game game;
    private Room currentRoom;
    private Inventory inventory = new Inventory();
    private Map<String, Room> rooms = new HashMap<>();
    private Map<String, GameCharacter> characters = new HashMap<>();

    public GamePlan(Game game) {
        this.game = game;
        initializeGame();
    }

    private void initializeGame() {
        Room garage = new Room("garage", "garage");
        Room kitchen = new Room("kitchen", "kitchen");
        Room living_room = new Room("living_room", "living room");
        Room dining_room = new Room("dining_room", "dining room");

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

        currentRoom = dining_room;

        Item weapon = new Item("plasma_blaster", true);
        garage.addItem(weapon);

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
        GameCharacter raptor = new GameCharacter("262", "raptor", StringResources.SpeakStrings.RAPTOR_SPEAK);
        GameCharacter steve = new GameCharacter("391", "steve", StringResources.SpeakStrings.STEVE_SPEAK);

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

    public String endGame() {
        game.setGameOver(true);
        return StringResources.Outro.GAME_OVER;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getRoomByName(String name) {
        return rooms.get(name);
    }

    public GameCharacter getGameCharacterByName(String name) {
        return characters.get(name);
    }


    public Inventory getInventory() {
        return this.inventory;
    }
}