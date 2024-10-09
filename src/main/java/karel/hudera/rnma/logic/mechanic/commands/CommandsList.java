package karel.hudera.rnma.logic.mechanic.commands;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages a list of commands, allowing for storing, retrieving, and validating commands.
 * Provides functionality to return a list of command names.
 *
 * @author KarelHudera
 */
public class CommandsList {
    private Map<String, ICommand> mappedCommands;

    /**
     * Constructs a new CommandsList, initializing an empty map for commands.
     */
    public CommandsList() {
        mappedCommands = new HashMap<>();
    }

    /**
     * Adds a command to the list.
     *
     * @param command the command to add
     */
    public void inputCommand(ICommand command) {
        mappedCommands.put(command.getName(), command);
    }

    /**
     * Retrieves a command by its name.
     *
     * @param command the name of the command to retrieve
     * @return the command associated with the given name, or null if not found
     */
    public ICommand returnCommand(String command) {
        return mappedCommands.getOrDefault(command, null);
    }

    /**
     * Checks if a command name is valid (i.e., if it exists in the list).
     *
     * @param command the name of the command to check
     * @return true if the command exists, false otherwise
     */
    public boolean isCommandValid(String command) {
        return mappedCommands.containsKey(command);
    }

    /**
     * Returns a comma-separated list of command names.
     *
     * @return a string containing the names of all commands, separated by commas
     */
    public String returnCommandNames() {
        StringBuilder list = new StringBuilder();
        for (String name : mappedCommands.keySet()) {
            list.append(name).append(", ");
        }
        list = new StringBuilder(list.substring(0, list.length() - 2));
        return list.toString();
    }
}