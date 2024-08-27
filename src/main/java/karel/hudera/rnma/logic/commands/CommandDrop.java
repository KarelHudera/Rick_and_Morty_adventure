package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.Strings.StringResources;
import karel.hudera.rnma.logic.game.GamePlan;

public class CommandDrop extends Command {
    public CommandDrop(GamePlan gamePlan) {
        super(StringResources.Commands.DROP, gamePlan);
    }

    @Override
    public String makeCommand(String... param) {
        String validationError = validateParams(param);
        if (validationError != null) {
            return validationError;
        }

        String itemName = param[0];
        String roomName = this.getGamePlan().getCurrentRoom().getName();

        if (!this.getGamePlan().getInventory().containsItem(itemName)) {
            return StringResources.Errors.PARAM_DOESNT_EXIST;
        }

        this.getGamePlan().getCurrentRoom().addItem(this.getGamePlan().getInventory().removeItem(itemName));
        return itemName + StringResources.Info.REMOVED_FROM_INVENTORY + roomName;
    }
}