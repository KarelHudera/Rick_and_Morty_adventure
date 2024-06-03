package karel.hudera.rnma.logic.game;

import karel.hudera.rnma.logic.commands.CommandGoTo;
import karel.hudera.rnma.logic.commands.CommandsList;
import karel.hudera.rnma.logic.commands.ICommand;

public class Game implements IGame {
    private CommandsList commandsList;
    private GamePlan gamePlan;
    private boolean gameOver = false;

    public Game() {
        gamePlan = new GamePlan(this);
        commandsList = new CommandsList();
        commandsList.inputCommand(new CommandGoTo(gamePlan));
    }

    @Override
    public String getIntro() {
        return """
                ⠀⠀⠀⠐⣦⣴⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⣻⣿⣿⣿⡄⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠈⠹⣯⣿⣿⡃⠀⠀⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⢀⣹⣟⣡⡤⠴⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⣠⡶⠋⢹⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣶⣿⣿⡄⠀⠀⠀
                ⠀⣼⠃⠀⠀⢀⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⡀⠀⠀
                ⢸⠇⠀⠀⠀⣼⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣶⣾⡟⣷⣂⣀⡤⠖
                ⠿⠊⠲⣶⠿⠛⠫⣶⣧⣀⣀⡀⠀⠀⠀⠀⣠⠞⠁⣴⣿⡿⠁⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⢀⡿⠀⠉⠉⣩⡿⠀⠀⠀⠉⠀⣼⣿⡿⠁⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⣼⠃⠀⠀⣰⠟⠀⢀⠀⠀⠀⢠⣿⣿⣁⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⢀⡼⠃⠀⠀⢴⣅⠀⠀⠉⠘⠲⠴⠟⠁⠈⠙⢷⡀⠀⠀⠀⠀⠀
                ⠀⠀⠀⣰⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠇⠀⠀⠀⠀⠀
                ⠀⠀⠰⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠀⠀⠀⠀""";
    }

    @Override
    public String getOutro() {
        return "Outro";
    }

    @Override
    public String handleInput(String input) {
        String[] commandParts = input.split("[ \t]+");
        String commandName = commandParts[0];
        String[] param = new String[commandParts.length - 1];
        for (int i = 0; i < param.length; i++) {
            param[i] = commandParts[i + 1];
        }
        String output;
        if (commandsList.isCommandValid(commandName)) {
            ICommand command = commandsList.returnCommand(commandName);
            output = command.makeCommand(param);
        } else {
            output = "Invalid command";
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
        return null;
    }
}