package karel.hudera.rnma.presentation.controllers;

import javafx.fxml.FXML;
import karel.hudera.rnma.logic.strings.StringResources;
import karel.hudera.rnma.presentation.controllers.base.BaseControllerAware;
import karel.hudera.rnma.presentation.navigation.Navigator;

/**
 * Controller for the Kitchen view.
 * Handles user interactions for navigating to other rooms.
 */
public class KitchenViewController implements BaseControllerAware {
    private Navigator navigator; // Reference to the Navigator for scene transitions

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator; // Set the navigator instance for this controller
    }

    /**
     * Handles the event when the Dining Room button is clicked.
     * Navigates to the Dining Room and updates the game state.
     */
    @FXML
    protected void onDiningRoomButtonClick() {
        navigator.navigateTo("dining_room"); // Navigate to the dining room
    }

    /**
     * Handles the event when the Garage button is clicked.
     * Navigates to the Garage and updates the game state.
     */
    @FXML
    protected void onGarageButtonClick() {
        navigator.navigateTo("garage"); // Navigate to the garage
    }

    /**
     * Handles the event when the Living Room button is clicked.
     * Navigates to the Living Room and updates the game state.
     */
    @FXML
    protected void onLivingRoomButtonClick() {
        navigator.navigateTo("living_room"); // Navigate to the living room
    }
}