package karel.hudera.rnma.logic.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandsList {
    private Map<String, ICommand> mappedCommands;

    public CommandsList() {
        mappedCommands = new HashMap<>();
    }

    public void inputCommand(ICommand command) {
        mappedCommands.put(command.getName(), command);
    }

    public ICommand returnCommand(String command) {
        return mappedCommands.getOrDefault(command, null);
    }

    public boolean isCommandValid(String command) {
        return mappedCommands.containsKey(command);
    }

    public String returnCommandNames() {
        StringBuilder list = new StringBuilder();
        for (String name : mappedCommands.keySet()) {
            list.append(name).append(", ");
        }
        list = new StringBuilder(list.substring(0, list.length() - 2));
        return list.toString();
    }
}