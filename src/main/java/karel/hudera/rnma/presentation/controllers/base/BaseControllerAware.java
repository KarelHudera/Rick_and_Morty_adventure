package karel.hudera.rnma.presentation.controllers.base;

import karel.hudera.rnma.logic.mechanic.game.Game;
import karel.hudera.rnma.presentation.navigation.Navigator;

public interface BaseControllerAware {
    void setNavigator(Navigator navigator);
}