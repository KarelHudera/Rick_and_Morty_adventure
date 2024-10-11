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
        System.out.println("Navigating to Dining Room"); // Debugging line
        navigator.navigateTo("dining_room"); // Navigate to the Dining Room view
    }

    @FXML
    protected void onGarageButtonClick() {
        System.out.println("Navigating to Garage"); // Debugging line
        navigator.navigateTo("garage"); // Navigate to the Garage view
    }

    @FXML
    protected void onLivingRoomButtonClick() {
        System.out.println("Navigating to Living Room"); // Debugging line
        navigator.navigateTo("living_room"); // Navigate to the Living Room view
    }
}