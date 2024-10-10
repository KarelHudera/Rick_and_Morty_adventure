package karel.hudera.rnma.presentation.controllers;

public interface StageControllerAware {
    void setScreenController(StageController stageController);
    void setScreenDimensions(double width, double height);
}