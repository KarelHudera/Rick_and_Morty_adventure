package karel.hudera.rnma.logic.commands;

import karel.hudera.rnma.strings.StringResources;
import karel.hudera.rnma.logic.game.GamePlan;
import karel.hudera.rnma.rooms.Room;

/**
 * Represents the "go to" command, which allows a player to move from the current room to a specified destination.
 * Extends the base {@link Command} class.
 *
 * @author KarelHudera
 */
public class CommandGoTo extends Command {

    /**
     * Constructs a new CommandGoTo with the specified game plan.
     *
     * @param gamePlan the game plan associated with this command
     */
    public CommandGoTo(GamePlan gamePlan) {
        super(StringResources.Commands.GOTO, gamePlan);
    }

    /**
     * Executes the go-to command with the given parameters. Validates the parameters and attempts to move the player
     * to the specified destination room.
     *
     * @param param the parameters for the command; expects exactly one parameter: the destination room name
     * @return the result of the command execution, either the description of the new room or an error message
     */
    @Override
    public String makeCommand(String... param) {
        String validationError = validateParams(param);
        if (validationError != null) {
            return validationError;  // Return validation error if parameters are invalid
        }

        String desiredDestination = param[0];

        Room currentRoom = this.getGamePlan().getCurrentRoom();
        Room availableEntrance = currentRoom.getEntranceByName(desiredDestination);
        Room allRooms = this.getGamePlan().getRoomByName(desiredDestination);

        // Check if the desired room exists
        if (allRooms == null) {
            return StringResources.Errors.PARAM_DOESNT_EXIST;  // Room does not exist
        }

        // Check if the room is accessible from the current room
        if (availableEntrance == null) {
            return StringResources.Errors.CANT_GO_THERE;  // Cannot go to the specified room from the current location
        }

        // Move to the new room and return its description
        this.getGamePlan().setCurrentRoom(availableEntrance);
        return availableEntrance.getDescription();
    }
}