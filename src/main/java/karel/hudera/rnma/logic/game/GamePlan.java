package karel.hudera.rnma.logic.game;

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

    }

    public String endGame() {
        game.setGameOver(true);
        return "Game Over";
    }
}