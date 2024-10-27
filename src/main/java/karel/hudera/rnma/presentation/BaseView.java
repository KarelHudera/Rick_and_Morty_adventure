package karel.hudera.rnma.presentation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import karel.hudera.rnma.MainApplication;
import karel.hudera.rnma.logic.mechanic.game.Game;
import karel.hudera.rnma.logic.mechanic.game.IGame;
import karel.hudera.rnma.presentation.controllers.base.BaseControllerAware;
import karel.hudera.rnma.presentation.controllers.base.BaseLayoutController;
import karel.hudera.rnma.presentation.navigation.Navigator;

import java.io.IOException;

import static karel.hudera.rnma.logic.strings.StringResources.GAME_NAME;

/**
 * BaseView class responsible for managing the primary user interface of the Rick and Morty Adventure game.
 * <p>
 * This class initializes the main game layout, loads various scenes and views, and handles navigation
 * between them using the {@link Navigator} class.
 * </p>
 * <p>
 * It sets up the user interface based on the FXML files and connects the controllers to the navigation system.
 * </p>
 *
 * <p>
 * Author: Karel Hudera
 * </p>
 */
public class BaseView {
    private static final double screenWidth = Screen.getPrimary().getBounds().getWidth(); // Width of the primary screen
    private static final double screenHeight = Screen.getPrimary().getBounds().getHeight(); // Height of the primary screen
    private static final String STYLESHEET_PATH = "/karel/hudera/rnma/styles/styles.css"; // Path to the CSS stylesheet

    private Navigator navigator; // Navigator to handle scene transitions
    private BorderPane viewHolder; // Main container for switching views
    private IGame game = new Game(); // Game instance that manages game logic

    /**
     * Entry point for launching the user interface of the game.
     * <p>
     * This method initializes the FXML loader, sets up the main layout, and configures the navigator.
     * </p>
     *
     * @param stage the primary stage for the JavaFX application
     * @throws IOException if there is an error loading the FXML files
     */
    public void launchUI(Stage stage) throws IOException {
        FXMLLoader baseLoader = new FXMLLoader(MainApplication.class.getResource("base-layout.fxml"));
        viewHolder = baseLoader.load(); // Load the FXML to initialize the view holder
        BaseLayoutController controller = baseLoader.getController(); // Get the controller associated with the layout

        // Initialize the Navigator with the loaded viewHolder and game instance
        navigator = new Navigator(viewHolder, game, stage);
        controller.setNavigator(navigator); // Set the navigator in the layout controller

        loadViews(); // Load all FXML views into the Navigator
        loadScenes(); // Load all scenes for the application

        navigator.changeScene("startScene"); // Change to the starting scene
        stage.setTitle(GAME_NAME); // Set the title of the application window
        stage.show(); // Display the application window
    }

    /**
     * Loads all scenes required for the application.
     * <p>
     * This method loads the start scene, the end scene, and the main scene using the viewHolder.
     * </p>
     *
     * @throws IOException if there is an error loading the scene FXML files
     */
    private void loadScenes() throws IOException {
        loadScene("view/start-view.fxml", "startScene"); // Load the Start Scene

        // Create the main scene using the viewHolder (not from FXML)
        Scene mainScene = new Scene(viewHolder);
        navigator.addScene("mainScene", mainScene); // Add the main scene to the navigator
        navigator.navigateTo("dining_room"); // Set the initial view to the dining room
        mainScene.getStylesheets().add(getClass().getResource(STYLESHEET_PATH).toExternalForm()); // Add the stylesheet to the main scene

        loadScene("view/end-view.fxml", "endScene"); // Load the End Scene
    }

    /**
     * Loads a specific scene from an FXML file and registers it with the Navigator.
     *
     * @param fxmlPath the path to the FXML file
     * @param sceneName the name to register the scene under
     * @throws IOException if there is an error loading the FXML file
     */
    private void loadScene(String fxmlPath, String sceneName) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource(fxmlPath));
        StackPane view = loader.load(); // Load the FXML into a StackPane

        // If the controller implements BaseControllerAware, set the navigator reference
        Object controller = loader.getController();
        if (controller instanceof BaseControllerAware) {
            ((BaseControllerAware) controller).setNavigator(navigator);
        }

        Scene scene = new Scene(view); // Create a Scene from the loaded view
        scene.getStylesheets().add(getClass().getResource(STYLESHEET_PATH).toExternalForm()); // Add the stylesheet to the scene
        navigator.addScene(sceneName, scene); // Register the scene with the Navigator
    }

    /**
     * Loads all individual views required for the game and registers them with the Navigator.
     * <p>
     * This method ensures that each view is associated with its corresponding controller.
     * </p>
     *
     * @throws IOException if there is an error loading any of the FXML files
     */
    private void loadViews() throws IOException {
        loadView("view/kitchen-view.fxml", "kitchen"); // Load the Kitchen view
        loadView("view/dining-room-view.fxml", "dining_room"); // Load the Dining Room view
        loadView("view/garage-view.fxml", "garage"); // Load the Garage view
        loadView("view/living-room-view.fxml", "living_room"); // Load the Living Room view
    }

    /**
     * Helper method to load an individual view from an FXML file and register it with the Navigator.
     *
     * @param fxmlFile the path to the FXML file for the view
     * @param screenName the name to register the view under
     * @throws IOException if there is an error loading the FXML file
     */
    private void loadView(String fxmlFile, String screenName) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource(fxmlFile));
        HBox view = loader.load(); // Load the FXML into an HBox

        // Configure the controller to have a reference to the Navigator
        Object controller = loader.getController();
        if (controller instanceof BaseControllerAware) {
            ((BaseControllerAware) controller).setNavigator(navigator);
        }

        // Register the view in the Navigator
        navigator.addScreen(screenName, view);
    }
}