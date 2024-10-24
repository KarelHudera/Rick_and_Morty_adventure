package karel.hudera.rnma.presentation.navigation;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import karel.hudera.rnma.logic.mechanic.game.IGame;

import java.util.HashMap;

public class Navigator {
    private HashMap<String, Pane> views = new HashMap<>();
    private BorderPane viewHolder; // Reference to the BorderPane that will hold the views
    private IGame game; // Add the game instance
    private HashMap<String, Scene> scenes = new HashMap<>();
    private Stage stage;

    public Navigator(BorderPane viewHolder, IGame game, Stage stage) {
        this.viewHolder = viewHolder;
        this.game = game;
        this.stage = stage;

    }

    // Add a screen to the controller
    public void addScreen(String name, HBox screen) {
        views.put(name, screen);
    }

    // Navigate to a screen by name and set it in the viewHolder
    public void navigateTo(String name) {
        Pane view = views.get(name); // Get the corresponding screen
        viewHolder.setBottom(view); // Set the screen in the bottom of the viewHolder (or wherever you prefer)
    }

    // Add a scene to the stage
    public void addScene(String name, Scene scene) {
        scenes.put(name, scene);
    }

    // Change the scene on the stage by its name
    public void changeScene(String name) {
        Scene scene = scenes.get(name); // Get the scene by name

        if (scene != null) {
            stage.hide(); // Hide the stage before setting a new scene
            stage.setScene(scene); // Set the scene on the stage
            stage.setMaximized(true); // Ensure maximized state
            stage.show(); // Show the stage again after setting the scene
        }

    }

    public IGame getGame() {
        return game;
    }
}