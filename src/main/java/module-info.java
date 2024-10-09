module karel.hudera.rnma {
    requires javafx.controls;
    requires javafx.fxml;


    opens karel.hudera.rnma.presentation.controllers to javafx.fxml;
    exports karel.hudera.rnma;
}