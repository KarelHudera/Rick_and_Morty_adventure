package karel.hudera.rnma.presentation.controllers;

import javafx.fxml.FXML;

public class GarageViewController implements StageControllerAware {
    private StageController stageController;

    @Override
    public void setScreenController(StageController stageController) {
        this.stageController = stageController;
    }

    double screenHeight;
    double screenWidth;
    @Override
    public void setScreenDimensions(double width, double height) {
        this.screenWidth = width;
        this.screenHeight = height;
    }

    @FXML
    protected void onBackButtonClick() {
        System.out.println("Back button clicked"); // Debugging line
        stageController.activate("start"); // Go back to the first page
    }
}