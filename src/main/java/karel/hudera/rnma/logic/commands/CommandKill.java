package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.strings.StringResources;
import karel.hudera.rnma.logic.game.GamePlan;

/**
 * Represents the "kill" command, which allows a player to kill a character in the current room.
 * Extends the base {@link Command} class.
 *
 * @author KarelHudera
 */
public class CommandKill extends Command {

    /**
     * Constructs a new CommandKill with the specified game plan.
     *
     * @param gamePlan the game plan associated with this command
     */
    public CommandKill(GamePlan gamePlan) {
        super(StringResources.Commands.KILL, gamePlan);
    }

    /**
     * Executes the kill command with the given parameters. Validates the parameters, checks if the player has the necessary
     * item to kill the character, and attempts to kill the specified character in the current room.
     *
     * @param param the parameters for the command; expects exactly one parameter: the character name
     * @return the result of the command execution, either a success message or an error message
     */
    @Override
    public String makeCommand(String... param) {
        String validationError = validateParams(param);
        if (validationError != null) {
            return validationError;  // Return validation error if parameters are invalid
        }

        // Check if the player has the plasma blaster required to kill
        if (!this.getGamePlan().getInventory().containsItem("plasma_blaster")) {
            return StringResources.Errors.GET_GUN;  // Player does not have the required item
        }

        String characterName = param[0];

        // Check if the character exists in the current room
        if (!this.getGamePlan().getCurrentRoom().containsCharacter(characterName)) {
            return StringResources.Errors.PARAM_DOESNT_EXIST;  // Character does not exist in the room
        }

        // Kill the character
        this.getGamePlan().getGameCharacterByName(characterName).setDead();
        return capitalizeFirstLetter(characterName) + StringResources.Info.KILLED;  // Success message
    }

    /**
     * Capitalizes the first letter of the given text.
     *
     * @param text the text to capitalize
     * @return the text with the first letter capitalized
     */
    String capitalizeFirstLetter(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
}