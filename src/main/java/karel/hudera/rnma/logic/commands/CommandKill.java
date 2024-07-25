package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.Strings.StringResources;
import karel.hudera.rnma.logic.game.GamePlan;

public class CommandKill extends Command{
    public CommandKill(GamePlan gamePlan) {
        super(StringResources.Commands.KILL, gamePlan);
    }

    @Override
    public String makeCommand(String... param) {
        if (param.length == 0) {
            return StringResources.Errors.SPECIFY_PARAM;
        }

        String characterName = param[0];
        if (!this.getGamePlan().getCurrentRoom().containsCharacter(characterName)) {
            return StringResources.Errors.PARAM_DOESNT_EXIST;
        }

        this.getGamePlan().getGameCharacterByName(characterName).setDead();
        return capitalizeFirstLetter(characterName) + StringResources.Info.KILLED;
    }

    String capitalizeFirstLetter(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
}