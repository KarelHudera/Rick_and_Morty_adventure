package karel.hudera.rnma.presentation.controllers;

import javafx.fxml.FXML;
import karel.hudera.rnma.presentation.navigation.Navigator;

public class DiningRoomViewController implements BaseControllerAware {
    private Navigator navigator;

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    @FXML
    protected void onBackButtonClick() {
        navigator.navigateTo("start"); // Go back to the first page
    }


}