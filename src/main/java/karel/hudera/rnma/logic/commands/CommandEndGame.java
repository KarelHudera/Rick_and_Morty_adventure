package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.strings.StringResources;
import karel.hudera.rnma.logic.game.Game;

/**
 * Represents the "end game" command, which allows a player to end the current game session.
 * Extends the base {@link Command} class.
 *
 * @author KarelHudera
 */
public class CommandEndGame extends Command {
    private Game game;

    /**
     * Constructs a new CommandEndGame with the specified game.
     *
     * @param game the game instance associated with this command
     */
    public CommandEndGame(Game game) {
        super(StringResources.Commands.END_GAME, game.getGamePlan());
        this.game = game;
    }

    /**
     * Executes the end game command. Sets the game state to "over" and returns a game over message.
     *
     * @param param the parameters for the command; not used in this command
     * @return the game over message indicating the game has ended
     */
    @Override
    public String makeCommand(String... param) {
        game.setGameOver(true); // Set the game state to over
        return StringResources.Outro.GAME_OVER; // Return the game over message
    }
}