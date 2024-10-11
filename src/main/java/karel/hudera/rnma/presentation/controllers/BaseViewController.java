package karel.hudera.rnma.presentation.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import karel.hudera.rnma.MainApplication;
import karel.hudera.rnma.presentation.navigation.Navigator;

import java.io.IOException;

public class BaseViewController {
    private static final double screenWidth = Screen.getPrimary().getBounds().getWidth();
    private static final double screenHeight = Screen.getPrimary().getBounds().getHeight();
    private Navigator navigator;
    private BorderPane viewHolder; // This is where the views will switch

    // Entry point to launch UI
    public void launchUI(Stage stage) throws IOException {
        viewHolder = new BorderPane(); // Initialize viewHolder (BorderPane)

        navigator = new Navigator(viewHolder); // Initialize the Navigator with viewHolder
        viewHolder.setTop(new VBox(new Button("Top")));
        loadViews(); // Load all FXML views into Navigator

        navigator.navigateTo("start"); // Set the initial view to 'start'

        Scene scene = new Scene(viewHolder); // Create a scene with the persistent viewHolder
        stage.setTitle("Rick and Morty Adventure");
        stage.setScene(scene); // Set scene on the stage once
        stage.show();
    }

    // Load all views into Navigator
    private void loadViews() throws IOException {
        loadView("start-view.fxml", "start");
        loadView("kitchen-view.fxml", "kitchen");
        loadView("dining-room-view.fxml", "dining_room");
        loadView("garage-view.fxml", "garage");
        loadView("living-room-view.fxml", "living_room");
    }

    // Helper to load individual views
    private void loadView(String fxmlFile, String screenName) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource(fxmlFile));
        Pane view = loader.load();

        // Configure the controller to have the Navigator reference
        Object controller = loader.getController();
        if (controller instanceof BaseControllerAware) {
            ((BaseControllerAware) controller).setNavigator(navigator);
        }

        // Register view in Navigator
        navigator.addScreen(screenName, view);
    }
}