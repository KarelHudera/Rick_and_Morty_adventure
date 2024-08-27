package karel.hudera.rnma.characters;

import karel.hudera.rnma.strings.StringResources;
import karel.hudera.rnma.logic.game.GamePlan;

public class Rick extends GameCharacter {
    private static final String ID = "1";
    private GamePlan gamePlan;

    public Rick(GamePlan gamePlan, String name, String speakString) {
        super(ID, name, speakString);
        this.gamePlan = gamePlan;
    }

    @Override
    public String speak() {
        String defaultAnswer = super.speak();
        if (playerHasWeapon()) {
            return String.format("%s: %s", capitalizeFirstLetter(super.getName()), StringResources.SpeakStrings.RICK_SPEAK_WEAPON);
        }
        return defaultAnswer;
    }

    private boolean playerHasWeapon() {
        return gamePlan.getInventory().containsItem("plasma_blaster");
    }
}