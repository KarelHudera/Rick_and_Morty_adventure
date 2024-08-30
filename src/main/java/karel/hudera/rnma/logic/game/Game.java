package karel.hudera.rnma.logic.game;

import karel.hudera.rnma.strings.StringResources;
import karel.hudera.rnma.logic.commands.*;

/**
 * Represents the main game logic, managing commands, game state, and interactions.
 * Implements the {@link IGame} interface.
 *
 * @author KarelHudera
 */
public class Game implements IGame {
    private CommandsList commandsList;
    private GamePlan gamePlan;
    private boolean gameOver = false;

    /**
     * Constructs a new Game instance and initializes the game plan and commands.
     */
    public Game() {
        gamePlan = new GamePlan(this);
        commandsList = new CommandsList();
        initializeCommands();
    }

    /**
     * Initializes the list of commands available in the game.
     */
    private void initializeCommands() {
        commandsList.inputCommand(new CommandHelp(commandsList));
        commandsList.inputCommand(new CommandEndGame(this));
        commandsList.inputCommand(new CommandGoTo(gamePlan));
        commandsList.inputCommand(new CommandShowInventory(gamePlan));
        commandsList.inputCommand(new CommandPick(gamePlan));
        commandsList.inputCommand(new CommandDrop(gamePlan));
        commandsList.inputCommand(new CommandSearch(gamePlan));
        commandsList.inputCommand(new CommandTalkTo(gamePlan));
        commandsList.inputCommand(new CommandKill(gamePlan));
        commandsList.inputCommand(new CommandOpen(gamePlan));
    }

    /**
     * Retrieves the introductory message for the game.
     *
     * @return the introductory message
     */
    @Override
    public String getIntro() {
        return StringResources.Intro.INTRO_MESSAGE;
    }

    /**
     * Retrieves the outro message for the game.
     *
     * @return the outro message
     */
    @Override
    public String getOutro() {
        return StringResources.Outro.OUTRO_MESSAGE;
    }

    /**
     * Processes the user's input, executing the corresponding command.
     *
     * @param input the user input
     * @return the result of the command execution
     */
    @Override
    public String handleInput(String input) {
        String[] commandParts = input.split("[ \t]+");
        String commandName = commandParts[0];
        String[] param = new String[commandParts.length - 1];
        System.arraycopy(commandParts, 1, param, 0, param.length);
        String output;
        if (commandsList.isCommandValid(commandName)) {
            ICommand command = commandsList.returnCommand(commandName);
            output = command.makeCommand(param);
        } else {
            output = StringResources.Errors.INVALID_COMMAND;
        }
        return output;
    }

    /**
     * Checks if the game is over.
     *
     * @return true if the game is over, false otherwise
     */
    @Override
    public boolean gameOver() {
        return gameOver;
    }

    /**
     * Sets the game over status.
     *
     * @param gameOver true to set the game as over, false otherwise
     */
    @Override
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    /**
     * Retrieves the current game plan.
     *
     * @return the game plan
     */
    @Override
    public GamePlan getGamePlan() {
        return gamePlan;
    }
}