package karel.hudera.rnma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import karel.hudera.rnma.presentation.controllers.*;

import java.io.IOException;

public class MainApplication extends Application {

    private StageController stageController;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        stageController = new StageController(stage);

        // Load and initialize all the views
        initializeView("start-view.fxml", "start");
        initializeView("kitchen-view.fxml", "kitchen");
        initializeView("dining-room-view.fxml", "dining");
        initializeView("garage-view.fxml", "garage");
        initializeView("living-room-view.fxml", "living");

        stageController.activate("start");

        // Show the initial scene
        stage.setTitle("Rick and Morty adventure");
        stage.setFullScreen(true);
        stage.show();
    }

    private void initializeView(String fxmlFile, String screenName) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource(fxmlFile));
        Parent view = loader.load();

        // Retrieve the controller and set the StageController if applicable
        Object controller = loader.getController();
        if (controller instanceof StageControllerAware) {
            ((StageControllerAware) controller).setScreenController(stageController);
        }

        // Create the scene and register it with the StageController
        Scene scene = new Scene(view);
        stageController.addScreen(screenName, scene);
    }

}
