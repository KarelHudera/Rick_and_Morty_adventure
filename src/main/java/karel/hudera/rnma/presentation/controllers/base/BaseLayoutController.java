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

/**
 * Base layout controller that manages the conversation and character interactions.
 */
public class BaseLayoutController implements BaseControllerAware {

    @FXML
    private TextArea conversationTextArea;
    @FXML
    private ListView<GameCharacter> charactersList; // Ensure this uses generics
    private ObservableList<GameCharacter> characters = FXCollections.observableArrayList();
    private Navigator navigator; // Navigator for scene navigation
    private final Item weapon = new Item("plasma_blaster", true); // Weapon item
    private GameCharacter selectedCharacter; // Currently selected character

    @Override
    public void setNavigator(Navigator navigator) {
        if (navigator == null) {
            throw new IllegalStateException("Navigator cannot be null.");
        }
        this.navigator = navigator;
        setupGameObservers();
        navigator.getGame().getGamePlan().getInventory().addItem(weapon);
        actualizeCharacters(); // Update character list initially
    }

    /**
     * Sets up observers for game changes.
     */
    private void setupGameObservers() {
        navigator.getGame().getGamePlan().observe(GameChange.NEW_ROOM, this::actualizeCharacters);
        navigator.getGame().getGamePlan().observe(GameChange.CHARACTER_KILL, this::actualizeCharacters);
    }

    @FXML
    public void initialize() {
        charactersList.setItems(characters); // Set items for the ListView
        charactersList.setCellFactory(_ -> new GameCharacterListCell()); // Set cell factory
        conversationTextArea.setEditable(false); // Make TextArea non-editable
    }

    /**
     * Updates the character list based on the current room.
     */
    public void actualizeCharacters() {
        characters.clear();
        characters.addAll(navigator.getGame().getGamePlan().getCurrentRoom().getAliveGameCharacters());
        System.out.println(characters);
        System.out.println(StringResources.Info.YOU_ARE_IN + navigator.getGame().getGamePlan().getCurrentRoom().getName());
        conversationTextArea.clear(); // Clear previous conversation text
    }

    @FXML
    private void handleOpenShields() {
        System.out.println("handleOpenShields: " + navigator.getGame().getGamePlan().endGame());
        navigator.changeScene("endScene"); // Change to end scene
    }

    @FXML
    private void onCharacterClicked() {
        selectedCharacter = charactersList.getSelectionModel().getSelectedItem(); // Fetch selected character
        if (selectedCharacter == null) return; // Return if no character is selected

        // Handle talking to the selected character
        String response = navigator.getGame().handleInput(StringResources.Commands.TALK_TO + " " + selectedCharacter.getName());
        System.out.println(response);
        updateConversationText(response); // Update the TextArea with the response
    }

    /**
     * Updates the conversation text area with the given response.
     *
     * @param response the response to display
     */
    private void updateConversationText(String response) {
        conversationTextArea.clear(); // Clear previous text
        conversationTextArea.setText(response); // Set new response
    }

    @FXML
    private void kill() {
        if (selectedCharacter != null) {
            String result = navigator.getGame().handleInput(StringResources.Commands.KILL + " " + selectedCharacter.getName());
            System.out.println("kill " + selectedCharacter.getName() + ": " + result);
            navigator.getGame().getGamePlan().characterKilled(); // Update game state after killing character
        }
    }
}