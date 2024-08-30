package karel.hudera.rnma.characters;

/**
 * Represents a game character with an ID, name, speech, and alive status.
 *
 * @author KarelHudera
 */
public class GameCharacter implements IGameCharacter {
    private String ID;
    private String name;
    private String speakString;
    private boolean isAlive = true;

    /**
     * Constructs a new GameCharacter with the specified ID, name, and speak string.
     *
     * @param ID          the unique identifier of the character
     * @param name        the name of the character
     * @param speakString the text the character speaks
     */
    public GameCharacter(String ID, String name, String speakString) {
        this.ID = ID;
        this.name = name;
        this.speakString = speakString;
    }

    /**
     * Returns the character's speech string, formatted with the character's name.
     *
     * @return the character's speech string
     */
    @Override
    public String speak() {
        return String.format("%s: %s", capitalizeFirstLetter(name), speakString);
    }

    /**
     * Returns whether the character is alive.
     *
     * @return true if the character is alive, false otherwise
     */
    @Override
    public Boolean isAlive() {
        return isAlive;
    }

    /**
     * Sets the character's status to dead.
     */
    public void setDead() {
        this.isAlive = false;
    }

    /**
     * Returns the name of the character.
     *
     * @return the name of the character
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the unique identifier of the character.
     *
     * @return the ID of the character
     */
    public String getID() {
        return ID;
    }

    /**
     * Capitalizes the first letter of the provided text.
     *
     * @param text the text to capitalize
     * @return the text with the first letter capitalized
     */
    String capitalizeFirstLetter(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }

    /**
     * Sets the speak string of the character.
     *
     * @param speakString the new speak string
     */
    public void setSpeakString(String speakString) {
        this.speakString = speakString;
    }
}