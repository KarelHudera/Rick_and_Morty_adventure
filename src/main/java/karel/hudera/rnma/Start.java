package karel.hudera.rnma;

import karel.hudera.rnma.logic.game.Game;
import karel.hudera.rnma.presentation.InputHandler;

/**
 * The entry point of the game.
 * This class initializes the game logic and the user interface,
 * and then starts the game loop.
 *
 * <p>
 * The {@link Game} class handles the game logic, while the {@link InputHandler} class
 * manages user inputs and game interactions.
 * </p>
 *
 * @author KarelHudera
 */
public class Start {

    /**
     * The main method that serves as the entry point of the application.
     * It initializes the game and starts the user interface for playing the game.
     *
     * @param args Command line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        // Create an instance of the game logic.
        Game game = new Game();

        // Create an instance of the input handler with the game instance.
        InputHandler ui = new InputHandler(game);

        // Start the game loop by calling the play method on the input handler.
        ui.play();
    }
}