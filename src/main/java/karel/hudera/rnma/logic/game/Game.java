package karel.hudera.rnma.logic.game;

import karel.hudera.rnma.Strings.StringResources;
import karel.hudera.rnma.logic.commands.*;

public class Game implements IGame {
    private CommandsList commandsList;
    private GamePlan gamePlan;
    private boolean gameOver = false;

    public Game() {
        gamePlan = new GamePlan(this);
        commandsList = new CommandsList();
        commandsList.inputCommand(new CommandHelp(commandsList));
        commandsList.inputCommand(new CommandEndGame(this));
        commandsList.inputCommand(new CommandGoTo(gamePlan));
        commandsList.inputCommand(new CommandShowInventory(gamePlan));
        commandsList.inputCommand(new CommandPick(gamePlan));
        commandsList.inputCommand(new CommandDrop(gamePlan));
        commandsList.inputCommand(new CommandSearch(gamePlan));
    }

    @Override
    public String getIntro() {
        return StringResources.Intro.INTRO_MESSAGE;
    }

    @Override
    public String getOutro() {
        return StringResources.Outro.OUTRO_MESSAGE;
    }

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

    @Override
    public boolean gameOver() {
        return gameOver;
    }

    @Override
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    @Override
    public GamePlan getGamePlan() {
        return gamePlan;
    }
}