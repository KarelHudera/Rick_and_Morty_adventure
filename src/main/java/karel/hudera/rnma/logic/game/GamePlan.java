package karel.hudera.rnma.logic.game;

import karel.hudera.rnma.Strings.StringResources;
import karel.hudera.rnma.characters.Alien2;
import karel.hudera.rnma.characters.GameCharacter;
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
        Room room1 = new Room("room1", "ddddd");
        Room room2 = new Room("room2", "ggggg");
        rooms.put(room1.getName(), room1);
        rooms.put(room2.getName(), room2);

        room1.setEntrance(room2);
        room2.setEntrance(room1);

        currentRoom = room1;

        Item item1 = new Item("1", false);
        Item item2 = new Item("2", true);
        Item item3 = new Item("3", true);
        Item item5 = new Item("4", true);
        Item item6 = new Item("5", true);
        Item item4 = new Item("6", true);
        Item bag = new Item("bag", true);

        room1.addItem(item1);
        room1.addItem(item2);
        room1.addItem(item3);
        room1.addItem(item4);
        room1.addItem(item5);
        room1.addItem(item6);
        room1.addItem(bag);

        GameCharacter alien = new GameCharacter("alien", "hello");
        Alien2 alien2 = new Alien2(this,"alien2", "hello3");
        room1.addGameCharacter(alien);
        room1.addGameCharacter(alien2);

        characters.put(alien.getName(), alien);
        characters.put(alien2.getName(), alien2);

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

    public Inventory getInventory() {
        return this.inventory;
    }
}