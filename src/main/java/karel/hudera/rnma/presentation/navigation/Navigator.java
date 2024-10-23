package karel.hudera.rnma.presentation.navigation;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import karel.hudera.rnma.logic.mechanic.game.IGame;

import java.util.HashMap;

public class Navigator {
    private HashMap<String, Pane> views = new HashMap<>();
    private BorderPane viewHolder; // Reference to the BorderPane that will hold the views
    private IGame game; // Add the game instance

    public Navigator(BorderPane viewHolder, IGame game) {
        this.viewHolder = viewHolder;
        this.game = game;
    }

    // Add a screen to the controller
    public void addScreen(String name, HBox screen) {
        views.put(name, screen);
    }

    // Activate a screen by name and set it in the viewHolder
    public void navigateTo(String name) {
        Pane view = views.get(name); // Get the corresponding screen

        if (view != null) {
            viewHolder.setBottom(view); // Set the screen in the center of the viewHolder
        } else {
            System.out.println("Screen not found: " + name);
        }
    }

    public IGame getGame() {
        return game;
    }
}