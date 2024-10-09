package karel.hudera.rnma.logic.mechanic.game;

public interface IGame {
    String getIntro();
    String getOutro();
    String handleInput(String input);
    boolean gameOver();
    void setGameOver(boolean gameOver);
    GamePlan getGamePlan();
}