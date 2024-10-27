package karel.hudera.rnma.presentation.items;

import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import karel.hudera.rnma.logic.characters.GameCharacter;

import java.util.Objects;

/**
 * A custom ListCell for displaying game characters in a ListView.
 * Each cell shows the character's name and image.
 */
public class GameCharacterListCell extends ListCell<GameCharacter> {
    private static final double SCREEN_HEIGHT = Screen.getPrimary().getBounds().getHeight();
    private static final double IMAGE_SIZE = SCREEN_HEIGHT / 3; // Image size is based on screen height

    /**
     * Updates the cell with the provided game character or clears it if empty.
     *
     * @param gameCharacter the game character to display
     * @param empty true if the cell is empty, false otherwise
     */
    @Override
    protected void updateItem(GameCharacter gameCharacter, boolean empty) {
        super.updateItem(gameCharacter, empty);
        if (empty || gameCharacter == null) {
            clearCell(); // Clear the cell if empty or character is null
        } else {
            updateCellWithCharacter(gameCharacter); // Update the cell with character information
        }
    }

    /**
     * Clears the cell when there's no content to display.
     */
    private void clearCell() {
        setText(null); // Clear text
        setGraphic(null); // Clear graphic
    }

    /**
     * Updates the cell with the character's name and corresponding image.
     *
     * @param gameCharacter the game character to be displayed
     */
    private void updateCellWithCharacter(GameCharacter gameCharacter) {
        String characterName = capitalizeFirstLetter(gameCharacter.getName());
        ImageView characterImageView = createCharacterImageView(characterName);
        Text nameText = createCharacterNameText(characterName);

        VBox vbox = new VBox(5, characterImageView, nameText); // Create a VBox to hold image and text
        vbox.setAlignment(Pos.BOTTOM_CENTER); // Center the content
        VBox.setVgrow(nameText, Priority.ALWAYS); // Allow the text to grow and fill available space

        setGraphic(vbox); // Set the VBox as the graphic for this cell
    }

    /**
     * Creates an ImageView for the character image with a fixed size.
     *
     * @param characterName the name of the character
     * @return an ImageView containing the character image, or null if not found
     */
    private ImageView createCharacterImageView(String characterName) {
        String imagePath = String.format("/karel/hudera/rnma/media/characters/%s.png", characterName);
        ImageView characterImageView = loadCharacterImage(imagePath);

        if (characterImageView != null) {
            configureImageView(characterImageView); // Configure ImageView properties
        }
        return characterImageView;
    }

    /**
     * Configures the ImageView properties, including size and aspect ratio.
     *
     * @param characterImageView the ImageView to configure
     */
    private void configureImageView(ImageView characterImageView) {
        characterImageView.setFitHeight(IMAGE_SIZE); // Set height based on SCREEN_HEIGHT
        characterImageView.setFitWidth(IMAGE_SIZE); // Set width to maintain square aspect ratio
        characterImageView.setPreserveRatio(false); // Disable preservation of aspect ratio
    }

    /**
     * Creates a Text node for the character name.
     *
     * @param characterName the name of the character
     * @return a Text node for the character name
     */
    private Text createCharacterNameText(String characterName) {
        return new Text(characterName); // Create and return a Text node
    }

    /**
     * Loads the image for the character from the specified path.
     *
     * @param imagePath the path of the image
     * @return an ImageView containing the loaded image, or null if not found
     */
    private ImageView loadCharacterImage(String imagePath) {
        try {
            Image characterImage = new Image(Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm());
            return new ImageView(characterImage); // Return the ImageView containing the loaded image
        } catch (NullPointerException e) {
            System.out.println("Image not found: " + imagePath); // Log if the image is not found
            return null; // If the image is not found, return null
        }
    }

    /**
     * Capitalizes the first letter of the given string and lowercases the rest.
     *
     * @param name the string to be formatted
     * @return the formatted string, or the original if empty or null
     */
    private String capitalizeFirstLetter(String name) {
        if (name == null || name.isEmpty()) {
            return name; // Return original if null or empty
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase(); // Capitalize first letter
    }
}