package karel.hudera.rnma.presentation.controllers;

import javafx.fxml.FXML;

public class DiningRoomViewController implements StageControllerAware {
    private StageController stageController;

    @Override
    public void setScreenController(StageController stageController) {
        this.stageController = stageController;
    }

    @FXML
    protected void onBackButtonClick() {
        stageController.activate("start"); // Go back to the first page
    }
}