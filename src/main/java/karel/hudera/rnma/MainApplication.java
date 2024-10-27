package karel.hudera.rnma;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import karel.hudera.rnma.logic.mechanic.InputHandler;
import karel.hudera.rnma.logic.mechanic.game.Game;
import karel.hudera.rnma.presentation.BaseView;

/**
 * Main class for the Rick and Morty Adventure game.
 * <p>
 * This application serves as the entry point for launching the game in different modes, including:
 * - Text-based mode
 * - Bot mode (to be implemented)
 * - JavaFX GUI mode
 * </p>
 * <p>
 * The application extends {@link Application} to facilitate the JavaFX framework functionalities.
 * It utilizes the {@link BaseView} for UI management and the {@link Game} class for game logic.
 * </p>
 *
 * <p>
 * Author: Karel Hudera
 * </p>
 */
public class MainApplication extends Application {

    private static Stage primaryStage; // The primary stage for the JavaFX application

    /**
     * The main method for launching the application.
     * <p>
     * This method processes command-line arguments to determine the mode in which to launch the game.
     * </p>
     *
     * @param args Command-line arguments that may specify the mode (e.g., "text" for text mode).
     */
    public static void main(String[] args) {
        handleArgs(args); // Process command-line arguments
    }

    /**
     * Processes command-line arguments to determine which mode of the game to launch.
     * <ul>
     *     <li>"text" - Launches the text-based version of the game.</li>
     *     <li>"bot" - Placeholder for launching bot mode.</li>
     *     <li>Default - Launches the JavaFX GUI version of the game.</li>
     * </ul>
     *
     * @param args The command-line arguments.
     */
    private static void handleArgs(String[] args) {
        if (args.length > 0) {
            switch (args[0].toLowerCase()) {
                case "text":
                    startTextMode(); // Launch text mode if specified
                    break;
                case "bot":
                    startBotMode(); // Launch bot mode if specified (not yet implemented)
                    break;
                default:
                    launchJavaFXApp(); // Launch the GUI version by default
                    break;
            }
        } else {
            launchJavaFXApp(); // Launch the GUI version if no arguments are provided
        }
    }

    /**
     * Launches the JavaFX GUI version of the game.
     * <p>
     * This method invokes the JavaFX application lifecycle by calling the {@link #launch()} method.
     * </p>
     */
    private static void launchJavaFXApp() {
        Application.launch(); // Starts the JavaFX application
    }

    /**
     * Starts the text-based version of the game.
     * <p>
     * This method initializes the game logic and uses the {@link InputHandler} to manage user inputs.
     * </p>
     */
    private static void startTextMode() {
        Game game = new Game(); // Initialize the game logic
        InputHandler ui = new InputHandler(game); // Create an input handler for managing game inputs
        ui.play(); // Start the game loop
    }

    /**
     * Placeholder method for starting bot mode.
     * <p>
     * This method is intended to set up the connection for the bot mode, such as connecting to a Telegram bot.
     * </p>
     */
    private static void startBotMode() {
        // TODO: Implement bot connection logic (e.g., Telegram bot)
    }

    /**
     * The entry point for the JavaFX application.
     * <p>
     * This method sets up the primary stage for the JavaFX application.
     * </p>
     *
     * @param primaryStage the primary stage for the JavaFX application
     * @throws Exception if an error occurs during application startup
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        MainApplication.primaryStage = primaryStage; // Store reference to the primary stage
        launchUI(primaryStage); // Initialize the user interface
    }

    /**
     * Initializes and launches the user interface of the application.
     * <p>
     * This method sets up the base view and configures the main application stage.
     * </p>
     *
     * @param stage the main stage for the application
     * @throws Exception if an error occurs while loading the UI
     */
    private void launchUI(Stage stage) throws Exception {
        BaseView baseView = new BaseView(); // Create an instance of the base view
        baseView.launchUI(stage); // Launch the UI for the stage
        stage.setMaximized(true); // Maximize the application window
    }

    /**
     * Restarts the entire application.
     * <p>
     * This method closes the current primary stage and reopens it,
     * reinitializing both game logic and UI.
     * </p>
     */
    public static void restart() {
        Platform.runLater(() -> {
            try {
                primaryStage.close(); // Close the existing primary stage
                primaryStage = new Stage(); // Create a new Stage instance
                MainApplication app = new MainApplication(); // Create a new instance of the application
                app.start(primaryStage); // Restart the application with the new stage
            } catch (Exception e) {
                e.printStackTrace(); // Log any exceptions that occur during restart
            }
        });
    }
}