package karel.hudera.rnma.logic.mechanic.game;

import karel.hudera.rnma.presentation.observer.Observable;

public interface IGame extends Observable {
    String getIntro();
    String getOutro();
    String handleInput(String input);
    boolean gameOver();
    void setGameOver(boolean gameOver);
    GamePlan getGamePlan();

}