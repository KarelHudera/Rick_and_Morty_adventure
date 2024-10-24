package karel.hudera.rnma.presentation.controllers.base;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import karel.hudera.rnma.logic.characters.GameCharacter;
import karel.hudera.rnma.logic.items.Item;
import karel.hudera.rnma.logic.strings.StringResources;
import karel.hudera.rnma.presentation.items.GameCharacterListCell;
import karel.hudera.rnma.presentation.navigation.Navigator;
import karel.hudera.rnma.presentation.observer.GameChange;

public class BaseLayoutController implements BaseControllerAware {

    @FXML
    private TextArea conversationTextArea;
    @FXML
    private ListView<GameCharacter> charactersList; // Ensure this uses generics
    private ObservableList<GameCharacter> characters = FXCollections.observableArrayList();
    @FXML
    private Navigator navigator;
    Item weapon = new Item("plasma_blaster", true);
    GameCharacter selectedCharacter;

    @Override
    public void setNavigator(Navigator navigator) {
        if (navigator == null) {
            throw new IllegalStateException("Navigator is not set.");
        }
        this.navigator = navigator;
        navigator.getGame().getGamePlan().observe(GameChange.NEW_ROOM, this::actualizeCharacters);
        navigator.getGame().getGamePlan().observe(GameChange.CHARACTER_KILL, this::actualizeCharacters);
        navigator.getGame().getGamePlan().getInventory().addItem(weapon);
        actualizeCharacters();
    }

    @FXML
    public void initialize() {
        charactersList.setItems(characters); // Set items for the ListView
        charactersList.setCellFactory(_ -> new GameCharacterListCell());
    }

    @FXML
    private void actualizeCharacters() {
        characters.clear();
        characters.addAll(navigator.getGame().getGamePlan().getCurrentRoom().getAliveGameCharacters());
        System.out.println(characters);
        System.out.println(StringResources.Info.YOU_ARE_IN + navigator.getGame().getGamePlan().getCurrentRoom().getName());
    }

    @FXML
    private void handleOpenShields() {
        String x = navigator.getGame().getGamePlan().endGame();
        System.out.println("handleOpenShields" + x);
        navigator.changeScene("endScene");
    }


    @FXML
    private void onCharacterClicked() {
        selectedCharacter = charactersList.getSelectionModel().getSelectedItem();
        // Fetch the selected character from the ListView
        if (selectedCharacter == null) return;

        // Handle talking to the selected character
        String talkTo = navigator.getGame().handleInput(StringResources.Commands.TALK_TO + " " + selectedCharacter.getName());
        System.out.println(talkTo);
        conversationTextArea.clear();
        conversationTextArea.setText(talkTo); // Update the TextArea with the response
    }

    @FXML
    private void kill() {
        String c = navigator.getGame().handleInput(StringResources.Commands.KILL + " " + selectedCharacter);
        System.out.println("kill " + selectedCharacter + c);
        navigator.getGame().getGamePlan().characterKilled();
    }
}