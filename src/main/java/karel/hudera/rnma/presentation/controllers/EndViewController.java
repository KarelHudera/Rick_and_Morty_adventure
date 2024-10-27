package karel.hudera.rnma.presentation.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import karel.hudera.rnma.MainApplication;
import karel.hudera.rnma.presentation.controllers.base.BaseControllerAware;
import karel.hudera.rnma.presentation.navigation.Navigator;
import karel.hudera.rnma.presentation.observer.GameChange;

/**
 * Controller for the End view.
 * Manages the display of the end message and game restart functionality.
 */
public class EndViewController implements BaseControllerAware {
    @FXML
    public Button finalExitButton; // Button to exit the application
    @FXML
    public Button newGameButton; // Button to start a new game
    @FXML
    private Label largeTextLabel; // Label to display the end message

    private Navigator navigator; // Reference to the Navigator for navigation and game management

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator; // Set the navigator instance
        navigator.getGame().getGamePlan().observe(GameChange.GAME_OVER, this::getEndMessage); // Observe game over changes

        // Set up button actions
        setupButtonActions();
    }

    /**
     * Sets up button actions for the finalExitButton and newGameButton.
     */
    private void setupButtonActions() {
        finalExitButton.setOnAction(_ -> Platform.exit()); // Exit the application
        newGameButton.setOnAction(_ -> startNewGame()); // Start a new game
    }

    /**
     * Updates the end message displayed in the label when the game is over.
     */
    public void getEndMessage() {
        String endMessage = navigator.getGame().getGamePlan().getEndMessage(); // Get the end message from the game plan
        System.out.println(endMessage); // Print the end message for debugging
        largeTextLabel.setText(endMessage); // Set the end message in the label
    }

    /**
     * Restarts the main application for a new game.
     */
    private void startNewGame() {
        MainApplication.restart(); // Restart the application
    }
}