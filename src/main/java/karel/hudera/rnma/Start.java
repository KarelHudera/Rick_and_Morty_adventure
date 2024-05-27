package karel.hudera.rnma;

import karel.hudera.rnma.logic.game.Game;
import karel.hudera.rnma.logic.game.IGame;
import karel.hudera.rnma.presentation.InputHandler;

public class Start {
    public static void main(String[] args) {
        IGame game = new Game();
        InputHandler ui = new InputHandler(game);
        ui.play();
    }
}