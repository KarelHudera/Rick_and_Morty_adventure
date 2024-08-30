package karel.hudera.rnma.logic.game;

import karel.hudera.rnma.strings.StringResources;
import karel.hudera.rnma.characters.GameCharacter;
import karel.hudera.rnma.player.Inventory;
import karel.hudera.rnma.rooms.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GamePlanTest {

    private GamePlan gamePlan;
    private Game game;
    private Room livingRoom, kitchen, garage, diningRoom;
    private GameCharacter rick, summer, beth, jerry, poopybutthole;
    private Inventory inventory;

    @BeforeEach
    void setUp() {
        // Initialize the Game instance
        game = new Game();

        // Initialize the GamePlan instance
        gamePlan = new GamePlan(game);
        inventory = gamePlan.getInventory();

        // Retrieve rooms from the GamePlan
        livingRoom = gamePlan.getRoomByName("living_room");
        kitchen = gamePlan.getRoomByName("kitchen");
        garage = gamePlan.getRoomByName("garage");
        diningRoom = gamePlan.getRoomByName("dining_room");

        // Retrieve characters from the GamePlan
        poopybutthole = gamePlan.getGameCharacterByName("poopybutthole");
        jerry = gamePlan.getGameCharacterByName("jerry");
        beth = gamePlan.getGameCharacterByName("beth");
        summer = gamePlan.getGameCharacterByName("summer");
        rick = gamePlan.getGameCharacterByName("rick");

        garage.addGameCharacter(poopybutthole);
        garage.addGameCharacter(jerry);
        garage.addGameCharacter(beth);
        garage.addGameCharacter(summer);
        garage.addGameCharacter(rick);
    }

//    @Test TODO
//    void endGameWin() {
//        gamePlan.getGameCharacterByName("poopybutthole");
//        gamePlan.getGameCharacterByName("jerry");
//        gamePlan.getGameCharacterByName("beth");
//        gamePlan.getGameCharacterByName("summer");
//        gamePlan.getGameCharacterByName("rick");
//
//        String result = gamePlan.endGame();
//        assertEquals(StringResources.Outro.GAME_OVER_WIN, result, "Game should end with a win message");
//    }

    @Test
    void endGameLose() {
        // Setting some characters as dead to test the losing condition
        gamePlan.getGameCharacterByName("rick");
        gamePlan.getGameCharacterByName("summer");
        gamePlan.getGameCharacterByName("beth");
        gamePlan.getGameCharacterByName("jerry");
        gamePlan.getGameCharacterByName("nicky");

        String result = gamePlan.endGame();
        assertEquals(StringResources.Outro.GAME_OVER_LOS, result, "Game should end with a lose message");
    }

    @Test
    void getCurrentRoom() {
        assertEquals(diningRoom, gamePlan.getCurrentRoom(), "Initial current room should be dining room");
    }

    @Test
    void setCurrentRoom() {
        gamePlan.setCurrentRoom(livingRoom);
        assertEquals(livingRoom, gamePlan.getCurrentRoom(), "Current room should be set to living room");
    }

    @Test
    void getRoomByName() {
        assertEquals(garage, gamePlan.getRoomByName("garage"), "Should retrieve the correct room by name");
        assertNull(gamePlan.getRoomByName("non_existent_room"), "Retrieving a non-existent room should return null");
    }

    @Test
    void getGameCharacterByName() {
        assertEquals(rick, gamePlan.getGameCharacterByName("rick"), "Should retrieve the correct character by name");
        assertNull(gamePlan.getGameCharacterByName("non_existent_character"), "Retrieving a non-existent character should return null");
    }

    @Test
    void getInventory() {
        assertNotNull(inventory, "The inventory should not be null");
    }
}