package karel.hudera.rnma.items;

public class Item {
    private String name;
    private Boolean canBePicked;

    public Item(String name, Boolean canBePicked) {
        this.name = name;
        this.canBePicked = canBePicked;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getCanBePicked() {
        return this.canBePicked;
    }
}