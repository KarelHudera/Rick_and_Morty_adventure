package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.strings.StringResources;
import karel.hudera.rnma.logic.game.GamePlan;

public class CommandSearch extends Command {
    public CommandSearch(GamePlan gamePlan) {
        super(StringResources.Commands.SEARCH, gamePlan);
    }

    @Override
    public String makeCommand(String... param) {
        return this.getGamePlan().getCurrentRoom().detailedDescription();
    }
}