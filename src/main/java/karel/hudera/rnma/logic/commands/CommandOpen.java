package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.strings.StringResources;
import karel.hudera.rnma.logic.game.GamePlan;

import java.util.Objects;

public class CommandOpen extends Command {

    public CommandOpen(GamePlan gamePlan) {
        super(StringResources.Commands.OPEN, gamePlan);
    }

    @Override
    public String makeCommand(String... param) {
        String validationError = validateParams(param);
        if (validationError != null) {
            return validationError;
        }

        String parameter = param[0];
        if (!Objects.equals(parameter, "shields")) {
            return StringResources.Errors.OPEN_SHIELDS;
        }

        return this.getGamePlan().endGame();
    }
}