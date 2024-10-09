package karel.hudera.rnma.presentation.controllers;

import javafx.fxml.FXML;

public class StartViewController implements StageControllerAware {

    private StageController stageController;

    @Override
    public void setScreenController(StageController stageController) {
        this.stageController = stageController;
    }

    @FXML
    protected void onHelloButtonClick() {
        stageController.activate("kitchen"); // Switch to the second page
    }
}