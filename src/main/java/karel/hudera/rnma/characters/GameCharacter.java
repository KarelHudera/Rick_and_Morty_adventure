package karel.hudera.rnma.characters;

public class GameCharacter implements IGameCharacter {
    private String ID;
    private String name;
    private String speakString;
    private boolean isAlive = true;

    public GameCharacter(String ID, String name, String speakString) {
        this.ID = ID;
        this.name = name;
        this.speakString = speakString;
    }

    @Override
    public String speak() {
        return String.format("%s: %s", capitalizeFirstLetter(name), speakString);
    }

    @Override
    public Boolean isAlive() {
        return isAlive;
    }

    public void setDead() {
        this.isAlive = false;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    String capitalizeFirstLetter(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }

    public void setSpeakString(String speakString) {
        this.speakString = speakString;
    }
}