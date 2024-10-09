package karel.hudera.rnma.presentation.controllers;

import javafx.fxml.FXML;

public class KitchenViewController implements StageControllerAware {
    private StageController stageController;

    @Override
    public void setScreenController(StageController stageController) {
        this.stageController = stageController;
    }

    @FXML
    protected void onBackButtonClick() {
        System.out.println("Back button clicked"); // Debugging line
        stageController.activate("start"); // Go back to the first page
    }
}