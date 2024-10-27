package karel.hudera.rnma.presentation.controllers;

import javafx.fxml.FXML;
import karel.hudera.rnma.logic.strings.StringResources;
import karel.hudera.rnma.presentation.controllers.base.BaseControllerAware;
import karel.hudera.rnma.presentation.navigation.Navigator;

/**
 * Controller for the Garage view.
 * Handles user interactions for navigating to other rooms.
 */
public class GarageViewController implements BaseControllerAware {
    private Navigator navigator; // Reference to the Navigator for scene transitions

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator; // Set the navigator instance for this controller
    }

    /**
     * Handles the event when the Kitchen button is clicked.
     * Navigates to the Kitchen and updates the game state.
     */
    @FXML
    protected void onKitchenButtonClick() {
        navigator.navigateTo("kitchen"); // Navigate to the kitchen
    }
}