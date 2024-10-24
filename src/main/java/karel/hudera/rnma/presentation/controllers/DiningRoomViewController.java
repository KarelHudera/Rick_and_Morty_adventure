package karel.hudera.rnma.presentation.controllers;

import javafx.fxml.FXML;
import karel.hudera.rnma.logic.strings.StringResources;
import karel.hudera.rnma.presentation.controllers.base.BaseControllerAware;
import karel.hudera.rnma.presentation.navigation.Navigator;

public class DiningRoomViewController implements BaseControllerAware {
    private Navigator navigator;

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    @FXML
    private void initialize() {

    }

    @FXML
    protected void onKitchenButtonClick() {
        // Navigate to the kitchen view
        navigator.navigateTo("kitchen");
        navigator.getGame().handleInput(StringResources.Commands.GOTO + " kitchen");
        String currentRoom = navigator.getGame().getGamePlan().getCurrentRoom().getName();
        System.out.println(currentRoom);
    }

    @FXML
    protected void onLivingRoomButtonClick() {
        // Navigate to the living room view
        navigator.navigateTo("living_room");
        navigator.getGame().handleInput(StringResources.Commands.GOTO + " living_room");
        String currentRoom = navigator.getGame().getGamePlan().getCurrentRoom().getName();
        System.out.println(currentRoom);
    }
}