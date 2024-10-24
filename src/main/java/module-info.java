module karel.hudera.rnma {
    requires javafx.controls;
    requires javafx.fxml;


    opens karel.hudera.rnma.presentation.controllers to javafx.fxml;
    exports karel.hudera.rnma;
    opens karel.hudera.rnma.presentation.navigation to javafx.fxml;
    opens karel.hudera.rnma.presentation.controllers.base to javafx.fxml;
    opens karel.hudera.rnma.presentation to javafx.fxml;
}