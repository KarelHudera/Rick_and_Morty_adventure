package karel.hudera.rnma.presentation.observer;

/**
 * The GameChange enum defines the different types of changes that can occur
 * within the game, which may trigger updates to observers.
 * <p>
 * This enum is used in conjunction with the Observer design pattern to notify
 * registered observers about specific events in the game. Each constant represents
 * a distinct event that observers may want to respond to.
 * </p>
 */
public enum GameChange {
    /**
     * Indicates that the player has entered a new room in the game.
     */
    NEW_ROOM,

    /**
     * Indicates that a character has been killed in the game.
     */
    CHARACTER_KILL,

    /**
     * Indicates that the game has ended.
     */
    GAME_OVER
}