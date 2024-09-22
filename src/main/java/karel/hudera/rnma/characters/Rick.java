package karel.hudera.rnma.characters;

import karel.hudera.rnma.logic.game.GamePlan;
import karel.hudera.rnma.strings.StringResources;

/**
 * Represents the character Rick in the game.
 * Extends the GameCharacter class to include specific behaviors for Rick.
 *
 * @autor KarelHudera
 */
public class Rick extends GameCharacter {
    private static final String ID = "1";
    private GamePlan gamePlan;

    /**
     * Constructs a new Rick character with the specified game plan, name, and speak string.
     *
     * @param gamePlan    the game plan associated with the character
     * @param name        the name of the character
     * @param speakString the default speech string of the character
     */
    public Rick(GamePlan gamePlan, String name, String speakString) {
        super(ID, name, speakString);
        this.gamePlan = gamePlan;
    }

    /**
     * Returns Rick's speech string. If the player has a weapon, a specific response is returned.
     *
     * @return Rick's speech string, based on the player's inventory
     */
    @Override
    public String speak() {
        String defaultAnswer = super.speak();
        if (playerHasWeapon()) {
            return String.format("%s: %s", capitalizeFirstLetter(super.getName()), StringResources.SpeakStrings.RICK_SPEAK_WEAPON);
        }
        return defaultAnswer;
    }

    /**
     * Checks if the player has a weapon in their inventory.
     *
     * @return true if the player has a weapon, false otherwise
     */
    private boolean playerHasWeapon() {
        return gamePlan.getInventory().containsItem("plasma_blaster");
    }
}