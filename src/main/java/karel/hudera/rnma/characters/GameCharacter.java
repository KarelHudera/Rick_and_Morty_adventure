package karel.hudera.rnma.characters;

public class GameCharacter implements ICharacter{
    private String name;
    private String speakString;

    public GameCharacter (String name, String speakString) {
        this.name = name;
        this.speakString = speakString;
    }

    @Override
    public String speak() {
        return makeFirstLetterCapital(name) + ": " + speakString;
    }

    public String getName() {
        return name;
    }

    private String makeFirstLetterCapital(String text) {
        return text.substring(0,1).toUpperCase() + text.substring(1);
    }
}