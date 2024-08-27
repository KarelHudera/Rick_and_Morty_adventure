package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.Strings.StringResources;
import karel.hudera.rnma.logic.game.GamePlan;

public class Command implements ICommand{
    private String NAME;
    private GamePlan gamePlan;

    public Command(String name, GamePlan gamePlan) {
        this.NAME = name;
        this.gamePlan = gamePlan;
    }

    @Override
    public String makeCommand(String... param) {
        return null;
    }

    @Override
    public String getName() {
        return this.NAME;
    }

    public GamePlan getGamePlan() {
        return this.gamePlan;
    }

    protected String validateParams(String... params) {
        if (params.length == 0) {
            return StringResources.Errors.SPECIFY_MORE_PARAM;
        } else if (params.length > 1) {
            return StringResources.Errors.SPECIFY_LESS_PARAM;
        }
        return null; // No validation error
    }
}