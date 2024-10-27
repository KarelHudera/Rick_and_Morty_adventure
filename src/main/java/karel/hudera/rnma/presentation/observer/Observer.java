package karel.hudera.rnma.presentation.observer;

/**
 * The Observer interface defines the contract for objects that wish to be notified
 * of changes or updates in the subject they are observing.
 * <p>
 * This interface is part of the Observer design pattern, which allows a subject
 * to maintain a list of observers and notify them automatically of any changes.
 * </p>
 * <p>
 * Implementing classes should define the behavior that should occur when
 * an update is received from the subject.
 * </p>
 */
public interface Observer {
    /**
     * Called to update the observer with the latest information or state
     * from the subject it is observing.
     */
    void update();
}