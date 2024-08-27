package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.strings.StringResources;
import karel.hudera.rnma.logic.game.Game;

public class CommandEndGame extends Command {
    private Game game;

    public CommandEndGame(Game game) {
        super(StringResources.Commands.END_GAME, game.getGamePlan());
        this.game = game;
    }

    @Override
    public String makeCommand(String... param) {
        game.setGameOver(true);
        return StringResources.Outro.GAME_OVER;
    }
}