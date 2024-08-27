package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.strings.StringResources;
import karel.hudera.rnma.logic.game.GamePlan;

public class CommandShowInventory extends Command {
    public CommandShowInventory(GamePlan gamePlan) {
        super(StringResources.Commands.SHOW_INVENTORY, gamePlan);
    }

    @Override
    public String makeCommand(String... param) {
        return this.getGamePlan().getInventory().showInventory();
    }
}
