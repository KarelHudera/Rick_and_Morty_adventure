package karel.hudera.rnma.presentation.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import karel.hudera.rnma.logic.strings.StringResources;
import karel.hudera.rnma.presentation.controllers.base.BaseControllerAware;
import karel.hudera.rnma.presentation.navigation.Navigator;
import karel.hudera.rnma.presentation.observer.GameChange;

public class EndViewController implements BaseControllerAware {
    private Navigator navigator;


    @FXML
    private Label largeTextLabel;

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
        navigator.getGame().getGamePlan().observe(GameChange.GAME_OVER, this::getEndMessage);
    }

    public void getEndMessage() {
        String end = navigator.getGame().getGamePlan().getEndMessage();
        System.out.println(end);

        largeTextLabel.setText(end);
    }
}
