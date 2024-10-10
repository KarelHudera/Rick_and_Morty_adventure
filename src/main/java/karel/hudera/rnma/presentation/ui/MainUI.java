package karel.hudera.rnma.presentation.ui;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class MainUI {

    private BorderPane borderPane;
    private VBox vbox1;
    private VBox vbox2;
    private Button topButton;

    public void launchUI(Stage stage, double screenWidth, double screenHeight) {
        vbox1 = createPaneOne();
        vbox2 = createPaneTwo();

        borderPane = new BorderPane();
        topButton = new Button("Click to show Pane 2");
        topButton.setOnAction(_ -> switchPanes(vbox2));
        borderPane.setTop(new VBox(topButton));

        borderPane.setCenter(vbox1);

        Scene scene = new Scene(borderPane, screenWidth, screenHeight);
        stage.setScene(scene);
        stage.setTitle("Rick and Morty adventure");
        stage.show();
    }

    private VBox createPaneOne() {
        Button button1 = new Button("Click to show Pane 2");
        button1.setOnAction(_ -> switchPanes(vbox2));
        VBox vbox1 = new VBox(button1);
        vbox1.setStyle("-fx-background-color: green");

        return vbox1;
    }

    private VBox createPaneTwo() {
        Button button2 = new Button("Click to show Pane 1");
        button2.setOnAction(_ -> switchPanes(vbox1));
        VBox vbox2 = new VBox(button2);
        vbox2.setStyle("-fx-background-color: yellow");

        return vbox2;
    }

    // Switch Layout Panes in Center of BorderPane
    private void switchPanes(Pane pane) {
        borderPane.setCenter(pane);
    }
}