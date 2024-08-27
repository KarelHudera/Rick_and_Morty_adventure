package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.strings.StringResources;
import karel.hudera.rnma.logic.game.GamePlan;
import karel.hudera.rnma.rooms.Room;

public class CommandGoTo extends Command {
    public CommandGoTo(GamePlan gamePlan) {
        super(StringResources.Commands.GOTO, gamePlan);
    }

    @Override
    public String makeCommand(String... param) {
        String validationError = validateParams(param);
        if (validationError != null) {
            return validationError;
        }

        String desiredDestination = param[0];

        Room currentRoom = this.getGamePlan().getCurrentRoom();
        Room availableEntrance = currentRoom.getEntranceByName(desiredDestination);
        Room allRooms = this.getGamePlan().getRoomByName(desiredDestination);

        if (allRooms == null) {
            return StringResources.Errors.PARAM_DOESNT_EXIST;
        }

        if (availableEntrance == null) {
            return StringResources.Errors.CANT_GO_THERE;
        }

        this.getGamePlan().setCurrentRoom(availableEntrance);
        return availableEntrance.getDescription();
    }
}