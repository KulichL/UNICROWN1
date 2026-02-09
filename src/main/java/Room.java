import java.util.*;

public class Room {
    private final String id;
    private final String name;
    private final String description;
    private final Map<String, String> exits;

    private final List<Item> items = new ArrayList<>();
    private final List<NPC> npcs = new ArrayList<>();
    private final List<Enemy> enemies = new ArrayList<>();

    public Room(String id, String name, String description, Map<String, String> exits) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.exits = (exits != null) ? exits : new HashMap<>();
    }

    public List<Enemy> getEnemies() { return enemies; }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Map<String, String> getExits() { return exits; }
    public List<Item> getItems() { return items; }
    public List<NPC> getNpcs() { return npcs; }

    public String itemsToString() {
        if (items.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (Item it : items) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(it.getName());
        }
        return sb.toString();
    }

    public Enemy findEnemy(String token) {
        String t = token.toLowerCase();
        for (Enemy e : enemies) {
            if (e.getName().toLowerCase().contains(t)) return e;
        }
        return null;
    }

    public String npcsToString() {
        if (npcs.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (NPC n : npcs) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(n.getName());
        }
        return sb.toString();
    }

    public String enemiesToString() {
        if (enemies.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (Enemy e : enemies) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(e.getName());
        }
        return sb.toString();
    }

    public String exitsToString() {
        return String.join(", ", exits.keySet());
    }
}
