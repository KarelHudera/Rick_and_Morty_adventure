package karel.hudera.rnma.presentation.navigation;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import karel.hudera.rnma.logic.mechanic.game.IGame;
import karel.hudera.rnma.logic.strings.StringResources;

import java.util.HashMap;

/**
 * The Navigator class is responsible for managing the navigation between different views and scenes within the application.
 * It facilitates switching between different parts of the user interface while maintaining a reference to the game state.
 */
public class Navigator {
    private HashMap<String, Pane> views = new HashMap<>(); // Map to store registered views by name
    private BorderPane viewHolder; // Reference to the BorderPane that will hold the views
    private IGame game; // Reference to the game instance for interaction with game logic
    private HashMap<String, Scene> scenes = new HashMap<>(); // Map to store scenes by name
    private Stage stage; // The primary stage for the application

    /**
     * Constructs a Navigator instance with the specified view holder, game instance, and primary stage.
     *
     * @param viewHolder the BorderPane that will hold the views
     * @param game the instance of the game being played
     * @param stage the primary stage of the application
     */
    public Navigator(BorderPane viewHolder, IGame game, Stage stage) {
        this.viewHolder = viewHolder;
        this.game = game;
        this.stage = stage;
    }

    /**
     * Registers a new screen in the navigator.
     *
     * @param name the name identifier for the screen
     * @param screen the HBox representing the screen
     */
    public void addScreen(String name, HBox screen) {
        views.put(name, screen); // Store the screen in the views map
    }

    /**
     * Navigates to a specified screen by name and handles game input for room navigation.
     *
     * @param name the name identifier of the screen or room to navigate to
     */
    public void navigateTo(String name) {
        // First, retrieve the corresponding screen
        Pane view = views.get(name);

        if (view != null) {
            viewHolder.setBottom(view); // Set the screen in the view holder
        } else {
            // Handle case where the view is not found
            System.err.println("View not found: " + name);
        }

        // Handle game input for room navigation if a valid room name is provided
        if (game.getGamePlan().getRoomByName(name) != null) {
            game.handleInput(StringResources.Commands.GOTO + " " + name); // Handle game input for navigation
            String currentRoom = game.getGamePlan().getCurrentRoom().getName(); // Get the current room's name
            System.out.println(currentRoom); // Print the current room's name for debugging
        }
    }

    /**
     * Registers a new scene in the navigator.
     *
     * @param name the name identifier for the scene
     * @param scene the Scene to be added
     */
    public void addScene(String name, Scene scene) {
        scenes.put(name, scene); // Store the scene in the scenes map
    }

    /**
     * Changes the current scene on the stage to the specified scene by name.
     *
     * @param name the name identifier of the scene to change to
     */
    public void changeScene(String name) {
        Scene scene = scenes.get(name); // Retrieve the scene by name

        if (scene != null) {
            stage.hide(); // Hide the stage before setting a new scene
            stage.setScene(scene); // Set the new scene on the stage
            stage.setMaximized(true); // Ensure the stage is maximized
            stage.show(); // Show the stage again after setting the new scene
        } else {
            // Handle case where the scene is not found
            System.err.println("Scene not found: " + name);
        }
    }

    /**
     * Gets the current game instance associated with this navigator.
     *
     * @return the IGame instance representing the game logic
     */
    public IGame getGame() {
        return game; // Return the game instance
    }
}