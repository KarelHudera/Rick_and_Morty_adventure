package karel.hudera.rnma.logic.game;

import karel.hudera.rnma.logic.game.GamePlan;

public interface IGame {
    String getIntro();
    String getOutro();
    String handleInput(String input);
    boolean gameOver();
    GamePlan getGamePlan();
}