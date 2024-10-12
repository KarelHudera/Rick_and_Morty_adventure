package karel.hudera.rnma.presentation.controllers;

import javafx.fxml.FXML;
import karel.hudera.rnma.presentation.controllers.base.BaseControllerAware;
import karel.hudera.rnma.presentation.navigation.Navigator;

public class GarageViewController implements BaseControllerAware {
    private Navigator navigator;

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    @FXML
    protected void onKitchenButtonClick() {
        navigator.navigateTo("kitchen"); // Navigate to the Kitchen view
        navigator.getGame().handleInput("goto kitchen");
        String currentRoom = navigator.getGame().getGamePlan().getCurrentRoom().getName();
        System.out.println(currentRoom);
    }
}