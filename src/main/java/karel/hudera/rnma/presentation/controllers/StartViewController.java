package karel.hudera.rnma.presentation.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import karel.hudera.rnma.presentation.controllers.base.BaseControllerAware;
import karel.hudera.rnma.presentation.navigation.Navigator;

import java.util.Objects;

/**
 * Controller for the start view of the application.
 * Handles initialization and events for the start screen.
 */
public class StartViewController implements BaseControllerAware {
    private Navigator navigator; // Reference to the navigator for scene changes

    // Screen dimensions for layout purposes
    private static final double SCREEN_WIDTH = Screen.getPrimary().getBounds().getWidth();

    @FXML
    private ImageView backgroundImage; // ImageView for the background image

    /**
     * Initializes the controller after its root element has been processed.
     * Loads the background image and sets its properties.
     */
    public void initialize() {
        // Load the image from resources and set it to the ImageView
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/karel/hudera/rnma/media/4k-rick-and-morty.jpg")));
        backgroundImage.setImage(image);

        // Set the ImageView's width to match the screen width
        backgroundImage.setFitWidth(SCREEN_WIDTH);
    }

    /**
     * Handles the event when the start game button is clicked.
     * Navigates to the main scene.
     */
    @FXML
    public void onStartGameButtonClick() {
        navigator.changeScene("mainScene"); // Change to the main scene
    }

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator; // Set the navigator for scene changes
    }
}