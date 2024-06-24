package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.Strings.StringResources;
import karel.hudera.rnma.logic.game.GamePlan;

public class CommandTalkTo extends Command {
    public CommandTalkTo(GamePlan gamePlan) {
        super(StringResources.Commands.TALK_TO, gamePlan);
    }

    @Override
    public String makeCommand(String... param) {
        if (param.length == 0) {
            return "You must specify who you want to talk to.";
        } else if (param.length > 1) {
            return "Please specify only one character to talk to.";
        }

        String characterName = param[0];
        if (this.getGamePlan().getCurrentRoom().containsCharacter(characterName)) {
            return this.getGamePlan().getCurrentRoom().getCharacter(characterName).speak();
        } else {
            return "The character '" + characterName + "' is not here.";
        }
    }
}
