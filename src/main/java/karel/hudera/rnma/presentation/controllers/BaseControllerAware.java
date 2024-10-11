package karel.hudera.rnma.presentation.controllers;

import karel.hudera.rnma.presentation.navigation.Navigator;

public interface BaseControllerAware {
    void setNavigator(Navigator navigator);
}