package karel.hudera.rnma.presentation.observer;

public interface Observable  {
    void observe(GameChange gameChange, Observer observer);
}