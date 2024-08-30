package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.strings.StringResources;
import karel.hudera.rnma.logic.game.GamePlan;

import java.util.Objects;

/**
 * Represents the "open" command, which handles special cases of performing actions in the game.
 * Extends the base {@link Command} class.
 *
 * @author KarelHudera
 */
public class CommandOpen extends Command {

    /**
     * Constructs a new CommandOpen with the specified game plan.
     *
     * @param gamePlan the game plan associated with this command
     */
    public CommandOpen(GamePlan gamePlan) {
        super(StringResources.Commands.OPEN, gamePlan);
    }

    /**
     * Executes the open command with the given parameters. Validates the parameters and checks if the specified action is valid.
     *
     * @param param the parameters for the command; expects exactly one parameter: the item or action to open
     * @return the result of the command execution, either an error message or the result of the action
     */
    @Override
    public String makeCommand(String... param) {
        String validationError = validateParams(param);
        if (validationError != null) {
            return validationError;  // Return validation error if parameters are invalid
        }

        String parameter = param[0];

        // Check if the parameter is "shields"
        if (!Objects.equals(parameter, "shields")) {
            return StringResources.Errors.OPEN_SHIELDS;  // Parameter is not recognized for the "open" action
        }

        // Perform the action associated with opening shields
        return this.getGamePlan().endGame();  // End the game as the result of the action
    }
}