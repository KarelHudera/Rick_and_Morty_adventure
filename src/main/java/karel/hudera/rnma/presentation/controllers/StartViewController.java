package karel.hudera.rnma.presentation.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class StartViewController implements StageControllerAware {

    private StageController stageController;
    double width;
    double height;

    // Get the physical screen dimensions

    // Reference to the VBox defined in the FXML
    @FXML
    private VBox rootVBox;

    @Override
    public void setScreenController(StageController stageController) {
        this.stageController = stageController;
    }

    @Override
    public void setScreenDimensions(double width, double height) {
        this.width = width;
        this.height = height;
        initialize();
    }


    private void initialize() {
        // Set VBox size based on the physical screen dimensions
        rootVBox.setPrefWidth(width);
        rootVBox.setPrefHeight(height);
        System.out.println("Updated Screen Width: " + width);
        System.out.println("Updated Screen Height: " + height);
    }

    @FXML
    protected void onHelloButtonClick() {
        // Switch to the dining_room screen when the button is clicked
        stageController.activate("dining_room");
    }
}