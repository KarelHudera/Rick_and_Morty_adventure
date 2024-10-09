package karel.hudera.rnma.presentation.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public class StageController {
    private Stage stage;
    private HashMap<String, Scene> screens = new HashMap<>();

    public StageController(Stage stage) {
        this.stage = stage;
    }

    public void addScreen(String name, Scene scene) {
        screens.put(name, scene);
    }

    public void activate(String name) {
        stage.setScene(screens.get(name));
    }
}