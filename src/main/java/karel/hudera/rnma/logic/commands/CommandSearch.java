package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.strings.StringResources;
import karel.hudera.rnma.logic.game.GamePlan;

/**
 * Represents the "search" command, which provides a detailed description of the current room.
 * Extends the base {@link Command} class.
 *
 * @author KarelHudera
 */
public class CommandSearch extends Command {

    /**
     * Constructs a new CommandSearch with the specified game plan.
     *
     * @param gamePlan the game plan associated with this command
     */
    public CommandSearch(GamePlan gamePlan) {
        super(StringResources.Commands.SEARCH, gamePlan);
    }

    /**
     * Executes the search command, returning a detailed description of the current room.
     *
     * @param param optional parameters for the command; ignored in this implementation
     * @return a detailed description of the current room
     */
    @Override
    public String makeCommand(String... param) {
        // Return the detailed description of the current room
        return this.getGamePlan().getCurrentRoom().detailedDescription();
    }
}