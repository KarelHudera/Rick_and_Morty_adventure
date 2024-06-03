package karel.hudera.rnma.logic.commands;


import karel.hudera.rnma.Strings.StringResources;
import karel.hudera.rnma.items.Item;
import karel.hudera.rnma.logic.game.GamePlan;


public class CommandPick extends Command {
    public CommandPick(GamePlan gamePlan) {
        super(StringResources.Commands.PICK, gamePlan);
    }

    @Override
    public String makeCommand(String... param) {
        if (param.length == 0) {
            return StringResources.Errors.SPECIFY_PARAM;
        }

        String itemName = param[0];
        if (!this.getGamePlan().getCurrentRoom().containsItem(itemName)) {
            return StringResources.Errors.PARAM_DOESNT_EXIST;
        }

        Item item = this.getGamePlan().getCurrentRoom().getItem(itemName);
        if (this.getGamePlan().getInventory().isFull()) {
            return StringResources.Errors.FULL_INVENTORY;
        }

        if (!item.getCanBePicked()) {
            return StringResources.Errors.CANT_BE_PICKED;
        }

        this.getGamePlan().getInventory().addItem(this.getGamePlan().getCurrentRoom().removeItem(itemName));
        return item.getName() + StringResources.Info.ADDED_TO_INVENTORY;
    }
}
