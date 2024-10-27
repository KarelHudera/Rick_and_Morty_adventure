package karel.hudera.rnma.presentation.controllers.base;

import karel.hudera.rnma.presentation.navigation.Navigator;

/**
 * Interface for controllers that require access to the Navigator.
 */
public interface BaseControllerAware {

    /**
     * Sets the Navigator for the controller.
     *
     * @param navigator the Navigator instance to be set
     * @throws IllegalStateException if the navigator is null
     */
    void setNavigator(Navigator navigator);
}