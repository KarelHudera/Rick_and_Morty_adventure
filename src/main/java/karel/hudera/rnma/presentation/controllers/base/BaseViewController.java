package karel.hudera.rnma.presentation.controllers.base;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import karel.hudera.rnma.MainApplication;
import karel.hudera.rnma.logic.characters.GameCharacter;
import karel.hudera.rnma.logic.mechanic.game.Game;
import karel.hudera.rnma.logic.mechanic.game.IGame;
import karel.hudera.rnma.presentation.navigation.Navigator;

import java.io.IOException;

public class BaseViewController {
    private static final double screenWidth = Screen.getPrimary().getBounds().getWidth();
    private static final double screenHeight = Screen.getPrimary().getBounds().getHeight();

    private Navigator navigator;
    private BorderPane viewHolder; // This is where the views will switch
    private IGame game = new Game();

    // Entry point to launch UI
    public void launchUI(Stage stage) throws IOException {
        // Initialize the FXML loader and load the base layout first
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("base-layout.fxml"));
        viewHolder = loader.load(); // Load the FXML to initialize viewHolder
        BaseLayoutController controller = loader.getController(); // Get the controller after loading the FXML

        // Initialize the Navigator with the loaded viewHolder
        navigator = new Navigator(viewHolder, game); // Initialize the Navigator after viewHolder is loaded
        controller.setNavigator(navigator); // Now set the navigator in the controller

        loadViews(); // Load all FXML views into Navigator

        navigator.navigateTo("dining_room"); // Set the initial view to 'dining_room'

        Scene scene = new Scene(viewHolder); // Create a scene with the persistent viewHolder
        stage.setTitle("Rick and Morty Adventure");
        stage.setScene(scene); // Set scene on the stage once
        stage.show();
    }

    // Load all views into Navigator
    private void loadViews() throws IOException {
        loadView("view/start-view.fxml", "start");
        loadView("view/kitchen-view.fxml", "kitchen");
        loadView("view/dining-room-view.fxml", "dining_room");
        loadView("view/garage-view.fxml", "garage");
        loadView("view/living-room-view.fxml", "living_room");
       // loadView("base-layout.fxml", "game");
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