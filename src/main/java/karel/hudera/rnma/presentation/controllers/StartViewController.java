package karel.hudera.rnma.presentation.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import karel.hudera.rnma.presentation.controllers.base.BaseControllerAware;
import karel.hudera.rnma.presentation.navigation.Navigator;

import java.util.Objects;

public class StartViewController implements BaseControllerAware {
    private Navigator navigator;

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    private static final double screenWidth = Screen.getPrimary().getBounds().getWidth();
    private static final double screenHeight = Screen.getPrimary().getBounds().getHeight();

    @FXML
    private ImageView backgroundImage;
    @FXML
    private StackPane rootPane;

    public void initialize() {
        // Load the image
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/karel/hudera/rnma/media/4k-rick-and-morty.jpg")));
        backgroundImage.setImage(image);

        // Bind the ImageView's fitWidth and fitHeight properties to the StackPane size
        backgroundImage.setFitHeight(screenHeight);
        backgroundImage.setFitWidth(screenWidth);
        //backgroundImage.fitWidthProperty().bind(rootPane.widthProperty());
        //backgroundImage.fitHeightProperty().bind(rootPane.heightProperty());
    }

    @FXML
    public void onStartGameButtonClick() {
        navigator.navigateTo("kitchen");
    }
}