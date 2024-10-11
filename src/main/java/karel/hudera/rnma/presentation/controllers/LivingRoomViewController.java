package karel.hudera.rnma.presentation.controllers;

import javafx.fxml.FXML;
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
        System.out.println("Navigating to Dining Room"); // Debugging line
        navigator.navigateTo("dining_room"); // Navigate to the Dining Room view
    }

    @FXML
    protected void onKitchenButtonClick() {
        System.out.println("Navigating to Kitchen"); // Debugging line
        navigator.navigateTo("kitchen"); // Navigate to the Kitchen view
    }
}