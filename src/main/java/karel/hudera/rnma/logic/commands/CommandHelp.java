package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.Strings.StringResources;

public class CommandHelp implements ICommand{
    private static final String NAME = StringResources.Commands.HELP;
    private CommandsList commandsList;

    public CommandHelp(CommandsList commandsList) {
        this.commandsList = commandsList;
    }

    @Override
    public String makeCommand(String... param) {
        return commandsList.returnCommandNames();
    }

    @Override
    public String getName() {
        return NAME;
    }
}