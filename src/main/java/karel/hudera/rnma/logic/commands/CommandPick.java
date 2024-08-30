package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.strings.StringResources;
import karel.hudera.rnma.items.Item;
import karel.hudera.rnma.logic.game.GamePlan;

/**
 * Represents the "pick" command, which allows the player to pick up an item from the current room.
 * Extends the base {@link Command} class.
 *
 * @author KarelHudera
 */
public class CommandPick extends Command {

    /**
     * Constructs a new CommandPick with the specified game plan.
     *
     * @param gamePlan the game plan associated with this command
     */
    public CommandPick(GamePlan gamePlan) {
        super(StringResources.Commands.PICK, gamePlan);
    }

    /**
     * Executes the pick command with the given parameters. Validates the parameters, checks if the item can be picked,
     * and handles adding the item to the inventory.
     *
     * @param param the parameters for the command; expects exactly one parameter: the item name to pick up
     * @return the result of the command execution, either an error message or a success message
     */
    @Override
    public String makeCommand(String... param) {
        // Validate parameters
        String validationError = validateParams(param);
        if (validationError != null) {
            return validationError;  // Return validation error if parameters are invalid
        }

        String itemName = param[0];

        // Check if the item exists in the current room
        if (!this.getGamePlan().getCurrentRoom().containsItem(itemName)) {
            return StringResources.Errors.PARAM_DOESNT_EXIST;  // Item not found in the room
        }

        Item item = this.getGamePlan().getCurrentRoom().getItem(itemName);

        // Check if the inventory is full
        if (this.getGamePlan().getInventory().isFull()) {
            return StringResources.Errors.FULL_INVENTORY;  // Inventory is full
        }

        // Check if the item can be picked
        if (!item.getCanBePicked()) {
            return StringResources.Errors.CANT_BE_PICKED;  // Item cannot be picked
        }

        // Add the item to the inventory
        this.getGamePlan().getInventory().addItem(this.getGamePlan().getCurrentRoom().removeItem(itemName));
        return item.getName() + StringResources.Info.ADDED_TO_INVENTORY;  // Success message
    }
}