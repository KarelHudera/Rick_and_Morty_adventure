package karel.hudera.rnma.presentation.items;

import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import karel.hudera.rnma.logic.characters.GameCharacter;

import java.util.Objects;

public class GameCharacterListCell extends ListCell<GameCharacter> {
    private static final double SCREEN_HEIGHT = Screen.getPrimary().getBounds().getHeight();
    private static final double IMAGE_SIZE = SCREEN_HEIGHT / 2.8; // Image size based on screen height
    private static final int TEXT_FONT_SIZE = 28; // Font size for character name

    @Override
    protected void updateItem(GameCharacter gameCharacter, boolean empty) {
        super.updateItem(gameCharacter, empty);
        if (empty || gameCharacter == null) {
            clearCell();
        } else {
            updateCellWithCharacter(gameCharacter);
        }
    }

    /**
     * Clears the cell when there's no content to display.
     */
    private void clearCell() {
        setText(null);
        setGraphic(null);
    }

    /**
     * Updates the cell with the character's name and corresponding image.
     *
     * @param gameCharacter the game character to be displayed.
     */
    private void updateCellWithCharacter(GameCharacter gameCharacter) {
        String characterName = capitalizeFirstLetter(gameCharacter.getName());
        ImageView characterImageView = createCharacterImageView(characterName);

        Text nameText = createCharacterNameText(characterName);

        VBox vbox = new VBox(5, characterImageView, nameText);
        vbox.setAlignment(Pos.BOTTOM_CENTER);
        VBox.setVgrow(nameText, Priority.ALWAYS); // Allow the text to grow

        setGraphic(vbox);
    }

    /**
     * Creates an ImageView for the character image with a rounded square clip.
     *
     * @param characterName the name of the character.
     * @return an ImageView containing the character image.
     */
    private ImageView createCharacterImageView(String characterName) {
        String imagePath = String.format("/karel/hudera/rnma/media/characters/%s.png", characterName);
        ImageView characterImageView = loadCharacterImage(imagePath);

        if (characterImageView != null) {
            configureImageView(characterImageView);
        }
        return characterImageView;
    }

    /**
     * Configures the ImageView properties, including size and clipping.
     *
     * @param characterImageView the ImageView to configure.
     */
    private void configureImageView(ImageView characterImageView) {
        characterImageView.setFitHeight(IMAGE_SIZE);
        characterImageView.setFitWidth(IMAGE_SIZE);
        characterImageView.setPreserveRatio(false); // Disable ratio preservation for 1:1 aspect ratio
    }

    /**
     * Creates a Text node for the character name.
     *
     * @param characterName the name of the character.
     * @return a Text node for the character name.
     */
    private Text createCharacterNameText(String characterName) {
        Text nameText = new Text(characterName);
        nameText.setFont(Font.font(TEXT_FONT_SIZE));
        nameText.setStyle("-fx-font-weight: semibold;"); // Optional: make the text bold
        return nameText;
    }

    /**
     * Loads the image for the character from the specified path.
     *
     * @param imagePath the path of the image.
     * @return an ImageView containing the loaded image, or null if not found.
     */
    private ImageView loadCharacterImage(String imagePath) {
        try {
            Image characterImage = new Image(Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm());
            return new ImageView(characterImage);
        } catch (NullPointerException e) {
            System.out.println("Image not found: " + imagePath);
            return null; // If the image is not found, set graphic to null
        }
    }

    /**
     * Capitalizes the first letter of the given string and lowercases the rest.
     *
     * @param name the string to be formatted.
     * @return the formatted string.
     */
    private String capitalizeFirstLetter(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}