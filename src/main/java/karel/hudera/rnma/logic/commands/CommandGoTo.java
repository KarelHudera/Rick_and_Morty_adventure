package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.logic.game.GamePlan;
import karel.hudera.rnma.rooms.Room;

public class CommandGoTo extends Command{
    public CommandGoTo(GamePlan gamePlan) {
        super("goto", gamePlan);
    }

    @Override
    public String makeCommand(String... param) {
        if (param.length == 0) {
            return "Please specify where to go.";
        }

        String desiredDestination = param[0];

        Room currentRoom = this.getGamePlan().getCurrentRoom();
        Room availableEntrance = currentRoom.getEntranceByName(desiredDestination);
        Room allRooms = this.getGamePlan().getRoomByName(desiredDestination);

        if (allRooms == null) {
            return "That place doesnt exist";
        }

        if (availableEntrance == null) {
            return "Can't go there.";
        }

        this.getGamePlan().setCurrentRoom(availableEntrance);
        return availableEntrance.getDescription();
    }
}