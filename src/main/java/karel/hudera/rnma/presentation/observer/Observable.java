package karel.hudera.rnma.presentation.observer;

/**
 * The Observable interface defines the contract for objects that can be observed
 * by one or more Observer instances. It provides the mechanism for attaching
 * observers and notifying them of changes in the observable's state.
 * <p>
 * This interface is part of the Observer design pattern, enabling the
 * decoupling of the subject's state from its observers, allowing multiple
 * observers to react to changes independently.
 * </p>
 */
public interface Observable {

    /**
     * Attaches an observer to the observable object, enabling it to receive
     * updates related to specific game changes.
     *
     * @param gameChange The type of game change to observe, which can be used
     *                   to filter notifications or updates.
     * @param observer The observer that wants to receive updates. This observer
     *                 will be notified when the observable state changes.
     */
    void observe(GameChange gameChange, Observer observer);
}