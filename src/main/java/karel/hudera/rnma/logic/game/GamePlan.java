package karel.hudera.rnma.logic.game;

import karel.hudera.rnma.Strings.StringResources;
import karel.hudera.rnma.player.Inventory;
import karel.hudera.rnma.rooms.Room;
import java.util.HashMap;
import java.util.Map;

public class GamePlan {
    private Game game;
    private Room currentRoom;
    private Inventory inventory = new Inventory();
    private Map<String, Room> rooms = new HashMap<>();
    private Map<String, Character> characters = new HashMap<>();

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
}