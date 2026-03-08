import java.util.*;

/**
 * Třída reprezentující místnost ve hře.
 * Místnost má identifikátor, název, popis a východy do dalších místností.
 * Může také obsahovat předměty, NPC postavy a nepřátele.
 *
 * @author Lukáš Kulich
 */
public class Room {
    private final String id;
    private final String name;
    private final String description;
    private final Map<String, String> exits;

    private final List<Item> items = new ArrayList<>();
    private final List<NPC> npcs = new ArrayList<>();
    private final List<Enemy> enemies = new ArrayList<>();

    /**
     * Vytvoří novou místnost.
     *
     * @param id unikátní identifikátor místnosti
     * @param name název místnosti
     * @param description popis místnosti
     * @param exits mapa východů (směr → id místnosti)
     */
    public Room(String id, String name, String description, Map<String, String> exits) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.exits = (exits != null) ? exits : new HashMap<>();
    }

    /**
     * Vrátí seznam nepřátel v místnosti.
     *
     * @return seznam nepřátel
     */
    public List<Enemy> getEnemies() { return enemies; }

    /**
     * Vrátí identifikátor místnosti.
     *
     * @return id místnosti
     */
    public String getId() { return id; }

    /**
     * Vrátí název místnosti.
     *
     * @return název místnosti
     */
    public String getName() { return name; }

    /**
     * Vrátí popis místnosti.
     *
     * @return popis místnosti
     */
    public String getDescription() { return description; }

    /**
     * Vrátí mapu východů z místnosti.
     *
     * @return mapa východů
     */
    public Map<String, String> getExits() { return exits; }

    /**
     * Vrátí seznam předmětů v místnosti.
     *
     * @return seznam předmětů
     */
    public List<Item> getItems() { return items; }

    /**
     * Vrátí seznam NPC postav v místnosti.
     *
     * @return seznam NPC
     */
    public List<NPC> getNpcs() { return npcs; }

    /**
     * Vrátí textový seznam předmětů v místnosti.
     *
     * @return text se seznamem předmětů
     */
    public String itemsToString() {
        if (items.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (Item it : items) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(it.getName());
        }
        return sb.toString();
    }

    /**
     * Najde nepřítele v místnosti podle jména.
     *
     * @param token část jména nepřítele
     * @return nalezený nepřítel nebo null
     */
    public Enemy findEnemy(String token) {
        String t = token.toLowerCase();
        for (Enemy e : enemies) {
            if (e.getName().toLowerCase().contains(t)) return e;
        }
        return null;
    }

    /**
     * Vrátí textový seznam NPC postav v místnosti.
     *
     * @return text se seznamem NPC
     */
    public String npcsToString() {
        if (npcs.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (NPC n : npcs) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(n.getName());
        }
        return sb.toString();
    }

    /**
     * Vrátí textový seznam nepřátel v místnosti.
     *
     * @return text se seznamem nepřátel
     */
    public String enemiesToString() {
        if (enemies.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (Enemy e : enemies) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(e.getName());
        }
        return sb.toString();
    }

    /**
     * Vrátí textový seznam východů z místnosti.
     *
     * @return seznam směrů východů
     */
    public String exitsToString() {
        return String.join(", ", exits.keySet());
    }
}