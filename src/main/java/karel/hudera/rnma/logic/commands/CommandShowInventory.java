package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.strings.StringResources;
import karel.hudera.rnma.logic.game.GamePlan;

/**
 * Represents the "show inventory" command, which displays the current inventory of the player.
 * Extends the base {@link Command} class.
 *
 * @author KarelHudera
 */
public class CommandShowInventory extends Command {

    /**
     * Constructs a new CommandShowInventory with the specified game plan.
     *
     * @param gamePlan the game plan associated with this command
     */
    public CommandShowInventory(GamePlan gamePlan) {
        super(StringResources.Commands.SHOW_INVENTORY, gamePlan);
    }

    /**
     * Executes the show inventory command, returning the current inventory of the player.
     *
     * @param param optional parameters for the command; ignored in this implementation
     * @return a string representation of the player's inventory
     */
    @Override
    public String makeCommand(String... param) {
        // Return the player's inventory as a string
        return this.getGamePlan().getInventory().showInventory();
    }
}