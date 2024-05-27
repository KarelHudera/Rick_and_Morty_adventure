package karel.hudera.rnma.logic.commands;

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
}