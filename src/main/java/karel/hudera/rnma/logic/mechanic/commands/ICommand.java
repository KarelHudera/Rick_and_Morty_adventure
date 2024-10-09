package karel.hudera.rnma.logic.mechanic.commands;

public interface ICommand {
    String makeCommand(String... param);
    String getName();
}