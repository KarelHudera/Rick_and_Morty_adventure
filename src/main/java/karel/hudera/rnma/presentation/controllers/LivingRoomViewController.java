package karel.hudera.rnma.presentation.controllers;

import javafx.fxml.FXML;
import karel.hudera.rnma.logic.strings.StringResources;
import karel.hudera.rnma.presentation.controllers.base.BaseControllerAware;
import karel.hudera.rnma.presentation.navigation.Navigator;

public class LivingRoomViewController implements BaseControllerAware {
    private Navigator navigator;

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    @FXML
    protected void onDiningRoomButtonClick() {
        navigator.navigateTo("dining_room");
        navigator.getGame().handleInput(StringResources.Commands.GOTO + " dining_room");
        String currentRoom = navigator.getGame().getGamePlan().getCurrentRoom().getName();
        System.out.println(currentRoom);
    }

    @FXML
    protected void onKitchenButtonClick() {
        navigator.navigateTo("kitchen");
        navigator.getGame().handleInput(StringResources.Commands.GOTO + " kitchen");
        String currentRoom = navigator.getGame().getGamePlan().getCurrentRoom().getName();
        System.out.println(currentRoom);
    }
}