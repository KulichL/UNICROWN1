import java.util.*;

public class Inventory {
    private final int capacity;
    private final List<Item> items = new ArrayList<>();

    public Inventory(int capacity) {
        this.capacity = capacity;
    }

    public boolean add(Item item) {
        if (items.size() >= capacity) return false;
        items.add(item);
        return true;
    }

    public boolean remove(Item item) {
        return items.remove(item);
    }

    public Item findByIdOrName(String token) {
        String t = token.toLowerCase();
        for (Item it : items) {
            if (it.getId().equalsIgnoreCase(token) || it.getName().toLowerCase().contains(t)) {
                return it;
            }
        }
        return null;
    }

    public boolean isEmpty() { return items.isEmpty(); }

    public String toText() {
        if (items.isEmpty()) return "Inventář je prázdný.";
        StringBuilder sb = new StringBuilder("Inventář:\n");
        for (Item it : items) {
            sb.append("- ").append(it.getName()).append(" (").append(it.getId()).append(")\n");
        }
        return sb.toString();
    }
}
