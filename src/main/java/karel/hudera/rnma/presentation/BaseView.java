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
import karel.hudera.rnma.presentation.controllers.EndViewController;
import karel.hudera.rnma.presentation.controllers.StartViewController;
import karel.hudera.rnma.presentation.controllers.base.BaseControllerAware;
import karel.hudera.rnma.presentation.controllers.base.BaseLayoutController;
import karel.hudera.rnma.presentation.navigation.Navigator;

import java.io.IOException;

import static karel.hudera.rnma.logic.strings.StringResources.GAME_NAME;

public class BaseView {
    private static final double screenWidth = Screen.getPrimary().getBounds().getWidth();
    private static final double screenHeight = Screen.getPrimary().getBounds().getHeight();

    private Navigator navigator;
    private BorderPane viewHolder; // This is where the views will switch
    private IGame game = new Game();
    private StackPane start;

    // Entry point to launch UI
    public void launchUI(Stage stage) throws IOException {
        // Initialize the FXML loader and load the base layout first
        FXMLLoader baseLoader = new FXMLLoader(MainApplication.class.getResource("base-layout.fxml"));
        viewHolder = baseLoader.load(); // Load the FXML to initialize viewHolder
        BaseLayoutController controller = baseLoader.getController(); // Get the controller after loading the FXML

        // Initialize the Navigator with the loaded viewHolder
        navigator = new Navigator(viewHolder, game, stage); // Initialize the Navigator after viewHolder is loaded
        controller.setNavigator(navigator); // Now set the navigator in the controller

        loadViews(); // Load all FXML views into Navigator
        loadScenes();

        navigator.changeScene("startScene");
        stage.setTitle(GAME_NAME);
        stage.show();
    }

    private void loadScenes() throws IOException {
        // Load the Start Scene
        loadScene("view/start-view.fxml", "startScene");

        // Create the main scene using the viewHolder (special case since it's not from FXML)
        Scene mainScene = new Scene(viewHolder); // Create a scene for the main viewHolder
        navigator.addScene("mainScene", mainScene); // Add the main scene to the navigator
        navigator.navigateTo("dining_room"); // Set the initial view to 'dining_room'

        // Load the End Scene
        loadScene("view/end-view.fxml", "endScene");
    }

    private void loadScene(String fxmlPath, String sceneName) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource(fxmlPath));
        StackPane view = loader.load();

        // If the controller implements BaseControllerAware, set the navigator
        Object controller = loader.getController();
        if (controller instanceof BaseControllerAware) {
            ((BaseControllerAware) controller).setNavigator(navigator);
        }

        Scene scene = new Scene(view);
        navigator.addScene(sceneName, scene); // Register the scene in the navigator
    }

    // Load all views into Navigator
    private void loadViews() throws IOException {
        loadView("view/kitchen-view.fxml", "kitchen");
        loadView("view/dining-room-view.fxml", "dining_room");
        loadView("view/garage-view.fxml", "garage");
        loadView("view/living-room-view.fxml", "living_room");
    }

    // Helper to load individual views
    private void loadView(String fxmlFile, String screenName) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource(fxmlFile));
        HBox view = loader.load();

        // Configure the controller to have the Navigator reference
        Object controller = loader.getController();
        if (controller instanceof BaseControllerAware) {
            ((BaseControllerAware) controller).setNavigator(navigator);
        }

        // Register view in Navigator
        navigator.addScreen(screenName, view);
    }
}