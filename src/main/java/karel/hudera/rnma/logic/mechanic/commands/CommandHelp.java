package karel.hudera.rnma.logic.mechanic.commands;

import karel.hudera.rnma.logic.strings.StringResources;

/**
 * Represents the "help" command, which provides a list of available commands.
 * Implements the {@link ICommand} interface.
 *
 * @author KarelHudera
 */
public class CommandHelp implements ICommand {
    private static final String NAME = StringResources.Commands.HELP;
    private CommandsList commandsList;

    /**
     * Constructs a new CommandHelp with the specified commands list.
     *
     * @param commandsList the list of commands to be displayed
     */
    public CommandHelp(CommandsList commandsList) {
        this.commandsList = commandsList;
    }

    /**
     * Executes the help command. Returns a list of available command names.
     *
     * @param param the parameters for the command; not used in this command
     * @return a string containing the names of available commands
     */
    @Override
    public String makeCommand(String... param) {
        return commandsList.returnCommandNames();  // Return the list of command names
    }

    /**
     * Returns the name of the command.
     *
     * @return the name of the help command
     */
    @Override
    public String getName() {
        return NAME;
    }
}