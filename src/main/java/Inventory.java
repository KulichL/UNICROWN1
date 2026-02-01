import java.util.List;

public class Inventory {
    private int capacity;
    private List<Item> items;

    public Inventory(int capacity) {}

    public boolean addItem(Item item) { return false; }

    public boolean removeItem(Item item) { return false; }

    public boolean hasItem(String itemName) { return false; }

    public Item findByName(String itemName) { return null; }

    public List<Item> getItems() { return null; }
}
