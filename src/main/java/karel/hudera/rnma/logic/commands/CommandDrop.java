package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.logic.game.GamePlan;
import karel.hudera.rnma.strings.StringResources;

/**
 * Represents the "drop" command in the game, which allows a player to drop an item from their inventory into the current room.
 * Extends the base {@link Command} class.
 *
 * @author KarelHudera
 */
public class CommandDrop extends Command {

    /**
     * Constructs a new CommandDrop with the specified game plan.
     *
     * @param gamePlan the game plan associated with this command
     */
    public CommandDrop(GamePlan gamePlan) {
        super(StringResources.Commands.DROP, gamePlan);
    }

    /**
     * Executes the drop command with the given parameters. Validates the parameters and attempts to drop the specified item
     * from the player's inventory into the current room.
     *
     * @param param the parameters for the command; expects exactly one parameter: the item name
     * @return the result of the command execution, either success or error message
     */
    @Override
    public String makeCommand(String... param) {
        String validationError = validateParams(param);
        if (validationError != null) {
            return validationError;  // Return validation error if parameters are invalid
        }

        String itemName = param[0];
        String roomName = this.getGamePlan().getCurrentRoom().getName();

        // Check if the inventory contains the item
        if (!this.getGamePlan().getInventory().containsItem(itemName)) {
            return StringResources.Errors.PARAM_DOESNT_EXIST;  // Item does not exist in inventory
        }

        // Drop the item into the current room
        this.getGamePlan().getCurrentRoom().addItem(this.getGamePlan().getInventory().removeItem(itemName));
        return itemName + StringResources.Info.REMOVED_FROM_INVENTORY + roomName;  // Success message
    }
}