package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.logic.game.GamePlan;
import karel.hudera.rnma.strings.StringResources;

/**
 * Represents a command in the game logic. Commands are actions that a player can perform.
 * This class provides the base functionality for all commands.
 *
 * @author KarelHudera
 */
public class Command implements ICommand {
    private String NAME;
    private GamePlan gamePlan;

    /**
     * Constructs a new Command with the specified name and game plan.
     *
     * @param name     the name of the command
     * @param gamePlan the game plan associated with the command
     */
    public Command(String name, GamePlan gamePlan) {
        this.NAME = name;
        this.gamePlan = gamePlan;
    }

    /**
     * Executes the command with the given parameters. This is a default implementation that returns null.
     * Subclasses should override this method to provide specific command functionality.
     *
     * @param param parameters for the command
     * @return the result of the command execution
     */
    @Override
    public String makeCommand(String... param) {
        return null;  // Placeholder for command logic
    }

    /**
     * Returns the name of the command.
     *
     * @return the name of the command
     */
    @Override
    public String getName() {
        return this.NAME;
    }

    /**
     * Returns the game plan associated with the command.
     *
     * @return the game plan associated with the command
     */
    public GamePlan getGamePlan() {
        return this.gamePlan;
    }

    /**
     * Validates the parameters passed to the command. Ensures that exactly one parameter is specified.
     *
     * @param params parameters for the command
     * @return an error message if validation fails, null if parameters are valid
     */
    protected String validateParams(String... params) {
        if (params.length == 0) {
            return StringResources.Errors.SPECIFY_MORE_PARAM;  // No parameters provided
        } else if (params.length > 1) {
            return StringResources.Errors.SPECIFY_LESS_PARAM;  // Too many parameters provided
        }
        return null; // No validation error
    }
}