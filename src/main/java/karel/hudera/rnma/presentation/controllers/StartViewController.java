package karel.hudera.rnma.presentation.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import karel.hudera.rnma.presentation.navigation.Navigator;

public class StartViewController implements BaseControllerAware {

    private Navigator navigator;

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    @FXML
    private Button helloButton;

    @FXML
    public void onHelloButtonClick() {
        navigator.navigateTo("kitchen");
    }
}