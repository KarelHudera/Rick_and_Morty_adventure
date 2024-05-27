package karel.hudera.rnma.logic.commands;

public interface ICommand {
    String makeCommand(String... param);
    String getName();
}