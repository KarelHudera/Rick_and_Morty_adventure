package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.Strings.StringResources;
import karel.hudera.rnma.logic.game.GamePlan;
import karel.hudera.rnma.characters.GameCharacter;

public class CommandTalkTo extends Command {
    public CommandTalkTo(GamePlan gamePlan) {
        super(StringResources.Commands.TALK_TO, gamePlan);
    }

    @Override
    public String makeCommand(String... param) {
        if (param.length == 0) {
            return StringResources.Errors.SPECIFY_TALK_TO;
        } else if (param.length > 1) {
            return StringResources.Errors.SPECIFY_LESS_PARAM;
        }

        String characterName = param[0];
        return talkToCharacter(characterName);
    }

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

    String capitalizeFirstLetter(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
}