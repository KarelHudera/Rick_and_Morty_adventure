package karel.hudera.rnma.presentation.controllers;

import javafx.fxml.FXML;
import karel.hudera.rnma.presentation.controllers.base.BaseControllerAware;
import karel.hudera.rnma.presentation.navigation.Navigator;

public class KitchenViewController implements BaseControllerAware {
    private Navigator navigator;

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    @FXML
    protected void onDiningRoomButtonClick() {
        navigator.navigateTo("dining_room");
        navigator.getGame().handleInput("goto dining_room");
        String currentRoom = navigator.getGame().getGamePlan().getCurrentRoom().getName();
        System.out.println(currentRoom);
    }

    @FXML
    protected void onGarageButtonClick() {
        navigator.navigateTo("garage");
        navigator.getGame().handleInput("goto garage");
        String currentRoom = navigator.getGame().getGamePlan().getCurrentRoom().getName();
        System.out.println(currentRoom);
    }

    @FXML
    protected void onLivingRoomButtonClick() {
        navigator.navigateTo("living_room");
        navigator.getGame().handleInput("goto living_room");
        String currentRoom = navigator.getGame().getGamePlan().getCurrentRoom().getName();
        System.out.println(currentRoom);
    }
}