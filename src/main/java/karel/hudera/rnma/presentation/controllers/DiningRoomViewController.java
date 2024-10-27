package karel.hudera.rnma.presentation.controllers;

import javafx.fxml.FXML;
import karel.hudera.rnma.logic.strings.StringResources;
import karel.hudera.rnma.presentation.controllers.base.BaseControllerAware;
import karel.hudera.rnma.presentation.navigation.Navigator;

/**
 * Controller for the Dining Room view.
 * Manages navigation to other rooms in the game.
 */
public class DiningRoomViewController implements BaseControllerAware {
    private Navigator navigator; // Reference to the Navigator for navigation

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator; // Set the navigator instance
    }

    @FXML
    protected void onKitchenButtonClick() {
        navigator.navigateTo("kitchen"); // Navigate to the kitchen view
    }

    @FXML
    protected void onLivingRoomButtonClick() {
        navigator.navigateTo("living_room"); // Navigate to the living room view
    }
}