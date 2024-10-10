package karel.hudera.rnma;

import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import karel.hudera.rnma.logic.mechanic.InputHandler;
import karel.hudera.rnma.logic.mechanic.game.Game;
import karel.hudera.rnma.presentation.controllers.StageController;
import karel.hudera.rnma.presentation.ui.MainUI;

import java.io.IOException;

/**
 * The main class of the Rick and Morty Adventure game, responsible for initializing and launching the game in different modes.
 * <p>
 * The class extends {@link Application} to run the JavaFX version of the game. It supports multiple modes such as:
 * - Text-based mode.
 * - Bot mode (to be implemented).
 * - JavaFX GUI mode.
 * </p>
 *
 * <p>
 * The {@link StageController} manages scene transitions, and the views are loaded dynamically using FXML files.
 * </p>
 *
 * @author KarelHudera
 */
public class MainApplication extends Application {

    private static final double screenWidth = Screen.getPrimary().getBounds().getWidth();
    private static final double screenHeight = Screen.getPrimary().getBounds().getHeight();
    /**
     * The main method of the application.
     * Based on the command-line arguments, it launches the appropriate mode of the game.
     *
     * @param args Command-line arguments that determine the mode to launch the game (e.g., "text" or "bot").
     */
    public static void main(String[] args) {
        handleArgs(args);
    }

    /**
     * Processes command-line arguments and determines which mode to launch.
     * <ul>
     *     <li>"text" - Launches the text-based version of the game.</li>
     *     <li>"bot" - (Placeholder) Launches bot mode, e.g., connecting to a Telegram bot.</li>
     *     <li>Default - Launches the JavaFX GUI version of the game.</li>
     * </ul>
     *
     * @param args The command-line arguments.
     */
    private static void handleArgs(String[] args) {
        if (args.length > 0) {
            switch (args[0].toLowerCase()) {
                case "text":
                    startTextMode();
                    break;
                case "bot":
                    startBotMode();
                    break;
                default:
                    launchJavaFXApp();
                    break;
            }
        } else {
            launchJavaFXApp();
        }
    }

    /**
     * Launches the JavaFX GUI version of the game by invoking the {@link #launch()} method.
     */
    private static void launchJavaFXApp() {
        Application.launch();
    }

    /**
     * Starts the text-based version of the game.
     * This method initializes the {@link Game} instance and uses the {@link InputHandler} to handle user inputs and run the game loop.
     */
    private static void startTextMode() {
        Game game = new Game();
        InputHandler ui = new InputHandler(game);
        ui.play();
    }

    /**
     * Placeholder method for starting bot mode.
     * This could involve connecting the game to an external bot interface such as a Telegram bot.
     */
    private static void startBotMode() {
        // TODO: Create Telegram bot connection logic
        // botStart();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        MainUI mainUI = new MainUI();
        mainUI.launchUI(primaryStage, screenWidth, screenHeight);
    }
}