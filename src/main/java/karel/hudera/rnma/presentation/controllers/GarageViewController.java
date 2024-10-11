package karel.hudera.rnma.presentation.controllers;

import javafx.fxml.FXML;
import karel.hudera.rnma.presentation.navigation.Navigator;

public class GarageViewController implements BaseControllerAware {
    private Navigator navigator;

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }


    @FXML
    protected void onBackButtonClick() {
        System.out.println("Back button clicked"); // Debugging line
        navigator.navigateTo("start"); // Go back to the first page
    }
}