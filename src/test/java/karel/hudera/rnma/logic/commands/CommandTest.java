package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.logic.mechanic.commands.Command;
import karel.hudera.rnma.logic.mechanic.game.Game;
import karel.hudera.rnma.logic.mechanic.game.GamePlan;
import karel.hudera.rnma.logic.strings.StringResources;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    private Command command;
    private GamePlan gamePlan;

    @BeforeEach
    void setUp() {
        // Initialize GamePlan and Command before each test
        gamePlan = new GamePlan(new Game());
        command = new TestCommand(gamePlan); // Assuming TestCommand is a concrete subclass for testing
    }

    @Test
    void makeCommand_ValidParams() {
        // Test the makeCommand method with valid parameters
        String result = command.makeCommand("valid parameter");
        assertNotNull(result, "The makeCommand should return a non-null result.");
        assertEquals("Command executed successfully.", result, "The command should return a success message.");
    }

    @Test
    void makeCommand_InvalidParams() {
        // Test the makeCommand method with invalid parameters
        String result = command.makeCommand("invalid parameter");
        assertEquals(StringResources.Errors.PARAM_DOESNT_EXIST, result, "The command should return an error message for invalid parameters.");
    }

    @Test
    void getName() {
        // Test getName method
        assertEquals("TestCommand", command.getName(), "The command name should be 'TestCommand'.");
    }

    @Test
    void getGamePlan() {
        // Test getGamePlan method
        assertEquals(gamePlan, command.getGamePlan(), "The GamePlan returned should be the same as the one set.");
    }

    @Test
    void validateParams_NoParams() {
        // Test validateParams with no parameters
        String result = command.validateParams();
        assertEquals(StringResources.Errors.SPECIFY_MORE_PARAM, result, "The validation should return an error message for no parameters.");
    }

    @Test
    void validateParams_TooManyParams() {
        // Test validateParams with too many parameters
        String result = command.validateParams("param1", "param2");
        assertEquals(StringResources.Errors.SPECIFY_LESS_PARAM, result, "The validation should return an error message for too many parameters.");
    }

    @Test
    void validateParams_ValidParams() {
        // Test validateParams with valid parameters
        String result = command.validateParams("valid parameter");
        assertNull(result, "The validation should return null for valid parameters.");
    }

    // A test concrete Command class for testing purposes
    private static class TestCommand extends Command {
        public TestCommand(GamePlan gamePlan) {
            super("TestCommand", gamePlan);
        }

        @Override
        public String makeCommand(String... params) {
            String validationError = validateParams(params);
            if (validationError != null) {
                return validationError;
            }
            return "Command executed successfully."; // Return a success message for valid params
        }

        @Override
        protected String validateParams(String... params) {
            if (params.length == 0) {
                return StringResources.Errors.SPECIFY_MORE_PARAM;
            } else if (params.length > 1) {
                return StringResources.Errors.SPECIFY_LESS_PARAM;
            } else if ("valid parameter".equals(params[0])) {
                return null; // Valid parameter
            }
            return StringResources.Errors.PARAM_DOESNT_EXIST; // Invalid parameter
        }
    }
}