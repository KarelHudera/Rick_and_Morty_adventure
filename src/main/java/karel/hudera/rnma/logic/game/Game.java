package karel.hudera.rnma.logic.game;

import karel.hudera.rnma.logic.commands.CommandsList;

public class Game implements IGame {
    private CommandsList commandsList;
    private GamePlan gamePlan;
    private boolean gameOver = false;

    @Override
    public String getIntro() {
        return null;
    }

    @Override
    public String getOutro() {
        return null;
    }

    @Override
    public String handleInput(String input) {
        return null;
    }

    @Override
    public boolean gameOver() {
        return false;
    }

    @Override
    public GamePlan getGamePlan() {
        return null;
    }
}
