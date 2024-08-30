package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.strings.StringResources;
import karel.hudera.rnma.logic.game.GamePlan;
import karel.hudera.rnma.characters.GameCharacter;

/**
 * Represents the "talk to" command, which allows the player to talk to a character in the current room.
 * Extends the base {@link Command} class.
 *
 * @author KarelHudera
 */
public class CommandTalkTo extends Command {

    /**
     * Constructs a new CommandTalkTo with the specified game plan.
     *
     * @param gamePlan the game plan associated with this command
     */
    public CommandTalkTo(GamePlan gamePlan) {
        super(StringResources.Commands.TALK_TO, gamePlan);
    }

    /**
     * Executes the "talk to" command by interacting with a specified character.
     *
     * @param param the name of the character to talk to
     * @return a string response based on the interaction with the character
     */
    @Override
    public String makeCommand(String... param) {
        String validationError = validateParams(param);
        if (validationError != null) {
            return validationError;
        }

        String characterName = param[0];
        return talkToCharacter(characterName);
    }

    /**
     * Handles the interaction with a specified character.
     *
     * @param characterName the name of the character to talk to
     * @return a string response based on whether the character is present and alive
     */
    private String talkToCharacter(String characterName) {
        if (!this.getGamePlan().getCurrentRoom().containsCharacter(characterName)) {
            return StringResources.ERROR_PREFIX + characterName + StringResources.Errors.CHARACTER_NOT_HERE;
        }

        GameCharacter character = this.getGamePlan().getGameCharacterByName(characterName);
        if (!character.isAlive()) {
            return capitalizeFirstLetter(characterName) + StringResources.Errors.CHARACTER_IS_DEAD;
        }

        return character.speak();
    }

    /**
     * Capitalizes the first letter of a given text.
     *
     * @param text the text to capitalize
     * @return the text with the first letter capitalized
     */
    String capitalizeFirstLetter(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
}