package karel.hudera.rnma.logic.items;

/**
 * Represents an item in the game with a name and a flag indicating if it can be picked up.
 *
 * @author KarelHudera
 */
public class Item {
    private String name;
    private Boolean canBePicked;

    /**
     * Constructs a new Item with the specified name and pick-up status.
     *
     * @param name        the name of the item
     * @param canBePicked whether the item can be picked up
     */
    public Item(String name, Boolean canBePicked) {
        this.name = name;
        this.canBePicked = canBePicked;
    }

    /**
     * Returns the name of the item.
     *
     * @return the name of the item
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns whether the item can be picked up.
     *
     * @return true if the item can be picked up, false otherwise
     */
    public Boolean getCanBePicked() {
        return this.canBePicked;
    }
}