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
        if (mappedCommands.containsKey(command)) {
            return mappedCommands.get(command);
        } else {
            return null;
        }
    }

    public boolean isCommandValid(String command) {
        return mappedCommands.containsKey(command);
    }

    public String returnCommandName() {
        String list = "";
        for (String name : mappedCommands.keySet()) {
            list += name + ", ";
        }
        list = list.substring(0, list.length() - 2);
        return list;
    }
}