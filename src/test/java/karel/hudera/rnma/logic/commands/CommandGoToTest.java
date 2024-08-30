package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.logic.game.Game;
import karel.hudera.rnma.logic.game.GamePlan;
import karel.hudera.rnma.rooms.Room;
import karel.hudera.rnma.strings.StringResources;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandGoToTest {

    private CommandGoTo commandGoTo;
    private GamePlan gamePlan;
    private Room livingRoom;
    private Room kitchen;

    @BeforeEach
    void setUp() {
        // Initialize GamePlan, rooms, and CommandGoTo before each test
        gamePlan = new GamePlan(new Game());

        // Create and set up rooms
        livingRoom = new Room("living_room", "Living Room");
        kitchen = new Room("kitchen", "Kitchen");

        // Set up room connections
        livingRoom.setEntrance(kitchen);
        kitchen.setEntrance(livingRoom);

        // Add rooms to the GamePlan
        gamePlan.getRoomByName("living_room");  // Assuming this method adds rooms or does some initialization
        gamePlan.getRoomByName("kitchen");

        // Set the initial current room
        gamePlan.setCurrentRoom(livingRoom);

        commandGoTo = new CommandGoTo(gamePlan);
    }

    @Test
    void makeCommand_ValidRoom() {
        // Move from living room to kitchen
        String result = commandGoTo.makeCommand("kitchen");

        // Assert the result is the description of the kitchen
        assertEquals("Kitchen", result, "The command should return the description of the kitchen.");

        // Assert the current room is now the kitchen
        assertEquals(kitchen, gamePlan.getCurrentRoom(), "The current room should be updated to the kitchen.");
    }

    @Test
    void makeCommand_InvalidRoom() {
        // Try to move to a non-existent room
        String result = commandGoTo.makeCommand("dining_room");

        // Assert the result is an error message for non-existent room
        assertEquals(StringResources.Errors.CANT_GO_THERE, result, "The command should return an error message for a non-existent room.");
    }

    @Test
    void makeCommand_UnreachableRoom() {
        // Create a new room that's not connected to the current room
        Room garage = new Room("garage", "Garage");
        gamePlan.getRoomByName("garage");  // Assuming this method adds rooms or does some initialization

        // Try to move to the new room that is not connected
        String result = commandGoTo.makeCommand("garage");

        // Assert the result is an error message for unreachable room
        assertEquals(StringResources.Errors.CANT_GO_THERE, result, "The command should return an error message for an unreachable room.");
    }

    @Test
    void makeCommand_NoParameters() {
        // Try to execute the command with no parameters
        String result = commandGoTo.makeCommand();

        // Assert the result is an error message for invalid parameters
        assertEquals(StringResources.Errors.SPECIFY_MORE_PARAM, result, "The command should return an error message for missing parameters.");
    }
}