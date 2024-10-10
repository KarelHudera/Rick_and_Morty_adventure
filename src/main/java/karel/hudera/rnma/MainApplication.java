package karel.hudera.rnma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import karel.hudera.rnma.logic.mechanic.InputHandler;
import karel.hudera.rnma.logic.mechanic.game.Game;
import karel.hudera.rnma.presentation.controllers.StageController;
import karel.hudera.rnma.presentation.controllers.StageControllerAware;

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

    // Controller for managing different scenes in the JavaFX stage.
    private StageController stageController;
    double screenWidth = Screen.getPrimary().getBounds().getWidth();
    double screenHeight = Screen.getPrimary().getBounds().getHeight();

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
        launch();
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

    /**
     * The entry point for JavaFX applications. This method is called after {@link #launch()} is invoked.
     * It sets up the JavaFX stage and initializes the views.
     *
     * @param stage The primary stage for the JavaFX application.
     * @throws IOException If loading the FXML files fails.
     */
    @Override
    public void start(Stage stage) throws IOException {


        stageController = new StageController(stage);

        // Load all views and set the initial view to the "start" scene.
        loadViews(screenWidth, screenHeight);
        stageController.activate("start");

        // Configure the primary stage properties such as title and fullscreen.
        setupPrimaryStage(stage);
    }

    /**
     * Loads all the FXML views required by the application and registers them with the {@link StageController}.
     *
     * @throws IOException If any of the FXML files fail to load.
     */
    private void loadViews(double width, double height) throws IOException {
        loadView("start-view.fxml", "start");
        loadView("kitchen-view.fxml", "kitchen");
        loadView("dining-room-view.fxml", "dining_room");
        loadView("garage-view.fxml", "garage");
        loadView("living-room-view.fxml", "living_room");
    }

    /**
     * Loads an individual FXML view, registers it with the {@link StageController}, and configures the controller if necessary.
     *
     * @param fxmlFile   The path to the FXML file for the view.
     * @param screenName The name by which this view is identified in the {@link StageController}.
     * @throws IOException If the FXML file fails to load.
     */
    private void loadView(String fxmlFile, String screenName) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource(fxmlFile));
        Parent view = loader.load();

        // Set the StageController on the controller if it implements StageControllerAware.
        configureController(loader);

        // Register the view with the StageController.
        registerView(screenName, view);
    }

    /**
     * Configures the controller by passing the {@link StageController} if the controller implements {@link StageControllerAware}.
     *
     * @param loader The {@link FXMLLoader} that has loaded the FXML file.
     */
    private void configureController(FXMLLoader loader) {
        Object controller = loader.getController();
        if (controller instanceof StageControllerAware) {
            ((StageControllerAware) controller).setScreenController(stageController);
            ((StageControllerAware) controller).setScreenDimensions(screenWidth, screenHeight);
            System.out.println("Screen Width1: " + screenWidth);
            System.out.println("Screen Height1: " + screenHeight);
        }
    }

    /**
     * Registers the loaded view (scene) with the {@link StageController}.
     *
     * @param screenName The name used to identify the screen.
     * @param view       The root node of the view.
     */
    private void registerView(String screenName, Parent view) {
        Scene scene = new Scene(view);
        stageController.addScreen(screenName, scene);
    }

    /**
     * Configures the primary stage properties such as the title and fullscreen mode.
     *
     * @param stage The main stage of the JavaFX application.
     */
    private void setupPrimaryStage(Stage stage) {
        stage.setTitle("Rick and Morty Adventure");
        stage.setFullScreen(true);
        stage.show();
    }
}