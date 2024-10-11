package karel.hudera.rnma.presentation.navigation;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class Navigator {
    private HashMap<String, Pane> views = new HashMap<>();
    private BorderPane viewHolder; // Reference to the BorderPane that will hold the views

    public Navigator(BorderPane viewHolder) {
        this.viewHolder = viewHolder;
    }

    // Add a screen to the controller
    public void addScreen(String name, Pane screen) {
        views.put(name, screen);
    }

    // Activate a screen by name and set it in the viewHolder
    public void navigateTo(String name) {
        Pane view = views.get(name); // Get the corresponding screen
        if (view != null) {
            viewHolder.setCenter(view); // Set the screen in the center of the viewHolder
        } else {
            System.out.println("Screen not found: " + name);
        }
    }
}