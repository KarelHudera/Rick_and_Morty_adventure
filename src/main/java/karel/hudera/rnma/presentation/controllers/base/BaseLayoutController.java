package karel.hudera.rnma.presentation.controllers.base;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import karel.hudera.rnma.logic.characters.GameCharacter;
import karel.hudera.rnma.presentation.navigation.Navigator;

public class BaseLayoutController implements BaseControllerAware {
    private Navigator navigator;

    @Override
    public void setNavigator(Navigator navigator) {
//        if (navigator == null) {
//            throw new IllegalStateException("Navigator is not set.");
//        }
//        if (this.navigator != null) {
//            System.out.println("Navigator is being reset.");
//        }
        this.navigator = navigator;
        System.out.println("Navigator has been set.");
    }
    @FXML
    private ListView<GameCharacter> charactersList; // Ensure this uses generics
    private ObservableList<GameCharacter> characters = FXCollections.observableArrayList();

    @FXML
    private void onLoad() {
       actualizeCharacters(); // Call this when the button is clicked
    }

    @FXML
    private void initialize() {
        charactersList.setItems(characters); // Set items for the ListView
        actualizeCharacters(); // Optionally load characters at the start
    }

    @FXML
    private void actualizeCharacters() {
        if (navigator == null) {
            System.out.println("Navigator is null in actualizeCharacters.");
            return; // Prevent further action
        }

        characters.clear();
        characters.addAll(navigator.getGame().getGamePlan().getCurrentRoom().getAllGameCharacters());
        System.out.println(characters);
        System.out.println("Current room: " + navigator.getGame().getGamePlan().getCurrentRoom().getName());
    }
}
